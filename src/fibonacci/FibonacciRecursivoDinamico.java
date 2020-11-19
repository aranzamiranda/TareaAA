/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import aa20201.data.Grafica;

/**
 *
 * @author chiky
 */
public class FibonacciRecursivoDinamico extends FibonacciRecursivo
{
    public int[] serieFibonacci;
    
    public FibonacciRecursivoDinamico()
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
    
    public int FibonacciRecurcivoDinamico(int n)
    {
        int desN1 = 0;
        int desN2 = 0;
        
        if(n == 0)
        {
            return 0;
        }
        else if(n == 1)
        {
            return 1;
        }
        else
        {
            if(serieFibonacci[n-1] != -1)
            {
                desN1 = serieFibonacci[n-1];
            }
            else
            {
                desN1 = FibonacciRecurcivoDinamico(n-1);
                serieFibonacci[n-1] = desN1;
            }

            if(serieFibonacci[n-2] != -1)
            {
                desN2 = serieFibonacci[n-2];
            }
            else
            {
                desN2 = FibonacciRecurcivoDinamico(n-2);
                serieFibonacci[n-2] = desN2;
            }
            return desN1 + desN2;
        }
    }
    
    public void codigoGrafica(int n)
    {
        System.out.println("Fibonacci Recursivo Dinamico");
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
        System.out.println("Fibonacci Recursivo Dinamico");
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