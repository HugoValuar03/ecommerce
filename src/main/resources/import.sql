--Inserindo fornecedor


-- Inserindo uma Marca
INSERT INTO marca (nome) VALUES ('Canon');

-- Inserindo uma Câmera
INSERT INTO camera (nomeModelo, preco, material, dimensoes, conectividade, resolucao, telaArticulavel, telaSensivelToque, tipoTela, iso, flashPopUp, garantia, id_marca) VALUES('EOS R100',4500.00, 'metal emborrachado', '116.33x85.6 x 68.83mm','Wi-Fi', '24 megapixels', true, true, 'LCD', 'ISO 100-12800', true, 1, 1);


-- Inserindo uma Lente
INSERT INTO lente (nomeModelo, preco, material, dimensoes, comaptibildiade, diametroFiltro, montagem, id_marca, id_fornecedor);

