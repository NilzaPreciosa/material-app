/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  nilza.graca
 * Created: 15/jun/2021
 */

--ALTER TABLE table_name 
--MODIFY column_name INT NOT NULL AUTO_INCREMENT PRIMARY KEY;

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
--drop table armazem_item;
create table armazem_item(
    id          int,
    codigo      varchar(10),
    material_id int,
    dataEntrada timestamp,
    dataLeilao  datetime NULL,
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