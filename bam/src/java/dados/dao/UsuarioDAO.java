package dados.dao;

import Util.Constantes;
import Util.HibernateUtil;
import dados.entidade.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jacob.santana
 */
public class UsuarioDAO {

    Criteria criteria;

    private static UsuarioDAO instancia;

    public static synchronized UsuarioDAO getInstance() {
        if (instancia == null) {
            instancia = new UsuarioDAO();
        }
        return instancia;
    }

    public Usuario consultaUsuarioPorNome(Usuario usuario) throws Exception {
        getCriteria();
        criteria.add(Restrictions.eq(Constantes.NM_USUARIO, usuario.getNmUsuario()));
        criteria.add(Restrictions.eq(Constantes.DS_SENHA, usuario.getDsSenha()));
        return (Usuario) criteria.uniqueResult();
    }

    public Session getSessao() throws Exception {
        return HibernateUtil.getInstance().getSessao();
    }

    public void getCriteria() throws Exception {
        criteria = getSessao().createCriteria(Usuario.class);
    }
}
