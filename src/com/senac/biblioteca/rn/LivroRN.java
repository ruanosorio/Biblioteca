package com.senac.biblioteca.rn;

import com.senac.biblioteca.bd.LivroBD;
import com.senac.biblioteca.bean.GeraId;
import com.senac.biblioteca.bean.Livro;
import com.senac.biblioteca.rnval.LivroRNVAL;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ruans
 */
public class LivroRN {
 
    LivroBD bd;
    
    public LivroRN() {
        bd  = new LivroBD();
    }
 
    public void salvar(Livro p_livro){
        bd.salvar(p_livro);
    }

    public void editar(Livro p_livro){
        bd.editar(p_livro);
    }
    
    public List<Livro> listaLivro(){
        return bd.listaLivro();
    }
    
    public void excluir(Livro p_livro){
        bd.excluir(p_livro);
    }
    
    
}
