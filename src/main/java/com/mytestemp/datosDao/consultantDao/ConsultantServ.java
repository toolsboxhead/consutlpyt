package com.mytestemp.datosDao.consultantDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import com.mytestemp.bdata.connect_bd;
import com.mytestemp.datosModel.Consultor;
import com.mytestemp.datosModel.Utilidades;

public class ConsultantServ implements IntConsultantServ {

    
   


    public  ConsultantServ() {
        
        
     
    }
   


    /*
     * private PreparedStatement statem_sql;
     * private ResultSet resultado;
     */

    final String consulta = "select * caol.cao_servico from co_servico = ?";
    final String SQLTODOS = " SELECT * FROM caol.cao_usuario";
    final String SQLCons  = "SELECT A.co_usuario, no_usuario " +
                            "FROM caol.cao_usuario A, caol.permissao_sistema B " +
                            "WHERE A.co_usuario = B.co_usuario  AND  B.in_ativo = 'S' " +
                            "AND  (B.co_tipo_usuario <= 2);";


final String SQLutil2 =      "SELECT  co_usuario, CONSULTOR.no_usuario, brut_salario," +
                            "EXTRACT(YEAR FROM data_emissao) AS anno, EXTRACT(MONTH FROM data_emissao) AS mes,  " +
                            "sum(valor) VALOR,   " +
                            "sum(valor) - (sum(valor) * (total_imp_inc / 100)) as receita_liquida,  " +
                            "sum(valor) * (total_imp_inc / 100) as monto_imp,  " +
                            "(sum(valor) - (sum(valor) * (total_imp_inc / 100))) * (comissao_cn / 100) as valor_comissao,  " +
                            "(sum(valor) - (sum(valor) * (total_imp_inc / 100)) ) - (brut_salario +((sum(valor) - (sum(valor) * (total_imp_inc / 100))) * (comissao_cn / 100))) AS lucro " +
                            "FROM caol.cao_fatura X,  (SELECT co_os, A.co_usuario, no_usuario,brut_salario  " +
                                                        "FROM caol.cao_usuario A INNER JOIN caol.permissao_sistema B ON A.co_usuario = B.co_usuario  " + 
                                                        "INNER JOIN caol.cao_os C  ON A.co_usuario = C.co_usuario  " +
                                                        "INNER JOIN caol.cao_salario D ON A.co_usuario = D.co_usuario   " +
                                                        "WHERE B.in_ativo = 'S' AND  ( B.co_tipo_usuario <= 2)  AND B.co_usuario = ?) AS CONSULTOR  " +
                                                        "WHERE X.co_os = CONSULTOR.co_os  AND (EXTRACT(YEAR FROM data_emissao) >= ? AND EXTRACT(YEAR FROM data_emissao) <= ?)  " +
                            "AND (EXTRACT(MONTH FROM data_emissao) >= ? AND EXTRACT(MONTH FROM data_emissao) <= ?)  " +
                            "GROUP BY EXTRACT(YEAR FROM data_emissao), EXTRACT(MONTH FROM data_emissao); ";                      
String SQLutil3 =      "SELECT  co_usuario, CONSULTOR.no_usuario, brut_salario, " +  
                            "EXTRACT(YEAR FROM data_emissao) AS anno, EXTRACT(MONTH FROM data_emissao) AS mes, " +
                            "sum(valor) VALOR,  " +
                            "sum(valor) - (sum(valor) * (total_imp_inc / 100)) as receita_liquida, " +
                            "sum(valor) * (total_imp_inc / 100) as monto_imp, " +
                            "(sum(valor) - (sum(valor) * (total_imp_inc / 100))) * (comissao_cn / 100) as valor_comissao  , " +
                            "(sum(valor) - (sum(valor) * (total_imp_inc / 100)) ) - (brut_salario +((sum(valor) - (sum(valor) * (total_imp_inc / 100))) * (comissao_cn / 100))) AS lucro " +
                            "FROM caol.cao_fatura X,  (SELECT co_os, A.co_usuario, no_usuario,brut_salario " +
                                                        "FROM caol.cao_usuario A INNER JOIN caol.permissao_sistema B ON A.co_usuario = B.co_usuario " +
                                                             "INNER JOIN caol.cao_os C  ON B.co_usuario = C.co_usuario " +
                                                             "INNER JOIN caol.cao_salario D ON C.co_usuario = D.co_usuario " +
                                                             "WHERE B.in_ativo = 'S' AND  ( B.co_tipo_usuario <= 2)  )  AS CONSULTOR " +
                            "WHERE X.co_os = CONSULTOR.co_os AND   co_usuario IN ";
String SQLcin =             " AND " +
                            "(EXTRACT(YEAR FROM data_emissao) >= ? AND EXTRACT(YEAR FROM data_emissao) <= ?) AND " +
                            "(EXTRACT(MONTH FROM data_emissao) >= ? AND EXTRACT(MONTH FROM data_emissao) <= ?) " +
                            "GROUP BY EXTRACT(YEAR FROM data_emissao), EXTRACT(MONTH FROM data_emissao), co_usuario;"; 
String SQLutil =            "SELECT  co_usuario, CONSULTOR.no_usuario,   brut_salario, data_emissao, " +
                            "EXTRACT(YEAR FROM data_emissao) AS anno, EXTRACT(MONTH FROM data_emissao) AS mes, " +
                            "sum(valor) VALOR, " +
                            "sum(valor) - (sum(valor) * (total_imp_inc / 100)) as receita_liquida,  " +
                            "sum(valor) * (total_imp_inc / 100) as monto_imp,    " +
                            "(sum(valor) - (sum(valor) * (total_imp_inc / 100))) * (comissao_cn / 100) as valor_comissao, " +
                            "(sum(valor) - (sum(valor) * (total_imp_inc / 100)) ) - (brut_salario + ((sum(valor)  " +
                            "- (sum(valor) * (total_imp_inc / 100))) * (comissao_cn / 100))) AS lucro " +
                            "FROM caol.cao_fatura X, 	 " +
                            "(SELECT co_os, A.co_usuario, no_usuario,brut_salario    " +
                                    "FROM caol.cao_usuario A INNER JOIN caol.permissao_sistema B ON A.co_usuario = B.co_usuario    " +
                                    "INNER JOIN caol.cao_os C  ON B.co_usuario = C.co_usuario    " +
                                    "INNER JOIN caol.cao_salario D ON C.co_usuario = D.co_usuario    " +
                                    "WHERE B.in_ativo = 'S' AND  ( B.co_tipo_usuario <= 2)  )  AS CONSULTOR " +
                                    "WHERE X.co_os = CONSULTOR.co_os  AND  data_emissao BETWEEN ? AND ?  AND co_usuario IN "; 
String SQLwher =            "GROUP BY EXTRACT(YEAR FROM data_emissao), EXTRACT(MONTH FROM data_emissao), co_usuario " +
                            "ORDER BY  co_usuario, EXTRACT(YEAR FROM data_emissao), EXTRACT(MONTH FROM data_emissao);";
                // ('carlos.arruda', 'anapaula.chiodaro')
    @Override
    public void searchConsultant(Consultor consultant) {

        System.out.println(consultant.getCo_usuario() + consultant.getNo_usuario() + " Registrada");
        System.out.println(consultant.getCo_usuario() + " Registrada");
    }

