DROP TABLE IF EXISTS TURBINAS;

CREATE TABLE TURBINAS (
ID INTEGER IDENTITY PRIMARY KEY NOT NULL,
ANGULO INTEGER NOT NULL,
ALTURA INTEGER NOT NULL,
VELOCIDAD_MAX INTEGER NOT NULL,
ENCENDIDO BOOLEAN NOT NULL,
CARGA INTEGER NOT NULL,
);

DROP TABLE IF EXISTS USUARIO;

CREATE TABLE  USUARIO (
    ID INTEGER IDENTITY PRIMARY KEY NOT NULL,
	CORREO VARCHAR2(100) NOT NULL,
	PASSW VARCHAR2(100) NOT NULL,
);

DROP TABLE IF EXISTS CLIMA;

CREATE TABLE CLIMA (
	ID INTEGER IDENTITY PRIMARY KEY NOT NULL,
	TEMPERATURA INTEGER NOT NULL,
	DESCRIPCION VARCHAR2(100) NOT NULL,
	PRECIPITACION INTEGER NOT NULL,
	VELOCIDAD_VIENTO INTEGER NOT NULL
)