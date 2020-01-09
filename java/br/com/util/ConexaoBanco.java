/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author e.andre.germano
 */
public class ConexaoBanco {

    public static Connection getConexao() {
    
        Connection conexao = null;

        try {

            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce", "postgres", "postgres");

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return conexao;
    }
    
    public static void close(ResultSet rs, Statement st, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }
  
    public static void close(Statement st, Connection conn) {
        close(null, st, conn);
    }
  
    public static void close(Connection conn) {
        close(null, null, conn);
    }
}