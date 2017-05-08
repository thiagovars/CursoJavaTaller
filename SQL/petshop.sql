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
	calle        varchar(100) not null,
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
('Caniche toy',       'CHICO',  'CORTO'),
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

INSERT INTO CLIENTE (nombre, fechaRegistro) VALUES 
('Familia Gerali',          '2015-01-01'),
('Pedro y Mariana',         '2015-01-05'),
('Castro',                  '2016-02-13'),
('Familia Bouza',           '2017-02-02'),
('Familia Taranto',         '2015-02-24'),
('Edgar Vivar',             '2016-03-15'),
('Lopez Mena',              '2016-04-08'),
('Isaac Mejlovitz',         '2015-05-04'),
('Castro y Silveira',       '2017-06-19'),
("D'Arengber",              '2017-06-13'),
("Patricia Damiani",        '2017-06-18'),
("Julia Cardozo",           '2016-07-17'),
("Maria Lecueder",          '2016-07-17'),
("Nelson y Jacira Alvarez", '2015-08-20'),
("Leticia Weiss",           '2015-08-26'),
("Mariana Jourdan",         '2015-08-28'),
("Nestor Rosemblum",        '2016-08-30'),
("Fabian Suárez",           '2016-09-14'),
("Mario Macri",             '2016-09-18'),
("Ana Ribeiro",             '2016-10-12'),
("María Noel Ache",         '2017-10-12'),
("Teresa Aishemberg",       '2017-10-05'),
("Azucena Arbeleche",       '2017-11-06'),
("Selva Andreoli",          '2017-12-06');

INSERT INTO MASCOTA (nombre, raza) VALUES
('Lola', 19),
('Tsuki', 2),
('Toti', 1),
('Tito', 3),
('Lobo', 4),
('Toto', 5),
('Simba', 6),
('Koki', 7),
('Madam Bovary', 9),
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
(2, 9),
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

INSERT INTO REL_CLI_EMP_TELEFONO (numero, cliente) VALUES
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

INSERT INTO REL_CLI_EMP_TELEFONO (numero, empleado) VALUES
('098889998', 1),
('094315415', 2),
('099481418', 3),
('091456654', 4);

INSERT INTO REL_DIR_BAR_CLI (numPuerta, calle, barrio, cliente) VALUES 
('3054', 'Eduardo D. Carbajal', 1, 4),
('125', 'Yaguarí', 2, 3),
('7801', 'Guadalupe', 3, 5),
('1195', 'Hocquart', 4, 7),
('105', 'Batoví',  5, 6),
('6659', 'Av. Uruguay', 6, 8),
('4581', '25 de Mayo', 7, 9),
('1546', 'Colonia', 8, 10),
('889', 'Maldonado',  9, 11),
('1012', 'José Castro', 10, 12),
('2525', 'Heredita', 10, 13),
('1846', 'Calle Dionisio Coronel', 10, 14),
('9796', 'Real', 10, 15),
('9494', 'Gregorio Camino', 10, 16),
('6684', 'Pedro Trápani', 15, 17),
('666', 'Bonaparte',  16, 18),
('1516', 'Juan Cabal', 17, 19),
('4011', 'Miguel Grau', 18, 20),
('4368', 'Rafael Hortiguera', 19, 1),
('8488', 'Amandaú', 20, 22),
('8787', 'Camino Gral. Osvaldo Rodríguez', 21, 23),
('9491', 'Natal', 22, 24),
('5066', 'Dr. Gabriel Otero', 23, 21),
('4366', 'Aceguá', 24, 2);

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
('2017-05-02 08:00:00', 15, 15),
('2017-05-12 08:00:00', 5, 13),
('2016-02-11 08:00:00', 9, 20),
('2017-05-13 08:00:00', 10, 14),
('2017-05-13 09:00:00', 1, 3),
('2017-05-13 010:10:00', 4, 5),
('2017-05-13 011:00:00', 15, 7),
('2017-05-13 012:00:00', 18, 9),
('2017-05-13 013:30:00', 19, 5),
('2017-05-13 014:10:00', 5, 6),
('2017-05-13 015:00:00', 8, 7),
('2017-05-13 08:00:00', 9, 10),
('2017-05-13 09:00:00', 11, 25),
('2017-05-13 010:10:00', 12, 67),
('2017-05-13 011:00:00', 21, 32),
('2017-05-13 012:00:00', 24, 65),
('2017-05-13 013:30:00', 7, 24),
('2017-05-13 014:10:00', 17, 39),
('2017-05-13 015:00:00', 22, 40),
;

