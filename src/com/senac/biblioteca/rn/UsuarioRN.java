package com.senac.biblioteca.rn;

import com.senac.biblioteca.bd.UsuarioBD;
import com.senac.biblioteca.old.GeraId;
import com.senac.biblioteca.bean.Usuario;
import com.senac.biblioteca.rnval.UsuarioRNVAL;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ruans
 */
public class UsuarioRN {
    
    UsuarioBD bd;
    
    public UsuarioRN() {
        bd  = new UsuarioBD();
    }
 
    public void salvar(Usuario p_usuario){
        bd.salvar(p_usuario);
    }

    public void editar(Usuario p_usuario){
        bd.editar(p_usuario);
    }
    
    public List<Usuario> listaUsuario(){
        return bd.listaUsuario();
    }
    
    public void excluir(Usuario p_usuario){
        bd.excluir(p_usuario);
    }
}
