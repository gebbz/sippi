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




public class EstadoPedidoObraTerminado extends EstadoPedidoObra {

        public EstadoPedidoObraTerminado()
        {
            super();
            this.setNombre("Terminado");
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
        return false;
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
        return true;
    }

    @Override
    public boolean esSolicitado() {
        return false;
    }
}
