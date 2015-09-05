package com.senac.biblioteca.bean;

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
    private Categoria categoria;

    /**
     * **************************CONSTRUTORES****************************
     */
    
    public Livro() {
    }
    
    /**
     * Método constutor da classe Livro
     *
     * @param p_titulo Título do Livro.
     * @param p_autor Autor do Livro.
     * @param p_isbn Código ISBN do Livro.
     * @param p_ano Ano de publicação do Livro.
     * @param p_editora Editora do Livro.
     * @param p_descricao Descrição do Livro.
     * @param p_categoria Categoria do Livro
     */
    public Livro(String p_titulo, String p_autor, String p_isbn, int p_ano, Editora p_editora, String p_descricao, Categoria p_categoria) {
        this.titulo = p_titulo;
        this.autor = p_autor;
        this.ISBN = p_isbn;
        this.ano = p_ano;
        this.editora = p_editora;
        this.descricao = p_descricao;
        this.categoria = p_categoria;
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
        return this.titulo;
    }

    /**
     * Método para atribuir um título ao Livro.
     *
     * @param p_titulo String com o titulo do Livro.
     */
    public void setTitulo(String p_titulo) {
        this.titulo = p_titulo;
    }

    /**
     * Método para retorno do autor do Livro.
     *
     * @return String - autor.
     */
    public String getAutor() {
        return this.autor;
    }

    /**
     * Método para atribuir um autor ao Livro.
     *
     * @param p_autor String com o autor do Livro.
     */
    public void setAutor(String p_autor) {
        this.autor = p_autor;
    }

    /**
     * Método para retorno do código ISBN do Livro.
     *
     * @return isbn String com o codigo ISBN do Livro.
     */
    public String getISBN() {
        return this.ISBN;
    }

    /**
     * Método para atribuir um código ISBN ao Livro.
     *
     * @param p_isbn String com o código ISBN do Livro.
     */
    public void setISBN(String p_isbn) {
        this.ISBN = p_isbn;
    }

    /**
     * Método para retorno do ano de publicação do Livro.
     *
     * @return int - ano.
     */
    public int getAno() {
        return this.ano;
    }

    /**
     * Método para atribuir um ano de publicação ao Livro.
     *
     * @param p_ano int com o ano de publicação do Livro.
     */
    public void setAno(int p_ano) {
        this.ano = p_ano;
    }

    /**
     * Método para retorno da editora do Livro.
     *
     * @return editora do livro do tipo Class Editora.
     */
    public Editora getEditora() {
        return this.editora;
    }

    /**
     * Método para atribuir uma editora ao Livro.
     *
     * @param editora do livro do tipo Class Editora.
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
        return this.descricao;
    }

    /**
     * Método para atribuir uma descrição ao Livro.
     *
     * @param descricao String com a descricao do Livro.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", autor=" + autor + ", ISBN=" + ISBN + ", ano=" + ano + ", editora=" + editora + ", descricao=" + descricao + ", categoria=" + categoria + '}';
    }
    
    
    
}
