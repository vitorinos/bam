package br.iesb.bam.dados.entidade;

import java.util.Date;

public class Emprestimo {

    private Integer id_emprestimo;
    private Integer nr_matricula;
    private Date    dt_emprestimo;
    private Date    dt_devolucao;
    private Integer ds_prazo;

    public Integer getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(Integer id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public Integer getNr_matricula() {
        return nr_matricula;
    }

    public void setNr_matricula(Integer nr_matricula) {
        this.nr_matricula = nr_matricula;
    }

    public Date getDt_emprestimo() {
        return dt_emprestimo;
    }

    public void setDt_emprestimo(Date dt_emprestimo) {
        this.dt_emprestimo = dt_emprestimo;
    }

    public Date getDt_devolucao() {
        return dt_devolucao;
    }

    public void setDt_devolucao(Date dt_devolucao) {
        this.dt_devolucao = dt_devolucao;
    }

    public Integer getDs_prazo() {
        return ds_prazo;
    }

    public void setDs_prazo(Integer ds_prazo) {
        this.ds_prazo = ds_prazo;
    }
}
