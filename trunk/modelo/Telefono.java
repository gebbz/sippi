package modelo;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : Telefono.java
//  @ Date : 14/06/2010
//  @ Author : 
//
//




public class Telefono {
        private int id;
	private String numero;
	private TipoTelefono tipo;
	public void crear() {
	
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTelefono getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefono tipo) {
        this.tipo = tipo;
    }
	
        

	public TipoTelefono mostrarTipoTelefono() {
            return tipo;
	}
}
