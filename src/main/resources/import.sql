INSERT INTO categoria(nome, data_Cadastro) VALUES ('BOOKS', NOW());
INSERT INTO categoria(nome, data_Cadastro) VALUES ('ELETRONICOS', NOW());
INSERT INTO categoria(nome, data_Cadastro) VALUES ('TENIS', NOW());
INSERT INTO categoria(nome, data_Cadastro) VALUES ('CAMISETAS', NOW());

INSERT INTO filial(apelido, telefone, email, cep, logradouro, complemento, unidade, bairro, localidade, uf, ibge, gia, ddd, siafi,numero,cnpj) VALUES ('Apelido Teste', '123456789', 'email@teste.com', '81910040', 'Logradouro Teste', 'Complemento Teste', 'Unidade Teste', 'Bairro Teste', 'Localidade Teste', 'UF', '1234567', 'GIA Teste', '12', 'SIAFI Teste','123','12345678912345');
INSERT INTO filial(apelido, telefone, email, cep, logradouro, complemento, unidade, bairro, localidade, uf, ibge, gia, ddd, siafi,numero,cnpj) VALUES ('Apelido Teste 2', '123456789', 'email@teste.com', '12345678', 'Logradouro Teste', 'Complemento Teste', 'Unidade Teste', 'Bairro Teste', 'Localidade Teste', 'UF', '1234567', 'GIA Teste', '12', 'SIAFI Teste','123','12345678912345');

INSERT INTO produto(nome,descricao,preco,imagem_Url,cod_Barras) VALUES ('Produto Teste1', 'Descricao Teste1', 10.0, 'imagemurl teste1', '12345678912345');
INSERT INTO produto(nome,descricao,preco,imagem_Url,cod_Barras) VALUES ('Produto Teste2', 'Descricao Teste2', 10.0, 'imagemurl teste2', '12345678912345');
INSERT INTO produto(nome,descricao,preco,imagem_Url,cod_Barras) VALUES ('Produto Teste3', 'Descricao Teste3', 10.0, 'imagemurl teste3', '12345678912345');
INSERT INTO produto(nome,descricao,preco,imagem_Url,cod_Barras) VALUES ('Produto Teste4', 'Descricao Teste4', 10.0, 'imagemurl teste4', '12345678912345');

INSERT INTO produto_categoria(produto_id,categoria_id) VALUES (1,1);
INSERT INTO produto_categoria(produto_id,categoria_id) VALUES (2,2);
INSERT INTO produto_categoria(produto_id,categoria_id) VALUES (3,3);
