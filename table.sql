CREATE DATABASE poketra_production;

.\c poketra_production;

create sequence seq_matiere; 
create table matiere(
    id_matiere integer primary key default nextval('seq_matiere'),
    nom varchar(100)
);

create sequence seq_look; 
create table look(
id_look integer primary key default nextval('seq_look'),
nom varchar(100)

);

create sequence seq_r_matiere_look;
create table r_matiere_look(
    id_r_matiere_look integer primary key default nextval('seq_r_matiere_look'),
    id_matiere int,
    id_look int,
    status varchar(100),
    foreign key (id_look) references look(id_look),
    foreign key (id_matiere) references matiere(id_matiere)
);

insert into matiere(nom) values
    ('Cuir'),
    ('Rafia'),
    ('Soga');

insert into look (nom) values
    ('Luxe'),
    ('Normal'),
    ('debrayer');