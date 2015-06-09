
CREATE SEQUENCE bam.tb_tipo_pessoa_id_tipo_pessoa_seq;

CREATE TABLE bam.TB_TIPO_PESSOA (
                id_tipo_pessoa INTEGER NOT NULL DEFAULT nextval('bam.tb_tipo_pessoa_id_tipo_pessoa_seq'),
                nm_tipo_pessoa VARCHAR NOT NULL,
                cd_tipo_pessoa CHAR(1) NOT NULL,
                CONSTRAINT tb_tipo_pessoa_pk PRIMARY KEY (id_tipo_pessoa)
);


ALTER SEQUENCE bam.tb_tipo_pessoa_id_tipo_pessoa_seq OWNED BY bam.TB_TIPO_PESSOA.id_tipo_pessoa;

CREATE SEQUENCE bam.tb_tipo_obra_id_tipo_obra_seq;

CREATE TABLE bam.TB_TIPO_OBRA (
                id_tipo_obra INTEGER NOT NULL DEFAULT nextval('bam.tb_tipo_obra_id_tipo_obra_seq'),
                nm_tipo_obra VARCHAR NOT NULL,
                CONSTRAINT tb_tipo_obra_pk PRIMARY KEY (id_tipo_obra)
);


ALTER SEQUENCE bam.tb_tipo_obra_id_tipo_obra_seq OWNED BY bam.TB_TIPO_OBRA.id_tipo_obra;

CREATE UNIQUE INDEX tb_tipo_obra_idx
 ON bam.TB_TIPO_OBRA
 ( nm_tipo_obra );

CREATE SEQUENCE bam.tb_pessoa_id_pessoa_seq;

CREATE TABLE bam.TB_PESSOA (
                id_pessoa INTEGER NOT NULL DEFAULT nextval('bam.tb_pessoa_id_pessoa_seq'),
                nr_matricula INTEGER NOT NULL,
                cd_pessoa CHAR NOT NULL,
                nm_pessoa VARCHAR NOT NULL,
                id_tipo_pessoa INTEGER NOT NULL,
                CONSTRAINT tb_pessoa_pk PRIMARY KEY (id_pessoa)
);


ALTER SEQUENCE bam.tb_pessoa_id_pessoa_seq OWNED BY bam.TB_PESSOA.id_pessoa;

CREATE UNIQUE INDEX tb_pessoa_idx
 ON bam.TB_PESSOA
 ( nr_matricula );

CREATE SEQUENCE bam.tb_usuario_id_usuario_seq;

CREATE TABLE bam.TB_USUARIO (
                ID_USUARIO INTEGER NOT NULL DEFAULT nextval('bam.tb_usuario_id_usuario_seq'),
                NM_USUARIO VARCHAR(20) NOT NULL,
                DS_SENHA VARCHAR(20) NOT NULL,
                id_pessoa INTEGER NOT NULL,
                CONSTRAINT tb_usuario_pk PRIMARY KEY (ID_USUARIO)
);


ALTER SEQUENCE bam.tb_usuario_id_usuario_seq OWNED BY bam.TB_USUARIO.ID_USUARIO;

CREATE UNIQUE INDEX tb_usuario_idx
 ON bam.TB_USUARIO
 ( NM_USUARIO );

CREATE TABLE bam.TB_PROFESSOR (
                id_pessoa INTEGER NOT NULL,
                ds_departamento VARCHAR NOT NULL,
                CONSTRAINT tb_professor_pk PRIMARY KEY (id_pessoa)
);


CREATE TABLE bam.TB_ALUNO (
                id_pessoa INTEGER NOT NULL,
                ds_curso VARCHAR NOT NULL,
                CONSTRAINT tb_aluno_pk PRIMARY KEY (id_pessoa)
);


CREATE SEQUENCE bam.tb_emprestimo_id_emprestimo_seq;

