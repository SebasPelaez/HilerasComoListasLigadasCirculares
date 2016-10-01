/**
 * @author Juan Sebastian Pelaez, Juan Esteban Marin
 */
package practicauno.Lista;

import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JTextArea;
import practicauno.Nodo.Nodo;

/**
 * Clase Hilera que representa el String en forma de lista Ligada, extiende de
 * la Clase Lista_C la cual corresponde a la estructura Lista simplemente ligada
 * circular
 */
public class Hilera extends Lista_C {

    /**
     * Metodo Constructor
     */
    public Hilera() {
    }

    /**
     * Este Metodo ingresa caracter por caracter a la lista
     */
    public void construirEnLista(String cadena) {
        if (cadena != null) {
            int n = 0;
            while (true) {
                try {
                    insertNodo(cadena.charAt(n), lastNode());
                } catch (Exception e) {
                    break;
                }
                n++;
            }
        }
    }

    /**
     * Retorna el numero de nodos de la lista
     */
    public int tamano() {
        if (isVoid()) {
            return 0;
        }
        Nodo p = firstNode();
        int cont = 0;
        do {
            cont++;
            p = p.getLiga();
        } while (!istheEnd(p));
        return cont;
    }

    //Inicio Metodo 4
    /**
     *Metodo 4: Invertir la hilera (Si la hilera ingresada es hola,
     *y el usuario selecciona esta opción, la nueva hilera será aloh)
     */
    public void invertirHilera() {
        if (isVoid()) {
            System.out.println("Lista vacia");
        } else {
            Nodo p, q, r;
            p = firstNode();
            setLast(p);
            q = previousNode(p);
            do {
                r = q;
                q = p;
                p = p.getLiga();
                q.setLiga(r);
            } while (!istheEnd(p));
            setFirst(q);
        }
    }
    //FIN METODO 4

    //INICIO METODO 2
    /**
     *Metodo 2:Eliminar hilera original o parte de ella.
     */
    public void eliminarHilera(int i, int j, boolean full) {
        if (full) {
            eliminarHileraFull();
        } else {
            Nodo p;
            Nodo q;
            if (i == 1) {
                q = firstNode();
                p = firstNode();
                Nodo previous;
                int cont = 1;
                do {
                    q = q.getLiga();
                    cont++;
                } while (!istheEnd(q) && cont <= j);
                if (istheEnd(q)) {
                    eliminarHileraFull();
                } else {
                    while (p != q) {
                        previous = p.getLiga();
                        delete(p);
                        p = previous;
                    }
                }
            } else {
                p = firstNode();
                int cont = 1;
                do {
                    p = p.getLiga();
                    cont++;
                } while (!istheEnd(p) && cont < i);
                if (cont < i) {
                    System.out.println("Limites de borrado mal definidos");
                } else {
                    q = p;
                    cont = 1;
                    do {
                        delete(p);
                        q = q.getLiga();
                        p = q;
                        cont++;
                    } while (!istheEnd(q) && cont <= j);
                }
            }
        }
    }

    private void eliminarHileraFull() {
        setFirst(null);
        setLast(null);
    }
    //FIN METODO 2

    //Inicio Metodo 6
    /**
     *Metodo 6: Determinar si la hilera original es substring de otra hilera entrada por pantalla, o viceversa, es
     *decir, si la hilera entrada por pantalla es substring de la hilera original.(Si la hilera inicial es hola,
     *y el substring ingresado por el usuario es ol, entonces el programa debe mostrar un mensaje indicando que ol
     *es un substring de hola)
     */
    public boolean isSubString(Hilera t) {
        boolean resultado = false;
        Nodo p = firstNode();
        int cont = 0;
        Nodo q = t.firstNode();
        do {
            if (p.getDato() == q.getDato()) {
                p = p.getLiga();
                q = q.getLiga();
                cont++;
            } else {
                if (q != t.firstNode()) {
                    q = t.firstNode();
                    cont = 0;
                }
                p = p.getLiga();
            }
        } while (!istheEnd(p) && cont != t.tamano());
        if (!istheEnd(p) || cont == t.tamano()) {
            resultado = true;
        }
        return resultado;
    }
    //FIN METODO SEIS
    
