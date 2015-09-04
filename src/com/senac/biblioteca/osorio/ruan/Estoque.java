package com.senac.biblioteca.osorio.ruan;

/**
 * Classe para objetos do tipo Estoque
 *
 * @author Ruan Osório
 * @version 1
 */
public class Estoque {

    private int quantidade;
    private Livro livro;

    /**
     * **************************CONSTRUTORES****************************
     */
    
    public Estoque() {
    
    }
    
    /**
     * Método constutor da classe Estoque.
     *
     * @param quantidade Quantidade no Estoque.
     * @param livro Livro disponivel no Estoque.
     */
    public Estoque(int quantidade, Livro livro) {
        this.quantidade = quantidade;
        this.livro = livro;
    }

    /**
     * **************************GETS e SETS****************************
     */
    /**
     * Método para retornar a quantidade do livro no Estoque.
     *
     * @return int - quantidade.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Método para atribuir a quantidade do livro no Estoque.
     *
     * @param quantidade int - quantidade no Estoque.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Método para retorno do Livro no Estoque.
     *
     * @return livro - Livro.
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * Método para atribuir um Livro ao Estoque.
     *
     * @param livro Livro - Livro ao Estoque.
     */
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

}
