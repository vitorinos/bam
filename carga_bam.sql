--tipos de obra
INSERT INTO bam.tb_tipo_obra (nm_tipo_obra) VALUES ('Livro');
INSERT INTO bam.tb_tipo_obra (nm_tipo_obra) VALUES ('Enciclopedia');
INSERT INTO bam.tb_tipo_obra (nm_tipo_obra) VALUES ('Artigo');
INSERT INTO bam.tb_tipo_obra (nm_tipo_obra) VALUES ('Periodico');
--tipos de pessoa
INSERT INTO bam.tb_tipo_pessoa (nm_tipo_pessoa,cd_tipo_pessoa) VALUES ('Aluno','A');
INSERT INTO bam.tb_tipo_pessoa (nm_tipo_pessoa,cd_tipo_pessoa) VALUES ('Professor','P');
INSERT INTO bam.tb_tipo_pessoa (nm_tipo_pessoa,cd_tipo_pessoa) VALUES ('Bibliotecario','B');
--autores
INSERT INTO bam.tb_autor(nm_autor)VALUES ('Machado de Assis');
INSERT INTO bam.tb_autor(nm_autor)VALUES ('Cora Coralina');
INSERT INTO bam.tb_autor(nm_autor)VALUES ('Olavo Bilac');
INSERT INTO bam.tb_autor(nm_autor)VALUES ('Paulo Coelho');
INSERT INTO bam.tb_autor(nm_autor)VALUES ('Mario Sergio Cortella');
INSERT INTO bam.tb_autor(nm_autor)VALUES ('Augusto Cury');
--editoras
INSERT INTO bam.tb_editora(nm_editora)VALUES ('Sextante');
INSERT INTO bam.tb_editora(nm_editora)VALUES ('Saraiva');
INSERT INTO bam.tb_editora(nm_editora)VALUES ('Cultura');

