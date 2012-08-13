/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Iuga
 */
public class RecepcionOrdenDeCompra {
    
    public static final String ESTADO_PENDIENTE = "Pendiente";
    public static final String ESTADO_ANULADA   = "Anulada";
    public static final String ESTADO_RECIBIDA_PARCIALMENTE = "Recibida Parcialmente";
    public static final String ESTADO_RECIBIDA_TOTALMENTE = "Recibida Totalmente";
    
    private int id = 0;
    private String estado;
    private String observaciones;
    
    private List<DetalleRecepcionOrdenDeCompra> recepcionesParciales;

    public RecepcionOrdenDeCompra() {
        recepcionesParciales = new ArrayList<DetalleRecepcionOrdenDeCompra>();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<DetalleRecepcionOrdenDeCompra> getRecepcionesParciales() {
        return recepcionesParciales;
    }

    public void setRecepcionesParciales(List<DetalleRecepcionOrdenDeCompra> recepcionesParciales) {
        this.recepcionesParciales = recepcionesParciales;
    }
    
    public void addRecepcionesParciales(DetalleRecepcionOrdenDeCompra recepcionParcial) {
        this.recepcionesParciales.add(recepcionParcial);
    }    
    
}