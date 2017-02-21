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
    public ListaDiccionario listafichas = new ListaDiccionario();
    
    public NodoCusuarios(String n,NodoCusuarios s, ListaDiccionario lista) {
        nombre = n;
        siguiente = s;
        listafichas = lista;
    }
}
