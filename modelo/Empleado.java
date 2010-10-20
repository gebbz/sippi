package modelo;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : Empleado.java
//  @ Date : 14/06/2010
//  @ Author : Iuga
//
//




public class Empleado extends Persona {

	//private Date fechaAlta;
	//private Date fechaBaja;
	private int legajo;
	private String rango;
	//private ArrayList capacitacion;
	//private ArrayList indumentaria;
	//private ArrayList<Especialidad> especialidades;
        
	private Set indumentaria;
	private Set<Especialidad> especialidades;
        private Set<Capacitacion> capacitaciones;
        private EstadoEmpleado estado;
        private Date fechaIngreso;
        private String hib_flag_estado;
        private String motivoBaja;
       // private Date fechaBaja;




   
public Empleado(int leg,String nom,String apell,Date fechadeNac,Date fechaIng,TipoDocumento tipoDoc,String nroDoc,String cuil, String email,Domicilio domicilio , ArrayList<Especialidad> listaEspecialiades , ArrayList<String> listaNroTel, ArrayList<TipoTelefono> listaTipoTel,ArrayList<TipoCapacitacion> listaTipoCapacitaciones, ArrayList<Date> listaVencimientoCapacitaciones, Date fecha_Alta)
    {
        legajo=leg;
        super.setNombre(nom);
        super.setApellido(apell);
        super.setFechadeNac(fechadeNac);
        super.setTipoDoc(tipoDoc);
        super.setNroDoc(nroDoc);
        super.setCuil(cuil);
        super.setEmail(email);
        super.setDomicilio(domicilio);
        setEspecialidades(listaEspecialiades);
        //especialiades= new ArrayList();
        //indumentaria= new ArrayList();
        //capacitacion= new ArrayList();
        super.setFechaAlta(fecha_Alta);
        super.setTelefonos(listaNroTel, listaTipoTel);
        setCapacitaciones(listaTipoCapacitaciones,listaVencimientoCapacitaciones);
        estado=new EstadoEmpleadoActivo();
        hib_flag_estado = "modelo.EstadoEmpleadoActivo";
        fechaIngreso =fechaIng;

    }
     public Empleado(int leg,String nom,String apell,Date fechadeNac,Date fechaIng,TipoDocumento tipoDoc,String nroDoc,String cuil, String email, String calleD, int numeroD, int pisoD, String deptoD, String codigoPostalD, Barrio barrioD , ArrayList<Especialidad> listaEspecialiades , ArrayList<String> listaNroTel, ArrayList<TipoTelefono> listaTipoTel,ArrayList<TipoCapacitacion> listaTipoCapacitaciones, ArrayList<Date> listaVencimientoCapacitaciones, Date fecha_Alta)
    {
        legajo=leg;
        super.setNombre(nom);
        super.setApellido(apell);
        super.setFechadeNac(fechadeNac);
        super.setTipoDoc(tipoDoc);
        super.setNroDoc(nroDoc);
        super.setCuil(cuil);
        super.setEmail(email);
        //super.setDomicilio(domicilio);
        setEspecialidades(listaEspecialiades);
        //especialiades= new ArrayList();
        //indumentaria= new ArrayList();
        //capacitacion= new ArrayList();
        super.setFechaAlta(fecha_Alta);
        super.setDomicilio(calleD,  numeroD,  pisoD,  deptoD, codigoPostalD,  barrioD);
        super.setTelefonos(listaNroTel,  listaTipoTel);
        setCapacitaciones(listaTipoCapacitaciones,listaVencimientoCapacitaciones);
        estado=new EstadoEmpleadoActivo();
        hib_flag_estado = "modelo.EstadoEmpleadoActivo";
        fechaIngreso =fechaIng;
    }
     public Empleado()
     {
        /* especialiades= new ArrayList();
         indumentaria= new ArrayList();
         capacitacion= new ArrayList();*/
    }
    /*public void setFechaBaja(Date fb)
    {
        fechaBaja=fb;
    }
    public Date getFechaBaja()
    {
      return  fechaBaja;
    }*/
     public EstadoEmpleado getEstado()
     {
         if(this.estado==null)
                {
                    try {
                            //Class estadoAux = Class.forName(this.hib_flag_estado);
                            EstadoEmpleado estadoAux = (EstadoEmpleado) Class.forName(this.hib_flag_estado).newInstance();
                            this.estado = estadoAux;
                            return estado;
                        }
                        catch (Exception ex)
                        {
                            System.out.println("No se encontro la clase Estado Concreto: "+this.hib_flag_estado);
                            ex.getStackTrace();
                            return null;
                        }
                }
                else
                {
                    return this.estado;
                }
     }
     public void setEstado(EstadoEmpleado ee)
     {
         estado=ee;
         hib_flag_estado = ee.getClass().getName();
     }
    public String getHib_flag_estado() {
        return hib_flag_estado;
    }

