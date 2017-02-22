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
public class NodoDiccionario {
    
    public String palabra;
    public NodoDiccionario siguiente;
    public int id;
    public NodoDiccionario(String p , NodoDiccionario s){
        palabra = p;
        siguiente = s;
    }
    
    public NodoDiccionario(String p,NodoDiccionario s,int i){
        palabra = p;
        siguiente = s;
        id = i;
    }
    
}
