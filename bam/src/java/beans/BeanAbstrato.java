package beans;

import Util.Constantes;
import exception.AlertaException;
import exception.ErroException;
import exception.InfoException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import negocio.AutorBO;

/**
 *
 * @author jacob.santana
 */
public abstract class BeanAbstrato {
    
    protected static final String USUARIO_LOGADO = "usuarioLogado";
    
    protected static final String TELA_PRINCIPAL = "/consultarObras";
    protected static final String TELA_LOGIN = "/login";
    
    protected static final String TELA_CONSULTA_AUTOR = "/restrito/manterAutor/consulta";
    protected static final String TELA_INCLUSAO_AUTOR = "/restrito/manterAutor/novo";

    protected void adicionaMensagemInfo(InfoException info) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.SUCESSO, info.getMessage()));
    }

    protected void adicionaMensagemAlerta(AlertaException alerta) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,Constantes.ALERTA, alerta.getMessage()));
    }

    protected void adicionaMensagemErro(ErroException erro) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERRO, erro.getMessage()));
    }

    protected AutorBO getAutorBO() {
        return new AutorBO();
    }
}
