INSERT INTO TURBINAS (ANGULO, ALTURA, VELOCIDAD_MAX, ENCENDIDO, CARGA) VALUES ('30','107','50','TRUE','18');
INSERT INTO TURBINAS (ANGULO, ALTURA, VELOCIDAD_MAX, ENCENDIDO, CARGA) VALUES ('30','104','52','TRUE','27');
INSERT INTO TURBINAS (ANGULO, ALTURA, VELOCIDAD_MAX, ENCENDIDO, CARGA) VALUES ('35','102','53','TRUE','12');
INSERT INTO TURBINAS (ANGULO, ALTURA, VELOCIDAD_MAX, ENCENDIDO, CARGA) VALUES ('40','107','52','FALSE','0');
INSERT INTO TURBINAS (ANGULO, ALTURA, VELOCIDAD_MAX, ENCENDIDO, CARGA) VALUES ('30','105','52','TRUE','10');
INSERT INTO TURBINAS (ANGULO, ALTURA, VELOCIDAD_MAX, ENCENDIDO, CARGA) VALUES ('40','110','50','FALSE','0');

INSERT INTO USUARIO (CORREO, PASSW) VALUES ('sexoculo@gmail.com', '{noop}abc123');
INSERT INTO USUARIO (CORREO, PASSW) VALUES ('farloperez@gmail.com', '{noop}abc123');
INSERT INTO USUARIO (CORREO, PASSW) VALUES ('pito@gmail.com', '{noop}abc123');

INSERT INTO CLIMA (TEMPERATURA, DESCRIPCION, PRECIPITACION, VELOCIDAD_VIENTO) VALUES (23, 'Soleado', 3, 45);
INSERT INTO CLIMA (TEMPERATURA, DESCRIPCION, PRECIPITACION, VELOCIDAD_VIENTO) VALUES (10, 'Lluvia fuerte', 69, 69);
INSERT INTO CLIMA (TEMPERATURA, DESCRIPCION, PRECIPITACION, VELOCIDAD_VIENTO) VALUES (15, 'Apocalipsis nuclear', 25, 15);
INSERT INTO CLIMA (TEMPERATURA, DESCRIPCION, PRECIPITACION, VELOCIDAD_VIENTO) VALUES (35, 'Nublado', 30, 29);

INSERT INTO GENERADOR (RPM, VOLTAJE, PRESION, ESTADO) VALUES (43, 220, 14, "Bajo rendimiento");
INSERT INTO GENERADOR (RPM, VOLTAJE, PRESION, ESTADO) VALUES (48, 220, 11, "Bajo rendimiento");
INSERT INTO GENERADOR (RPM, VOLTAJE, PRESION, ESTADO) VALUES (0, 110, 2, "Reposo");
INSERT INTO GENERADOR (RPM, VOLTAJE, PRESION, ESTADO) VALUES (0, 110, 3, "Reposo");
INSERT INTO GENERADOR (RPM, VOLTAJE, PRESION, ESTADO) VALUES (2578, 220, 77, "Alto rendimiento");