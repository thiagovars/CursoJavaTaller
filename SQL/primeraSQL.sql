CREATE DATABASE bra_prueba;

USE bra_prueba;

CREATE TABLE paises(
	codPais int(2) primary key AUTO_INCREMENT,
	nombrePais varchar(25) not null
);

CREATE TABLE localidades(
	codLoc int(3) primary key AUTO_INCREMENT,
	nombreLoc varchar(25) not null,
	codPais int(2) not null,
	FOREIGN KEY (codPais) references paises(codPais)
);

INSERT INTO paises (nombrePais)
VALUES ("Uruguay"), ("Brasil");

INSERT INTO localidades (nombreLoc, codPais) VALUES
("Montevideo", 1), 
("San Pablo", 2), 
("Salto", 1), 
("Rio de Janeiro", 2), 
("Porto Alegre", 2), 
("Canelones", 1), 
("Rocha", 1);

UPDATE localidades SET nombreLoc = "São Paulo" WHERE nombreLoc = "San Pablo";

INSERT INTO paises (nombrePais)
VALUES ("ARGENTINA"), ("ITALIA"), ("MEXICO");

INSERT INTO localidades (nombreLoc, codPais) VALUES
("Buenos Aires", 3),
("Palermo", 4),
("Guatemala", 5),
("Colonia del Sacramento", 1);