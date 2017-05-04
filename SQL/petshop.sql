CREATE DATABASE BRA_CANINA;

USE BRA_CANINA;

CREATE TABLE RAZA (
	codRaza int(5) not null primary key AUTO_INCREMENT,
	nombre  varchar(80) not null,
	porte   varchar(80) not null,
	pelaje  varchar(5) not null
);

CREATE TABLE SERVICIOS (
	codServicio int(5) not null primary key AUTO_INCREMENT,
	nombre      varchar(20) not null,
	precio      float(10) not null,
	pelaje      varchar(5) not null,
	porte       varchar(6) not null,
	tiempo      time
);

CREATE TABLE CLIENTE (
	codCliente int(5) not null primary key AUTO_INCREMENT,
	nombre     varchar(100) not null,
	fechaRegistro date not null
);

CREATE TABLE BARRIOS (
	codBarrio int(5) not null primary key AUTO_INCREMENT,
	nombre    varchar(100) not null,
	zona      varchar(80)
);

CREATE TABLE EMPLEADO (
	codEmp int(5) not null primary key AUTO_INCREMENT,
	nombre varchar(80) not null,
	fechaIngreso datetime not null
);

CREATE TABLE COCHE (
	codCoche int(5) not null primary key AUTO_INCREMENT,
	matricula varchar(7) not null
);

CREATE TABLE MASCOTA (
	codMascota int(5) not null primary key AUTO_INCREMENT,
	nombre varchar(80) not null,
	raza int(5) not null,
	foreign key (raza) references RAZA(codRaza)
);

CREATE TABLE AGENDA (
	codAgenda int(5) not null primary key AUTO_INCREMENT,
	fecha datetime not null,
	cliente int(5) not null,
	servicio int(5) not null,
	foreign key (cliente) references CLIENTE(codCliente),
	foreign key (servicio) references SERVICIOS(codServicio)
);

CREATE TABLE REL_DIR_BAR_CLI (
	codDireccion int(5) not null primary key AUTO_INCREMENT,
	numPuerta    int(10) not null,
	barrio       int(5) not null,
	cliente      int(5) not null,
	foreign key (barrio) references BARRIOS(codBarrio),
	foreign key (cliente) references CLIENTE(codCliente)
);

CREATE TABLE REL_CLI_EMP_TELEFONO (
	codTelefono int(5) not null primary key	AUTO_INCREMENT,
	numero varchar(9) not null,
	cliente int(5),
	empleado int(5),
	foreign key (cliente) references CLIENTE(codCliente),
	foreign key (empleado) references EMPLEADO(codEmp)
);

CREATE TABLE REL_MASCOTA_CLIENTE (
	cliente int(5) not null,
	mascota int(5) not null,
	foreign key (cliente) references CLIENTE(codCliente),
	foreign key (mascota) references MASCOTA(codmascota),
	primary key (cliente, mascota)
);

CREATE TABLE REL_COCH_AGD_EMP (
	codCocheAgdEmp int(5) not null AUTO_INCREMENT,
	coche int(5) not null,
	empleado1 int(5),
	empleado2 int(5),
	agenda int(5),
	foreign key (coche) references COCHE(codCoche),
	foreign key (empleado1) references EMPLEADO(codEmp),
	foreign key (empleado2) references EMPLEADO(codEmp),
	foreign key (agenda) references AGENDA(codAgenda),
	primary key (codCocheAgdEmp, empleado1, empleado2, agenda)
);

/* INSERTS */
INSERT INTO COCHE (matricula) VALUES 
('ABE7844'),
('PER6866');

INSERT INTO BARRIOS (nombre, zona) VALUES 
('Bella Vista'           , 'ZONA 1'),
('Jaciento Vera'         , 'ZONA 1'),
('Goes'                  , 'ZONA 1'),
('La Comercial'          , 'ZONA 1'),
('Aguada'                , 'ZONA 1'),
('Centro'                , 'ZONA 1'),
('Ciudad Vieja'          , 'ZONA 1'),
('Cordón'                , 'ZONA 1'),
('Barrio Sur'            , 'ZONA 1'),
('La Teja'               , 'ZONA 2'),
('Belvedere'             , 'ZONA 2'),
('Capurro'               , 'ZONA 2'),
('Atahualpa'             , 'ZONA 2'),
('Brazo Oriental'        , 'ZONA 2'),
('Aires Puros'           , 'ZONA 2'),
('Bolivar'               , 'ZONA 2'),
('La Blanqueda'          , 'ZONA 2'),
('Buceo'                 , 'ZONA 2'),
('Cerrito de la Victoria', 'ZONA 2'),
('Colón'                 , 'ZONA 3 A'),
('Abayubá'               , 'ZONA 3 A'),
('Casavalle'             , 'ZONA 3 A'),
('Carrasco'              , 'ZONA 3 B'),
('Malvín'                , 'ZONA 3 B'),
('Malvín Norte'          , 'ZONA 3 B');

