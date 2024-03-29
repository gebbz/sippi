/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emmanuel
 */
public class SubObra implements ISubtotal
{
    
    private int id;
    private String nombre;
    private double gananciaMonto;
    private double gananciaPorcentaje;
    private boolean flagGananciaPorcentaje;
    private String descripcion;
    protected List<SubObraXAdicional> adicionales;
    protected List<SubObraXAlquilerCompra> alquileresCompras;
    protected List<SubObraXTarea> tareas;
    protected List<SubObraXHerramienta> herramientas;
    protected List<SubObraXMaterial> materiales;
    private boolean subObraGeneralALaPlanificacion;

    public SubObra() {
        adicionales = new ArrayList<SubObraXAdicional>();
        alquileresCompras = new ArrayList<SubObraXAlquilerCompra>();
        tareas = new ArrayList<SubObraXTarea>();
        herramientas = new ArrayList<SubObraXHerramienta>();
        materiales = new ArrayList<SubObraXMaterial>();
        subObraGeneralALaPlanificacion=false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SubObraXAdicional> getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(List<SubObraXAdicional> adicionales) {
        this.adicionales = adicionales;
    }

    public List<SubObraXAlquilerCompra> getAlquileresCompras() {
        return alquileresCompras;
    }

    public void setAlquileresCompras(List<SubObraXAlquilerCompra> alquileresCompras) {
        this.alquileresCompras = alquileresCompras;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getGananciaMonto() 
    {
       return gananciaMonto;
        
        
    }
    
    @Deprecated
    public void setGananciaMonto(double gananciaMonto) 
    {
       this.gananciaMonto = gananciaMonto;
       
        
    }
    
    @Deprecated
    public void setGananciaPorcentaje(double gananciaPorcentaje) {
       this.gananciaPorcentaje = gananciaPorcentaje;            
    }

    public void setearGananciaMonto(double gananciaMonto) 
    {
        try{
            flagGananciaPorcentaje=false;
            this.gananciaMonto = gananciaMonto;
            //gananciaPorcentaje = (gananciaMonto/calcularSubtotal())*100;
            gananciaPorcentaje = (double)Math.round((gananciaMonto/calcularSubtotalSinBeneficio())*100);
        }catch(Exception ex){
            System.err.println("Se produjo un error grave al Guardar El monto de Ganancia");
        }
    }

    public double getGananciaPorcentaje() {
        return gananciaPorcentaje;
    }

    public void setearGananciaPorcentaje(double gananciaPorcentaje) {
        try {
            flagGananciaPorcentaje=true;
            this.gananciaPorcentaje = gananciaPorcentaje;
            //gananciaMonto =(gananciaPorcentaje/100)*calcularSubtotal();
            gananciaMonto = (double) Math.round(((gananciaPorcentaje / 100) * calcularSubtotalSinBeneficio()) * 100) / 100;
        } catch (Exception ex) {
            System.err.println("Se produjo un error grave al Guardar El monto de Ganancia");
        }
    }

    public List<SubObraXHerramienta> getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(List<SubObraXHerramienta> herramientas) {
        this.herramientas = herramientas;
    }

    public List<SubObraXMaterial> getMateriales() {
        return (List<SubObraXMaterial>)materiales;
    }

    public void setMateriales(List<SubObraXMaterial> materiales) {
        this.materiales = materiales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<SubObraXTarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<SubObraXTarea> tareas) {
        this.tareas = tareas;
    }

    public void addAdicional(SubObraXAdicional soxa){
        this.adicionales.add(soxa);
    }
    public void addAlquilerCompra(SubObraXAlquilerCompra soxac){
        this.alquileresCompras.add(soxac);
    }
    public void addTarea(SubObraXTarea soxt){
        this.tareas.add(soxt);
    }
    public void addHerramienta(SubObraXHerramienta soxh){
        this.herramientas.add(soxh);
    }
    public void addMaterial(SubObraXMaterial soxm){
        ((List<SubObraXMaterial>)this.materiales).add(soxm);
    }
    public boolean eliminarTarea(int id){
        for (int i = 0; i < tareas.size(); i++)
        {
            if ((tareas.get(i).hashCode())==id) 
            {
             tareas.remove(i);
             return true;
            }
        }
        /*for (SubObraXTarea soxt: tareas) 
        {
            if (soxt.getId()==id) 
            {
             tareas.remove(soxt); 
             return true;
            }
        }*/
        return false;
    }
    @Override
    public double calcularSubtotal() 
    {
        double beneficio=0.0;
        if(flagGananciaPorcentaje){
            beneficio = (getGananciaPorcentaje()/100)*calcularSubtotalSinBeneficio();
        }
        else{
            beneficio = getGananciaMonto();
        }
        return (calcularSubtotalSinBeneficio()+beneficio);
    }

    
    public double calcularSubtotalSinBeneficio() 
    {
        double monto = 0;
        // 1-Material 
        // 2-Tareas
        // 3-Herramientas
        // 4-Adicionales
        // 5-Compras
                // Materiales
                for (int j = 0; j < getMateriales().size(); j++) 
                {
                    monto += getMateriales().get(j).calcularSubtotal();
                }
                // Tareas
                for (int j = 0; j < getTareas().size(); j++) 
                {
                    monto += getTareas().get(j).calcularSubtotal();
                }
                // Herramientas
                for (int j = 0; j < getHerramientas().size(); j++) 
                {
                    monto += getHerramientas().get(j).calcularSubtotal();
                }
                // Adicionales
                for (int j = 0; j < getAdicionales().size(); j++) 
                {
                    monto += getAdicionales().get(j).calcularSubtotal();
                } 
                // Compras
                for (int j = 0; j < getAlquileresCompras().size(); j++) 
                {
                    monto += getAlquileresCompras().get(j).calcularSubtotal();
                }    
         return Math.rint(monto*100)/100; // Redondeo
    }

    /**
     * @return the flagGananciaPorcentaje
     */
    public boolean isFlagGananciaPorcentaje() {
        return flagGananciaPorcentaje;
    }
    
    // NO BORRAR; ERROR DE HIBERNATE, POR MAS Q SEA VIEJO
    //Existe solo porque lo necesita hibernate. Este método no deberia ser accedido externamente.
    private void setFlagGananciaPorcentaje(boolean flag) 
    {
        flagGananciaPorcentaje=flag;
    }
    
    public SubObraXMaterial getSubObraXMaterialPorHash(int hashCode)
    {
        for (int i = 0; i < materiales.size(); i++) {
            
            SubObraXMaterial soxm =materiales.get(i);
            if(soxm.hashCode()==hashCode)
            { return soxm;}            
        }
        return null;
    }
    
    public SubObraXAdicional getSubObraXAdicionalPorHash(int hashCode)
    {
        for (int i = 0; i < adicionales.size(); i++) {
            
            SubObraXAdicional soxa =adicionales.get(i);
            if(soxa.hashCode()==hashCode)
            { return soxa;}            
        }
        return null;
    }
    
    public SubObraXAlquilerCompra getSubObraXAlquilerCompraPorHash(int hashCode)
    {
        for (int i = 0; i < alquileresCompras.size(); i++) {
            
            SubObraXAlquilerCompra soxac =alquileresCompras.get(i);
            if(soxac.hashCode()==hashCode)
            { return soxac;}            
        }
        return null;
    }
    public SubObraXTarea getSubObraXTareaPorHash(int hashCode)
    {
        for (int i = 0; i < tareas.size(); i++) {
            
            SubObraXTarea soxt =tareas.get(i);
            if(soxt.hashCode()==hashCode)
            { return soxt;}            
        }
        return null;
    }
    
    public SubObraXHerramienta getSubObraXHerramientaPorHash(int hashCode)
    {
        for (int i = 0; i < herramientas.size(); i++) {
            
            SubObraXHerramienta soxh =herramientas.get(i);
            if(soxh.hashCode()==hashCode)
            { return soxh;}            
        }
        return null;
    }

    /**
     * @return the subObraGeneralALaPlanificacion
     */
    public boolean esSubObraGeneralALaPlanificacion() {
        return subObraGeneralALaPlanificacion;
    }

    /**
     * @param subObraGeneralALaPlanificacion the subObraGeneralALaPlanificacion to set
     */
    public void setSubObraGeneralALaPlanificacion(boolean subObraGeneralALaPlanificacion) {
        this.subObraGeneralALaPlanificacion = subObraGeneralALaPlanificacion;
    }
    
    
    
}
