CREATE TABLE CONFIGURACION (
	codigo int(100) not null primary key auto_increment,
	creacion date not null,
	modificacion date null,
	creacion char(1),
	edicion char(1),
	deleccion char(1)
);

CREATE TABLE CATEGORIA (
	codigo int(100) not null primary key auto_increment,
	creacion date not null,
	modificacion date null,
	codConfig int(100),
	foreign key (codConfig) references CONFIGURACION (codigo)
);

CREATE TABLE USUARIO (
	codigo int(100) not null primary key auto_increment,
	creacion date not null,
	modificacion date null,
	nombre varchar(200) not null,
	tipo char(1) not null,
	passw varchar(64) not null,
	codCategoria int(100),
	foreign key (codCategoria) references CATEGORIA (codigo)
);

CREATE TABLE HORARIOS (
	codigo int(100) not null primary key auto_increment,
	creacion date not null,
	modificacion date null,
	fechaHoraEntrada datetime,
	fechaHoraSalida datetime,
	codUsuario int(100),
	foreign key (codUsuario) references USUARIO (codigo)
);

CREATE TABLE CONTROLMENSUAL (
	codigo int(100) not null primary key auto_increment,
	creacion date not null,
	monto decimal(10,2) not null,
	estado char(1),
	codUsuario int(100),
	foreign key	(codUsuario) references USUARIO (codigo)	
);