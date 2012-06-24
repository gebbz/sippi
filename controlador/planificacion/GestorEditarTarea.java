/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.planificacion;


import java.util.Iterator;
import modelo.PlanificacionXXX;
import modelo.TareaPlanificacion;
import vista.planificacion.PantallaEditarTarea;

/**
 *
 * @author Emmanuel
 */
public class GestorEditarTarea implements IGestorPlanificacion{
    private PantallaEditarTarea pantalla;
    private TareaPlanificacion tarea;

    // GESTORES
    private GestorEditarPlanificacion gestorPadre;
    private GestorEditarTarea gestorTareaPadre;

    // LISTA DE GESTORES
    private GestorPlanificacionDatosGenerales gestorDatosGenerales;
    private GestorPlanificacionSubTareas gestorSubTareas;
    private GestorPlanificacionAsigEmpleados gestorAsigEmpleados;
    private GestorPlanificacionHerramientas gestorHerramientas;
    private GestorPlanificacionMateriales gestorMateriales;
    private GestorPlanificacionAlquileresCompras gestorAlquileresCompras;
    private GestorEditarTareaDetalles gestorEsfuerzo;

    public GestorEditarTarea(GestorEditarPlanificacion gestor)
    {
        this.gestorPadre = gestor;
    }

    public GestorEditarTarea getGestorTareaPadre() {
        return gestorTareaPadre;
    }

    public void setGestorTareaPadre(GestorEditarTarea gestorTareaPadre) {
        this.gestorTareaPadre = gestorTareaPadre;
    }

    public PantallaEditarTarea getPantalla() {
        return pantalla;
    }
    
    public void setPantalla(PantallaEditarTarea pantalla) {
        this.pantalla = pantalla;
    }

    public void seleccionarTarea(int idTarea)
    {
        if(idTarea != 0) // Si se trata de modificar una existente
        {
            this.tarea = gestorPadre.getPlanificacion().buscarTarea(idTarea);
        }
        else // Si se trata de una tarea nueva
        {
            this.tarea = new TareaPlanificacion();
        }
    }

    public void seleccionarTarea(TareaPlanificacion tarea){
        this.tarea = tarea;
    }

    public GestorPlanificacionDatosGenerales getGestorDatosGenerales()
    {
        if(this.gestorDatosGenerales==null)
        {
            this.gestorDatosGenerales = new GestorPlanificacionDatosGenerales(this);
        }
        return gestorDatosGenerales;
    }

    public GestorPlanificacionSubTareas getGestorSubTareas()
    {
        if(this.gestorSubTareas==null)
        {
            this.gestorSubTareas = new GestorPlanificacionSubTareas(this);
        }
        return gestorSubTareas;
    }
    
    public GestorEditarTareaDetalles getGestorEsfuerzo()
    {
        if(this.gestorEsfuerzo==null)
        {
            this.gestorEsfuerzo = new GestorEditarTareaDetalles(this);
        }
        return gestorEsfuerzo;
    }

    public GestorPlanificacionAsigEmpleados getGestorAsigEmpleados()
    {
        if(this.gestorAsigEmpleados==null)
        {
            this.gestorAsigEmpleados = new GestorPlanificacionAsigEmpleados(this);
        }
        return gestorAsigEmpleados;
    }

    public GestorPlanificacionHerramientas getGestorHerramientas()
    {
        if(this.gestorHerramientas==null)
        {
            this.gestorHerramientas = new GestorPlanificacionHerramientas(this);
        }
        return gestorHerramientas;
    }

    public GestorPlanificacionMateriales getGestorMateriales()
    {
        if(this.gestorMateriales==null)
        {
            this.gestorMateriales = new GestorPlanificacionMateriales(this);
        }
        return gestorMateriales;
    }

    public GestorPlanificacionAlquileresCompras getGestorAlquileresCompras()
    {
        if(this.gestorAlquileresCompras==null)
        {
            this.gestorAlquileresCompras = new GestorPlanificacionAlquileresCompras(this);
        }
        return gestorAlquileresCompras;
    }

    @Override
    public void refrescarPantallas() {
        gestorPadre.refrescarPantallas();
        pantalla.actualizarPantallas();
    }

    @Override
    public PlanificacionXXX getPlanificacion() {
        return this.gestorPadre.getPlanificacion();
    }

    @Override
    public TareaPlanificacion getTareaActual() {
        return this.tarea;
    }

    public void guardarCambios() 
    {
        if(gestorTareaPadre == null){
            this.gestorPadre.refrescarPantallas();
            this.pantalla.setVisible(false);
        }
        else
        {
            boolean banMod = false;
            Iterator<TareaPlanificacion> subtareas = this.gestorTareaPadre.getTareaActual().getSubtareas().iterator();
            while(subtareas.hasNext())
            {
                TareaPlanificacion st = subtareas.next();
                if(st.hashCode() == this.tarea.hashCode())
                {
                    int index = this.gestorTareaPadre.getTareaActual().getSubtareas().indexOf(st);
                    this.gestorTareaPadre.getTareaActual().getSubtareas().set(index, this.tarea);
                    banMod = true;
                    break;
                }
            }
            if(!banMod)
            {
                this.gestorTareaPadre.getTareaActual().addSubTarea(tarea);
            }
        }
        gestorPadre.cerrarVentanaEditarTarea(tarea.hashCode());
    }

    public GestorEditarPlanificacion getGestorPadre() {
        return gestorPadre;
    }

//    public void agregarSubTarea() {
//        this.gestorTareaPadre.getTareaActual().addSubTarea(tarea);
//    }

    public boolean eliminarComoSubTarea(StringBuilder mensaje) {
        System.out.println("[DEBUG] Eliminar como SubTarea");
        if(PlanificacionUtils.puedeEliminarseTarea(getTareaActual()))
        {
            if(PlanificacionUtils.eliminarTarea(this.getGestorTareaPadre().getGestorPadre().getPlanificacion(), tarea))
            {
                // Se elimino correctamente
                mensaje.append("Se eliminó correctamente la Tarea");
                return true;
            }
            else
            {
                mensaje.append("Se produjo un error al borrar la Tarea");
                return false;
            }
        }
        else
        {
            // Avisar que esta tarea no puede eliminarse
            mensaje.append("Esta tarea no puede eliminarse\nCompruebe que no tiene SubTareas cargadas");
            return false;
        }
    }
    
    public void actualizarPantallaPadre(){
        this.gestorPadre.refrescarPantallas();
    }
}