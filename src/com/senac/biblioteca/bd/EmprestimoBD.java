/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.biblioteca.bd;

import com.mysql.jdbc.Util;
import com.senac.biblioteca.bean.Categoria;
import com.senac.biblioteca.bean.Emprestimo;
import com.senac.biblioteca.bean.Livro;
import com.senac.biblioteca.bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.omg.PortableInterceptor.USER_EXCEPTION;

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
            pstm.setTimestamp(2, new Timestamp(emprestimo.getDtDevolucao().getTime()));
            pstm.setInt(3, emprestimo.getUsuario().getId());
            pstm.setInt(4, emprestimo.getLivro().getId());
            pstm.setString(5, emprestimo.getIndDevolvido());

            pstm.executeUpdate();
            log.info("Inserindo emprestimo no banco de dados");
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

            pstm.executeUpdate();
            log.info("Emprestimo inserido no banco de dados");

        } catch (Exception e) {
            log.error("Erro, ao tentar efetuar o emprestimo do livro!");
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

    public List<Emprestimo> listaEmprestimoDoUsuario(Usuario usuario) {
        Connection conn = null;
        try {

            conn = ConexaoBD.getConexao();

            String sql = ""
                    + " select  "
                    + " emp.* "
                    + ",       usu.id as id_usuario  "
                    + ",       usu.matricula  as matricula_usuario  "
                    + ",       usu.nome as nome_usuario    "
                    + ",       usu.telefone as telefone_usuario    "
                    + ",       liv.id as id_livro    "
                    + ",       liv.titulo as titulo_livro    "
                    + ",       liv.autor as autor_livro    "
                    + ",       liv.isbn as isbn_livro    "
                    + ",       liv.ano ano_livro    "
                    + ",       liv.descricao as descricao_livro    "
                    + ",       liv.id_categoria    "
                    //+ ",       liv.    " editora
                    + " from      emprestimo emp "
                    + " inner join usuario usu on usu.id = emp.id_usuario "
                    + " inner join livro liv on liv.id = emp.id_livro "
                    + " inner join categoria cat on cat.id = liv.id_categoria"
                    + " where    emp.id_usuario = ?";

           // log.error("Erro em: "+sql);
            PreparedStatement pmst = conn.prepareStatement(sql);
            pmst.setInt(1, usuario.getId());

            ResultSet rs = pmst.executeQuery();

            List<Emprestimo> emprestimos = new ArrayList<>();
            Emprestimo emp;
            Livro livro;
            Usuario user;
            Categoria cat;

            while (rs.next()) {
                emp = new Emprestimo();
                livro = new Livro();
                user = new Usuario();
                cat = new Categoria();

                emp.setDtDevolucao(new Date(rs.getTimestamp("dataDevolucao").getTime()));
                emp.setDtEmprestimo(new Date(rs.getTimestamp("dataEmprestimo").getTime()));
                emp.setId(rs.getInt("id"));
                emp.setIndDevolvido(rs.getString("ind_devolvido"));

                livro.setId(rs.getInt("id_livro"));
                livro.setAno(rs.getInt("ano_livro"));
                livro.setDescricao(rs.getString("descricao_livro"));
                livro.setAutor(rs.getString("autor_livro"));
                livro.setIsbn(rs.getString("isbn_livro")); //: Column 'isbn' not found
                livro.setTitulo(rs.getString("titulo_livro"));
                
                cat.setId(rs.getInt("id_categoria"));
                livro.setCategoria(cat);
                
                emp.setLivro(livro);

                user.setId(rs.getInt("id_usuario"));
                user.setMatricula(rs.getInt("matricula_usuario"));
                user.setNome(rs.getString("nome_usuario"));
                user.setTelefone(rs.getString("telefone_usuario"));
                emp.setUsuario(user);

                emprestimos.add(emp);
            }

            return emprestimos;

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

    public void excluir(Usuario p_usuario) {
        Connection conn = null;
        try {

            conn = ConexaoBD.getConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM emprestimo WHERE id_usuario=?");
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

    public List<Emprestimo> listaEmprestimos() {

        Connection conn = null;
        try {

            log.info("Abrindo conexão com o banco");

            conn = ConexaoBD.getConexao();

            log.info("executando o select empréstimos");
            
            String sql = ""
                    + "SELECT"
                    + "  emp.*, "
                    + "  usu.id as id_usuario,  "
                    + "  usu.matricula as matricula_usuario,    "
                    + "  usu.nome as nome_usuario,  "
                    + "  liv.id as id_livro,   "
                    + "  liv.titulo as titulo_livro,  "
                    + "  liv.autor as autor_livro,  "
                    + "  liv.isbn as isbn_livro,  "
                    + "  cat.id as id_categoria,  "
                    + "  cat.nome as nome_categoria  "
                    + " from      emprestimo emp "
                    + " inner join usuario usu ON usu.id = emp.id_usuario"
                    + " inner join livro liv ON liv.id = emp.id_livro"
                    + " inner join categoria cat ON cat.id = liv.id_categoria";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            
           //  log.error("Erro em: "+sql);
            
            ResultSet rs = pstm.executeQuery();
            
            System.out.println(pstm);
            
            List<Emprestimo> lista = new ArrayList<>();
            Emprestimo emp;
            Livro book;
            Usuario user;
            Categoria cat;
            
            while (rs.next()) {

                emp = new Emprestimo();
                user = new Usuario();
                book = new Livro();
                cat = new Categoria();
                        
                emp.setId(rs.getInt("id"));                
                emp.setDtEmprestimo(new Date(rs.getTimestamp("dataEmprestimo").getTime()));
                emp.setDtDevolucao(new Date(rs.getTimestamp("dataDevolucao").getTime()));
                emp.setIndDevolvido(rs.getString("ind_devolvido"));
                
                book.setId(rs.getInt("id_livro"));
                book.setTitulo(rs.getString("titulo_livro"));
                book.setAutor(rs.getString("autor_livro"));
                book.setIsbn(rs.getString("isbn_livro"));
                
                cat.setId(rs.getInt("id_categoria"));
                book.setCategoria(cat);
                cat.setNome("nome_categoria");
                
                emp.setLivro(book);
                
                user.setId(rs.getInt("id_usuario"));
                user.setMatricula(rs.getInt("matricula_usuario"));
                user.setNome(rs.getString("nome_usuario"));
                
                emp.setUsuario(user);
                
                lista.add(emp);

            }
            System.out.println(lista);
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
}
