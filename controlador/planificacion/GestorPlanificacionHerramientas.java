/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.planificacion;

import java.util.ArrayList;
import java.util.List;
import modelo.PlanificacionXHerramienta;
import modelo.Planificacion;
import modelo.TareaPlanificacion;
import util.NTupla;
import vista.planificacion.PlanificacionHerramientas;

/**
 *
 * @author Emmanuel
 */
public class GestorPlanificacionHerramientas implements IGestorPlanificacion{

    private PlanificacionHerramientas pantalla;
    private GestorEditarTarea gestorPadre;    
    
    GestorPlanificacionHerramientas(GestorEditarTarea aThis) {
         System.out.println("GestorEditarTarea: "+aThis);
         this.gestorPadre = aThis;
    }

    public void setPantalla(PlanificacionHerramientas pantalla) {
        this.pantalla = pantalla;
    }
    
    public Planificacion getPlanificacion() {
        return this.gestorPadre.getPlanificacion();
    }

    public TareaPlanificacion getTareaActual() {
        return this.gestorPadre.getTareaActual();
    }

    public void refrescarPantallas() {
        this.gestorPadre.refrescarPantallas();
    }

    public ArrayList<NTupla> cargarDatos() {
        
        ArrayList<NTupla> filasHerramienta = new ArrayList<NTupla>();
        
        TareaPlanificacion tarea = this.gestorPadre.getTareaActual();
        List<PlanificacionXHerramienta> listaHerramientas = tarea.getHerramientas();
        for (int i = 0; i < listaHerramientas.size(); i++) {
            PlanificacionXHerramienta herr = listaHerramientas.get(i);
            if(herr.getHerramientaCotizacion()!=null && herr.getHerramientaCotizacion().getHerramienta()!=null)
            {
                NTupla nt = new NTupla(herr.hashCode());
                nt.setNombre(herr.getHerramientaCotizacion().getHerramienta().getNombre()+": "+herr.getHerramientaCotizacion().getHerramienta().getNroSerie());
                String[] datos = new String[1];
                datos[0] = String.valueOf(herr.getHorasAsignadas());
                nt.setData(datos);
                filasHerramienta.add(nt);
            }
        }
        
        return filasHerramienta;
    }
    
    public boolean eliminarAsignación(int hashPxH,boolean eliminoGastos)
    {
        ArrayList<TareaPlanificacion> tareas = PlanificacionUtils.getTodasTareasPlanificacion(getPlanificacion());
        for (int i = 0; i < tareas.size(); i++) {
            TareaPlanificacion tarea = tareas.get(i);
            for (int j = 0; j < tarea.getHerramientas().size(); j++) {
                PlanificacionXHerramienta pxh = tarea.getHerramientas().get(j);
                if(pxh.hashCode()==hashPxH)
                {
                    // Es mi asignacion
                    if(eliminoGastos)
                    {
                        // Elimino los gastos
                        // Esto es un borrador del algoritmo, no se me ocurre otra cosa
                        int horasBaul = pxh.getHerramientaCotizacion().getHorasDisponibles();
                        horasBaul = horasBaul - pxh.getHorasAsignadas();
                        pxh.getHerramientaCotizacion().setCantHoras(horasBaul);
                    }
                    // Elimino la asignacion
                    tarea.getHerramientas().remove(j);
                    return true;
                }
            }
        }
        return false;
    }

}
