package modelo;

//
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import vista.planificacion.ArbolDeTareasTipos;

//
//  @ Author : Fran
//
//
public class TareaPlanificacion
{

    private int id;
    private List<TareaPlanificacion> subtareas;
    private String nombre;
    private TipoTarea tipoTarea;
    private String observaciones;
    private List<AsignacionEmpleadoPlanificacion> asignacionesEmpleados;
    private List<PlanificacionXHerramienta> herramientas;
    private List<PlanificacionXMaterial> materiales;
    private List<PlanificacionXAlquilerCompra> alquilerCompras;
    private Date fechaInicio;
    private Date fechaFin;
    private int idTareaGantt;
    private SubObraXTareaModif tareaCotizada;    
    private List<DetalleTareaPlanificacion> detalles;
    

    public TareaPlanificacion() {
        this.subtareas = new ArrayList<TareaPlanificacion>();
        this.asignacionesEmpleados = new ArrayList<AsignacionEmpleadoPlanificacion>();
        this.herramientas = new ArrayList<PlanificacionXHerramienta>();
        this.materiales = new ArrayList<PlanificacionXMaterial>();
        this.alquilerCompras = new ArrayList<PlanificacionXAlquilerCompra>();
        this.tipoTarea = new TipoTarea();
        this.tipoTarea.setNombre("NORMAL?");
        this.observaciones = new String();
        this.detalles= new ArrayList<DetalleTareaPlanificacion>();
       
    }
    
    public TareaPlanificacion(SubObraXTareaModif tareaCotizada) {
        this.subtareas = new ArrayList<TareaPlanificacion>();
        this.asignacionesEmpleados = new ArrayList<AsignacionEmpleadoPlanificacion>();
        this.herramientas = new ArrayList<PlanificacionXHerramienta>();
        this.materiales = new ArrayList<PlanificacionXMaterial>();
        this.alquilerCompras = new ArrayList<PlanificacionXAlquilerCompra>();
        this.tipoTarea = new TipoTarea();
        this.tipoTarea.setNombre("NORMAL?");
        this.observaciones = new String();
        this.detalles= new ArrayList<DetalleTareaPlanificacion>();
        
        
        this.tareaCotizada=tareaCotizada;
        this.nombre=tareaCotizada.getNombre();
        this.tipoTarea=tareaCotizada.getTipoTarea();
        this.observaciones=tareaCotizada.getObservaciones();
        
        
        for (int i = 0; i < tareaCotizada.getDetallesMod().size(); i++) 
        {
           DetalleTareaPlanificacion detalleNuevaTarea=new DetalleTareaPlanificacion(tareaCotizada.getDetallesMod().get(i));
           detalles.add(detalleNuevaTarea);
            
        }
       
    }

    public List<PlanificacionXAlquilerCompra> getAlquilerCompras() {
        return alquilerCompras;
    }

