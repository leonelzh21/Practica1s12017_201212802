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
public class ListaCusuarios {
    
    //variables para los nodos de la lista circular
    public NodoCusuarios inicio;
    public NodoCusuarios fin;
    public NodoCusuarios usuariotemporal;
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
    public void insertarNombre(String nombre, ListaDiccionario list){
        NodoCusuarios nuevo = new NodoCusuarios(nombre,null,list);//recprdar que tienen que ser tres atributos porque tiene que tenes una lista de fichas como parametro
        
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
    
    
    public boolean buscarNombre(String nombre){
        
        NodoCusuarios temp = inicio;
        if(temp != null){
            do{
                if(temp.nombre.equals(nombre)){
                    temp = inicio;
                    return true;
                }else{
                    return false;
                }
            }while(temp != inicio);
        }else{
            return false;
        }
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
            rutausuarios = "C:\\Users\\Leonel\\Documents\\NetBeansProjects\\Edd_Scrabble\\src\\Documentos\\listausuarios.dot";
            
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
        imagenUsuarios(rutausuarios, "C:\\Users\\Leonel\\Documents\\NetBeansProjects\\Edd_Scrabble\\src\\Imagenes\\listausuarios.jpg");
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
    
    public String cambiarturno(int cambio){
        String nombre = "";
        Tablero tab = new Tablero ();
        if(cambio == 1){
            usuariotemporal = inicio.siguiente;
            usuariotemporal.listafichas.graficarf();
            nombre = usuariotemporal.nombre;
            usuariotemporal = usuariotemporal.siguiente;
            return nombre;
        }else{
            usuariotemporal.listafichas.graficarf();
            nombre = usuariotemporal.nombre;
            usuariotemporal = usuariotemporal.siguiente;
            return nombre;
        }
    }
    
    public String primerUsuario(){
        NodoCusuarios temp = inicio;
        return temp.nombre;
    }
}
