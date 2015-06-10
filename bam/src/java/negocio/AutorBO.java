package negocio;

import Util.Constantes;
import dados.dao.AutorDAO;
import dados.entidade.Autor;
import exception.AlertaException;
import java.util.List;
import exception.ErroException;
import exception.GenericaException;

/**
 *
 * @author Jacob Vilar
 */
public class AutorBO {
    
    private static AutorBO instance;

    private AutorBO() {
    }
    
    public static AutorBO getInstance() {
        if (instance == null) {
            instance = new AutorBO();
        }
        return instance;
    }
    
    public void incluir(Autor autor) throws ErroException {
        try {
            AutorDAO.getInstance().incluir(autor);
        } catch (Exception e) {
            new ErroException(e.getMessage());
        }
    }

    public void alterar(Autor autor) throws Exception {
        AutorDAO.getInstance().alterar(autor);
    }

    public void excluir(Integer id) throws Exception {
        AutorDAO.getInstance().excluir(id);
    }

    public Autor consultarPorId(Integer id) throws Exception {
        return AutorDAO.getInstance().consultar(id);
    }

    public List<Autor> consultarPorNome(String nome) throws GenericaException, Exception {
        List<Autor> autores = AutorDAO.getInstance().consultarPorNome(nome);
        if(autores == null || autores.isEmpty()) {
            throw new AlertaException(Constantes.MSGA2);
        }
        return autores;
    }

    public List<Autor> listar() throws Exception {
        return AutorDAO.getInstance().listar();
    }

    public List<Autor> consultarPorExemplo(Autor autor) throws Exception {
        return AutorDAO.getInstance().consultarPorExemplo(autor);
    }
}