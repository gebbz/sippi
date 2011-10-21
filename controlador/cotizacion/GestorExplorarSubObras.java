/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.cotizacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import modelo.Cotizacion;
import modelo.PedidoObra;
import modelo.SubObra;
import org.hibernate.Query;
import org.hibernate.Session;
import util.FechaUtil;
import util.HibernateUtil;
import util.Tupla;
import vista.cotizacion.CotizacionGraficoBean;
import vista.cotizacion.ExplorarSubObras;

/**
 *
 * @author Iuga
 */
public class GestorExplorarSubObras implements IGestorCotizacion{
    
    private ExplorarSubObras pantalla;
    private Session sesion;
    
    private PedidoObra obra;
    private Cotizacion cot;
    private SubObra subObra;
    
    private GestorEditarCotizacion gestorEditarCotizacion;
    
    private boolean necesita_guardar = false;
    

    public GestorExplorarSubObras(ExplorarSubObras pantalla) 
    {
        this.pantalla = pantalla;
        try 
        {    
            this.sesion = HibernateUtil.getSession();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }        
    }
    
    public void cargarCotizacion(int id_cot)
    {
        sesion.clear();
        this.cot  = (Cotizacion) sesion.load(Cotizacion.class,id_cot);
        this.obra = cot.buscarPedidoObra();   
        
        // Cargo la descripcion de la Obra
        cargarDescripcionObra();
        // Cargo lso datos de la cotizacion
        cargarDatosGeneralesCotizacion();
        
        refrescarVentana();
    }

    public PedidoObra getObra() {
        return obra;
    }

    private void refrescarVentana() 
    {
        // Cargo en el menú las SubObras
        cargarSubObras();
        // Cargo los datos de la Obra
        cargarDatosGeneralesObra();
        // Actualizo el monto Total
        cargarMontoTotal();
        // Mostrar Barra de Monto Actual VS Maximo
        cargarMontoActualVSMaximo();
        // Actualiza los graficos
        cargarGraficos();
        // Cambiar Interface segun el estado de la cotizacion
        refrescarVentanaSegunEstado();
    }    
    
    private void cargarSubObras()
    {
        this.pantalla.clearSubObrasList();
        Iterator<SubObra> it = this.cot.getSubObras().iterator();
        while(it.hasNext())
        {
            SubObra sb = (SubObra) it.next();
            Tupla nt = new Tupla(sb.hashCode(),sb.getNombre());
            this.pantalla.cargarSubObras(nt);
        }     
    }
    
    private void cargarDatosGeneralesObra()
    {
        String lbl_obra_nombre = this.obra.getNombre();
        String lbl_obra_planta = this.obra.getPlanta().getRazonSocial();
        String lbl_obra_lugar  = this.obra.getPlanta().getDomicilio().toString();
        String lbl_obra_montomax = "$"+String.valueOf(this.obra.getPresupuestoMaximo());
        String lbl_obra_fechaini = FechaUtil.getFecha(this.obra.getFechaInicio());
        String lbl_obra_fechafin = FechaUtil.getFecha(this.obra.getFechaFin());
        
        pantalla.llenarDatosGeneralesObra(lbl_obra_nombre, lbl_obra_planta, lbl_obra_lugar, lbl_obra_montomax, lbl_obra_fechaini, lbl_obra_fechafin);
    }
    
    private void cargarDatosGeneralesCotizacion()
    {    
        pantalla.llenarDatosCotizacion(this.cot.getNroCotizacion(),this.cot.getFechaLimiteEntrega(),cot.getValidezOferta(),cot.getPlazoEntrega(),cot.getLugarEntrega(),cot.getEstado());
    }
    
    private double getMontoMaximo()
    {
        if(this.cot!=null)
        {
            return this.obra.getPresupuestoMaximo();
        }
        return -1;
    }
    
    public String getMontoTotal()
    {
        return "$"+this.cot.CalcularTotal()+" (Max: $"+getMontoMaximo()+")";
    }
    
    private void cargarMontoTotal()
    {
        pantalla.setMontoTotal(getMontoTotal());
    }

    private void cargarMontoActualVSMaximo() 
    {    
        pantalla.setMontoActualVSMaximo(this.cot.CalcularTotal(),getMontoMaximo());
    }

    private void cargarDescripcionObra() 
    {
        if(this.cot.getDescripcion()!=null)
        {
            pantalla.setDescripcionObra(this.cot.getDescripcion());
        }
    }
    
    public void crearSubObra(String nombre)
    {
        // VEO QUE NO REPITA EL NOMBRE
        boolean _used_name = false;
        for (int i = 0; i < this.cot.getSubObras().size(); i++) 
        {
            SubObra so = this.cot.getSubObras().get(i);
            if(so.getNombre().equals(nombre))
            {
                _used_name=true;
            }
        }
        
        if(_used_name==false)
        {
            SubObra nuevaso = new SubObra();
            nuevaso.setNombre(nombre);
            this.cot.getSubObras().add(nuevaso);
            refrescarVentana();
        }
    }

    private void cargarGraficos() 
    {
        pantalla.updateGraphs();
    }