INSERT INTO REL_COCH_AGD_EMP (COCHE, EMPLEADO1, EMPLEADO2, AGENDA) VALUES
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
(2, 3, 4, 73),
(1, 2, 1, 75),
(1, 2, 1, 76),
(1, 2, 1, 77),
(1, 2, 1, 78),
(2, 3, 4, 79),
(2, 3, 4, 80),
(2, 3, 4, 81),
(2, 3, 4, 82),
(2, 3, 4, 83),
(2, 3, 4, 84),
(2, 3, 4, 85),
(2, 3, 4, 86),
(2, 3, 4, 87),
(2, 3, 4, 88),
(2, 3, 4, 89),
(2, 3, 4, 90),
(2, 3, 4, 91);

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
/*1*/SELECT COUNT(*) AS CANTIDAD_COCHE FROM COCHE;

/*2*/ SELECT EMP.NOMBRE, EMP.fechaIngreso, TIMESTAMPDIFF(YEAR, EMP.fechaIngreso, CURDATE()) AS "ANTIGÜEDAD" FROM EMPLEADO EMP;

/*3*/ SELECT BARRIOS.NOMBRE FROM BARRIOS BARRIOS ORDER BY NOMBRE ASC;

/*4*/ SELECT COUNT(*) AS "CANTIDAD BARRIOS" FROM BARRIOS;

/*5*/ SELECT COUNT(*) AS "CANTIDAD CLIENTES REGISTRADOS" FROM CLIENTE;

/*6*/ SELECT NOMBRE FROM CLIENTE ORDER BY FECHAREGISTRO DESC LIMIT 1;

/*7*/ SELECT count(cli.codcliente) as "Clientes", BAR.NOMBRE FROM CLIENTE CLI
INNER JOIN DIRECCION DIR ON DIR.CLIENTE = CLI.codCliente
INNER JOIN BARRIOS BAR ON BAR.codBarrio = DIR.BARRIO
GROUP BY BAR.CODBARRIO ORDER BY clientes, bar.nombre ASC;

/*8*/ SELECT CLI.NOMBRE, COUNT(AGD.CODAGENDA) AS "NUMERO_ATENDIMENTOS" FROM AGENDA AGD
INNER JOIN CLIENTE CLI ON CLI.CODCLIENTE = AGD.CLIENTE
GROUP BY CLI.CODCLIENTE ORDER BY "NUMERO_ATENDIMENTO" DESC;

/*9*/ SELECT CLI.NOMBRE, CLI.FECHAREGISTRO FROM CLIENTE CLI
INNER JOIN AGENDA AGD ON AGD.CLIENTE = CLI.CODCLIENTE
GROUP BY AGD.CLIENTE HAVING COUNT(AGD.CODAGENDA) = 1;

/*10*/ SELECT NOMBRE, PRECIO FROM SERVICIOS;

/*11*/ SELECT * FROM SERVICIOS WHERE PRECIO > 500;

/*12*/ SELECT COUNT(1) AS CANTIDAD FROM (SELECT DISTINCT RAZA.NOMBRE FROM AGENDA
INNER JOIN CLIENTE CLI ON CLI.CODCLIENTE = AGENDA.CLIENTE
INNER JOIN REL_MASCOTA_CLIENTE RELMASCOTA ON RELMASCOTA.CLIENTE = CLI.CODCLIENTE
INNER JOIN MASCOTA ON MASCOTA.CODMASCOTA = RELMASCOTA.MASCOTA
INNER JOIN RAZA ON RAZA.CODRAZA = MASCOTA.RAZA) TABLA;

