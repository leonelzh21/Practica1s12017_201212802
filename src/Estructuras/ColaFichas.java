/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class ColaFichas {
    
    public NodoFichas inicio;
    public NodoFichas fin;
    public int id;
    public String nodos;
    public String relacion;
  
    public ColaFichas(){
        inicio = null;
        fin = null;
        nodos= "";
        relacion = "";
        id = 1;
    }
    
    public void insertarFichasfinal(String ficha){
        NodoFichas nuevo = new NodoFichas(ficha, null,id);
        id++;
        //aqui se verifica que la cola no este vacia y se craa su primer elemento
        if(inicio == null){
            fin = nuevo;
            inicio = fin;
            
        //aqui si no esta vacia la cola agragamos el nuevo nodo hasta el final
        }else{
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }
    
    //este metodo se encarga de recorrer la lista
    public void buscarFichas(){
        //aqui indicamos que estamos en el inicio de la cola
        NodoFichas temp = inicio;
        //aqui recomrremos la lista valor por valor
        while(temp != null){
            System.out .println(temp.ficha);
            temp = temp .siguiente;
        }
    }
    
    //este metodo extrae el valor inicial de la cola como 
    public String extraerInicio(){
        String letra = inicio.ficha;
        inicio = inicio.siguiente;
        if(inicio == null){
            fin = null;
        }
        return letra;
    }
    
    
    public void graficasFichas(){
        String textographics ="";
        String ruta="";
        //solo grafica si la lista no esta vacia
        if (inicio != null){
            NodoFichas temp = inicio ;
            temp.ficha = inicio.ficha;
            while(temp != null){
                //aqui creamos los nodos
                nodos += temp.ficha+temp.id +";"+"\n";
                if(temp.siguiente != null){
                    //aqui creamos las relaciones
                    relacion +=  temp.ficha+temp.id +"--"+temp.siguiente.ficha+temp.siguiente.id+";"+"\n";
                }
                temp = temp.siguiente;
            }
            textographics = "graph G" +"{"+"\n"+ nodos+relacion+"}";
            //JOptionPane.showMessageDialog(null, textographics);
            ruta = "C:\\Users\\Leonel\\Documents\\NetBeansProjects\\Edd_Scrabble\\src\\Documentos\\fichas.dot";
            
            File archivo = new File(ruta);
            BufferedWriter escribir;
            try {
                if ( archivo.exists()){
                    FileWriter escritor = new FileWriter(archivo);
                    escribir = new BufferedWriter(escritor);
                    escribir.write(textographics);
                    nodos = "";
                    relacion = "";
                }else{
                    FileWriter escritor = new FileWriter(archivo);
                    escribir = new BufferedWriter(escritor);
                    escribir.write(textographics);
                    textographics = "";
                }
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(ListaDiccionario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex, "nose pudo hacer el archivo", 0);
            }
        }
        imagenFichas(ruta, "C:\\Users\\Leonel\\Documents\\NetBeansProjects\\Edd_Scrabble\\src\\Imagenes\\fichas.jpg");
    }
    
    
    public void imagenFichas(String contenido, String ruta){
        String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
        String fileInputPath = contenido;
        String fileOutputPath = ruta;
      
        String tParam = "-Tjpg";
        String tOParam = "-o";
        
        String[] cmd = new String[5];
        cmd[0] = dotPath;
        cmd[1] = tParam;
        cmd[2] = fileInputPath;
        cmd[3] = tOParam;
        cmd[4] = fileOutputPath;
                  
        Runtime rt = Runtime.getRuntime();
      
        try {
            rt.exec( cmd );
        } catch (IOException ex) {
            Logger.getLogger(ListaDiccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