    public ArrayList<CotizacionGraficoBean> getDataGraficoSubObras() 
    {
        ArrayList<CotizacionGraficoBean> lista = new ArrayList<CotizacionGraficoBean>();
        for (int i = 0; i < this.cot.getSubObras().size(); i++) 
        {
            SubObra so = this.cot.getSubObras().get(i);
            
                double monto = so.calcularSubtotal();
                CotizacionGraficoBean bean = new CotizacionGraficoBean("[$"+monto+"]"+so.getNombre(),monto);
                lista.add(bean);
        }
        return lista;
    }
    
    public ArrayList<CotizacionGraficoBean> getDataGraficoRecursos() 
    {
        // 1-Material 
        // 2-Tareas
        // 3-Herramientas
        // 4-Adicionales
        // 5-Compras
        double[] subtotales = new double[5];
        
        ArrayList<CotizacionGraficoBean> lista = new ArrayList<CotizacionGraficoBean>();
        for (int i = 0; i < this.cot.getSubObras().size(); i++) 
        {
            SubObra so = this.cot.getSubObras().get(i);
            
                // Materiales
                for (int j = 0; j < so.getMateriales().size(); j++) 
                {
                    subtotales[0] += so.getMateriales().get(j).calcularSubtotal();
                }
                // Tareas
                for (int j = 0; j < so.getTareas().size(); j++) 
                {
                    subtotales[1] += so.getTareas().get(j).calcularSubtotal();
                }
                // Herramientas
                for (int j = 0; j < so.getHerramientas().size(); j++) 
                {
                    subtotales[2] += so.getHerramientas().get(j).calcularSubtotal();
                }
                // Adicionales
                for (int j = 0; j < so.getAdicionales().size(); j++) 
                {
                    subtotales[3] += so.getAdicionales().get(j).calcularSubtotal();
                } 
                // Compras
                for (int j = 0; j < so.getAlquileresCompras().size(); j++) 
                {
                    subtotales[4] += so.getAlquileresCompras().get(j).calcularSubtotal();
                }                                
            
        }
        
        // Agrego al Set de datos
        CotizacionGraficoBean bean1 = new CotizacionGraficoBean("[$"+subtotales[0]+"] Materiales",subtotales[0]);
        lista.add(bean1); 
        CotizacionGraficoBean bean2 = new CotizacionGraficoBean("[$"+subtotales[1]+"] Mano de Obra",subtotales[1]);
        lista.add(bean2); 
        CotizacionGraficoBean bean3 = new CotizacionGraficoBean("[$"+subtotales[2]+"] Herramientas",subtotales[2]);
        lista.add(bean3); 
        CotizacionGraficoBean bean4 = new CotizacionGraficoBean("[$"+subtotales[3]+"] Adicionales",subtotales[3]);
        lista.add(bean4); 
        CotizacionGraficoBean bean5 = new CotizacionGraficoBean("[$"+subtotales[4]+"] Compras",subtotales[4]);
        lista.add(bean5);         
        return lista;
    }

    public void eliminarSubObra(int id_subObra)
    {
        // Recorro, encuentro la subobra y la elimino
        for (int i = 0; i < this.cot.getSubObras().size(); i++) 
        {
            SubObra so = this.cot.getSubObras().get(i);
            if(so.getId()==id_subObra)
            {
                this.cot.getSubObras().remove(i);
                this.refrescarVentana();
                return;
            }
        }
    }

    public void cambiarNombreSubObra(int idSubObra, String nombre) 
    {
         // Recorro, encuentro la subobra y la modifico
        for (int i = 0; i < this.cot.getSubObras().size(); i++) 
        {
            SubObra so = this.cot.getSubObras().get(i);
            if(so.getId()==idSubObra)
            {
                so.setNombre(nombre);
                this.refrescarVentana();
                return;
            }
        }
    }

    public GestorEditarCotizacion getGestorEditarCotizacion(int idSubObra) 
    {
        if(this.gestorEditarCotizacion==null)
        {
            this.gestorEditarCotizacion = new GestorEditarCotizacion(this);
            this.gestorEditarCotizacion.seleccionarSubObra(idSubObra);
        }
        this.gestorEditarCotizacion.seleccionarSubObra(idSubObra);
        return gestorEditarCotizacion;
    }

    @Override
    public Cotizacion getCotizacion() {
        return this.cot;
    }

