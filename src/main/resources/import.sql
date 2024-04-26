-- Inserindo telefones
INSERT INTO telefone(codigoArea, numero) VALUES ('63', '32213123');
INSERT INTO telefone(codigoArea, numero) VALUES ('62', '32243132');
INSERT INTO telefone(codigoArea, numero) VALUES ('61', '32243141');

-- Inserindo Cliente
INSERT INTO usuario (nome, email, cpf, sexo, aniversario, telefone) VALUES ('João', 'joaogomes@gmail.com', '123.456.789-12', 1, '1998-02-24', 1);

INSERT INTO cliente(id_pessoa) VALUES (1);

--Inserindo fornecedor
INSERT INTO fornecedor(nome, email, endereco, id_fornecedor,cnpj) VALUES ('Americanas', 'americanas@gmail.com', 'rua das flores', 1,'72.227.573/0001-63');
INSERT INTO fornecedor(nome, email, endereco, id_fornecedor, cnpj) VALUES ('Kabum', 'kabum@gmail.com', 'rua dos mouses', 2,'32.447.256/0001-38');



-- Inserindo uma Marca
INSERT INTO marca (nome) VALUES ('Canon');
INSERT INTO marca (nome) VALUES ('Nikon');
INSERT INTO marca (nome) VALUES ('Sony');

-- Inserindo uma Câmera
INSERT INTO camera (nomeModelo, preco, material, dimensoes, conectividade, resolucao, telaArticulavel, telaSensivelToque, tipoTela, iso, flashPopUp, garantia, id_marca) VALUES('EOS R100',4500.00, 'metal emborrachado', '116.33x85.6 x 68.83mm','Wi-Fi', '24 megapixels', true, true, 'LCD', 'ISO 100-12800', true, 1, 1);

-- Inserindo uma Lente
INSERT INTO lente (diametroFiltro, distanciaFocal, preco, compatibilidade, dimensoes, material, montagem, nomeModelo, id_marca) VALUES (55, 50, 300.00, 'Canon EOS', '10x5x8', 'vidro', 'EF', 'Canon EF 50mm f/1.8 II', 1);
INSERT INTO lente (diametroFiltro, distanciaFocal, preco, compatibilidade, dimensoes, material, montagem, nomeModelo, id_marca) VALUES (52, 55, 350.00, 'Canon EOS 2', '10x5x8', 'vidro', 'EF', 'Canon EF 45mm f/2.3 II', 1);


-- Inserindo uma Lente
-- INSERT INTO lente (nomeModelo, preco, material, dimensoes, comaptibildiade, diametroFiltro, montagem, id_marca, id_fornecedor)

