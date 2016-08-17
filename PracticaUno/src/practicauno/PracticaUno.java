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
        Nodo p;
        Scanner leer = new Scanner(System.in);
        for (int i=1;i<10;i++){
            System.out.println("Dato: " + i);
            lista.Insert(leer.next().charAt(0), lista.LastNode());
        }
        lista.Print();
        System.out.println("");
        lista.Reverse();
        lista.Print();
    }
    
}
