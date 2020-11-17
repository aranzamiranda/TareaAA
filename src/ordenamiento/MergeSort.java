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
public class MergeSort {
    //variables para obtener tiempos
    private long tInicial;
    private long tFinal;
    private long tTotal;
    
    public MergeSort(){
        this.tInicial = 0;
        this.tFinal = 0;
        this.tTotal = 0;
    }
    
    public void ordenar(int[] datos){
        this.tInicial = System.currentTimeMillis();
        
    }
    
    public void ordenarDatos(int[] datos, int l, int r)
    {
        if(l < r){
            // Find the middle point 
            int m = (l + r) / 2; 
  
            // Sort first and second halves 
            ordenarDatos(datos, l, m); 
            ordenarDatos(datos, m + 1, r); 
  
            // Merge the sorted halves 
            merge(datos, l, m, r); 
        }
    }
    
    public void merge(int[] datos, int l, int m, int r)
    {
        //creando el tamaño de las sublistas temporales
        int n1 = m - l + 1;
        int n2 = r - m;
        
        //creando las sublistas temporales
        int[] dL = new int[n1];
        int[] dR = new int[n2];
        
        //Copiando el contenido de la lista principal, a las sublistas
        for(int i = 0; i<n1; i++){
            dL[i] = datos[1 + i];
        }
        
        for(int j = 0; j<n2; j++){
            dR[j] = datos[m + 1 + j];
        }
        
        //Indices iniciales para hacer el merge
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) { 
            if (dL[i] <= dR[j]) { 
                datos[k] = dL[i]; 
                i++; 
            } 
            else { 
                datos[k] = dR[j]; 
                j++; 
            } 
            k++;             
        }
        
         /* Copy remaining elements of L[] if any */
        while (i < n1) { 
            datos[k] = dL[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) { 
            datos[k] = dR[j]; 
            j++; 
            k++; 
        } 
    }

    /**
     * @return the tInicial
     */
    public long gettInicial() {
        return tInicial;
    }

    /**
     * @return the tFinal
     */
    public long gettFinal() {
        return tFinal;
    }

    /**
     * @return the tTotal
     */
    public long gettTotal() {
        return tTotal;
    }
    
    
    
}
