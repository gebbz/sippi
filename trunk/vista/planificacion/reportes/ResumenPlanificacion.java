/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.planificacion.reportes;

import vista.reportes.sources.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import modelo.*;
import util.FechaUtil;
import util.RecursosUtil;
import vista.reportes.ReportDesigner;

/**
 *
 * @author Iuga
 */
public class ResumenPlanificacion extends ReportDesigner{

    private int planificacion_id;
    
    public ResumenPlanificacion(int plan_id) throws FileNotFoundException, DocumentException
    {
       this.planificacion_id = plan_id;
    }

    @Override
    protected void makeCuerpo(HashMap<String,Object> params) throws DocumentException
    {
        // Cotización Nro
        Paragraph PNroPlanificacion = new Paragraph();
        PNroPlanificacion.setAlignment(Paragraph.ALIGN_RIGHT);
        Phrase nroPlan = new Phrase("Planificación Nº: "+(Integer)params.get("PLANIFICACION_NRO"),new Font(Font.FontFamily.HELVETICA,11,Font.BOLD));
        PNroPlanificacion.add(nroPlan);    
        super.doc.add(PNroPlanificacion);
        
        // Titulos e Introducción
        Paragraph PTitulo = new Paragraph();
        PTitulo.setAlignment(Paragraph.ALIGN_LEFT);      

        PTitulo.add( new Phrase("\nEmpresa: ",ReportDesigner.FUENTE_NORMAL_B));
        PTitulo.add( new Phrase((String)params.get("PLANIFICACION_EMPRESA_CLIENTE"),ReportDesigner.FUENTE_NORMAL));
        PTitulo.add( new Phrase("\nPedido de Obra: ",ReportDesigner.FUENTE_NORMAL_B));
        PTitulo.add( new Phrase((String)params.get("PLANIFICACION_PEDIDO_OBRA"),ReportDesigner.FUENTE_NORMAL));
        PTitulo.add( new Phrase("\nFecha de Inicio Planificada: ",ReportDesigner.FUENTE_NORMAL_B));
        PTitulo.add( new Phrase((String)params.get("PLANIFICACION_FECHA_INICIO"),ReportDesigner.FUENTE_NORMAL));
        PTitulo.add( new Phrase("\nFecha de Fin Planificada: ",ReportDesigner.FUENTE_NORMAL_B));
        PTitulo.add( new Phrase((String)params.get("PLANIFICACION_FECHA_FIN"),ReportDesigner.FUENTE_NORMAL));
        PTitulo.add( new Phrase("\n\nA continuación se listan en detalle los items de la obra presupuestados con sus subtotales.\n\n",ReportDesigner.FUENTE_NORMAL));

        super.doc.add(PTitulo);
        
        List tareas = (List) params.get("PLANIFICACION_TAREAS");
        Iterator<TareaPlanificacion> itTareas = tareas.iterator();
        int orden = 0;
        while(itTareas.hasNext())
        {
            PdfPTable tabla = new PdfPTable(2);
            TareaPlanificacion tarea = itTareas.next();
            this.pintarTarea(tarea, orden, "Tarea", tabla);
            super.doc.add(tabla);
            Paragraph pnl = new Paragraph(new Phrase("\n"));
            super.doc.add(pnl);
            orden++;
        }
    }
    
