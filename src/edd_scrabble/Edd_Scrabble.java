/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_scrabble;

import Estructuras.ListaCusuarios;
import Estructuras.ListaDiccionario;

/**
 *
 * @author Alejandro
 */
public class Edd_Scrabble {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaDiccionario lista = new ListaDiccionario();
        ListaCusuarios listausuario = new ListaCusuarios();
        String num;
        for(int i = 0; i<10 ;i++){
            num = String.valueOf(i);
            lista.insertarPalabrafinal(num);
        }
        
        lista.buscarPalabra();
        lista.graficarDiccionario();
        System.out.println("-----------------------------------------------------------------------------");
        for(int j = 0 ;j <5;j++){
            String nombre = String.valueOf(j);
            listausuario.insertarNombre(nombre);
        }
        listausuario.buscarNombre();
        listausuario.graficarUsuarios();
    }
    
}
