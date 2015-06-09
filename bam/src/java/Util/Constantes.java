package Util;

public class Constantes {

    //Unidade de persistencia

    public static final String PERSISTENCE_UNIT_NAME = "bam_homologacao";

    //Propriedades dos objetos
    //autor
    public static final String ID_AUTOR = "idAutor";
    public static final String NM_AUTOR = "nmAutor";
    //aluno
    public static final String NR_MATRICULA = "nrMatricula";
    public static final String DS_CURSO = "dsCurso";
    //editora
    public static final String ID_EDITORA = "idEditora";
    public static final String NM_EDITORA = "nmEditora";
    //livro
    public static final String ID_LIVRO = "id_livro";
    public static final String DS_IBSN = "ds_ibsn";
    public static final String ST_REFERENCIA = "st_referencia";
    //usuario
    public static final String ID_USUARIO = "idUsuario";
    public static final String NM_USUARIO = "nmUsuario";
    public static final String DS_SENHA = "dsSenha";
    //obras
    public static final String ID_OBRA = "id_obra";
    public static final String ID_AUTOR_OBRA = "autor.idAutor";
    public static final String ID_EDITORA_OBRA = "editora.idEditora";

    //tipos de pessoa
    public static final String TIPO_ALUNO = "A";
    public static final String TIPO_PROFESSOR = "P";
    public static final String TIPO_FUNCIONARIO = "F";

    //mensagens
    //sucesso
    public static final String MSGS1 = "Registro incluído com sucesso";
    public static final String MSGS2 = "Registro alterado com sucesso";
    public static final String MSGS3 = "Registro excluido com sucesso";
    //alerta
    public static final String MSGA1 = "Campo(s) obrigatório(s) não informado(s)";
    public static final String MSGA2 = "Nenhum registro encontrado para os parâmetros informados.";
    public static final String MSGA3 = "Preencha pelo menos um parâmetro para consulta.";
    public static final String MSGA4 = "Tem certeza que excluir o(s) item(s) selecionado(s)?";
    public static final String MSGA5 = "Nenhum registro selecionado.";
    public static final String LOGIN_INVALIDO = "Usuário e/ou senha inválidos";
    public static final String ALERTA = "Alerta";
    public static final String ERRO = "Erro";
    public static final String SUCESSO = "Sucesso";
}
