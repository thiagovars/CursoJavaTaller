CREATE DATABASE BRA_CANINA;

USE BRA_CANINA;

CREATE TABLE BRA_RAZA (
	codRaza int(5) not null primary key AUTO_INCREMENT,
	nombre  varchar(80) not null,
	porte   varchar(80) not null,
	pelaje  varchar(5) not null
);

CREATE TABLE BRA_SERVICIOS (
	codServicio int(5) not null primary key AUTO_INCREMENT,
	nombre      varchar(20) not null,
	precio      float(10) not null,
	pelaje      varchar(5) not null,
	porte       varchar(6) not null,
	tiempo      time
);

CREATE TABLE BRA_CLIENTE (
	codCliente int(5) not null primary key AUTO_INCREMENT,
	nombre     varchar(100) not null
);

CREATE TABLE BRA_BARRIOS (
	codBarrio int(5) not null primary key AUTO_INCREMENT,
	nombre    varchar(100) not null,
	zona      varchar(80)
);

CREATE TABLE BRA_EMPLEADO (
	codEmp int(5) not null primary key AUTO_INCREMENT,
	nombre varchar(80) not null,
	salario int(100)
);

CREATE TABLE BRA_COCHE (
	codCoche int(5) not null primary key AUTO_INCREMENT,
	matricula varchar(7) not null
);

CREATE TABLE BRA_DIRECCION (
	codDireccion int(5) not null primary key AUTO_INCREMENT,
	numPuerta    int(10) not null,
	barrio       int(5) not null,
	cliente      int(5) not null,
	foreign key (barrio) references BRA_BARRIOS(codBarrio),
	foreign key (cliente) references BRA_CLIENTE(codCliente)
);

CREATE TABLE BRA_MASCOTA (
	codMascota int(5) not null primary key AUTO_INCREMENT,
	nombre varchar(80) not null,
	raza int(5) not null,
	cliente int(5) not null,
	foreign key (raza) references BRA_RAZA(codRaza),
	foreign key (cliente) references BRA_CLIENTE(codCliente)
);

CREATE TABLE BRA_TELEFONO (
	codTelefono int(5) not null primary key	AUTO_INCREMENT,
	numero varchar(9) not null,
	cliente int(5),
	empleado int(5),
	foreign key (cliente) references BRA_CLIENTE(codCliente),
	foreign key (empleado) references BRA_EMPLEADO(codEmp)
);

CREATE TABLE BRA_AGENDA (
	codAgenda int(5) not null primary key AUTO_INCREMENT,
	fecha datetime not null,
	cliente int(5) not null,
	servicio int(5) not null,
	foreign key (cliente) references BRA_CLIENTE(codCliente),
	foreign key (servicio) references BRA_SERVICIOS(codServicio)
);

CREATE TABLE BRA_RELCOCHEAGDEMP (
	codCocheAgdEmp int(5) not null AUTO_INCREMENT,
	coche int(5) not null,
	empleado1 int(5) not null,
	empleado2 int(5) not null,
	agenda int(5),
	foreign key (coche) references BRA_COCHE(codCoche),
	foreign key (empleado1) references BRA_EMPLEADO(codEmp),
	foreign key (empleado2) references BRA_EMPLEADO(codEmp),
	foreign key (agenda) references BRA_AGENDA(codAgenda),
	primary key (codCocheAgdEmp, empleado1, empleado2, agenda)
);

/* INSERTS */
INSERT INTO BRA_COCHE (matricula) VALUES 
('ABE7844'),
('PER6866');

INSERT INTO BRA_BARRIOS (nombre, zona) VALUES 
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

INSERT INTO BRA_RAZA (nombre, porte, pelaje) VALUES 
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

INSERT INTO BRA_SERVICIOS (nombre, precio, pelaje, porte) VALUES
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

INSERT INTO BRA_CLIENTE (nombre) VALUES 
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

