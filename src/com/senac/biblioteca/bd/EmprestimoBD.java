/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.biblioteca.bd;

import com.senac.biblioteca.bean.Emprestimo;
import com.senac.biblioteca.bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import org.apache.log4j.Logger;

/**
 *
 * @author Ruan Osorio
 */
public class EmprestimoBD {

    static Logger log = Logger.getLogger(UsuarioBD.class);

    public void salvar(Emprestimo emprestimo) {
        Connection conn = null;
        try {

            log.info("Abrindo conexão com o banco");

            conn = ConexaoBD.getConexao();
            PreparedStatement pstm = conn.prepareStatement(""
                    + "INSERT INTO emprestimo "
                    + "(dataEmprestimo,dataDevolucao,id_usuario,id_livro,ind_devolvido) "
                    + "VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            // pstm.setInt(1, p_usuario.getId());
            pstm.setTimestamp(1, new Timestamp(emprestimo.getDtEmprestimo().getTime()));
            pstm.setTimestamp(2, new Timestamp(emprestimo.getDtDevoluco().getTime()));
            pstm.setInt(3, emprestimo.getUsuario().getId());
            pstm.setInt(4, emprestimo.getLivro().getId());
            pstm.setString(5, emprestimo.getIndDevolvido());

            log.info("Inserindo emprestimo no banco de dados");

            pstm.executeUpdate();
            Long id = ConexaoBD.getLastKey(pstm);
            emprestimo.setId(id == null ? null : id.intValue());

            log.info("ID criado = " + emprestimo.getId());
        } catch (Exception e) {
            log.error("Erro ao tentar inserir emprestimo");
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

    public void devolucao(Emprestimo emprestimo) {
        Connection conn = null;
        try {

            log.info("Abrindo conexão com o banco");

            conn = ConexaoBD.getConexao();
            PreparedStatement pstm = conn.prepareStatement(""
                    + "update emprestimo "
                    + "set ind_devolvido = 'S' ,"
                    + " dataDevolucao = ? "
                    + "where id = ?");

            pstm.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            pstm.setInt(2, emprestimo.getId());
            log.info("Inserindo emprestimo no banco de dados");

            pstm.executeUpdate();

        } catch (Exception e) {
            log.error("Erro ao tentar inserir emprestimo");
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
