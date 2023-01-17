package com.mytestemp.Servlet;

import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.mytestemp.datosDao.consultantDao.ConsultantServ;
import com.mytestemp.datosModel.Consultor;

public class DataConsult extends HttpServlet{
    protected void processRequest(  HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException, SQLException{
        resp.setContentType("text/html;charset=UTF=8");
         String anno; //, mees;
        //List<Consultor> cons =   new ArrayList<Consultor>();
       // Connection conn = null;
            
        
        /* Consultor consultors = new Consultor();
        ArrayList<Consultor>  usuarios = ArrayList<Consultor>(); */
        
        //anno =  req.getParameter("tx_anno");
        //mees =  req.getParameter("tx_mees");
        
        // BUSCAR LOS CONSULTORES SEGUN LAS ORDENES DE SERVICIO AÑO Y MES

        
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/caol1",  "root", "");
        ConsultantServ dao = new ConsultantServ();
        List<Consultor> consultors = dao.listarConsultValidos();
        // HttpSession session =  req.getSession();
        String proceso = req.getParameter("proc2");
        if (proceso == "2" ) {
            System.out.println("Proceso 2");
            req.setAttribute("proc",  proceso + "2");
            req.getSession().setAttribute("user", proceso);
            RequestDispatcher respu = req.getRequestDispatcher("/data_cons.jsp");
           respu.forward(req, resp);
        } else {

          
          // session.setAttribute("ls_cons", cons);
           anno = "Estamos Conect";
           //session.setAttribute("ls_cons", anno);
           req.setAttribute("ls_cons", anno);
           req.setAttribute("consultors", consultors);
           RequestDispatcher respu = req.getRequestDispatcher("/index.jsp");
           respu.forward(req, resp);
           System.out.println(proceso);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
       // super.doGet(req, resp);
        try {
            processRequest(req, resp);
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
       // super.doPost(req, resp);
        try {
            processRequest(req, resp);
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
    
}
