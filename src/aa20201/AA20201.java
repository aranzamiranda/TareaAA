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
import fibonacci.CompararMetodos;
import fibonacci.FibonacciRecursivoDinamico;
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
CompararMetodos fc = new CompararMetodos(
                30,
                true,
                true,
                new int[]{
                    1,
                    1,
                    1,
                    1
                });
    }
    
} 
