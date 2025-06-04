package Controllers;

import java.util.EmptyStackException;

import Models.Node;

public class Queue {
    private Node primero; //head-front
    private Node ultimo; //back - rear -- tail
    private int size;

    
    
    public Queue() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }

    public void add(int value){
        Node newNode = new Node(value);
        if(isEmpty()){
            primero = newNode;
            ultimo = primero;
        }else{
            ultimo.setNext(newNode);
            ultimo=newNode;
        }
        size++;
    }

    public int remove(){
        if(isEmpty()){
            throw new EmptyStackException(); //Usamos la de stack pq queue no tiene
        }
        int aux=primero.getValue();
        primero=primero.getNext();
        size--;
        return aux;
    }

    public int peek(){
        if(isEmpty()) throw new EmptyStackException(); return primero.getValue();
    }

    public boolean isEmpty(){
        return this.primero == null;
    }
}
