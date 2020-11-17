/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

/**
 *
 * @author chiky
 */
public class QuickSort {
    private long tInicial;
    private long tFinal;
    private long tTotal;
    
    public QuickSort(){
        this.tInicial = 0;
        this.tFinal = 0;
        this.tTotal = 0;
    }
    
    public void ordenar(int[] datos){
        this.tInicial = System.currentTimeMillis();
        
    }
    
    public void ordenarDatos(int[] datos, int inicio, int fin){
        if (inicio < fin) 
        { 
             int pi = particion(datos, inicio, fin); 
  //Antes de que se clasifiquen de forma recursiva los elementos  
            ordenarDatos(datos, inicio, pi-1); 
            ordenarDatos(datos, pi+1, fin); 
        } 
    }
    
    public int particion(int[] datos, int inicio, int fin){
        int pivot = datos[fin];  
        int i = (inicio-1);  
        for (int j=inicio; j<fin; j++) 
        {  
            if (datos[j] < pivot) 
            { 
                i++;  
                int temp = datos[i]; 
                datos[i] = datos[j]; 
                datos[j] = temp; 
            } 
        }  
        int temp = datos[i+1]; 
        datos[i+1] = datos[fin]; 
        datos[fin] = temp; 
  
        return i+1; 
    }
    
    
    public long gettInicial() {
        return tInicial;
    }

    public long gettFinal() {
        return tFinal;
    }

    public long gettTotal() {
        return tTotal;
    }
    
    
}
