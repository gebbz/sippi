package modelo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : EstadoPedidoObra.java
//  @ Date : 14/06/2010
//  @ Author : Iuga
//
//

public abstract class EstadoPedidoObra extends EstadoAbstracto {
/**
        public EstadoPedidoObra()
        {
            super();
        }

        public boolean esActiva() {
            return false;
	}
	
	public boolean esConfirmada() {
            return false;
	}

        public boolean esPendiente() {
            return false;
	}
**/
        public abstract boolean esSolicitado();

        public abstract boolean esPresupuestado();

        public abstract boolean esPendiente();

        public abstract boolean esConfirmado();

        public abstract boolean esCancelado();

        public abstract boolean esPlanificado();

        public abstract boolean esEnEjecucion();

        public abstract boolean esSuspendido();

        public abstract boolean esTerminado();
       
}
