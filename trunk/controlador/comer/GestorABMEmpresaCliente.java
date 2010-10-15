package controlador.comer;

import controlador.utiles.gestorGeoLocalicacion;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;
import modelo.Pais;
import org.hibernate.Session;
import org.hibernate.collection.PersistentList;
import org.hibernate.collection.PersistentSet;
import util.Tupla;
import util.HibernateUtil;
import util.NTupla;
import util.SwingPanel;
import vista.comer.pantallaRegistrarNuevaPlanta;
import vista.interfaces.IPantallaEmpresaClienteABM;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : GestorABMEmpresaCliente.java
//  @ Date : 14/06/2010
//  @ Author : 
//
//

public class GestorABMEmpresaCliente {
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
    private IPantallaEmpresaClienteABM pantalla;
    private Planta planta;
    private String nombreEmpresaCliente;
    private String calle;
    private String altura;
    private String piso;
    private String dpto;
    private String cp;
    private String paginaWeb;
    private ArrayList<Planta> plantas;
    private EmpresaCliente empresa;

    public GestorABMEmpresaCliente(IPantallaEmpresaClienteABM pantalla) {
        this.pantalla = pantalla;
        plantas = new ArrayList<Planta>();

    }

    public ArrayList<Tupla> mostrarTiposTelefono() {
        ArrayList<Tupla> tuplas = new ArrayList<Tupla>();
        Tupla tupla = null;
        try{
            Session sesion = HibernateUtil.getSession();
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

    public ArrayList<Tupla> mostrarNombrePaises() {
            gestorGeoLocalicacion ggl = new gestorGeoLocalicacion();
           return ggl.getPaises();
    }

    public ArrayList<Tupla> mostrarLocalidades(Tupla prov) {
           gestorGeoLocalicacion ggl = new gestorGeoLocalicacion();
           return ggl.getLocalidades(prov.getId());
    }

    public ArrayList<Tupla> mostrarProvincias(Tupla pais) {
           gestorGeoLocalicacion ggl = new gestorGeoLocalicacion();
           return ggl.getProvincias(pais.getId());
    }

    public ArrayList<Tupla> mostrarBarrios(Tupla loc) {
           gestorGeoLocalicacion ggl = new gestorGeoLocalicacion();
           return ggl.getBarrios(loc.getId());
    }

    public void registrarNuevaPlanta(String razonSocial){
        pantallaRegistrarNuevaPlanta np = new pantallaRegistrarNuevaPlanta(this,razonSocial);
        SwingPanel.getInstance().addWindow(np);
        np.setVisible(true);
    }

    /**
     * METODO POR DEMAS IMPORTANTE: EL GESTOR DE PLANTAS LE ENVIA EL OBJETO PLANTA CREADO PARA SER
     * AGREGADO EN LA LISTA DE PLANTAS DE LA INTERFAZ DE EMPRESACLIENTE
     * @param gestorPlanta
     */
    public void agregarPlanta(GestorRegistrarNuevaPlanta gestorPlanta) {
        this.plantas.add(gestorPlanta.getPlanta());
        pantalla.plantaAgregada();
    }

    public void borrarPlanta(int id) {
        this.plantas.remove(id);
    }

    public int agregarTelefono(Tupla tipo, String numero) {
        if(this.telefonos == null){
            this.telefonos = new ArrayList<Telefono>();
        }
        Telefono tel = new Telefono();
        tel.setNumero(numero);
        TipoTelefono ttel = new TipoTelefono();
        ttel.setId(tipo.getId());
        ttel.setNombre(tipo.getNombre());
        tel.setTipo(ttel);
        this.telefonos.add(tel);
        return this.telefonos.indexOf(tel);
    }

    public void borrarTelefono(int id) {
        this.telefonos.remove(id);
    }

    public boolean validarExistenciaCUIT(String cuit) {
        boolean respuesta = true;
        try {
            List pr = (List) HibernateUtil.getSession().createQuery("FROM EmpresaCliente WHERE cuit LIKE :cuitP").setParameter("%cuitP%", cuit).list();
            if(pr.isEmpty())
                respuesta = false;
        } catch (Exception ex) {
            Logger.getLogger(GestorABMEmpresaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
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

    /***************************************************************************
     *                              ALTA
     ***************************************************************************
     */

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
        d.setBarrio(this.barrio);
        nueva.setDomicilio(d);

        nueva.setPlantas(this.plantas);

        nueva.setTelefonos(new HashSet<Telefono>(this.telefonos));

        nueva.setPaginaWeb(this.paginaWeb);

        Session sesion;
        try {
            sesion = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            try{
                sesion.saveOrUpdate(nueva.getDomicilio());
                for (Telefono tell : (HashSet<Telefono>)nueva.getTelefonos())
                {
                    sesion.saveOrUpdate(tell);
                }
                for(Planta p : (ArrayList<Planta>)nueva.getPlantas()){
                    for (Telefono tell : (HashSet<Telefono>)p.getTelefonos())
                    {
                        sesion.saveOrUpdate(tell);
                    }
                    sesion.saveOrUpdate(p.getDomicilio());
                    sesion.saveOrUpdate(p.getContacto());

                    sesion.saveOrUpdate(p);
                }
                sesion.saveOrUpdate(nueva);
                HibernateUtil.commitTransaction();
            }catch(Exception e) {
                System.out.println("No se pudo inicia la transaccion\n"+e.getMessage());
                HibernateUtil.rollbackTransaction();
        }
        } catch (Exception ex) { System.out.println("No se pudo abrir la sesion");  }
        return nueva.getId();
    }
   
    public void paginaWeb(String text) {
        this.paginaWeb = text;
    }

    public ArrayList<NTupla> getPlantas() {
        ArrayList<NTupla> pls = new ArrayList<NTupla>();
        NTupla nt = new NTupla();
        int indice = 0;
        for (Planta p : this.plantas){
            indice = this.plantas.indexOf(p);
            nt.setId(indice);
            nt.setNombre(p.getRazonSocial());
            nt.setData(p.getDomicilio().toString());
            pls.add(nt);
        }
        return pls;
    }

    /***************************************************************************
     *               MODIFICAR, CONSULTAR y DAR DE BAJA
     ***************************************************************************
     */

    public void seleccionEmpresaCliente(int id) {
        buscarDatosEmpresa(id);
        this.pantalla.mostrarEstadoEmpresa(this.empresa.getEstado().getNombre());
        this.pantalla.mostrarRZEmpresa(this.empresa.getRazonSocial());
        this.pantalla.mostrarCUITEmpresa(this.empresa.getCuit());
        this.pantalla.mostrarEmailEmpresa(this.empresa.getEmail());
        this.pantalla.mostrarPaginaWebEmpresa(this.empresa.getPaginaWeb());

        String calle = this.empresa.getDomicilio().getCalle();
        String nro = String.valueOf(this.empresa.getDomicilio().getNumero());
        String piso = String.valueOf(this.empresa.getDomicilio().getPiso());
        String dpto = this.empresa.getDomicilio().getDepto();
        String cp = this.empresa.getDomicilio().getCodigoPostal();
        this.pantalla.mostrarDomicilioEmpresa(calle,nro,piso,dpto,cp);

        gestorGeoLocalicacion geo = new gestorGeoLocalicacion();
        Localidad l = geo.getLocalidadDeBarrio(this.empresa.getDomicilio().getBarrio().getId());
        Provincia pr = geo.getProvinciaDeLocalidad(l.getId());
        Pais pa = geo.getPaisDeProvincia(pr.getId());
        this.pantalla.mostrarPaisEmpresa(new Tupla(pa.getId(),pa.getNombre()));
        this.pantalla.mostrarProvinciaEmpresa(new Tupla(pr.getId(),pr.getNombre()));
        this.pantalla.mostrarLocalidadEmpresa(new Tupla (l.getId(),l.getNombre()));
        this.pantalla.mostrarBarrioEmpresa(new Tupla(this.empresa.getDomicilio().getBarrio().getId(),this.empresa.getDomicilio().getBarrio().getNombre()));

        this.telefonos = new ArrayList<Telefono>(this.empresa.getTelefonos());
        ArrayList<NTupla> tels = buscarTelefonos();
        this.pantalla.mostrarDatosTelefono(tels);
        this.plantas = new ArrayList(this.empresa.getPlantas());
        ArrayList<NTupla> plts = this.buscarPlantas();
        this.pantalla.mostrarDatosPlantas(plts);
    }

    public void buscarDatosEmpresa(int id) {
        try{
            HibernateUtil.beginTransaction();
            this.empresa = (EmpresaCliente)HibernateUtil.getSession().load(EmpresaCliente.class, id);
            HibernateUtil.commitTransaction();
        }
        catch(Exception e){
            System.out.println("ERROR:"+e.getMessage()+"|");
            e.printStackTrace();
        }
    }

    public ArrayList<NTupla> buscarTelefonos() {
        ArrayList<NTupla> listaTelefonos = new ArrayList<NTupla>();
        PersistentSet tels = (PersistentSet) this.empresa.getTelefonos();
        Iterator<Telefono> i = tels.iterator();
        while(i.hasNext()) {
            Telefono t = i.next();
            NTupla nt = new NTupla();
            nt.setId(telefonos.indexOf(t));
            nt.setNombre(t.mostrarTipoTelefono().getNombre());
            nt.setData((String)t.getNumero());
            listaTelefonos.add(nt);
        }
        return listaTelefonos;
    }

    public ArrayList<NTupla> buscarPlantas() {
        ArrayList<NTupla> listaPlantas = new ArrayList<NTupla>();
        Iterator<Planta> iPlantas = ((PersistentList) empresa.getPlantas()).iterator();
        Planta p = null;
        while(iPlantas.hasNext()){
            p = iPlantas.next();
            NTupla nt = new NTupla();
            nt.setId(plantas.indexOf(p));
            nt.setNombre(p.getRazonSocial());
            nt.setData(p.getDomicilio().toString());
            listaPlantas.add(nt);
        }
        return listaPlantas;
    }

    public int darDeBajaEmpresaCliente(int idEmpresa) {
        Session sesion;
        try {
            sesion = HibernateUtil.getSession();
            try{
                HibernateUtil.beginTransaction();
                EmpresaCliente ec = (EmpresaCliente)sesion.load(EmpresaCliente.class, idEmpresa);
                ec.setEstadoBaja();

                sesion.saveOrUpdate(ec);

                HibernateUtil.commitTransaction();
            }catch(Exception e) {
                System.out.println("No se pudo inicia la transaccion\n"+e.getMessage());
                HibernateUtil.rollbackTransaction();
                return -1;

        }
            HibernateUtil.closeSession();
        } catch (Exception ex) { System.out.println("No se pudo abrir la sesion");  return -1;}
        return idEmpresa;
    }

    public int confirmacionModificacionRegistro(int idEmpresa) {
        Session sesion;
        try{
            sesion = HibernateUtil.getSession();
            try{
                HibernateUtil.beginTransaction();

                /***************************************************************
                 *                       GENERALES
                 * *************************************************************
                 */
                this.empresa.setRazonSocial(this.nombreEmpresaCliente);
                this.empresa.setCuit(this.cuit);
                this.empresa.setEmail(this.email);
                this.empresa.setPaginaWeb(this.paginaWeb);

                /***************************************************************
                 *                         DOMICILIO
                 * *************************************************************
                 */
                Domicilio d = this.empresa.getDomicilio();
                d.setCalle(this.calle);
                d.setCodigoPostal(this.cp);
                d.setNumero(Integer.parseInt(this.altura));
                d.setPiso(Integer.parseInt(this.piso));
                d.setDepto(this.dpto);
                d.setBarrio(this.barrio);

                /***************************************************************
                 *                         PLANTAS
                 * *************************************************************
                 */
                Iterator itPlantas = this.plantas.iterator();
                Planta pAux = null;
                while (itPlantas.hasNext()){
                    pAux = (Planta)itPlantas.next();
                    if(pAux.getId() == 0){ // CON ESTO AGREGAMOS TODAS LAS NUEVAS... NOS QUEDA BORRAR LAS Q ESTAN EN LA BD
                        for (Telefono tell : (HashSet<Telefono>)pAux.getTelefonos())
                        {
                            sesion.save(tell);
                        }
                        sesion.save(pAux.getDomicilio());
                        sesion.save(pAux.getContacto());

                        this.empresa.getPlantas().add(pAux);
                        sesion.save(pAux);
                    }
                }
                itPlantas = this.empresa.getPlantas().iterator();
                Iterator it = null;
                Planta pAux2 = null;
                boolean ban = false;
                ArrayList<Planta> plantasBorradas = new ArrayList<Planta>();
                while(itPlantas.hasNext()){
                    pAux = (Planta)itPlantas.next();
                    it = this.plantas.iterator();
                    ban = false;
                    while(it.hasNext()){
                        pAux2 = (Planta)it.next();
                        if(pAux2.getId() == pAux.getId()){
                            ban=true;
                            break;
                        }
                    }
                    if(ban == false){
                        plantasBorradas.add(pAux);
                    }
                }
                Iterator itPlantasBorradas = plantasBorradas.iterator();
                while(itPlantasBorradas.hasNext()){
                    pAux = (Planta)itPlantasBorradas.next();
                    this.empresa.getPlantas().remove(pAux);
                    sesion.delete(pAux);
                }
                /***************************************************************
                 *                         TELEFONOS
                 * *************************************************************
                 */
                Iterator itTelefonos = this.telefonos.iterator();
                Telefono tAux = null;
                while (itTelefonos.hasNext()){
                    tAux = (Telefono)itTelefonos.next();
                    if(tAux.getId() == 0){ // CON ESTO AGREGAMOS TODAS LAS NUEVAS... NOS QUEDA BORRAR LAS Q ESTAN EN LA BD
                        this.empresa.getTelefonos().add(tAux);
                        sesion.save(tAux);

                    }
                }

                itTelefonos = this.empresa.getTelefonos().iterator();
                Telefono tAux2 = null;
                ArrayList<Telefono> borrados = new ArrayList<Telefono>();
                ban = false;
                while(itTelefonos.hasNext()){
                    tAux = (Telefono)itTelefonos.next();
                    it = this.telefonos.iterator();
                    ban = false;
                    while(it.hasNext()){
                        tAux2 = (Telefono)it.next();
                        if(tAux2.getId() == tAux.getId()){
                            ban=true;
                            break;
                        }
                    }
                    if(ban == false){
                        borrados.add(tAux);
                    }
                }
                Iterator itBorrados = borrados.iterator();
                while(itBorrados.hasNext()){
                    tAux = (Telefono)itBorrados.next();
                    this.empresa.getTelefonos().remove(tAux);
                    sesion.delete(tAux);
                }
                sesion.update(this.empresa);
                HibernateUtil.commitTransaction();
            }catch(Exception e) {
                    System.out.println("No se pudo inicia la transaccion\n"+e.getMessage());
                    HibernateUtil.rollbackTransaction();
                    return -1;
            }
            HibernateUtil.closeSession();
        } catch (Exception ex) { System.out.println("No se pudo abrir la sesion");  return -1;}
        return this.empresa.getId();
    }

    /***************************************************************************
     *                          DEPRECATED
     * *************************************************************************
     */

    public void llamarCURegistrarNuevaPlanta() {
        // DEPRECATED - DIRECTAMENTE SE LLAMA A REGISTRARNUEVAPLANTA()
    }

    public void seleccionTipoTelefono() {
        // DEPRECATED - NO SIRVE DE NADA... ESTA INFO VA EN TELEFONO()
    }

    public void agregarNuevaPlanta() {
        // DEPRECATED - AHORA SE LLAMA REGISTRARNUEVAPLANTA()
    }

    public void registrarNuevaEmpresa() {
        // DEPRECATED - AHORA SE LLAMA CONFIRMARREGISTRO()
    }

    public void finCU() {
        // DEPRECATED - NO SE LO USA
    }
}