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
public class InsertionSort {
    private long tInicial;
    private long tFinal;
    private long tTotal;

    public InsertionSort(){
        this.tFinal = 0;
        this.tInicial = 0;
        this.tTotal = 0;
    }
    
    public void ordenar(int[] datos)
    {
        this.tInicial = System.currentTimeMillis();
        ordenarDatos(datos);
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicial;
    }
    
    public void ordenarDatos(int[] datos)
    {
        int aux = 0;
        int j = 0;
        for(int i = 1; i < datos.length; i++)
        {
            aux = datos[i];
            j = i - 1;
            while((j >=0) && (datos[j] > aux))
            {
                datos[j+1] = datos[j];
                j--;
            }
            datos[j+1] = aux;
        }
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
