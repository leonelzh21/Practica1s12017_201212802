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
public class ListaCusuarios {
    
    //variables para los nodos de la lista circular
    public NodoCusuarios inicio;
    public NodoCusuarios fin;
    
    //variables para la grafica de la lista circular
    public String nodos;
    public String relacion;
    
    public ListaCusuarios(){
        inicio = null;
        fin = null;
        nodos = "";
        relacion = "";
    }
    
    //este metodo va agrega los nombres al final de la lista circular de usuarios
    public void insertarNombre(String nombre){
        NodoCusuarios nuevo = new NodoCusuarios(nombre,null);//recprdar que tienen que ser tres atributos porque tiene que tenes una lista de fichas como parametro
        
        //reviasa que lal ista no este vacia 
        if(inicio == null){
            inicio = nuevo;
            fin = nuevo;
            fin.siguiente = inicio;
        }else{
            //aqui hacemos que el el apuntador del ultimo nodo apunte el nuevo
            fin.siguiente = nuevo;
            //aqui hacemos que el apuntador del nuevo nodo apunte a el inicio
            nuevo.siguiente = inicio;
            //aqui hacemos que el final sea el nuevo nodo
            fin = nuevo;    
        }
    }
    
    
    public void buscarNombre(){
        
        NodoCusuarios temp = inicio;        
        do{
            System.out.println(temp.nombre);
            temp = temp.siguiente;
        }while(temp != inicio);
    }
    
    public void graficarUsuarios(){
        String textographics = "";
        String rutausuarios = "";
        
        if(inicio != null){
            NodoCusuarios temp = inicio;
            do{
                nodos += temp.nombre +"\n";
                relacion +=  "\"" +temp.nombre+ "\"" +"--"+"\""+temp.siguiente.nombre+"\""+"\n";
                temp = temp.siguiente;
            }while(temp != inicio);
            textographics = "graph G" +"{"+"\n"+ nodos+relacion+"}";
            JOptionPane.showMessageDialog(null, textographics);
            rutausuarios = "C:\\Users\\Alejandro\\Documents\\NetBeansProjects\\Edd_Scrabble\\src\\Estructuras\\listausuarios.dot";
            
            File archivo = new File(rutausuarios);
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
        imagenUsuarios(rutausuarios, "C:\\Users\\Alejandro\\Documents\\NetBeansProjects\\Edd_Scrabble\\src\\Imagenes\\listausuarios.jpg");
    }
    
    public void imagenUsuarios(String contenido, String ruta){
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