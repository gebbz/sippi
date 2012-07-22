/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.planificacion;

import controlador.utiles.gestorBDvarios;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.*;
import org.hibernate.Session;
import util.HibernateUtil;
import util.NTupla;
import util.Tupla;
import vista.planificacion.EditarTareaDetalles;
import vista.planificacion.EditarTareaDetallesABM;

/**
 *
 * @author Fran
 */
public class GestorEditarTareaDetalles implements IGestorPlanificacion{
    private EditarTareaDetalles pantallaLista;
    private EditarTareaDetallesABM pantallaABM;
    private GestorEditarTarea gestorPadre;
    private DetalleTareaPlanificacion detalleActual;  //SOLO LECTURA MIENTRAS NO SE PRESIONE ACEPTAR
    private DetalleTareaPlanificacion copiaDetalleActual;
    private DetalleTareaPlanificacion detallePadre;
    private DetalleTareaPlanificacion copiaDetallePadre;    
    private DetalleTareaPlanificacion copiaDetallePadre_nva;
    private DetalleTareaPlanificacion detalleConCotizacion;
    private DetalleTareaPlanificacion copiaDetalleConCotizacion;  
    
    
    private TareaPlanificacion copiaTareaConCotizacion;
    private TareaPlanificacion tareaConCotizacion;
    
    private TareaPlanificacion copiaTareaActual;
    private SubObraXTareaModif cotizacionTareaCotizada;
    private SubObraXTareaModif copiaCotizacionTareaCotizada;
    
    private DetalleSubObraXTareaModif detalleCotizacionTareaCotizada;
    private DetalleSubObraXTareaModif copiaDetalleCotizacionTareaCotizada;
    private TareaPlanificacion copiaTareaConDetallePadre;
    private TareaPlanificacion tareaConDetallePadre;
    //private SubObraXTarea copiaTareaCotizadaOriginal;
    private boolean modificacion=false;
    private boolean tareaHijaDePlanificacion;
   // private List<TareaPlanificacion> caminoTareas; 
    
    private int cantPersonas;
    private double cantHsNormales;
    private double cantHs100;
    private double cantHs50;
    private Especialidad especialidad;
    private double costoDetalle;
    
    
    //Solo para modificacion:
    private int cantPersonasOriginal;
    private double cantHsNormalesOriginal;
    private double cantHs100Original;
    private double cantHs50Original;
    private Especialidad especialidadOriginal;
    private double costoDetalleOriginal;

    public GestorEditarTareaDetalles(GestorEditarTarea gestorPadre){
        this.gestorPadre = gestorPadre;
        
        ///Para la parte que muestra el impacto en la tarea de cotizacion
        List<TareaPlanificacion> caminoTareas=gestorPadre.getTareaActual().buscarCaminoHastaTareaConCotizacion(gestorPadre.getPlanificacion(), true, true);
        tareaConCotizacion=caminoTareas.get(0);
        if(tareaConCotizacion.equals(gestorPadre.getTareaActual()))
        {tareaHijaDePlanificacion=true;}
        else
        {tareaHijaDePlanificacion=false;}
        
        
       //Realizo las copias de trabajo de la tarea que tiene cotizacion (puede ser la que tenemos o una superior)
        copiaTareaConCotizacion=new TareaPlanificacion(tareaConCotizacion);
        cotizacionTareaCotizada=tareaConCotizacion.getTareaCotizada();
        copiaCotizacionTareaCotizada=new SubObraXTareaModif(cotizacionTareaCotizada);
        copiaTareaConCotizacion.setTareaCotizada(copiaCotizacionTareaCotizada);
       
       
       
        
    }
    
  
    
    public TareaPlanificacion getCopiaTareaConConCotizacion()
    {        
        return copiaTareaConCotizacion;
    }
    
    public DetalleTareaPlanificacion getCopiaDetallePadre()
    {        
        return copiaDetallePadre;
    }
    
    public DetalleTareaPlanificacion getCopiaDetallePadre_nvo()
    {        
        return copiaDetallePadre_nva;
    }
     
    
    public void setPantallaLista(EditarTareaDetalles pantallaLista) {
        this.pantallaLista = pantallaLista;
    }

