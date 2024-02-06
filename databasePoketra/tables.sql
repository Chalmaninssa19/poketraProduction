CREATE DATABASE poketra_production;
.\c poketra_production;

CREATE SEQUENCE seq_size;
CREATE TABLE size(
    id_size integer primary key default nextval('seq_size'),
    name VARCHAR(50),
    status int
);

CREATE SEQUENCE seq_type;
CREATE TABLE type(
    id_type integer primary key default nextval('seq_type'),
    name VARCHAR(50),
    status int
);

CREATE SEQUENCE seq_look;
CREATE TABLE look(
    id_look integer primary key default nextval('seq_look'),
    name VARCHAR(50),
    status int
);

CREATE SEQUENCE seq_product; 
CREATE TABLE product(
    id_product integer primary key default nextval('seq_product'),
    id_size int,
    id_type int,
    id_look int,
    designation varchar(100),
    description varchar(500),
    date_creation date,
    status int,
    prix_vente DOUBLE PRECISION,
    FOREIGN KEY(id_size) REFERENCES size(id_size),
    FOREIGN KEY(id_type) REFERENCES type(id_type),
    FOREIGN KEY(id_look) REFERENCES look(id_look)
);

CREATE TABLE product_matiere (
    id_product INTEGER,
    id_matiere INTEGER,
    FOREIGN KEY(id_product) REFERENCES product(id_product),
    FOREIGN KEY(id_matiere) REFERENCES matiere(id_matiere)
);

CREATE SEQUENCE seq_unity; 
CREATE TABLE unity(
    id_unity integer primary key default nextval('seq_unity'),
    name varchar(20),
    status int
);

CREATE SEQUENCE seq_matiere; 
CREATE TABLE matiere(
    id_matiere integer primary key default nextval('seq_matiere'),
    id_unity int,
    name varchar(100),
    status int,
    FOREIGN KEY(id_unity) REFERENCES unity(id_unity)
);

CREATE SEQUENCE seq_quantity_matiere_production;
CREATE TABLE quantity_matiere_production (
    id_quantity_matiere_production integer primary key default nextval('seq_quantity_matiere_production'),
    id_size int,
    id_type int,
    id_look int,
    status int,
    FOREIGN KEY(id_look) REFERENCES look(id_look),
    FOREIGN KEY(id_type) REFERENCES type(id_type),
    FOREIGN KEY(id_size) REFERENCES size(id_size)
);

CREATE SEQUENCE seq_matiere_quantity; 
CREATE TABLE matiere_quantity(
    id_matiere_quantity integer primary key default nextval('seq_matiere_quantity'),
    id_matiere int,
    id_quantity_matiere_production int,
    quantity DOUBLE PRECISION,
    FOREIGN KEY(id_matiere) REFERENCES matiere(id_matiere),
    FOREIGN KEY(id_quantity_matiere_production) REFERENCES quantity_matiere_production(id_quantity_matiere_production) 
);

CREATE SEQUENCE seq_look_matiere; 
CREATE TABLE look_matiere(
    id_look_matiere integer primary key default nextval('seq_look_matiere'),
    id_look int,
    id_matiere int,
    status int,
    FOREIGN KEY(id_look) REFERENCES look(id_look),
    FOREIGN KEY(id_matiere) REFERENCES matiere(id_matiere)
);


CREATE SEQUENCE seq_duration_production; 
CREATE TABLE duration_production(
    id_duration_production integer primary key default nextval('seq_duration_production'),
    id_size int,
    id_type int,
    id_look int,
    duration DOUBLE PRECISION,
    status int,
    id_profession int,
    nombre_employe int,
    FOREIGN KEY(id_look) REFERENCES look(id_look),
    FOREIGN KEY(id_type) REFERENCES type(id_type),
    FOREIGN KEY(id_size) REFERENCES size(id_size),
    FOREIGN KEY(id_profession) REFERENCES profession(id_profession)
);


create sequence seq_entree;
CREATE TABLE entree(
    id_entree INTEGER PRIMARY KEY default nextval('seq_entree'),
    id_matiere INTEGER,
    prix_unitaire double precision,
    quantite double precision,
    date_entree date,
    etat INTEGER,
    FOREIGN KEY (id_matiere) REFERENCES matiere(id_matiere)
);