    /**
     * Realiza una copia de la hilera
     * @return La copia de la Hilera
     */
    public Hilera copia() {
        Hilera copia = new Hilera();
        Nodo p, x;
        p = this.firstNode();
        do {
            copia.insertNodo(p.getDato(), copia.lastNode());
            p = p.getLiga();
        } while (!this.istheEnd(p));
        return copia;
    }

    //INICIO METODO 7
    /**
    * Método 7, el métdo retorna true si la hilera es un palíndrome, false de lo contrario ejemplo ana
    *   es palíndrome ya que se lee igual de izq a der y de der a izq.
    */
    public boolean esPalindrome() {
        Nodo p, q;
        Hilera b = new Hilera();
        b = this.copia();
        b.invertirHilera();
        p = this.firstNode();
        q = b.firstNode();

        do {
            if (p.getDato() == q.getDato()) {
                p = p.getLiga();
                q = q.getLiga();
            } else {
                return false;
            }
        } while (!this.istheEnd(p));
        return true;
    }
    //FIN METODO 7
    
    //INICIO METODO 3
    /**
     * 
     * @param i Posición desde la que empezara a reemplazar
     * @param j Cantidad de Caracteres
     * @param s Hilera por la cual reemplzar
     */
    public void replace(int i, int j, Hilera s) {
        Nodo p, q, pp;
        int c = 1;
        if (!isVoid()) {
            p = firstNode();
            pp = p;
            if (i + j <= tamano() + 1) {
                do {
                    c++;
                    pp = p;
                    p = p.getLiga();
                } while (c < i);
                c = 1;
                do {
                    c++;
                    p = p.getLiga();
                } while (c < j);
                if (tamano() == 1) {
                    setFirst(s.firstNode());
                    setLast(s.lastNode());
                }
                if (i == 1 && j == 1) {
                    setFirst(s.firstNode());
                    s.lastNode().setLiga(pp.getLiga());
                    lastNode().setLiga(s.firstNode());
                } else {
                    pp.setLiga(s.firstNode());
                    s.lastNode().setLiga(p.getLiga());
                }

            }
        } else {
            System.out.println("Lista Vacia");
        }

    }
    //FIN METODO 3
    
    //INICIO METODO 8
     
    /**
     * Metodo 8:  Determinar si la hilera es anagrama de otra (Si las hileras son salta y atlas, el sistema debe 
     *mostrar un mensaje indicando que son anagramas)
     * @param b Hilera con la cual se comparara si es anagrama
     * @return verdadero si es Anagrama, falso de lo contrario
     */
    public boolean isAnagrama(Hilera b) {
        boolean respuesta = true;
        Hilera aux = copia();
        Nodo p = aux.firstNode();
        Nodo q = b.firstNode();
        int cont = 0;
        while (cont != aux.tamano()) {
            if (p.getDato() == ' ') {
                p = p.getLiga();
            }
            if (q.getDato() == ' ') {
                q = q.getLiga();
            }
            if (p.getDato() == q.getDato()) {
                aux.delete(p);
                p = aux.firstNode();
                q = q.getLiga();
                cont = 0;
            } else {
                p = p.getLiga();
                cont++;
            }
        }
        if (!b.istheEnd(q)) {
            respuesta = false;
        }

        return respuesta;
    }
    //FIN METODO 8
    //INICIO METODO 1
    /**
     * MÉTODO 1: INSERTA UNA HILERA T A PARTIR DEL CARACTER i DE LA HILERA 
     * @param i Posicion apartir de la cual insertara
     * @param s Hilera que insertara
     */
    public void insert(int i, Hilera s) {
        if (!isVoid()) {
            Nodo p, pp;
            p = firstNode();
            pp = p;
            int c = 1;
            if (i < tamano()) {
                if (i > 1) {
                    do {
                        c++;
                        pp = p;
                        p = p.getLiga();
                    } while (c < i);
                    s.lastNode().setLiga(pp.getLiga());
                    pp.setLiga(s.firstNode());
                } else {
                    lastNode().setLiga(s.firstNode());
                    s.lastNode().setLiga(firstNode());
                    setFirst(s.firstNode());
                }
            } else if (i == tamano()) {
                lastNode().setLiga(s.firstNode());
                s.lastNode().setLiga(firstNode());
                setLast(s.lastNode());
            } else {
                System.out.println("El índice debe ser menor que: " + tamano());
            }

        }
    }
    //FIN METODO OCHO
    