    public void setPantallaABM(EditarTareaDetallesABM pantallaABM) {
        this.pantallaABM = pantallaABM;
    }
    
    
    //Solo si se trata de una modificacion de detalle y no una creacion
    public void setDetalleAcutal(DetalleTareaPlanificacion detalleActual ){
                
        copiaTareaActual=new TareaPlanificacion(gestorPadre.getTareaActual());
        
        modificacion=true;        
        this.detallePadre=detalleActual.getPadre();        
        this.detalleActual = detalleActual;
        
        cantPersonasOriginal=detalleActual.getCantidadPersonas();
        cantHsNormalesOriginal=detalleActual.getCantHorasNormales();
        cantHs100Original=detalleActual.getCantHorasAl100();
        cantHs50Original=detalleActual.getCantHorasAl50();
        especialidadOriginal=detalleActual.getEspecialidad();
        costoDetalleOriginal=detalleActual.getCostoXHoraNormal();
        
        pantallaABM.tomarDatosDetalleModificado(gestorPadre.getPlanificacion().getTareaDeDetalle(detallePadre), detallePadre, detalleActual);
        armarCopiaDeEstructura(detalleActual);        
    }
    
    public void crearNuevoDetalleAcutal(DetalleTareaPlanificacion detallePadre ) {
        
        
        copiaTareaActual=new TareaPlanificacion(gestorPadre.getTareaActual());
        
        modificacion = false;
        this.detallePadre = detallePadre;
        detalleActual = new DetalleTareaPlanificacion();
        detalleActual.setPadre(detallePadre);
        
        detalleActual.setCostoXHoraNormal(detallePadre.getCostoXHoraNormal());
        detalleActual.setCantidadPersonas(detallePadre.getCantidadPersonas());
        detalleActual.setEspecialidad(detallePadre.getEspecialidad());
        
        
        armarCopiaDeEstructura(detalleActual);
        
    } 
    
    private void armarCopiaDeEstructura(DetalleTareaPlanificacion detalleActual)
    {
        
        ///////////////////////////////////////        
        copiaDetallePadre= new DetalleTareaPlanificacion(detallePadre);
        copiaDetallePadre_nva=null;
        tareaConDetallePadre=gestorPadre.getPlanificacion().getTareaDeDetalle(detallePadre);
        this.copiaTareaConDetallePadre= new TareaPlanificacion(tareaConDetallePadre);
        int indiceDetalleActual_=tareaConDetallePadre.getDetalles().indexOf(detallePadre);
            if(indiceDetalleActual_!=-1)
            {
                //copiaTareaConCotizacion.getDetalles().remove(indiceDetalleActual);
                copiaTareaConDetallePadre.getDetalles().remove(indiceDetalleActual_);
            }
            else
            {
                pantallaABM.MostrarMensaje(JOptionPane.ERROR_MESSAGE, "Error", "Ocurrio un error interno");
                Logger.getLogger(GestorEditarTareaDetalles.class.getName()).log(Level.SEVERE, "ERROR obteniendo indice de detalle padre");
            }
        copiaTareaConDetallePadre.agreagarDetalle(copiaDetallePadre, indiceDetalleActual_);
        
        //////////////////////////////////////
        
        //Reinicio el detalle copia
        if(this.copiaDetalleActual !=null)
        {
            int indiceDetalleActual=copiaTareaActual.getDetalles().indexOf(copiaDetalleActual);
            if(indiceDetalleActual!=-1)
            {
                //copiaTareaConCotizacion.getDetalles().remove(indiceDetalleActual);
                copiaTareaActual.getDetalles().remove(indiceDetalleActual);
            }
            else
            {
                pantallaABM.MostrarMensaje(JOptionPane.ERROR_MESSAGE, "Error", "Ocurrio un error interno");
                Logger.getLogger(GestorEditarTareaDetalles.class.getName()).log(Level.SEVERE, "ERROR obteniendo indice de detalle actual en tarea");
            }
         //   this.copiaDetalleActual = null;
        }
        
        copiaDetalleActual= new DetalleTareaPlanificacion(detalleActual);
        copiaDetalleActual.setPadre(copiaDetallePadre);
        //copiaTareaConCotizacion.agreagarDetalle(copiaDetalleAcutal); 
        copiaTareaActual.agreagarDetalle(copiaDetalleActual); 
        
        //////////////////////////////////////
        
        detalleConCotizacion=getDetalleConCotizacion(tareaConCotizacion, detallePadre);
        copiaDetalleConCotizacion= new DetalleTareaPlanificacion(detalleConCotizacion);
        int indiceDetalleActual_1=tareaConCotizacion.getDetalles().indexOf(detalleConCotizacion);
            if(indiceDetalleActual_1!=-1)
            {
               copiaTareaConCotizacion.getDetalles().remove(indiceDetalleActual_1);
            }
            else
            {
                pantallaABM.MostrarMensaje(JOptionPane.ERROR_MESSAGE, "Error", "Ocurrio un error interno");
                Logger.getLogger(GestorEditarTareaDetalles.class.getName()).log(Level.SEVERE, "ERROR obteniendo indice de detalle de tarea con cotizacion");
            }
        copiaTareaConCotizacion.agreagarDetalle(copiaDetalleConCotizacion, indiceDetalleActual_1);
        
        
        ///////////////////////////////////////////////////////////////
        detalleCotizacionTareaCotizada=detalleConCotizacion.getCotizado();
        copiaDetalleCotizacionTareaCotizada=new DetalleSubObraXTareaModif(detalleCotizacionTareaCotizada);
        int indiceDetalleActual_2=cotizacionTareaCotizada.getDetallesMod().indexOf(detalleCotizacionTareaCotizada);
            if(indiceDetalleActual_2!=-1)
            {
                copiaCotizacionTareaCotizada.getDetallesMod().remove(indiceDetalleActual_2);
            }
            else
            {
                pantallaABM.MostrarMensaje(JOptionPane.ERROR_MESSAGE, "Error", "Ocurrio un error interno");
                Logger.getLogger(GestorEditarTareaDetalles.class.getName()).log(Level.SEVERE, "ERROR obteniendo indice de detalle de tarea cotizada");
            }
        copiaCotizacionTareaCotizada.getDetallesMod().add(indiceDetalleActual_2, copiaDetalleCotizacionTareaCotizada);   
        
        copiaDetalleConCotizacion.setCotizado(copiaDetalleCotizacionTareaCotizada);
    }
    
