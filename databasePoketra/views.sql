/*Vue matiere et unite*/
CREATE OR REPLACE VIEW v_matiere_unity AS SELECT m.id_matiere, m.name matiere,u.id_unity, u.name unity, 
m.status 
from matiere m 
join unity u on m.id_unity=u.id_unity; 

/*Vue pour le produit*/
CREATE OR REPLACE VIEW v_product_existance AS SELECT p.id_product, p.designation, p.description, 
s.name AS size, t.name AS type, l.name AS look, p.date_creation,p.status,p.prix_vente 
FROM product p 
JOIN size s ON p.id_size=s.id_size 
JOIN type t ON p.id_type=t.id_type 
JOIN look l ON p.id_look=l.id_look;

/*Vue pour la quantite production*/
CREATE OR REPLACE VIEW v_quantity_production AS SELECT qmp.id_quantity_matiere_production, s.id_size, 
s.name AS size, t.id_type, t.name AS type, l.id_look, l.name AS look, qmp.status, m.id_matiere,
m.name AS matiere, mq.quantity 
FROM quantity_matiere_production qmp 
JOIN matiere_quantity mq ON qmp.id_quantity_matiere_production=mq.id_quantity_matiere_production 
JOIN matiere m ON mq.id_matiere=m.id_matiere
JOIN size s ON s.id_size = qmp.id_size 
JOIN type t ON t.id_type=qmp.id_type 
JOIN look l ON l.id_look=qmp.id_look;

/*Vue pour la matiere et son prix*/
CREATE OR REPLACE VIEW v_matiere AS SELECT m.id_matiere,u.name as unity,m.name as matiere, 
COALESCE((SELECT SUM(prix_unitaire * quantite) / SUM(quantite) AS prix 
FROM entree e WHERE e.id_matiere = m.id_matiere), m.prix) AS prix,m.status FROM matiere m 
join unity u on m.id_unity=u.id_unity;

/*Vue pour le produit et la matiere produit */
CREATE OR REPLACE VIEW v_product_matiere AS SELECT p.id_product, s.id_size, s.name AS size, t.id_type,
t.name AS type, l.id_look, l.name AS look, p.designation, p.description, p.date_creation, p.status, 
p.prix_vente, m.id_matiere, m.matiere, m.unity,m.prix
FROM product p 
JOIN product_matiere pm ON p.id_product=pm.id_product
JOIN v_matiere m ON pm.id_matiere=m.id_matiere 
JOIN size s ON s.id_size=p.id_size
JOIN type t ON t.id_type=p.id_type
JOIN look l ON l.id_look=p.id_look;

/*Vue pour le produit et quantite production*/
CREATE OR REPLACE VIEW v_product_quantity_production 
AS SELECT p.id_product, q.id_quantity_matiere_production, 
q.id_size, q.size, q.id_type,q.type, q.id_look, q.look, p.designation, p.description, p.date_creation, 
q.status AS status_quantity_production, p.status AS status_product, p.id_matiere, p.matiere, 
p.unity,q.quantity, p.prix 
AS prix_unitaire_matiere, (p.prix * q.quantity) AS prix_quantite_matiere , p.prix_vente
FROM v_product_matiere p
JOIN v_quantity_production q ON p.id_matiere=q.id_matiere WHERE p.id_size=q.id_size 
AND p.id_look=q.id_look AND p.id_type=q.id_type; 

--Vue pour la duree employe et profession
CREATE OR REPLACE VIEW v_duration_production AS
SELECT d.id_duration_production, d.id_size, s.name size, d.id_type, t.name type, d.id_look, l.name look,
d.duration, d.status, d.nombre_employe, p.id_profession, p.nom profession, p.salaire, 
(p.salaire*d.duration) prix_salaire_duree
FROM duration_production d 
JOIN size s ON d.id_size=s.id_size
JOIN type t ON d.id_type=t.id_type
JOIN look l ON d.id_look=l.id_look
JOIN profession p ON d.id_profession=p.id_profession;

