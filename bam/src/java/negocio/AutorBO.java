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
    private AutorDAO getAutorDAO() {
        return new AutorDAO();
    }
    
    public void incluir(Autor autor) throws ErroException {
        try {
            getAutorDAO().incluir(autor);
        } catch (Exception e) {
            new ErroException(e.getMessage());
        }
    }

    public void alterar(Autor autor) throws Exception {
        getAutorDAO().alterar(autor);
    }

    public void excluir(Integer id) throws Exception {
        getAutorDAO().excluir(id);
    }

    public Autor consultarPorId(Integer id) throws Exception {
        return getAutorDAO().consultar(id);
    }

    public List<Autor> consultarPorNome(String nome) throws GenericaException, Exception {
        List<Autor> autores = getAutorDAO().consultarPorNome(nome);
        if(autores == null || autores.isEmpty()) {
            throw new AlertaException(Constantes.MSGA2);
        }
        return getAutorDAO().consultarPorNome(nome);
    }

    public List<Autor> listar() throws Exception {
        return getAutorDAO().listar();
    }

    public List<Autor> consultarPorExemplo(Autor autor) throws Exception {
        return getAutorDAO().consultarPorExemplo(autor);
    }
}