package com.senac.biblioteca.osorio.ruan;

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
     * @param nome Nome da Editora.
     */
    public Editora(String nome) {
        this.nome = nome;
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
        return nome;
    }

    /**
     * Método para atribuir um nome a Editora.
     *
     * @param nome String - nome da Editora.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}
