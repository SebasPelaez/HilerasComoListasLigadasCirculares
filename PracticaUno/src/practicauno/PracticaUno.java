/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicauno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import practicauno.Lista.Hilera;

/**
 *
 * @author jsebastian.pelaez
 */
public class PracticaUno {

    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Hilera lista = new Hilera();
        construirEnLista(lista);
        lista.print();
        System.out.println("");
        agregarHilera(lista);
        System.out.println("");
        lista.print();
    }
    
    public static void construirEnLista(Hilera lista) throws IOException{
        System.out.println("Ingrese Cadena");
        String cadena = br.readLine().replaceAll("\\p{Punct}+",""); 
        for (int i=0;i<cadena.length();i++){
           lista.insertNodo(cadena.charAt(i), lista.lastNode());
        }
        /*
        lista.Print();
        System.out.println("");
        lista.Reverse();*/
    }
    
    public static void agregarHilera(Hilera lista) throws IOException{
        System.out.println("Ingrese la cadena que quiera agregar");
        Hilera t = new Hilera();
        String cadena = br.readLine().replaceAll("\\p{Punct}+", ""); 
        for (int i=0;i<cadena.length();i++){
           t.insertNodo(cadena.charAt(i), t.lastNode());
        }
        t.print();
        lista.insertarHilera(t, 0);//Primer parametro es la hilera que quiero insertar, segundo parametro es la pos en la cual lo voy a insertar
    }
    
  
}
