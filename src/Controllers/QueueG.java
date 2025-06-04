package Controllers;

import java.util.EmptyStackException;

//import Models.Node;
import Models.NodeGeneric;
import Models.Persona;

public class QueueG<T>{
    private NodeGeneric<T> primero; //head-front
    private NodeGeneric<T> ultimo; //back - rear -- tail
    private int size;

    
    
    public QueueG() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }

    public void add(T value){
        NodeGeneric<T> newNode = new NodeGeneric<>(value);
        if(isEmpty()){
            primero = newNode;
            ultimo = primero;
        }else{
            ultimo.setNext(newNode);
            ultimo=newNode;
        }
        size++;
    }

    public T remove(){
        if(isEmpty()){
            throw new EmptyStackException(); //Usamos la de stack pq queue no tiene
        }
        T aux=primero.getValue();
        primero=primero.getNext();
        size--;
        return aux;
    }

    public T peek(){
        if(isEmpty()) throw new EmptyStackException(); return primero.getValue();
    }

    public boolean isEmpty(){
        return this.primero == null;
    }

    public void printCola(){
        NodeGeneric<T> aux = primero;
        while (aux != null) {
            T nombre=aux.getValue();
            System.out.print(nombre + " | ");
            aux = aux.getNext();
        }
        System.out.println();
    }

    public NodeGeneric<T> findByName(String nombre) {
        NodeGeneric<T> aux=primero;
        if(primero.getValue()==nombre){
            return aux;
        }
    }

    public Persona deleteByName(String nombre) {
        
    }

    
}
