/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.compras;

import vista.abms.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.DetalleOrdenDeCompra;
import modelo.DetalleRecepcionOrdenDeCompra;
import modelo.Herramienta;
import modelo.HerramientaDeEmpresa;
import modelo.ItemComprable;
import modelo.OrdenDeCompra;
import modelo.Proveedor;
import modelo.RecepcionOrdenDeCompra;
import modelo.RecursoEspecifico;
import org.hibernate.Hibernate;
import util.HibernateUtil;
import util.RecursosUtil;
import vista.gen.FiltroPasivo;

/**
 * @author Iuga
 */
public class FiltroPasivoOrdenesDeCompraConHerramienta extends FiltroPasivo{


    public FiltroPasivoOrdenesDeCompraConHerramienta() {
    }
    
    @Override
    public List Excecute(List lista) {
        
        List listaFinal = new ArrayList();
        
        System.out.println("Initial Size:"+lista.size());
        
        for (int i = 0; i < lista.size(); i++) {
            
            System.out.print("*");
            
            Object object = lista.get(i);
            if(object instanceof OrdenDeCompra)
            {
                OrdenDeCompra ordenDeCompra = (OrdenDeCompra)object;
                Iterator<RecepcionOrdenDeCompra> itRecepciones = ordenDeCompra.getRecepciones().iterator();
                while(itRecepciones.hasNext())
                {
                    RecepcionOrdenDeCompra recepcion = itRecepciones.next();
                    Iterator<DetalleRecepcionOrdenDeCompra> itDetalleRecepciones = recepcion.getRecepcionesParciales().iterator();
                    while(itDetalleRecepciones.hasNext())
                    {
                        DetalleRecepcionOrdenDeCompra detalleRecepcion = itDetalleRecepciones.next();
                        DetalleOrdenDeCompra detalle = detalleRecepcion.getDetalleOrdenDeCompra();
                        ItemComprable itemComprable = detalle.getItem();
                        if(itemComprable!=null && itemComprable.getItem()!=null && itemComprable.getItem() instanceof RecursoEspecifico)
                        {
                            RecursoEspecifico recursoEsp = (RecursoEspecifico) itemComprable.getItem();
                            if(!this.yaEstaAsociadaAUnaHerramientaDeEmpresa(recursoEsp))
                            {
                                listaFinal.add(ordenDeCompra);
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println("Final Size:"+listaFinal.size());
        
        return listaFinal;
    }  

    private boolean yaEstaAsociadaAUnaHerramientaDeEmpresa(RecursoEspecifico recursoEsp) {
        try {
                HibernateUtil.beginTransaction();
            Iterator<HerramientaDeEmpresa>  itHerramientaDeEmpresa = (Iterator<HerramientaDeEmpresa>)HibernateUtil.getSession().createQuery("FROM HerramientaDeEmpresa").iterate();
            while(itHerramientaDeEmpresa.hasNext())
            {
                HerramientaDeEmpresa herramientaDeEmpresa = itHerramientaDeEmpresa.next();
                if(recursoEsp.getId() == herramientaDeEmpresa.getRecursoEsp().getId())
                {
                    return true;
                }
            }
            HibernateUtil.commitTransaction();
            return false;
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            return false;
        }
    }
}

