package com.senac.biblioteca.rn;

import com.senac.biblioteca.bean.GeraId;
import com.senac.biblioteca.bean.Usuario;
import com.senac.biblioteca.rnval.UsuarioRNVAL;
import java.util.ArrayList;

/**
 *
 * @author ruans
 */
public class UsuarioRN {
    
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    
    public static void addUsuario(Usuario p_usuario) {
        p_usuario.setId(GeraId.getIdUsuario());
        usuarios.add(p_usuario);
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public static void excluirUsuario(int index) {
        usuarios.remove(index);
    }
    
    public static Usuario buscarUsuario(int id) throws UsuarioRNVAL {
        for(Usuario p_user : usuarios) {
            if(p_user.getId() == id) {
                return p_user;
            }
        }
        throw new UsuarioRNVAL("Usuário não encontrado! RN");
    }
}
