/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import edd_scrabble.Tablero;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class ListaDiccionario {
    
    public NodoDiccionario inicio;
    public NodoDiccionario fin;
    public int id;
    NodoDiccionario tempo;
    //variable para graficar la lista que contendran los nodos y las relaciones
    public String nodos;
    public String relacion;
    
    public ListaDiccionario(){
        inicio = null;
        fin = null;
        nodos = "";
        relacion = "";
        id = 1;
    }
    
    //este metodo inserta las palabras al diccionario hasta el final
    public void insertarPalabrafinal(String palabra){
        NodoDiccionario nuevo = new NodoDiccionario(palabra, null);
        
        //aqui se verifica que la lista no este vacia y se craa su primer elemento
        if(inicio == null){
            fin = nuevo;
            inicio = fin;
            
        //aqui si no esta vacia la lista agragamos el nuevo nodo hasta el final
        }else{
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }
    
    public void insertarfichas(String ficha){
        NodoDiccionario nuevo = new NodoDiccionario(ficha, null,id);
        id++;
        
        //aqui se verifica que la lista no este vacia y se craa su primer elemento
        if(inicio == null){
            fin = nuevo;
            inicio = fin;
            
        //aqui si no esta vacia la lista agragamos el nuevo nodo hasta el final
        }else{
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }
    
    //este metodo se encarga de recorrer la lista
    public String buscarPalabra(int i){
        //aqui indicamos que estamos en el inicio de la lista
        String letra = "";
        if (i == 0){
            tempo = inicio;
            letra = tempo.palabra;
            tempo = tempo.siguiente;
            return letra;
        }else{
            letra = tempo.palabra;
            tempo = tempo.siguiente;
            return letra;
        }
        //aqui recomrremos la lista valor por valor
        
    }
    
    //este metodo extrae el valor inicial de la lista como si fuera una cola
    public String extraerInicio(){
        String letra = inicio.palabra;
        inicio = inicio.siguiente;
        if(inicio == null){
            fin = null;
        }
        return letra;
    }
    
    //este metodo grafica la lista que contiene el diccionario de palabras
    public void graficarDiccionario(){
        String textographics ="";
        String ruta="";
        //solo grafica si la lista no esta vacia
        if (inicio != null){
            NodoDiccionario temp = inicio ;
            temp.palabra = inicio.palabra;
            while(temp != null){
                //aqui creamos los nodos
                nodos += temp.palabra +"\n";
                if(temp.siguiente != null){
                    //aqui creamos las relaciones
                    relacion +=  "\"" +temp.palabra+ "\"" +"--"+"\""+temp.siguiente.palabra+"\""+"\n";
                }
                temp = temp.siguiente;
            }
            textographics = "graph G" +"{"+"\n"+ nodos+relacion+"}";
            JOptionPane.showMessageDialog(null, textographics);
            ruta = "C:\\Users\\Leonel\\Documents\\NetBeansProjects\\Edd_Scrabble\\src\\Documentos\\Lista.dot";
            
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
                }
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(ListaDiccionario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex, "nose pudo hacer el archivo", 0);
            }
        }
        imagenDiccionario(ruta, "C:\\Users\\Leonel\\Documents\\NetBeansProjects\\Edd_Scrabble\\src\\Imagenes\\Lista.jpg");
    }
    
    public void graficarf(){
        String textographics ="";
        String ruta="";
        //solo grafica si la lista no esta vacia
        if (inicio != null){
            NodoDiccionario temp = inicio ;
            temp.palabra = inicio.palabra;
            while(temp != null){
                //aqui creamos los nodos
                nodos += temp.palabra+temp.id +"\n";
                if(temp.siguiente != null){
                    //aqui creamos las relaciones
                    relacion +=  "\"" +temp.palabra+temp.id+ "\"" +"--"+"\""+temp.siguiente.palabra+temp.siguiente.id+"\""+"\n";
                }
                temp = temp.siguiente;
            }
            textographics = "graph G" +"{"+"\n"+ nodos+relacion+"}";
            JOptionPane.showMessageDialog(null, textographics);
            ruta = "C:\\Users\\Leonel\\Documents\\NetBeansProjects\\Edd_Scrabble\\src\\Documentos\\Lista.dot";
            
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
                }
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(ListaDiccionario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex, "nose pudo hacer el archivo", 0);
            }
        }
        imagenDiccionario(ruta, "src\\Imagenes\\Lista.jpg");
        
    }
    
    //crea la imagen de la lista de palabras
    public void imagenDiccionario(String contenido, String ruta){
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
