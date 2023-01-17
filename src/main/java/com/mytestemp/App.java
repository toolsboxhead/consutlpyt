package com.mytestemp;

//import com.mytestemp.datosDao.consultantDao.IntConsultantServ;

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.util.List;

//import com.mytestemp.bdata.connect_bd;
import com.mytestemp.datosDao.consultantDao.ConsultantServ;
import com.mytestemp.datosModel.Consultor;

public class App {
    public static void main(String[] args ) throws Exception {
    /*     System.out.println("Hello, World");
        Connection conn = null; */
       // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/caol1",  "root", "");

       /*  Consultor consult1 = new Consultor("nuevo", "jesus");
        
        IntConsultantServ consultServ = new ConsultantServ(conn);
        consultServ.searchConsultant(consult1);
 */
//connect_bd conn = new connect_bd();
        try {
            // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/caol1",  "root", "");
             //conn = conn();
             
             ConsultantServ dao = new ConsultantServ();
             List<Consultor> consultors = dao.listarConsultValidos();
             for (Consultor c: consultors){
                 /*System.out.println(c.toString());*/
                 System.out.println(c.getCo_usuario());
             }
         } finally {
             /* if (conn != null){
                 conn.cerrarConexiones(conn, null, null);
             }  */
         } 
    
    }
}
