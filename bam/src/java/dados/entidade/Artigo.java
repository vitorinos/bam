package br.iesb.bam.dados.entidade;

import java.util.Date;

public class Artigo {
	private Integer id_artigo;
	private Date dt_publicacao;

	public Integer getId_artigo() {
		return id_artigo;
	}

	public void setId_artigo(Integer id_artigo) {
		this.id_artigo = id_artigo;
	}

	public Date getDt_publicacao() {
		return dt_publicacao;
	}

	public void setDt_publicacao(Date dt_publicacao) {
		this.dt_publicacao = dt_publicacao;
	}
}
