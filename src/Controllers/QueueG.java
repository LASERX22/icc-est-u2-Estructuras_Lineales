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
        while(aux != null){
            if(aux.getValue() instanceof Persona){ //Por lo que averigue hay que asegurarse de que el valor del aux sea del tipo Persona
                Persona persona=(Persona) aux.getValue(); //Una vez seguros definimos como tipo Persona
                if(persona.getNombre().equals(nombre)){ 
                    return aux;
                }
            }
            aux=aux.getNext();
        }
        return null; //En caso de no encontrar
    }

    public Persona deleteByName(String nombre) {
        NodeGeneric<T> actual = primero; //Partimos por usar de actual al "Primero" de la cola,
        NodeGeneric<T> anterior = null; //Lo dejamos como null porque se supone no hay ninguno antes del primero en teoria, obviamente estos valores iran cambiando

        while (actual != null) {
            if (actual.getValue() instanceof Persona) {
                Persona p = (Persona) actual.getValue();
                if (p.getNombre().equals(nombre)) { //Aqui tuve un problema de que me soltaba solo null en la consola porque mi entrada era 'pedro' e intente buscar 'Pedro', en ese caso debia usar equalsIgnoreCase, por ser una practica simple solo cambie la entrada a 'Pedro'
                    // Si es el primero
                    if (anterior == null) {
                        primero = actual.getNext();// Si el actual es el primero, se va a borrar y aparte no hay anterior, el primero de la lista pasa a ser el siguiente
                    } else {
                        anterior.setNext(actual.getNext());//Si el actual no es el primero y tiene un anterior, entonces conectamos al anterior con el siguiente al actual que se va a eliminar
                    }
                    // Si es el último
                    if (actual == ultimo) {
                        ultimo = anterior; //Con esto si por ejemplo el actual con el que trabajamos es e lultimo de la cola y es el que queremos borrar entonces definimos al anterior a este como el ultimo de la cola
                    }
                    size--;// Como estamos removiendo elementos, el tamaño de la cola disminuye
                    return p;// Por la practica, devolvemos el eliminado para asegurarnos
                }
            }
            anterior = actual;         //Me costo entender pero estas lineas se las coloca fuera del if que se asegura de que 
            actual = actual.getNext();//el elemento sea tipo Persona, para que de no serlo el codigo siga con el siguiente 
                                     //elemento de la cola y no se estanque, osea si hubieran otro tipo de datos(Porque trabajamos con clase generica),
                                    //el codigo podria seguir con el siguiente elemento sin detenerse 
        }
        return null; // No encontrado
    }
}
