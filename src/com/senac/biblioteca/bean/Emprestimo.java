package com.senac.biblioteca.bean;

import com.towel.el.annotation.Resolvable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Classe para objetos do tipo Emprestimo
 *
 * @author Ruan Osório
 * @version 1
 */
public class Emprestimo {

    private int id;
    @Resolvable(colName = "Nome do Usuário")
    private Usuario usuario;
    @Resolvable(colName = "Livro")
    private Livro livro;
    @Resolvable(colName = "Data do Empréstimo")
    private Date dtEmprestimo;
    @Resolvable(colName = "Data de Devolução")
    private Date dtDevolucao;
    @Resolvable(colName = "Devolvido")
    private String indDevolvido;

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
     * @param
     */
//    public Emprestimo(Date p_dtEmprestimo, Date p_dtDevolucao) {
//        this.dtEmprestimo = p_dtEmprestimo;
//        this.dtDevolucao = p_dtDevolucao;
//    }
    // 7 Dias em milisegundos
    //static final int DIAS_EMPRESTIMO = 60 * 60 * 24 * 7 * 1000;
    public Emprestimo(Usuario p_usuario, Livro p_livro) {
        this.livro = p_livro;
        this.usuario = p_usuario;
        dtEmprestimo = new Date(System.currentTimeMillis());
        //dtDevolucao = new Date(dtEmprestimo.getTime() + new Date(DIAS_EMPRESTIMO).getTime());

        Calendar calIni = Calendar.getInstance();
        calIni.setTime(dtEmprestimo);
        //adicionei 7dias do mes a data inicial, dessa forma obtenho a data de devolução
        calIni.add(Calendar.DAY_OF_MONTH, 7);

        dtDevolucao = new Date(calIni.getTimeInMillis());
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
    public Date getDtDevolucao() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getIndDevolvido() {
        return indDevolvido;
    }

    public void setIndDevolvido(String indDevolvido) {
        this.indDevolvido = indDevolvido;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Emprestimo other = (Emprestimo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.livro, other.livro)) {
            return false;
        }
        if (!Objects.equals(this.dtEmprestimo, other.dtEmprestimo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Livros Emprestados \n "
                + "Nome do Usuario = " + usuario.getNome() + " \n "
                + "Nome do Livro = " + livro.getTitulo() + " \n "
                + "Data de Emprestimo = " + dtEmprestimo
                + " "
                + "Data de Devolução = " + dtDevolucao;
    }

}
