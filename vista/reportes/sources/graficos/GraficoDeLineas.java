/*
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.reportes.sources.graficos;

import java.awt.Color;
import java.awt.Paint;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Administrador
 */
public class GraficoDeLineas {

    private String title;
    private DefaultCategoryDataset data;

    public GraficoDeLineas(String title, DefaultCategoryDataset data) {
        this.title = title;
        this.data = data;
    }
    
    public JFreeChart createGraph() {
        
        final JFreeChart chart = ChartFactory.createLineChart(
            title,             // chart title
            "",               // domain axis label
            "",                  // range axis label
            data,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            false,                     // tooltips
            false                     // urls
        );
        
        chart.setBackgroundPaint(Color.white);
        
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setForegroundAlpha(0.5f);
        
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();   
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());   
        rangeAxis.setLabelAngle(0 * Math.PI / 2.0); 
        
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);  
        
        Paint[] paints= new Paint[] { new Color( 153, 0, 255 ,100 ), 
                              new Color( 204,0,255, 150 ) };
        
        CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, Color.green);
        renderer.setSeriesPaint(1, Color.red);
        renderer.setSeriesPaint(2, Color.blue);
        renderer.setSeriesPaint(3, Color.orange);
        
        return chart;
    }
    
   
    
    
    
}
