--DROP TABLE users IF EXIST;

CREATE TABLE users {
	id	INTEGER PRIMARY KEY,
	name VARCHAR(30),
	contraseña VARCHAR(30),
	nombre VARCHAR(50),
	apellidos VARCHAR(50),
	email VARCHAR(50)
;