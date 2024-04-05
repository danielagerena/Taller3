/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller3;

/**
 *
 * @author Daniela
 */
public class ListaDoble<T extends Comparable<T>> {
    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;
    
    public ListaDoble<T>[] split(ListaDoble<T> list) {
        ListaDoble<T>[] result = new ListaDoble[2]; //Cada componente es una mitad
        int indMitad = list.size / 2; //Indice en 5 es 2

        if (list.size % 2 == 0) { //Indice en 4 es 1
            indMitad--;
        }

        result[0] = new ListaDoble<>();
        result[1] = new ListaDoble<>();

        Nodo<T> currentNode = list.head;
        for (int i = 0; i < indMitad; i++) {
            currentNode = currentNode.next; //Moverme al siguiente nodo
        }

        result[0].head = list.head;
        result[0].tail = currentNode;
        result[0].size = indMitad + 1;

        result[1].head = currentNode.next;
        result[1].tail = list.tail;
        result[1].size = list.size - indMitad - 1;

        if (result[0].tail != null) {
            result[0].tail.next = null;
        }
        if (result[1].head != null) {
            result[1].head.prev = null;
        }

        return result;    
    }
}