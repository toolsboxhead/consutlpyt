package com.mytestemp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
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





public class DataConsultTable extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Si lo queremos hacer a traves de un get, tenemos que poner el codigo del post en esta clase
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
      
        

		// ! Obtengo los datos de la peticion
		 //ArrayList<String> selec = new ArrayList<String>();
		 String selecSQL = "";
         int anno1 =  Integer.parseInt(request.getParameter("annoi"));
		 int mees1 =  Integer.parseInt(request.getParameter("meesi")); 
		 int anno2 =  Integer.parseInt(request.getParameter("annof"));
		 int mees2 =  Integer.parseInt(request.getParameter("meesf")); 
	/* 	 String anno1 =  request.getParameter("annoi");
		 String mees1 =  request.getParameter("meesi"); 
		 String anno2 =  request.getParameter("annof");
		 String mees2 =  request.getParameter("meesf");  */
		 String[] selec = request.getParameterValues("consu[]");
		 selecSQL  = convStringSql(selec);

		System.out.println(" MES1 :" + mees1 + " AÑO 1: " + anno1 + " MES2 :" + mees2 + " AÑO 2: " + anno2); 
		System.out.println(selecSQL);
		// ! Recupero campos del Base de Datos segun Criterio 
		ConsultantServ dao = new ConsultantServ();
		

        //List<Utilidades> utilidades = dao.utilidadesxMes("carlos.arruda", 2006, 2009, 2, 4,"ALGO");
		List<Utilidades> utilidades = dao.utilidadesxMes("carlos.arruda", anno1, anno2, mees1, mees2, selecSQL);
        System.out.println("entroSERVLET");
        // ! Generando Tabla de Datos
		
		
		//out.println("<table>");
		Double  tot_valor = 0.0;
		Double	tot_bruts = 0.0;
		Double	tot_comis = 0.0;
		Double	tot_lucro = 0.0;
		String ntvalorFormat = "";
        String brutsalFormat = "";
        String comisioFormat = "";
        String tolucroFormat = "";
		String co_user = "";
		String tx_mes = "";
		Boolean bl_pie = true;
		Locale portBr = new Locale("pt","BR");
		NumberFormat formatoTotal = NumberFormat.getCurrencyInstance(portBr);
		
		for( Utilidades c : utilidades){

			if (!c.getCo_usuario().equals(co_user)){
				co_user = c.getCo_usuario();
				if (!bl_pie){
					out.println("<tr>");
					out.println("<td>" + "TOTAL :" + "</td>");
					out.println("<td>" + formatoTotal.format(tot_valor) + "</td>");
					out.println("<td>" + formatoTotal.format(tot_bruts) + "</td>");
					out.println("<td>" + formatoTotal.format(tot_comis) + "</td>");			
					out.println("<td>" + formatoTotal.format(tot_lucro) + "</td>");
					out.println("</tr>");
					out.println("</table>");
					
					
				}
				out.println("<br>");
				bl_pie = false;
				tot_valor = 0.0;
				tot_bruts = 0.0;
				tot_comis = 0.0;
				tot_lucro = 0.0;
				out.println("<table class='table table-success table-striped'>");
				out.println("<tr>");
				out.println("<td font-weight: 'bold'>"+ c.getNo_usuario() +"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td font-weight: 'bold'> Período </td>");			
				out.println("<td font-weight: 'bold'>Receita Líquida</td>");
				out.println("<td font-weight: 'bold'>Custo Fixo</td>");
				out.println("<td font-weight: 'bold'>Comissão</td>");
				out.println("<td font-weight: 'bold'>Lucro</td>");
				out.println("</tr>");
			}
        
        		
			//TABLA Utilidades 
            ntvalorFormat = formatoTotal.format(c.getMo_ntvalor());
            brutsalFormat = formatoTotal.format(c.getMo_brutsal());
            comisioFormat = formatoTotal.format(c.getMo_comisio());
            tolucroFormat = formatoTotal.format(c.getMo_tolucro());
			tot_valor = tot_valor + c.getMo_ntvalor();
			tot_bruts = tot_bruts + c.getMo_brutsal();
			tot_comis = tot_comis + c.getMo_comisio();
			tot_lucro = tot_lucro + c.getMo_tolucro();
			out.println("<tr>");
			tx_mes = mesText((int) c.getDt_meesuti());
			out.println("<td>"+ tx_mes.toUpperCase() + " - " + c.getDt_annouti() +"</td>");
            out.println("<td>"+ ntvalorFormat +"</td>");
            out.println("<td>"+ brutsalFormat +"</td>");
			out.println("<td>" + comisioFormat + "</td>");			
			out.println("<td>"+tolucroFormat  +"</td>");
			out.println("</tr>");
		}
		out.println("<tr>");
					out.println("<td>" +"TOTAL :" + "</td>");
					out.println("<td>" + formatoTotal.format(tot_valor) + "</td>");
					out.println("<td>" + formatoTotal.format(tot_bruts) + "</td>");
					out.println("<td>" + formatoTotal.format(tot_comis) + "</td>");			
					out.println("<td>" + formatoTotal.format(tot_lucro) + "</td>");
					out.println("</tr>");
		out.println("</table>");
	

	}

	public String convStringSql( String[] selec){
		String sql_string = "";
		String coma = "";
		
					
		for (String v : selec)
		{
			sql_string =  sql_string + coma + " '" + v + "'"  ;
			coma = ",";
		  }
	    
		
		sql_string = " ( " + sql_string + " ) ";
		System.out.println(sql_string);
		return sql_string;

	} 

	public String mesText(int mesnum){
		//bLocale = new Locale("por","BR");
		Locale locale = new Locale("es", "ES");
		Calendar calendarInicio = Calendar.getInstance();
		/*Restamos 1 a la variable por lo dicho al inicio*/
		calendarInicio.set(Calendar.MONTH, mesnum-1);
		String monthName=calendarInicio.getDisplayName(Calendar.MONTH, Calendar.LONG, locale);
		System.out.println(monthName);
		return monthName;
	}
    
	public static  void main(String[] args) {
		Locale portBr = new Locale("pt","BR");
		//Locale inglesGB = new Locale("en","GB");
		double importe = -1234.56;
		NumberFormat formatoImporte = NumberFormat.getCurrencyInstance(portBr);
		System.out.println(formatoImporte.format(importe));
		//DecimalFormat formato = new DecimalFormat("R$##,###.00");
	}
}
