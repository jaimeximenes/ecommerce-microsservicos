CREATE TABLE `tb_fornecedores`(
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nomeFantasia` VARCHAR(255) NOT NULL ,
    `razaoSocial` VARCHAR(255) NOT NULL UNIQUE,
    `cnpj` VARCHAR(255) NOT NULL UNIQUE,
    `email` VARCHAR(255) NOT NULL UNIQUE,
    `telefone` VARCHAR(255) NOT NULL UNIQUE,
    `cep` VARCHAR(255) NOT NULL,
    `logradouro` VARCHAR(255) NOT NULL,
    `cidade` VARCHAR(255) NOT NULL,
    `uf` VARCHAR(255) NOT NULL,
    `bairro` VARCHAR(255) NOT NULL,
    `numero` VARCHAR(255) NOT NULL,
    `complemento` VARCHAR(255)
);