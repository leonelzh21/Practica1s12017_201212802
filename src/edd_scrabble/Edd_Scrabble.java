/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_scrabble;

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
        String num;
        for(int i = 0; i<10 ;i++){
            num = String.valueOf(i);
            lista.insertarPalabrafinal(num);
        }
        
        lista.buscarPalabra();
        lista.graficarDiccionario();
    }
    
}
