/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;

import modelos.Expediente;
import modelos.Prioridad;

/**
 *
 * @author ASUS
 */
public class Cola<T> {


    private Nodo<T> frente;
    private Nodo<T> ultimo;


    public Cola() {
        frente = null;
        ultimo = null;
    }


    public boolean esVacia() {
        if (frente == null) {
            return true;
        } else {
            return false;
        }
    }


    public void encolar(T pElemento) {
        if (esVacia() == true) {
            Nodo<T> nuevoNodo = new Nodo(pElemento, null);
            frente = nuevoNodo;
            ultimo = nuevoNodo;
        } else { 
            Nodo<T> nuevoNodo = new Nodo(pElemento, null);
            ultimo.setSgteNodo(nuevoNodo);
            ultimo = nuevoNodo;

        }
    }


    public T desencolar() {
        if (esVacia() == false) {
            T x = frente.getElemento();
            Nodo<T> aux = frente;
            frente = aux.getSgteNodo();
            return x;
        } else {
            throw new RuntimeException("ERROR...");
        }
    }

    public T frente() {
        if (!esVacia()) {
            return frente.getElemento();
        } else {
            throw new RuntimeException("ERROR...");
        }
    }

    public int longitud() {
        int i = 0;
        Nodo<T> aux = frente;
        while (aux != null) {
            aux = aux.getSgteNodo();
            i++;
        }
        return i;
    }
    

}
    

