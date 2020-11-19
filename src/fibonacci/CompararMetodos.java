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
public class CompararMetodos {
    double[] tiemposFI;
    double[] tiemposFR;
    double[] tiemposFID;
    double[] tiemposFRD;
    
    public CompararMetodos(int n, boolean graficsIndividuales, boolean grafica, int[] metodos) 
    {
        if(metodos[0] == 1)
        {
            FibonacciIterativo fi = new FibonacciIterativo();
            tiemposFI = fi.codigoTiempos(n);
        }
        
        if(metodos[1] == 1)
        {
            FibonacciRecursivo fr = new FibonacciRecursivo();
            tiemposFR = fr.codigoTiempos(n);
        }
        
        if(metodos[2] == 1)
        {
            FibonacciIterativoDinamico fid = new FibonacciIterativoDinamico();
            tiemposFID = fid.codigoTiempos(n);
        }
        
        if(metodos[3] == 1)
        {
            FibonacciRecursivoDinamico frd = new FibonacciRecursivoDinamico();
            tiemposFRD = frd.codigoTiempos(n);
        }
        
        if(graficsIndividuales == true)
        {
            graficasIndividuales(metodos);
        }
        
        if(grafica == true)
        {
            grafica(metodos);
        }
    }
    
    public void graficasIndividuales(int[] metodos)
    {
        if(metodos[0] == 1)
        {
            graficaIndividual("FibonacciIterativo",tiemposFI);
        }
        
        if(metodos[1] == 1)
        {
            graficaIndividual("FibonacciRecursivo", tiemposFR);
        }
        
        if(metodos[2] == 1)
        {
            graficaIndividual("FibonacciIterativoDinamico",tiemposFID);
        }
        
        if(metodos[3] == 1)
        {
            graficaIndividual("FibonacciRecursivoDinamico",tiemposFRD);
        }
    }
    
    public void graficaIndividual(String nombre ,double[] tiempos)
    {
        Grafica g1 = new Grafica("N","Tiempo","Tiempos");
        g1.agregarSerie(nombre,tiempos);
        g1.crearGrafica();
        System.out.println();
        g1.muestraGrafica();
    }
    
    public void grafica(int[] metodos)
    {
        Grafica g1 = new Grafica("N","Tiempo","Tiempos");
        
        if(metodos[0] == 1)
        {
            g1.agregarSerie("FibonacciIterativo",tiemposFI);
        }

        if(metodos[1] == 1)
        {
            g1.agregarSerie("FibonacciRecursivo", tiemposFR);
        }

        if(metodos[2] == 1)
        {
            g1.agregarSerie("FibonacciIterativoDinamico",tiemposFID);
        }

        if(metodos[3] == 1)
        {
            g1.agregarSerie("FibonacciRecursivoDinamico",tiemposFRD);
        }
            
        g1.crearGrafica();
        System.out.println();
        g1.muestraGrafica();
    }
}
