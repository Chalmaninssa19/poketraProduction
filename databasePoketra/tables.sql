create table product(
id_product integer primary key,
id_size int foreign key,
id_type int  foreign key,
id_look int foreign key,
duration double,
designation varchar(100),
description varchar(100),
picture varchar(500),
date_creation date,
status int
);

create table matiere_quantity(
id_matiere_quantity integer primary key,
id_matiere int foreign key,
quantity double,
id_product int
);

create table matiere(
id_matiere integer primary key,
id_unity int foreign key,
designation varchar(100)
);

create table unity(
id_unity integer primary key,
designation varchar(20)
);

create table size(
id_size integer primary key,
name varchar(50)
);

create table type(
id_type integer primary key,
name varchar(20)
);

create table look(
id_look integer primary key,
name varchar(50)
);

create table look_matiere(
id_look_matiere integer primary key,
id_look int foreign key,
id_matiere int foreign key,
status int
);