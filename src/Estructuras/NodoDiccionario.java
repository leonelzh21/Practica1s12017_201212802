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
    
    public NodoDiccionario(String p , NodoDiccionario s){
        palabra = p;
        siguiente = s;
    }
    
}
