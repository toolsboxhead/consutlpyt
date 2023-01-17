package com.mytestemp.datosModel;

public class Utilidades {
    private String co_usuario;
    private String no_usuario;
    private Double   mo_brutsal;
    private long   dt_annouti;
    private long   dt_meesuti;
    private Double   mo_ntvalor;
    private Double   mo_liquido;
    private Double   mo_impuest;
    private Double   mo_comisio;
    private Double   mo_tolucro;

    
    public Utilidades(String co_usuario, String no_usuario, Double  mo_brutsal, long dt_anno, Long dt_mees, Double mo_ntvalor,
    Double mo_liquido, Double mo_impuest, Double mo_comisio, Double mo_tolucro) {
        this.co_usuario = co_usuario;
        this.no_usuario = no_usuario;
        this.mo_brutsal = mo_brutsal;
        this.dt_annouti = dt_anno;
        this.dt_meesuti = dt_mees;
        this.mo_ntvalor = mo_ntvalor;
        this.mo_liquido = mo_liquido;
        this.mo_impuest = mo_impuest;
        this.mo_comisio = mo_comisio;
        this.mo_tolucro = mo_tolucro;
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


    public Double getMo_brutsal() {
        return mo_brutsal;
    }


    public void setMo_brutsal(Double mo_brutsal) {
        this.mo_brutsal = mo_brutsal;
    }


    public long getDt_annouti() {
        return dt_annouti;
    }


    


    public long getDt_meesuti() {
        return dt_meesuti;
    }


    


    public void setDt_annouti(long dt_annouti) {
        this.dt_annouti = dt_annouti;
    }


    public void setDt_meesuti(long dt_meesuti) {
        this.dt_meesuti = dt_meesuti;
    }


    public Double getMo_ntvalor() {
        return mo_ntvalor;
    }


    public void setMo_ntvalor(Double mo_ntvalor) {
        this.mo_ntvalor = mo_ntvalor;
    }


    public Double getMo_liquido() {
        return mo_liquido;
    }


    public void setMo_liquido(Double mo_liquido) {
        this.mo_liquido = mo_liquido;
    }


    public Double getMo_impuest() {
        return mo_impuest;
    }


    public void setMo_impuest(Double mo_impuest) {
        this.mo_impuest = mo_impuest;
    }


    public Double getMo_comisio() {
        return mo_comisio;
    }


    public void setMo_comisio(Double mo_comisio) {
        this.mo_comisio = mo_comisio;
    }


    public Double getMo_tolucro() {
        return mo_tolucro;
    }


    public void setMo_tolucro(Double mo_tolucro) {
        this.mo_tolucro = mo_tolucro;
    }


       

}
