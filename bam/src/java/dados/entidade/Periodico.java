package dados.entidade;

import java.util.Date;

public class Periodico extends Obra {
	private Integer id_periodico;
	private Integer id_obra;
	private Date dt_publicacao;

	public Integer getId_periodico() {
		return id_periodico;
	}

	public void setId_periodico(Integer id_periodico) {
		this.id_periodico = id_periodico;
	}

	public Integer getId_obra() {
		return id_obra;
	}

	public void setId_obra(Integer id_obra) {
		this.id_obra = id_obra;
	}

	public Date getDt_publicacao() {
		return dt_publicacao;
	}

	public void setDt_publicacao(Date dt_publicacao) {
		this.dt_publicacao = dt_publicacao;
	}
}
