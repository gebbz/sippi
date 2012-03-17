/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Cotizacion;
import modelo.CotizacionModificada;
import modelo.DetalleSubObraXTarea;
import modelo.DetalleSubObraXTareaModif;
import modelo.SubObra;
import modelo.SubObraModificada;
import modelo.SubObraXAdicional;
import modelo.SubObraXAdicionalModif;
import modelo.SubObraXAlquilerCompra;
import modelo.SubObraXAlquilerCompraModif;
import modelo.SubObraXHerramienta;
import modelo.SubObraXHerramientaModif;
import modelo.SubObraXMaterial;
import modelo.SubObraXMaterialModif;
import modelo.SubObraXTarea;
import modelo.SubObraXTareaModif;
import util.HibernateUtil;

/**
 *
 * @author Emmanuel
 */
public class Trazabilidad {
    
    /**
     * Este método permite copiar la cotización a una cotizacionModificada para ser tratada en Planificación.
     * @param cot La cotización original
     * @return La cotización modificada
     */
    public CotizacionModificada copiarCotizacionACotizacionModificada(Cotizacion cot){
        CotizacionModificada cotMod = null;
        try
        {
            HibernateUtil.beginTransaction();
            cotMod = new CotizacionModificada();
            cotMod.setCotizacionOriginal(cot);

            Iterator<SubObra> itSubObras = cot.getSubObras().iterator();
            while(itSubObras.hasNext()){
                SubObra subObra = itSubObras.next();
                SubObraModificada subObraMod = new SubObraModificada();
                List<SubObraXAdicionalModif> subObraXAdicionalModifs = new ArrayList<SubObraXAdicionalModif>();
                List<SubObraXAlquilerCompraModif> subObraXAlquilerCompraModifs = new ArrayList<SubObraXAlquilerCompraModif>();
                List<SubObraXHerramientaModif> subObraXHerramientaModifs = new ArrayList<SubObraXHerramientaModif>();
                List<SubObraXMaterialModif> subObraXMaterialModifs = new ArrayList<SubObraXMaterialModif>();
                List<SubObraXTareaModif> subObraXTareaModifs = new ArrayList<SubObraXTareaModif>();

                Iterator<SubObraXAdicional> itSubObraXAdcional = subObra.getAdicionales().iterator();
                while(itSubObraXAdcional.hasNext()){
                    SubObraXAdicional subObraXAdicional = itSubObraXAdcional.next();
                    SubObraXAdicionalModif soXAdicionalModif = new SubObraXAdicionalModif();
                    soXAdicionalModif.setOriginal(subObraXAdicional);
                    soXAdicionalModif.setCantDias(subObraXAdicional.getCantDias());
                    soXAdicionalModif.setCantOperarios(subObraXAdicional.getCantOperarios());
                    soXAdicionalModif.setDescripcion(subObraXAdicional.getDescripcion());
                    soXAdicionalModif.setPrecioUnitario(subObraXAdicional.getPrecioUnitario());
                    soXAdicionalModif.setTipoAdicional(subObraXAdicional.getTipoAdicional());
                    subObraXAdicionalModifs.add(soXAdicionalModif);
                    HibernateUtil.getSession().save(soXAdicionalModif);
                }
                subObraMod.setAdicionales(subObraXAdicionalModifs);

                Iterator<SubObraXAlquilerCompra> itSubObraXAlquilerCompra = subObra.getAlquileresCompras().iterator();
                while(itSubObraXAlquilerCompra.hasNext()){
                    SubObraXAlquilerCompra subObraXAlquilerCompra = itSubObraXAlquilerCompra.next();
                    SubObraXAlquilerCompraModif subObraXAlquilerCompraModif = new SubObraXAlquilerCompraModif();
                    subObraXAlquilerCompraModif.setOriginal(subObraXAlquilerCompra);
                    subObraXAlquilerCompraModif.setCantidad(subObraXAlquilerCompraModif.getCantidad());
                    subObraXAlquilerCompraModif.setDescripcion(subObraXAlquilerCompra.getDescripcion());
                    subObraXAlquilerCompraModif.setPrecioUnitario(subObraXAlquilerCompraModif.getPrecioUnitario());
                    subObraXAlquilerCompraModif.setTipoAlquilerCompra(subObraXAlquilerCompra.getTipoAlquilerCompra());
                    subObraXAlquilerCompraModifs.add(subObraXAlquilerCompraModif);
                    HibernateUtil.getSession().save(subObraXAlquilerCompraModif);
                }
                subObraMod.setAlquileres(subObraXAlquilerCompraModifs);

                Iterator<SubObraXHerramienta> itSubObraXHerramienta = subObra.getHerramientas().iterator();
                while(itSubObraXHerramienta.hasNext()){
                    SubObraXHerramienta subObraXHerramienta = itSubObraXHerramienta.next();
                    SubObraXHerramientaModif subObraXHerramientaModif = new SubObraXHerramientaModif();
                    subObraXHerramientaModif.setOriginal(subObraXHerramienta);
                    subObraXHerramientaModif.setCantDias(subObraXHerramienta.getCantDias());
                    subObraXHerramientaModif.setCantHoras(subObraXHerramienta.getCantDias());
                    subObraXHerramientaModif.setHerramienta(subObraXHerramienta.getHerramienta());
                    subObraXHerramientaModif.setObservaciones(subObraXHerramienta.getObservaciones());
                    subObraXHerramientaModifs.add(subObraXHerramientaModif);
                    HibernateUtil.getSession().save(subObraXHerramientaModif);
                }
                subObraMod.setHerramientas(subObraXHerramientaModifs);

                Iterator<SubObraXMaterial> itSubObraXMaterial = subObra.getMateriales().iterator();
                while(itSubObraXMaterial.hasNext()){
                    SubObraXMaterial subObraXMaterial = itSubObraXMaterial.next();
                    SubObraXMaterialModif subObraXMaterialModif = new SubObraXMaterialModif();
                    subObraXMaterialModif.setOriginal(subObraXMaterial);
                    subObraXMaterialModif.setCantidad(subObraXMaterial.getCantidad());
                    subObraXMaterialModif.setMaterial(subObraXMaterial.getMaterial());
                    subObraXMaterialModif.setPrecioUnitario(subObraXMaterial.getPrecioUnitario());
                    subObraXMaterialModifs.add(subObraXMaterialModif);
                    HibernateUtil.getSession().save(subObraXMaterialModif);

                }
                subObraMod.setMateriales(subObraXMaterialModifs);

                Iterator<SubObraXTarea> itSubObraXTarea = subObra.getTareas().iterator();
                while(itSubObraXTarea.hasNext()){
                    SubObraXTarea subObraXTarea = itSubObraXTarea.next();
                    SubObraXTareaModif subObraXTareaModif = new SubObraXTareaModif();
                    subObraXTareaModif.setOriginal(subObraXTarea);
                    subObraXTareaModif.setObservaciones(subObraXTarea.getObservaciones());
                    subObraXTareaModif.setNombre(subObraXTarea.getNombre());
                    subObraXTareaModif.setTipoTarea(subObraXTarea.getTipoTarea());
                    List<DetalleSubObraXTareaModif> detalleMods = new ArrayList<DetalleSubObraXTareaModif>();
                    Iterator<DetalleSubObraXTarea> itDetalleSOXT = subObraXTarea.getDetalles().iterator();
                    while(itDetalleSOXT.hasNext()){
                        DetalleSubObraXTarea detalle = itDetalleSOXT.next();
                        DetalleSubObraXTareaModif detalleMod = new DetalleSubObraXTareaModif();
                        detalleMod.setOriginal(detalle);
                        detalleMod.setCantHorasAl100(detalle.getCantHorasAl100());
                        detalleMod.setCantHorasAl50(detalle.getCantHorasAl50());
                        detalleMod.setCantHorasNormales(detalle.getCantHorasNormales());
                        detalleMod.setCantidadPersonas(detalle.getCantidadPersonas());
                        detalleMod.setCostoXHoraNormal(detalle.getCostoXHoraNormal());
                        detalleMod.setRangoEmpleado(detalle.getRangoEmpleado());
                        detalleMods.add(detalleMod);
                        HibernateUtil.getSession().save(detalleMod);
                    }
                    subObraXTareaModif.setDetallesMod(detalleMods);
                    subObraXTareaModifs.add(subObraXTareaModif);
                    HibernateUtil.getSession().save(subObraXTareaModif);
                }
                subObraMod.setTareas(subObraXTareaModifs);

                subObraMod.setSubObraOriginal(subObra);

                cotMod.getSubObra().add(subObraMod);
                HibernateUtil.getSession().save(subObraMod);
            }
            HibernateUtil.getSession().save(cotMod);
            HibernateUtil.getSession().getTransaction().commit();
        }
        catch(Exception ex)
        {
            System.out.println("Se ha producido un error al intentar  crear la Cotización Modificada: \n"+ ex.getMessage());
            HibernateUtil.rollbackTransaction();
        }
        return cotMod;
    }
}