package dados.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_livro", schema = "bam")
public class Livro extends Obra implements Serializable {

    @Column(name = "id_livro", insertable = false, updatable = false)
    private Integer idLivro;
    
    @Column(name = "ds_ibsn")
    private String dsIbsn;
    
    @Column(name = "st_referencia")
    private String stReferencia;

    public Livro() {
    }

    public Livro(Integer idLivro) {
        this.idLivro = idLivro;
    }
    
    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getDsIbsn() {
        return dsIbsn;
    }

    public void setDsIbsn(String dsIbsn) {
        this.dsIbsn = dsIbsn;
    }

    public String getStReferencia() {
        return stReferencia;
    }

    public void setStReferencia(String stReferencia) {
        this.stReferencia = stReferencia;
    }
}
