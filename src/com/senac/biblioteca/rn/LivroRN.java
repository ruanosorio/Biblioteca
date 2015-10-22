package com.senac.biblioteca.rn;

import com.senac.biblioteca.bean.GeraId;
import com.senac.biblioteca.bean.Livro;
import com.senac.biblioteca.rnval.LivroRNVAL;
import java.util.ArrayList;


/**
 *
 * @author ruans
 */
public class LivroRN {
 
    private static ArrayList<Livro> livros = new ArrayList<>();
    
        
    public static void addLivro(Livro p_livro) {
        p_livro.setId(GeraId.getIdLivro());
        livros.add(p_livro);
    }
    
    public static Livro buscaLivro(int p_id) throws LivroRNVAL{
        for(Livro p_livro : livros){
           if(p_livro.getId() == p_id ){
               return p_livro;
           }               
        }
        
        throw new LivroRNVAL("Livro não encontrado!!! RN");
    }
     
    public static void excluirLivro(int p_livro){
        livros.remove(p_livro);
    }
    
    
    
}
