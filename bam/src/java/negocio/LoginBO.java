package negocio;

import dados.dao.UsuarioDAO;
import dados.entidade.Usuario;
import exception.ErroException;
import exception.GenericaException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author jacob.santana
 */
public class LoginBO {

    private static LoginBO instancia;

    public static LoginBO getInstance() {
        if (instancia == null) {
            instancia = new LoginBO();
        }
        return instancia;
    }

    public Usuario isUsuarioValido(Usuario usuario) throws GenericaException {
        Usuario usuarioDoBanco = null;
        try {
            String senha = encriptaSenha(usuario.getDsSenha());
            usuario.setDsSenha(senha);
            usuarioDoBanco = UsuarioDAO.getInstance().consultaUsuarioPorNome(usuario);
        } catch (Exception e) {
            throw new ErroException(e.getMessage());
        }
        return usuarioDoBanco;
    }

    public String encriptaSenha(String senha) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        return hash.toString(16);
    }
}
