/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;

/**
 *
 * @author ASUS
 */
public class Pila<T> {

    private Nodo<T> top;

    public Pila() { 
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T elemento) {
        Nodo<T> nuevoNodo = new Nodo(elemento, null);
        if (isEmpty()) {
            top = nuevoNodo;
        } else { 
            nuevoNodo.setSgteNodo(top);
            top = nuevoNodo;
        }
    }


    public T pop() {
        if (!isEmpty()) {
            T elemento = top.getElemento();
            top = top.getSgteNodo();
            return elemento;
        } else {
            throw new RuntimeException("ERROR...");
        }

    }

    public T top() {
        if (!isEmpty()) {
            return top.getElemento();
        } else {
            throw new RuntimeException("ERROR...");
        }
    }

    public int longitud() {
        int i = 0;
        Nodo<T> aux = top;
        while (aux != null) {
            aux = aux.getSgteNodo();
            i++;
        }
        return i;
    }
}
