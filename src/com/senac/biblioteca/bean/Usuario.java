package com.senac.biblioteca.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe para objetos do tipo Usuário
 *
 * @author Ruan Osório
 * @version 1
 */
public class Usuario {
    
    private int id;
    private int matricula;
    private String nome;
    private String telefone;
    private List<Emprestimo> emprestimoItems = new ArrayList<>();
    //private List<Emprestimo> emprestimoItems = new ArrayList<Emprestimo>();

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
    public Usuario(int matricula, String nome, String telefone) {
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
        return this.matricula;
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
        return this.nome;
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
     * @return String - this.telefone.
     */
    public String getTelefone() {
        return this.telefone;
    }

    /**
     * Método para atribuir um telefone ao Usuário.
     *
     * @param p_telefone String - Telefone do Usuário.
     */
    public void setTelefone(String p_telefone) {
        this.telefone = p_telefone;
    }

    public List<Emprestimo> getEmprestimosItems() {
        return this.emprestimoItems;
    }

    public void setEmprestimoItems(List<Emprestimo> p_emprestimoItems) {
        this.emprestimoItems = p_emprestimoItems;
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
        hash = 89 * hash + this.id;
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
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.matricula != other.matricula) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.emprestimoItems, other.emprestimoItems)) {
            return false;
        }
        return true;
    }
       
    
    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("Matricula: ");
        stringBuffer.append(this.matricula);
        stringBuffer.append(" Nome: ");
        stringBuffer.append(this.nome);
        stringBuffer.append(" Telefone: ");
        stringBuffer.append(this.telefone);       
        
        // pensar como implementar a estrutura adequada do emprestimo dos livros
        
//        StringBuffer.append("EmprestimoItems: ");
//        stringBuffer.append(this.emprestimoItems);

        return stringBuffer.toString();
    }
    
}
