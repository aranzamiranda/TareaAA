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
     
   
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public Burbuja() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
    }
  
    public int[] ordenar(int[] datos, int i){
        int[] d = null;
        this.tInicio = System.currentTimeMillis();
        if(i == 1){
            d = ordenarDMayor(datos);
        }
        else{
            d = ordenarDMenor(datos);
        }
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
        return d; 
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
    
}