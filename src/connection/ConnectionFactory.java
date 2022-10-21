/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.*;

/**
 *
 * @author Brunobhs18
 */
public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASS = "";
    
    
    
    public static Connection getConnection() {
        
       try {
           Class.forName(DRIVER);
           
           return DriverManager.getConnection(URL, USER, PASS);
           
       } catch(ClassNotFoundException | SQLException ex){
           throw new RuntimeException("Erro na conexão: ", ex);
       }
                
    }
    
    public static void closeConnection(Connection con){
       try {
           if(con != null){
            con.close();
           }
        } catch(SQLException ex){
             throw new RuntimeException("Erro na conexão: ", ex); 
                }
       }
        
     public static void closeConnection(Connection con, PreparedStatement stmt){
     
        closeConnection(con);
        
        try {
           if(stmt != null){
               stmt.close();
           }
        } catch(SQLException ex){
             throw new RuntimeException("Erro na conexão: ", ex);   
                }
       }
        
      public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
     
        closeConnection(con, stmt);
        
        
        try {
           if(rs != null){
               rs.close();
           }
        } catch(SQLException ex){
             throw new RuntimeException("Erro na conexão: ", ex);   
                }
       }
     
    }


