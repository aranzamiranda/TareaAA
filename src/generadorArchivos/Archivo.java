/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorArchivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author peper
 */
public class Archivo 
{
    int limP;
    int limB;
    int numRegistros;

    public Archivo(int limP, int limB, int numRegistros) 
    {
        this.limP = limP;
        this.limB = limB;
        this.numRegistros = numRegistros;
    }
    
    public String generarArchivo() throws IOException
    {
        Random r = new Random();
        String ruta = "src/generadorArchivos/Archivos/"+limP+"_"+limB+"-"+numRegistros+".txt";
        File archivo = new File(ruta);
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        int auxP = 0;
        int auxB = 0;
            
        for(int x = 0; x< numRegistros; x++)
        {
            auxP = r.nextInt(limP)+1;
            auxB = r.nextInt(limB)+1;
            bw.write(auxP+","+auxB);
            
            if(x != numRegistros-1)
            {
                bw.newLine();
            }
        }
        
        bw.close();
        
        return ruta.substring(31,ruta.length());
    }
}
