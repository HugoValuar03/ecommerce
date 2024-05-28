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
('João', 'joaogomes@gmail.com', '123.456.789-12', 1, '1998-02-24', 1, 'João', 'p82moUZk1SIA2vicVAHZ9TVkmc6wwRc+qJBoFQWAJ/lt2DQ2Tr3sLzLV1UoHj8yURd7T1/+5/tnWedVYEEhNlQ=='), 
-- Senha Felipe: 345
('Felipe', 'felipeomes@gmail.com', '123.456.389-12', 1, '1992-02-23', 2, 'Felipe', 'IsimPxtqqGq1OTddeeKhIFCgn0leFU6EWI9RAgpSeTfTlKBaAXcZHm1lk5SJ6Z2nZwBB+1A32q2w2lOevVtBIg=='),
-- Senha Ana: 456
('Ana', 'anagomes@gmail.com', '123.456.729-12', 2, '1918-02-24', 3, 'Ana', 'rbG/jwSrRjqmOCOlERtiprbcq7n8M3fsOUFzAH50hzc29X0aO4vouJzeZOzLtIRwNaDNRRKVa0c6751aBhYpwA=='), 
-- Senha Rafael: 123
('Rafael',  'rafael@gmail.com', '98765432134', 1, '1992-03-10', 4, 'Rafael', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA=='), 
-- Senha Pedro: 567
('Pedro',  'pedro@gmail.com', '98765442134', 1, '1992-03-10', 5, 'Pedro', 'cGDXTTbKL96YkZuM7V0ca9XMx8zuH+oC8BsEX2jtBEWNMEjkXIqtPYhrttt0fw66X78ovge/wQQzuCs8hmQpLg==');

-- Permissão Usuario
insert into funcionario(cargo, id_pessoa) values('Vendedor', 4);

-- Inserindo Vendas
insert into venda(nome, preco) values ('Canon T6i', 3300);
insert into venda(nome, preco) values ('Canon R100', 3200);
insert into venda(nome, preco) values ('Canon SL3', 5000);

-- Inserindo Cliente    
INSERT INTO cliente(id_pessoa) VALUES (1), 
                                      (2), 
                                      (3);

--Inserindo Funcionário
INSERT INTO funcionario(id_pessoa, cargo) VALUES 
                                            (4, 'Vendedor'),
                                            (5, 'Gerente');

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


-- Inserindo Câmera
INSERT INTO camera (nomeModelo, preco, material, dimensoes, conectividade, resolucao, telaArticulavel, telaSensivelToque, tipoTela, iso, flashPopUp, garantia, idMarca) VALUES
                                            ('EOS R250',4500.00, 'metal emborrachado', '116.33x85.6 x 68.83mm','Wi-Fi', '24mp', true, true, 'LCD', 'ISO 100-12800', true, 1, 1), 
                                            ('EOS R150',6500.00, 'metal emborrachado', '116.33x85.6 x 68.83mm','Wi-Fi', '30mp', true, true, 'AMOLED', 'ISO 100-12800', true, 1, 2),
                                            ('EOS R300',6500.00, 'metal emborrachado', '116.33x85.6 x 68.83mm','Wi-Fi', '50mp', true, true, 'AMOLED', 'ISO 100-13000', true, 1, 3);

-- Inserindo Lente
INSERT INTO lente (diametroFiltro, distanciaFocal, preco, compatibilidade, dimensoes, material, montagem, nomeModelo, idMarca) VALUES 
        (55, 50, 305.00, 'Canon EOS', '10x5x8', 'vidro', 'EF', 'Canon EF 50mm f_1.8 II', 1), 
        (52, 55, 350.00, 'Canon EOS 2', '10x5x8', 'vidro', 'EF', 'Canon EF 45mm f_2.3 II', 1);
