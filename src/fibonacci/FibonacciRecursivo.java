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
public class FibonacciRecursivo 
{
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public FibonacciRecursivo()
    {
        this.tFinal = 0;//+1
        this.tInicio = 0;//+1
        this.tTotal = 0 ;//+1
    }
    
    public static int fibonacciRecursivo(int n) 
    {
 
        //CASO BASE, si es cero devuelve un cero
        //Puedes poner n<=0 tamvien para incluir negativos
        if (n == 0) 
        {
            return 0;
            //CASO BASE, si es 1 devuelve un 1    
        } 
        else if (n == 1) 
        {
            return 1;
        } 
        else 
        {
            //Hago la suma
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
        }
 
    }
    
    public int ejecutarfibonacciRecursivo(int serie)
    {
        int result;
        this.tInicio = System.currentTimeMillis();         
        result =  fibonacciRecursivo(serie);
        this.tFinal = System.currentTimeMillis();//+1
        this.tTotal = this.tFinal - this.tInicio;
        return result;
    }
    
    public void codigoGrafica(int n)
    {
        int aux;
        double[] tiempos = new double[n];//+1
        FibonacciRecursivo I = new FibonacciRecursivo();//+1

        for (int j = 0; j < n; j++)
        {
            I.ejecutarfibonacciRecursivo(j);
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
        System.out.println("Fibonacci Recurcivo");
        int aux;
        double[] tiempos = new double[n];
        FibonacciRecursivo I = new FibonacciRecursivo();

        for (int j = 0; j < n; j++)
        {
            aux = I.ejecutarfibonacciRecursivo(n);
            tiempos[j] = (int)I.gettTotal();
        }  
        System.out.println("Fin de Fibonacci Recurcivo");
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
