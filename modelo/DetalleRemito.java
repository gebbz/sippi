package modelo;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : DetalleRemito.java
//  @ Date : 04/09/2010
//  @ Author : 
//
//

public class DetalleRemito {
    private int id;
    private double cantidad;
    private String descripcion;
    private DetalleOrdenDeCompra detalleOC;

    public DetalleRemito() {
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public DetalleOrdenDeCompra getDetalleOC() {
        return detalleOC;
    }

    public void setDetalleOC(DetalleOrdenDeCompra detalleOC) {
        this.detalleOC = detalleOC;
    }
}
