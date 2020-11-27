/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa20201;
import TSP.Ciudad;
import TSP.PuntosXY;
import TSP.TSPDinamico;
import aa20201.data.Grafica;
import busquedas.BusquedaSecuencial;
import busquedas.GeneradorDatos;
import busquedas.Busquedas;
import fibonacci.CompararMetodos;
import fibonacci.FibonacciRecursivoDinamico;
import java.util.Random;
import ordenamiento.Burbuja;
import ordenamiento.BurbujaOpt;
import ordenamiento.InsertionSort;
import ordenamiento.MergeSort; 
import ordenamiento.QuickSort;
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
/*CompararMetodos fc = new CompararMetodos(
                30,
                true,
                true,
                new int[]{
                    1,
                    1,
                    1,
                    1
            });
      */ 
 Ciudad ciudadInicial = new Ciudad("A",new PuntosXY(2, 3),0);

        Ciudad[] ciudades = new Ciudad[10];
        
        for(int i=0;i<ciudades.length;i++){
            Random random = new Random();
            char nombreCiudad = (char)(i+65);
            ciudades[i] = new Ciudad(Character.toString(nombreCiudad), new PuntosXY(random.nextInt(100), random.nextInt(100)), i+1);
        }
        
        TSPDinamico tsp = new TSPDinamico(ciudades);
        
        long inicio = System.currentTimeMillis();
        tsp.recorrerCaminos(ciudadInicial, ciudades,ciudadInicial,0.0);
        long fTiempo = System.currentTimeMillis() - inicio;
        
        System.out.println(fTiempo);

    }
   
} 
