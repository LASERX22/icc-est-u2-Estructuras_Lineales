import java.util.ArrayList;

//import Controllers.Queue;
import Controllers.QueueG;
import Models.NodeGeneric;
//import Controllers.Stack;
//import Controllers.StackG;
import Models.Persona;

public class App {
    public static void main(String[] args) throws Exception {
        /*Stack stack = new Stack();
        stack.push(10);
        stack.push(-1);
        stack.push(5);
        stack.push(8);
        stack.printStack(); // Imprime la pila
        System.out.println("tamaño: " + stack.getSize()); // Imprime la pila actual
        stack.pop(); // Elimina el nodo superior
        stack.printStack(); // Imprime la pila después de eliminar el nodo superior
        System.out.println("tamaño: " + stack.getSize()); // Imprime la pila actual*/
        
        /*StackG<Integer> pilaG=new StackG <>();
        pilaG.push(10);
        pilaG.push(8);
        pilaG.push(-1);
        pilaG.push(5);
        System.out.println("Tam = "+pilaG.getSize());
        pilaG.printStack();
        pilaG.pop();
        System.out.println("Tam = "+pilaG.getSize());
        pilaG.printStack();*/

        Persona p1=new Persona("Juan");
        Persona p2=new Persona("Maria");
        Persona p3=new Persona("Pedro");
        Persona p4=new Persona("David");

        QueueG<Persona> colaPersonas=new QueueG<Persona>();
        colaPersonas.add(p1);
        colaPersonas.add(p2);
        colaPersonas.add(p3);
        colaPersonas.add(p4);
        colaPersonas.printCola();
        System.out.println("Persona atendida -> "+colaPersonas.remove());
        colaPersonas.printCola();
        NodeGeneric<Persona> pB= colaPersonas.findByName("Juan");
        System.out.println("Persona Encontrada -> "+(pB !=null? pB:"Ninguna"));//Por recomendacion hay que cerrar los ternarios en parentesis para evitar malinterpretaciones por parte de java


        Persona pE=colaPersonas.deleteByName("Pedro");
        System.out.println("Persona eliminada -> "+(pE !=null? pE:"Ninguna"));//Lo mismo aca, al aplicar parentesis ya no compara erroneamente soltandome null, en su lugar mostrara el print como se debe
        colaPersonas.printCola();
        //Perdon por tantos comentarios, es que estoy aprendiendo jajajaja
    }
}
