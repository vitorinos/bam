/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.dao;

import Util.Constantes;
import Util.HibernateUtil;
import dados.entidade.Livro;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Jacob Vilar
 */
public class LivroDAO implements DAO<Livro> {
    private Livro livro;
    private Criteria criteria;

    @Override
    public void incluir(Livro livro) throws Exception {
        getSessao().persist(livro);
        getSessao().flush();
    }

    @Override
    public void alterar(Livro livro) throws Exception {
        getSessao().update(livro);
        getSessao().flush();
    }

    @Override
    public void excluir(Integer id) throws Exception {
        livro = new Livro(id);
        getSessao().delete(livro);
        getSessao().flush();
    }

    @Override
    public Livro consultar(Integer id) throws Exception {
        getCriteria();
        criteria.add(Restrictions.eq(Constantes.ID_LIVRO, id));
        return (Livro) criteria.uniqueResult();
    }

    @Override
    public List<Livro> listar() throws Exception {
        getCriteria();
        return criteria.list();
    }

    @Override
    public List<Livro> consultarPorExemplo(Livro livro) throws Exception {
        getCriteria();
        criteria.add(Restrictions.eq(Constantes.ID_LIVRO, livro.getIdLivro()));
        criteria.add(Restrictions.eq(Constantes.DS_IBSN, livro.getDsIbsn()));
        criteria.add(Restrictions.eq(Constantes.ST_REFERENCIA, livro.getStReferencia()));
        return criteria.list();
    }

    @Override
    public Session getSessao() throws Exception {
        return HibernateUtil.getInstance().getSessao();
    }

    @Override
    public void getCriteria() throws Exception {
        criteria = getSessao().createCriteria(Livro.class);
    }
}