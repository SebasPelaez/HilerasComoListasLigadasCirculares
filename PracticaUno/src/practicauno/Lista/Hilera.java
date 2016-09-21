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
    
    /*NUESTRO PROPIO .LENGTH
    
    */
    public int tamaño(){
        if(isVoid()){
            return 0;
        }
        Nodo p=firstNode();
        int cont=0;
        do{
            cont++;
            p=p.getLiga();
        }while(!istheEnd(p));
        return cont;
    }
    
    
    /*INICIO METODO 4
        Metodo 4: Invertir la hilera (Si la hilera ingresada es hola,
        y el usuario selecciona esta opción, la nueva hilera será aloh)
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
    /*FIN METODO 4
        Metodo 4: Invertir la hilera (Si la hilera ingresada es hola,
        y el usuario selecciona esta opción, la nueva hilera será aloh)
    */

    /*INICIO METODO 2
        Metodo 2:Eliminar hilera original o parte de ella.
     */
    public void eliminarHilera(int i, int j, boolean full) {
        if (full) {
            eliminarHileraFull();
        } else {
            Nodo p;
            Nodo q;
            if (i == 1) {
                q=firstNode();
                p=firstNode();
                Nodo previous;
                int cont=1;
                do{
                    q=q.getLiga();
                    cont++;
                }while(!istheEnd(q)&&cont<=j);
                if(istheEnd(q)){
                    eliminarHileraFull();
                }else{                    
                    while(p!=q){
                        previous=p.getLiga();
                        delete(p);
                        p=previous;
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
    
    public void eliminarHileraFull(){
        setFirst(null);
        setLast(null);
    }
    /*FIM METODO 2
        Metodo 2:Eliminar hilera original o parte de ella.
     */
    
    /*INICIO METODO 6
        Metodo 6: Determinar si la hilera original es substring de otra hilera entrada por pantalla, o viceversa, es
        decir, si la hilera entrada por pantalla es substring de la hilera original. (Si la hilera inicial es hola,
        y el substring ingresado por el usuario es ol, entonces el programa debe mostrar un mensaje indicando que ol
        es un substring de hola)
     */
    public boolean isSubString(Hilera t){
        boolean resultado=false;
        Nodo p=firstNode();
        int cont=0;
        Nodo q=t.firstNode();
        do{
            if(p.getDato()==q.getDato()){
                p=p.getLiga();
                q=q.getLiga();
                cont++;
            }else{
                if(q!=t.firstNode()){
                    q=t.firstNode();
                    cont=0;
                }                
                p=p.getLiga();
            }
        }while(!istheEnd(p)&& cont!=t.tamaño());
        if(!istheEnd(p) || cont==t.tamaño()){
            resultado=true;
        }
        return resultado;
    }
    /*FIN METODO 6
        Metodo 6: Determinar si la hilera original es substring de otra hilera entrada por pantalla, o viceversa, es
        decir, si la hilera entrada por pantalla es substring de la hilera original. (Si la hilera inicial es hola,
        y el substring ingresado por el usuario es ol, entonces el programa debe mostrar un mensaje indicando que ol
        es un substring de hola)
     */
    
}
