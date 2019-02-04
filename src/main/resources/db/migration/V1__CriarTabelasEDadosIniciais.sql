CREATE SEQUENCE hibernate_sequence START 1;

CREATE TABLE Papel (id INT, Nome TEXT);

INSERT INTO Papel VALUES (nextval('hibernate_sequence'),'Administrador');

INSERT INTO Papel VALUES (nextval('hibernate_sequence'),'Operador');

CREATE TABLE Usuario (id INT, NomeDeUsuario TEXT, Email TEXT, Senha TEXT, Papel INT);

INSERT INTO Usuario VALUES (nextval('hibernate_sequence'),'admin', 'admin@admin.com','admin',(SELECT id FROM Papel Where nome='Administrador'));