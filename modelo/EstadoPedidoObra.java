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




public class EstadoPedidoObra {

        private int id;
        private String nombre;

	public void crear() {
	
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
