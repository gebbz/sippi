package modelo;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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

	private Date fechaAlta;
	private Date fechaBaja;
	private int legajo;
	private String rango;
	private ArrayList capacitacion;
	private ArrayList indumentaria;
	private ArrayList<Especialidad> especialidades;




    public Empleado(int leg,String nom,String apell,Date fechadeNac,TipoDocumento tipoDoc,String nroDoc,String cuil, String email,Domicilio domicilio , ArrayList<TipoEspecialidad> tipoEspecialiades,ArrayList<RangoEspecialidad> rangoEspecialiades , ArrayList<String> listaNroTel, ArrayList<TipoTelefono> listaTipoTel, Date fecha_Alta)
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
        setEspecialidades(tipoEspecialiades, rangoEspecialiades);
        //especialiades= new ArrayList();
        //indumentaria= new ArrayList();
        //capacitacion= new ArrayList();
        fechaAlta=fecha_Alta;
        super.setTelefonos(listaNroTel, listaTipoTel);

    }
     public Empleado(int leg,String nom,String apell,Date fechadeNac,TipoDocumento tipoDoc,String nroDoc,String cuil, String email, String calleD, int numeroD, int pisoD, String deptoD, String codigoPostalD, Barrio barrioD , ArrayList<TipoEspecialidad> tipoEspecialiades,ArrayList<RangoEspecialidad> rangoEspecialiades , ArrayList<String> listaNroTel, ArrayList<TipoTelefono> listaTipoTel, Date fecha_Alta)
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
        setEspecialidades(tipoEspecialiades, rangoEspecialiades);
        //especialiades= new ArrayList();
        //indumentaria= new ArrayList();
        //capacitacion= new ArrayList();
        fechaAlta=fecha_Alta;
        super.setDomicilio(calleD,  numeroD,  pisoD,  deptoD, codigoPostalD,  barrioD);
        super.setTelefonos(listaNroTel,  listaTipoTel);
    }



     public Empleado()
     {
        /* especialiades= new ArrayList();
         indumentaria= new ArrayList();
         capacitacion= new ArrayList();*/
    }

    public List getCapacitacion() {
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
    }

    public void setEspecialidades(ArrayList<TipoEspecialidad> tipoEspecialiades,ArrayList<RangoEspecialidad> rangoEspecialiades)
    {
        especialidades= new ArrayList();
        for(int i=0; i< tipoEspecialiades.size();i++)
        {
           Especialidad especialidad = new Especialidad(tipoEspecialiades.get(i), rangoEspecialiades.get(i));
           especialidades.add(especialidad);
        }
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public List getIndumentaria() {
        return indumentaria;
    }

    public void setIndumentaria(ArrayList indumentaria) {
        this.indumentaria = indumentaria;
    }

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
