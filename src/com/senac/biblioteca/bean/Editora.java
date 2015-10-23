package com.senac.biblioteca.bean;

import java.util.Objects;

/**
 * Classe para objetos do tipo Editora
 *
 * @author Ruan Osório
 * @version 1
 */
public class Editora {
    
    private int id;
    private String nome;

    /**
     * **************************CONSTRUTORES****************************
     */
    
    public Editora() {
    
    }
    
    /**
     * Método constutor da classe Editora.
     *
     * @param p_nome Nome da Editora.
     */
    public Editora(String p_nome) {
        this.nome = p_nome;
    }

    /**
     * **************************GETS e SETS****************************
     */
    /**
     * Método para retornar o nome da Editora.
     *
     * @return String - nome.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método para atribuir um nome a Editora.
     *
     * @param p_nome String - nome da Editora.
     */
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
        int hash = 5;
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
        final Editora other = (Editora) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Editora{" + "nome=" + nome + '}';
    }

 }
