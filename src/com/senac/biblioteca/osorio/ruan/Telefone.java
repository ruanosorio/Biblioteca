package com.senac.biblioteca.osorio.ruan;

/**
 * Classe para objetos do tipo Telefone
 *
 * @author Ruan Osório
 * @version 1
 */
public class Telefone {

    private int numero;

    /**
     * **************************CONSTRUTORES****************************
     */
    
    public Telefone() {
    }
    
    /**
     * Método constutor da classe Telefone.
     *
     * @param numero Numero do Telefone.
     */
    public Telefone(int numero) {
        this.numero = numero;
    }    
    
    
    /**
     * **************************GETS e SETS****************************
     */
    /**
     * Método para retornar o numero do Telefone.
     *
     * @return int - numero.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Método para atribuir um numero ao Telefone.
     *
     * @param numero int - numero do Telefone.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

}
