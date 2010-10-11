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
    private String hib_flag_estado; // FALTARIA DETERMINAR LOS ESTADOS DEL DTE

    public HerramientaDeEmpresa() {
        this.hib_flag_estado = "modelo.EstadoHerramientaDeEmpresaDisponible";
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }

    public String getHib_flag_estado() {
        return hib_flag_estado;
    }

    public void setHib_flag_estado(String hib_flag_estado) {
        this.hib_flag_estado = hib_flag_estado;
    }

    /************************************************************
    *                    MANEJO DE ESTADOS                      *
    * ***********************************************************
    */

    public EstadoHerramienta getEstado(){
        if(this.id!=0) // Objeto no cargado
        {
            if(this.estado==null)
            {
                try {
                        EstadoHerramienta estadoAux = (EstadoHerramienta) Class.forName(this.hib_flag_estado).newInstance();
                        this.estado = estadoAux;
                        return estado;
                    }
                    catch (Exception ex)
                    {
                        System.out.println("No se encontro la clase Estado Concreto");
                    }
            }
            else{
                return this.estado;
            }
        }
        else{
            System.out.println("Carga el objeto antes de usarlo");
            return null;
        }
        return null;
    }

    public void setEstado(EstadoHerramienta estado) {
        this.estado = estado;
    }
}
