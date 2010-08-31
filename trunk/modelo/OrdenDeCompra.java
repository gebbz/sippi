package modelo;

import java.util.Date;
import java.util.List;

/**
 * Descripción:
 * @version 1.0
 * @author Iuga
 * @cambios
 * @todo
 */

public class OrdenDeCompra {

    private int id;
    private int numero;
    private Date fechaDePedido;
    private Date fechaDeRecepcion;
    private Proveedor proveedor;
    private List detalle;
    private FormaDePago formaDePago;
    private EstadoOrdenDeCompra estado;
    private String hib_flag_estado;

    public OrdenDeCompra() {
        this.hib_flag_estado = "modelo.EstadoOrdenDeCompraGenerada";
    }

    public Date getFechaDePedido() {
        return fechaDePedido;
    }

    public void setFechaDePedido(Date fechaDePedido) {
        this.fechaDePedido = fechaDePedido;
    }

    public Date getFechaDeRecepcion() {
        return fechaDeRecepcion;
    }

    public void setFechaDeRecepcion(Date fechaDeRecepcion) {
        this.fechaDeRecepcion = fechaDeRecepcion;
    }

    public String getHib_flag_estado() {
        return hib_flag_estado;
    }

    public void setHib_flag_estado(String hib_flag_estado) {
        this.hib_flag_estado = hib_flag_estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<DetalleOrdenDeCompra> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleOrdenDeCompra> detalle) {
        this.detalle = detalle;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

/*************************************************************
 *                    MANEJO DE ESTADOS                      *
 * ***********************************************************
 */
    
    public EstadoOrdenDeCompra getEstado()
    {
        if(this.id!=0) // Objeto no cargado
        {
            if(this.estado==null)
            {
                try {
                        //Class estadoAux = Class.forName(this.hib_flag_estado);
                        EstadoOrdenDeCompra estadoAux = (EstadoOrdenDeCompra) Class.forName(this.hib_flag_estado).newInstance();
                        this.estado = estadoAux;
                        return estado;
                    }
                    catch (Exception ex)
                    {
                        System.out.println("No se encontro la clase Estado Concreto");
                    }
            }
            else
            {
                return this.estado;
            }

        }
        else
        {
            System.out.println("Carga el objeto antes de usarlo");
            return null;
        }
        return null;
    }

    public void setEstadoPendienteDeRecepcion()
    {
        if(this.id!=0) // Objeto no cargado
        {
            if(this.estado.esGenerada())
            {
                ((EstadoOrdenDeCompraGenerada)this.estado).setPendiente(this);
            }
        }
    }

    public void setEstadoRecibida()
    {
        if(this.id!=0) // Objeto no cargado
        {
            if(this.estado.esPendiente())
            {
                ((EstadoOrdenDeCompraPendienteDeRecepcion)this.estado).setRecibida(this);
            }
        }
    }


    public void setEstadoCancelado()
    {
        if(this.id!=0) // Objeto no cargado
        {
            if(this.estado.esGenerada()){
                ((EstadoOrdenDeCompraGenerada)this.estado).setCancelado(this);
            }
            else{
                if(this.estado.esPendiente()){
                    ((EstadoOrdenDeCompraPendienteDeRecepcion)this.estado).setCancelado(this);
                }
                else{
                    if(this.estado.esRecibida()){
                        ((EstadoOrdenDeCompraRecibida)this.estado).setCancelado(this);
                    }
                }
            }
        }
    }

    public void setEstado(EstadoOrdenDeCompra estado) {
        this.estado = estado;
    }

}
