/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedas;

/**
 *
 * @author working
 */
public class Busquedas {
    
    
    public static int[] busquedaLineal(int[][] datos, int x, boolean resultado)
    {
        int[] pos = new int[2];
        
        for(int y = 0; y<datos.length; y++)
        {
            for(int n =0; n<datos.length; n++)
            {
                if(datos[y][n] == x)
                {
                    pos[0] = y;
                    pos[1] = n;
                    mostrarArray(resultado,pos);
                    return pos;
                }
            }
            
        }
        
        pos[0] = -1;
        pos[1] = -1;
        
        mostrarArray(resultado,pos);
        return pos;
    }
    
    public static void mostrarArray(boolean resultado,int[] pos)
    {
        if(resultado == true)
        {
            System.out.println("----------------------------------------------------"); 
            if(pos[0] != -1)
            {
               System.out.println("La posision del numero es: "+pos[0]+","+ pos[1]); 
            }
            else
            {
                System.out.println("No se encuentra en el arreglo");
            }
        }
    }
    
    
    
    //Array ********************************************************************************************************************************************
    public static int busquedaLineal (int[] datos, int x,boolean mostrarResultado){
        
        int pos = -1;
        for(int y = 0; y<datos.length; y++)
        {
            if(datos[y] == x)
            {
                pos = y;
                MostrarArray(mostrarResultado,pos);
                return pos;
            }
        }
        
        MostrarArray(mostrarResultado,pos);
        return pos;
    }
    
    public static void MostrarArray(boolean mostrarResultado,int pos)
    {
        if(mostrarResultado == true)
        {
            System.out.println("----------------------------------------------------"); 
            if(pos != -1)
            {
               System.out.println("La posision del numero es: "+pos); 
            }
            else
            {
                System.out.println("No se encuentra en el arreglo");
            }
        }
    }
    
}
