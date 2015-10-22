package com.senac.biblioteca.app;

import com.senac.biblioteca.bd.EmprestimoBD;
import com.senac.biblioteca.bd.LivroBD;
import com.senac.biblioteca.bd.UsuarioBD;
import com.senac.biblioteca.bean.Emprestimo;
import com.senac.biblioteca.bean.Livro;
import com.senac.biblioteca.bean.Telefone;
import com.senac.biblioteca.bean.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe Teste realizar o fluxo do projeto. 
 * 
 * Realizar o fluxo basico de cadastro
 *
 * @author Ruan Osório
 * @version 1  
 */
public class Teste {

public static void main(String[] args) {
    Emprestimo emprestimo = new Emprestimo();
    emprestimo.setId(1);
    new EmprestimoBD().devolucao(emprestimo);
}
    public static void mains(String[] args) {
        
        UsuarioBD user = new UsuarioBD();

        Usuario p_user = new Usuario();

        p_user.setNome("Teste");
        p_user.setMatricula(2015);
        p_user.setTelefone("9875464");

        user.salvar(p_user);
        
        LivroBD livrobanco = new LivroBD();
        
        Livro p_book = new Livro();
        
        p_book.setTitulo("Use a cabeça JAVA");
        p_book.setAutor("Seu Java");
        p_book.setISBN("121451545");
        p_book.setAno(2015);
        p_book.setDescricao("Como aprender a linguem de programação JAVA");
        
        livrobanco.salvar(p_book);
        
        
        Emprestimo emprestimo = new Emprestimo(p_user, p_book);
        emprestimo.setIndDevolvido("N");
        new EmprestimoBD().salvar(emprestimo);
        System.out.println("Emprestimo efetuado = "+emprestimo.toString());
        
    }
//
//    public static void dadosUsuarios() {
//        
//        Scanner sc= new Scanner(System.in);
//        
//        Telefone phone;
//        
//        Usuario user;
//        
//        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
//        
//        int opcao = 0;
//        
//        do {
//            System.out.println("## Escolha uma das opções abaixo ##");
//            System.out.println("Opção 1 - Cadastrar Usuário");
//            System.out.println("Opção 2 - Listar Usuário(s) cadastrado(s)");
//            System.out.println("Opção 3 - Cadastrar Livros");
//            System.out.println("Opção 0 - Sair do programa");
//            System.out.println("_______________________");
//            System.out.print("Digite aqui sua opção: ");
//           
//            opcao = Integer.parseInt(sc.nextLine());
//            
//            if (opcao == 1) {
//                //Cria um novo objeto do tipo Usuário
//                user = new Usuario();
//                
//                    System.out.print("Digite a mátiricula: ");
//                    user.setMatricula(Integer.parseInt(sc.nextLine()));
//                    System.out.print("Digite o nome: ");
//                    user.setNome(sc.nextLine());
//                    
//                    phone = new Telefone();
//                    System.out.print("Digite o telefone: ");
//                    phone.setNumero(Integer.parseInt(sc.nextLine()));
//                    //user.setTelefone(phone);
//                    
//                    System.out.println();
//                                       
//                    
//                //Guarda o objeto Usuário em uma lista.
//                listaUsuarios.add(user);
//                
//            } else if (opcao == 2) {
//                if (listaUsuarios.isEmpty()) {
//                    System.out.println("Não existem pessoas cadastradas, pressione uma tecla para continuar!");
//                    sc.nextLine();
//                } else {
//                    System.out.println(listaUsuarios.toString());
//                    System.out.println("Pressione um tecla para continuar.");
//                    sc.nextLine();
//                }
//            }
//        } while (opcao != 0);
//        sc.close();
//        
//    }

}

