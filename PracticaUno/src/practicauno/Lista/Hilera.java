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

    /*WAZA, aqui esta lo que yo había hecho, solo falta validar el agregado al inicio, como le digo
    si quiere lo termina de modificar o lo borra del todo
    */
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
    
    /*Metodo 4: Invertir la hilera (Si la hilera ingresada es hola,
        y el usuario selecciona esta opción, la nueva hilera será aloh)
    */
    
    public void invertirHilera(){
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
    
    public Hilera copia(){
        Hilera copia = new Hilera();
        Nodo p,x;
        p = this.firstNode();
        do{
            copia.insertNodo(p.getDato(), copia.lastNode());
            p = p.getLiga();
        }while(!this.istheEnd(p));
        return copia;
    } 
    
    //Método 7, el métdo retorna true si la hilera es un palíndrome, false de lo contrario ejemplo ana
    //es palíndrome ya que se lee igual de izq a der y de der a izq.
    public boolean esPalindrome(){
        Nodo p,q;
        Hilera b= new Hilera();
        b = this.copia();
        b.invertirHilera();
        
        b.print();
        
        p = this.firstNode();
        q = b.firstNode();
        
        do
          if(p.getDato()== q.getDato()){
              p = p.getLiga();
              q = q.getLiga();
          }else{
          return false;
          }   
        while(!this.istheEnd(p));
        return true;
    }
    
    public void replace(int i, int j){
        Nodo p,q;
        int c=1;
        if(!isVoid()){
            p=firstNode();
            do{
                c++;
                p=p.getLiga();
            }while(c<i);
        }
    
    }
}
