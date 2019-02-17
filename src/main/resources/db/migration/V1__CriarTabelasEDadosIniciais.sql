CREATE SEQUENCE hibernate_sequence START 1;

CREATE TABLE Papel (id INT, Nome TEXT);

INSERT INTO Papel VALUES (nextval('hibernate_sequence'),'Administrador');

INSERT INTO Papel VALUES (nextval('hibernate_sequence'),'Operador');

CREATE TABLE Usuario (id INT, NomeCompleto TEXT, NomeDeUsuario TEXT, Email TEXT, Senha TEXT, idPapel INT);

INSERT INTO Usuario VALUES (nextval('hibernate_sequence'), 'Administrador','admin', 'admin@admin.com','admin',1);