--Vue pour l'affichage du produit
CREATE OR REPLACE VIEW v_product AS SELECT id_product, designation, description, id_size, size, id_type,
type, id_look, look, sum(prix_quantite_matiere) as prix_product,date_creation,status_product, prix_vente
from v_product_quantity_production 
group by id_product,designation,description,id_size,size,id_type,type,id_look,look,date_creation,
status_product,prix_vente;

--Vue pour le produit avec son prix de vente et prix de revient
CREATE OR REPLACE VIEW v_product_price AS 
SELECT p.id_product, p.designation, p.description, p.id_size, p.size, p.id_type,
p.type, p.id_look, p.look, (p.prix_product + d.prix_salaire_duree) prix_revient, p.date_creation, 
p.status_product, p.prix_vente, (p.prix_vente - (p.prix_product + d.prix_salaire_duree)) benefice
FROM v_product p JOIN v_duration_production d ON p.id_size=d.id_size WHERE p.id_type=d.id_type 
AND p.id_look=d.id_look;


-- Vue pour l'affichage produit fabrique
CREATE OR REPLACE VIEW v_product_fabrique AS SELECT f.id_product_fabrique, f.id_product, p.designation, 
f.quantite, f.date_fabrication, f.etat, (f.quantite * p.prix_vente) montant, p.prix_vente
FROM product_fabrique f
JOIN v_product p ON f.id_product=p.id_product; 

CREATE
OR REPLACE FUNCTION get_stock_availability(target_date DATE)
RETURNS TABLE (
    id_article INTEGER,
    reste NUMERIC(8, 2),
    unit_price NUMERIC(10, 2),
    amount NUMERIC(10, 2)
)  AS $$
BEGIN
RETURN QUERY
SELECT end_stock.id_article,
       SUM(end_stock.reste),
        CASE 
            WHEN SUM(end_stock.reste) = 0 THEN 0
            ELSE SUM(end_stock.reste * end_stock.unit_price) / COALESCE(SUM(end_stock.reste), 1) -- Prix unitaire moyenne pondéré
        END,    
        SUM(end_stock.reste * end_stock.unit_price)
FROM get_incoming_stock(target_date) end_stock
GROUP BY end_stock.id_article;
END;
$$
LANGUAGE plpgsql;

-- Fontion pour sortir l'etat de stock grace au deux dates
CREATE 
OR REPLACE FUNCTION get_etat_stock(start_date DATE, end_date DATE)
RETURNS TABLE (
    id_matiere INTEGER,
    matiere VARCHAR(50),
    unity VARCHAR(50),
    quantite_initial DOUBLE PRECISION,
    entree DOUBLE PRECISION,
    sortie DOUBLE PRECISION,
    prix_unitaire DOUBLE PRECISION
)  AS $$
BEGIN
RETURN QUERY
SELECT 
    m.id_matiere, 
    m.matiere,
    m.unity,
    COALESCE((SELECT SUM(e.quantite) 
        FROM entree e 
        WHERE e.id_matiere=m.id_matiere 
            AND e.date_entree <= start_date),0) quantite_initial,
    COALESCE((SELECT SUM(e.quantite) 
        FROM entree e   
        WHERE e.id_matiere=m.id_matiere 
            AND e.date_entree >= start_date 
            AND e.date_entree <= end_date),0) entree, 
    COALESCE((SELECT SUM(s.quantite) 
        FROM sortie s 
        WHERE s.id_matiere=m.id_matiere 
            AND s.date_sortie >= start_date
            AND s.date_sortie <= end_date),0) sortie,
    COALESCE((SELECT SUM(e.prix_unitaire * e.quantite) / SUM(e.quantite)
        FROM entree e 
        WHERE e.id_matiere = m.id_matiere), 0) prix_unitaire
FROM v_matiere m WHERE status != 0;
END;
$$
LANGUAGE plpgsql;

