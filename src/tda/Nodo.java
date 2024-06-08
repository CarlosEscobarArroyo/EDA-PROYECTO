/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;

/**
 *
 * @author ASUS
 */
public class Nodo<T> {
    
    private T elemento;
    private Nodo sgteNodo;
    
    public Nodo(){
        elemento = null;
        sgteNodo = null;
    }
    
    public Nodo(T pElemento, Nodo pSgteNodo){
        elemento = pElemento;
        sgteNodo = pSgteNodo;
    }
    
    public void setElemento(T pElemento){
        elemento = pElemento;
    }
    public T getElemento(){
        return elemento;
    }
    public void setSgteNodo(Nodo pSgteNodo){
        sgteNodo = pSgteNodo;
    }
    public Nodo getSgteNodo(){
        return sgteNodo;
    }
}
