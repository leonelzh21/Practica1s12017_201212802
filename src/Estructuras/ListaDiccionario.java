/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

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
    //variable para graficar la lista que contendran los nodos y las relaciones
    public String nodos;
    public String relacion;
    
    public ListaDiccionario(){
        inicio = null;
        fin = null;
        nodos = "";
        relacion = "";
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
    
    //este metodo se encarga de recorrer la lista
    public void buscarPalabra(){
        //aqui indicamos que estamos en el inicio de la lista
        NodoDiccionario temp = inicio;
        //aqui recomrremos la lista valor por valor
        while(temp != null){
            System.out .println(temp.palabra);
            temp = temp .siguiente;
        }
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
                    relacion +=  "\"" +temp.palabra+ "\"" +"-->"+"\""+temp.siguiente.palabra+"\""+"\n";
                }
                temp = temp.siguiente;
            }
            textographics = "dgraph G" +"{"+"\n"+ nodos+relacion+"}";
            JOptionPane.showMessageDialog(null, textographics);
            ruta = "C:\\Users\\Alejandro\\Documents\\NetBeansProjects\\Edd_Scrabble\\src\\Estructuras\\listadiccionario.dot";
            
            File archivo = new File(ruta);
            BufferedWriter escribir;
            try {
                if ( archivo.exists()){
                    FileWriter escritor = new FileWriter(archivo);
                    escribir = new BufferedWriter(escritor);
                    escribir.write(textographics);
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
        imagenDiccionario(ruta, "C:\\Users\\Alejandro\\Documents\\NetBeansProjects\\Edd_Scrabble\\src\\Imagenes\\listaDiccionario.jpg");
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
