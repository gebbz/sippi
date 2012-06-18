package controlador.rrhh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import modelo.AsistenciaTallerCapacitacion;
import modelo.DetalleHorarioTaller;
import modelo.TallerCapacitacion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.FechaUtil;
import util.HibernateUtil;
import util.NTupla;
import util.Tupla;
import vista.rrhh.pantallaRegistrarAsistenciaTallerCapacitacion;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : gestorRegistrarAsistenciaTallerCapacitacion.java
//  @ Date : 14/06/2010
//  @ Author : 
//
//

public class GestorRegistrarAsistenciaTallerCapacitacion {

        private pantallaRegistrarAsistenciaTallerCapacitacion pantalla;

        public GestorRegistrarAsistenciaTallerCapacitacion(pantallaRegistrarAsistenciaTallerCapacitacion pantalla) {
            this.pantalla = pantalla;
        }

        /**
         * Busco los talleres de capacitación que no se realizaron aun
         * Fecha posterior a la actual
         * @return
         */
        public ArrayList<Tupla> buscarTalleresNoRealizados()
        {
           ArrayList<Tupla> lista = new ArrayList<Tupla>();

           Session sesion;
           try {
                sesion = HibernateUtil.getSession();

                Iterator iter = sesion.createQuery("from TallerCapacitacion tc order by tc.id DESC").iterate();
                while (iter.hasNext())
                {
                   TallerCapacitacion lc = (TallerCapacitacion)iter.next();

                   Tupla t = new Tupla();
                   t.setId(lc.getId());
                   t.setNombre(lc.getTipoCapacitacion().getNombre());
                   lista.add(t);
                }

                }catch(Exception ex)
               {
                    System.out.println("EL-0002 :"+ex.getMessage());
                    pantalla.MostrarMensaje("EL-0002");
               }
           return lista;
        }

        public ArrayList<Tupla> mostrarFechasDeTaller(Tupla taller)
        {
           ArrayList<Tupla> lista = new ArrayList<Tupla>();

           Session sesion;
           try {
                sesion = HibernateUtil.getSession();
                HibernateUtil.beginTransaction();

                TallerCapacitacion lugar = (TallerCapacitacion) sesion.load(TallerCapacitacion.class,taller.getId());

                Iterator it = lugar.getDetalle().iterator();

                    while (it.hasNext())
                    {
                       DetalleHorarioTaller dht = (DetalleHorarioTaller) it.next();
                       if(!estaFechaEnLista(lista, FechaUtil.getFecha(dht.getFecha())))
                       {
                            lista.add(new Tupla(dht.getId(),FechaUtil.getFecha(dht.getFecha())));
                       }
                    }
                    HibernateUtil.commitTransaction();

                }catch(Exception ex)
               {
                    System.out.println("EL-0003 :"+ex.getMessage());
                    HibernateUtil.rollbackTransaction();
                    pantalla.MostrarMensaje("EL-0003");
               }
           return lista;
        }

        private boolean estaFechaEnLista(ArrayList<Tupla> lista, String fecha)
        {

            Iterator<Tupla> it = lista.iterator();
            while (it.hasNext())
            {
                Tupla tp = it.next();
                if(tp.getNombre().equals(fecha))
                {
                    return true;
                }
            }
            return false;
        }

        public ArrayList<Tupla> mostrarHorariosDeTaller(Tupla tTaller,Tupla tFecha)
        {
           ArrayList<Tupla> lista = new ArrayList<Tupla>();

           Session sesion;
           try {
                sesion = HibernateUtil.getSession();
                HibernateUtil.beginTransaction();

                TallerCapacitacion lugar = (TallerCapacitacion) sesion.load(TallerCapacitacion.class,tTaller.getId());

                Iterator it = lugar.getDetalle().iterator();

                    while (it.hasNext())
                    {
                       DetalleHorarioTaller dht = (DetalleHorarioTaller) it.next();

                            if( FechaUtil.getFecha(dht.getFecha()).equals(tFecha.getNombre()) )
                            {
                                lista.add(new Tupla(dht.getId(),dht.getHoraInicio()+" - "+dht.getHoraFin()));
                            }
                       
                    }
                    HibernateUtil.commitTransaction();

                }catch(Exception ex)
               {
                    System.out.println("EL-0004 :"+ex.getMessage());
                    HibernateUtil.rollbackTransaction();
                    pantalla.MostrarMensaje("EL-0004");
               }
           return lista;
        }

        public ArrayList<NTupla> ListaAsistencia(int idHorarioTaller)
        {
           ArrayList<NTupla> lista = new ArrayList<NTupla>();
           Session sesion;
           try {
                sesion = HibernateUtil.getSession();
                HibernateUtil.beginTransaction();

                DetalleHorarioTaller horario = (DetalleHorarioTaller) sesion.load(DetalleHorarioTaller.class,idHorarioTaller);

                Iterator it = horario.getAsistencias().iterator();
                while (it.hasNext())
                {
                   AsistenciaTallerCapacitacion atc = (AsistenciaTallerCapacitacion) it.next();

                        NTupla nt = new NTupla();
                        nt.setId(atc.getId());
                        nt.setNombre(atc.getEmpleado().getApellido()+", "+atc.getEmpleado().getNombre());
                        nt.setData(atc.getAsistio());

                   lista.add(nt);
               }
                HibernateUtil.commitTransaction();

                }catch(Exception ex)
               {
                    System.out.println("EL-0005 :"+ex.getMessage());
                    HibernateUtil.rollbackTransaction();
                    pantalla.MostrarMensaje("EL-0005");
               }
           return lista;

        }

        public void confirmarListaAsistencia(ArrayList<NTupla> lista)
        {
             // Me confirmaron la lista ... y angora? Cargo la lista
           Session sesion;
           try {
                sesion = HibernateUtil.getSession();
                HibernateUtil.beginTransaction();

                Iterator<NTupla> itass = lista.iterator();
                while (itass.hasNext())
                {
                   NTupla nt = itass.next();

                        AsistenciaTallerCapacitacion asist = (AsistenciaTallerCapacitacion) sesion.load(AsistenciaTallerCapacitacion.class,nt.getId());

                        System.out.println("ID AsistenciaTallerCapacitacion = "+asist.getId());

                        asist.setAsistio((Boolean)nt.getData());
                        sesion.saveOrUpdate(asist);

                }

                HibernateUtil.commitTransaction();
                pantalla.MostrarMensaje("MI-0002");

                }catch(Exception ex)
               {
                    HibernateUtil.rollbackTransaction();
                    System.out.println("EG-0006 :"+ex.getMessage());
                    pantalla.MostrarMensaje("EG-0006");
               }

        }


}
