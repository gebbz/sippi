package modelo;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : EstadoTallerDeCapacitacion.java
//  @ Date : 14/06/2010
//  @ Author : 
//
//

public abstract class EstadoTallerCapacitacion extends EstadoAbstracto
{

    public EstadoTallerCapacitacion()
    {
        super();
    }

    public boolean esAlta()
    {
        return false;
    }

    public boolean esBaja()
    {
        return false;
    }

    public void darBaja(TallerCapacitacion tc)
    {
        tc.setHib_flag_estado("modelo.EstadoTallerCapacitacionBaja");
        tc.setEstado(new EstadoTallerCapacitacionBaja());
    }

    public void darAlta(TallerCapacitacion tc)
    {
        tc.setHib_flag_estado("modelo.EstadoTallerCapacitacionAlta");
        tc.setEstado(new EstadoTallerCapacitacionAlta());
    }

}