CREATE TABLE bam.TB_EMPRESTIMO (
                id_emprestimo INTEGER NOT NULL DEFAULT nextval('bam.tb_emprestimo_id_emprestimo_seq'),
                id_pessoa INTEGER NOT NULL,
                dt_emprestimo DATE NOT NULL,
                dt_devolucao DATE NOT NULL,
                CONSTRAINT id_emprestimo PRIMARY KEY (id_emprestimo)
);


ALTER SEQUENCE bam.tb_emprestimo_id_emprestimo_seq OWNED BY bam.TB_EMPRESTIMO.id_emprestimo;

CREATE TABLE bam.TB_ARTIGO (
                id_artigo INTEGER NOT NULL,
                dt_publicacao DATE NOT NULL,
                CONSTRAINT id_artigo PRIMARY KEY (id_artigo)
);


CREATE SEQUENCE bam.tb_autor_id_autor_seq;

CREATE TABLE bam.TB_AUTOR (
                id_autor INTEGER NOT NULL DEFAULT nextval('bam.tb_autor_id_autor_seq'),
                nm_autor VARCHAR NOT NULL,
                CONSTRAINT id_autor PRIMARY KEY (id_autor)
);


ALTER SEQUENCE bam.tb_autor_id_autor_seq OWNED BY bam.TB_AUTOR.id_autor;

CREATE SEQUENCE bam.tb_editora_id_editora_seq;

CREATE TABLE bam.TB_EDITORA (
                id_editora INTEGER NOT NULL DEFAULT nextval('bam.tb_editora_id_editora_seq'),
                nm_editora VARCHAR NOT NULL,
                CONSTRAINT id_editora PRIMARY KEY (id_editora)
);


ALTER SEQUENCE bam.tb_editora_id_editora_seq OWNED BY bam.TB_EDITORA.id_editora;

CREATE SEQUENCE bam.tb_obra_id_obra_seq;

CREATE TABLE bam.TB_OBRA (
                id_obra INTEGER NOT NULL DEFAULT nextval('bam.tb_obra_id_obra_seq'),
                qtd_exemplares INTEGER NOT NULL,
                cd_tipo_obra CHAR(1) NOT NULL,
                ds_titulo VARCHAR NOT NULL,
                id_editora INTEGER NOT NULL,
                id_autor INTEGER NOT NULL,
                id_tipo_obra INTEGER NOT NULL,
                CONSTRAINT id_obras PRIMARY KEY (id_obra)
);


ALTER SEQUENCE bam.tb_obra_id_obra_seq OWNED BY bam.TB_OBRA.id_obra;

CREATE TABLE bam.TB_OBRA_EMPRESTIMO (
                id_emprestimo INTEGER NOT NULL,
                id_obra INTEGER NOT NULL,
                CONSTRAINT tb_obra_emprestimo_pk PRIMARY KEY (id_emprestimo, id_obra)
);


CREATE SEQUENCE bam.tb_reserva_id_reserva_seq;

CREATE TABLE bam.TB_RESERVA (
                id_reserva INTEGER NOT NULL DEFAULT nextval('bam.tb_reserva_id_reserva_seq'),
                id_obra INTEGER NOT NULL,
                id_pessoa INTEGER NOT NULL,
                dt_validade DATE NOT NULL,
                CONSTRAINT tb_reserva_pk PRIMARY KEY (id_reserva)
);


ALTER SEQUENCE bam.tb_reserva_id_reserva_seq OWNED BY bam.TB_RESERVA.id_reserva;

CREATE TABLE bam.TB_PERIODICO (
                id_periodico INTEGER NOT NULL,
                id_obra INTEGER NOT NULL,
                dt_publicacao DATE NOT NULL,
                CONSTRAINT id_periodico PRIMARY KEY (id_periodico)
);


CREATE TABLE bam.TB_PERIODICO_ARTIGO (
                id_periodico INTEGER NOT NULL,
                id_artigo INTEGER NOT NULL,
                CONSTRAINT id_periodico_artigo PRIMARY KEY (id_periodico, id_artigo)
);


CREATE TABLE bam.TB_ENCICLOPEDIA (
                id_enciclopedia INTEGER NOT NULL,
                id_obra INTEGER NOT NULL,
                ds_assunto VARCHAR NOT NULL,
                qtd_volumes INTEGER NOT NULL,
                CONSTRAINT id_enciclopedia PRIMARY KEY (id_enciclopedia)
);