CREATE SEQUENCE seq_sortie;
CREATE TABLE sortie (
    id_sortie INTEGER PRIMARY KEY default nextval('seq_entree'),
    id_matiere INTEGER,
    quantite DOUBLE PRECISION,
    date_sortie DATE,
    etat INTEGER,
    FOREIGN KEY (id_matiere) REFERENCES matiere(id_matiere) 
);

create sequence seq_product_fabrique;
CREATE TABLE product_fabrique(
    id_product_fabrique INTEGER PRIMARY KEY default nextval('seq_product_fabrique'),
    id_product INTEGER,
    quantite double precision,
    date_fabrication DATE,
    etat INTEGER,
    FOREIGN KEY (id_product) REFERENCES product(id_product)
);

create sequence seq_poste;
CREATE TABLE poste(
    id_poste INTEGER PRIMARY KEY default nextval('seq_poste'),
    name VARCHAR(20),
    status INTEGER
);

create sequence seq_grade;
CREATE TABLE grade(
    id_grade INTEGER PRIMARY KEY default nextval('seq_grade'),
    name VARCHAR(20),
    niveau INTEGER,
    status INTEGER
);

create sequence seq_poste_grade;
CREATE TABLE poste_grade(
    id_poste_grade INTEGER PRIMARY KEY default nextval('seq_poste_grade'),
    id_poste INTEGER REFERENCES poste(id_poste),
    id_grade INTEGER REFERENCES grade(id_grade),
    taux_horaire DOUBLE PRECISION
);

create sequence seq_param_graduation;
CREATE TABLE param_graduation(
    id_param_graduation INTEGER PRIMARY KEY default nextval('seq_param_graduation'),
    ancien INTEGER REFERENCES poste_grade(id_poste_grade),
    ajour INTEGER REFERENCES poste_grade(id_poste_grade),
    duree INTEGER
);

create sequence seq_employe;
CREATE TABLE employe(
    id_employe INTEGER PRIMARY KEY default nextval('seq_employe'),
    nom VARCHAR(100),
    prenom VARCHAR(100),
    date_naissance date,
    id_poste_grade INTEGER REFERENCES poste_grade(id_poste_grade),
    status INTEGER,
    date_embauche DATE
);

CREATE SEQUENCE seq_promotion;
CREATE TABLE promotion (
    id_employe INTEGER PRIMARY KEY default nextval('seq_employe'),
    id_product INTEGER REFERENCES product(id_product),
    date_debut DATE,
    date_fin DATE,
    remise DOUBLE PRECISION
);

CREATE SEQUENCE seq_genre;
CREATE TABLE genre (
    id_genre INTEGER PRIMARY KEY default nextval('seq_genre'),
    genre VARCHAR(20)
);

CREATE SEQUENCE seq_client;
CREATE TABLE client(
    id_client INTEGER PRIMARY KEY default nextval('seq_client'),
    nom VARCHAR(50),
    prenom VARCHAR(50),
    date_naissance DATE,
    email VARCHAR(100),
    id_genre INTEGER REFERENCES genre(id_genre)
);

CREATE SEQUENCE seq_facture;
CREATE TABLE facture (
    id_facture INTEGER PRIMARY KEY default nextval('seq_facture'),
    date DATE,
    status INTEGER,
    id_client INTEGER REFERENCES client(id_client)
);

CREATE TABLE facture_details(
    id_facture INTEGER REFERENCES facture(id_facture),
    id_product INTEGER REFERENCES product(id_product),
    quantite DOUBLE PRECISION,
    remise DOUBLE PRECISION
);

CREATE SEQUENCE seq_facture_payment;
CREATE TABLE facture_payment (
    id_facture_payment INTEGER PRIMARY KEY default nextval('seq_facture_payment'),
    id_facture INTEGER REFERENCES facture(id_facture),
    date DATE,
    montant DOUBLE PRECISION
);

create sequence seq_regle_graduation;
CREATE TABLE regle_graduation (
id_regle_graduation INTEGER PRIMARY KEY default nextval('seq_regle_graduation'),
id_profession_ancien INTEGER REFERENCES profession(id_profession),
id_profession_actuel INTEGER REFERENCES profession(id_profession),
duree_annee_min INTEGER,
duree_annee_max INTEGER,
status INTEGER
);

create sequence seq_vente_client;
CREATE TABLE vente_client(
    id_vente_client INTEGER primary key default nextval('seq_vente_client'),
    id_client INTEGER references client(id_client),
    id_product INTEGER references product(id_product),
    quantite DOUBLE PRECISION,
    date DATE
);