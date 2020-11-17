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
public class Burbuja {
     
   //variables para obtener tiempos
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public Burbuja() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
    }
  
    public void ordenar(int[] datos){
        this.tInicio = System.currentTimeMillis();
        ordenarDatos(datos);
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    public long gettFinal() {
        return tFinal;
    }

    public long gettInicio() {
        return tInicio;
    }

    public long gettTotal() {
        return tTotal;
    }
     public int[] ordenarDMayor(int[] arr)
    {
       for(int i = 0; i < arr.length - 1; i++)
        {
            for(int j = 0; j < arr.length - 1; j++)
            {
                if (arr[j] < arr[j + 1])
                {
                    int tiempo = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tiempo;
                }
            }
        }
       return arr;
    }

   public int[] ordenarDMenor(int[] arr)
    {
       for(int i = 0; i < arr.length - 1; i++)
        {
            for(int j = 0; j < arr.length - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
       return arr;
    }
    private void ordenarDatos(int[] datos) {
       int aux = 0;
       for (int i = 0; i<datos.length; i++){
           for(int j = 0; j<datos.length - 1; j++){
               if(datos[j] > datos[j+1]){
                   aux = datos[j];
                   datos[j] = datos[j+1];
                   datos[j+1] = aux;
               }
           }
       }
    }
    
}