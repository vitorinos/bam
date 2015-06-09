package dados.dao;

import Util.Constantes;
import Util.HibernateUtil;
import dados.entidade.TipoObra;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class TipoObraDAO extends Constantes implements DAO<TipoObra> {

    private TipoObra tipoObra;
    private Criteria criteria;
    private static TipoObraDAO instancia;

    public static TipoObraDAO getInstance() {
        if (instancia == null) {
            instancia = new TipoObraDAO();
        }
        return instancia;
    }

    private TipoObraDAO() {
    }

    @Override
    public void incluir(TipoObra tipoObra) throws Exception {
        getSessao().persist(tipoObra);
        getSessao().flush();
    }

    @Override
    public void alterar(TipoObra tipoObra) throws Exception {
        getSessao().update(tipoObra);
        getSessao().flush();
    }

    @Override
    public void excluir(Integer id) throws Exception {
        tipoObra = new TipoObra();
        tipoObra.setIdTipoObra(id);
        getSessao().delete(tipoObra);
    }

    @Override
    public TipoObra consultar(Integer id) throws Exception {
        getCriteria();
        criteria.add(Restrictions.eq(ID_TIPO_OBRA, id));
        return (TipoObra) criteria.uniqueResult();
    }

    public List<TipoObra> consultarPorNome(String nome) throws Exception {
        getCriteria();
        criteria.add(Restrictions.ilike(NM_TIPO_OBRA, nome.toLowerCase(), MatchMode.START));
        return criteria.list();
    }

    @Override
    public List<TipoObra> listar() throws Exception {
        getCriteria();
        return criteria.list();
    }

    @Override
    public List<TipoObra> consultarPorExemplo(TipoObra tipoObra) throws Exception {
        getCriteria();
        criteria.add(Restrictions.eq(ID_TIPO_OBRA, tipoObra.getIdTipoObra()));
        criteria.add(Restrictions.eq(NM_TIPO_OBRA, tipoObra.getNmTipoObra()));
        return (List<TipoObra>) criteria.uniqueResult();
    }

    @Override
    public Session getSessao() throws Exception {
        return HibernateUtil.getInstance().getSessao();
    }

    @Override
    public void getCriteria() throws Exception {
        criteria = getSessao().createCriteria(TipoObra.class);
    }
}
