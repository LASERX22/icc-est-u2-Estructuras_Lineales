package Controllers;

import java.util.EmptyStackException;

import Models.NodeGeneric;

public class StackG<T> {
    private NodeGeneric<T> top;
    private int size;

    public StackG() {
        this.top=null;
        this.size=0;
    }

    public void push(T value){
        NodeGeneric<T> newNode = new NodeGeneric<>(value); // Crea un nuevo nodo
        newNode.setNext(top); // El siguiente del nuevo nodo es el actual tope
        top = newNode; // Actualiza el tope a ser el nuevo nodo
        size++; // Se aumenta el tamaño de la pila
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Lanza una excepción si la pila está vacía
        }
        T value = top.getValue(); // Obtiene el valor del nodo superior
        top = top.getNext(); // Elimina el nodo superior
        size--; // Se reduce el tamaño de la pila
        return value; // Devuelve el valor del nodo eliminado
    }

    public T peek(){
        if (isEmpty()) {
            throw new EmptyStackException(); // Lanza una excepción si la pila está vacía
        }
        return top.getValue(); // Devuelve el valor del nodo superior sin eliminarlo
    }

    public boolean isEmpty(){
        return top == null; // Devuelve true si la pila está vacía
    }

    public void printStack() {
        NodeGeneric<T> aux = top; // Nodo auxiliar para recorrer la pila
        while (aux != null) {
            System.out.print(aux.getValue() + " "); // Imprime el nodo superior
            aux = aux.getNext(); // Avanza al siguiente nodo
        }
        System.out.println(); // Imprime una nueva línea al final
    }

    public int getSize() {
        return size; // Devuelve el tamaño actual de la pila
    }
}