    public void guardarCotizacion() 
    {
        boolean flag_valido_nropresupuesto = false;
        // Busco si el número de cotización no está repetido
        // OJO, tengo que chequear que no me choque con esta misma cotizacion
        try
        {
            Query q = HibernateUtil.getSession().createQuery("FROM Cotizacion C WHERE C.nroCotizacion=? AND C.id!=?");
            q.setParameter(0,this.cot.getNroCotizacion());
            q.setParameter(1,this.cot.getId());
            
            ArrayList<Cotizacion> lista = (ArrayList) q.list();
            if(lista.size()==0)
            {
                flag_valido_nropresupuesto = true;
            }
        } 
        catch (Exception ex)
        {
            pantalla.MostrarMensaje(JOptionPane.ERROR_MESSAGE,"Error!","No se pudo comprobar si el número ingresado ya está en uso\nIntentelo nuevamente");
        }
        
        if(flag_valido_nropresupuesto)
        {
            // Actualizo la ultima modificacion
            this.cot.setFechaModificacion(new Date());

            // GUARDO LA COTIZACION EN LA BD
            try
            {
                sesion.beginTransaction();
                sesion.saveOrUpdate(this.cot);
                sesion.getTransaction().commit(); 
                necesita_guardar = false;

                pantalla.setNroCotizacionValidoGuardado();
            }
            catch(Exception e)
            {
                pantalla.MostrarMensaje(JOptionPane.ERROR_MESSAGE,"Error!","No se pudo guardar la cotización!\n"+e.getLocalizedMessage());
            }

            pantalla.MostrarMensaje(JOptionPane.INFORMATION_MESSAGE,"Exito!","Se guardo correctamente la cotización número "+this.cot.getNroCotizacion()+" !");
        }
        else
        {
            pantalla.MostrarMensaje(JOptionPane.ERROR_MESSAGE,"Error!","El número de Presupuesto \""+this.cot.getNroCotizacion()+"\" ya está en uso\nIngrese uno diferente!");
        }
    }

    public void updateNroCotizacion(String text) 
    {
        // Busco si el número de cotización no está repetido
        // OJO, tengo que chequear que no me choque con esta misma cotizacion
        try
        {
            Query q = HibernateUtil.getSession().createQuery("FROM Cotizacion C WHERE C.nroCotizacion=? AND C.id!=?");
            q.setParameter(0,text);
            q.setParameter(1,this.cot.getId());
            
            ArrayList<Cotizacion> lista = (ArrayList) q.list();
            if(lista.size()==0)
            {
                // Puedo usar ese Nro de Cotizacion
                this.cot.setNroCotizacion(text);
                pantalla.setNroCotizacionValido();
            }
            else
            {
                // Ya está en uso
                pantalla.setNroCotizacionInvalido();
                this.cot.setNroCotizacion(text);
                pantalla.MostrarMensaje(JOptionPane.ERROR_MESSAGE,"Error!","El número de Presupuesto \""+text+"\" ya está en uso\nIngrese uno diferente!");
            }
        } 
        catch (Exception ex)
        {
            pantalla.MostrarMensaje(JOptionPane.ERROR_MESSAGE,"Error!","No se pudo comprobar si el número ingresado ya está en uso\nIntentelo nuevamente");
        }

        
        
        
    }

    public void updateLEP(Date date) {
        this.cot.setFechaLimiteEntrega(date);
    }

    public void updateLVP(Date date) {
        this.cot.setValidezOferta(date);
    }

    public void updatePlazoEntrega(String text) {
        this.cot.setPlazoEntrega(text);
    }

    public void updateLugarEntrega(String text) {
        this.cot.setLugarEntrega(text);
    }

    public void updateDescripcion(String text) {
        this.cot.setDescripcion(text);
    }

    @Override
    public SubObra getSubObraActual() {
        return null;
    }

    @Override
    public void refrescarPantallas() 
    {
        refrescarVentana();
        necesita_guardar = true;
    }

    public boolean isNecesitaGuardar() {
        return necesita_guardar;
    }

    public void rechazarCotizacion() 
    {
        if(getCotizacion().getId()!=0)
        {
            if(getCotizacion().setEstadoRechazado())
            {
                pantalla.setEstadoRechazado();
                refrescarVentana();
            }
            else
            {
                pantalla.MostrarMensaje(JOptionPane.ERROR_MESSAGE,"Error!","No se pudo cambiar el estado de la cotización");
            }
        }
        else
        {
            pantalla.MostrarMensaje(JOptionPane.ERROR_MESSAGE,"Error!","Para realizar esta acción antes debe guardar la cotización");
        }
    }

    private void refrescarVentanaSegunEstado() 
    {
        if(cot.getEstado().equals(Cotizacion.ESTADO_DESCARTADO) || cot.getEstado().equals(Cotizacion.ESTADO_RECHAZADO))
        {
            pantalla.refrescarVentanaEstadoRechazado();
        }
        if(cot.getEstado().equals(Cotizacion.ESTADO_PENDIENTE_ACEPTACION))
        {
            pantalla.refrescarVentanaEstadoPendienteAceptacion();
        }
        if(cot.getEstado().equals(Cotizacion.ESTADO_EN_CREACION))
        {
            pantalla.refrescarVentanaEstadoEnCreacion();
        }
    }
    
    public void enviarCotizacionCliente()
    {
        if(getCotizacion().getId()!=0)
        {
            if(getCotizacion().setEstadoPendienteAceptacion())
            {
                pantalla.setEstadoEnviadoCliente();
                refrescarVentana();
            }
            else
            {
                pantalla.MostrarMensaje(JOptionPane.ERROR_MESSAGE,"Error!","No se pudo cambiar el estado de la cotización");
            }
        }
        else
        {
            pantalla.MostrarMensaje(JOptionPane.ERROR_MESSAGE,"Error!","Para realizar esta acción antes debe guardar la cotización");
        }        
    }

    
    
}
