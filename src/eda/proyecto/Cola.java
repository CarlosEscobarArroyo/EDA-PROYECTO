/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

/**
 *
 * @author Usuario
 */
public class Cola<T> {
    private Nodo<T> cabeza;
    private Nodo<T> ultimo;
    
    public Cola(){
        cabeza = null;
        ultimo = null;
    }
    
    public boolean estaVacia(){
        if(cabeza == null){
            return true;
        }
        else{
            return false;
        }
    }
    public void encolar(T elemento){
        Nodo<T> nuevoNodo = new Nodo(elemento,null);
        if(estaVacia()){
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
        }
        else{
            Nodo<T> aux = cabeza;
            while(aux.getSgteNodo() != null){
                aux=aux.getSgteNodo();
            }
            aux.setSgteNodo(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }
    public void desencolar(){
        cabeza = cabeza.getSgteNodo();
    }
    public Integer longitud(){
        Integer n = 0;
        Nodo<T> aux = cabeza;
        while(aux != null){
            aux=aux.getSgteNodo();
            n++;
        }
        return n;
    }
    public void mostar(){
        if(estaVacia()){
            System.out.println("No existe cola");
        }
        else{
            Nodo<T> aux = cabeza;
            while(aux != null){
                System.out.print("  " + aux.getElemento());
                aux=aux.getSgteNodo();
            }
            System.out.println();
        }
    }
}