    private DetalleTareaPlanificacion getDetalleConCotizacion(TareaPlanificacion tareaCotizada, DetalleTareaPlanificacion detalleDescendiente)
    {
        DetalleTareaPlanificacion detalleSuperior=detalleDescendiente;
        if(tareaCotizada.tieneDetalle(detalleSuperior))
        {return detalleSuperior;}
        else
        {
            detalleSuperior=detalleDescendiente.getPadre();
            if(detalleSuperior!=null)
            {return getDetalleConCotizacion(tareaCotizada, detalleSuperior);}
            else
            {return null;}
            
        }
    }
        
    
    public ArrayList<NTupla> mostrarTareasSuperiores()
    { 
        //List<TareaPlanificacion> tareas=new ArrayList<TareaPlanificacion>();
        List<TareaPlanificacion> tareasSuperiores=new ArrayList<TareaPlanificacion>();
        try{            
            tareasSuperiores= gestorPadre.getTareaActual().buscarCaminoHastaTareaConCotizacion(gestorPadre.getPlanificacion(),false,true);
            
            ArrayList<NTupla> tuplas = new ArrayList<NTupla>();
            if(tareasSuperiores.isEmpty())
            {
                NTupla tuplaV = new NTupla(-1);
                tuplaV.setNombre("No hay tareas de nivel superior");
                tuplas.add(tuplaV);
                return tuplas;
            }            
            
            for (int i = 0; i < tareasSuperiores.size(); i++)
            {
                TareaPlanificacion tt = (TareaPlanificacion)tareasSuperiores.get(i);
                
                NTupla tuplaT = new NTupla(tt.hashCode());
                tuplaT.setNombre(tt.getNombre());
                tuplaT.setData(tt);
                tuplas.add(tuplaT);
             }
            return tuplas;    
           }
           catch (Exception ex){
                System.out.println("No se ejecutar la consulta para cargar el combo de tareas de nivel superior :"+ex);
                pantallaABM.MostrarMensaje(JOptionPane.ERROR_MESSAGE,"Error!","Se produjo un error al cargar la lista Tareas de nivel superior");
                return null;
           }       
        }
    