INSERT INTO RAZA (nombre, porte, pelaje) VALUES 
('Afgano',            'GRANDE', 'LARGO'),
('Akita',             'GRANDE', 'CORTO'),
('American Stafford', 'GRANDE', 'CORTO'),
('Pitbull',           'GRANDE', 'CORTO'),
('Basset Hound',      'CHICO',  'CORTO'),
('Beagle',            'CHICO',  'CORTO'),
('Bichón Frisé',      'CHICO',  'CORTO'),
('Maltés',            'CHICO',  'CORTO'),
('Boxer',             'GRANDE', 'CORTO'),
('Boyero de Flandes', 'GRANDE', 'CORTO'),
('Braco Alemán',      'GRANDE', 'CORTO'),
('Bull Terrier',      'GRANDE', 'CORTO'),
('Bulldog Frances',   'CHICO',  'CORTO'),
('Caniche',           'GRANDE', 'CORTO'),
('Carlino',           'CHICO',  'CORTO'),
('Chihuahua',         'CHICO',  'CORTO'),
('Chow Chow',         'GRANDE', 'LARGO'),
('Cocker Spaniel',    'CHICO',  'CORTO'),
('Collie',            'GRANDE', 'LARGO'),
('Corgi',             'CHICO',  'CORTO'),
('Dálmata',           'GRANDE', 'CORTO'),
('Doberman',          'GRANDE', 'CORTO'),
('Dogo Argentino',    'GRANDE', 'CORTO'),
('Fila',              'GRANDE', 'CORTO');

INSERT INTO SERVICIOS (nombre, precio, pelaje, porte) VALUES
('Baño', 300, 'CORTO',                 'CHICO'),
('Baño', 350, 'LARGO',                 'CHICO'),
('Baño', 450, 'CORTO',                 'GRANDE'),
('Baño', 550, 'LARGO',                 'GRANDE'),
('Corte (esquila)', 300, 'CORTO',      'CHICO'),
('Corte (esquila)', 350, 'LARGO',      'CHICO'),
('Corte (esquila)', 450, 'CORTO',      'GRANDE'),
('Corte (esquila)', 550, 'LARGO',      'GRANDE'),
('Corte y Baño', 500, 'CORTO',         'CHICO'),
('Corte y Baño', 600, 'LARGO',         'CHICO'),
('Corte y Baño', 800, 'CORTO',         'GRANDE'),
('Corte y Baño', 900, 'LARGO',         'GRANDE'),
('Recortes', 150, 'CORTO',             'CHICO'),
('Recortes', 150, 'LARGO',             'CHICO'),
('Recortes', 150, 'CORTO',             'GRANDE'),
('Recortes', 150, 'LARGO',             'GRANDE'),
('Baño y Recortes', 400, 'CORTO',      'CHICO'),
('Baño y Recortes', 500, 'LARGO',      'CHICO'),
('Baño y Recortes', 650, 'CORTO',      'GRANDE'),
('Baño y Recortes', 750, 'LARGO',      'GRANDE'),
('Baño antiparacitario', 300, 'CORTO', 'CHICO'),
('Baño antiparacitario', 350, 'LARGO', 'CHICO'),
('Baño antiparacitario', 450, 'CORTO', 'GRANDE'),
('Baño antiparacitario', 550, 'LARGO', 'GRANDE');

INSERT INTO CLIENTE (nombre) VALUES 
('Familia Gerali'),
('Pedro y Mariana'),
('Castro'),
('Familia Bouza'),
('Familia Taranto'),
('Edgar Vivar'),
('Lopez Mena'),
('Isaac Mejlovitz'),
('Castro y Silveira'),
("D'Arengber"),
("Patricia Damiani"),
("Julia Cardozo"),
("Maria Lecueder"),
("Nelson y Jacira Alvarez"),
("Leticia Weiss"),
("Mariana Jourdan"),
("Nestor Rosemblum"),
("Fabian Suárez"),
("Mario Macri"),
("Ana Ribeiro"),
("María Noel Ache"),
("Teresa Aishemberg"),
("Azucena Arbeleche"),
("Selva Andreoli");

