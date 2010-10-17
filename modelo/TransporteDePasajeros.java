package modelo;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : TransporteDePasajeros.java
//  @ Date : 16/10/2010
//  @ Author : Fran a mano...
//
//

public class TransporteDePasajeros
{
    private int id;
    private Proveedor empresa;
    private int cantidad;
    private double precio;
    private Localidad origen;
    private Localidad destino;

    public TransporteDePasajeros()
    {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Proveedor getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Proveedor empresa) {
        this.empresa = empresa;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cant) {
        this.cantidad = cant;
    }
    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Localidad getOrigen() {
        return this.origen;
    }

    public void setOrigen(Localidad origen) {
        this.origen = origen;
    }

    public Localidad getDestino() {
        return this.destino;
    }

    public void setDestino(Localidad destino) {
        this.destino = destino;
    }
}
