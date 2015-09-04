package com.senac.biblioteca.osorio.ruan;

import java.util.Date;

/**
 * Classe para objetos do tipo Emprestimo
 *
 * @author Ruan Osório
 * @version 1
 */
public class Emprestimo {

    private Date dtEmprestimo;
    private Date dtDevolucao;

    /**
     * **************************CONSTRUTORES****************************
     */
    
    public Emprestimo() {
    }
    
    /**
     * Método constutor da classe Emprestimo.
     *
     * @param dtEmprestimo Data do Emprestimo do Livro.
     * @param dtDevolucao Data de Devolucao Emprestimo do Livro.
     */
    public Emprestimo(Date dtEmprestimo, Date dtDevolucao) {
        this.dtEmprestimo = dtEmprestimo;
        this.dtDevolucao = dtDevolucao;
    }

    /**
     * **************************GETS e SETS****************************
     */
    /**
     * Método para retornar a data do emprestimo do Emprestimo.
     *
     * @return Date - DtEmprestimo.
     */
    public Date getDtEmprestimo() {
        return dtEmprestimo;
    }

    /**
     * Método para atribuir uma data de Emprestimo.
     *
     * @param dtEmprestimo Date - data do Emprestimo.
     */
    public void setDtEmprestimo(Date dtEmprestimo) {
        this.dtEmprestimo = dtEmprestimo;
    }

    /**
     * Método para retornar a data de devolucao do Emprestimo.
     *
     * @return Date - dtDevolucao.
     */
    public Date getDtDevoluco() {
        return dtDevolucao;
    }

    /**
     * Método para atribuir uma data de devolucao do Emprestimo.
     *
     * @param dtDevolucao Date - data de devolucao do Emprestimo.
     */
    public void setDtDevolucao(Date dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }

}
