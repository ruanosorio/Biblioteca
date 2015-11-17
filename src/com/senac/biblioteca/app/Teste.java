package com.senac.biblioteca.app;

import com.senac.biblioteca.bd.EmprestimoBD;
import com.senac.biblioteca.bd.LivroBD;
import com.senac.biblioteca.bd.UsuarioBD;
import com.senac.biblioteca.bean.Emprestimo;
import com.senac.biblioteca.bean.Livro;
import com.senac.biblioteca.bean.Usuario;
import com.senac.biblioteca.rn.LivroRN;
import java.util.List;
import org.apache.log4j.chainsaw.Main;

/**
 * Classe Teste realizar o fluxo do projeto.
 *
 * Realizar o fluxo basico de cadastro
 *
 * @author Ruan Osório
 * @version 1
 */
public class Teste {

    public static void mains(String[] args) throws Exception {

//        Usuario u = new Usuario();
//        
//        u.setId(9);
//        u.setId(10);
//        List<Emprestimo> emps = new EmprestimoBD().listaEmprestimoDoUsuario(u);
//        for (Emprestimo emp : emps) {
//            System.out.println(emp);
//
//        }
//        
//        List<Livro> l = new LivroBD().listaLivro();
//        for (Livro livros : l){
//            System.out.println(livros);
//        }
//        
//        List<Usuario> ul = new UsuarioBD().listaUsuario();
//        for (Usuario usuarios : ul){
//            System.out.println(usuarios);
//        }
        
        
        /*
         FabricaRN rn = new FabricaRN();
        List<Fabrica> lista = rn.listar();
        for (Fabrica fabrica : lista) {
            System.out.println(fabrica.getNome());
        }
        */
    }

    public static void devolucao(String[] args) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId(1);
        new EmprestimoBD().devolucao(emprestimo);
    }

    public static void main(String[] args) {

        UsuarioBD user = new UsuarioBD();

        Usuario p_user = new Usuario();

        p_user.setNome("Lossurdo");
        p_user.setMatricula(20152);
        p_user.setTelefone("56444");

        user.salvar(p_user);

        LivroBD livrobanco = new LivroBD();

        Livro p_book = new Livro();

        p_book.setTitulo("Qualqwer");
        p_book.setAutor("Seu ");
        p_book.setIsbn("121451545");
        p_book.setAno(2015);
        p_book.setDescricao(" JAVA");

        livrobanco.salvar(p_book);

        Emprestimo emprestimo = new Emprestimo(p_user, p_book);
        emprestimo.setIndDevolvido("N");
        new EmprestimoBD().salvar(emprestimo);
        System.out.println("Emprestimo efetuado = " + emprestimo.toString());

    }

}
