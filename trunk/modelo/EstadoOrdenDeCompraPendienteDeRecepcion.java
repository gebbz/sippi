package modelo;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : EstadoOrdenDeCompraPendienteDeRecepcion.java
//  @ Date : 31/08/2010
//  @ Author : 
//
//




public class EstadoOrdenDeCompraPendienteDeRecepcion extends EstadoOrdenDeCompra {

    public EstadoOrdenDeCompraPendienteDeRecepcion() {
        super();
        this.setNombre("Pendiente de Recepción");
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
        return true;
    }

    @Override
    public boolean esRecibida() {
        return false;
    }
//	public boolean imprimir() {
//
//	}

    public void setCancelado(OrdenDeCompra oc){
        oc.setHib_flag_estado("modelo.EstadoOrdenDeCompraCancelada");
        oc.setEstado(new EstadoOrdenDeCompraCancelada());
    }

    public void setRecibida(OrdenDeCompra oc){
        oc.setHib_flag_estado("modelo.EstadoOrdenDeCompraRecibida");
        oc.setEstado(new EstadoOrdenDeCompraRecibida());
    }
}