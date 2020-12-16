/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablero;

/**
 *
 * @author chiky
 */
public class Posicion {
    int i;
    int j;
    int posibilidad;

    public Posicion(int i, int j, int posibilidad) 
    {
        this.i = i;
        this.j = j;
        this.posibilidad = posibilidad;
    }
    
    public Posicion() 
    {
        this.i = 0;
        this.j = 0;
        this.posibilidad = 0;
    }
}
