package controlador.comer;

import controlador.utiles.gestorGeoLocalicacion;
import java.util.ArrayList;
//import java.util.List;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.transaction.Transaction;
import modelo.*;
import modelo.Pais;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.Tupla;
import util.HibernateUtil;
import util.SwingPanel;
import vista.comer.pantallaRegistrarEmpresaCliente;
import vista.comer.pantallaRegistrarNuevaPlanta;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : GestorRegistrarNuevaEmpresaCliente.java
//  @ Date : 14/06/2010
//  @ Author : 
//
//




public class GestorRegistrarNuevaEmpresaCliente {
    private ArrayList<Pais> paises;
    private ArrayList<Provincia> provincias;
    private ArrayList<Localidad> localidades;
    private ArrayList<Barrio> barrios;
    private Pais pais;
    private Provincia provincia;
    private Localidad localidad;
    private Barrio barrio;
    private String cuit;
    private String email;
    private ArrayList<Telefono> telefonos;
    private ArrayList<Domicilio> domicilio;
    private pantallaRegistrarEmpresaCliente pantalla;
    private Planta planta;
    private String nombreEmpresaCliente;
    private String calle;
    private String altura;
    private String piso;
    private String dpto;
    private String cp;

    public GestorRegistrarNuevaEmpresaCliente(pantallaRegistrarEmpresaCliente pantalla) {
        this.pantalla = pantalla;
    }

    public void registrarNuevaPlanta(String razonSocial)
    {
        pantallaRegistrarNuevaPlanta np = new pantallaRegistrarNuevaPlanta(this,razonSocial);
        SwingPanel.getInstance().addWindow(np);
        np.setVisible(true);
    }

    public void setNuevaPlanta(int id)
    {
        // SI ESTE METODO SE ACTIVA SIGNIFICA QUE AGREGO UNA NUEVA PLANTA CON EXITO
        // Y EL ID es el id pasado por parametro
        pantalla.plantaAgregada();
        //TODO: UNA VEZ QUE YA REGISTRASTE LA NUEVA EMPRESA, TENES QUE BUSCAR LA PLANTA CREADA
        // Y  ACTUALIZARLE EL ID DE LA EMPRESA que va a estar en NULL... SI O SI !!!
        //(Usa el id este para encontrarla y actualizarla)

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();

        this.planta = (Planta)sesion.load(Planta.class, id);

        sesion.close();
    }

    public void finCU() {

    }

    public void llamarCURegistrarNuevaPlanta() {
        // DEPRECATED - DIRECTAMENTE SE LLAMA A REGISTRARNUEVAPLANTA()
    }

    public void seleccionPais(int id) {
        gestorGeoLocalicacion ggl = new gestorGeoLocalicacion();
        this.pais = ggl.getPais(id);
    }

    public void seleccionProvincia(int id) {
        gestorGeoLocalicacion ggl = new gestorGeoLocalicacion();
        this.provincia = ggl.getProvincia(id);
    }

    public void seleccionLocalidad(int id) {
        gestorGeoLocalicacion ggl = new gestorGeoLocalicacion();
        this.localidad = ggl.getLocalidad(id);
    }

    public void seleccionBarrio(int id) {
        gestorGeoLocalicacion ggl = new gestorGeoLocalicacion();
        this.barrio = ggl.getBarrio(id);
    }

    public void nombreEmpresa(String nombre) {
        this.nombreEmpresaCliente = nombre;
    }

    public void CUIT(String cuit) {
        this.cuit = cuit;
    }

    public void datosDomicilio(String calle,String altura,String piso,String dpto,String cp) {
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.dpto = dpto;
        this.cp = cp;
    }

    public void EMail(String email) {
        this.email = email;
    }

    public void telefono(ArrayList<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public void seleccionTipoTelefono() {
        // DEPRECATED - NO SIRVE DE NADA... ESTA INFO VA EN TELEFONO()
    }

    public void agregarNuevaPlanta() {
        // DEPRECATED - AHORA SE LLAMA REGISTRARNUEVAPLANTA()
    }

    public int confirmacionRegistro() {
        EmpresaCliente nueva = new EmpresaCliente();
        nueva.setRazonSocial(this.nombreEmpresaCliente);
        nueva.setCuit(this.cuit);
        nueva.setEmail(this.email);

        Domicilio d = new Domicilio();
        d.setCalle(this.calle);
        d.setCodigoPostal(this.cp);
        d.setNumero(Integer.parseInt(this.altura));
        d.setPiso(Integer.parseInt(this.piso));
        d.setDepto(this.dpto);
        nueva.setDomicilio(d);

        ArrayList<Planta> listaPlantas = new ArrayList<Planta>();
        listaPlantas.add(this.planta);
        nueva.setPlantas(listaPlantas);

        nueva.setTelefonos(this.telefonos);

        nueva.setPaginaWeb("www.ubuntulife.net");

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion;
        try {
            sesion = HibernateUtil.getSession();
            //sesion = sf.openSession();
            try{
                HibernateUtil.beginTransaction();
                sesion.save(d);
                //sesion.save(nueva);
                //sesion.update(planta);
                //nueva.setPlantas(listaPlantas);
                //sesion.update(nueva);
                sesion.saveOrUpdate(nueva);
                HibernateUtil.commitTransaction();
            }catch(Exception e) {
                System.out.println("No se pudo inicia la transaccion\n"+e.getMessage());
                HibernateUtil.rollbackTransaction();
        }
            HibernateUtil.closeSession();
        } catch (Exception ex) { System.out.println("No se pudo abrir la sesion");  }
        return nueva.getId();
    }

    public ArrayList<Tupla> mostrarTiposTelefono() {
        ArrayList<Tupla> tuplas = new ArrayList<Tupla>();
        Tupla tupla = null;
        try{
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session sesion = sf.openSession();
            Iterator iter = sesion.createQuery("from TipoTelefono q order by q.nombre").iterate();
            while ( iter.hasNext() ) {
                TipoTelefono tipo = (TipoTelefono) iter.next();
                tupla = new Tupla(tipo.getId(),tipo.getNombre());
                tuplas.add(tupla);
            }
        }catch(Exception e)
        {
            System.out.println("ERROR:"+e.getMessage()+"|");
            e.printStackTrace();
        }
        return tuplas;
        }

    public void registrarNuevaEmpresa() {

    }
    
    /**
     * IUGA
     * @return
     */
    public ArrayList<Tupla> mostrarNombrePaises() {

            gestorGeoLocalicacion ggl = new gestorGeoLocalicacion();
           return ggl.getPaises();
    }

    /**
     * IUGA
     * @return
     */
    public ArrayList<Tupla> mostrarLocalidades(Tupla prov) {

           gestorGeoLocalicacion ggl = new gestorGeoLocalicacion();
           return ggl.getLocalidades(prov.getId());
    }

    /**
     * IUGA
     * @return
     */
    public ArrayList<Tupla> mostrarProvincias(Tupla pais) {

           gestorGeoLocalicacion ggl = new gestorGeoLocalicacion();
           return ggl.getProvincias(pais.getId());
    }

    /**
     * IUGA
     * @return
     */
    public ArrayList<Tupla> mostrarBarrios(Tupla loc) {

           gestorGeoLocalicacion ggl = new gestorGeoLocalicacion();
           return ggl.getBarrios(loc.getId());

    }
}
