package com.senac.biblioteca.bean;

/**
 * Classe para objetos do tipo Editora
 *
 * @author Ruan Osório
 * @version 1
 */
public class Editora {

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

    @Override
    public String toString() {
        return "Editora{" + "nome=" + nome + '}';
    }

 }
