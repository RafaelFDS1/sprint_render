DROP TABLE IF EXISTS Produto;
CREATE TABLE Produto (
                         id SERIAL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         descricao TEXT,
                         preco NUMERIC(10, 2) NOT NULL,
                         quantidadeEstoque INTEGER NOT NULL
);

INSERT INTO Produto (nome, descricao, preco, quantidadeEstoque)
VALUES
    ('Carne Bovina - Alcatra', 'Carne bovina de corte nobre - Alcatra. Ideal para churrasco.', 29.99, 100),
    ('Frango Inteiro', 'Frango inteiro resfriado. Perfeito para diversas preparaÃ§Ãµes culinÃ¡rias.', 12.50, 200),
    ('Salsicha Tradicional', 'Salsicha tradicional de excelente qualidade. Ã“tima para cachorro-quente.', 5.99, 150),
    ('Bife de Frango', 'Bife de frango para grelhados e frituras. Sem pele.', 9.75, 120),
    ('Pernil SuÃ­no', 'Pernil suÃ­no temperado. Ideal para assados.', 24.80, 80),
    ('LinguiÃ§a Toscana', 'LinguiÃ§a toscana artesanal com temperos especiais.', 17.25, 90),
    ('Coxa de Frango', 'Coxa de frango desossada. PrÃ¡tica e saborosa.', 8.99, 180),
    ('Carne MoÃ­da', 'Carne bovina moÃ­da para preparaÃ§Ã£o de diversos pratos.', 15.00, 120),
    ('Costela Bovina', 'Costela bovina de corte especial. Ideal para assados lentos.', 35.50, 50),
    ('Peito de Frango', 'Peito de frango sem pele e sem osso. VersÃ¡til e saudÃ¡vel.', 11.75, 100);