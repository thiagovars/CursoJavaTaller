CREATE DATABASE personal;

USE personal;

CREATE TABLE departamento (
	clave int(5) not null primary key AUTO_INCREMENT,
	nombre varchar(80) not null,
	presupuesto float(100,2)
);

CREATE TABLE empleado (
	clave varchar(5) not null primary key,
	nombre varchar(80) not null,
	apellido varchar(80) not null,
	departamento int(5) not null,
	FOREIGN KEY (departamento) REFERENCES departamento (clave)
);


INSERT INTO departamento (nombre, presupuesto) VALUES 
	("Almacen", 70000),
	("Contabilidad", 60000),
	("Manufactura", 50000),
	("Empaque", 30000),
	("Personal", 40000);

INSERT INTO empleado (clave, nombre, apellido, departamento) VALUES 
("EMP01", "Tatiana", "Vargas", 1),
("EMP02", "Laura", "Perez", 2),
("EMP03", "Armando", "Lopez", 3),
("EMP04", "Juan", "Perez", 4),
("EMP05", "Ivan", "Lopes", 4),
("EMP06", "Margarita", "Hernandes", 1),
("EMP07", "Jesus", "Perez", 3),
("EMP08", "Jonathan", "Flores", 2),
("EMP09", "Pablo", "Hernandes", 5),
("EMP010", "Ana", "Gonzalez", 1);

------------------------------------------ CONSULTAS ---------------------------------------------
SELECT nombre, apellido FROM empleado;

SELECT DISTINCT apellido FROM empleado;

SELECT emp.clave, emp.nombre, emp.apellido, dep.nombre FROM empleado emp
	INNER JOIN departamento dep ON emp.departamento = dep.clave
	WHERE emp.apellido LIKE "Lopez";

SELECT emp.clave, emp.nombre, emp.apellido, dep.nombre FROM empleado emp
	INNER JOIN departamento dep ON emp.departamento = dep.clave
	WHERE emp.apellido IN ("Lopez", "Perez");

SELECT emp.nombre, emp.clave FROM departamento dep
	INNER JOIN empleado emp ON emp.departamento = dep.clave
	WHERE dep.clave = 4;

SELECT emp.clave, emp.nombre, emp.apellido, dep.clave FROM departamento dep
	INNER JOIN empleado emp ON emp.departamento = dep.clave
	WHERE (dep.clave = 1) OR (dep.clave = 3)
	ORDER BY emp.nombre ASC;

SELECT nombre, apellido FROM empleado
WHERE apellido LIKE "H%";

SELECT clave, nombre, presupuesto FROM departamento
WHERE presupuesto BETWEEN 50000 AND 70000;

SELECT emp.clave, emp.nombre, emp.apellido FROM departamento dep
	INNER JOIN empleado emp ON emp.departamento = dep.clave
	WHERE dep.nombre = "Contabilidad";

SELECT emp.clave, emp.nombre, emp.apellido, dep.nombre AS departamento FROM empleado emp
	INNER JOIN departamento dep ON emp.departamento = dep.clave;