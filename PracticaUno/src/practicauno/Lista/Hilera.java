/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicauno.Lista;

import practicauno.Nodo.Nodo;

/**
 *
 * @author jsebastian.pelaez
 */
public class Hilera extends Lista_C {

    public Hilera() {

    }

    public void insertarHilera(Hilera t, int i) {
        Nodo p = firstNode();
        Nodo ant = previousNode(p);
        Nodo q;
        do {
                ant = p;
                p = p.getLiga();
        } while (!istheEnd(p) && p.getIndice() < i);
        q = t.firstNode();
        do {
            insertNodo(q.getDato(), ant);
            ant = ant.getLiga();
            q = q.getLiga();
        } while (!t.istheEnd(q));
    }
}