INSERT INTO BRA_MASCOTA (nombre, raza, cliente) VALUES
('Lola', 19, 1),
('Tsuki', 2, 2),
('Toti', 1, 3),
('Tito', 3, 4),
('Lobo', 4, 5),
('Toto', 5, 6),
('Simba', 6, 7),
('Koki', 7, 8),
('Napoleón', 8, 9),
('Orejas', 9, 10),
('Sigmund', 10, 11),
('Trufa', 11, 12),
('Marvel', 12, 13),
('Marley', 13, 14),
('Peluche', 14, 15),
('Alen', 15, 16),
('Sisi', 16, 17),
('Anita', 17, 18),
('Nina', 18, 19),
('Arwen', 20, 20),
('Luna', 21, 21),
('Ada', 22, 22),
('Buda', 23, 23),
('Sol', 24, 24);

INSERT INTO BRA_TELEFONO (numero, cliente) VALUES
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

INSERT INTO BRA_EMPLEADO (nombre, salario) VALUES 
('Mario Tetto', 26000),
('Rosa Lopez', 30000),
('Pamela Alvez', 32000),
('Pablo Nuñez', 25000);

INSERT INTO BRA_TELEFONO (numero, empleado) VALUES
('098889998', 1),
('094315415', 2),
('099481418', 3),
('091456654', 4);

INSERT INTO BRA_DIRECCION (numPuerta, barrio, cliente) VALUES 
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
('2525', 11, 13),
('1846', 12, 14),
('9796', 13, 15),
('9494', 14, 16),
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

INSERT INTO BRA_AGENDA (fecha, cliente, servicio) VALUES
('2017-05-01 08:00:00', 8, 5),
('2017-05-01 08:00:00', 12, 3),
('2017-05-01 08:00:00', 5, 23),
('2017-05-01 08:00:00', 1, 8),
('2017-05-02 08:00:00', 7, 9),
('2017-05-02 08:00:00', 23, 23),
('2017-05-02 08:00:00', 18, 20),
('2017-05-02 08:00:00', 15, 15);

INSERT INTO BRA_RELCOCHEAGDEMP (COCHE, EMPLEADO1, EMPLEADO2, AGENDA) VALUES
(1, 1, 2, 1),
(2, 3, 4, 2),
(1, 1, 2, 3),
(2, 3, 4, 4),
(1, 1, 2, 5),
(1, 1, 2, 6),
(2, 3, 4, 7),
(2, 3, 4, 8);

------- SELECT -------
SELECT MASCOTA.NOMBRE AS MASCOTA,
       RAZA.NOMBRE AS RAZA,
       RAZA.PELAJE AS PELAJE,
       RAZA.PORTE AS PORTE,
       CLIENTE.NOMBRE AS CLIENTE,
       CLIENTE.CODCLIENTE AS CODCLIENTE 
  FROM bra_mascota as mascota
INNER JOIN BRA_RAZA RAZA ON RAZA.codRaza = mascota.raza
INNER JOIN BRA_CLIENTE CLIENTE ON CLIENTE.CODCLIENTE = MASCOTA.CLIENTE;

SELECT BARRIO.ZONA,
       BARRIO.NOMBRE,
       DIRECCION.NUMPUERTA,
       AGENDA.CODAGENDA
  FROM BRA_BARRIOS AS BARRIO
INNER JOIN BRA_DIRECCION DIRECCION ON DIRECCION.BARRIO = BARRIO.codBarrio
INNER JOIN BRA_CLIENTE CLIENTE ON CLIENTE.CODCLIENTE = DIRECCION.CLIENTE
INNER JOIN BRA_AGENDA AGENDA ON AGENDA.CLIENTE = CLIENTE.CODCLIENTE;

SELECT SUM(SERVICIO.PRECIO) FROM BRA_AGENDA AGENDA
INNER JOIN BRA_SERVICIOS SERVICIO ON SERVICIO.CODSERVICIO = AGENDA.SERVICIO;

SELECT SUM(SERVICIO.PRECIO) FROM BRA_AGENDA AGENDA
INNER JOIN BRA_SERVICIOS SERVICIO ON SERVICIO.CODSERVICIO = AGENDA.SERVICIO
INNER JOIN BRA_RELCOCHEAGDEMP COCHEAGENDA ON COCHEAGENDA.AGENDA = AGENDA.CODAGENDA
INNER JOIN BRA_COCHE COCHE ON COCHE.CODCOCHE = COCHEAGENDA.COCHE
GROUP BY CHOCHE.CODCOCHE;

SELECT SUM(SALARIO) FROM BRA_EMPLEADO;