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




public class EstadoPedidoObraEnEjecucion extends EstadoPedidoObra {

        public EstadoPedidoObraEnEjecucion()
        {
            super();
            this.setNombre("EnEjecucion");
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
        return true;
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

    void setSuspendido(PedidoObra aThis) {
        aThis.setHib_flag_estado("modelo.EstadoPedidoObraSuspendido");
        aThis.setEstado(new EstadoPedidoObraSuspendido());
    }

    void setTerminado(PedidoObra aThis) {
        aThis.setHib_flag_estado("modelo.EstadoPedidoObraTerminado");
        aThis.setEstado(new EstadoPedidoObraTerminado());
    }

    void setCancelado(PedidoObra aThis) {
        aThis.setHib_flag_estado("modelo.EstadoPedidoObraCancelado");
        aThis.setEstado(new EstadoPedidoObraCancelado());
    }
}
