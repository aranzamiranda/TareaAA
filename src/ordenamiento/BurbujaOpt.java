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
public class BurbujaOpt {
    //variables para obtener tiempos
    public long tInicio;
    public long tFinal;
    public long tTotal;
    
    public BurbujaOpt() {
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

    private void ordenarDatos(int[] datos) {
       int aux = 0;
       boolean band = true;
       for (int i = 0; i<datos.length && band == true; i++){
           band = false;
           for(int j = 0; j<datos.length - 1; j++){             
               if(datos[j] > datos[j+1]){
                   band = true;
                   aux = datos[j];
                   datos[j] = datos[j+1];
                   datos[j+1] = aux;
               }
           }
       }
    }
}