INSERT INTO MASCOTA (nombre, raza) VALUES
('Lola', 19),
('Tsuki', 2),
('Toti', 1),
('Tito', 3),
('Lobo', 4),
('Toto', 5),
('Simba', 6),
('Koki', 7),
('Napoleón', 8),
('Orejas', 9),
('Sigmund', 10),
('Trufa', 11),
('Marvel', 12),
('Marley', 13),
('Peluche', 14),
('Alen', 15),
('Sisi', 16),
('Anita', 17),
('Nina', 18),
('Arwen', 20),
('Luna', 21),
('Ada', 22),
('Buda', 23),
('Sol', 24);

INSERT INTO REL_MASCOTA_CLIENTE (cliente, mascota) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17),
(18, 18),
(19, 19),
(20, 20),
(21, 21),
(22, 22),
(23, 23),
(24, 24);

INSERT INTO TELEFONO (numero, cliente) VALUES
('093376718', 2),
('094155066', 2),
('094548889', 1),
('092123456', 4),
('094778887', 4),
('094778890', 5),
('094111222', 6),
('093666333', 7),
('093543112', 7),
('099123456', 8),
('094788274', 9),
('095733768', 9),
('093556454', 9),
('092222444', 10),
('091160588', 11),
('094270184', 11),
('096338884', 12),
('099040517', 12),
('091111333', 13),
('090190458', 14),
('090193460', 14),
('094777999', 15),
('094000111', 16),
('094555666', 17),
('092789789', 18),
('091141545', 19),
('094720248', 20),
('094720249', 20),
('094722249', 21),
('094722280', 21),
('094581184', 22),
('092581184', 23),
('093560185', 24),
('093560200', 24);

INSERT INTO EMPLEADO (nombre, fechaIngreso) VALUES 
('Mario Tetto', "2015-03-02"),
('Rosa Lopez', "2015-02-20"),
('Pamela Alvez', "2015-02-02"),
('Pablo Nuñez', "2015-07-23");

INSERT INTO TELEFONO (numero, empleado) VALUES
('098889998', 1),
('094315415', 2),
('099481418', 3),
('091456654', 4);

INSERT INTO DIRECCION (numPuerta, barrio, cliente) VALUES 
('3054', 1, 4),
('125',  2, 3),
('7801', 3, 5),
('1195', 4, 7),
('105',  5, 6),
('6659', 6, 8),
('4581', 7, 9),
('1546', 8, 10),
('889',  9, 11),
('1012', 10, 12),
('2525', 10, 13),
('1846', 10, 14),
('9796', 10, 15),
('9494', 10, 16),
('6684', 15, 17),
('666',  16, 18),
('1516', 17, 19),
('4011', 18, 20),
('4368', 19, 1),
('8488', 20, 22),
('8787', 21, 23),
('9491', 22, 24),
('5066', 23, 21),
('4366', 24, 2);

