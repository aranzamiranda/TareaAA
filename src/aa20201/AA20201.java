/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa20201;
import busquedas.BusquedaSecuencial;
import busquedas.GeneradorDatos;
import java.awt.Color;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 *
 * @author chiky
 */
public class AA20201 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      int j = 0;
        int[] aux; 
        int lim = 500000;
        int tiempoTotal = 0;
        int[] auxPeor;
        int[] auxMejor;
        int[] auxMedio;
        boolean inicio = true;
        int[] tiemposPeor = new int[lim];
        int[] tiemposMejor = new int[lim];
        int[] tiemposMedio = new int[lim];
        //XYSeriesCollection es la colecci on de todos esos puntos
        XYSeriesCollection dataSet = new XYSeriesCollection();
        XYSeries lineaPeor = new XYSeries("Peor caso");
        XYSeries lineaMejor = new XYSeries("Mejor caso");
        XYSeries lineaMedio = new XYSeries("Caso medio"); 
        
        BusquedaSecuencial b1 = new BusquedaSecuencial();
        
        for(j=1;j<lim;j++){
              auxPeor = GeneradorDatos.generarArregloIntPeorCaso(6, j+1, 100);
              auxMejor = GeneradorDatos.generarArregloIntMejorCaso(6, j+1, 100);
              auxMedio = GeneradorDatos.generarArregloIntCasoMedio(6, j+1, 100);
              
               int posPeor = b1.buscar(auxPeor, 6);
               int posMedio = b1.buscar(auxMedio, 8); 
               int posMejor = b1.buscar(auxMejor, 5);
               tiemposPeor[j] = (int)b1.gettTotal();
               tiemposMejor[j] = (int)b1.gettTotal();
               tiemposMedio[j] = (int)b1.gettTotal();
               
               System.out.println("Peor: "+j+" :"+tiemposPeor[j]);
               System.out.println("Mejor: "+j+" :"+tiemposMejor[j]);
               System.out.println("Medio: "+j+" :"+tiemposMedio[j]);
               
               lineaPeor.add(j, tiemposPeor[j]);
               lineaMejor.add(j, tiemposMejor[j]);
               lineaMedio.add(j, tiemposMedio[j]);
        }
        
        dataSet.addSeries(lineaPeor);
       dataSet.addSeries(lineaMejor);
       dataSet.addSeries(lineaMedio);
       JFreeChart datosGrafica;
       datosGrafica = ChartFactory.createXYLineChart("Grafica de Datos", "Iteraciones", "Tiempo", dataSet, PlotOrientation.VERTICAL, true, false, false);
       ChartPanel graficaFrame = new ChartPanel(datosGrafica);
       graficaFrame.setVisible(true);
       graficaFrame.setSize(450, 450);
       
       JFrame ventana = new JFrame("Grafica de Datos");
       ventana.setSize(500, 500);
       ventana.setLocationRelativeTo(null);
       ventana.setVisible(true);
       ventana.add(graficaFrame);
       
       
       System.out.println("Tiempo: "+b1.gettTotal()+"");
    }
    
}
