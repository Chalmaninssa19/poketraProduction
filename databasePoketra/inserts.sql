INSERT INTO size VALUES
(1, 'Petit'),
(2, 'Moyen'),
(3, 'Grand'),
(4, 'XL'),
(5, 'XXL');

INSERT INTO type VALUES
(1, 'Sac a dos'),
(2, 'Sac fourre-tout'),
(3, 'Sac messager'),
(4, 'Cartable'),
(5, 'Pochette');

INSERT INTO look VALUES
(1, 'Decontracte'),
(2, 'Formel'),
(3, 'Sportif'),
(4, 'Vintage'),
(5, 'Boho');

INSERT INTO unity VALUES
(1, 'Piece'),
(2, 'Kilogramme'),
(3, 'Metre');

INSERT INTO matiere VALUES
(1, 1, 'Cuir'),
(2, 1, 'Toile'),
(3, 2, 'Metal'),
(4, 3, 'Coton'),
(5, 2, 'Polyester');

INSERT INTO product VALUES
(1, 2, 1, 3, 15.5, 'Sac a dos classique', 'Un sac polyvalent pour un usage quotidien', 'sac_classique.jpg', '2023-01-15', 1),
(2, 3, 4, 2, 20.0, 'Cartable vintage', 'Un cartable elegant avec une touche vintage', 'cartable_vintage.jpg', '2023-02-20', 1),
(3, 1, 2, 1, 12.5, 'Sac fourre-tout sportif', 'Ideal pour les activites sportives avec un design spacieux', 'sac_sportif.jpg', '2023-03-10', 1),
(4, 4, 5, 4, 18.0, 'Pochette boho', 'Une pochette a la mode inspiree du style boheme pour des occasions speciales', 'pochette_boho.jpg', '2023-04-05', 1),
(5, 2, 3, 5, 14.5, 'Sac messager', 'Parfait pour transporter l essentiel en deplacement', 'sac_messager.jpg', '2023-05-15', 1);

INSERT INTO look_matiere VALUES
(1, 1, 1, 1),
(2, 2, 2, 1),
(3, 3, 3, 1),
(4, 4, 4, 1),
(5, 5, 5, 1);

INSERT INTO matiere_quantity VALUES
(1, 1, 2.5, 1),
(2, 2, 3.0, 2),
(3, 3, 1.8, 3),
(4, 4, 2.2, 4),
(5, 5, 2.0, 5);

create sequence seq_regle_graduation;
CREATE TABLE regle_graduation (
id_regle_graduation INTEGER PRIMARY KEY default nextval('seq_regle_graduation'),
id_profession_ancien INTEGER REFERENCES profession(id_profession),
id_profession_actuel INTEGER REFERENCES profession(id_profession),
duree_annee_min INTEGER,
duree_annee_max INTEGER
);

INSERT INTO regle_graduation(id_profession_ancien, id_profession_actuel, duree_annee_min, duree_annee_max)
 VALUES
(6, 6, 0, 2),
(6, 7, 2, 3),
(7, 8, 3, 10),
(9, 10, 2, 3),
(10, 11, 3, 10);

INSERT INTO genre(genre)
VALUES
('Homme'),
('Femme');

INSERT INTO client(nom, prenom, date_naissance, email, id_genre) 
VALUES
('Rakoto', 'Jean', '2000-05-23', 'rakotoJean@gmail.com', 1),
('Ravao', 'Eva', '2003-10-02', 'ravaoBehara@gmail.com', 2),
('Rameva', 'Justin', '1997-03-10', 'ramevaJustin@gmail.com', 1),
('Rajao', 'Hanitra', '19999-08-15', 'rajaoHanitra@gmail.com', 2);