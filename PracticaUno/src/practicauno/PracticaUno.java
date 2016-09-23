package practicauno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import practicauno.Lista.Hilera;
import practicauno.Nodo.Nodo;
import practicauno.Visual.VentanaPrincipal;

/**
 *
 * @author jsebastian.pelaez
 */
public class PracticaUno {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        new VentanaPrincipal();
        /*        
        Hilera lista = new Hilera();
        construirEnLista(lista);
        Hilera lista2 = new Hilera();
        construirEnLista(lista2);
        lista.ordenar();
        lista.print();
        System.out.println("");
        
        invertirLista(lista);
        lista.print();
         
        
        eliminarHilera(lista);
        lista.print();
         
        Hilera b = new Hilera();
        construirEnLista(b);
        b.print();
        isSubString(lista, b);
        boolean c = lista.esPalindrome();
        System.out.println(b);

        
        invertirLista(lista);
        lista.print();
        
        
        eliminarHilera(lista);
        lista.print();
        
        Hilera b=new Hilera();
        construirEnLista(b);
        b.print();
        isSubString(lista, b);
        
        boolean c = lista.esPalindrome();
        System.out.println(c);
        
        Hilera b = new Hilera();
        construirEnLista(b);
        b.print();
        isAnagrama(lista, b);
        */
    }

    public static void construirEnLista(Hilera lista) throws IOException {
        System.out.println("Ingrese Cadena");
        String cadena = br.readLine().replaceAll("\\p{Punct}+", "");
        for (int i = 0; i < cadena.length(); i++) {
            lista.insertNodo(cadena.charAt(i), lista.lastNode());
        }
    }

    /*Esto waza es la prueba de si borraba bien un nodo y ya lo hace perfectamente
     lo que toca hacer es implementar el metodo para borrar ya muchos nodos, el metodo borrar tambien
     organiza todos los numeros
     */
    public static void borrarDato(Hilera lista) throws IOException {
        System.out.println("Ingrese caracter a borrar");
        String cadena = br.readLine().replaceAll("\\p{Punct}+", "");
        Nodo x = new Nodo(cadena.charAt(0));
        Nodo y = lista.searchNode(x);
        if (y != null) {
            lista.delete(y.getLiga());
        }
    }

    public static void invertirLista(Hilera lista) {
        lista.invertirHilera();
    }

    public static void eliminarHilera(Hilera lista) {
        lista.eliminarHilera(16, 1, false);
    }

    public static void isSubString(Hilera a, Hilera b) {
        if (a.isSubString(b)) {
            System.out.println("ES SUBSTRING");
        } else {
            System.out.println("NO ES SUBSTRING");
        }
    }

    public static void isAnagrama(Hilera a, Hilera b) {
        if (a.isAnagrama(b)) {
            System.out.println("Es Anagrama");
        } else {
            System.out.println("No es Anagrama");
        }
    }

}
