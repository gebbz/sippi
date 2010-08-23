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




public class EstadoPedidoObraSuspendido extends EstadoPedidoObra {

        public EstadoPedidoObraSuspendido()
        {
            super();
            this.setNombre("Suspendido");
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
        return true;
    }

    @Override
    public boolean esTerminado() {
        return false;
    }

    @Override
    public boolean esSolicitado() {
        return false;
    }

    void setEnEjecucion(PedidoObra aThis) {
        aThis.setHib_flag_estado("modelo.EstadoPedidoObraEnEjecucion");
        aThis.setEstado(new EstadoPedidoObraEnEjecucion());
    }

    void setCancelado(PedidoObra aThis) {
        aThis.setHib_flag_estado("modelo.EstadoPedidoObraCancelado");
        aThis.setEstado(new EstadoPedidoObraCancelado());
    }
}
