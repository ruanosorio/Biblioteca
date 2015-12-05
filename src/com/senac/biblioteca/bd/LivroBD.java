/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.biblioteca.bd;

import com.senac.biblioteca.bean.Categoria;
import com.senac.biblioteca.bean.Editora;
import com.senac.biblioteca.bean.Livro;
import com.senac.biblioteca.bean.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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
public class LivroBD {

    static Logger log = Logger.getLogger(LivroBD.class);

    public void salvar(Livro p_livro) {
        Connection conn = null;
        try {

            log.info("Abrindo conexão com o banco");

            conn = ConexaoBD.getConexao();
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO livro (titulo, autor, isbn, ano, id_editora, id_categoria, descricao) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            pstm.setString(1, p_livro.getTitulo());
            pstm.setString(2, p_livro.getAutor());
            pstm.setString(3, p_livro.getIsbn());
            pstm.setInt(4, p_livro.getAno());
            pstm.setInt(5, p_livro.getEditora().getId());
            pstm.setInt(6, p_livro.getCategoria().getId());
            pstm.setString(7, p_livro.getDescricao());

            log.info("Inserindo Livro no banco de dados");

            pstm.executeUpdate();
            Long id = ConexaoBD.getLastKey(pstm);
            p_livro.setId(id == null ? null : id.intValue());

            log.info("ID criado = " + p_livro.getId());

        } catch (Exception e) {
            log.error("Erro ao tentar inserir novo Livro!");
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

        Connection conn = null;
        try {

            log.info("Abrindo conexão com o banco");

            conn = ConexaoBD.getConexao();
            PreparedStatement pstm = conn.prepareStatement(""
                    + "update livro set "
                    + "titulo = ? ,"
                    + "autor = ? ,"
                    + "isbn = ? ,"
                    + "ano = ? ,"
                    + "id_editora = ? ,"
                    + "id_categoria = ? ,"
                    + "descricao = ? "
                    + "where id = ?");

            pstm.setString(1, p_livro.getTitulo());
            pstm.setString(2, p_livro.getAutor());
            pstm.setString(3, p_livro.getIsbn());
            pstm.setInt(4, p_livro.getAno());
            pstm.setString(5, p_livro.getEditora().getNome());
            pstm.setInt(6, p_livro.getCategoria().getId());
            pstm.setString(7, p_livro.getDescricao());
            pstm.setInt(8, p_livro.getId());

            pstm.executeUpdate();

            log.info("Livro editado com sucesso!");

        } catch (Exception e) {
            log.error("Erro ao tentar editar o livro!");
            e.printStackTrace();
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

    public List<Livro> listaLivro() {

        List<Livro> lista = new ArrayList<>();

        Connection conn = null;
        try {

            log.info("Abrindo conexão com o banco");

            conn = ConexaoBD.getConexao();

            log.info("Efeutando a busca dos livros..");

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM livro");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                Livro livro = new Livro();
                Editora editora = new Editora();
                Categoria cat = new Categoria();

                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setIsbn(rs.getString("isbn"));
                livro.setAno(rs.getInt("ano"));
                //livro.setEditora(rs.getInt("id"));

                cat.setId(rs.getInt("id_categoria"));
                livro.setCategoria(cat);

                livro.setDescricao(rs.getString("descricao"));

                lista.add(livro);

            }
            log.info("Lista de livros encontrada.");
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

    public void excluir(Livro p_livro) {
        Connection conn = null;
        try {

            conn = ConexaoBD.getConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM livro WHERE id=?");
            pstm.setInt(1, p_livro.getId());

            pstm.execute();
            log.info("Livro deletado com sucesso!");
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

    public Vector<Livro> pesquisar(String text) throws SQLException {
        //Carregar combo passando um vetor de categoria
        Vector<Livro> dados = new Vector<Livro>();

        // definição do SQL com base nos dados informados para pesquisa
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT *  ");
        sql.append("FROM livro  ");
        sql.append("WHERE ");
        sql.append("id = ? ");

        Connection conn = null;
        try {

            conn = ConexaoBD.getConexao();

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, text);
            //  pstm.setString(2, "%" + text + "%");
            // pstm.setString(3, "%" + text + "%");
            //  pstm.setString(4, "%" + text + "%");
            log.info(pstm);
            log.debug("Pesquisando: " + text);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                Livro book = new Livro();
                book.setId(rs.getInt("id"));
                book.setTitulo(rs.getString("titulo"));
                book.setAutor("autor");

                log.debug("Registro encontrado!");

                dados.add(book);
            }
            log.debug("Pesquisa executada com sucesso!");
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
