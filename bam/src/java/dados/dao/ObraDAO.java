package dados.dao;

import Util.Constantes;
import Util.HibernateUtil;
import dados.entidade.Autor;
import dados.entidade.Editora;
import dados.entidade.Obra;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.apache.commons.lang.StringUtils;

public class ObraDAO implements DAO<Obra> {

    private Obra obra;
    private Criteria criteria;
    private static ObraDAO instance;

    private ObraDAO() {
    }

    public static ObraDAO getInstance() {
        if (instance == null) {
            instance = new ObraDAO();
        }
        return instance;
    }

    @Override
    public void incluir(Obra obras) throws Exception {
        getSessao().persist(obra);
        getSessao().flush();
    }

    @Override
    public void alterar(Obra obra) throws Exception {
        getSessao().update(obra);
        getSessao().flush();
    }

    @Override
    public List<Obra> listar() throws Exception {
        getCriteria();
        return criteria.list();

    }

    @Override
    public void excluir(Integer id) throws Exception {
        obra = new Obra(id);
        getSessao().delete(obra);
    }

    @Override
    public Obra consultar(Integer id) throws Exception {
        getCriteria();
        criteria.add(Restrictions.eq(Constantes.ID_OBRA, id));
        return (Obra) criteria.uniqueResult();
    }

    @Override
    public List<Obra> consultarPorExemplo(Obra obra) throws Exception {
        getCriteria();
        if (obra.getAutor().getIdAutor() != null) {
            criteria.add(Restrictions.eq("autor.idAutor", obra.getAutor().getIdAutor()));
        } else if (obra.getEditora().getIdEditora() != null) {
            criteria.add(Restrictions.eq("editora.idEditora", obra.getEditora().getIdEditora()));
        } else if (obra.getTipoObra().getIdTipoObra() != null) {
            criteria.add(Restrictions.eq("tipoObra.idTipoObra", obra.getTipoObra().getIdTipoObra()));
        } else if (!StringUtils.isBlank(obra.getDsTitulo())) {
            criteria.add(Restrictions.eq("dsTitulo", obra.getDsTitulo()));
        }
        return criteria.list();
    }

    public List<Obra> consultarObrasPorAutor(Autor autor) throws Exception {
        getCriteria();
        criteria.add(Restrictions.eq(Constantes.ID_AUTOR_OBRA, autor.getIdAutor()));
        return criteria.list();
    }

    public List<Obra> consultarObrasPorEditora(Editora editora) throws Exception {
        getCriteria();
        criteria.add(Restrictions.eq(Constantes.ID_EDITORA_OBRA, editora.getIdEditora()));
        return criteria.list();
    }

    @Override
    public Session getSessao() throws Exception {
        return HibernateUtil.getInstance().getSessao();
    }

    @Override
    public void getCriteria() throws Exception {
        criteria = getSessao().createCriteria(Obra.class);
    }
}
