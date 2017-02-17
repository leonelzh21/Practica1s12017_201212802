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
public class NodoCusuarios {
    public String nombre;
    public NodoCusuarios siguiente;
    
    public NodoCusuarios(String n,NodoCusuarios s) {
        nombre = n;
        siguiente = s;
    }
}
