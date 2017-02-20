/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_scrabble;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author Alejandro
 */
public class XML {
    
    
    XML(String ruta){
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler(){
            
                //variables boolenas que nos serviran para saber si entramos a la etiqueta especificada del archivo xml
                boolean scrabble = false;
                boolean diemension = false;
                boolean dobles = false;
                boolean triples = false;
                boolean casilla = false;
                boolean diccionario = false;
                boolean palabra = false;
                
                public void startElement(String uri,String localnambe,String qname,Attributes atributes) throws SAXException{
                    
                    System.out.println("Start Element:"+qname);
                    
                    if(qname.equalsIgnoreCase("dimension")){
                        diemension = true;
                    }
                    if(qname.equalsIgnoreCase("casilla")){
                        casilla = true;
                    }
                    if(qname.equalsIgnoreCase("palabra")){
                        palabra = true;
                    }
                }
                
                public void endElement(String uri, String localName,String qname) throws SAXException{
                    System.out.println("End Element;"+" "+qname);
                }
                
                public void characters(char ch[], int start, int length) throws SAXException{
                    if(diemension){
                        System.out.println("dimension:"+" "+new String(ch,start,length));
                        diemension = false;
                    }
                    if(casilla){
                        System.out.println("casilla"+""+new String(ch,start,length));
                        casilla = false;
                    }
                    if(palabra){
                        System.out.println("palabra:"+" "+new String(ch,start,length));
                        InicioScrabble.diccionarioglobal.insertarPalabrafinal(new String(ch,start,length));
                        palabra = false;
                    }
                }
            };
            saxParser.parse(ruta,handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
