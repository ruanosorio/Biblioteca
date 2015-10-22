/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.biblioteca.bd;

import com.senac.biblioteca.bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

/**
 *
 * @author Ruan Osorio
 */
public class UsuarioBD {

    static Logger log = Logger.getLogger(UsuarioBD.class);

    public void salvar(Usuario p_usuario) {
        Connection conn = null;
        try {

            log.info("Abrindo conexão com o banco");

            conn = ConexaoBD.getConexao();
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO usuario (matricula, nome, telefone) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            // pstm.setInt(1, p_usuario.getId());
            pstm.setInt(1, p_usuario.getMatricula());
            pstm.setString(2, p_usuario.getNome());
            pstm.setString(3, p_usuario.getTelefone());

            log.info("Inserindo usuário no banco de dados");

            pstm.executeUpdate();
            Long id = ConexaoBD.getLastKey(pstm);
            p_usuario.setId(id == null ? null : id.intValue());
            
//            ResultSet rs = pstm.getGeneratedKeys();
//            
//            if (rs.next()){
//                Long id = rs.getLong(1);
//                p_usuario.setId(id.intValue());
//            }
            log.info("ID criado = "+p_usuario.getId());
        } catch (Exception e) {
            log.error("Erro ao tentar inserir usuário");
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    public void excluir(Usuario p_usuario) {
        Connection conn = null;
        try {

            conn = ConexaoBD.getConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM usuario WHERE id=?");
            pstm.setInt(1, p_usuario.getId());

            pstm.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

}
