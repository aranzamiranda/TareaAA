/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;
import aa20201.data.Grafica;
import busquedas.GeneradorDatos;
import ordenamiento.InsertionSort;
/**
 *
 * @author chiky
 */
public class FibonacciIterativo {
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public FibonacciIterativo()
    {
        this.tFinal = 0;//+1
        this.tInicio = 0;//+1
        this.tTotal = 0 ;//+1
    }
    
    public int FibonacciIterativo(int serie)
    {
        this.tInicio = System.currentTimeMillis();
        int num1 = 0, num2 = 1, suma = 1;
        // Muestro el valor inicial
         
        for (int i = 1; i < serie; i++) 
        {    
            suma = num1 + num2;
            num1 = num2;
            num2 = suma;    
        }
        this.tFinal = System.currentTimeMillis();//+1
        this.tTotal = this.tFinal - this.tInicio;
        return suma;
    }

    public void codigoGrafica(int n)
    {
        int[] aux;
        double[] tiempos = new double[n];//+1
        FibonacciIterativo I = new FibonacciIterativo();//+1

        for (int j = 0; j < n; j++)//+1 (+1+2(n))
        {
            I.FibonacciIterativo(j);//+1(n)
            tiempos[j] = (int)I.gettTotal();//+1+1(n)
        }  

        Grafica g1 = new Grafica("N","Tiempo","Tiempos");//+1
        g1.agregarSerie("t1",tiempos);
        g1.crearGrafica();
        System.out.println();
        g1.muestraGrafica();
    }
    
    public double[] codigoTiempos(int n)
    {
        System.out.println("Fibonacci Iterativo");
        int aux;
        double[] tiempos = new double[n];
        FibonacciIterativo I = new FibonacciIterativo();

        for (int j = 0; j < n; j++)
        {
            aux = I.FibonacciIterativo(n);
            tiempos[j] = (int)I.gettTotal();
        }  
        System.out.println("Fin de Fibonacci Iterativo");
        return tiempos;
    }
    
    public long gettFinal() 
    {
        return tFinal;
    }
     public long gettInicio() 
    {
        return tInicio;
    }

    public long gettTotal() 
    {
        return tTotal;
    }
}
