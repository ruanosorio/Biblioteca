/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.biblioteca.bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author 631320290
 */
public class ConexaoBD {

    static Logger log = Logger.getLogger(ConexaoBD.class);

    public static Connection getConexao() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/biblioteca", "root", "usbw");
            return conn;
        } catch (Exception e) {

            log.error("Conexão com banco de dados falhou!", e);

            throw new RuntimeException(e);
        }
    }

    public static Long getLastKey(PreparedStatement pmst) throws Exception {
        ResultSet rs = pmst.getGeneratedKeys();

        if (rs.next()) {
            Long id = rs.getLong(1);
            return id;
        }
        return null;
    }

}
