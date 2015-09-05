package com.senac.biblioteca.bean;

/**
 * Classe para objetos do tipo Categoria livro
 *
 * @author Ruan Osório
 * @version 1
 */
public class Categoria {

    private String descricao;

    public Categoria() {
    }

    public Categoria(String p_descricao) {
        this.descricao = p_descricao;
    }
            
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String p_descricao) {
        this.descricao = p_descricao;
    }

    @Override
    public String toString() {
        return "Categoria{" + "descricao=" + descricao + '}';
    }

        
}