/* 13 */ SELECT 
CLIENTE.NOMBRE AS 'CLIENTE', MASCOTA.NOMBRE AS 'MASCOTA', RAZA.NOMBRE AS 'RAZA', RDIRECCION.NUMPUERTA AS 'NUMERO DE PUERTA', TELEFONO.NUMERO AS 'TELEFONO', BARRIOS.NOMBRE AS 'BARRIO'
FROM CLIENTE
INNER JOIN REL_MASCOTA_CLIENTE RMASCOTA ON RMASCOTA.CLIENTE = CLIENTE.CODCLIENTE
INNER JOIN MASCOTA ON MASCOTA.CODMASCOTA = RMASCOTA.MASCOTA
INNER JOIN RAZA ON RAZA.CODRAZA = MASCOTA.RAZA
INNER JOIN REL_DIR_BAR_CLI RDIRECCION ON RDIRECCION.CLIENTE = CLIENTE.CODCLIENTE
INNER JOIN BARRIOS ON BARRIOS.CODBARRIO = RDIRECCION.BARRIO
INNER JOIN REL_CLI_EMP_TELEFONO TELEFONO ON TELEFONO.CLIENTE = CLIENTE.CODCLIENTE
WHERE TELEFONO.NUMERO = '099123456';

/*14*/ SELECT CLIENTE.NOMBRE, COUNT(RMASCOTA.MASCOTA) AS 'MASCOTAS' FROM CLIENTE
INNER JOIN REL_MASCOTA_CLIENTE RMASCOTA ON RMASCOTA.CLIENTE = CLIENTE.CODCLIENTE
GROUP BY CLIENTE;

/*15*/
SELECT CLIENTE.NOMBRE, PET.NOMBRE FROM CLIENTE
INNER JOIN REL_MASCOTA_CLIENTE RMASCOTA ON RMASCOTA.CLIENTE = CLIENTE.CODCLIENTE
INNER JOIN MASCOTA PET ON PET.CODMASCOTA = RMASCOTA.MASCOTA
ORDER BY CLIENTE.NOMBRE;

/*16*/
SELECT CLIENTE.NOMBRE, COUNT(RMASCOTA.MASCOTA) AS 'MASCOTAS' FROM CLIENTE
INNER JOIN REL_MASCOTA_CLIENTE RMASCOTA ON RMASCOTA.CLIENTE = CLIENTE.CODCLIENTE
GROUP BY CLIENTE ORDER BY MASCOTAS DESC LIMIT 1;

/*17*/
SELECT DISTINCT MASCOTA.NOMBRE FROM MASCOTA
INNER JOIN REL_MASCOTA_CLIENTE PET ON PET.MASCOTA = MASCOTA.CODMASCOTA
INNER JOIN CLIENTE ON CLIENTE.CODCLIENTE = PET.CLIENTE
WHERE CLIENTE.FECHAREGISTRO IS NOT NULL;

/*18*/
SELECT SUM(SERVICIOS.PRECIO) FROM AGENDA
INNER JOIN SERVICIOS ON SERVICIOS.CODSERVICIO = AGENDA.SERVICIO
WHERE YEAR(AGENDA.FECHA) = '2016' AND MONTH(AGENDA.FECHA) = '04';

/*19*/
SELECT SUM(SERVICIOS.PRECIO) FROM AGENDA
INNER JOIN SERVICIOS ON SERVICIOS.CODSERVICIO = AGENDA.SERVICIO
WHERE YEAR(AGENDA.FECHA) = '2015';

