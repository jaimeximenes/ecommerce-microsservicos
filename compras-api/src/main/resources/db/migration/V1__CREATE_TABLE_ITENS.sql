CREATE TABLE tb_itens (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY UNIQUE,
    `codigoProduto` VARCHAR(255) NOT NULL UNIQUE,
    `quantidade` INT NOT NULL,
    `preco` DOUBLE NOT NULL
);