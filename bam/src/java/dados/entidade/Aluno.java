package dados.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aluno", schema = "bam")
public class Aluno extends Pessoa implements Serializable {

    @Column(name = "id_pessoa", insertable = false, updatable = false)
    private Integer idAluno;

    @Column(name = "ds_curso")
    private String dsCurso;

    public Aluno() {
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public String getDsCurso() {
        return dsCurso;
    }

    public void setDsCurso(String dsCurso) {
        this.dsCurso = dsCurso;
    }
}
