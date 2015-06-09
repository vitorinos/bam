package dados.dao;

import Util.Constantes;
import Util.HibernateUtil;
import dados.entidade.Autor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class AutorDAO implements DAO<Autor> {

    private Autor autor;
    private Criteria criteria;

    @Override
    public void incluir(Autor autor) throws Exception {
        getSessao().persist(autor);
        getSessao().flush();
    }

    @Override
    public void alterar(Autor autor) throws Exception {
        getSessao().update(autor);
        getSessao().flush();
    }

    @Override
    public void excluir(Integer id) throws Exception {
        autor = new Autor();
        autor.setIdAutor(id);
        getSessao().delete(autor);
    }

    @Override
    public Autor consultar(Integer id) throws Exception {
        getCriteria();
        criteria.add(Restrictions.eq(Constantes.ID_AUTOR, id));
        return (Autor) criteria.uniqueResult();
    }

    public List<Autor> consultarPorNome(String nome) throws Exception {
        getCriteria();
        criteria.add(Restrictions.ilike(Constantes.NM_AUTOR, nome.toLowerCase(), MatchMode.START));
        return criteria.list();
    }

    @Override
    public List<Autor> listar() throws Exception {
        getCriteria();
        return criteria.list();
    }

    @Override
    public List<Autor> consultarPorExemplo(Autor autor) throws Exception {
        getCriteria();
        criteria.add(Restrictions.eq(Constantes.ID_AUTOR, autor.getIdAutor()));
        criteria.add(Restrictions.eq(Constantes.NM_AUTOR, autor.getNmAutor()));
        return (List<Autor>) criteria.uniqueResult();
    }

    @Override
    public Session getSessao() throws Exception {
        return HibernateUtil.getInstance().getSessao();
    }

    @Override
    public void getCriteria() throws Exception {
        criteria = getSessao().createCriteria(Autor.class);
    }
}