    //INICIO METODO 5
    /**
     * Metodo Cinco: Ordena la lista Ascendentemente
     */
    public void ordenar() {
        Nodo p, pp;
        char aux;
        int c;
        for (int i = tamano(); i > 1; i--) {
            c = 1;
            p = firstNode();
            pp = p;
            do {
                c++;
                pp = p;
                p = p.getLiga();
                if (pp.getDato() > p.getDato()) {
                    aux = pp.getDato();
                    pp.setDato(p.getDato());
                    p.setDato(aux);
                }
            } while (c < i);
        }
    }
    //FIN METODO 5
    
    
    /**
     * Pinta la Hilera en un cuadro de texto
     * @param txt Cuadro de texto en el cual imprimira el resultado
     */
    public void pintarLista(JTextArea txt) {
        txt.setText("");
        Nodo p = firstNode();
        if (!isVoid()) {
            do {
                txt.setText(txt.getText() + p.getDato());
                p = p.getLiga();
            } while (!istheEnd(p));
        } else {
            System.out.println("Lista Vacia");
        }
    }

    /**
     * Metodo que guarda en un archivo de texto los comandos necesarios para que la aplicacion
     * Graphiz cree la imagen con la representacion de la lista
     */
    public void guardarEnArchivo() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        Nodo p;
        int contador = 1;
        try {
            fichero = new FileWriter("src//grafico.txt", false);
            pw = new PrintWriter(fichero);
            pw.println("digraph G{");
            pw.println("node [shape=box];");
            pw.println("node [style=filled];");
            pw.println("node [fillcolor=\"#EEEEEE\"];");
            pw.println("node [color=\"#EEEEEE\"];");
            pw.println("edge [color=\"#31CEF0\"];");
            pw.println("Primero [label=Primero, fillcolor=lightblue]");
            p = firstNode();
            do {
                pw.println("Nodo" + contador + " [label=" + p.getDato() + "];");
                p = p.getLiga();
                contador++;
            } while (!istheEnd(p));
            p = firstNode();
            contador = 1;
            do {
                if (contador == tamano()) {
                    pw.println("Nodo" + contador + " -> " + "Nodo" + 1);
                } else {
                    if (contador == 1) {
                        pw.println("Primero" + " -> " + "Nodo" + contador + "[style=dashed,color=red]");
                    }
                    pw.println("Nodo" + contador + " -> " + "Nodo" + (contador + 1));
                }
                p = p.getLiga();
                contador++;
            } while (!istheEnd(p));
            pw.print("rankdir=LR;}");
            fichero.close();
        } catch (Exception e) {
            System.out.println("Error Creando Archivo");
            System.out.println(e);
        }
    }

    /**
     * Metodo que genera un archivo JPG a partir de un comando de consola
     * tomando como parametros la ubicacion del aplicativo, la ruta donde se encuentra el archivo
     * y la ruta donde guardara la imagen
     */
    public void generarImagen() {
        try {
            ProcessBuilder pbuilder;
            /*
             * Realiza la construccion del comando    
             * en la linea de comandos esto es: 
             * dot -Tpng -o archivo.png archivo.dot
             */
            pbuilder = new ProcessBuilder("Graphviz2.38//bin//dot.exe", "-Tpng", "-o", "src//grafico.jpg", "src//grafico.txt");
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
