package com.mytestemp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servlet extends HttpServlet {
    public void processRequest(HttpServletRequest request, HttpServletResponse response)  {
        response.setContentType("text/html;charset-UTF-8");

        try {
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("<h1> Hello all from servle</h1>");
            out.println("<h1>Servlet Newserlet at " + request.getContextPath() + "</h1>");
            String user = request.getParameter("user");
            out.println("<h2> Welcome" + user + "</h2");
            out.println("</body>");
            out.println("</html>");
            // out.println("Saludos desde la tierra");

        } catch (Exception e) {
            
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        super.doGet(req, resp);
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
