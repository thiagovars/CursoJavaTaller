CREATE DATABASE BRA_tienda;

SHOW DATABASES;

USE BRA_tienda;

CREATE TABLE fabricantes (
	clave_fabricante int(5) not null primary key,
	nombre varchar(30)
);

CREATE TABLE articulos (
	clave_articulo int(5) not null primary key,
	nombre varchar(30) not null,
	precio int(100),
	clave_fabricante int(5) not null,
	FOREIGN KEY (clave_fabricante) references fabricantes(clave_fabricante)
);

SHOW TABLES FROM tienda;

SELECT * FROM tienda.articulos;

INSERT INTO fabricantes (clave_fabricante, nombre) VALUES
(1, "Kingston"),
(2, "Adata"),
(3, "Logitech"),
(4, "Lexar"),
(5, "Seagate");

INSERT INTO articulos (clave_articulo, nombre, precio, clave_fabricante) VALUES 
(1, "Teclado", 100, 3),
(2, "Disco duro 300 GB", 500, 5),
(3, "Mouse", 80, 3),
(4, "Memoria USB", 140, 4),
(5, "Memoria RAM", 290, 1),
(6, "Disco duro extraíble 250 GB", 650, 5),
(7, "Memoria USB", 279, 1),
(8, "DVD Rom", 450, 2),
(9, "CD Rom", 200, 2),
(10, "Tarjeta de red", 180, 3);

-------------------------- CONSULTAS --------------------------
select * from tienda.articulos;

select nombre from tienda.articulos;

select nombre, precio from tienda.articulos;

select distinct nombre from tienda.articulos;

select * from tienda.articulos 
	where clave_articulo = 5;

select * from tienda.articulos
	where nombre = "teclado";

select * from tienda.articulos
	where nombre IN ("Memoria RAM", "Memoria USB");

select * from tienda.articulos
	where nombre like "M%";

select nombre from tienda.articulos
	where precio = 100;

select nombre from tienda.articulos
	where precio = 200;

select * from tienda.articulos 
	where precio BETWEEN 100 AND 350;

select AVG(precio) FROM tienda.articulos;

select AVG(precio) FROM tienda.articulos
	where clave_fabricante = 2;

select nombre, precio FROM tienda.articulos
	ORDER BY nombre;

select * from tienda.articulos
	ORDER BY precio DESC;

select nombre, precio FROM tienda.articulos
	where precio > 250
	ORDER BY precio DESC, nombre ASC;

select art.clave_articulo, art.nombre, art.precio, fab.nombre FROM tienda.articulos art
	INNER JOIN tienda.fabricantes fab ON fab.clave_fabricante = art.clave_fabricante;

select art.clave_articulo, art.nombre, fab.nombre FROM tienda.articulos art
	INNER JOIN tienda.fabricantes fab ON fab.clave_fabricante = art.clave_fabricante;

select art.nombre, art.precio FROM tienda.articulos art
	INNER JOIN tienda.fabricantes fab ON fab.clave_fabricante = art.clave_fabricante
	WHERE fab.nombre = "Logitech"
	ORDER BY art.nombre ASC;

select art.nombre, art.precio, fab.nombre FROM tienda.articulos art
	INNER JOIN tienda.fabricantes fab ON fab.clave_fabricante = art.clave_fabricante
	WHERE fab.nombre IN ("Lexar", "Kingston")
	ORDER BY art.precio DESC;

INSERT INTO tienda.articulos (clave_articulo, nombre, precio, clave_fabricante) VALUES
(11, "Altavoces", 120, 2);

UPDATE tienda.articulos SET nombre = "Impresora Láser" WHERE clave_articulo = 6;

UPDATE tienda.articulos SET precio = precio - ((precio * 10)/100);

UPDATE tienda.articulos SET precio = precio - ((precio * 10)/100) where precio >= 300;

DELETE FROM tienda.articulos where clave_articulo = 6;