INSERT INTO AGENDA (fecha, cliente, servicio) VALUES
('2015-08-01 08:00:00', 20, 21),
('2015-08-01 08:00:00', 4, 16),
('2015-08-01 08:00:00', 2, 19),
('2015-08-01 08:00:00', 8, 9),
('2015-08-01 08:00:00', 18, 4),
('2015-08-01 08:00:00', 11, 15),
('2015-08-01 08:00:00', 7, 21),
('2015-08-01 08:00:00', 16, 13),
('2015-08-01 08:00:00', 1, 4),
('2016-02-01 08:00:00', 18, 4),
('2016-02-01 08:00:00', 2, 19),
('2016-02-01 08:00:00', 3, 16),
('2016-02-01 08:00:00', 4, 11),
('2016-02-01 08:00:00', 5, 15),
('2016-02-01 08:00:00', 6, 17),
('2016-02-01 08:00:00', 7, 5),
('2016-02-01 08:00:00', 8, 5),
('2016-02-01 08:00:00', 9, 5),
('2016-02-01 08:00:00', 10, 7),
('2016-02-01 08:00:00', 11, 7),
('2016-02-01 08:00:00', 12, 7),
('2016-02-01 08:00:00', 13, 7),
('2016-02-01 08:00:00', 14, 5),
('2016-02-01 08:00:00', 15, 19),
('2016-02-01 08:00:00', 16, 5),
('2016-04-01 08:00:00', 17, 5),
('2016-04-01 08:00:00', 18, 5),
('2016-04-01 08:00:00', 19, 5),
('2016-04-01 08:00:00', 20, 5),
('2016-04-01 08:00:00', 21, 5),
('2016-04-01 08:00:00', 22, 5),
('2016-04-01 08:00:00', 23, 5),
('2016-04-01 08:00:00', 24, 5),
('2016-05-01 08:00:00', 18, 4),
('2016-05-01 08:00:00', 2, 19),
('2016-05-01 08:00:00', 3, 16),
('2016-05-01 08:00:00', 4, 11),
('2016-05-01 08:00:00', 5, 15),
('2016-05-01 08:00:00', 6, 17),
('2016-05-01 08:00:00', 7, 5),
('2016-05-01 08:00:00', 8, 5),
('2016-05-01 08:00:00', 9, 5),
('2016-05-01 08:00:00', 10, 7),
('2016-05-01 08:00:00', 11, 7),
('2016-05-01 08:00:00', 12, 7),
('2016-05-01 08:00:00', 13, 7),
('2016-05-01 08:00:00', 14, 5),
('2016-05-01 08:00:00', 15, 19),
('2016-05-01 08:00:00', 16, 5),
('2016-05-01 08:00:00', 17, 5),
('2016-05-01 08:00:00', 18, 5),
('2016-05-01 08:00:00', 19, 5),
('2016-05-01 08:00:00', 20, 5),
('2016-05-01 08:00:00', 21, 5),
('2016-05-01 08:00:00', 22, 5),
('2016-05-01 08:00:00', 23, 5),
('2016-05-01 08:00:00', 24, 5),
('2017-05-01 08:00:00', 1, 5),
('2017-05-01 08:00:00', 12, 3),
('2017-05-01 08:00:00', 5, 23),
('2017-05-01 08:00:00', 1, 8),
('2017-05-01 08:00:00', 1, 8),
('2017-05-01 08:00:00', 1, 8),
('2017-05-01 08:00:00', 1, 8),
('2017-05-01 08:00:00', 1, 8),
('2017-05-02 08:00:00', 7, 9),
('2017-05-02 08:00:00', 7, 9),
('2017-05-02 08:00:00', 7, 9),
('2017-05-02 08:00:00', 7, 9),
('2017-05-02 08:00:00', 7, 9),
('2017-05-02 08:00:00', 23, 23),
('2017-05-02 08:00:00', 18, 20),
('2017-05-02 08:00:00', 15, 15);

INSERT INTO RELCOCHEAGDEMP (COCHE, EMPLEADO1, EMPLEADO2, AGENDA) VALUES
(1, 1, 2, 1),
(2, 3, 4, 2),
(1, 1, 2, 3),
(2, 3, 4, 4),
(1, 1, 2, 5),
(1, 1, 2, 6),
(2, 3, 4, 7),
(2, 3, 4, 9),
(1, 1, 2, 10),
(2, 3, 4, 11),
(1, 1, 2, 12),
(2, 3, 4, 13),
(1, 1, 2, 14),
(1, 1, 2, 15),
(2, 3, 4, 16),
(2, 3, 4, 17),
(2, 3, 4, 18),
(2, 3, 4, 19),
(2, 3, 4, 20),
(1, 1, 2, 21),
(2, 3, 4, 22),
(1, 1, 2, 23),
(2, 3, 4, 24),
(1, 1, 2, 25),
(1, 1, 2, 26),
(2, 3, 4, 27),
(2, 3, 4, 29),
(1, 1, 2, 30),
(2, 3, 4, 31),
(1, 1, 2, 32),
(2, 3, 4, 33),
(1, 1, 2, 34),
(1, 1, 2, 35),
(2, 3, 4, 36),
(2, 3, 4, 37),
(2, 3, 4, 38),
(2, 3, 4, 39),
(2, 3, 4, 40),
(1, 1, 2, 41),
(2, 3, 4, 42),
(1, 1, 2, 43),
(2, 3, 4, 44),
(1, 1, 2, 45),
(1, 1, 2, 46),
(2, 3, 4, 47),
(2, 3, 4, 49),
(1, 1, 2, 50),
(2, 3, 4, 51),
(1, 1, 2, 52),
(2, 3, 4, 53),
(1, 1, 2, 54),
(1, 1, 2, 55),
(2, 3, 4, 56),
(2, 3, 4, 57),
(2, 3, 4, 58),
(2, 3, 4, 59),
(2, 3, 4, 60),
(1, 1, 2, 61),
(2, 3, 4, 62),
(1, 1, 2, 63),
(2, 3, 4, 64),
(1, 1, 2, 65),
(1, 1, 2, 66),
(2, 3, 4, 67),
(2, 3, 4, 69),
(1, 1, 2, 70),
(2, 3, 4, 71),
(1, 1, 2, 72),
(2, 3, 4, 73);