    private void pintarTarea(TareaPlanificacion tarea, int orden, String tipoTarea,PdfPTable tabla)  throws DocumentException
    {
        tabla.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
        tabla.setWidthPercentage(95);
        
        PdfPCell celdaNombre = new PdfPCell(new Paragraph(tipoTarea+": "+(orden+1)+"-"+tarea.getNombre(),ReportDesigner.FUENTE_NORMAL_B));
        celdaNombre.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaNombre.setBackgroundColor(new BaseColor(219,229,241));
        celdaNombre.setColspan(2);
        tabla.addCell(celdaNombre);

        Paragraph paFechaInicio = new Paragraph();
        paFechaInicio.add(new Phrase("Fecha de Inicio: ", ReportDesigner.FUENTE_NORMAL_B));
        paFechaInicio.add(new Phrase(String.valueOf(FechaUtil.getFecha(tarea.getFechaInicio())), ReportDesigner.FUENTE_NORMAL));
        PdfPCell celdaFechaInicio = new PdfPCell(paFechaInicio);
        celdaFechaInicio.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaFechaInicio.setBackgroundColor(new BaseColor(219,229,241));
        tabla.addCell(celdaFechaInicio);

        Paragraph paFechaFin = new Paragraph();
        paFechaFin.add(new Phrase("Fecha de Fin: ", ReportDesigner.FUENTE_NORMAL_B));
        paFechaFin.add(new Phrase(String.valueOf(FechaUtil.getFecha(tarea.getFechaFin())), ReportDesigner.FUENTE_NORMAL));
        PdfPCell celdaFechaFin = new PdfPCell(paFechaFin);
        celdaFechaFin.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaFechaFin.setBackgroundColor(new BaseColor(219,229,241));
        tabla.addCell(celdaFechaFin);
        
        Paragraph paObservaciones = new Paragraph();
        paObservaciones.add(new Phrase("Observaciones: \n\n", ReportDesigner.FUENTE_NORMAL_B));
        paObservaciones.add(new Phrase(tarea.getObservaciones(), ReportDesigner.FUENTE_NORMAL));
        PdfPCell celdaDesc = new PdfPCell(paObservaciones);
        celdaDesc.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaDesc.setColspan(2);
        tabla.addCell(celdaDesc);


        //Recursos
        PdfPCell celdaRecurso = new PdfPCell(new Paragraph("Recurso",ReportDesigner.FUENTE_NORMAL_BK));
        celdaRecurso.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaRecurso.setBackgroundColor(new BaseColor(219,229,241));
        celdaNombre.setColspan(1);
        tabla.addCell(celdaRecurso);


        PdfPCell celdaDescripcion = new PdfPCell(new Paragraph("Descripción",ReportDesigner.FUENTE_NORMAL_BK));
        celdaDescripcion.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaDescripcion.setBackgroundColor(new BaseColor(219,229,241));
        tabla.addCell(celdaDescripcion);

        String unidad= "";
        
        // Mano de Obra
        Iterator<DetalleTareaPlanificacion> itDetalles = tarea.getDetalles().iterator();
        while(itDetalles.hasNext())
        {
            DetalleTareaPlanificacion detalle = itDetalles.next();
            celdaRecurso = new PdfPCell(new Paragraph("Mano de Obra",ReportDesigner.FUENTE_NORMAL));
            tabla.addCell(celdaRecurso);
            celdaDescripcion = new PdfPCell(new Paragraph(
                detalle.getCantidadPersonas() + " personas - " + 
                detalle.getEspecialidad().getTipo().getNombre() + " " +
                detalle.getEspecialidad().getRango().getNombre() + ", " +
                detalle.getCantHorasNormales() + " hs/hombre - " +
                detalle.getCantHorasAl50() + " HES - " +
                detalle.getCantHorasAl100() + " HED."
                    ));
            tabla.addCell(celdaDescripcion);
        }

        // Materiales
        Iterator<PlanificacionXMaterial> itMateriales = tarea.getMateriales().iterator();
        while(itMateriales.hasNext())
        {
            PlanificacionXMaterial pxm = itMateriales.next();
            pxm.getMaterialCotizacion().getMaterial();
            RecursoEspecifico re = RecursosUtil.getRecursoEspecifico(pxm.getMaterialCotizacion().getMaterial());
            Material material = RecursosUtil.getMaterial(re);
            celdaRecurso = new PdfPCell(new Paragraph("Material",ReportDesigner.FUENTE_NORMAL));
            tabla.addCell(celdaRecurso);
            celdaDescripcion = new PdfPCell(new Paragraph(
                    material.getNombre()+ " " + 
                    re.getNombre() + ": " +
                    pxm.getCantidad() + " " +
                    material.getUnidadDeMedida().getAbreviatura(),ReportDesigner.FUENTE_NORMAL));
            tabla.addCell(celdaDescripcion);

        }

        // Herramientas
        Iterator<PlanificacionXHerramienta> itHerramientas = tarea.getHerramientas().iterator();
        while(itHerramientas.hasNext())
        {
            PlanificacionXHerramienta pxh = itHerramientas.next();
            celdaRecurso = new PdfPCell(new Paragraph("Herramienta",ReportDesigner.FUENTE_NORMAL));
            tabla.addCell(celdaRecurso);
            if(pxh.getHorasAsignadas()> 1) unidad = " Horas";
            else unidad = " Hora";
            celdaDescripcion = new PdfPCell(new Paragraph(
                    pxh.getHerramientaCotizacion().getHerramienta().getNombre() + ": " +
                    pxh.getHorasAsignadas() + unidad , ReportDesigner.FUENTE_NORMAL));
            tabla.addCell(celdaDescripcion);
        }

        // Alquileres Compras
        Iterator<PlanificacionXAlquilerCompra> itAlquilerCompra = tarea.getAlquilerCompras().iterator();
        while(itAlquilerCompra.hasNext())
        {
            PlanificacionXAlquilerCompra pxac = itAlquilerCompra.next();
            celdaRecurso = new PdfPCell(new Paragraph("Alquiler/Compra",ReportDesigner.FUENTE_NORMAL));
            tabla.addCell(celdaRecurso);
            if(pxac.getCantidad()> 1) unidad = " unidades";
            else unidad = " unidad";
            celdaDescripcion = new PdfPCell(new Paragraph(
                    pxac.getAlquilerCompraCotizacion().getTipoAlquilerCompra().getNombre() + ": " +
                    pxac.getCantidad() + unidad , ReportDesigner.FUENTE_NORMAL));
            tabla.addCell(celdaDescripcion);
        }    
        
        // Subtareas
        Iterator<TareaPlanificacion> itSubTareas = tarea.getSubtareas().iterator();
        int orden1 = 0;
        while(itSubTareas.hasNext())
        {
            TareaPlanificacion subtarea = itSubTareas.next();
            celdaRecurso = new PdfPCell(new Paragraph("",ReportDesigner.FUENTE_NORMAL));
            celdaRecurso.setColspan(2);
            tabla.addCell(celdaRecurso);
            this.pintarTarea(subtarea, orden1, "Subtarea", tabla);
            orden1++;
        }
    }
}
