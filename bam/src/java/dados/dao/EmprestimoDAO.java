package dados.dao;

import br.iesb.bam.dados.entidade.Emprestimo;
import java.util.List;
import org.hibernate.Session;

public class EmprestimoDAO implements DAO<Emprestimo>{
    
    private Emprestimo emprestimo;
    private List<Emprestimo> emprestimos;
    
    public Emprestimo incluirComRetorno(Emprestimo emprestimo) throws Exception {

        return this.emprestimo;
    }

    @Override
    public void alterar(Emprestimo emprestimo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Emprestimo consultar(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Emprestimo> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Emprestimo> consultarPorExemplo(Emprestimo emprestimo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void incluir(Emprestimo t) throws Exception {
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
