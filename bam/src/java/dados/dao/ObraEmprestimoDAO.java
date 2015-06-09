package dados.dao;

import br.iesb.bam.dados.entidade.ObraEmprestimo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import org.hibernate.Session;

public class ObraEmprestimoDAO implements DAO<ObraEmprestimo>{

    @Override
    public void incluir(ObraEmprestimo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void incluir(List<ObraEmprestimo> lista) throws Exception {

    }

    @Override
    public void alterar(ObraEmprestimo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObraEmprestimo consultar(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ObraEmprestimo> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ObraEmprestimo> consultarPorExemplo(ObraEmprestimo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Session getSessao() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getCriteria() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
