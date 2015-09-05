package com.senac.biblioteca.bean;

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
     * @param p_dtEmprestimo Data do Emprestimo do Livro.
     * @param p_dtDevolucao Data de Devolucao Emprestimo do Livro.
     */
    public Emprestimo(Date p_dtEmprestimo, Date p_dtDevolucao) {
        this.dtEmprestimo = dtEmprestimo;
        this.dtDevolucao = p_dtDevolucao;
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
        return this.dtEmprestimo;
    }

    /**
     * Método para atribuir uma data de Emprestimo.
     *
     * @param p_dtEmprestimo Date - data do Emprestimo.
     */
    public void setDtEmprestimo(Date p_dtEmprestimo) {
        this.dtEmprestimo = p_dtEmprestimo;
    }

    /**
     * Método para retornar a data de devolucao do Emprestimo.
     *
     * @return Date - dtDevolucao.
     */
    public Date getDtDevoluco() {
        return this.dtDevolucao;
    }

    /**
     * Método para atribuir uma data de devolucao do Emprestimo.
     *
     * @param p_dtDevolucao Date - data de devolucao do Emprestimo.
     */
    public void setDtDevolucao(Date p_dtDevolucao) {
        this.dtDevolucao = p_dtDevolucao;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "dtEmprestimo=" + dtEmprestimo + ", dtDevolucao=" + dtDevolucao + '}';
    }

     
}
