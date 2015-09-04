package com.senac.biblioteca.osorio.ruan;

/**
 * Classe para objetos do tipo Livro
 *
 * @author Ruan Osório
 * @version 1
 */
public class Livro {

    private String titulo;
    private String autor;
    private String ISBN;
    private int ano;
    private Editora editora;
    private String descricao;

    /**
     * **************************CONSTRUTORES****************************
     */
    
    public Livro() {
    }
    
    /**
     * Método constutor da classe Livro
     *
     * @param titulo Título do Livro.
     * @param autor Autor do Livro.
     * @param isbn Código ISBN do Livro.
     * @param ano Ano de publicação do Livro.
     * @param editora Editora do Livro.
     * @param descricao Descrição do Livro.
     */
    public Livro(String titulo, String autor, String isbn, int ano, Editora editora, String descricao) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = isbn;
        this.ano = ano;
        this.editora = editora;
        this.descricao = descricao;
    }

    /**
     * **************************GETS e SETS****************************
     */
    /**
     * Método para retorno do título do Livro.
     *
     * @return String - titulo.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Método para atribuir um título ao Livro.
     *
     * @param titulo String com o titulo do Livro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método para retorno do autor do Livro.
     *
     * @return String - autor.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Método para atribuir um autor ao Livro.
     *
     * @param autor String com o autor do Livro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Método para retorno do código ISBN do Livro.
     *
     * @return isbn String com o codigo ISBN do Livro.
     */
    public String getIsbn() {
        return ISBN;
    }

    /**
     * Método para atribuir um código ISBN ao Livro.
     *
     * @param isbn String com o código ISBN do Livro.
     */
    public void setIsbn(String isbn) {
        this.ISBN = isbn;
    }

    /**
     * Método para retorno do ano de publicação do Livro.
     *
     * @return int - ano.
     */
    public int getAno() {
        return ano;
    }

    /**
     * Método para atribuir um ano de publicação ao Livro.
     *
     * @param ano int com o ano de publicação do Livro.
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Método para retorno da editora do Livro.
     *
     * @return editora do livro do tipo Class Editora.
     */
    public Editora getEditora() {
        return editora;
    }

    /**
     * Método para atribuir uma editora ao Livro.
     *
     * @return editora do livro do tipo Class Editora.
     */
    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    /**
     * Método para retorno da descrição do Livro.
     *
     * @return String - descricacao.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Método para atribuir uma descrição ao Livro.
     *
     * @param descricao String com a descricao do Livro.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
