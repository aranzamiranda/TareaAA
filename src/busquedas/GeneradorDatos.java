/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedas;

import java.util.Random;

/**
 *
 * @author working
 */
public class GeneradorDatos {
    
  // "aleatorio"
    public static int[] generarArregloInt(int x, int dim, int bound){
        int[] arreglo = new int[dim];
        Random ran = new Random();
       
        for(int y=0; y < dim; y++){
            arreglo[y] = ran.nextInt(bound);
        }
        int pos = ran.nextInt(dim);
        arreglo[pos] = x;
       return arreglo;
    }
    
    // peor de los casos / Ordenado de manera descendente
    public static int[] generarArregloIntPeorCaso(int dim){
        int[] arreglo = new int[dim];
        int control = 0;
      
        for(int y = dim-1; y >= 0; y--){
            arreglo[control] = y;
            control++;
        }
        //arreglo[arreglo.length-1] = x;
       return arreglo;
    }
    
    public static int[] generarArregloIntMejorCaso(int dim){
        int[] arreglo = new int[dim];
        int control = 0;
      
        for(int y = 0; y <= dim - 1; y++){
            arreglo[control] = y;
            control++;
        }
        //arreglo[arreglo.length-1] = x;
       return arreglo;
    }
    
   
    // genera numeros aleatorio en base a un valor x que no queremos que genere
    public static int generarNumeroAleatorioControlado (int x, int bound){
        Random ran = new Random();
        int aux = ran.nextInt(bound);
        while(aux==x){
         aux = ran.nextInt(bound);
        }
        return aux;
    }
    
    //Medio caso, numeros aleatorios
    public static int[] generarArregloInt(int n, int bound){
        int[] arreglo = new int[n];
        Random ran = new Random();
     
        for(int y=0; y < n; y++){
            arreglo[y] = ran.nextInt(bound);
        }
        
       return arreglo;
    }
}
