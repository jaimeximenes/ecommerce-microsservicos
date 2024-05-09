CREATE TABLE tb_compras (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `emailCliente` VARCHAR(255) NOT NULL,
    `total` DOUBLE NOT NULL,
    `data` DATE NOT NULL
);