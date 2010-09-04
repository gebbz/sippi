package modelo;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : EstadoOrdenDeCompraRecibida.java
//  @ Date : 31/08/2010
//  @ Author : 
//
//




public class EstadoOrdenDeCompraRecibida extends EstadoOrdenDeCompra {

    public EstadoOrdenDeCompraRecibida() {
        super();
        this.setNombre("Recibida");
    }

    @Override
    public boolean esAnulada() {
        return false;
    }

    @Override
    public boolean esCancelada() {
        return false;
    }

    @Override
    public boolean esGenerada() {
        return false;
    }

    @Override
    public boolean esPendiente() {
        return false;
    }

    @Override
    public boolean esRecibida() {
        return true;
    }
//	public boolean registrarRecepcion() {
//
//	}

    public void setCancelado(OrdenDeCompra oc){
        oc.setHib_flag_estado("modelo.EstadoOrdenDeCompraCancelada");
        oc.setEstado(new EstadoOrdenDeCompraCancelada());
    }
}