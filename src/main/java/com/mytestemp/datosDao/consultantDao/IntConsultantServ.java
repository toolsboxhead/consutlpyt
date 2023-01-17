package com.mytestemp.datosDao.consultantDao;



import java.util.List;

import com.mytestemp.datosModel.Consultor;
import com.mytestemp.datosModel.Utilidades;


public interface IntConsultantServ {

    public void searchConsultant(Consultor consultant);
    
    public void constUsuario(String id);

    List<Consultor> listarConsultValidos();

    Consultor obtener(String codigo);

    List<Utilidades> utilidadesxMes(String co_usuario, Integer anno_ini, Integer anno_fin, Integer mees_ini, Integer mees_fin, String parmSQL );

    


}
