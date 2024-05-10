-- Inserindo telefones
INSERT INTO telefone(codigoArea, numero) VALUES ('63', '32213123');
INSERT INTO telefone(codigoArea, numero) VALUES ('62', '32243132');
INSERT INTO telefone(codigoArea, numero) VALUES ('61', '32243141');
INSERT INTO telefone(codigoArea, numero) VALUES ('66', '32242141');
INSERT INTO telefone(codigoArea, numero) VALUES ('55', '12452141');

-- Inserindo Pessoa
INSERT INTO pessoa (nome, email, cpf, sexo, aniversario, id_telefone) VALUES ('João', 'joaogomes@gmail.com', '123.456.789-12', 1, '1998-02-24', 1);
INSERT INTO pessoa (nome, email, cpf, sexo, aniversario, id_telefone) VALUES ('Felipe', 'felipeomes@gmail.com', '123.456.389-12', 1, '1992-02-23', 2);
INSERT INTO pessoa (nome, email, cpf, sexo, aniversario, id_telefone) VALUES ('Ana', 'anagomes@gmail.com', '123.456.729-12', 2, '1918-02-24', 3);
INSERT INTO pessoa(nome, email, cpf, sexo, aniversario, id_telefone) VALUES ('Rafael',  'rafael@gmail.com', '98765432134', 1, '1992-03-10', 4);
INSERT INTO pessoa(nome, email, cpf, sexo, aniversario, id_telefone) VALUES ('Pedro',  'pedro@gmail.com', '98765442134', 1, '1992-03-10', 5);

-- Inserindo Cliente

INSERT INTO cliente(id_pessoa) VALUES (1);
INSERT INTO cliente(id_pessoa) VALUES (2);
INSERT INTO cliente(id_pessoa) VALUES (3);

--Inserindo Funcionário

INSERT INTO funcionario(id_pessoa, cargo) VALUES (4, 'Vendedor');

--Inserindo fornecedor
INSERT INTO fornecedor(nome, email, endereco, id_fornecedor,cnpj) VALUES ('Americanas', 'americanas@gmail.com', 'rua das flores', 1,'72.227.573/0001-63');
INSERT INTO fornecedor(nome, email, endereco, id_fornecedor, cnpj) VALUES ('Kabum', 'kabum@gmail.com', 'rua dos mouses', 2,'32.447.256/0001-38');

-- Inserindo Marca
INSERT INTO marca (marca) VALUES ('Canon');
INSERT INTO marca (marca) VALUES ('Nikon');
INSERT INTO marca (marca) VALUES ('Sony');
INSERT INTO marca (marca) VALUES ('Fujifilm');

-- Inserindo Câmera
INSERT INTO camera (nomeModelo, preco, material, dimensoes, conectividade, resolucao, telaArticulavel, telaSensivelToque, tipoTela, iso, flashPopUp, garantia, idMarca) VALUES
('EOS R250',4500.00, 'metal emborrachado', '116.33x85.6 x 68.83mm','Wi-Fi', '24mp', true, true, 'LCD', 'ISO 100-12800', true, 1, 1), 
('EOS R150',6500.00, 'metal emborrachado', '116.33x85.6 x 68.83mm','Wi-Fi', '30mp', true, true, 'AMOLED', 'ISO 100-12800', true, 1, 2),
('EOS R300',6500.00, 'metal emborrachado', '116.33x85.6 x 68.83mm','Wi-Fi', '50mp', true, true, 'AMOLED', 'ISO 100-13000', true, 1, 3);

-- Inserindo Lente
INSERT INTO lente (diametroFiltro, distanciaFocal, preco, compatibilidade, dimensoes, material, montagem, nomeModelo, idMarca) VALUES (55, 50, 305.00, 'Canon EOS', '10x5x8', 'vidro', 'EF', 'Canon EF 50mm f_1.8 II', 1);
INSERT INTO lente (diametroFiltro, distanciaFocal, preco, compatibilidade, dimensoes, material, montagem, nomeModelo, idMarca) VALUES (52, 55, 350.00, 'Canon EOS 2', '10x5x8', 'vidro', 'EF', 'Canon EF 45mm f_2.3 II', 1);

