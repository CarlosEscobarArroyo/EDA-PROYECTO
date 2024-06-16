/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import tda.*;
import modelos.*;

/**
 *
 * @author brina
 */
public class GestionInteresado {
    private Lista<Interesado> interesados;
    public GestionInteresado(){
        this.interesados=new Lista<>();
        Interesado interesado1=new Interesado("Alonso", "Almerco", 10, 101010);
        Interesado interesado2=new Interesado("abc", "de", 11, 1123);
        Interesado interesado3=new Interesado("abcd", "def", 12, 234);        
        interesados.agregar(interesado1);
        interesados.agregar(interesado2);
        interesados.agregar(interesado3);
    }
    public void Insertar(Interesado interesado){
        interesados.agregar(interesado);
    
    } 

    public Lista<Interesado> getInteresados() {
        return interesados;
    }

    public void setInteresados(Lista<Interesado> interesados) {
        this.interesados = interesados;
    }
    
    
}
