package com.senac.biblioteca.bean;

import java.util.Objects;

/**
 * Classe para objetos do tipo Categoria livro
 *
 * @author Ruan Osório
 * @version 1
 */
public class Categoria {
    
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
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
        final Categoria other = (Categoria) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Categoria{" + "descricao=" + descricao + '}';
    }

        
}