    @Override
    public void constUsuario(String id) {

    }

    private Consultor convertir(ResultSet rs) throws SQLException {
        String codigo = rs.getString("co_usuario");
        String nombre = rs.getString("no_usuario");
        Consultor consultor = new Consultor(codigo, nombre);
        consultor.setCo_usuario(rs.getString("co_usuario"));
        consultor.setNo_usuario(rs.getString("no_usuario"));
        return consultor;
    }

    @Override
    public List<Consultor> listarConsultValidos( ) {

        connect_bd conexion = new connect_bd();
        Connection conn = null;
        PreparedStatement statm = null;
        ResultSet rs = null;
        List<Consultor>  consultors = new ArrayList<>();
        try {
            conn = conexion.conectar();
            statm = conn.prepareStatement(SQLCons);
            
            rs = statm.executeQuery();
            while (rs.next()){
                consultors.add(convertir(rs));
            }
            
            
        } catch (SQLException e) {
            System.out.println("Ocurrio un error  " + e.getMessage());
        } finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error :" + e.getMessage());
                }
            }
            if (statm != null) {
                try {
                    statm.close();
                } catch (Exception e) {
                    System.out.println("Error :" + e.getMessage());
                }}
        }
        return consultors;
 
    }

    @Override
    public Consultor obtener(String codigo) {

        connect_bd conexion = new connect_bd(); //DriverManager.getConnection("jdbc:mysql://localhost:3306/caol",  "root", "");
        Connection conn = null;
        PreparedStatement statm = null;
        ResultSet rs = null;
        Consultor a = null;
        try {
            conn  = conexion.conectar();
            statm = conn.prepareStatement(consulta);
            statm.setString(4, codigo);
            rs = statm.executeQuery();
            
            if (rs.next()) {
                a = convertir(rs);
            } else {
                System.out.println("no hay registros");
            }

        } catch (SQLException e) {
            System.out.println("Ocurrio un error  " + e.getMessage());
        } finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error :" + e.getMessage());
                }
            }
            if (statm != null) {
                try {
                    statm.close();
                } catch (Exception e) {
                    System.out.println("Error :" + e.getMessage());
                }}
        }
        return a;
  
    }

    private Utilidades listUtilidades(ResultSet rs) throws SQLException {
        String codigo = rs.getString("co_usuario");
        String nombre = rs.getString("no_usuario");
        Double mo_sala  = rs.getDouble("brut_salario");
        long dt_anno = rs.getInt("anno");
        long dt_mees = rs.getInt("mes");
        Double movalor = rs.getDouble ("VALOR");
        Double ga_liqu = rs.getDouble ("receita_liquida");
        Double mo_impt = rs.getDouble ("monto_imp");
        Double va_comi = rs.getDouble ("valor_comissao");
        Double va_lucr = rs.getDouble ("lucro");

        System.out.println("Hay REgis" + codigo + " " + movalor);
        Utilidades utilidads = new Utilidades(codigo, nombre, mo_sala, dt_anno, dt_mees, movalor, ga_liqu, mo_impt, va_comi, va_lucr);
        utilidads.setCo_usuario(rs.getString("co_usuario"));
        utilidads.setNo_usuario(rs.getString("no_usuario"));
        utilidads.setMo_brutsal(rs.getDouble ("brut_salario"));
        utilidads.setDt_annouti(rs.getInt("anno"));
        utilidads.setDt_meesuti(rs.getInt("mes"));
        utilidads.setMo_ntvalor(rs.getDouble ("VALOR"));
        utilidads.setMo_liquido(rs.getDouble ("receita_liquida"));
        utilidads.setMo_impuest(rs.getDouble ("monto_imp"));
        utilidads.setMo_comisio(rs.getDouble ("valor_comissao"));
        utilidads.setMo_tolucro(rs.getDouble ("lucro"));

        return utilidads;
    }



   

    public static void main(String[] args)  throws SQLException{
        Connection conn3 = null;
        
        try {
         
            ConsultantServ dao = new ConsultantServ();
            //List<Consultor> consultors = dao.listarConsultValidos();
            //List<Consultor> consultors = dao.listarConsultValidos();
             //List<Utilidades> utilidades =  dao.utilidadesxMes("carlos.arruda", 2006, 2009, 2, 4,"");
             
             List<Utilidades> utilidades =  dao.utilidadesxMes("carlos.arruda", 2006, 2009, 2, 4,"");
            for (Utilidades c: utilidades){
                //System.out.println(c.toString());
                System.out.println(c.getCo_usuario() + c.getNo_usuario() + " " +  Long.toString(c.getDt_meesuti()));
            } 

            /* for (Consultor c: consultors){
                
                System.out.println(c.getCo_usuario());
            }   */  
        } finally {
            if (conn3 != null){
                conn3.close();
            }
        }    
        
        
    }

    @Override
    public List<Utilidades> utilidadesxMes(String co_usuario, Integer anno_ini, Integer anno_fin, Integer mees_ini,
            Integer mees_fin, String conecSQL) {
                connect_bd conexion = new connect_bd();
                Connection conn = null;
                PreparedStatement statm = null;
                ResultSet rs = null;
                //conecSQL = " ('carlos.arruda', 'carlos.carvalho') ";
               // String ids[] = { "carlos.arruda", "carlos.carvalho"};
               String meini = mees_ini + "";
               if (meini.length() == 1){
                   meini = "0" + meini;
               }
               String fechaini = anno_ini +"-" + meini + "-01";
               System.out.println(fechaini);
               String fechafin = ultimoDiaMes(mees_fin,anno_fin);
                SQLutil = SQLutil + conecSQL + SQLwher;
                //SQLutil.replace("conjunto", conecSQL);
                System.out.println(SQLutil);
                List<Utilidades>  utilidades = new ArrayList<>();
                try {
                    conn = conexion.conectar();
                    statm = conn.prepareStatement(SQLutil);
                    statm.setString(1,fechaini);
                    statm.setString(2, fechafin);
                    
                    //statm.se String(1,ids);
                    /* statm.setInt(1,anno_ini);
                    statm.setInt(2, anno_fin);
                    statm.setInt(3, mees_ini);
                    statm.setInt(4,mees_fin);  */
                    rs = statm.executeQuery();
                    
                    while (rs.next()){
                        utilidades.add(listUtilidades(rs));
                    }
                    
                    
                } catch (SQLException e) {
                    System.out.println("Ocurrio un error  " + e.getMessage());
                } finally{
                    if (rs != null) {
                        try {
                            rs.close();
                        } catch (SQLException e) {
                            System.out.println("Error :" + e.getMessage());
                        }
                    }
                    if (statm != null) {
                        try {
                            statm.close();
                        } catch (Exception e) {
                            System.out.println("Error :" + e.getMessage());
                        }}

                       /*  try {
                            connect_bd.cerrarConexiones(conn, statm, rs);
                        } catch (Exception e) {
                            System.out.println(e);
                            
                        } */
                        
                }
                return utilidades;
    }

    public String ultimoDiaMes(int mesFin, int anioFin){

        String mfin = Integer.toString(mesFin);
        String afin = Integer.toString(anioFin);

        Calendar calFin = Calendar.getInstance();		
        calFin.set(Integer.parseInt(afin), Integer.parseInt(mfin), 1);
        calFin.set(Integer.parseInt(afin), Integer.parseInt(mfin), calFin.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date fechaFin = calFin.getTime();
        
        
        String fechaFinStr = String.format("%1$tY-%1$tm-%1$td", fechaFin);
        System.out.println(fechaFinStr);
        return fechaFinStr;
    }
   

    

    
}
