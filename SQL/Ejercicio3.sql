CREATE DATABASE BRA_cine;

USE BRA_cine;

CREATE TABLE peliculas (
	codigo int(10) not null primary key AUTO_INCREMENT,
	nombre varchar(30) not null,
	calificacion varchar(20)
);

CREATE TABLE salas (
	codigo int(5) not null primary key AUTO_INCREMENT,
	nombre varchar(30) not null,
	codPelicula int(10) not null,
	FOREIGN KEY (codPelicula) references peliculas(codigo)
);

INSERT INTO peliculas (nombre, calificacion) VALUES 
("La la land", ""),
("No Small Parts", 18),
("Drone", ""),
("El Circulo", ""),
("How to Be a Latin Lover", ""),
("Sleight", ""),
("Buster´s Mal Heart", ""),
("Shavua ve Yom", ""),
("Below Her Mouth", ""),
("Fast & Furious 8", 13),
("El Bebè Jefazo", ""),
("La Bella y la Bestia", ""),
("Born in China", ""),
("Un Golpe con Destino", 13),
("Unforgettable", 18);

INSERT INTO salas (nombre, codPelicula) VALUES
("verde", 1),
("roja", 15),
("verde", 4),
("amarilla", 10),
("verde", 5),
("verde", 6),
("roja", 2),
("verde", 7),
("verde", 11),
("amarilla", 14),
("verde", 12);

--------------------------------------- CONSULTAS ---------------------------------------
SELECT nombre FROM cine.peliculas;

SELECT DISTINCT calificacion FROM cine.peliculas;

SELECT codigo, nombre FROM cine.peliculas
	WHERE calificacion = "";

INSERT INTO salas (nombre, codPelicula) VALUES
("negro", "");
("azul", "");
("naranja", "");

SELECT codigo, nombre FROM cine.salas
	WHERE codPelicula = "";

SELECT sal.codigo, sal.nombre, pel.codigo, pel.nombre, pel.calificacion
	FROM cine.salas sal
	INNER JOIN cine.peliculas pel ON peliculas.codigo = sal.codPelicula;

SELECT pel.nombre
	FROM cine.salas sal
	INNER JOIN cine.peliculas pel ON peliculas.codigo = sal.codPelicula
	WHERE sal.codPelicula = "";

INSERT INTO peliculas (nombre, calificacion) VALUES 
("Uno, dos, tres", 7);

UPDATE peliculas SET calificacion = "no recomendable" WHERE calificacion = 13;

DELETE FROM salas WHERE codpelicula IN (SELECT codigo FROM peliculas WHERE calificacion = "");