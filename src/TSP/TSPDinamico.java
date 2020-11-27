/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import java.util.ArrayList;

/**
 *
 * @author chiky
 */
public class TSPDinamico {
    
    final private Double acceso_distancias[][];
    public ArrayList<Double> distancias;

    public TSPDinamico(Ciudad ciudades[]) {
        this.distancias = new ArrayList<>();
        this.acceso_distancias = new Double[ciudades.length + 1][ciudades.length + 1];
    }
    
    public double recorrerCaminos(Ciudad raiz,Ciudad[] hijos,Ciudad inicio,double distanciaRecorrida){
        if(hijos.length > 1){
            for(int i=0;i<hijos.length;i++){
                //Creamos los nuevos hijos
                
                Ciudad[] nuevosHijos = new Ciudad[hijos.length - 1];
                int posicion = 0;
                for(int j=0;j<hijos.length;j++){
                    if(hijos[i] != hijos[j]){
                        nuevosHijos[posicion] = hijos[j];
                        posicion++;
                    }
                }
                double resultado = 0;
                //Obtenemos la distancia entre el nodo raiz y el siguiente y le sumamos
                //la distancia que llevamos recorrida hasta ahorita
                if(this.acceso_distancias[raiz.getId()][hijos[i].getId()] != null){
                   resultado = this.acceso_distancias[raiz.getId()][hijos[i].getId()];
                }else{
                   resultado = getDistancia(raiz.getPuntos(), hijos[i].getPuntos()) + distanciaRecorrida;
                   this.acceso_distancias[raiz.getId()][hijos[i].getId()] = resultado;
                   this.acceso_distancias[hijos[i].getId()][raiz.getId()] = resultado;
                } 
                //Hacemos recursividad para recorrer los demas caminos faltantes
                recorrerCaminos(hijos[i], nuevosHijos,inicio,resultado);
            }
        }else{
           double resultado = 0;
           //Obtenemos la distancia entre el ultimo nodo y el nodo anterior
           
           //Si la posicion en la tabla ya ha sido calculado, obtenemos ese dato de la tabla,
           //si no, calculamos la distancia y la guardamos en la tabla, y lo guardamos
           
            if(this.acceso_distancias[raiz.getId()][hijos[0].getId()] != null){
                resultado += this.acceso_distancias[raiz.getId()][hijos[0].getId()];
            }else{
                resultado += getDistancia(raiz.getPuntos(), hijos[0].getPuntos());
                this.acceso_distancias[raiz.getId()][hijos[0].getId()] = resultado;
                this.acceso_distancias[hijos[0].getId()][raiz.getId()] = resultado;
            }
            
            //Obtenemos la distancia entre el ultimo nodo y el inicio
            if(this.acceso_distancias[raiz.getId()][inicio.getId()] != null){
              resultado +=  this.acceso_distancias[raiz.getId()][hijos[0].getId()]; 
            }else{
              resultado += getDistancia(inicio.getPuntos(), hijos[0].getPuntos());
              this.acceso_distancias[raiz.getId()][inicio.getId()] = resultado;
              this.acceso_distancias[inicio.getId()][raiz.getId()] = resultado;
            }
           
           //Le sumamos la distancia que llevamos recorriendo
           resultado += distanciaRecorrida;
           //Agregamos a las distancias el valor de este camino
           this.distancias.add(resultado);
           return resultado;
        }
       return 0;   
    }
    
    private double getDistancia(PuntosXY punto1, PuntosXY punto2){
        double resultado = 0;
        
        resultado = Math.sqrt(Math.pow((punto2.getPunto_X() - punto1.getPunto_X()),2) + 
                              Math.pow((punto2.getPunto_Y() - punto1.getPunto_Y()),2));
        
        return resultado;
    }
    
}