     public ArrayList<NTupla> mostrarTiposEspecialidad()
    { //Session sesion;
        ArrayList<NTupla> tuplas;
        gestorBDvarios gestorBD = new gestorBDvarios();
        tuplas=gestorBD.getNTuplasTipoEspecialidades();
        /*//List<TipoEspecialidad> tiposEspecialidad=null;
        try{
            //sesion= HibernateUtil.getSession();
            
            //HibernateUtil.beginTransaction();
           //tiposEspecialidad=HibernateUtil.getSession().createQuery("from TipoEspecialidad").list();
           
            if(tiposEspecialidad==null)
            {return null;}           
            tuplas = new ArrayList<NTupla>();
            for (int i = 0; i < tiposEspecialidad.size(); i++)
            {
                TipoEspecialidad te = (TipoEspecialidad)tiposEspecialidad.get(i);

                NTupla tupla = new NTupla(te.getId());
                tupla.setNombre(te.getNombre());
                tupla.setData(te);

                tuplas.add(tupla);
            } 
            //HibernateUtil.commitTransaction();
           
        }
        catch (Exception ex)
        {System.out.println("No se ejecutar la consulta en mostrarTiposEspecialidad()");
       // HibernateUtil.rollbackTransaction();
        return null;}*/
        return tuplas;           
      }
 
public ArrayList<NTupla> mostrarRangos(TipoEspecialidad te)
        { Session sesion;

        
            gestorBDvarios gestorBD = new gestorBDvarios();
            List<Especialidad> rangos=gestorBD.getEspecialidades( te);
            /*try{
                sesion= HibernateUtil.getSession();
                sesion.beginTransaction();
                rangos=sesion.createQuery("from Especialidad").list();
                sesion.getTransaction().commit();
            }
            catch (Exception ex)
            {System.out.println("No se ejecutar la consulta en mostrarRangos()");
            return null;}*/
            if(rangos==null)
            {return null;}           
            ArrayList<NTupla> tuplas = new ArrayList<NTupla>();
            for (int i = 0; i < rangos.size(); i++)
            {
                Especialidad re = (Especialidad)rangos.get(i);
                
                NTupla nTupla = new NTupla(re.getId());
                nTupla.setNombre(re.getRango().getNombre());
                nTupla.setData(re.getPrecioHoraNormal());
                tuplas.add(nTupla);
             }
            return tuplas;           
        }
    
    /*public DetalleTareaPlanificacion getDetalleTareaActual() {
        return this.detalleAcutal;
    }*/

    public PlanificacionXXX getPlanificacion() {
        return this.gestorPadre.getPlanificacion();
    }

    public TareaPlanificacion getTareaActual() {
        return this.gestorPadre.getTareaActual();
    }

    public void refrescarPantallas() {
        this.gestorPadre.refrescarPantallas();
    }
    
    public void tomarCambios(int cantidadPersonas, double cantHorasNormales,  double cantHorasAl50,  double cantHorasAl100,  double costoXHoraNormal, Especialidad especialidad)
    {
        
        this.cantPersonas=cantidadPersonas;
        this.cantHsNormales=cantHorasNormales;
        this.cantHs50=cantHorasAl50;
        this.cantHs100=cantHorasAl100;
        this.especialidad=especialidad;
        this.costoDetalle=costoXHoraNormal;
        
        
        detalleActual.setCantHorasNormales(cantHorasNormales);
        detalleActual.setCantHorasAl50(cantHorasAl50);
        detalleActual.setCantHorasAl100(cantHorasAl100);
        detalleActual.setCostoXHoraNormal(costoXHoraNormal);
        detalleActual.setCantidadPersonas(cantidadPersonas);
        detalleActual.setEspecialidad(especialidad);
        
        armarCopiaDeEstructura(detalleActual);
        
        impactarDatos(cantidadPersonas, cantHorasNormales, cantHorasAl50, cantHorasAl100, costoXHoraNormal, especialidad, copiaTareaConCotizacion, copiaDetalleConCotizacion, copiaTareaConDetallePadre, copiaDetalleActual);
        
        
        pantallaABM.actualizar();
    }