CREATE TABLE bam.TB_LIVRO (
                id_livro INTEGER NOT NULL,
                id_obra INTEGER NOT NULL,
                ds_ibsn VARCHAR NOT NULL,
                st_referencia CHAR(1) NOT NULL,
                CONSTRAINT id_livro PRIMARY KEY (id_livro)
);


ALTER TABLE bam.TB_PESSOA ADD CONSTRAINT tb_tipo_pessoa_tb_pessoa_fk
FOREIGN KEY (id_tipo_pessoa)
REFERENCES bam.TB_TIPO_PESSOA (id_tipo_pessoa)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_OBRA ADD CONSTRAINT tb_tipo_obra_tb_obra_fk
FOREIGN KEY (id_tipo_obra)
REFERENCES bam.TB_TIPO_OBRA (id_tipo_obra)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_EMPRESTIMO ADD CONSTRAINT tb_pessoa_tb_emprestimo_fk
FOREIGN KEY (id_pessoa)
REFERENCES bam.TB_PESSOA (id_pessoa)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_ALUNO ADD CONSTRAINT tb_pessoa_tb_aluno_fk
FOREIGN KEY (id_pessoa)
REFERENCES bam.TB_PESSOA (id_pessoa)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_PROFESSOR ADD CONSTRAINT tb_pessoa_tb_professor_fk
FOREIGN KEY (id_pessoa)
REFERENCES bam.TB_PESSOA (id_pessoa)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_RESERVA ADD CONSTRAINT tb_pessoa_tb_reserva_fk
FOREIGN KEY (id_pessoa)
REFERENCES bam.TB_PESSOA (id_pessoa)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_USUARIO ADD CONSTRAINT tb_pessoa_tb_usuario_fk
FOREIGN KEY (id_pessoa)
REFERENCES bam.TB_PESSOA (id_pessoa)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_OBRA_EMPRESTIMO ADD CONSTRAINT tb_emprestimo_tb_obras_emprestimo_fk
FOREIGN KEY (id_emprestimo)
REFERENCES bam.TB_EMPRESTIMO (id_emprestimo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_PERIODICO_ARTIGO ADD CONSTRAINT tb_artigo_tb_periodico_artigo_fk
FOREIGN KEY (id_artigo)
REFERENCES bam.TB_ARTIGO (id_artigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_OBRA ADD CONSTRAINT tb_autor_tb_obras_fk
FOREIGN KEY (id_autor)
REFERENCES bam.TB_AUTOR (id_autor)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_OBRA ADD CONSTRAINT tb_editora_tb_obras_fk
FOREIGN KEY (id_editora)
REFERENCES bam.TB_EDITORA (id_editora)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_LIVRO ADD CONSTRAINT tb_obras_tb_livro_fk
FOREIGN KEY (id_obra)
REFERENCES bam.TB_OBRA (id_obra)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_ENCICLOPEDIA ADD CONSTRAINT tb_obras_tb_enciclopedia_fk
FOREIGN KEY (id_obra)
REFERENCES bam.TB_OBRA (id_obra)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_PERIODICO ADD CONSTRAINT tb_obras_tb_periodico_fk
FOREIGN KEY (id_obra)
REFERENCES bam.TB_OBRA (id_obra)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_RESERVA ADD CONSTRAINT tb_obras_tb_reserva_fk
FOREIGN KEY (id_obra)
REFERENCES bam.TB_OBRA (id_obra)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_OBRA_EMPRESTIMO ADD CONSTRAINT tb_obras_tb_obras_emprestimo_fk
FOREIGN KEY (id_obra)
REFERENCES bam.TB_OBRA (id_obra)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE bam.TB_PERIODICO_ARTIGO ADD CONSTRAINT tb_periodico_tb_periodico_artigo_fk
FOREIGN KEY (id_periodico)
REFERENCES bam.TB_PERIODICO (id_periodico)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
