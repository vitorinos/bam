package dados.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_enciclopedia", schema = "bam")
public class Enciclopedia extends Obra implements Serializable {

    @Column(name = "id_enciclopedia", insertable = false, updatable = false)
    private Integer idEnciclopedia;
    
    private String dsAssunto;
    
    private Integer qtdVolumes;

    public Integer getIdEnciclopedia() {
        return idEnciclopedia;
    }

    public void setIdEnciclopedia(Integer idEnciclopedia) {
        this.idEnciclopedia = idEnciclopedia;
    }

    public String getDsAssunto() {
        return dsAssunto;
    }

    public void setDsAssunto(String dsAssunto) {
        this.dsAssunto = dsAssunto;
    }

    public Integer getQtdVolumes() {
        return qtdVolumes;
    }

    public void setQtdVolumes(Integer qtdVolumes) {
        this.qtdVolumes = qtdVolumes;
    }

    public Enciclopedia(Integer idEnciclopedia) {
        this.idEnciclopedia = idEnciclopedia;
    }

    public Enciclopedia() {
    }
}
