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
public class Casilla 
{
    int[] pos;
    int numberPos;
    int check;

    public Casilla(int[] pos, int numberPos, int check) 
    {
        this.pos = pos;
        this.numberPos = numberPos;
        this.check = check;
    }
}
