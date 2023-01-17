package com.mytestemp.datosModel;

/**
 * Representa el Modelo de un Consultor
 * @author jcamacho Ene. 2023
 * @version 1.0
 */


public class Consultor {
    public String co_usuario;
    public String no_usuario;
   
    
    public Consultor() {
    }
/**
 * Construct
 * @param co_usuario
 * @param no_usuario
 */

    
public Consultor(String co_usuario, String no_usuario) {
    this.co_usuario = co_usuario;
    this.no_usuario = no_usuario;
}
public String getCo_usuario() {
    return co_usuario;
}
public void setCo_usuario(String co_usuario) {
    this.co_usuario = co_usuario;
}
public String getNo_usuario() {
    return no_usuario;
}
public void setNo_usuario(String no_usuario) {
    this.no_usuario = no_usuario;
}

    


}