    public void setAlquilerCompras(List<PlanificacionXAlquilerCompra> alquilerCompras) {
        this.alquilerCompras = alquilerCompras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<AsignacionEmpleadoPlanificacion> getAsignacionesEmpleados() {
        return asignacionesEmpleados;
    }

    public void setAsignacionesEmpleados(List<AsignacionEmpleadoPlanificacion> asignacionesEmpleados) {
        this.asignacionesEmpleados = asignacionesEmpleados;
    }

    public List<PlanificacionXHerramienta> getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(List<PlanificacionXHerramienta> herramientas) {
        this.herramientas = herramientas;
    }

    public List<PlanificacionXMaterial> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<PlanificacionXMaterial> materiales) {
        this.materiales = materiales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<TareaPlanificacion> getSubtareas() {
        return subtareas;
    }

    public void setSubtareas(List<TareaPlanificacion> subtareas) {
        this.subtareas = subtareas;
    }

    public TipoTarea getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(TipoTarea tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getOrden() {
        return idTareaGantt;
    }

    public void setOrden(int orden) {
        this.idTareaGantt = orden;
    }

    public int getIdTareaGantt() {
        return idTareaGantt;
    }

    public void setIdTareaGantt(int idTareaGantt) {
        this.idTareaGantt = idTareaGantt;
    }

    public SubObraXTareaModif getTareaCotizada() {
        return tareaCotizada;
    }

    public void setTareaCotizada(SubObraXTareaModif tareaCotizada) {
        this.tareaCotizada = tareaCotizada;
    }
    
    public void addSubTarea(TareaPlanificacion subTarea)
    {
        this.subtareas.add(subTarea);
    }
    
    public TareaPlanificacion buscarSubTarea(int idSubTarea)
    {
        TareaPlanificacion tarea=null;
        for (int i = 0; i < subtareas.size(); i++) {
            
            if(subtareas.get(i).getId()==idSubTarea)
            {
                tarea=subtareas.get(i);
                break;
            }
            else
            {
                tarea=subtareas.get(i).buscarSubTarea(idSubTarea);
                if(tarea!=null)
                {break;}
            }
        }
        return tarea;
    }
    public TareaPlanificacion buscarSubTareaPorHash(int hashSubTarea)
    {
        TareaPlanificacion tarea=null;
        for (int i = 0; i < subtareas.size(); i++) {
            
            if(subtareas.get(i).hashCode()==hashSubTarea)
            {
                tarea=subtareas.get(i);
                break;
            }
            else
            {
                tarea=subtareas.get(i).buscarSubTareaPorHash(hashSubTarea);
                if(tarea!=null)
                {break;}
            }
        }
        return tarea;
    }
    
    public TareaPlanificacion buscarSubTareaPorIdTareaCotizada(int idTarea)
    {
        TareaPlanificacion tarea=null;
        for (int i = 0; i < subtareas.size(); i++) {
            
            if(subtareas.get(i).getTareaCotizada().getId()==idTarea)
            {
                tarea=subtareas.get(i);
                break;
            }
            else
            {
                tarea=subtareas.get(i).buscarSubTareaPorIdTareaCotizada(idTarea);
                if(tarea!=null)
                {break;}
            }
        }
        return tarea;        
    }
    public TareaPlanificacion buscarSubTareaPorHashTareaCotizada(int hashTarea)
    {
        TareaPlanificacion tarea=null;
        for (int i = 0; i < subtareas.size(); i++) {
            
            if(subtareas.get(i).getTareaCotizada()!=null && subtareas.get(i).getTareaCotizada().hashCode()==hashTarea)
            {
                tarea=subtareas.get(i);
                break;
            }
            else
            {
                tarea=subtareas.get(i).buscarSubTareaPorHashTareaCotizada(hashTarea);
                if(tarea!=null)
                {break;}
            }
        }
        return tarea;        
    }
    
    public TareaPlanificacion buscarTareaPorIdTareaGantt(int idTareaGantt)
    {
        TareaPlanificacion tarea=null;
        for (int i = 0; i < subtareas.size(); i++) {
            
            if(subtareas.get(i).getIdTareaGantt()==idTareaGantt)
            {
                tarea=subtareas.get(i);
                break;
            }
            else
            {
                tarea=subtareas.get(i).buscarTareaPorIdTareaGantt(idTareaGantt);
                if(tarea!=null)
                {break;}
            }
        }
        return tarea;        
    }    
    
    public boolean agregarMaterialCotizacion(SubObraXMaterialModif materialCotizacion)
    {        
        //Veo q no se repita
        for (int i = 0; i < materiales.size(); i++) {
            if(materiales.get(i).getMaterialCotizacion().getId()==materialCotizacion.getId())
            {
                return false;
            }
        }
        //Creo y agrego el recurso a la lista
        PlanificacionXMaterial pm=new  PlanificacionXMaterial(materialCotizacion);
        materiales.add(pm);
        return true;        
    }
    
    public boolean agregarHerramientaCotizacion(SubObraXHerramientaModif herramientaCotizacion)
    {        
        //Veo q no se repita
        for (int i = 0; i < herramientas.size(); i++) {
            if(herramientas.get(i).getHerramientaCotizacion().getId()==herramientaCotizacion.getId())
            {
                return false;
            }
        }
        //Creo y agrego el recurso a la lista
        PlanificacionXHerramienta ph=new  PlanificacionXHerramienta(herramientaCotizacion);
        herramientas.add(ph);
        return true;        
    }
    
    public boolean agregarAlquilerCompraCotizacion(SubObraXAlquilerCompraModif alquilerCompraCotizacion)
    {        
        //Veo q no se repita
        for (int i = 0; i < alquilerCompras.size(); i++) {
            if(alquilerCompras.get(i).getAlquilerCompraCotizacion().getId()==alquilerCompraCotizacion.getId())
            {
                return false;
            }
        }
        //Creo y agrego el recurso a la lista
        PlanificacionXAlquilerCompra ph=new  PlanificacionXAlquilerCompra(alquilerCompraCotizacion);
        alquilerCompras.add(ph);
        return true;        
    }
    
    public boolean tieneMaterialCotizacion(int idMaterialCotizacion)
    {
        for (int i = 0; i < materiales.size(); i++) {
            if(materiales.get(i).getMaterialCotizacion().getId()==idMaterialCotizacion)
            {
                return true;
            }
        }
        return false;        
    }
    public boolean tieneHerramientaCotizacion(int idHerramientaCotizacion)
    {
        for (int i = 0; i < herramientas.size(); i++) {
            if(herramientas.get(i).getHerramientaCotizacion().getId()==idHerramientaCotizacion)
            {
                return true;
            }
        }
        return false;        
    }
    
    public boolean tieneAlquilerCompraCotizacion(int idAlquilerCompraCotizacion)
    {
        for (int i = 0; i < alquilerCompras.size(); i++) {
            if(alquilerCompras.get(i).getAlquilerCompraCotizacion().getId()==idAlquilerCompraCotizacion)
            {
                return true;
            }
        }
        return false;        
    }
    
    public boolean eliminarSubTareaPorHash(int hashTarea, boolean busquedaProfunda)
    {
        boolean eliminada=false;
        for (int i = 0; i < subtareas.size(); i++) {
            
            if(subtareas.get(i).hashCode()==hashTarea)
            {
                subtareas.remove(i);
                eliminada=true;
                break;
            }
            else
            {
                if(busquedaProfunda)
                {subtareas.get(i).eliminarSubTareaPorHash(hashTarea, busquedaProfunda);}
            }
        }  
        return eliminada;
    }
    
    public boolean eliminarSubTarea(int idTarea, boolean busquedaProfunda)
    {
        boolean eliminada=false;
        for (int i = 0; i < subtareas.size(); i++) {
            
            if(subtareas.get(i).getId()==idTarea)
            {
                subtareas.remove(i);
                eliminada=true;
                break;
            }
            else
            {
                if(busquedaProfunda)
                {subtareas.get(i).eliminarSubTarea(idTarea, busquedaProfunda);}
            }
        }  
        return eliminada;
    }
    
    
    /* Aca una idea sin terminar... ya fue, q venga nomas la horda de ifs
    public HashMap getRecursos()
    {return recursos;}    
    public boolean tieneRecursoCotizacion(int idRecurso, String tipoRecurso)
    {
        List<IRecursoCotizacion> listaRecursoTipoT;
        if(recursos.containsKey(tipoRecurso))
        {listaRecursoTipoT =  (List) recursos.get(recursos);    }
        else
        {return false;}
        for (int i = 0; i < listaRecursoTipoT.size(); i++) {
            if(listaRecursoTipoT.get(i).getAlquilerCompraCotizacion().getId()==idAlquilerCompraCotizacion)
            {
                return true;
            }
        }
        return false; 
    }*/
    
     
    ///////////////////////////////////////////
    /***
     * //Buscar camino desde tarea hasta primer padre
     * 
     * @param planificacion
     * @param incluirTareaBuscada
     * @param cortarEnTareaCotizada
     * @return 
     */
   public List<TareaPlanificacion> buscarCaminoHastaTareaConCotizacion(PlanificacionXXX planificacion, boolean incluirTareaBuscada, boolean cortarEnTareaCotizada)
    {
        //Necesario para pasar una boolean como referencia en vez de pasarlo por valor
        boolean[] todaviaNoPasoTareaCotizada= new boolean[1];
        todaviaNoPasoTareaCotizada[0]=true;
        
        
        List<TareaPlanificacion> tareasSuperiores=new ArrayList<TareaPlanificacion>();        
        int total=planificacion.getTareas().size();
        for (int i = 0; i < total; i++) 
        {   TareaPlanificacion actual=planificacion.getTareas().get(i); 
            todaviaNoPasoTareaCotizada[0]=true;
            if(actual.equals(this) )
            {  
                if(incluirTareaBuscada)
                {tareasSuperiores.add(0,actual);}
                return tareasSuperiores;   
            }
            else
            {                
              if(buscarCaminoEnTarea(actual, tareasSuperiores,  incluirTareaBuscada,cortarEnTareaCotizada,todaviaNoPasoTareaCotizada))
                {
                    
                    
                    if(!cortarEnTareaCotizada || (cortarEnTareaCotizada && todaviaNoPasoTareaCotizada[0]))
                    {tareasSuperiores.add(0,actual);}
                    
                     /*if(actual.getTareaCotizada()!=null)
                    {
                        todaviaNoPasoTareaCotizada[0]=false;
                    }**/
                     
                     
                     
                    break;
                }  
            }   
        }   
        
        return tareasSuperiores;
    }       
    private boolean buscarCaminoEnTarea(TareaPlanificacion tareaDondeBuscar,  List<TareaPlanificacion> tareasSuperiores,  boolean incluirTareaBuscada, boolean cortarEnTareaCotizada, boolean[] todaviaNoPasoTareaCotizada) 
    {
        for (int i = 0; i < tareaDondeBuscar.getSubtareas().size(); i++) 
        {   
            
            TareaPlanificacion actual=tareaDondeBuscar.getSubtareas().get(i); 
                        
            if(actual.equals(this))
            {  
                if(incluirTareaBuscada)
                {tareasSuperiores.add(0,actual);}
                if(actual.getTareaCotizada()!=null)
                {
                   todaviaNoPasoTareaCotizada[0]=false;
                }
                return true;
            }
            else
            {
                if((actual.getSubtareas()!=null)&&(!actual.getSubtareas().isEmpty()))
                {
                   if(buscarCaminoEnTarea(tareaDondeBuscar.getSubtareas().get(i), tareasSuperiores,  incluirTareaBuscada,cortarEnTareaCotizada, todaviaNoPasoTareaCotizada))
                   {
                       
                       if(!cortarEnTareaCotizada || (cortarEnTareaCotizada && todaviaNoPasoTareaCotizada[0]))
                        {
                            tareasSuperiores.add(0,actual);                        
                        }   
                       if(actual.getTareaCotizada()!=null)
                        {
                        todaviaNoPasoTareaCotizada[0]=false;
                        }
                        
                       return true;
                   }
                }
                
            }   
        }
        return false;
        
    }
    /////////////////////////////
    /**
     * Este metodo verifica si la tarea es descendiente de una tarea cotizada o ella misma es una tarea cotizada.
     * IMPORTANTE: Si es hija de una tarea cotizada en la subobra de gastos generales creada en planificacion, el resultado es FALSE
     * SOLAMENTE devuelve TRUE en caso de q sea o q sea hija de una tera cotizada normal y no de gastos generales.
     */
    public boolean esCotizadaODescendienteDeTareaCotizada(PlanificacionXXX planificacion)
    {
        //Este metodo podria optimizarse para q no haga uso de buscarCaminoHastaTareaConCotizacion() ... pero ya fue...
        List<TareaPlanificacion> tareasSuperioresTotales= buscarCaminoHastaTareaConCotizacion(planificacion,true,true);
        for (int i = 0; i < tareasSuperioresTotales.size(); i++) 
        {
                        
            //tareasSuperioresTotales incuye la tarea actual asi q no hace falta preguntar si .get(i!)!=null
            if (tareasSuperioresTotales.get(i).getTareaCotizada()!=null) 
            {//Esta tarea padre tiene una tarea cotizada
                
                //Es una tarea cotizada en cotizacion o es una tarea cotizada para gastos generales de planificacion)?
                for (int j = 0; j < planificacion.getCotizacion().getSubObraGeneral().getTareas().size(); j++) {
                    if(planificacion.getCotizacion().getSubObraGeneral().getTareas().get(j).equals(tareasSuperioresTotales.get(i).getTareaCotizada()))
                    {return false;}
                    
                }
                
                //Es una tarea cotizada en cotizacion
                return true;
            }
        }
        return false;
    }
    

    
    public List<DetalleTareaPlanificacion> getDetalles() {
        
        return detalles;
    }

    
    public void setDetalles(List<DetalleTareaPlanificacion> detalles) {
        this.detalles = detalles;
    }
    
    
    public void agreagarDetalle(DetalleTareaPlanificacion detalle) {
        this.detalles.add(detalle);
    }
    
    
    public DetalleTareaPlanificacion getDetalleParticular(int i) {
        return detalles.get(i);
    } 
    
    
    public double obtenerTotalDeHorasNormalesSinSubtareas()
    {
        double totalHorasNormales=0;
        for (DetalleTareaPlanificacion detalle: detalles) 
        {
            totalHorasNormales+=(detalle.getCantHorasNormales()*detalle.getCantidadPersonas());
        }
        return totalHorasNormales;
    }
    public double obtenerTotalDeHorasAl50SinSubtareas()
    {
        double totalHoras50=0;
        for (DetalleTareaPlanificacion detalle: detalles) 
        {
            totalHoras50+=(detalle.getCantHorasAl50()*detalle.getCantidadPersonas());
        }
        return totalHoras50;
    }
    public double obtenerTotalDeHorasAl100SinSubtareas()
    {
        double totalHoras100=0;
        for (DetalleTareaPlanificacion detalle: detalles) 
        {
            totalHoras100+=(detalle.getCantHorasAl100()*detalle.getCantidadPersonas());
        }
        return totalHoras100;
    }
    
    public double obtenerTotalDeHorasNormalesConSubtareas()
    {
        double totalHorasNormales=0;
        for (DetalleTareaPlanificacion detalle: detalles) 
        {
            totalHorasNormales+=(detalle.getCantHorasNormales()*detalle.getCantidadPersonas());
        }
        for (TareaPlanificacion subtarea: subtareas) 
        {
            totalHorasNormales+=subtarea.obtenerTotalDeHorasNormalesConSubtareas();
        }
        return totalHorasNormales;
    }
    public double obtenerTotalDeHorasAl50ConSubtareas()
    {
        double totalHoras50=0;
        for (DetalleTareaPlanificacion detalle: detalles) 
        {
            totalHoras50+=(detalle.getCantHorasAl50()*detalle.getCantidadPersonas());
        }
        for (TareaPlanificacion subtarea: subtareas) 
        {
            totalHoras50+=subtarea.obtenerTotalDeHorasAl50ConSubtareas();
        }
        return totalHoras50;
    }
    public double obtenerTotalDeHorasAl100ConSubtareas()
    {
        double totalHoras100=0;
        for (DetalleTareaPlanificacion detalle: detalles) 
        {
            totalHoras100+=(detalle.getCantHorasAl100()*detalle.getCantidadPersonas());
        }
        for (TareaPlanificacion subtarea: subtareas) 
        {
            totalHoras100+=subtarea.obtenerTotalDeHorasAl100ConSubtareas();
        }
        return totalHoras100;
    }
}