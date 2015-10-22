/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.biblioteca.rn;

import com.senac.biblioteca.bd.ConexaoBD;
import com.senac.biblioteca.bd.EmprestimoBD;
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

/**
 *
 * @author ruans
 */
public class EmprestimoRN {

    EmprestimoBD bd;

    public EmprestimoRN() {
        bd = new EmprestimoBD();

    }

    public void salvar(Emprestimo emprestimo) {
        bd.salvar(emprestimo);
    }

    public void devolucao(Emprestimo emprestimo) {
        bd.devolucao(emprestimo);
    }

    public List<Emprestimo> listaEmprestimoDoUsuario(Usuario usuario) {
        return bd.listaEmprestimoDoUsuario(usuario);
    }

    public void excluir(Usuario p_usuario) {
        bd.excluir(p_usuario);
    }
}
