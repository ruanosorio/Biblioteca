package com.senac.biblioteca.rn;

import com.senac.biblioteca.bd.EmprestimoBD;
import com.senac.biblioteca.bean.Emprestimo;
import com.senac.biblioteca.bean.Livro;
import com.senac.biblioteca.bean.Usuario;
import java.util.ArrayList;
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

    public void salvar(Emprestimo p_emprestimo) {
        bd.salvar(p_emprestimo);
    }

    public void devolucao(Emprestimo p_emprestimo) {
        bd.devolucao(p_emprestimo);
    }

    public List<Emprestimo> listaEmprestimoDoUsuario(Usuario p_usuario) {
        return bd.listaEmprestimoDoUsuario(p_usuario);
    }

    public void excluir(Usuario p_usuario) {
        bd.excluir(p_usuario);
    }
}
