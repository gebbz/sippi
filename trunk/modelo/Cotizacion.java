package modelo;

import java.util.Date;
import java.util.List;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : Cotizacion.java
//  @ Date : 08/10/2010
//  @ Author : 
//
//




public class Cotizacion {
    private int id;
    private Date vencimiento;
    private Date tiempoDeEntrega;
    private Date fechaEmision;
    private Proveedor proveedor;
    private int cantDiasVigencia;
    private float costoTotal;
    private float porcentajeIVA;
    private List<DetalleMaterial> detalle;
    public void crear() {

    }

    public void mostrarDetalle() {

    }

    public void mostrarProveedor() {

    }

    public Cotizacion() {
    }

    public int getCantDiasVigencia() {
        return cantDiasVigencia;
    }

    public void setCantDiasVigencia(int cantDiasVigencia) {
        this.cantDiasVigencia = cantDiasVigencia;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public List<DetalleMaterial> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleMaterial> detalle) {
        this.detalle = detalle;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public float getPorcentajeIVA() {
        return porcentajeIVA;
    }

    public void setPorcentajeIVA(float porcentajeIVA) {
        this.porcentajeIVA = porcentajeIVA;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Date getTiempoDeEntrega() {
        return tiempoDeEntrega;
    }

    public void setTiempoDeEntrega(Date tiempoDeEntrega) {
        this.tiempoDeEntrega = tiempoDeEntrega;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }
}