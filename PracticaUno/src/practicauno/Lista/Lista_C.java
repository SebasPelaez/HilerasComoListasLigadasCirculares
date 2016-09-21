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

    public boolean isVoid() {//PREGUNTA SI LA LISTA ESTA VACIA
        return (first == null);
    }

    public Nodo firstNode() { //RETORNA EL PRIMERO
        return first;
    }

    public Nodo lastNode() {//RETORNA EL ULTIMO
        return last;
    }

    public boolean istheEnd(Nodo x) {// PREGUNTA SI LA LISTA ACABO LA LISTA
        return (x == first);
    }

    public void print() {//IMPRIME LOS DATOS DE LA LISTA
        Nodo p = firstNode();
        if (!isVoid()) {
            do {
                System.out.print(p.getDato() + "|" + p.getIndice() + "|| ");
                p = p.getLiga();
            } while (!istheEnd(p));
        } else {
            System.out.println("Lista Vacia");
        }
    }

    public Nodo previousNode(Nodo x) {
        if (isVoid()) {
            System.out.println("Lista vacia");
            return null;
        } else {
            Nodo p, q;
            p = firstNode();
            do {
                q = p;
                p = p.getLiga();
            } while (!istheEnd(p) && p != x);
            return q;
        }
    }

    public void insertNodo(char data, Nodo y) {
        Nodo x = new Nodo(data);
        connect(x, y);
    }

    public void connect(Nodo x, Nodo y) {
        if (y != null) {
            x.setLiga(y.getLiga());
            y.setLiga(x);
            x.setIndice(y.getIndice() + 1);
            if (y == lastNode()) {
                last = x;
            }
        } else if (isVoid()) {
            x.setLiga(x);
            x.setIndice(1);
            first = last = x;
        }
    }
    
    public void delete(Nodo x) {
        if (x == null) {
            System.out.println("El nodo no existe");
            return;
        }
        disconnect(x, previousNode(x));
    }

    public void disconnect(Nodo x, Nodo y) {
        if (firstNode() == lastNode()) {
            first = last = null;
        } else {
            if (x != firstNode()) {
                y.setLiga(x.getLiga());
                if (x == lastNode()) {
                    last = y;
                }
            } else {
                first = firstNode().getLiga();
                lastNode().setLiga(firstNode());
            }
            organizeNode(y.getLiga());
        }
    }

    public void organizeNode(Nodo p){
        if(p.getIndice()!=1){
            do{
                p.setIndice(p.getIndice()-1);
                p=p.getLiga();
            }while(!istheEnd(p));
        }
    }
    
    public Nodo searchNode(Nodo x){
        if(firstNode().getDato()==x.getDato()){
            return previousNode(firstNode());
        }
        Nodo p=firstNode();
        Nodo q=previousNode(p);
        do{
            q=p;
            p=p.getLiga();
        }while(!istheEnd(p)&& p.getDato()!=x.getDato());
        if(istheEnd(p)){
            q=null;
        }
        return q;
    }

    public void setFirst(Nodo first) {
        this.first = first;
    }
    
    public void setLast(Nodo last) {
        this.last = last;
    }
}
