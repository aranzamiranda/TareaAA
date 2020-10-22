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
 public static int[] generarArregloInt(int x, int dim, int bound,int clase, boolean mostrarArray)
    {
        int[] arr = new int[dim];
        
        Random random = new Random();
       
        for(int y=0; y < dim; y++)
        {
            arr[y] = random.nextInt(bound);
            while(arr[y] == x)
            {
                arr[y] = random.nextInt(bound);
            }
        }
        
        int pos = 0;
        switch (clase)
        {
            //Peor Caso
            case 1:
            {
                pos = arr.length - 1;
                break;
            }
            //Mejor Caso
            case 2:
            {
                pos = 0;
                break;
            }
            //Caso Medio
            case 3:
            {
                pos = arr.length / 2;
                break;
            }
            //Caso aleatorio
            default:
            {
                pos = random.nextInt(dim);
                break;
            }
        }
        
        arr[pos] = x;
        
        mostrarArray(arr,mostrarArray);
        return arr;
    }
    
        public static int[] generarArregloIntOrga(int dim, int bound,int clase, boolean mostrarArray)
    {
        int[] arr = new int[dim];
        
        Random random = new Random();
        
        switch (clase)
        {
            //Peor Caso
            case 1:
            {
                for(int y=0; y < dim; y++)
                {
                    arr[y] = y;
                }
                break;
            }
            
            //Mejor Caso
            case 2:
            {
                int cont = dim;
                for(int y=0; y < dim; y++)
                {
                    arr[y] = cont;
                    cont--;
                }
                break;
            }
            
            //Caso Medio
            case 3:
            {
                int cont = dim;
                for(int y=0; y < dim/2; y++)
                {
                    arr[y] = cont;
                    cont--;
                }
                for(int y=(int)dim/2; y < dim; y++)
                {
                    arr[y] = y;
                }
                break;
            }
            
            //Caso aleatorio
            default:
            {
                for(int y=0; y < dim; y++)
                {
                    arr[y] = random.nextInt(bound);
                }
                break;
            }
        }
        
        mostrarArray(arr,mostrarArray);
        return arr;
    }
     public static int[] generarArregloInt(int dim, int bound, boolean mostrarArray)
    {
        int[] arr = new int[dim];
        
        Random random = new Random();
       
        for(int y=0; y < dim; y++)
        {
            arr[y] = random.nextInt(bound);
        }
        
        mostrarArray(arr,mostrarArray);
        return arr;
    }
    
    
    public static void mostrarArray(int[] auxiliar, boolean mostrarArray)
    {
        if(mostrarArray == true)
        {
            for(int l =0; l<auxiliar.length; l++)
            {
                System.out.print("["+l+"]");
            }
            System.out.println();
            for(int l =0; l<auxiliar.length; l++)
            {
                System.out.print("-"+auxiliar[l]+"-");
            }
            System.out.println();
        }
        
    }
}
