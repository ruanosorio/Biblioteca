package com.senac.biblioteca.bean;

import com.towel.el.annotation.Resolvable;
import java.util.Objects;

/**
 * Classe para objetos do tipo Livro
 *
 * @author Ruan Osório
 * @version 1
 */
public class Livro {
    
    
    private Integer id;
    @Resolvable(colName = "Título")
    private String titulo;
    @Resolvable(colName = "Autor")
    private String autor;
    @Resolvable(colName = "ISBN")
    private String isbn;
    @Resolvable(colName = "Ano")
    private int ano;
    private Editora editora = new Editora();
    @Resolvable(colName = "Descrição")
    private String descricao;    
    private Categoria categoria = new Categoria();

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
     * @param p_isbn Código isbn do Livro.
     * @param p_ano Ano de publicação do Livro.
     * @param p_editora Editora do Livro.
     * @param p_descricao Descrição do Livro.
     * @param p_categoria Categoria do Livro
     */
    public Livro(String p_titulo, String p_autor, String p_isbn, int p_ano, Editora p_editora, String p_descricao, Categoria p_categoria) {
        this.titulo = p_titulo;
        this.autor = p_autor;
        this.isbn = p_isbn;
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
     * Método para retorno do código isbn do Livro.
     *
     * @return isbn String com o codigo isbn do Livro.
     */
    public String getIsbn() {
        return this.isbn;
    }

    /**
     * Método para atribuir um código isbn ao Livro.
     *
     * @param p_isbn String com o código isbn do Livro.
     */
    public void setIsbn(String p_isbn) {
        this.isbn = p_isbn;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Livro other = (Livro) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (this.ano != other.ano) {
            return false;
        }
        if (!Objects.equals(this.editora, other.editora)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return true;
    }
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", autor=" + autor + ", ISBN=" + isbn + ", ano=" + ano + ", editora=" + editora + ", descricao=" + descricao + ", categoria=" + categoria.getNome() + '}';
    }
    
    
    
}
