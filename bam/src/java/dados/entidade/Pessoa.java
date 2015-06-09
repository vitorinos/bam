package dados.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa", schema = "bam")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

    @Id
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(name = "nr_matricula")
    private Integer nrMatricula;

    @Column(name = "nm_pessoa")
    private String nmPessoa;

    @Column(name = "id_tipo_pessoa")
    private TipoPessoa tipoPessoa;

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Integer getNrMatricula() {
        return nrMatricula;
    }

    public void setNrMatricula(Integer nrMatricula) {
        this.nrMatricula = nrMatricula;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }
}
