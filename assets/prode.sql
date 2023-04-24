-- Sentencia para crear una base de datos dentro del motor de SQL
CREATE DATABASE prode;

-- Sentencia para sacar el modo UDATE SAFE de MySQL
SET SQL_SAFE_UPDATES = 0;

-- Sentencia para crear una tabla dentro de la base de datos que creamos antes
CREATE TABLE prode.personas (
id int PRIMARY KEY auto_increment,
Apellido varchar(255),
Nombre varchar(255),
Puntos int
);

-- Sentencia para insertar registros de prueba
Insert into prode.personas (apellido,Nombre,Puntos) VALUES ("Gonzalez", "Raúl", 0);
Insert into prode.personas (apellido,Nombre,Puntos) VALUES ("Gomez", "Jorge", 0);
Insert into prode.personas (apellido,Nombre,Puntos) VALUES ("Perez", "Juan", 0);
Insert into prode.personas (apellido,Nombre,Puntos) VALUES ("Lopez", "Maria", 0);
Insert into prode.personas (apellido,Nombre,Puntos) VALUES ("Soria", "Camila", 0);
Insert into prode.personas (apellido,Nombre,Puntos) VALUES ("Álvarez", "Martina", 0);
Insert into prode.personas (apellido,Nombre,Puntos) VALUES ("Perez", "Juliana", 0);
Insert into prode.personas (apellido,Nombre,Puntos) VALUES ("Don", "Remolo", 0);
-- Senetancia para validar que la tabla está creada y con los registros insertados
select * from prode.personas;

CREATE TABLE prode.pronostico (
participanteID int,
nombre varchar(255),
equipo1ID int,
gana1 varchar(1),
empata varchar(1),
gana2 varchar(1),
equipo2ID int
);

-- Insert into prode.pronostico (participanteID,equipo1ID,gana1,empata,gana2,equipo2ID) 
Insert into prode.pronostico (participanteID,equipo1ID,gana1,equipo2ID) VALUES (1,1,"X",2);
Insert into prode.pronostico  (participanteID,equipo1ID,empata,equipo2ID) VALUES (1,3,"X",4);
Insert into prode.pronostico (participanteID,equipo1ID,gana1,equipo2ID) VALUES (1,1,"X",4); 
Insert into prode.pronostico (participanteID,equipo1ID,gana2,equipo2ID) VALUES (1,2,"X",3); 
Insert into prode.pronostico (participanteID,equipo1ID,gana1,equipo2ID) VALUES (2,1,"X",2);
Insert into prode.pronostico (participanteID,equipo1ID,gana2,equipo2ID) VALUES (2,3,"X",4);
Insert into prode.pronostico (participanteID,equipo1ID,gana1,equipo2ID) VALUES (2,1,"X",4);
Insert into prode.pronostico (participanteID,equipo1ID,empata,equipo2ID) VALUES (2,2,"X",3);

Insert into prode.pronostico (participanteID,equipo1ID,gana1,equipo2ID) VALUES (3,1,"X",2);
Insert into prode.pronostico  (participanteID,equipo1ID,empata,equipo2ID) VALUES (3,3,"X",4);
Insert into prode.pronostico (participanteID,equipo1ID,gana1,equipo2ID) VALUES (3,1,"X",4); 
Insert into prode.pronostico (participanteID,equipo1ID,gana2,equipo2ID) VALUES (3,2,"X",3); 
Insert into prode.pronostico (participanteID,equipo1ID,gana1,equipo2ID) VALUES (4,1,"X",2);
Insert into prode.pronostico (participanteID,equipo1ID,gana2,equipo2ID) VALUES (4,3,"X",4);
Insert into prode.pronostico (participanteID,equipo1ID,gana1,equipo2ID) VALUES (4,1,"X",4);
Insert into prode.pronostico (participanteID,equipo1ID,empata,equipo2ID) VALUES (4,2,"X",3);

Insert into prode.pronostico (participanteID,equipo1ID,gana1,equipo2ID) VALUES (5,1,"X",2);
Insert into prode.pronostico  (participanteID,equipo1ID,empata,equipo2ID) VALUES (5,3,"X",4);
Insert into prode.pronostico (participanteID,equipo1ID,gana1,equipo2ID) VALUES (5,1,"X",4); 
Insert into prode.pronostico (participanteID,equipo1ID,gana2,equipo2ID) VALUES (5,2,"X",3); 
Insert into prode.pronostico (participanteID,equipo1ID,gana1,equipo2ID) VALUES (6,1,"X",2);
Insert into prode.pronostico (participanteID,equipo1ID,gana2,equipo2ID) VALUES (6,3,"X",4);
Insert into prode.pronostico (participanteID,equipo1ID,gana1,equipo2ID) VALUES (6,1,"X",4);
Insert into prode.pronostico (participanteID,equipo1ID,empata,equipo2ID) VALUES (6,2,"X",3);

Insert into prode.pronostico (participanteID,equipo1ID,gana2,equipo2ID) VALUES (8,1,"X",2);
Insert into prode.pronostico (participanteID,equipo1ID,empata,equipo2ID) VALUES (8,3,"X",4);
Insert into prode.pronostico (participanteID,equipo1ID,gana1,equipo2ID) VALUES (8,1,"X",4);
Insert into prode.pronostico (participanteID,equipo1ID,gana2,equipo2ID) VALUES (8,2,"X",3);
SELECT * from prode.pronostico;
