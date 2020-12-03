/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochila;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author chiky
 */
public class Mochila {
    ArrayList<Articulo> articulosPropuestos;
    ArrayList<Articulo> articulosPropuestosPeso;
    ArrayList<Articulo> articulosPropuestosValor;
    
    public Mochila() 
    {
        articulosPropuestos = LeerDatos.tokenizarDataSet();
        organizarArticulos();
    }
    
    public void agregarArticulos(int tamañoMochila)
    {
        ArrayList<Articulo> articulosDentro = new ArrayList<>();
    }
    
    public void organizarArticulos()
    {
        articulosPropuestosPeso = (ArrayList<Articulo>) articulosPropuestos.clone();
        articulosPropuestosValor = (ArrayList<Articulo>) articulosPropuestos.clone();
        
        quicksortValor(articulosPropuestosValor,0,articulosPropuestosValor.size()-1);
        quicksortPeso(articulosPropuestosPeso,0,articulosPropuestosPeso.size()-1);
    }
    
    static void quicksortValor(ArrayList<Articulo> arreglo,int primero,int ultimo)
    {
        int central,i,j;
        int pivote;
        central = (primero + ultimo) / 2;
        pivote=arreglo.get(central).valor;
        i=primero;
        j=ultimo;
        
        do
        {
          while(arreglo.get(i).valor  < pivote) i++;
          {
              while(arreglo.get(j).valor > pivote) j--;
              {
                if(i<=j)
                {
                    Articulo temp;
                    temp=arreglo.get(i);
                    arreglo.set(i, arreglo.get(j));
                    arreglo.set(j, temp);
                    i++;
                    j--;
                } 
              }
          }
        }
        while(i<=j);
        {
            if(primero<j)
            {
                quicksortValor(arreglo,primero,j); /*mismo proceso con sublista izquierda*/
            }
            if(i<ultimo)
            {
                quicksortValor(arreglo,i,ultimo); /*mismo proceso con sublista derecha*/
            }
        }
    }
    
    static void quicksortPeso(ArrayList<Articulo> arreglo,int primero,int ultimo)
    {
        int central,i,j;
        int pivote;
        central = (primero + ultimo) / 2;
        pivote=arreglo.get(central).peso;
        i=primero;
        j=ultimo;
        
        do
        {
          while(arreglo.get(i).peso  < pivote) i++;
          {
              while(arreglo.get(j).peso > pivote) j--;
              {
                if(i<=j)
                {
                    Articulo temp;
                    temp=arreglo.get(i);
                    arreglo.set(i, arreglo.get(j));
                    arreglo.set(j, temp);
                    i++;
                    j--;
                } 
              }
          }
        }
        while(i<=j);
        {
            if(primero<j)
            {
                quicksortPeso(arreglo,primero,j); /*mismo proceso con sublista izquierda*/
            }
            if(i<ultimo)
            {
                quicksortPeso(arreglo,i,ultimo); /*mismo proceso con sublista derecha*/
            }
        }
    }
    
    public void generarTablas(int tabla)
    {
        switch (tabla)
        {
            case 1:
            {
                generarTabla(articulosPropuestos,"articulosPropuestos");
                break;
            }
            case 2:
            {
                generarTabla(articulosPropuestosPeso,"articulosPropuestosPeso");
                break;
            }
            case 3:
            {
                generarTabla(articulosPropuestosValor,"articulosPropuestosValor");
                break;
            }
            default:
            {
                generarTabla(articulosPropuestos,"articulosPropuestos");
                generarTabla(articulosPropuestosPeso,"articulosPropuestosPeso");
                generarTabla(articulosPropuestosValor,"articulosPropuestosValor");
                break;
            }
        }
    }
    
    public void generarTabla(ArrayList<Articulo> articulos, String metodo)
    {
        String[][] clases = new String[articulos.size()][3];
        String[] cabezera = new String[3];
        
        for(int x = 0; x < articulos.size(); x++)
        {
            clases[x][0] = String.valueOf(articulos.get(x).index);
            clases[x][1] = String.valueOf(articulos.get(x).peso);
            clases[x][2] = String.valueOf(articulos.get(x).valor);
        }
        
        DefaultTableModel mod = new DefaultTableModel(clases,cabezera);

        JTable tabla = new JTable(mod);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(50,50,400,200);

        JFrame ventana = new JFrame();
        ventana.setLayout(null);
        ventana.setSize(500, 500);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Metodo: "+metodo);

        ventana.add(scroll);
        ventana.setVisible(true);
    }
}