--Fonction pour sortir l'etat de stock a une date donnee
CREATE 
OR REPLACE FUNCTION get_etat_stock(target_date DATE)
RETURNS TABLE (
    id_matiere INTEGER,
    matiere VARCHAR(50),
    unity VARCHAR(50),
    quantite_initial DOUBLE PRECISION,
    entree DOUBLE PRECISION,
    sortie DOUBLE PRECISION,
    prix_unitaire DOUBLE PRECISION
)  AS $$
BEGIN
RETURN QUERY
SELECT 
    m.id_matiere, 
    m.matiere,
    m.unity,
    COALESCE((SELECT SUM(e.quantite) 
        FROM entree e 
        WHERE e.id_matiere=m.id_matiere 
            AND e.date_entree <= target_date),0) quantite_initial,
    COALESCE((SELECT SUM(e.quantite) 
        FROM entree e   
        WHERE e.id_matiere=m.id_matiere 
            AND e.date_entree <= target_date),0) entree, 
    COALESCE((SELECT SUM(s.quantite) 
        FROM sortie s 
        WHERE s.id_matiere=m.id_matiere 
            AND s.date_sortie <= target_date),0) sortie,
    COALESCE((SELECT SUM(e.prix_unitaire * e.quantite) / SUM(e.quantite)
        FROM entree e 
        WHERE e.id_matiere = m.id_matiere), 0) prix_unitaire
FROM v_matiere m WHERE status != 0;
END;
$$
LANGUAGE plpgsql;

--Vue d'une promotion d'un produit
CREATE OR REPLACE VIEW v_promotion AS SELECT product.id_product, product.designation,
product.description, product.prix_vente prix_exterieur, promo.id_promotion, promo.remise, 
(product.prix_vente - (product.prix_vente * promo.remise)/100) prix_interieur, promo.date_debut,
promo.date_fin FROM promotion promo 
JOIN v_product_price product ON promo.id_product = product.id_product;

--Vue d'une fiche de facture details
CREATE OR REPLACE VIEW v_fiche_facture_details AS SELECT f.id_facture,p.designation product, fd.quantite, p.prix_vente, fd.remise,
(fd.quantite * p.prix_vente) montant, 
((fd.quantite * p.prix_vente) - ((fd.quantite * p.prix_vente) * fd.remise) / 100) montant_with_remise,
(((fd.quantite * p.prix_vente) * fd.remise) / 100) value_remise, c.nom, c.prenom
FROM facture_details fd
JOIN v_product_price p ON fd.id_product = p.id_product
JOIN facture f ON fd.id_facture=f.id_facture
JOIN client c ON f.id_client = c.id_client;

--Fiche facture grouper
CREATE OR REPLACE VIEW v_fiche_facture_grouped AS 
SELECT id_facture, sum(montant) total_facture, sum(value_remise) total_remise, 
sum(montant) - sum(value_remise) total_payer_with_remise, nom, prenom
from v_fiche_facture_details GROUP BY id_facture, nom, prenom;

--Payment d'une facture
CREATE OR REPLACE VIEW v_facture_payment AS 
SELECT id_facture, sum(montant) total_montant FROM facture_payment GROUP BY id_facture; 


--Fiche facture
CREATE OR REPLACE VIEW v_fiche_facture AS SELECT f.id_facture, f.date, ffg.total_facture, ffg.total_remise,
ffg.total_payer_with_remise, COALESCE(fp.total_montant, 0) montant_deja_payer, 
ffg.total_payer_with_remise - COALESCE(fp.total_montant, 0) reste_payer, c.nom, c.prenom
FROM facture f
LEFT JOIN v_fiche_facture_grouped ffg ON f.id_facture = ffg.id_facture
LEFT JOIN v_facture_payment fp ON f.id_facture = fp.id_facture
LEFT JOIN client c ON f.id_client = c.id_client;

--Poste grade
CREATE OR REPLACE VIEW v_poste_grade AS SELECT 
pg.id_poste_grade, p.id_poste, p.name poste, p.status status_poste, g.id_grade, g.name grade, g.niveau, 
g.status status_grade, pg.taux_horaire
FROM poste_grade pg 
LEFT JOIN poste p ON pg.id_poste = p.id_poste
LEFT JOIN grade g ON pg.id_grade = g.id_grade;