/*20*/
SELECT MONTH(AGENDA.FECHA) AS 'MES', SUM(SERVICIOS.PRECIO) AS 'TOTAL' FROM AGENDA
INNER JOIN SERVICIOS ON SERVICIOS.CODSERVICIO = AGENDA.SERVICIO
WHERE YEAR(AGENDA.FECHA) = '2015' GROUP BY MONTH(AGENDA.FECHA) ORDER BY TOTAL DESC LIMIT 1;

/*21*/
SELECT MONTH(AGENDA.FECHA) AS 'MES', SUM(SERVICIOS.PRECIO) AS 'TOTAL' FROM AGENDA
INNER JOIN SERVICIOS ON SERVICIOS.CODSERVICIO = AGENDA.SERVICIO
WHERE YEAR(AGENDA.FECHA) = '2016' GROUP BY MONTH(AGENDA.FECHA) ORDER BY TOTAL DESC LIMIT 1;

/*22*/
SELECT COUNT(SERVICIOS.CODSERVICIO) AS 'BAÑOS' FROM SERVICIOS
INNER JOIN AGENDA ON AGENDA.SERVICIO = SERVICIOS.CODSERVICIO
WHERE UPPER(SERVICIOS.NOMBRE) LIKE '%BAÑO%' AND MONTH(AGENDA.FECHA) BETWEEN '01' AND '12';

/*23*/
SELECT COUNT(SERVICIOS.CODSERVICIO) AS 'ESQUILA' FROM SERVICIOS
INNER JOIN AGENDA ON AGENDA.SERVICIO = SERVICIOS.CODSERVICIO
WHERE UPPER(SERVICIOS.NOMBRE) LIKE '%ESQUILA%' AND MONTH(AGENDA.FECHA) BETWEEN '01' AND '12';

/*24*/
SELECT COUNT(SERVICIOS.CODSERVICIO) AS 'RECORTE' FROM SERVICIOS
INNER JOIN AGENDA ON AGENDA.SERVICIO = SERVICIOS.CODSERVICIO
WHERE UPPER(SERVICIOS.NOMBRE) LIKE '%RECORTE%' AND MONTH(AGENDA.FECHA) BETWEEN '01' AND '12';

/*25*/
SELECT COUNT(AGENDA.SERVICIO) AS 'SERVICIOS', BARRIOS.NOMBRE FROM AGENDA
INNER JOIN CLIENTE ON CLIENTE.CODCLIENTE = AGENDA.CLIENTE
INNER JOIN REL_DIR_BAR_CLI RBAR ON RBAR.CLIENTE = CLIENTE.CODCLIENTE
INNER JOIN BARRIOS ON BARRIOS.CODBARRIO = RBAR.BARRIO
GROUP BY BARRIOS.CODBARRIO;

/*26*/
SELECT COUNT(AGENDA.SERVICIO) AS 'SERVICIOS', SUM(SERVICIOS.PRECIO) AS 'TOTAL' FROM AGENDA
INNER JOIN SERVICIOS ON SERVICIOS.CODSERVICIO = AGENDA.SERVICIO
GROUP BY AGENDA.SERVICIO ORDER BY SERVICIOS DESC LIMIT 1;

/*27*/
SELECT 
AGENDA.FECHA, CLIENTE.NOMBRE, RDIR.CALLE, RDIR.NUMPUERTA, BARRIOS.NOMBRE, COCHE.CODCOCHE, COCHE.MATRICULA
FROM AGENDA
INNER JOIN CLIENTE ON CLIENTE.CODCLIENTE = AGENDA.CLIENTE
INNER JOIN REL_DIR_BAR_CLI RDIR ON RDIR.CLIENTE = CLIENTE.CODCLIENTE
INNER JOIN BARRIOS ON BARRIOS.CODBARRIO = RDIR.BARRIO
INNER JOIN REL_COCH_AGD_EMP RCOCHE ON RCOCHE.AGENDA = AGENDA.CODAGENDA
INNER JOIN COCHE ON COCHE.CODCOCHE = RCOCHE.COCHE
WHERE AGENDA.FECHA BETWEEN '2017-05-12 00:00:00' AND '2017-05-12 23:59:59';

