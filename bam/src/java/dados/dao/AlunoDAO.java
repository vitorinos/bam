package dados.dao;

import Util.Constantes;
import Util.HibernateUtil;
import dados.entidade.Aluno;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class AlunoDAO implements DAO<Aluno> {

    private Aluno aluno;
    private List<Aluno> alunos;
    private Criteria criteria;

    @Override
    public void incluir(Aluno aluno) throws Exception {
        getSessao().persist(aluno);
        getSessao().flush();
    }

    @Override
    public void alterar(Aluno aluno) throws Exception {
        getSessao().update(aluno);
        getSessao().flush();
    }

    @Override
    public void excluir(Integer id) throws Exception {
        aluno = new Aluno();
        aluno.setIdAluno(id);
        getSessao().delete(aluno);
    }

    @Override
    public Aluno consultar(Integer id) throws Exception {
        getCriteria();
        criteria.add(Restrictions.eq(Constantes.NR_MATRICULA, id));
        return (Aluno) criteria.uniqueResult();
    }

    @Override
    public List<Aluno> listar() throws Exception {
        getCriteria();
        return criteria.list();
    }

    @Override
    public List<Aluno> consultarPorExemplo(Aluno aluno) throws Exception {
        getCriteria();
        criteria.add(Restrictions.eq(Constantes.NR_MATRICULA, aluno.getNmPessoa()));
        criteria.add(Restrictions.like(Constantes.DS_CURSO, aluno.getDsCurso()));
        alunos = criteria.list();
        return alunos;
    }

    @Override
    public Session getSessao() throws Exception {
        return HibernateUtil.getInstance().getSessao();
    }

    @Override
    public void getCriteria() throws Exception {
        criteria = getSessao().createCriteria(Aluno.class);
    }
}