    private void guardar()
    {
       if(modificacion)
        {
          int indiceDetalleActual=gestorPadre.getTareaActual().getDetalles().indexOf(detalleActual);
          
          if(indiceDetalleActual!=-1)
          {
              gestorPadre.getTareaActual().getDetalles().remove(indiceDetalleActual);
              gestorPadre.getTareaActual().getDetalles().add(indiceDetalleActual, copiaDetalleActual);
              
          }
          else
          {
              pantallaABM.MostrarMensaje(JOptionPane.ERROR_MESSAGE, "Error", "Ocurrio un error interno");
              Logger.getLogger(GestorEditarTareaDetalles.class.getName()).log(Level.SEVERE, "ERROR obteniendo indice de detalle actual en tarea");
          }
            
            
        }
        else
        {
            gestorPadre.getTareaActual().agreagarDetalle(copiaDetalleActual);
            
        }
        pantallaLista.actualizar(0, null, true, null);
    }

     public void impactarDatos( int cantidadPersonas,double cantHorasNormales, double cantHorasAl50, double cantHorasAl100, double costoXHoraNormal, Especialidad especialidad, TareaPlanificacion tareaConCotizacion, DetalleTareaPlanificacion detalleCotizado, TareaPlanificacion tareaConDetallePadre, DetalleTareaPlanificacion detalleActual) throws RuntimeException
    {
        if(tareaConCotizacion.getDetalles().indexOf(detalleCotizado)==-1)
        {
            throw new RuntimeException("El detalle no pertenece a la tarea pasada por parametro");
        }
        
        if(tareaConDetallePadre.getDetalles().indexOf(detalleActual.getPadre())==-1)
        {
            throw new RuntimeException("El detalle no pertenece a la tarea pasada por parametro");
        }
        
        
        
        
        int cant_aux;
        if(copiaDetallePadre_nva==null)
        {
            cant_aux=detalleActual.getPadre().getCantidadPersonas();
            
        }
        else
        {   
            cant_aux=detalleActual.getPadre().getCantidadPersonas()+copiaDetallePadre_nva.getCantidadPersonas();
        }
        if(cant_aux<cantidadPersonas)
        {
                throw new RuntimeException("La cantidad de personas no puede ser mayor a la actual");
        }
        if(especialidad==null)
        {
            throw new RuntimeException("La la especialidad no puede ser null");
        }
        
        boolean altoImpactoMasHoras=false;//=true  cambios en detalle en cotizacion modificada (agregar horas) - restar las horas al padre.
        boolean altoImpactoMenosPersonas=false;//=true  dividir detalle en tarea padre. usar horas de uno de ellos.
        boolean altoImpactoCosto=false; //=true  crear nuevo detalle en cotizacion modificada
        
        //Si todos son false, simplemente restar las horas al padre.
        
        if( !especialidad.equals(detalleActual.getPadre().getEspecialidad()) || detalleActual.getPadre().getCostoXHoraNormal() !=costoXHoraNormal)
        {
            altoImpactoCosto=true;
        }
        
        if(detalleActual.getPadre().getCantidadPersonas()!=cantidadPersonas)
        {
            altoImpactoMenosPersonas=true;
        }       
        
        
        if(altoImpactoMenosPersonas)
        {
            //divido al padre en 3:  padre original (puede estar siendo padre de otro detalle)
            //                       padre nuevo (el q sera padre de este) - tiene detalle cotizado propio (nuevo)
            //                       tio (division del padre con el sobrante de personas)  - tiene detalle cotizado propio (nuevo)
            
            //Resto a lo cotizado las horas del padre
            detalleActual.getPadre().getCotizado().setCantHorasNormales(detalleActual.getPadre().getCotizado().getCantHorasNormales() - detalleActual.getPadre().getCantHorasNormales());
            detalleActual.getPadre().getCotizado().setCantHorasAl50(detalleActual.getPadre().getCotizado().getCantHorasAl50() - detalleActual.getPadre().getCantHorasAl50());
            detalleActual.getPadre().getCotizado().setCantHorasAl100(detalleActual.getPadre().getCotizado().getCantHorasAl100() - detalleActual.getPadre().getCantHorasAl100());
            
            //Creo las 2 divisiones nuevas del padre (padre nuevo y tio)
            DetalleTareaPlanificacion tio= new DetalleTareaPlanificacion(detalleActual.getPadre());
            DetalleTareaPlanificacion padreNuevo= new DetalleTareaPlanificacion(detalleActual.getPadre());
            tio.setCantidadPersonas( tio.getCantidadPersonas() - cantidadPersonas); //tio.cantidadPersonas  -= cantidadPersonas; 
            padreNuevo.setCantidadPersonas(cantidadPersonas);
            
            
            //Creo las cotizaciones de tio y padre nuevo
            DetalleSubObraXTareaModif tioCotizado= new DetalleSubObraXTareaModif((DetalleSubObraXTareaModif)detalleActual.getPadre().getCotizado());
            DetalleSubObraXTareaModif padreNuevoCotizado= new DetalleSubObraXTareaModif((DetalleSubObraXTareaModif)detalleActual.getPadre().getCotizado());
            tioCotizado.setCantidadPersonas(detalleActual.getPadre().getCotizado().getCantidadPersonas() - cantidadPersonas); 
            padreNuevoCotizado.setCantidadPersonas(cantidadPersonas);
            tareaConCotizacion.getTareaCotizada().agreagarDetalle(tioCotizado);
            tareaConCotizacion.getTareaCotizada().agreagarDetalle(padreNuevoCotizado);
            
            //Resto las horas sobrantes al padre
            detalleActual.getPadre().setCantHorasNormales(detalleActual.getPadre().getCantHorasNormales() - padreNuevo.getCantHorasNormales());
            detalleActual.getPadre().setCantHorasAl50(detalleActual.getPadre().getCantHorasAl50() - padreNuevo.getCantHorasAl50());
            detalleActual.getPadre().setCantHorasAl100(detalleActual.getPadre().getCantHorasAl100() - padreNuevo.getCantHorasAl100());
            
            tio.setCotizado(tioCotizado);
            padreNuevo.setCotizado(padreNuevoCotizado);
            detalleActual.setPadre(padreNuevo);
            copiaDetallePadre_nva=tio;
            copiaDetallePadre=padreNuevo;
        }
        
         /*       
        if(altoImpactoCosto)
        {
            //divido al padre en 2:  padre original (puede estar siendo padre de otro detalle)
            //                       padre nuevo (el q sera padre de este) - tiene detalle cotizado propio (nuevo)
            
            //Resto a lo cotizado las horas que necesito
            detalleActual.getPadre().getCotizado().setCantHorasNormales(detalleActual.getPadre().getCotizado().getCantHorasNormales() - cantHorasNormales);
            detalleActual.getPadre().getCotizado().setCantHorasAl50(detalleActual.getPadre().getCotizado().getCantHorasAl50() - cantHorasAl50);
            detalleActual.getPadre().getCotizado().setCantHorasAl100(detalleActual.getPadre().getCotizado().getCantHorasAl100() - cantHorasAl100);
            
            //Creo la division nueva del padre (padre nuevo)
            DetalleTareaPlanificacion padreNuevo= new DetalleTareaPlanificacion(detalleActual.getPadre());
            padreNuevo.setCostoXHoraNormal(costoXHoraNormal);
            padreNuevo.setEspecialidad(especialidad);
            padreNuevo.setCantHorasNormales(cantHorasNormales);
            padreNuevo.setCantHorasAl50(cantHorasAl50);
            padreNuevo.setCantHorasAl100(cantHorasAl100);
            
            //Creo la cotizacion de  padre nuevo
            DetalleSubObraXTareaModif padreNuevoCotizado= new DetalleSubObraXTareaModif((DetalleSubObraXTareaModif)detalleActual.getPadre().getCotizado());
            tareaConCotizacion.getTareaCotizada().agreagarDetalle(padreNuevoCotizado);
            padreNuevoCotizado.setCostoXHoraNormal(costoXHoraNormal);
            padreNuevoCotizado.setEspecialidad(especialidad);
            padreNuevoCotizado.setCantHorasNormales(cantHorasNormales);
            padreNuevoCotizado.setCantHorasAl50(cantHorasAl50);
            padreNuevoCotizado.setCantHorasAl100(cantHorasAl100);
            
            padreNuevo.setCotizado(padreNuevoCotizado);
            
            //Resto las horas sobrantes al padre
            detalleActual.getPadre().setCantHorasNormales(detalleActual.getPadre().getCantHorasNormales() - padreNuevo.getCantHorasNormales());
            detalleActual.getPadre().setCantHorasAl50(detalleActual.getPadre().getCantHorasAl50() - padreNuevo.getCantHorasAl50());
            detalleActual.getPadre().setCantHorasAl100(detalleActual.getPadre().getCantHorasAl100() - padreNuevo.getCantHorasAl100());
                        
            
            detalleActual.setPadre(padreNuevo);
        }
        */
        
        
        
        if( detalleActual.getPadre().getCantHorasNormales() <(cantHorasNormales-cantHsNormalesOriginal))
        {
            detalleCotizado.getCotizado().setCantHorasNormales(detalleCotizado.getCantHorasNormales()+((cantHorasNormales-cantHsNormalesOriginal)-detalleActual.getPadre().getCantHorasNormales()));
            detalleActual.getPadre().setCantHorasNormales(0.0);
        }
        else
        {
           detalleActual.getPadre().setCantHorasNormales(detalleActual.getPadre().getCantHorasNormales() - (cantHorasNormales-cantHsNormalesOriginal)); 
        }
        
        if( detalleActual.getPadre().getCantHorasAl50() <(cantHorasAl50-cantHs50Original)) 
        {
            detalleCotizado.getCotizado().setCantHorasAl50(detalleCotizado.getCantHorasAl50()+((cantHorasAl50-cantHs50Original)-detalleActual.getPadre().getCantHorasAl50()));
            detalleActual.getPadre().setCantHorasAl50(0.0);
        }
        else
        {
            detalleActual.getPadre().setCantHorasAl50(detalleActual.getPadre().getCantHorasAl50() - (cantHorasAl50-cantHs50Original));
        }
        
        if( detalleActual.getPadre().getCantHorasAl100() < (cantHorasAl100-cantHs100Original))
        {
            detalleCotizado.getCotizado().setCantHorasAl100(detalleCotizado.getCantHorasAl100()+((cantHorasAl100-cantHs100Original)-detalleActual.getPadre().getCantHorasAl100()));
            detalleActual.getPadre().setCantHorasAl100(0.0);
        }
        else
        {
           detalleActual.getPadre().setCantHorasAl100(detalleActual.getPadre().getCantHorasAl100() - (cantHorasAl100-cantHs100Original));
        }
        ///////////////////////////////////////////////////
       
        /*
        //Devolucion de horas al padre (solo pasa en el caso de modificacion):        
       if( detalleActual.getCantHorasNormales() >cantHorasNormales)
        {
            detalleActual.getPadre().setCantHorasNormales(detalleActual.getPadre().getCantHorasNormales()+(detalleActual.getCantHorasNormales() - cantHorasNormales));
            //padre.setCantHorasNormales(0.0);
        }
        
        if( detalleActual.getCantHorasAl50() >cantHorasAl50) 
        {
            detalleActual.getPadre().setCantHorasAl50(detalleActual.getPadre().getCantHorasAl50()+(detalleActual.getCantHorasAl50()- cantHorasAl50));
            ///padre.setCantHorasAl50(0.0);
        }
        
        if( detalleActual.getCantHorasAl100() >cantHorasAl100)
        {
            detalleActual.getPadre().setCantHorasAl100(detalleActual.getPadre().getCantHorasAl100()+(detalleActual.getCantHorasAl100() - cantHorasAl100));
            //padre.setCantHorasAl100(0.0);
        }
        */
        detalleActual.setCantHorasNormales(cantHorasNormales);
        detalleActual.setCantHorasAl50(cantHorasAl50);
        detalleActual.setCantHorasAl100(cantHorasAl100);
        detalleActual.setCostoXHoraNormal(costoXHoraNormal);
        detalleActual.setCantidadPersonas(cantidadPersonas);
        detalleActual.setEspecialidad(especialidad);
       
    }
     
     
    public void guardarCambios()
    {
        if(!modificacion)
        {
            gestorPadre.getTareaActual().addDetalle(detalleActual);
        }
        //
        //TODO:
        //
        
        armarCopiaDeEstructura(detalleActual);
        
        impactarDatos(cantPersonas, cantHsNormales, cantHs50, cantHs100, costoDetalle, especialidad, tareaConCotizacion, detalleConCotizacion, tareaConDetallePadre, detalleActual);
        pantallaLista.inicializarVentana();
        
    }
    
    
    
    
    ////////////////////////////////////////////////////////////////////////

    
}
