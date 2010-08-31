package modelo;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : EstadoPedidoObraSolicitado.java
//  @ Date : 15/06/2010
//  @ Author : 
//
//




public class EstadoPedidoObraCancelado extends EstadoPedidoObra {

    public EstadoPedidoObraCancelado()
    {
        super();
        this.setNombre("Cancelado");
    }
	
    @Override
    public boolean esPresupuestado() {
        return false;
    }

    @Override
    public boolean esPendiente() {
        return false;
    }

    @Override
    public boolean esConfirmado() {
        return false;
    }

    @Override
    public boolean esCancelado() {
        return true;
    }

    @Override
    public boolean esPlanificado() {
        return false;
    }

    @Override
    public boolean esEnEjecucion() {
        return false;
    }

    @Override
    public boolean esSuspendido() {
        return false;
    }

    @Override
    public boolean esTerminado() {
        return false;
    }

    @Override
    public boolean esSolicitado() {
        return false;
    }
}
