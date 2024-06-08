/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;
import modelo.Expediente;

/**
 *
 * @author ASUS
 */
public class NodoExpediente {
    
    private Expediente elemento;
    private Nodo sgteNodo;
    
    public NodoExpediente(){
        elemento = null;
        sgteNodo = null;
    }
    
    public NodoExpediente(Expediente pElemento, Nodo pSgteNodo){
        elemento = pElemento;
        sgteNodo = pSgteNodo;
    }
    
    public void setElemento(Expediente pElemento){
        elemento = pElemento;
    }
    public Expediente getElemento(){
        return elemento;
    }
    public void setSgteNodo(Nodo pSgteNodo){
        sgteNodo = pSgteNodo;
    }
    public Nodo getSgteNodo(){
        return sgteNodo;
    }
}

