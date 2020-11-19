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
    public static int[] generarArregloIntOrga(int dim, int bound,int clase, boolean mostrarArray)
    {
        int[] arreglo = new int[dim];//+1
        
        Random ran = new Random();//+1
        
        switch (clase)
        {
            //Menor a Mayor
            case 1:
            {
                for(int y=0; y < dim; y++)//+1 (+1+2(n))
                {
                    arreglo[y] = y;//+1+1(n)
                }
                break;
            }
            
            //De mayor a menor
            case 2:
            {
                int cont = dim;//+1
                for(int y=0; y < dim; y++)//+1 (+1+2(n))
                {
                    arreglo[y] = cont;//+1+1(n)
                    cont--;//+2(n)
                }
                break;
            }
            
            //Mitad de Mayor a Menor y otra mitad de Menor a Mayor
            case 3:
            {
                int cont = dim;//+1
                for(int y=0; y < dim/2; y++)//+1 (+1+2(n))
                {
                    arreglo[y] = cont;//+1(n)
                    cont--;//+2(n)
                }
                for(int y=(int)dim/2; y < dim; y++)//+1+1 (+1+2(n))
                {
                    arreglo[y] = y;//+1(n)
                }
                break;
            }
            
            //Caso aleatorio
            default:
            {
                for(int y=0; y < dim; y++)//+1 (+1+2(n))
                {
                    arreglo[y] = ran.nextInt(bound);//+1(n)
                }
                break;
            }
        }
        
        mostrarArray(arreglo,mostrarArray);
        return arreglo;
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
    public static void mostrarArray(int[] aux,boolean mostrarArray)
    {
        if(mostrarArray == true)
        {
            for(int l =0; l<aux.length; l++)
            {
                System.out.print("["+l+"]");
            }
            System.out.println();
            for(int l =0; l<aux.length; l++)
            {
                System.out.print("-"+aux[l]+"-");
            }
            System.out.println();
        }
    }
}
