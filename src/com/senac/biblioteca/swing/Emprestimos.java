/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.biblioteca.swing;

import com.senac.biblioteca.bean.Emprestimo;
import com.senac.biblioteca.rn.EmprestimoRN;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ruans
 */
public class Emprestimos extends javax.swing.JInternalFrame {

    List<Emprestimo> lista = new ArrayList();
    TelaPrincipal telaPrincipal;

    /**
     * Creates new form Emprestimos
     */
    public Emprestimos(TelaPrincipal p_tela) {
        initComponents();
        populaTela();
        telaPrincipal = p_tela;
    }

    private void populaTela() {
        try {
            lista = new EmprestimoRN().listaEmprestimos();
            
            AnnotationResolver resolver = new AnnotationResolver(Emprestimo.class);
            ObjectTableModel<Emprestimo> tableModel2 = new ObjectTableModel<Emprestimo>(resolver, "usuario,livro,dtEmprestimo,dtDevolucao,indDevolvido");
            tableModel2.setData(lista);
            tbEmprestimos.getTableHeader().setReorderingAllowed(false);
            tbEmprestimos.setModel(tableModel2);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmprestimos = new javax.swing.JTable();

        setClosable(true);
        setTitle("Empréstimos - Sistema Biblioteca ROS");

        tbEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbEmprestimos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmprestimosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmprestimos);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbEmprestimosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmprestimosMouseClicked
        // TODO add your handling code here:
        //fazer o efento do mause
    }//GEN-LAST:event_tbEmprestimosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEmprestimos;
    // End of variables declaration//GEN-END:variables

}