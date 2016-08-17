package practicauno.Nodo;

public class Nodo {
    
    private char dato;
    private int indice;
    private Nodo liga;

    public char getDato() {
        return dato;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    } 

    public Nodo(char dato) {
        this.dato = dato;
        this.liga = null;
    }
    
}
