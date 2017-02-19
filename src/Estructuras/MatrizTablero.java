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
public class MatrizTablero {
    public NodoMatriz inicio;
    public NodoMatriz fin;
    
    public String nodos;
    public String relaciones;
    
    public MatrizTablero(){
        inicio = null;
        fin = null;
        nodos="";
        relaciones ="";
    }
    
    // este metodo va crar la matriz de un tamaño definico
    public  void crearMatriz(int dimension){        
        //variable que nos va ayudar a tener control del recorrido en el eje x
        int contx = 0;
        //varibale que indica la fila en la que vamos creando los nodos
        int fila =0;
        //viriable que indica el cambio de fial
        int cambiofila =0;
        //vairalbes que contendra el id de cada nodo
        int id =0;
        //aqui en empieza la cracion de la matriz solo mientras el nuemro de filas sea menor a la dimension
        while(cambiofila < dimension){
        
            while(fila == 0){
                if(inicio == null){//aqui se va a crear el primer nodo
                    inicio = new NodoMatriz(contx, null, null, null, null,id);
                    fin = inicio;//como es el primero el fin es igual a incio
                    contx++;
                    id++;
                    nodos += inicio.id+"\n";
                    System.out.println("----"+fila+"-------");
                    System.out.println(inicio.anterior+" "+inicio.siguiente+" "+inicio.arriba+" "+inicio.abajo+" "+inicio.dato);
                }else if(contx< dimension){
                    NodoMatriz nuevo = new NodoMatriz(contx, fin, null, null,null,id);//se craa el nodo endonde su apuntador anterior se dirige al fin de la lista que ya contenia nodos
                    fin.siguiente = nuevo;//aqui decimos que el siguiente del fin anterior es el nuevo nodod
                    fin = nuevo;//el nuevo nodo creado sera el nuevo fin
                    contx++;
                    id++;
                    nodos+=nuevo.id+"\n";
                    relaciones += nuevo.anterior.id+ "--"+nuevo.id +"\n" +nuevo.id + "--"+nuevo.anterior.id+"\n";
                    System.out.println("-----------"+fila+"---------");
                    System.out.println(nuevo.anterior.dato+" "+nuevo.siguiente+" "+nuevo.arriba+" "+nuevo.abajo+" "+nuevo.dato);
                }else{
                    fila = 1;
                    contx = 0;
                }
            }
            
            cambiofila++;
            
            while(fila == 1){
                if(fin.arriba == null && fin.siguiente == null && contx == 0){
                    NodoMatriz nuevo = new NodoMatriz(contx, null, null, fin, null,id);
                    fin.abajo = nuevo;
                    fin = nuevo;
                    contx++;
                    id++;
                    nodos += nuevo.id+"\n";
                    relaciones += fin.arriba.id +"--"+fin.id+"\n"+fin.id + "--" + fin.arriba.id+"\n"; 
                    System.out.println("---------"+fila+"---------");
                    System.out.println(nuevo.arriba.dato+" "+nuevo.anterior+" "+nuevo.siguiente+" "+nuevo.abajo+" "+nuevo.dato);
                }else if (contx<dimension && fin.arriba != null && fin.anterior == null){
                    NodoMatriz nuevo = new NodoMatriz(contx, null, fin, fin.arriba.anterior, null,id);
                    fin.anterior = nuevo;
                    fin = nuevo;
                    contx++;
                    id++;
                    nodos += fin.id+"\n";
                    relaciones += fin.id + "--"+fin.siguiente.id +"\n"+fin.id +"--"+fin.siguiente.arriba.anterior.id+"\n"+fin.siguiente.id+"--"+fin.id+"\n";
                    System.out.println("---------"+fila+"---------");
                    System.out.println(nuevo.siguiente.dato+" "+nuevo.arriba.dato+" "+nuevo.anterior+" "+nuevo.abajo+" "+nuevo.dato);
                }else if(contx < dimension && fin.siguiente == null && fin .arriba != null && fin.anterior != null){
                    NodoMatriz nuevo = new NodoMatriz(contx, null, null, fin, null,id);
                    fin.abajo = nuevo;
                    fin = nuevo;
                    contx++;
                    id++;
                    nodos += fin.id+"\n";
                    relaciones += fin.id +"--"+fin.arriba.id+"\n"+fin.arriba.id+ "--"+fin.id+"\n";
                    System.out.println("---------"+fila+"---------");
                    System.out.println(nuevo.anterior+" "+nuevo.siguiente+" "+nuevo.arriba.dato+" "+nuevo.abajo+" "+nuevo.dato);
                }else{
                    fila = 2;
                    contx = 0;
                }
            }
            
            cambiofila++;
            
            while(fila == 2 && cambiofila < dimension){
                if(contx == 0 && fin.anterior == null){
                    NodoMatriz nuevo = new NodoMatriz(contx, null, null, fin, null,id);
                    fin.abajo = nuevo;
                    fin = nuevo;
                    contx++;
                    id++;
                    nodos += fin.id+"\n";
                    relaciones += fin.id +"--"+fin.arriba.id +"\n"+fin.arriba.id+"--"+fin.id+"\n";
                    System.out.println("---------"+fila+"---------");
                    System.out.println(nuevo.anterior+" "+nuevo.siguiente+" "+nuevo.arriba.dato+" "+nuevo.abajo+" "+nuevo.dato);
                }else if(contx < dimension){
                    NodoMatriz nuevo = new NodoMatriz(contx, fin,null, fin.arriba.siguiente, null,id);
                    fin.siguiente = nuevo;
                    fin = nuevo;
                    contx++;
                    id++;
                    nodos += fin.id+"\n";
                    relaciones += fin.id+"--"+fin.anterior.id+"\n"+fin.id+"--"+fin.anterior.arriba.siguiente.id+"\n"+fin.anterior.id+"--"+fin.id+"\n";
                    System.out.println("---------"+fila+"---------");
                    System.out.println(nuevo.anterior.dato+" "+nuevo.siguiente+" "+nuevo.arriba.dato+" "+nuevo.abajo+" "+nuevo.dato);
                }else{
                    fila = 1;
                    contx =0;
                }
            }
            cambiofila++;
            
        }
        graficarMatriz();
    }
    
    public void graficarMatriz(){
        String textographics = "graph G"+"{"+"\n"+nodos+relaciones+"}";
        String ruta = "C:\\Users\\Alejandro\\Documents\\NetBeansProjects\\Edd_Scrabble\\src\\Estructuras\\MatrizTalbero.dot";
        
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
            imagenMatriz(ruta,"C:\\Users\\Alejandro\\Documents\\NetBeansProjects\\Edd_Scrabble\\src\\Imagenes\\Matriz.jpg");
            
    }
    
    public void imagenMatriz(String contenido , String ruta){
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
