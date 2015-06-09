package dados.dao;

import Util.Constantes;
import Util.HibernateUtil;
import dados.entidade.Editora;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class EditoraDAO implements DAO<Editora>{
    private Editora editora;
    private List<Editora> editoras;
    private Criteria criteria;
    
    @Override
    public void incluir(Editora editora) throws Exception {
        getSessao().persist(editora);
        getSessao().flush();
    }

    @Override
    public void alterar(Editora editora) throws Exception {
        getSessao().update(editora);
        getSessao().flush();
    }

    @Override
    public void excluir(Integer id) throws Exception {
        editora = new Editora();
        editora.setIdEditora(id);
        getSessao().delete(editora);
        getSessao().flush();
    }

    @Override
    public Editora consultar(Integer id) throws Exception {
        getCriteria();
        criteria.add(Restrictions.eq(Constantes.ID_EDITORA, id));
        return (Editora) criteria.uniqueResult();
    }

    @Override
    public List<Editora> listar() throws Exception {
        getCriteria();
        return criteria.list();
    }

    @Override
    public List<Editora> consultarPorExemplo(Editora editora) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Session getSessao() throws Exception {
        return HibernateUtil.getInstance().getSessao();
    }

    @Override
    public void getCriteria() throws Exception {
        criteria = getSessao().createCriteria(Editora.class);
    }
}
