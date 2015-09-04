package com.senac.biblioteca.osorio.ruan;

/**
 * Classe para objetos do tipo Usuário
 *
 * @author Ruan Osório
 * @version 1
 */
public class Usuario {

    private int matricula;
    private String nome;
    private Telefone telefone;

    /**
     * **************************CONSTRUTORES****************************
     */
    
    public Usuario() {
    }
    
    /**
     * Método constutor da classe Usuário
     *
     * @param matricula Matricula do Usuário.
     * @param nome Nome do Usuário.
     * @param telefone Telefone do Usuário.
     */
    public Usuario(int matricula, String nome, Telefone telefone) {
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
    }
    

    /**
     * **************************GETS e SETS****************************
     */
    /**
     * Método para retornar a matricula do Usuário.
     *
     * @return int - matricula.
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * Método para atribuir uma matricula ao Usuário.
     *
     * @param matricula int - Matricula do Usuário.
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * Método para retornar o nome do Usuário.
     *
     * @return String - nome.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método para atribuir um nome ao Usuário.
     *
     * @param nome String - Nome do Usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método para retornar o telefone do Usuário.
     *
     * @return Telefone - telefone.
     */
    public Telefone getTelefone() {
        return telefone;
    }

    /**
     * Método para atribuir um telefone ao Usuário.
     *
     * @param telefone Telefone - Telefone do Usuário.
     */
    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

}
