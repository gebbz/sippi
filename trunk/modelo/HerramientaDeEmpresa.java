package modelo;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : HerramientaDeEmpresa.java
//  @ Date : 08/10/2010
//  @ Author : 
//
//




public class HerramientaDeEmpresa {
    private int id;
    private String nroSerie;
    private EstadoHerramienta estado;

    public HerramientaDeEmpresa() {
    }

    public EstadoHerramienta getEstado() {
        return estado;
    }

    public void setEstado(EstadoHerramienta estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }
}
