/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller3;

public class ListaDoble<T extends Comparable<T>> {
    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;
    
    public ListaDoble<T>[] split() {
        ListaDoble[] result = new ListaDoble[2]; //Cada componente es una mitad
        int indMitad = size / 2; //Indice en 5 es 2

        /*if (list.size % 2 == 0) { //Indice en 4 es 1
            indMitad--;
        }*/

        Nodo current = head;
        for (int i = 0; i < indMitad; i++) {
            current = current.next; //Moverme al siguiente nodo
        }
        result[0] = new ListaDoble<>();
        result[1] = new ListaDoble<>();
        
        while (current != null) {
        result[0].insert(current.item);
        current = current.next;
    }

    for (Nodo temp = head; temp != null; temp = temp.next) {
        if (temp.next == null) {
            break;
        }
        current = current.next;
    }

    while (current != null) {
        result[1].insert(current.item);
        current = current.next;
    }

    return result;
}
    public void insert(Comparable data) {
    Nodo newNode = new Nodo(data);

    if (head == null) {
        head = newNode;
        tail = newNode;
    } else {
        Nodo current = head;

        if (data.compareTo(current.item) < 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            while (current.next != null && data.compareTo(current.next.item) > 0) {
                current = current.next;
            }

            if (current.next == null) {
                current.next = newNode;
                newNode.prev = current;
                tail = newNode;
            } else {
                newNode.next = current.next;
                newNode.prev = current;
                current.next.prev = newNode;
                current.next = newNode;
            }
        }
    }
}
    
    public static ListaDoble merge(ListaDoble l1, ListaDoble l2) {
    ListaDoble mergedList = new ListaDoble();
    Nodo actual1 = l1.head;
    Nodo actual2 = l2.head;

    while (actual1 != null && actual2 != null) {
        if (actual1.item.compareTo(actual2.item) <= 0) {
            mergedList.insert(actual1.item);
            actual1 = actual1.next;
        } else {
            mergedList.insert(actual2.item);
            actual2 = actual2.next;
        }
    }

    while (actual1 != null) {
        mergedList.insert(actual1.item);
        actual1 = actual1.next;
    }

    while (actual2 != null) {
        mergedList.insert(actual2.item);
        actual2 = actual2.next;
    }

    return mergedList;
    }

    public static void mergeSort(ListaDoble list) {
    if (list.head == null || list.head.next == null) {
        return;
    }

    ListaDoble[] splitLists = list.split();
    mergeSort(splitLists[0]);
    mergeSort(splitLists[1]);

    list.head = merge(splitLists[0], splitLists[1]).head;
    }
}
