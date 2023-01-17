package com.mytestemp.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mytestemp.datosDao.consultantDao.ConsultantServ;
import com.mytestemp.datosModel.Consultor;

public class LoginStart extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, SQLException {
       /*  resp.setContentType("text/html;charset=UTF=8"); */

        ConsultantServ dao = new ConsultantServ();
        List<Consultor> consultors = dao.listarConsultValidos(); 
        
        req.setAttribute("consultors", consultors);
        // RequestDispatcher respu = 
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
        //respu.forward(req, resp);
       // System.out.println("proceso");

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
