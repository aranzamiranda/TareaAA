/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochila;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.Color;
/**
 *
 * @author chiky
 */
public class Mochila {
    //Todos los arraylist de los articulos
    ArrayList<Articulo> articulos;
    ArrayList<Articulo> articulosPeso;
    ArrayList<Articulo> articulosIndice;
    ArrayList<Articulo> articulosValor;
    
    public Mochila() 
    {
        articulos = LeerDatos.tokenizarDataSet();
        organizar();
    }

    public void addPeso(int tamañoMochila)
    {
        ArrayList<Articulo> mochila = new ArrayList<>();
        boolean ult = false;
        int peso = 0;
        int valor = 0;
        int cont = 0;
        do
        {
            if((peso + articulosPeso.get(cont).peso) <= tamañoMochila)
            {
                while(articulosPeso.get(cont).peso == articulosPeso.get(cont+1).peso)
                {
                    if((peso + articulosPeso.get(cont).peso) <= tamañoMochila)
                    {
                        mochila.add(articulosPeso.get(cont));
                        valor = valor + articulosPeso.get(cont).valor;
                        peso = peso + articulosPeso.get(cont).peso;
                        cont++;
                    }
                }
            
                if(articulosIndice.get(peso + articulosPeso.get(cont).peso).valor < valor)
                {
                    mochila.add(articulosPeso.get(cont));
                    peso = peso + articulosPeso.get(cont).peso;
                    valor = valor + articulosPeso.get(cont).valor;
                    cont++;
                }
                else
                {
                    mochila.clear();
                    mochila.add(articulosIndice.get(peso + articulosPeso.get(cont).peso));
                    peso = mochila.get(mochila.size()-1).peso;
                    valor = mochila.get(mochila.size()-1).valor;
                    cont++;
                }
                
            }
            else
            {
                ult = true;
            }
        }
        while(peso <= tamañoMochila);{
            while(ult == false);{
            generarTabla(mochila, "mochila");
            }
        }
    }
    
    public void organizar(){
        articulosIndice = new ArrayList<>();
        articulosPeso = (ArrayList<Articulo>) articulos.clone();
        articulosValor = (ArrayList<Articulo>) articulos.clone();
        
        quicksortValor(articulosValor,0,articulosValor.size()-1);
        quicksortPeso(articulosPeso,0,articulosPeso.size()-1);
        
        for(int x = 0; x < articulosPeso.get(articulosPeso.size()-1).peso; x++){
            articulosIndice.add(new Articulo(0, 0, 0));
        }
        articulosIndice.add(new Articulo(0, 0, 0));
        
        for(int x = 0; x < articulosPeso.size(); x++){
            if(articulosIndice.get(articulosPeso.get(x).peso).valor < articulosPeso.get(x).valor){
                articulosIndice.set(articulosPeso.get(x).peso, articulosPeso.get(x));
            }    
        }
    }
    static void quicksortValor(ArrayList<Articulo> array,int uno,int finale){
        int medio,i,j, p;
        medio = (uno + finale) / 2;//en medio
        p=array.get(medio).valor;
        i=uno;
        j=finale;
        
        do{
          while(array.get(i).valor  < p) i++;{
              while(array.get(j).valor > p) j--;{
                if(i<=j){
                    Articulo temp;
                    temp=array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, temp);
                    i++;
                    j--;
                } 
              }
          }
        }
        while(i<=j);{
            if(uno<j){
                quicksortValor(array,uno,j); //Proceso con la lista de izquierda
            }
            if(i<finale){
                quicksortValor(array,i,finale); //Proceso con la lista de derecha
            }
        }
    }
    public void addValor(int sMochila)
    {
        ArrayList<Articulo> mochila = new ArrayList<>();
        int sumPeso = 0;
        int sumValor = 0;
        int cont = articulosValor.size()-1;
        do{
            if((sumPeso + articulosValor.get(cont).peso) <= sMochila) //Si el peso de los articulos es menor que el tamaño de la mochila
            {
                mochila.add(articulosValor.get(cont));
                sumPeso = sumPeso + articulosValor.get(cont).peso;
                sumValor = sumValor + articulosValor.get(cont).valor; 
            }
            cont--;
        }
        while(cont != 0);
        {
            generarTabla(mochila, "mochila");
        }
    }
    static void quicksortPeso(ArrayList<Articulo> array,int uno,int finale)
    {
        int medio,i,j;
        int pivote;
        medio = (uno + finale) / 2;
        pivote=array.get(medio).peso;
        i= uno;
        j= finale;
        
        do{
          while(array.get(i).peso  < pivote) i++;{
              while(array.get(j).peso > pivote) j--;{
                if(i<=j){
                    Articulo temp;
                    temp=array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, temp);
                    i++;
                    j--;
                } 
              }
          }
        }
        while(i<=j);
        {
            if(uno<j)
            {
                quicksortPeso(array,uno,j); /*mismo proceso con sublista izquierda*/
            }
            if(i<finale)
            {
                quicksortPeso(array,i,finale); /*mismo proceso con sublista derecha*/
            }
        }
    }
    
    public void tablas(int tabla)
    {
        switch (tabla)
        {
            case 0:
            {
                break;
            }
            case 1:
            {
                generarTabla(articulos,"Articulos propuestos");
                break;
            }
            case 2:
            {
                generarTabla(articulosPeso,"Articulos propuestos por peso");
                break;
            }
            case 3:
            {
                generarTabla(articulosIndice,"Articulos propuestos indice");
                break;
            }
            case 4:
            {
                generarTabla(articulosValor,"Articulos propuestos valor");
                break;
            }
            default:
            {
                generarTabla(articulos,"Articulos propuestos");
                generarTabla(articulosPeso,"Articulos propuestos por peso");
                generarTabla(articulosValor,"Articulos propuestos valor");
                generarTabla(articulosIndice,"Articulos propuestos indice");
                break;
            }
        }
    }
    
    public void generarTabla(ArrayList<Articulo> elementos, String metodo)//Funcion que genera la tabla con los datos
    {
        String[][] clas = new String[elementos.size()][3];
        String[] head = new String[3];
        
        for(int x = 0; x < elementos.size(); x++)
        {
            clas[x][1] = String.valueOf(elementos.get(x).peso);
            clas[x][2] = String.valueOf(elementos.get(x).valor);
        }
        
        DefaultTableModel mode = new DefaultTableModel(clas, head);

        JTable tabla = new JTable(mode);
           
        JScrollPane window2 = new JScrollPane(tabla);//Para contener los elementos en una barra deslizable
        window2.setBounds(50,50,300,200);
        window2.setBackground(Color.DARK_GRAY);
        
           
        JFrame window1 = new JFrame();
        window1.setLayout(null);
        window1.setSize(500, 500);
        window1.setBackground(Color.PINK);
       window1.setLocationRelativeTo(null);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window1.setTitle("Metodo: "+metodo);

        window1.add(window2);
        window1.setVisible(true);
    }
    
    public void funcion(int m, int sMochila, int table){
        switch (m){
            case 1:{
                addPeso(sMochila);
            }
            case 2:{
                addValor(sMochila);
            }
        }
      tablas(table);
    }
}
