/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

    public static String getMaskedDate(String mascara,Date fecha)
    {
        DATE_FORMAT = new SimpleDateFormat(mascara, new Locale("es_AR"));
        DATE_FORMAT.setTimeZone(new SimpleTimeZone(-3, "GMT"));

        return DATE_FORMAT.format(fecha);
    }    
    
    public static String getYear()
    {
        DATE_FORMAT = new SimpleDateFormat("yyyy", new Locale("es_AR"));
        DATE_FORMAT.setTimeZone(new SimpleTimeZone(-3, "GMT"));

        Date fechaDate = new Date();
        return DATE_FORMAT.format(fechaDate);
    }
    
    public static String getYear(Date fecha)
    {
        DATE_FORMAT = new SimpleDateFormat("yyyy", new Locale("es_AR"));
        DATE_FORMAT.setTimeZone(new SimpleTimeZone(-3, "GMT"));

        return DATE_FORMAT.format(fecha);
    }
    
    public static String getMonth(Date fecha)
    {
        DATE_FORMAT = new SimpleDateFormat("MM", new Locale("es_AR"));
        DATE_FORMAT.setTimeZone(new SimpleTimeZone(-3, "GMT"));

        return DATE_FORMAT.format(fecha);
    }
    
    public static String getDay(Date fecha)
    {
        DATE_FORMAT = new SimpleDateFormat("dd", new Locale("es_AR"));
        DATE_FORMAT.setTimeZone(new SimpleTimeZone(-3, "GMT"));

        return DATE_FORMAT.format(fecha);
    }
    
    public static String getFecha(Date d)
    {
        if(d!=null)
        {
            DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy", new Locale("es_AR"));
            DATE_FORMAT.setTimeZone(new SimpleTimeZone(-3, "GMT"));
            return DATE_FORMAT.format(d);
        }
        return "";
    }

    public static String getFechaActual()
    {
        DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy", new Locale("es_AR"));
        DATE_FORMAT.setTimeZone(new SimpleTimeZone(-3, "GMT"));
        Date fechaDate = new Date();
        return DATE_FORMAT.format(fechaDate);
    }

    public static Date getDate(String fecha) throws ParseException
    {
        DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy", new Locale("es_AR"));
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
        if(fecha==null || rangoInicio==null || rangoFin==null){
            return false;
        }
        
        System.out.println("Chequeo Rango de Fechas -> Fecha:"+FechaUtil.getFecha(fecha)+" en rango["+FechaUtil.getFecha(rangoInicio)+"/"+FechaUtil.getFecha(rangoFin)+"]");
        
//      Alternativa:        
//      return !(fecha.before(rangoInicio) || fecha.after(rangoFin));
        
        long f = fecha.getTime();
        long ri = rangoInicio.getTime();
        long rf = rangoFin.getTime();

        if(f-ri>=0 && rf-f>=0)
        {
            return true;
        }
        return false;
    }
    
    public static boolean fechaMayorOIgualQue(Date fecha, Date aComparar)
    {
        long f = fecha.getTime();
        long ri = aComparar.getTime();       

        if(f-ri>=0)
        {
            return true;
        }
        return false;
    }    
    
    public static boolean fechaMayorQue(Date fecha, Date aComparar)
    {
        long f = fecha.getTime();
        long ri = aComparar.getTime();       

        if(f-ri>0)
        {
            return true;
        }
        return false;
    }
    
    public static boolean horaEnRango(String hora, String horaInicio, String horaFin) throws ParseException
    {
        DATE_FORMAT = new SimpleDateFormat("H:m", new Locale("es_AR"));
        DATE_FORMAT.setTimeZone(new SimpleTimeZone(-3, "GMT"));
        
        Long horaAux = DATE_FORMAT.parse(hora).getTime();
        Long horaInicioAux = DATE_FORMAT.parse(horaInicio).getTime();
        Long horaFinAux = DATE_FORMAT.parse(horaFin).getTime();

        if(horaAux>=horaInicioAux && horaAux<=horaFinAux)
        {
            return true;
        }
        return false;
    }

    public static String getFechaYHoraActual()
    {
        DATE_FORMAT = new SimpleDateFormat("H:m:s dd/MM/yyyy", new Locale("es_AR"));
        DATE_FORMAT.setTimeZone(new SimpleTimeZone(-3, "GMT")); //TODO: Ver despues como hacer para no hardcodear esto
        Date fecha = new Date();
        return DATE_FORMAT.format(fecha);
    }

    public static Date fechaMas(Date fch, int dias)
    { 
     Calendar cal = new GregorianCalendar(); 
     cal.setTimeInMillis(fch.getTime()); 
     cal.add(Calendar.DATE, dias); 
     return new Date(cal.getTimeInMillis()); 
    } 

   public static Date fechaMenos(Date fch, int dias)
   { 
     Calendar cal = new GregorianCalendar(); 
     cal.setTimeInMillis(fch.getTime()); 
     cal.add(Calendar.DATE, -dias); 
     return new Date(cal.getTimeInMillis()); 
   }

   public static Date getToday(Date d) //Devuelve la fecha pasada por parametros pero sin horas ni minutos (fecha en hora cero)
   { 
        // el dia de hoy sin horas ni nada.        
        GregorianCalendar ddate = new GregorianCalendar();
        ddate.setTime(d);    
        GregorianCalendar ddateday = new GregorianCalendar(ddate.get(GregorianCalendar.YEAR), ddate.get(GregorianCalendar.MONTH), ddate.get(GregorianCalendar.DAY_OF_MONTH));
        return ddateday.getTime();       
    }
   
    public static int getYearFromDate(Date date) {
        int result = -1;
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            result = cal.get(Calendar.YEAR);
        }
        return result;
    }
    
    public static Date getLimpiarHorasYMinutos(Date date) {        
        // Get Calendar object set to the date and time of the given Date object  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  

        // Set time fields to zero  
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);  

        // Put it back in the Date object  
        date = cal.getTime();  
        return date;
    }
   
}
