/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicauno;

import java.util.Scanner;
import practicauno.Lista.Lista_C;
import practicauno.Nodo.Nodo;

/**
 *
 * @author jsebastian.pelaez
 */
public class PracticaUno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista_C lista = new Lista_C();
        construirEnLista(lista);
        lista.Print();
        System.out.println("");
        agregarHilera(lista);
        lista.Print();
    }
    
    public static void construirEnLista(Lista_C lista){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese Cadena");
        String cadena = leer.next().replaceAll("\\p{Punct}+", ""); 
        for (int i=0;i<cadena.length();i++){
           lista.Insert(cadena.charAt(i), lista.LastNode());
        }
        /*
        lista.Print();
        System.out.println("");
        lista.Reverse();*/
    }
    
    public static void agregarHilera(Lista_C lista){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cadena que quiera agregar");
        String cadena = leer.next().replaceAll("\\p{Punct}+", ""); 
        for (int i=0;i<cadena.length();i++){
           lista.Insert(cadena.charAt(i), lista.LastNode());
        }
    }
}
