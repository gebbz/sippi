/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

/**
 * Descripción:
 * @version 1.0
 * @author Iuga
 * @cambios
 * @todo
 */

//    Año
//
//    "yy" -> "03″
//    "yyyy" -> "2003″
//
//    Mes
//
//    "M" -> "7″
//    "M" -> "12″
//    "MM" -> "07″
//    "MMM" -> "Jul"
//    "MMMM" -> "Deciembre"
//
//    Día del mes
//
//    "d" -> "3″
//    "dd" -> "03″


public class FechaUtil {

    private static SimpleDateFormat DATE_FORMAT = null;

    public FechaUtil()
    {

    }

    public static String getYear()
    {
        DATE_FORMAT = new SimpleDateFormat("yyyy", new Locale("es_ES"));
        DATE_FORMAT.setTimeZone(new SimpleTimeZone(-3, "GMT"));

        Date fechaDate = new Date();
        return DATE_FORMAT.format(fechaDate);
    }
    
    public static String getFecha(Date d)
    {
        DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy", new Locale("es_ES"));
        DATE_FORMAT.setTimeZone(new SimpleTimeZone(-3, "GMT"));
        return DATE_FORMAT.format(d);
    }

    public static String getFechaActual()
    {
        DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy", new Locale("es_ES"));
        DATE_FORMAT.setTimeZone(new SimpleTimeZone(-3, "GMT"));
        Date fechaDate = new Date();
        return DATE_FORMAT.format(fechaDate);
    }

    public static Date getDate(String fecha) throws ParseException
    {
        DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy", new Locale("es_ES"));
        DATE_FORMAT.setTimeZone(new SimpleTimeZone(-3, "GMT"));
        return DATE_FORMAT.parse(fecha);
    }

    public static int diasDiferencia(Date inicio, Date fin)
    {
        long segInicio = inicio.getTime();
        long segFin    = fin.getTime();
        long diferencia = segFin - segInicio;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ( (int) dias);
    }

    public static int diasDiferencia(String sInicio, String sFin) throws ParseException
    {
        Date inicio = FechaUtil.getDate(sInicio);
        Date fin    = FechaUtil.getDate(sFin);

        long segInicio = inicio.getTime();
        long segFin    = fin.getTime();
        long diferencia = segFin - segInicio;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ( (int) dias);
    }

    public static boolean fechaEnRango(Date fecha, Date rangoInicio, Date rangoFin)
    {
        System.out.println("Chequeo Rango de Fechas -> Fecha:"+FechaUtil.getFecha(fecha)+" en rango["+FechaUtil.getFecha(rangoInicio)+"/"+FechaUtil.getFecha(rangoFin)+"]");

        long f = fecha.getTime();
        long ri = rangoInicio.getTime();
        long rf = rangoFin.getTime();

        if(f-ri>=0 && rf-f>=0)
        {
            return true;
        }
        return false;
    }

}