------- SELECT PARTICULARES -------
SELECT MASCOTA.NOMBRE AS MASCOTA,
       RAZA.NOMBRE AS RAZA,
       RAZA.PELAJE AS PELAJE,
       RAZA.PORTE AS PORTE,
       CLIENTE.NOMBRE AS CLIENTE,
       CLIENTE.CODCLIENTE AS CODCLIENTE 
  FROM mascota as mascota
INNER JOIN RAZA RAZA ON RAZA.codRaza = mascota.raza
INNER JOIN CLIENTE CLIENTE ON CLIENTE.CODCLIENTE = MASCOTA.CLIENTE

union all

SELECT * FROM SERVICIOS;

SELECT BARRIO.ZONA,
       BARRIO.NOMBRE,
       DIRECCION.NUMPUERTA,
       AGENDA.CODAGENDA
  FROM BARRIOS AS BARRIO
INNER JOIN DIRECCION DIRECCION ON DIRECCION.BARRIO = BARRIO.codBarrio
INNER JOIN CLIENTE CLIENTE ON CLIENTE.CODCLIENTE = DIRECCION.CLIENTE
INNER JOIN AGENDA AGENDA ON AGENDA.CLIENTE = CLIENTE.CODCLIENTE;

SELECT SUM(SERVICIO.PRECIO) FROM AGENDA AGENDA
INNER JOIN SERVICIOS SERVICIO ON SERVICIO.CODSERVICIO = AGENDA.SERVICIO;

SELECT SUM(SERVICIO.PRECIO) FROM AGENDA AGENDA
INNER JOIN SERVICIOS SERVICIO ON SERVICIO.CODSERVICIO = AGENDA.SERVICIO
INNER JOIN RELCOCHEAGDEMP COCHEAGENDA ON COCHEAGENDA.AGENDA = AGENDA.CODAGENDA
INNER JOIN COCHE COCHE ON COCHE.CODCOCHE = COCHEAGENDA.COCHE
GROUP BY CHOCHE.CODCOCHE;

SELECT SUM(SALARIO) FROM EMPLEADO;

-------------------------------- ENCUESTA -------------------------------- 
SELECT COUNT(*) AS CANTIDAD_COCHE FROM COCHE;

SELECT EMP.NOMBRE, EMP.fechaIngreso, TIMESTAMPDIFF(YEAR, EMP.fechaIngreso, CURDATE()) AS "ANTIGÜEDAD" FROM EMPLEADO EMP;

SELECT BARRIOS.NOMBRE FROM BARRIOS BARRIOS ORDER BY NOMBRE ASC;

SELECT COUNT(*) AS "CANTIDAD BARRIOS" FROM BARRIOS;

SELECT COUNT(*) AS "CANTIDAD CLIENTES REGISTRADOS" FROM CLIENTE;

SELECT count(cli.codcliente) as "Clientes", BAR.NOMBRE FROM CLIENTE CLI
INNER JOIN DIRECCION DIR ON DIR.CLIENTE = CLI.codCliente
INNER JOIN BARRIOS BAR ON BAR.codBarrio = DIR.BARRIO
GROUP BY BAR.CODBARRIO ORDER BY clientes, bar.nombre ASC;

SELECT CLI.NOMBRE, COUNT(AGD.CODAGENDA) AS "NUMERO_ATENDIMENTOS" FROM AGENDA AGD
INNER JOIN CLIENTE CLI ON CLI.CODCLIENTE = AGD.CLIENTE
GROUP BY CLI.CODCLIENTE ORDER BY "NUMERO_ATENDIMENTO" DESC;

SELECT CLI.NOMBRE, CLI.FECHAREGISTRO FROM CLIENTE CLI
INNER JOIN AGENDA AGD ON AGD.CLIENTE = CLI.CODCLIENTE
GROUP BY AGD.CLIENTE HAVING COUNT(AGD.CODAGENDA) = 1;