--Parametre de graduation
CREATE OR REPLACE VIEW V_param_graduation AS SELECT 
param_grad.id_param_graduation, post_grad.id_poste_grade id_poste_grade_ancien,
post_grad.id_poste id_poste_ancien, post_grad.poste poste_ancien, 
post_grad.id_grade id_grade_ancien, post_grad.grade grade_ancien, post_grad.niveau, 
post_grad.taux_horaire,
param_grad.ajour id_poste_grade_ajour, 
(SELECT pg.poste FROM v_poste_grade pg WHERE pg.id_poste_grade = param_grad.ajour) poste_ajour,
(SELECT pg.grade FROM v_poste_grade pg WHERE pg.id_poste_grade = param_grad.ajour) grade_ajour,
param_grad.duree   
FROM param_graduation param_grad
LEFT JOIN v_poste_grade post_grad ON param_grad.ancien = post_grad.id_poste_grade;

--Vue d'une employe
CREATE OR REPLACE VIEW v_employe AS SELECT emp.id_employe, emp.nom, emp.prenom, emp.date_naissance,
emp.id_poste_grade, pg.poste, pg.grade, pg.niveau, pg.taux_horaire, emp.status, emp.date_embauche
FROM employe emp 
LEFT JOIN v_poste_grade pg ON emp.id_poste_grade = pg.id_poste_grade; 


CREATE OR REPLACE VIEW v_vente_client AS SELECT 
vc.id_vente_client, vc.id_client, client.nom, client.prenom, client.id_genre, vc.quantite, vc.date,
prod.designation, prod.id_product 
FROM vente_client vc 
LEFT JOIN product prod ON vc.id_product = prod.id_product
LEFT JOIN client client ON vc.id_client = client.id_client
LEFT JOIN genre genre ON client.id_genre =genre.id_genre;

--Vue pour compter les nombres totals des clients pour chaque produit vendus
CREATE OR REPLACE VIEW v_total_client_product AS
Select id_product, count(id_client) total_client from v_vente_client group by id_product;

--Vue du nombre de client par genre grouper par produit et genre
CREATE VIEW v_number_genre_grouped AS
SELECT vvc.id_product, vvc.id_genre, vvc.designation, count(vvc.id_client) number_client,
FROM v_vente_client vvc
group by vvc.id_product, vvc.id_genre, vvc.designation;

--Statistique du vente_client par genre et par produit
    CREATE OR REPLACE VIEW v_stat_genre_product_vente AS
    SELECT vngg.id_product, vngg.id_genre, vngg.designation, vngg.number_client,
    (vngg.number_client / vtcp.total_client :: DOUBLE PRECISION) * 100 percent_number
    FROM v_number_genre_grouped vngg
    LEFT JOIN v_total_client_product vtcp ON vngg.id_product = vtcp.id_product;

--Stistique pour toutes les produits
CREATE OR REPLACE VIEW v_stat_genre_allproduct AS 
SELECT v.id_genre,SUM(v.number_client)/(SELECT SUM(vs.number_client) 
FROM v_stat_genre_product_vente vs) ::DOUBLE PRECISION * 100 percent 
FROM v_stat_genre_product_vente v GROUP BY v.id_genre;

--Etat produit fabrique
CREATE OR REPLACE VIEW v_etat_entre_fabrique AS
SELECT id_product, designation, SUM(quantite) entree, prix_vente
FROM v_product_fabrique group by id_product, designation, prix_vente;

CREATE OR REPLACE VIEW v_etat_sortie_fabrique AS 
SELECT id_product, SUM(quantite) sortie FROM vente_client GROUP BY id_product;

--Stock produit fabriques
CREATE OR REPLACE VIEW v_stock_product_fabrique AS
SELECT vef.id_product, vef.designation, vef.entree, COALESCE(vsf.sortie, 0) sortie, vef.prix_vente, 
COALESCE((vef.entree - vsf.sortie), 0) reste,
COALESCE((vef.entree - vsf.sortie) * vef.prix_vente, 0) montant
FROM v_etat_entre_fabrique vef
LEFT JOIN v_etat_sortie_fabrique vsf ON vef.id_product = vsf.id_product;
