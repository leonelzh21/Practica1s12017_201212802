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
public class NodoFichas {
    
    public String ficha;
    public NodoFichas siguiente;
    public int id;
    
    public NodoFichas(String p , NodoFichas s,int i){
        ficha = p;
        siguiente = s;
        id = i;
    }
    
}
