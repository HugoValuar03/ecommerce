-- Inserindo telefones
INSERT INTO telefone(codigoArea, numero) VALUES 
                                    ('63', '32213123'), 
                                    ('62', '32243132'), 
                                    ('61', '32243141'), 
                                    ('66', '32242141'), 
                                    ('55', '12452141');

-- Inserindo Pessoa
INSERT INTO pessoa (nome, email, cpf, sexo, aniversario, id_telefone, username, senha) VALUES 
-- Senha João: 234
('João', 'joaogomes@gmail.com', '123.456.789-12', 1, '1998-02-24', 1, 'joao.gomes', 'p82moUZk1SIA2vicVAHZ9TVkmc6wwRc+qJBoFQWAJ/lt2DQ2Tr3sLzLV1UoHj8yURd7T1/+5/tnWedVYEEhNlQ=='), 
-- Senha Felipe: 345
('Felipe', 'felipeomes@gmail.com', '123.456.389-12', 1, '1992-02-23', 2, 'felipe.omes', 'IsimPxtqqGq1OTddeeKhIFCgn0leFU6EWI9RAgpSeTfTlKBaAXcZHm1lk5SJ6Z2nZwBB+1A32q2w2lOevVtBIg=='),
-- Senha Ana: 456
('Ana', 'anagomes@gmail.com', '123.456.729-12', 2, '1918-02-24', 3, 'ana.gomes', 'rbG/jwSrRjqmOCOlERtiprbcq7n8M3fsOUFzAH50hzc29X0aO4vouJzeZOzLtIRwNaDNRRKVa0c6751aBhYpwA=='), 
-- Senha Rafael: 123
('Rafael',  'rafael@gmail.com', '98765432134', 1, '1992-03-10', 4, 'rafael.soares', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA=='), 
-- Senha Pedro: 567
('Pedro',  'pedro@gmail.com', '98765442134', 1, '1992-03-10', 5, 'pedro.felix', 'cGDXTTbKL96YkZuM7V0ca9XMx8zuH+oC8BsEX2jtBEWNMEjkXIqtPYhrttt0fw66X78ovge/wQQzuCs8hmQpLg==');

-- Criar Funcionario
insert into funcionario(cargo, id_pessoa) values
                                        ('Vendedor', 4),
                                        ('Gerente', 5);

-- Inserindo Vendas
insert into venda(nome, preco) values ('Canon T6i', 3300);
insert into venda(nome, preco) values ('Canon R100', 3200);
insert into venda(nome, preco) values ('Canon SL3', 5000);

-- Inserindo Cliente    
INSERT INTO cliente(id_pessoa) VALUES (1), 
                                      (2), 
                                      (3);

--Inserindo fornecedor
INSERT INTO fornecedor(nome, email, endereco, id_fornecedor,cnpj) VALUES 
                        ('Americanas', 'americanas@gmail.com', 'rua das flores', 1,'72.227.573/0001-63'), 
                        ('Kabum', 'kabum@gmail.com', 'rua dos mouses', 2,'32.447.256/0001-38');

-- Inserindo Marca
INSERT INTO marca (marca) VALUES 
                    ('Canon'), 
                    ('Nikon'), 
                    ('Sony'), 
                    ('Fujifilm');

-- Inserindo Produtos Câmera
INSERT INTO Produto (preco, idMarca, idFornecedor, dimensoes, material, nomeModelo) VALUES 
                                                        (4500.00, 1,1, '10x8x3', 'plastico', 'Canon T6i'),
                                                        (8500.00, 1,1, '10x8x3', 'plastico', 'Canon T8'),
                                                        (2200.00, 2,1, '10x8x3', 'plastico', 'Nikon D5200');

-- Inserindo Câmera
INSERT INTO camera (id, conectividade, resolucao, telaArticulavel, telaSensivelToque, tipoTela, iso, flashPopUp, garantia) 
VALUES 
(1, 'Wi-fi', '48mp', true, true, 'IPS', '12000', true, 2),
(2, 'Wi-fi', '24mp', true, false, 'LCD', '14000', false, 3),
(3, 'Wi-fi', '48mp', true, false, 'AMOLED', '16000', false, 2);


-- Inserindo Produtos Lente
INSERT INTO Produto (preco, idMarca, idFornecedor, dimensoes, material, nomeModelo) VALUES 
                                                (9000.0, 1, 1, '8x15x10', 'metal', 'Lente 80mm'), -- 4
                                                (12000.0, 1, 1, '8x15x10', 'metal', 'Lente 120mm'), -- 5
                                                (7000.0, 1, 1, '8x15x10', 'metal', 'Lente 40mm'); -- 6

-- Inserindo Lente
INSERT INTO lente (id, diametroFiltro, distanciaFocal, compatibilidade, montagem) VALUES 
                                                        (4,12, 10, 'Canon', 'EF'),
                                                        (5,13, 15, 'Canon', 'EF'),
                                                        (6,14, 17, 'Canon', 'EF');

-- Inserir Pedidos

INSERT INTO pedido (id_cliente, dataPedido, total, pago, formaPagamento, dataPrevista, dataChegada, statusPedido) VALUES 
(1, '2024-07-20', 19000.00, true, 2, '2024-08-28', '2024-08-29', 2);
