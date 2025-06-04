import Controllers.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(-1);
        stack.push(5);
        stack.push(8);
        stack.printStack(); // Imprime la pila
        System.out.println("tamaño: " + stack.getSize()); // Imprime la pila actual
        stack.pop(); // Elimina el nodo superior
        stack.printStack(); // Imprime la pila después de eliminar el nodo superior
        System.out.println("tamaño: " + stack.getSize()); // Imprime la pila actual
    }
}
