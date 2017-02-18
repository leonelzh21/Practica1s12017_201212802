/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Alejandro
 */
public class MatrizTablero {
    public NodoMatriz inicio;
    public NodoMatriz fin;
    
    public MatrizTablero(){
        inicio = null;
        fin = null;
    }
    
    // este metodo va crar la matriz de un tamaño definico
    public  void crearMatriz(int dimension){        
        //aqui vamos a craer los nodos en el eje x
        int contx = 0;
        int fila =0;
        int cambiofila =0;
        
        while(cambiofila < dimension){
        
            while(fila == 0){
                if(inicio == null){
                    inicio = new NodoMatriz(contx, null, null, null, null);
                    fin = inicio;
                    contx++;
                    System.out.println("----"+fila+"-------");
                    System.out.println(inicio.anterior+" "+inicio.siguiente+" "+inicio.arriba+" "+inicio.abajo+" "+inicio.dato);
                }else if(contx< dimension){
                    NodoMatriz nuevo = new NodoMatriz(contx, fin, null, null,null);
                    fin.siguiente = nuevo;
                    fin = nuevo;
                    contx++;
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
                    NodoMatriz nuevo = new NodoMatriz(contx, null, null, fin, null);
                    fin.abajo = nuevo;
                    fin = nuevo;
                    contx++;
                    System.out.println("---------"+fila+"---------");
                    System.out.println(nuevo.arriba.dato+" "+nuevo.anterior+" "+nuevo.siguiente+" "+nuevo.abajo+" "+nuevo.dato);
                }else if (contx<dimension && fin.arriba != null && fin.anterior == null){
                    NodoMatriz nuevo = new NodoMatriz(contx, null, fin, fin.arriba.anterior, null);
                    fin.anterior = nuevo;
                    fin = nuevo;
                    contx++;
                    System.out.println("---------"+fila+"---------");
                    System.out.println(nuevo.siguiente.dato+" "+nuevo.arriba.dato+" "+nuevo.anterior+" "+nuevo.abajo+" "+nuevo.dato);
                }else if(contx < dimension && fin.siguiente == null && fin .arriba != null && fin.anterior != null){
                    NodoMatriz nuevo = new NodoMatriz(contx, null, null, fin, null);
                    fin.abajo = nuevo;
                    fin = nuevo;
                    contx++;
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
                    NodoMatriz nuevo = new NodoMatriz(contx, null, null, fin, null);
                    fin.abajo = nuevo;
                    fin = nuevo;
                    contx++;
                    System.out.println("---------"+fila+"---------");
                    System.out.println(nuevo.anterior+" "+nuevo.siguiente+" "+nuevo.arriba.dato+" "+nuevo.abajo+" "+nuevo.dato);
                }else if(contx < dimension){
                    NodoMatriz nuevo = new NodoMatriz(contx, fin,null, fin.arriba.siguiente, null);
                    fin.siguiente = nuevo;
                    fin = nuevo;
                    contx++;
                    System.out.println("---------"+fila+"---------");
                    System.out.println(nuevo.anterior.dato+" "+nuevo.siguiente+" "+nuevo.arriba.dato+" "+nuevo.abajo+" "+nuevo.dato);
                }else{
                    fila = 1;
                    contx =0;
                }
            }
            cambiofila++;
            
        }
    }
}
