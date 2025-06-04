package Controllers;

import java.util.EmptyStackException;
import Models.Node;

public class Stack {
    private Node top; // N0do cima de la pila
    private int size; // Tamaño de la pila

    public Stack() {
        this.top = null; // Inicializa la pila vacía
        this.size = 0; // Inicializa el tamaño de la pila a 0
    }

    public void push(int value) {
        Node newNode = new Node(value); // Crea un nuevo nodo
        newNode.setNext(top); // El siguiente del nuevo nodo es el actual tope
        top = newNode; // Actualiza el tope a ser el nuevo nodo
        size++; // Se aumenta el tamaño de la pila
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Lanza una excepción si la pila está vacía
        }
        int value = top.getValue(); // Obtiene el valor del nodo superior
        top = top.getNext(); // Elimina el nodo superior
        size--; // Se reduce el tamaño de la pila
        return value; // Devuelve el valor del nodo eliminado
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Lanza una excepción si la pila está vacía
        }
        return top.getValue(); // Devuelve el valor del nodo superior sin eliminarlo
    }

    public boolean isEmpty() {
        return top == null; // Devuelve true si la pila está vacía
    }

    public void printStack() {
        Node aux = top; // Nodo auxiliar para recorrer la pila
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
