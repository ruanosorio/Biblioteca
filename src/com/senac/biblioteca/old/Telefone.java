package com.senac.biblioteca.old;

/**
 * Classe para objetos do tipo Telefone
 *
 * @author Ruan Osório
 * @version 1
 */
public class Telefone {

    private int numero;
    private int ddd;

    /**
     * **************************CONSTRUTORES****************************
     */
    
    public Telefone() {
    }
    
    /**
     * Método constutor da classe Telefone.
     *
     * @param p_numero Numero do Telefone.
     * @param p_ddd DDD do Telefone.
     */
    public Telefone(int p_numero, int p_ddd) {
        this.numero = p_numero;
        this.ddd = p_ddd;
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
        return this.numero;
    }

    /**
     * Método para atribuir um numero ao Telefone.
     *
     * @param p_numero int - numero do Telefone.
     */
    public void setNumero(int p_numero) {
        this.numero = p_numero;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    @Override
    public String toString() {
        return "Telefone{" + "numero=" + numero + ", ddd=" + ddd + '}';
    }
        
    
}
