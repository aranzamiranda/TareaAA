/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa20201;
import aa20201.data.Grafica;
import busquedas.BusquedaSecuencial;
import busquedas.GeneradorDatos;
import busquedas.Busquedas;
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
     int n = 1000;
        int[] aux;
        
        double[] tiemposBurbuja = new double[n];
        double[] tiemposBurbujaOp = new double[n];
        double[] tiemposInsert = new double[n];
        double[] tiemposMerge = new double[n];
        double[] tiemposQuick = new double[n];
        
        //Ordenamiento burbuja
        Burbuja b = new Burbuja();
        BurbujaOpt bO = new BurbujaOpt();
        InsertionSort in = new InsertionSort();
        MergeSort ms = new MergeSort();
        QuickSort qs = new QuickSort();
        
        // complejidad algoritmica Sumatoria ( Generar los datos aleatorios + busqueda + almacenar el tiempo)
        for (int j = 0; j < n; j++){
            aux = GeneradorDatos.generarArregloInt(n, 1);
            
            //Burbuja Simple
            b.ordenar(aux.clone());
            tiemposBurbuja[j] = (int) b.gettTotal();
            
            //Burbuja optimizado
            bO.ordenar(aux.clone());
            tiemposBurbujaOp[j] = (int) bO.gettTotal();
            
            //Insert Sort
            in.ordenar(aux.clone());
            tiemposInsert[j] = (int) in.gettTotal();
            
            //Merge Sort
            ms.ordenarDatos(aux.clone(), 0, aux.length - 1);
            tiemposMerge[j] = (int) ms.gettTotal();
            
            //Quick Sort
            qs.ordenarDatos(aux.clone(), 0, aux.length - 1);
            tiemposQuick[j] = (int) qs.gettTotal();
        }  
        
        //Graficacion
        Grafica g1 = new Grafica("n","tiempo","Graficación Caso Medio"); 
        g1.agregarSerie("Burbuja Simple",tiemposBurbuja);
        g1.agregarSerie("Burbuja Optimizado", tiemposBurbujaOp);
        g1.agregarSerie("Insert", tiemposInsert);
        g1.agregarSerie("Merge", tiemposMerge);
        g1.agregarSerie("Quick", tiemposQuick);
        g1.crearGrafica();
        g1.muestraGrafica();
    }
    
}
