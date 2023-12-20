/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrs.util;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author nxrtxn
 */
public class Conexao {
    private static String url_jdbc = "jdbc:mysql://localhost:3306/trabalho";
    private static String usuario = "root";
    private static String senha = "Norton159753!";
    
    public static Connection pegarConexao() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(url_jdbc, usuario,senha);
        
        return con;
    }
}
