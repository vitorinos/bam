package dados.dao;

import Util.HibernateUtil;
import dados.entidade.Professor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public class ProfessorDAO implements DAO<Professor> {

    private Professor professor;
    private List<Professor> professores;
    private Criteria criteria;

    @Override
    public void incluir(Professor professor) throws Exception {
        try {
            getSessao().persist(professor);
            getSessao().flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void alterar(Professor professor) throws Exception {

    }

    public void excluir(Integer nr_matricula) throws Exception {

    }

    public Professor consultar(Integer nr_matricula) throws Exception {

        return professor;
    }

    @Override
    public List<Professor> listar() throws Exception {
        getCriteria();
        professores = criteria.list();
        return professores;
    }

    @Override
    public List<Professor> consultarPorExemplo(Professor professor) throws Exception {

        return professores;
    }

    @Override
    public Session getSessao() throws Exception {
        return HibernateUtil.getInstance().getSessao();
    }

    @Override
    public void getCriteria() throws Exception {
        criteria = getSessao().createCriteria(Professor.class);
    }
}
