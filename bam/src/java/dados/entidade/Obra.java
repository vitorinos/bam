package dados.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_obras", schema = "bam")
@Inheritance(strategy = InheritanceType.JOINED)
public class Obra implements Serializable {

    @Id
    @SequenceGenerator(name = "tb_obra_id_obra_seq", sequenceName = "bam.tb_obra_id_obra_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_obra_id_obra_seq")
    @Column(name = "id_obra")
    private Integer idObra;

    @Column(name = "id_editora")
    private Editora editora;

    @Column(name = "id_autor")
    private Autor autor;

    @Column(name = "ds_titulo")
    private String dsTitulo;

    @Column(name = "id_tipo_obra")
    private TipoObra tipoObra;

    @Column(name = "qtd_exemplares")
    private Integer qtdExemplares;

    public Obra(Integer idObra) {
        this.idObra = idObra;
    }

    public Obra() {
    }

    public Integer getIdObra() {
        return idObra;
    }

    public void setIdObra(Integer idObra) {
        this.idObra = idObra;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getDsTitulo() {
        return dsTitulo;
    }

    public void setDsTitulo(String dsTitulo) {
        this.dsTitulo = dsTitulo;
    }

    public TipoObra getTipoObra() {
        return tipoObra;
    }

    public void setTipoObra(TipoObra tipoObra) {
        this.tipoObra = tipoObra;
    }

    public Integer getQtdExemplares() {
        return qtdExemplares;
    }

    public void setQtdExemplares(Integer qtdExemplares) {
        this.qtdExemplares = qtdExemplares;
    }
}
