DROP TABLE IF EXISTS "TURBINAS";

CREATE TABLE "TURBINAS" (
"ID" INTEGER IDENTITY PRIMARY KEY,
"ANGULO" INTEGER NOT NULL,
"ALTURA" INTEGER NOT NULL,
"VELOCIDAD_MAX" INTEGER NOT NULL,
"ON" BOOLEAN NOT NULL,
"CARGA" INTEGER NOT NULL,
);