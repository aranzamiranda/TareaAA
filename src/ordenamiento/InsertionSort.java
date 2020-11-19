/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import aa20201.data.Grafica;
import busquedas.GeneradorDatos;

/**
 *
 * @author chiky
 */
public class InsertionSort 
{
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public InsertionSort() 
    {
        this.tFinal = 0;//+1
        this.tInicio = 0;//+1
        this.tTotal = 0 ;//+1
    }
    
    public int[] ordenar (int[] datos,int tipo)
    {
        this.tInicio = System.currentTimeMillis();
        if(tipo == 1)//+1
        {
            datos = ordenarDatosMayor(datos);
        }
        else
        {
            datos = ordenarDatosMenor(datos);
        }
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
        return datos;
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
    
    public int[] ordenarDatosMenor(int arr[])  
    {  
        int i, key, j;  
        for (i = 1; i < arr.length; i++)
        {  
            key = arr[i];
            j = i - 1;  

            while (j >= 0 && arr[j] > key) 
            {  
                arr[j + 1] = arr[j];  
                j = j - 1; 
            }  
            arr[j + 1] = key;  
        } 
        return arr;
    }  

    
    public int[] ordenarDatosMayor(int arr[])  
    {  
        int i, key, j;  
        for (i = 1; i < arr.length; i++)
        {  
            key = arr[i];//+1+1(n)  
            j = i - 1;//+1+1(n)  

            while (j <= 0 && arr[j] < key)
            {  
                arr[j + 1] = arr[j];
                j = j - 1;
            }  
            arr[j + 1] = key;
        } 
        return arr;
    }
    
    public void codigoGrafica(int n, int tipo, int bound, int tipoGeneracion)
    {
        int[] aux;
        double[] tiempos = new double[n];
        InsertionSort I = new InsertionSort();

        for (int j = 0; j < n; j++)
        {
            aux = GeneradorDatos.generarArregloIntOrga(j+1,bound,tipoGeneracion,false);
            aux = I.ordenar(aux,tipo);
            tiempos[j] = (int)I.gettTotal();
        }  

        Grafica g1 = new Grafica("N","Tiempo","Tiempos");
        g1.agregarSerie("t1",tiempos);
        g1.crearGrafica();
        System.out.println();
        g1.muestraGrafica();
    }
    
    public double[] codigoTiempos(int n, int tipo, int bound, int tipoGeneracion)
    {
        System.out.println("InsertSort");

        int[] aux;
        double[] tiempos = new double[n];
        InsertionSort I = new InsertionSort();

        for (int j = 0; j < n; j++)
        {
            aux = GeneradorDatos.generarArregloIntOrga(j+1,bound,tipoGeneracion,false);
            aux = I.ordenar(aux,tipo);
            tiempos[j] = (int)I.gettTotal();
        }
        System.out.println("Fin de InsertSort");
        return tiempos;
    }
}
