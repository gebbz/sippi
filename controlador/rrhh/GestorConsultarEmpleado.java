/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.rrhh;
import vista.rrhh.pantallaConsultarEmpleado;
import util.NTupla;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;
import modelo.Empleado;

/**
 *
 * @author Administrador
 */
public class GestorConsultarEmpleado
{

    private pantallaConsultarEmpleado pantalla;
    private Session sesion;





    public GestorConsultarEmpleado(pantallaConsultarEmpleado pantalla)
    {
        this.pantalla = pantalla;
        //listaTipoEspecialidades= new ArrayList<TipoEspecialidad>();
       // listaRangoEspecialidades= new ArrayList<RangoEspecialidad>();
       // listaNroTel= new  ArrayList<String>();
       // listaTipoTel= new ArrayList<TipoTelefono>();
       // listaTipoCapacitaciones=new ArrayList<TipoCapacitacion>();
       //  listaVencimientoCapacitaciones=new ArrayList<Date>();
    }

    public List listaEmpleados()
    {


        try{
        //SessionFactory sf = HibernateUtil.getSessionFactory();
        //sesion = sf.openSession();
        sesion= HibernateUtil.getSession();
        } catch (Exception ex)////////////
            {//////////////////////////////////////////
                System.out.println("No se pudo abrir la sesion");//////////

            }




         sesion.beginTransaction();
            List lista = sesion.createQuery("from Empleado order by legajo").list();
            //sesion.getTransaction().commit();

            //ArrayList<String> listaNombres = new ArrayList<String>();
            ArrayList<NTupla> listaEmpleados = new ArrayList<NTupla>();
            for (int i = 0; i < lista.size(); i++) {
                Empleado emp = (Empleado)lista.get(i);
               // listaNombres.add(td.getNombre());
                NTupla tupla = new NTupla(emp.getOID());
                tupla.setNombre(String.valueOf(emp.getLegajo()));
                String[] datos=new String[4];
                datos[0]=String.valueOf(emp.getLegajo());
                datos[1]=emp.getNombre();
                datos[2]=emp.getApellido();
                if(emp.getEstado()!=null)
                {datos[3]=emp.getEstado().getNombre();}
                tupla.setData(datos);
                    listaEmpleados.add(tupla);
            }

            return listaEmpleados;

    }

}