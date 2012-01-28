package controlador.planificacion_old;

import java.util.ArrayList;
import java.util.Iterator;
import modelo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
import util.NTupla;
import vista.planificacion_old.pantallaConsultarPresupuestos;


public class GestorConsultarPresupuestos {

    private pantallaConsultarPresupuestos pantalla;


    public GestorConsultarPresupuestos(pantallaConsultarPresupuestos aThis)
    {
        this.pantalla = aThis;
    }

    private ArrayList<PedidoObra> buscarObras()
    {

        ArrayList<PedidoObra> lista = new ArrayList<PedidoObra>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();

        sesion.beginTransaction();
        Iterator iter = sesion.createQuery("from PedidoObra p order by p.nombre").iterate();
        while ( iter.hasNext() )
        {
            PedidoObra p = (PedidoObra)iter.next();
            lista.add(p);
        }
        return lista;
    }

    public ArrayList<NTupla> cargarPresupuestos()
    {
        ArrayList<NTupla> lista = new ArrayList<NTupla>();

        Iterator<PedidoObra> it = buscarObras().iterator();
        while (it.hasNext()) 
        {
            PedidoObra po = it.next();
//            Iterator<Presupuesto> itp = po.getPresupuestos().iterator();
//            while (itp.hasNext())
//            {
//                Presupuesto pr = itp.next();
//
//                    NTupla nt = new NTupla(pr.getId());
//                    nt.setNombre(po.getNombre());
//
//                        String data[] = new String[2];
//                        data[0] = po.getPlanta().getRazonSocial();
//                        data[1] = pr.getVersion();
//                        nt.setData(data);
//                    lista.add(nt);
//            }
        }

        return lista;
    }

}