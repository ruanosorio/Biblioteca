package com.senac.biblioteca.bean;

import java.util.Objects;

/**
 * Classe para objetos do tipo Estoque
 *
 * @author Ruan Osório
 * @version 1
 */
public class Estoque {
    
    private int id;
    private int quantidade;
    private Livro livro;

    /**
     * **************************CONSTRUTORES****************************
     */
    
    public Estoque() {
    
    }
    
    /**
     * Método constutor da classe Estoque.
     *
     * @param p_quantidade Quantidade no Estoque.
     * @param p_livro Livro disponivel no Estoque.
     */
    public Estoque(int p_quantidade, Livro p_livro) {
        this.quantidade = p_quantidade;
        this.livro = p_livro;
    }

    /**
     * **************************GETS e SETS****************************
     */
    /**
     * Método para retornar a quantidade do livro no Estoque.
     *
     * @return int - quantidade.
     */
    public int getQuantidade() {
        return this.quantidade;
    }

    /**
     * Método para atribuir a quantidade do livro no Estoque.
     *
     * @param p_quantidade int - quantidade no Estoque.
     */
    public void setQuantidade(int p_quantidade) {
        this.quantidade = p_quantidade;
    }

    /**
     * Método para retorno do Livro no Estoque.
     *
     * @return livro - Livro.
     */
    public Livro getLivro() {
        return this.livro;
    }

    /**
     * Método para atribuir um Livro ao Estoque.
     *
     * @param p_livro Livro - Livro ao Estoque.
     */
    public void setLivro(Livro p_livro) {
        this.livro = p_livro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final Estoque other = (Estoque) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.livro, other.livro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estoque{" + "quantidade=" + quantidade + ", livro=" + livro + '}';
    }

    
}
