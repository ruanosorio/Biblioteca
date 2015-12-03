package com.senac.biblioteca.bean;

import com.towel.el.annotation.Resolvable;
import java.util.Objects;

/**
 * Classe para objetos do tipo Categoria livro
 *
 * @author Ruan Osório
 * @version 1
 */
public class Categoria {
    
    private int id;
    @Resolvable(colName = "Categoria Livro")
    private String nome;

    public Categoria() {
    }

    public Categoria(String p_nome) {
        this.nome = p_nome;
    }
            
    public String getNome() {
        return this.nome;
    }

    public void setNome(String p_nome) {
        this.nome = p_nome;
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
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    
    //metodo toString sobreescrito
    @Override
    public String toString() {
        return this.nome;
    }

        
}
