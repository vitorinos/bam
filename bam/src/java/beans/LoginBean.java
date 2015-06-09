package beans;

import Session.SessionContext;
import Util.Constantes;
import dados.entidade.Usuario;
import exception.AlertaException;
import exception.ErroException;
import exception.GenericaException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import negocio.LoginBO;

/**
 *
 * @author jacob.santana
 */
@SessionScoped
@Named(value = "loginBean")
public class LoginBean extends BeanAbstrato implements Serializable {

    private Usuario usuario = new Usuario();

    @ManagedProperty(value = "#{loginBO}")
    private LoginBO loginBO;

    public LoginBean() {

    }

    public Usuario getUsuarioLogado() {
        return (Usuario) SessionContext.getInstance().getUsuarioLogado();
    }

    public String abrirFormLogin() {
        return TELA_LOGIN;
    }

    public String autenticar() {
        String retorno = null;
        try {
            validarCamposObrigatorios();
            Usuario usuarioBD = LoginBO.getInstance().isUsuarioValido(usuario);
            if (usuarioBD != null) {
                retorno = TELA_PRINCIPAL;
                SessionContext.getInstance().setAttribute(USUARIO_LOGADO, usuarioBD);
            } else {
                adicionaMensagemAlerta(new AlertaException(Constantes.LOGIN_INVALIDO));
                FacesContext.getCurrentInstance().validationFailed();
                retorno = TELA_LOGIN;
            }
        } catch (AlertaException a) {
            adicionaMensagemAlerta(a);
        } catch (GenericaException g) {
            adicionaMensagemErro(new ErroException(g.getMessage()));
        }
        return retorno;
    }

    private void validarCamposObrigatorios() throws AlertaException {
        if (usuario.getNmUsuario().equals(STRING_BRANCO) || usuario.getDsSenha().equals(STRING_BRANCO)) {
            throw new AlertaException(Constantes.MSGA1);
        }
    }

    public String sair() {
        try {
            SessionContext.getInstance().encerrarSessao();
        } catch (Exception e) {
            adicionaMensagemErro(new ErroException(e.getMessage()));
        }
        return TELA_PRINCIPAL;
    }

    public void limpar() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LoginBO getLoginBO() {
        return loginBO;
    }

    public void setLoginBO(LoginBO loginBO) {
        this.loginBO = loginBO;
    }
}
