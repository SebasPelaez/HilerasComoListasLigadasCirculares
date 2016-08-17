/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicauno.Lista;

import practicauno.Nodo.Nodo;

public class Lista_C {

    private Nodo first;
    private Nodo last;

    public Lista_C() {//Constructor
        first = last = null;
    }

    public boolean IsVoid() {//PREGUNTA SI LA LISTA ESTA VACIA
        return (first == null);
    }

    public Nodo FirstNode() { //RETORNA EL PRIMERO
        return first;
    }

    public Nodo LastNode() {//RETORNA EL ULTIMO
        return last;
    }

    public boolean IstheEnd(Nodo x) {// PREGUNTA SI LA LISTA ACABO LA LISTA
        return (x == first);
    }

    public void Print() {//IMPRIME LOS DATOS DE LA LISTA
        Nodo p = FirstNode();
        if (!IsVoid()) {
            do {
                System.out.print(p.getDato() + " || ");
                p = p.getLiga();
            } while (!IstheEnd(p));
        } else {
            System.out.println("Lista Vacia");
        }
    }

    public Nodo PreviousNode(Nodo x) {
        if (IsVoid()) {
            System.out.println("Lista vacia");
            return null;
        } else {
            Nodo p, q;
            p = FirstNode();
            do {
                q = p;
                p = p.getLiga();
            } while (!IstheEnd(p) && p != x);
            return q;
        }
    }

    public void Insert(char data, Nodo y) {
        Nodo x = new Nodo(data);
        Connect(x, y);
    }

    public void Connect(Nodo x, Nodo y) {
        if (y != null) {
            x.setLiga(y.getLiga());
            y.setLiga(x);
            if (y == LastNode()) {
                last = x;
            }
        } else {
            if (IsVoid()) {
                x.setLiga(x);
                first = last = x;
            }

        }
    }

    public void Delete(Nodo x) {
        if (x == null) {
            System.out.println("El nodo no existe");
            return;
        }
        Disconnect(x, PreviousNode(x));
    }

    public void Disconnect(Nodo x, Nodo y) {
        if (x != FirstNode()) {
            y.setLiga(x.getLiga());
            if (x == LastNode()) {
                last = y;
            }
        } else {
            first = first.getLiga();
            if (first == null) {
                last = null;
            }
        }
    }

    public void Reverse() {
        if (IsVoid()) {
            System.out.println("Lista vacia");
        } else {
            Nodo p, q, r;
            p = FirstNode();
            last = p;
            q = PreviousNode(p);
            do {
                r = q;
                q = p;
                p = p.getLiga();
                q.setLiga(r);
            } while (!IstheEnd(p));
            first = q;
        }
    }
    
}
