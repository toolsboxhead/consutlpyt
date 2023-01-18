package Lib;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

public class LibUtilTextTransf {
    
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
