/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Herramienta;
import modelo.Material;
import modelo.Recurso;
import modelo.RecursoEspecifico;
import modelo.RecursoXProveedor;

/**
 *
 * @author dell
 */
public class RecursosUtil {
    static Map<RecursoXProveedor, RecursoEspecifico> mapaMateriales = new HashMap<RecursoXProveedor, RecursoEspecifico>();
    
    
    public static RecursoEspecifico getRecursoEspecifico(RecursoXProveedor rxp){
        RecursoEspecifico reEncontrado=null;
        RecursoEspecifico re=null;
        if (mapaMateriales.containsKey(rxp)) {
                 // Sumo las horas solamente
                 return mapaMateriales.get(rxp);
        }
        else{}
        try {
            reEncontrado= (RecursoEspecifico)HibernateUtil.getSession().createQuery("from RecursoEspecifico RE where :cID in elements(RE.proveedores)").setParameter("cID", rxp).uniqueResult();
             mapaMateriales.put(rxp, reEncontrado);
             
        } catch (Exception ex) {
            Logger.getLogger(RecursosUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reEncontrado;
    }

//    public static Recurso getRecurso(RecursoEspecifico re){
//        Recurso rEncontrado = null;
//        Recurso r=null;
//        try {
//            //r = (Recurso) HibernateUtil.getSession().createQuery("FROM Recurso r WHERE re.recursos IN(:re)").setParameter("%re%", re);
//            Iterator it = HibernateUtil.getSession().createQuery("FROM Recurso").iterate();
//            while(it.hasNext()){
//                r=(Recurso)it.next();
//                Iterator<RecursoEspecifico> itr = r.getRecursos().iterator();
//                RecursoEspecifico resp = null;
//                while(itr.hasNext()){
//                    resp = itr.next();
//                    if(resp.equals(re)){
//                        rEncontrado=r;
//                        break;
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(RecursosUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rEncontrado;
//    }

    public static Material getMaterial(RecursoEspecifico re){
        Material rEncontrado = null;
        Material r=null;
        try {
            //r = (Recurso) HibernateUtil.getSession().createQuery("FROM Recurso r WHERE re.recursos IN(:re)").setParameter("%re%", re);
            rEncontrado= (Material)HibernateUtil.getSession().createQuery("from Material MA where :cID in elements(MA.recursos)").setParameter("cID", re).uniqueResult();
            /*Iterator it = HibernateUtil.getSession().createQuery("FROM Material").iterate();
            while(it.hasNext()){
                r=(Material)it.next();
                Iterator<RecursoEspecifico> itr = r.getRecursos().iterator();
                RecursoEspecifico resp = null;
                while(itr.hasNext()){
                    resp = itr.next();
                    if(resp.getId()==re.getId()){
                        rEncontrado=r;
                        break;
                    }
                }
            }*/
        } catch (Exception ex) {
            Logger.getLogger(RecursosUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rEncontrado;
    }
    
    /**
     * Método que busca un Material por RecursoXProveedor, es decir, por el precio que el Proveedor lo vende
     * @param rxp
     * @return el Material buscado
     */
    public static Material getMaterial(RecursoXProveedor rxp){
        Material rEncontrado = null;
        Material r=null;
        try {
            rEncontrado= (Material)HibernateUtil.getSession().createQuery(
                    "select m from Material m inner join "
                    + "m.recursos re where re.id in "
                    + "( from RecursoEspecifico re where "
                    + ":rxp in elements(re.proveedores))")
                    .setParameter("rxp", rxp).uniqueResult();
            
            /*Iterator it = HibernateUtil.getSession().createQuery("FROM Material").iterate();
            while(it.hasNext()){
                r=(Material)it.next();
                Iterator<RecursoEspecifico> itr = r.getRecursos().iterator();
                RecursoEspecifico resp = null;
                while(itr.hasNext()){
                    resp = itr.next();
                    RecursoXProveedor rxpAux = null;
                    Iterator<RecursoXProveedor> itrxp = resp.getRecursosXProveedor().iterator();
                    while(itrxp.hasNext())
                    {
                        rxpAux = itrxp.next();
                        if(rxpAux.getId() == rxp.getId())
                        {
                            rEncontrado=r;
                        break;
                        }
                    }
                }
            }*/
        } catch (Exception ex) {
            Logger.getLogger(RecursosUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rEncontrado;
    }

    public static Herramienta getHerramienta(RecursoEspecifico re){
        Herramienta rEncontrado = null;
        Herramienta r=null;
        try {
            rEncontrado= (Herramienta)HibernateUtil.getSession().createQuery("from Herramienta HE where :cID in elements(HE.recursos)").setParameter("cID", re).uniqueResult();
            /*Iterator it = HibernateUtil.getSession().createQuery("FROM Herramienta").iterate();
            while(it.hasNext()){
                r=(Herramienta)it.next();
                Iterator<RecursoEspecifico> itr = r.getRecursos().iterator();
                RecursoEspecifico resp = null;
                while(itr.hasNext()){
                    resp = itr.next();
                    if(resp.getId()==re.getId()){
                        rEncontrado=r;
                        break;
                    }
                }
            }*/
        } catch (Exception ex) {
            Logger.getLogger(RecursosUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rEncontrado;
    }
}
