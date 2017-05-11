CREATE DATABASE PELUQUERIA_CANINA;
USE PELUQUERIA_CANINA;

CREATE TABLE ZONA(
idZona INT(1) NOT NULL,
Barrio VARCHAR(20) NOT NULL,
PRIMARY KEY (idZona, Barrio)
);

CREATE TABLE CLIENTE(
idCliente INT(10) PRIMARY KEY AUTO_INCREMENT,
Nombre VARCHAR(25) NOT NULL,
Calle VARCHAR(40) NOT NULL,
nroCalle INT(8) NOT NULL,
Baja BOOLEAN NOT NULL,
idZona INT(1),
Barrio VARCHAR(20),
FOREIGN KEY (idZona) REFERENCES ZONA(idZona),
FOREIGN KEY (Barrio) REFERENCES ZONA(Barrio)
);

CREATE TABLE MASCOTAS(
idMascota INT(10) PRIMARY KEY AUTO_INCREMENT NOT NULL,
idCliente INT(10),
Nombre VARCHAR(25) NOT NULL,
Edad INT(2),
Raza VARCHAR(15),
Tamano VARCHAR(7),
Comportamiento VARCHAR(15),
Baja BOOLEAN NOT NULL,
FOREIGN KEY (idCliente) REFERENCES CLIENTE(idCliente)
);

CREATE TABLE EMPLEADOS(
cedIdent VARCHAR(11) PRIMARY KEY NOT NULL,
Nombre VARCHAR(25) NOT NULL,
Apellido VARCHAR(30) NOT NULL,
fecIng VARCHAR(10) NOT NULL
);

CREATE TABLE MOVILES(
Nombre VARCHAR(30) NOT NULL,
Matricula VARCHAR(8) PRIMARY KEY
);

CREATE TABLE TELEFONO(
idCliente INT(10) NOT NULL,
telefono VARCHAR(15) NOT NULL,
FOREIGN KEY (idCliente) REFERENCES CLIENTE(idCliente)
);

CREATE TABLE SERVICIOS(
idServicio INT(3) PRIMARY KEY NOT NULL,
dscServ VARCHAR(60) NOT NULL,
Precio INT(5)
);

CREATE TABLE PREFERENCIAS(
idMascota INT(10) NOT NULL,
cedIdent VARCHAR(11),
idServicio INT(3),
fecPref VARCHAR(10),
horaPred VARCHAR(5),
FOREIGN KEY (idMascota) REFERENCES MASCOTAS(idMascota),
FOREIGN KEY (cedIdent) REFERENCES EMPLEADOS(cedIdent),
FOREIGN KEY (idServicio) REFERENCES SERVICIOS(idServicio)
);

CREATE TABLE EVENTOS(
idEvento INT(5) PRIMARY KEY AUTO_INCREMENT NOT NULL,
idMascota INT(10) NOT NULL,
cedIdent VARCHAR(11) NOT NULL,
idServicio INT(3) NOT NULL,
fecEvent VARCHAR(10) NOT NULL,
horaEvent VARCHAR(5) NOT NULL,
Matricula VARCHAR(8) NOT NULL,
FOREIGN KEY (idMascota) REFERENCES MASCOTAS(idMascota),
FOREIGN KEY (cedIdent) REFERENCES EMPLEADOS(cedIdent),
FOREIGN KEY (idServicio) REFERENCES SERVICIOS(idServicio),
FOREIGN KEY (Matricula) REFERENCES MOVILES(Matricula)
);

CREATE TABLE ASISTE(
fecAsist VARCHAR(10) NOT NULL,
Matricula VARCHAR(8) NOT NULL,
cedIdent VARCHAR(11) NOT NULL,
FOREIGN KEY (Matricula) REFERENCES MOVILES(Matricula),
FOREIGN KEY (cedIdent) REFERENCES EMPLEADOS(cedIdent),
PRIMARY KEY (fecAsist, Matricula, cedIdent)
);

CREATE TABLE AGENDA(
idCliente INT(10),
idMascota INT(10),
fechaAgenda VARCHAR(10),
horaAgenda VARCHAR(5),
FOREIGN KEY (idCliente) REFERENCES CLIENTE(idCliente),
FOREIGN KEY (idMascota) REFERENCES MASCOTAS(idMascota)
);

INSERT INTO zona VALUES (1,"Malvin"),(1,"Pocitos"),(1,"Punta Gorda"),(1,"La Union"),(1,"Barrio Sur"),(2,"Shangrila"),(2,"Lagomar"),(2,"Solymar");

INSERT INTO cliente(Nombre,Calle,nroCalle,Baja,idZonaC,BarrioC) VALUES ("Andres Ghione","Estrazulas",1415,0,1,"Malvin"),("Gaston Fernandez","Bvar. España",1875,0,1,"Pocitos"),("Daniel Ferreiro","Miami",2074,0,2,"Shangrila");
INSERT INTO empleados VALUES("4.650.262-0","Jorge","Martinez","10/11/1990"),("4.650.262-2","Pedro","Rodriguez","09/02/1996"),("4.896.362-0","Martin","Alfonsi","06/03/2000"),("5.690.187-1","Michael","Casanova","25/01/2003");
INSERT INTO moviles VALUES("Movil 1","SAZ1748"),("Movil 2","SAZ1749");
INSERT INTO servicios VALUES (1,"Baño CC",300),(2,"Baño CL",350),(3,"Baño GC",450),(4,"Baño GL",550),(5,"Corte(esquila) CC",300),(6,"Corte(esquila) CL",350),(7,"Corte(esquila) GC",450),(8,"Corte(esquila) GL",450),(9,"Corte y baño CC",500),(10,"Corte y baño CL",600),(11,"Corte y baño GC",800),(12,"Corte y baño GL",900),(13,"Recortes",150),(14,"Baño y recortes CC",400),(15,"Baño y recortes CL",500),(16,"Baño y recortes GC",650),(17,"Baño y recortes GL",750),(18,"Baño antiparacitario CC",300),(19,"Baño antiparacitario CL",350),(20,"Baño antiparacitario GC",450),(21,"Baño antiparacitario GL",550);
INSERT INTO telefono VALUES (1,"091787644"),(1,"26135814"),(2,"092568978"),(3,"099708914");
INSERT INTO mascotas (idCliente,Nombre,Edad,Raza,Tamano,Comportamiento,Baja) VALUES (1,"Pepito",10,"Pitbull","Grande","COMPLICADO",false),(1,"Tomy",14,"Caniche","Chico","BUENO",false),(2,"Susy",8,"Beagle","Chico","BUENO",false),(3,"Cancun",4,"Pug","Chico","BUENO",false);
INSERT INTO eventos(idMascota,cedIdent,idServicio,fecEvent,horaEvent,Matricula) VALUES (1,"4.650.262-0",3,"03/05/2016","17:30","SAZ1748"),(2,"4.650.262-0",9,"03/05/2016","16:30","SAZ1748"),(3,"4.650.262-2",18,"03/05/2016","15:00","SAZ1749"),(4,"4.650.262-2",18,"03/05/2016","14:30","SAZ1749");
INSERT INTO preferencias VALUES(2,"4.650.262-0",1,"03/05/2017","14:30");
INSERT INTO asiste VALUES ("03/05/2016","SAZ1748","4.650.262-0"),("03/05/2016","SAZ1749","4.650.262-2"),("03/05/2016","SAZ1748","4.896.362-0"),("03/05/2016","SAZ1749","5.690.187-1");
INSERT INTO agenda VALUES (1,1,"04/06/2017","17:00"),(1,2,"04/06/2017","18:00");