    public void setHib_flag_estado(String hib_flag_estado) {
        this.hib_flag_estado = hib_flag_estado;
    }
     public Date getFechaIngreso()
     {
         return fechaIngreso;
     }
     public void setFechaIngreso(Date fi)
     {
         fechaIngreso=fi;
     }
    public Set getCapacitaciones() {
        return capacitaciones;
    }

    public void setCapacitaciones(Set capacitacion) {
        this.capacitaciones = capacitacion;
    }

    public Set<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(Set<Especialidad> especialiades) {
        this.especialidades = especialiades;
    }
   /* public List getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(ArrayList capacitacion) {
        this.capacitacion = capacitacion;
    }

    public ArrayList<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(ArrayList<Especialidad> especialiades) {
        this.especialidades = especialiades;
    }*/
    /*public void setEspecialidades(ArrayList<TipoEspecialidad> tipoEspecialiades,ArrayList<RangoEspecialidad> rangoEspecialiades)
    {
        especialidades= new HashSet();
        for(int i=0; i< tipoEspecialiades.size();i++)
        {
           Especialidad especialidad = new Especialidad(tipoEspecialiades.get(i), rangoEspecialiades.get(i));
           especialidades.add(especialidad);
        }
    }*/
    public void setEspecialidades(ArrayList<Especialidad> listaEspecialiades)
    {
        especialidades= new HashSet();
        for(int i=0; i< listaEspecialiades.size();i++)
        {
           especialidades.add(listaEspecialiades.get(i));
        }
    }

    public void setCapacitaciones(ArrayList<TipoCapacitacion> tipoCapacitaciones,ArrayList<Date> vencimientosCapacitaciones)
    {
        capacitaciones= new HashSet();
        for(int i=0; i< tipoCapacitaciones.size();i++)
        {
           Capacitacion cap = new Capacitacion(tipoCapacitaciones.get(i), vencimientosCapacitaciones.get(i));
           capacitaciones.add(cap);
        }
    }
    /*public void setEspecialidades(ArrayList<TipoEspecialidad> tipoEspecialiades,ArrayList<RangoEspecialidad> rangoEspecialiades)
    {
        especialidades= new ArrayList();
        for(int i=0; i< tipoEspecialiades.size();i++)
        {
           Especialidad especialidad = new Especialidad(tipoEspecialiades.get(i), rangoEspecialiades.get(i));
           especialidades.add(especialidad);
        }
    }*/
    

    
    public Set getIndumentaria() {
        return indumentaria;
    }

    public void setIndumentaria(Set indumentaria) {
        this.indumentaria = indumentaria;
    }
    /*
  public List getIndumentaria() {
        return indumentaria;
    }

    public void setIndumentaria(ArrayList indumentaria) {
        this.indumentaria = indumentaria;
    }
 */
    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public boolean darDeBaja(Date fechaB, String motiv)
        {
                boolean exito=getEstado().darBaja(this);
                if(exito)
                {
                    super.setFechaBaja(fechaB);
                    motivoBaja=motiv;

                }
                return    exito;
                
        }

        public boolean darDeAlta()
        {
             if(this.getEstado().esBaja())
                {
                    estado.darAlta(this);
                    return true;
                }
             else{return false;}           
        }

        public boolean estaActivo()
        {return getEstado().esActivo();}

        public boolean estaBaja()
        {return getEstado().esBaja();}

        public void setMotivoBaja(String mb)
        {motivoBaja=mb;
        }

        public String getMotivoBaja()
        { return motivoBaja;
        }


        public void crear() {
	
	}
	
	public void mostrarEmpleado() {
	
	}
	
	public void mostrarRangoEmpleado() {
	
	}
	
	public void mostrarEspecialidades() {
	
	}
	
	public void mostrarCapacitacion() {
	
	}
	
	public void crearEspecialidades() {
	
	}
	
	public void crearDomicilio() {
	
	}
	
	public void crearTelefonos() {
	
	}
	
	public void esEmpleado() {
	
	}
	
	public void buscarLegajoEmpleado() {
	
	}
	
	public void mostrarApellidoYNombre() {
	
	}
	
	public void getEmpleado() {
	
	}
	
	public void esTuTipo() {
	
	}
	
	public void buscarNombresEmpleadosActivos() {
	
	}
	
	public void buscarEmpleadosActivosConFechaDeVencimiento() {
	
	}
	
	public void mostrarEmpleadosDeEseTipoYMaximaFechaDeVencimiento() {
	
	}
	
	public void mostrarEmpleadoActivo() {
	
	}
	
	public void estaAsignado() {
	
	}
	
	public void fechaVencimientoCapacitacion() {
	
	}
}
