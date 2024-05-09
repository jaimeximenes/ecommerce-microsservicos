CREATE TABLE `tb_produtos` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY UNIQUE,
    `codigo` VARCHAR(255) NOT NULL UNIQUE,
    `nome` VARCHAR(255) NOT NULL,
    `descricao` TEXT NOT NULL,
    `preco` DOUBLE NOT NULL,
    `categoria_id` BIGINT,
    FOREIGN KEY (`categoria_id`) REFERENCES tb_categorias(id)
);