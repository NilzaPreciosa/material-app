 --Author:  nilza.graca
 --Created: 15/jun/2021

--create user sa@'localhost' identified with mysql_native_password BY '';
--GRANT ALL ON `armazemdb`.* TO 'sa'@'localhost';
--Create database
create database armazemdb;
--Entidade Material
create table material(
    id              int,
    tipo            varchar(50),
    marca           varchar(50),
    referencia      varchar(50),
    processador     varchar(50),
    serialNumber    varchar(50),
    anoFabrico      int,
    idade           int,
    PRIMARY KEY (id)
);
--Entidade ArmazemItem
create table armazem_item(
    id          int,
    codigo      int,
    material_id int,
    dataEntrada timestamp,
    dataLeilao  timestamp null,
    status      varchar(80), --LEILOADO, OBSOLETO
    PRIMARY KEY(id),
    --Criando os refencias as tabelas
    FOREIGN KEY (material_id) REFERENCES material(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
--Entidade Usuario
create table usuario(
    id          int,
    username    varchar(50),
    password    varchar(50),
    perfil      varchar(50),
    nameDescription varchar(80),
    PRIMARY KEY(id,perfil)
);
--composition
create table usuario_material(
    usuario_id  int,
    material_id int,
    --Criando referencias para usuario
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    --Criando referencias para material
    FOREIGN KEY (material_id) REFERENCES material(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);