# Projeto1aTecWeb
Repositório para a entrega do projeto1a de Tecnologias Web

Tabelas para uso:

CREATE TABLE nota (
id INT NOT NULL AUTO_INCREMENT,
usuario_id INT NOT NULL,
mensage VARCHAR(140),
date DATE NOT NULL,
deadline DATE,
title VARCHAR(32),
PRIMARY KEY (id)
);

CREATE TABLE usuario (
id INT NOT NULL AUTO_INCREMENT,
user VARCHAR(32) NOT NULL,
password VARCHAR(32) NOT NULL,
name VARCHAR(32) NOT NULL,
PRIMARY KEY (id)
);
