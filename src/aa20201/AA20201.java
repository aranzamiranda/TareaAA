/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa20201;
import aa20201.data.Grafica;
import busquedas.BusquedaSecuencial;
import busquedas.GeneradorDatos;
import busquedas.Busquedas;
import ordenamiento.Burbuja;
/**
 *
 * @author chiky
 */
public class AA20201 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     int y = 1;
        switch(y)
        {
            case 0:
            {
                int n = 10000;
                int[] aux;
                double[] tiempos = new double[n];
                Burbuja burbuja = new Burbuja();
                // complejidad algoritmica sumatoria
                for (int j = 0; j < n; j++){
                    aux = GeneradorDatos.generarArregloInt(j,1000,false);
                    burbuja.ordenar(aux,1);
                    tiempos[j] = (int) burbuja.gettTotal();
                }  

                Grafica graf1 = new Grafica("N","Tiempo","Tiempos");
                graf1.agregarSerie("t1",tiempos);
                graf1.crearGrafica();
                graf1.muestraGrafica();
            }
            case 1:
            {
                int n = 5000;
                int[] auxiliar;
                double[] tiempos = new double[n];
                Burbuja b = new Burbuja();
                
                for (int j = 0; j < n; j++)
                {
                    auxiliar = GeneradorDatos.generarArregloIntOrga(j+1,10,4,false);
                    b.ordenar(auxiliar,1);
                    tiempos[j] = (int)b.gettTotal();
                }  
                
                Grafica g1 = new Grafica("N","Tiempo","Tiempos");
                g1.agregarSerie("t1",tiempos);
                g1.crearGrafica();
                g1.muestraGrafica();
                System.out.println();
            }
        }
    }
    
}
