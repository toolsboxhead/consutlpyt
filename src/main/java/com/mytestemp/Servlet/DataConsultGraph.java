package com.mytestemp.Servlet;


import java.io.IOException;
import java.io.PrintWriter;
//import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;

import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mytestemp.datosDao.consultantDao.ConsultantServ;
import com.mytestemp.datosModel.Utilidades;
import com.google.gson.Gson;


public class DataConsultGraph extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Si lo queremos hacer a traves de un get, tenemos que poner el codigo del post en esta clase
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

        //String name=request.getParameter("name");
        
       // Ajax obj_Ajax = new Ajax(name,"1234");

       ConsultantServ dao = new ConsultantServ();
		

        List<Utilidades> utilidades = dao.utilidadesxMes("carlos.arruda", 2006, 2009, 2, 4," ('carlos.arruda') ");
		//List<Utilidades> utilidades = dao.utilidadesxMes("carlos.arruda", anno1, anno2, mees1, mees2, selecSQL);
        System.out.println("entroSERVLET2");
        Gson gson = new Gson();
        //Consultor cons = new Consultor("uno","salva"); 
        /* cons.co_usuario = "dos";
        cons.no_usuario = "linda"; */
        String datautilidad = gson.toJson(utilidades);
       // String datautilidad = gson.toJson(cons);
        System.out.println(datautilidad);
        PrintWriter out=response.getWriter();
        //response.setContentType("application/json");
        response.setContentType( "text/html; charset=iso-8859-1" );
        response.setCharacterEncoding("UTF-8");

        out.print(datautilidad);
		
        

	
	}




	}
    

