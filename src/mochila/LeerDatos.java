/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochila;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author chiky
 */
public class LeerDatos {
    public static ArrayList<Articulo> tokenizarDataSet(){
     ArrayList<Articulo> ins = new ArrayList<>();
     String text, aux1;
     LinkedList<String> list = new LinkedList();
        
        try {//cargamos la ventada
            JFileChooser ar = new JFileChooser();
            ar.setCurrentDirectory(new File("./"));
            ar.showOpenDialog(ar);
            //abrimos el archivo seleccionado
            File abre = ar.getSelectedFile();

            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader read = new BufferedReader(archivos);

                while ((aux1 = read.readLine()) != null){ //se lee el archivo
                    text = aux1;
                    list.add(text);
                }
                read.close();

                ArrayList<String> list2 = new ArrayList<>();
               
                for (int i = 0; i < list.size(); i++) //Se recorre el archivo
                {
                    StringTokenizer st = new StringTokenizer(list.get(i), ",");

                    while (st.hasMoreTokens()) //Se chequea si hay mas tokens en el array
                    {
                        list2.add(st.nextToken());//Pasa al siguiente
                    }
                    
                    ins.add(new Articulo(i,Integer.parseInt(list2.get(0)),Integer.parseInt(list2.get(1))));    
                    list2.clear();

                }
          
            }
        } 
        catch (IOException a) 
        {
            JOptionPane.showMessageDialog(null, a + ""+ "\n no se encontro", "error", JOptionPane.WARNING_MESSAGE);//Si hay un error, abre un panel con mensaje de advertencia
        }
        return ins;
    }
}
