CREATE TABLE `tb_clientes`(
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nome` VARCHAR(255) NOT NULL ,
    `cpf` VARCHAR(255) NOT NULL UNIQUE,
    `email` VARCHAR(255) NOT NULL UNIQUE,
    `telefone` VARCHAR(255) NOT NULL UNIQUE,
    `dataNascimento` DATE NOT NULL,
    `cep` VARCHAR(255) NOT NULL,
    `logradouro` VARCHAR(255) NOT NULL,
    `cidade` VARCHAR(255) NOT NULL,
    `uf` VARCHAR(255) NOT NULL,
    `bairro` VARCHAR(255) NOT NULL,
    `numero` VARCHAR(255) NOT NULL,
    `complemento` VARCHAR(255)
);