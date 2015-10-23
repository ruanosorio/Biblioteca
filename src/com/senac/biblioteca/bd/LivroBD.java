/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.biblioteca.bd;

import com.senac.biblioteca.bean.Livro;
import com.senac.biblioteca.bean.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Ruan Osorio
 */
public class LivroBD {
 
    static Logger log = Logger.getLogger(UsuarioBD.class);

    public void salvar(Livro p_livro) {
        Connection conn = null;
        try {

            log.info("Abrindo conexão com o banco");

            conn = ConexaoBD.getConexao();
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO livro (titulo, autor, isbn, ano, id_editora, id_categoria, descricao) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            // pstm.setInt(1, p_usuario.getId());
            pstm.setString(1, p_livro.getTitulo());
            pstm.setString(2, p_livro.getAutor());
            pstm.setString(3, p_livro.getIsbn());
            pstm.setInt(4, p_livro.getAno());
            pstm.setInt(5, p_livro.getEditora().getId());
            pstm.setInt(6, p_livro.getCategoria().getId());
            pstm.setString(7,p_livro.getDescricao());
            
            
            log.info("Inserindo Livrooo no banco de dados");

            pstm.executeUpdate();
            Long id = ConexaoBD.getLastKey(pstm);
            p_livro.setId(id == null ? null : id.intValue());

            log.info("ID criado = "+p_livro.getId());
        } catch (Exception e) {
            log.error("Erro ao tentar inserir livro");
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

    public void editar(Livro p_livro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Livro> listaLivro(Livro p_livro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluir(Livro p_livro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
