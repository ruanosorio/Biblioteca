package com.senac.biblioteca.rn;

import com.senac.biblioteca.bd.LivroBD;
import com.senac.biblioteca.old.GeraId;
import com.senac.biblioteca.bean.Livro;
import com.senac.biblioteca.bean.Usuario;
import com.senac.biblioteca.infra.ValidacaoRNException;
import com.senac.biblioteca.rnval.LivroRNVAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author ruans
 */
public class LivroRN {
    
    LivroBD bd;
    
    public LivroRN() {
        bd = new LivroBD();
    }
    
    public void salvar(Livro p_livro) {
        //se o getId for null Salva se não Edita
        if(p_livro.getId() == null){
            bd.salvar(p_livro);
        } else {
            bd.editar(p_livro);
        }
    }
    
    public void editar(Livro p_livro) {
        bd.editar(p_livro);
    }
    
    public List<Livro> listaLivro() {
        return bd.listaLivro();
    }
    
    public void excluir(Livro p_livro) {
        bd.excluir(p_livro);
    }

    public Vector<Livro> pesquisar(String text)throws SQLException {
       return bd.pesquisar(text);
    }
