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
public class NodoMatriz {
    
    public int dato;
    public int id;
    public NodoMatriz siguiente;
    public NodoMatriz anterior;
    public NodoMatriz arriba;
    public NodoMatriz abajo;
    
    public NodoMatriz(int dat, NodoMatriz ant,NodoMatriz sig,NodoMatriz arr,NodoMatriz ab,int i){
        
        dato = dat;
        anterior = ant;
        siguiente = sig;
        arriba = arr;
        abajo = ab;
        id = i;
    }
    
}
