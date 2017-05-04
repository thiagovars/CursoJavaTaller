CREATE DATABASE eltaller_fechas;
USE eltaller_fechas;

CREATE TABLE persona(
	perced INT(8) PRIMARY KEY,
	perfna DATE NOT NULL,
	perfin DATE NOT NULL,
	pernom VARCHAR(25) NOT NULL
);

INSERT INTO persona 
VALUES(11111111, '1982-11-16', '2014-02-13', "Carolina"),
(12223334, '1990-05-27', '2014-02-13', "Martin"),
(23334445, '1990-01-24', '2012-05-10', "Macarena"),
(34445556, '1982-10-27', '2000-07-02', "Juan"),
(45556667, '1982-09-20', '2002-02-19', "Pedro"),
(56667778, '1970-12-27', '2010-02-28', "Martha"),
(67778889, '1955-07-27', '2009-02-28', "Fernanda");

CREATE TABLE facturas(
	facfec DATE NOT NULL,
	facven DATE NOT NULL,
	facimp DECIMAL(8,2)
);

INSERT INTO facturas 
VALUES('2016-01-10', '2016-01-25', 1500),
('2016-06-01', '2016-07-01', 1500),
('2016-10-10', '2016-12-10', 1500),
('2016-09-05', '2016-11-05', 12300),
('2015-05-18', '2015-08-18', 36700),
('2016-01-12', '2016-01-22', 15500),
('2016-01-03', '2016-01-18', 21300),
('2016-01-01', '2016-01-10', 9600),
('2016-01-20', '2016-01-20', 5400),
('2016-01-25', '2016-01-30', 8600);

-- Traigo fecha y hora actual del servidor de DB
SELECT NOW();

-- Traigo fecha actual del servidor de DB
SELECT CURDATE();

-- Traigo hora actual del servidor de DB
SELECT CURTIME();

-- Traigo fecha de nacimiento y nombre de la tabla persona utilizando alias para los campos
SELECT pernom AS 'Nombre', perfna AS 'Fecha de Nacimiento' FROM persona;

-- Con una función calculamos la edad de las persona
SELECT pernom AS 'Nombre', TIMESTAMPDIFF(YEAR,perfna,CURDATE()) AS 'Edad' FROM persona;

-- Traigo la cantidad de edades que se repiten
SELECT TIMESTAMPDIFF(YEAR,perfna,CURDATE()) AS Edad, COUNT(*) AS Cantidad
FROM persona
GROUP BY Edad;

-- Traigo las personas cuyo año de naciemiento es 1982
SELECT pernom FROM persona WHERE YEAR(perfna) = '1982';

-- Traigo las personas cuyo mes de ingreso es 02
SELECT pernom FROM persona WHERE MONTH(perfna) = '02' AND YEAR(perfna) = '1982';

-- Traigo la cantidad de días de crédito de las facturas realizando una resta entre campos
SELECT facfec AS 'Fecha emitida', facven AS 'Fecha vencimiento', (facven-facfec) AS 'Días de crédito'
FROM facturas;


