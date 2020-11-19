/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author chiky
 */
import aa20201.data.Grafica;

public class FibonacciIterativoDinamico extends FibonacciIterativo
{
    public int[] serieFibonacci;
    
    public FibonacciIterativoDinamico() 
    {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0;
    }
    
    public int ejecutarFibonacciRecurcivoDinamico(int n)
    {
        this.tInicio = System.currentTimeMillis();
        int v=0;
        
        serieFibonacci = new int[n];
        for(int x = 0; x<serieFibonacci.length; x++)
        {
            serieFibonacci[x] = -1;
        }
        
        serieFibonacci[0] = 0;
        if(n>1)
        {
            serieFibonacci[1] = 1;
        }
        
        v = FibonacciRecurcivoDinamico(n);
        this.tFinal = System.currentTimeMillis();//+1
        this.tTotal = this.tFinal - this.tInicio;
        return v;
    }
    
    public int FibonacciRecurcivoDinamico(int x)
    {
        int num1 = 0, num2 = 1, suma = 1;
         
        for (int i = 1; i < x; i++) 
        {
            if(serieFibonacci[i] == 0)
            {
                suma = num1 + num2;
                num1 = num2;
                num2 = suma;
            }
            else
            {
                suma = serieFibonacci[i];
            }  
        }
        return suma;
    }
    
    public void codigoGrafica(int n)
    {
        System.out.println("Fibonacci Interactivo Dinamico");
        int valor;
        double[] tiempos = new double[n];
        FibonacciRecursivoDinamico I = new FibonacciRecursivoDinamico();
        for (int j = 0; j < n; j++)
        {
            valor = I.ejecutarFibonacciRecurcivoDinamico(n);
            tiempos[j] = (int)I.gettTotal();
        }  

        Grafica g1 = new Grafica("N","Tiempo","Tiempos");
        g1.agregarSerie("t1",tiempos);
        g1.crearGrafica();
        System.out.println();
        g1.muestraGrafica();
    }
    
    public double[] codigoTiempos(int n)
    {
        System.out.println("Fibonacci Interactivo Dinamico");
        int aux;
        double[] tiempos = new double[n];
        FibonacciRecursivoDinamico I = new FibonacciRecursivoDinamico();

        for (int j = 0; j < n; j++)
        {
            aux = I.ejecutarFibonacciRecurcivoDinamico(n);
            tiempos[j] = (int)I.gettTotal();
        }  
        System.out.println("Fin de Fibonacci Recursivo Dinamico");
        return tiempos;
    }
}
