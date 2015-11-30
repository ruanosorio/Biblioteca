/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.biblioteca.bd;

import com.senac.biblioteca.bean.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.apache.log4j.Logger;

/**
 *
 * @author Ruan Osorio
 */
public class CategoriaBD {

    static Logger log = org.apache.log4j.Logger.getLogger(UsuarioBD.class);

    public List<Categoria> listaCategoria() {
        List<Categoria> lista = new ArrayList<>();

        Connection conn = null;
        try {

            conn = ConexaoBD.getConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM categoria");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                Categoria categorias = new Categoria();

                categorias.setId(rs.getInt("id"));
                categorias.setNome(rs.getString("nome"));

                lista.add(categorias);

            }

            return lista;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }

    public void salvar(Categoria p_categoria) {
        Connection conn = null;
        try {

            log.info("Abrindo conexão com o banco");

            conn = ConexaoBD.getConexao();
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO categoria (nome) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            pstm.setString(2, p_categoria.getNome());

            log.info("Inserindo Usuário no banco de dados");

            pstm.executeUpdate();
            Long id = ConexaoBD.getLastKey(pstm);
            p_categoria.setId(id == null ? null : id.intValue());

            log.info("Usuário criado, seu ID = " + p_categoria.getId());

        } catch (Exception e) {
            log.error("Erro ao tentar inserir categoria");
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

    public void editar(Categoria p_categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluir(Categoria p_categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Vector<Categoria> carregaCombo() throws SQLException {
        //Carregar combo passando um vetor de categoria
        Vector<Categoria> dados = new Vector<Categoria>();

        Connection conn = null;
        try {

            conn = ConexaoBD.getConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM categoria order by nome");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                Categoria categorias = new Categoria();
                categorias.setId(rs.getInt("id"));
                categorias.setNome(rs.getString("nome"));
                
                dados.add(categorias);
                
            }
            return dados;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }

}
