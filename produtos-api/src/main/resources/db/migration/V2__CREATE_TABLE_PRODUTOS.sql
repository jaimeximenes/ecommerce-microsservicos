CREATE TABLE IF NOT EXISTS `tb_produtos` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY UNIQUE,
    `codigo` VARCHAR(255) NOT NULL UNIQUE,
    `nome` VARCHAR(255) NOT NULL,
    `descricao` TEXT NOT NULL,
    `preco` DECIMAL(10,2) NOT NULL,
    `idCategoria` BIGINT NOT NULL,
    FOREIGN KEY (`idCategoria`) REFERENCES `tb_categorias`(`id`)
);