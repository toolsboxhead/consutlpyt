package com.mytestemp.bdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSet;
//import java.sql.DriverManager;
import java.sql.SQLException;





// Importing the Resultset and PreparableStatement classes from the com.mysql package.
/* import java.sql.PreparedStatement;
import java.sql.ResultSet; */

// private static String url = "jdbc:mariadb://127.0.0.1:3306/caol1";

public class connect_bd {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String urlweb =  "jdbc:mysql://node124364-env-8539409.jelastic.saveincloud.net:3306/caol";
    private static String url = "jdbc:mysql://localhost:3306/caol";
    private static String user = "root";
    private static String pass = "GtFw5DtiC2";



  static {
    try {
        Class.forName(driver);
    } catch (ClassNotFoundException e) {
        System.out.println("Error al cargar el controlador");
        e.printStackTrace();
    }
}
    
public  Connection conectar(){
    
    Connection conectdb = null;
    try {
       // Class.forName("com.mysql.jdbc.driver");
       // Class.forName("com.mysql.cj.jdbc.Driver");
      
       conectdb = DriverManager.getConnection(urlweb,user,pass);
      
       
       } catch (SQLException e) {
           System.out.println("Error Conectando : "  + e.getMessage());
           e.printStackTrace();
       }

       return conectdb;
}

public static void cerrarConexiones(Connection c, PreparedStatement cas, ResultSet rs)throws SQLException
{
    if(c!=null)c.close();
    if(cas!=null)cas.close();
    if(rs!=null)rs.close();
}


    
public void destroy(Connection cn, PreparedStatement statm,ResultSet rs) throws SQLException {
    if (rs != null) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs = null;
    }
  
  if (statm != null) {
        try {				
            statm.close();
        } catch (SQLException esql) {
            esql.printStackTrace();
        }
        statm = null;
    }
    
    if (cn != null) {
        try {
            cn.close();
        } catch (SQLException esql) {
            esql.printStackTrace();
        }
        cn = null;
    }		
}


}
