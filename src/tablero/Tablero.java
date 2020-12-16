/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablero;

import java.util.ArrayList;
import javax.swing.JFrame;


/**
 *
 * @author chiky
 */
public class Tablero 
{
    ArrayList<Integer[][]> tableros;
    Posicion pos;
    int n;
    int cont = 1;
    
    JFrame ventana = new JFrame();
    
    public int calcularPosibilidades()
    {
        Posicion[] posiciones = new Posicion[8];
        
        
        for(int x = 0; x<8; x++)
        {
            posiciones[x] = new Posicion();
            switch (x)
            {
                case 0:
                {
                    posiciones[0].i = pos.i - 2;
                    posiciones[0].j = pos.j - 1;
                    break;
                }
                case 1:
                {
                    posiciones[1].i = pos.i - 2;
                    posiciones[1].j = pos.j + 1;
                    break;
                }
                case 2:
                {
                    posiciones[2].i = pos.i - 1;
                    posiciones[2].j = pos.j + 2;
                    break;
                }
                case 3:
                {
                    posiciones[3].i = pos.i + 1;
                    posiciones[3].j = pos.j + 2;
                    break;
                }
                case 4:
                {
                    posiciones[4].i = pos.i + 2;
                    posiciones[4].j = pos.j + 1;
                    break;
                }
                case 5:
                {
                    posiciones[5].i = pos.i + 2;
                    posiciones[5].j = pos.j - 1;
                    break;
                }
                case 6:
                {
                    posiciones[6].i = pos.i + 1;
                    posiciones[6].j = pos.j - 2;
                    break;
                }
                case 7:
                {
                    posiciones[7].i = pos.i - 1;
                    posiciones[7].j = pos.j - 2;
                    break;
                }
            }
            
            if(
                    (posiciones[x].i >= 0 && posiciones[x].i<n) && 
                    (posiciones[x].j >= 0 && posiciones[x].j<n)) 
                    
            {
                calcularNumPosibilidades(posiciones[x]);
            }
            else
            {
                posiciones[x].posibilidad = -1;
            }
            System.err.println("");
        }
        
        ordenarPosiciones(posiciones);
        //Se compara si el numero de posibilidades es igual al segundo mas grande
        
        //Se selecciona la mejor posibilidad
        if(posiciones[0].posibilidad == -1)
        {
            pos.i = -1;
        }
        else
        {
         
        }
        
        return 1;
    }
    
    public void calcularNumPosibilidades(Posicion pos2)
    {
        int auxNumPosibilidades = 0;
        Posicion[] posiciones2 = new Posicion[8];
        
        for(int x = 0; x<8; x++)
        {
            posiciones2[x] = new Posicion();
            switch (x)
            {
                case 0:
                {
                    posiciones2[0].i = pos2.i - 2;
                    posiciones2[0].j = pos2.j - 1;
                    break;
                }
                case 1:
                {
                    posiciones2[1].i = pos2.i - 2;
                    posiciones2[1].j = pos2.j + 1;
                    break;
                }
                case 2:
                {
                    posiciones2[2].i = pos2.i - 1;
                    posiciones2[2].j = pos2.j + 2;
                    break;
                }
                case 3:
                {
                    posiciones2[3].i = pos2.i + 1;
                    posiciones2[3].j = pos2.j + 2;
                    break;
                }
                case 4:
                {
                    posiciones2[4].i = pos2.i + 2;
                    posiciones2[4].j = pos2.j + 1;
                    break;
                }
                case 5:
                {
                    posiciones2[5].i = pos2.i + 2;
                    posiciones2[5].j = pos2.j - 1;
                    break;
                }
                case 6:
                {
                    posiciones2[6].i = pos2.i + 1;
                    posiciones2[6].j = pos2.j - 2;
                    break;
                }
                case 7:
                {
                    posiciones2[7].i = pos2.i - 1;
                    posiciones2[7].j = pos2.j - 2;
                    break;
                }
            }
            if(
                (posiciones2[x].i >= 0 && posiciones2[x].i<n) && 
                (posiciones2[x].j >= 0 && posiciones2[x].j<n)
            )
            {         
                auxNumPosibilidades += 1;
            }
        }
        
        pos2.posibilidad = auxNumPosibilidades;
    }
    
    public void ordenarPosiciones(Posicion[] posiciones)
    {
        for(int e = 0; e < posiciones.length; e++)
        {
            for(int i = 0; i < posiciones.length - 1; i++)
            {
                for(int j = 0; j < posiciones.length - 1; j++)
                {
                    if (posiciones[j].posibilidad < posiciones[j + 1].posibilidad)
                    {
                        Posicion tmp = posiciones[j+1];
                        posiciones[j+1] = posiciones[j];
                        posiciones[j] = tmp;
                    }
                }
            }
            
        }
    }
    
 
}
