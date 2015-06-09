package dados.dao;

import java.util.List;
import org.hibernate.Session;

public interface DAO<T> {

    void incluir(T t) throws Exception;

    void alterar(T t) throws Exception;

    void excluir(Integer id) throws Exception;

    T consultar(Integer id) throws Exception;

    List<T> listar() throws Exception;
    
    List<T> consultarPorExemplo(T t) throws Exception;
    
    Session getSessao() throws Exception;
    
    void getCriteria() throws Exception;
}
