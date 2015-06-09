package beans;

import dados.dao.AutorDAO;
import dados.dao.EditoraDAO;
import dados.dao.ObraDAO;
import dados.dao.TipoObraDAO;
import dados.entidade.Autor;
import dados.entidade.Editora;
import dados.entidade.Obra;
import dados.entidade.TipoObra;
import exception.AlertaException;
import exception.ErroException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import negocio.ObraBO;

/**
 *
 * @author jacob.santana
 */
@SessionScoped
@Named(value = "obraBean")
public class ObraBean extends BeanAbstrato implements Serializable {
    
    private Obra obra;
    private List<Obra> obras;
    private List<Editora> editoras;
    private List<Autor> autores;
    private List<TipoObra> tiposDeObra;
    
    public ObraBean() {
        try {
            this.editoras = EditoraDAO.getInstance().listar();
            this.autores = AutorDAO.getInstance().listar();
            this.tiposDeObra = TipoObraDAO.getInstance().listar();
        } catch (Exception ex) {
            adicionaMensagemErro(new ErroException(ex.getMessage()));
        }
    }
    
    public String abrirFormConsulta() {
        return TELA_PRINCIPAL;
    }
    
    public String abrirFormInclusao() {
        return TELA_INCLUSAO_OBRA;
    }
    
    public String consultar() {
        try {
            obras = ObraBO.getInstance().consultarObraPorExemplo(obra);
        } catch (AlertaException alerta) {
            adicionaMensagemAlerta(alerta);
        } catch (Exception e) {
            adicionaMensagemErro(new ErroException(e.getMessage()));
        }
        return abrirFormConsulta();
    }
    
    public List<Editora> getEditoras() {
        return editoras;
    }
    
    public void setEditoras(List<Editora> editoras) {
        this.editoras = editoras;
    }
    
    public List<Autor> getAutores() {
        return autores;
    }
    
    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
    
    public Obra getObra() {
        return obra;
    }
    
    public void setObra(Obra obra) {
        this.obra = obra;
    }
    
    public List<TipoObra> getTiposDeObra() {
        return tiposDeObra;
    }
    
    public void setTiposDeObra(List<TipoObra> tiposDeObra) {
        this.tiposDeObra = tiposDeObra;
    }
    
    public List<Obra> getObras() {
        return obras;
    }
    
    public void setObras(List<Obra> obras) {
        this.obras = obras;
    }
}
