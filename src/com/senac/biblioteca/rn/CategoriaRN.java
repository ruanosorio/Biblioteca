/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.biblioteca.rn;

import com.senac.biblioteca.bd.CategoriaBD;
import com.senac.biblioteca.bean.Categoria;
import java.util.List;

/**
 *
 * @author ruans
 */
public class CategoriaRN {
    
    CategoriaBD bd;
    
    public CategoriaRN() {
        bd = new CategoriaBD();
    }
    
    public void salvar(Categoria p_categoria) {
        bd.salvar(p_categoria);
    }
    
    public void editar(Categoria p_categoria) {
        bd.editar(p_categoria);
    }
    
    public List<Categoria> listaLivro() {
        return bd.listaCategoria();
    }
    
    public void excluir(Categoria p_categoria) {
        bd.excluir(p_categoria);
    }
    
}
