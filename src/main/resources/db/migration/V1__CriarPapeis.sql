CREATE SEQUENCE hibernate_sequence START 1;

CREATE TABLE Papel (id INT, Nome TEXT);

INSERT INTO Papel VALUES (nextval('hibernate_sequence'),'Administrador');

INSERT INTO Papel VALUES (nextval('hibernate_sequence'),'Operador');