/*28*/
SELECT TIME(AGENDA.FECHA) AS 'HORA', RDIR.CALLE, RDIR.NUMPUERTA
FROM AGENDA
INNER JOIN CLIENTE ON CLIENTE.CODCLIENTE = AGENDA.CLIENTE
INNER JOIN REL_DIR_BAR_CLI RDIR ON RDIR.CLIENTE = CLIENTE.CODCLIENTE
INNER JOIN BARRIOS ON BARRIOS.CODBARRIO = RDIR.BARRIO
INNER JOIN REL_COCH_AGD_EMP RCOCHE ON RCOCHE.AGENDA = AGENDA.CODAGENDA
INNER JOIN COCHE ON COCHE.CODCOCHE = RCOCHE.COCHE
WHERE AGENDA.FECHA BETWEEN '2017-05-13 08:00:00' AND '2017-05-13 16:00:00'
AND COCHE.CODCOCHE = 1
ORDER BY HORA ASC;

/*29*/
SELECT TIME(AGENDA.FECHA) AS 'HORA', RDIR.CALLE, RDIR.NUMPUERTA
FROM AGENDA
INNER JOIN CLIENTE ON CLIENTE.CODCLIENTE = AGENDA.CLIENTE
INNER JOIN REL_DIR_BAR_CLI RDIR ON RDIR.CLIENTE = CLIENTE.CODCLIENTE
INNER JOIN BARRIOS ON BARRIOS.CODBARRIO = RDIR.BARRIO
INNER JOIN REL_COCH_AGD_EMP RCOCHE ON RCOCHE.AGENDA = AGENDA.CODAGENDA
INNER JOIN COCHE ON COCHE.CODCOCHE = RCOCHE.COCHE
WHERE AGENDA.FECHA BETWEEN '2017-05-13 08:00:00' AND '2017-05-13 16:00:00'
AND COCHE.CODCOCHE = 2
ORDER BY HORA ASC;

/*30*/ 
SELECT (SELECT EMP.NOMBRE FROM EMPLEADO EMP WHERE EMP.CODEMP = RCOCHE.EMPLEADO1) AS 'EMPLEADO1',
(SELECT EMP.NOMBRE FROM EMPLEADO EMP WHERE EMP.CODEMP = RCOCHE.EMPLEADO2) AS 'EMPLEADO2',
COCHE.CODCOCHE, COCHE.MATRICULA FROM AGENDA
INNER JOIN REL_COCH_AGD_EMP RCOCHE ON RCOCHE.AGENDA = AGENDA.CODAGENDA
INNER JOIN COCHE ON COCHE.CODCOCHE = RCOCHE.COCHE
WHERE AGENDA.FECHA BETWEEN '2016-02-11 00:00:00' AND '2016-02-11 23:59:59'
AND AGENDA.CLIENTE = 9;

/*31*/
SELECT CLIENTE.NOMBRE AS 'CLIENTE', BAR.NOMBRE AS 'BARRIO' FROM agenda
INNER JOIN CLIENTE ON CLIENTE.CODCLIENTE = AGENDA.CLIENTE
INNER JOIN REL_DIR_BAR_CLI RBAR ON RBAR.CLIENTE = CLIENTE.CODCLIENTE
INNER JOIN BARRIOS BAR ON BAR.CODBARRIO = RBAR.BARRIO
INNER JOIN REL_COCH_AGD_EMP RCOCHE ON RCOCHE.AGENDA = AGENDA.CODAGENDA
WHERE AGENDA.FECHA BETWEEN '2016-05-01 00:00:00' AND '2016-05-01 23:59:59'
AND RCOCHE.COCHE = 2;

/*32*/
UPDATE SERVICIOS SET PRECIO = PRECIO + 50 WHERE PRECIO < 600;



