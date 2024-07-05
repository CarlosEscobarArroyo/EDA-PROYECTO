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
public class GestionDependencia {
    private Lista<Dependencia> dependencias;
    private Cola<Expediente> expedientes;
    //HOLA
    public GestionDependencia() {
        this.dependencias=new Lista<>();
        this.expedientes=new Cola<>();
        Dependencia dependencia1=new Dependencia("DCG", "Gerente de DUSAR");
        Dependencia dependencia2=new Dependencia("EDA", "Gerente de TRAMITES");
        dependencias.agregar(dependencia1);
        dependencias.agregar(dependencia2);
        
        Prioridad prioridad2=new Prioridad("Media");    
        Prioridad prioridad=new Prioridad("Alta");    

        Interesado interesado=new Interesado("Juan", 42,98982349, "av@gmail.com");        
        Interesado interesado2=new Interesado("Jose", 43,89893448, "df@gmail.com");
        
        Expediente expediente1=new Expediente(prioridad, "Notas", interesado2,"DCG");
        dependencia1.agregarExpediente(expediente1); 
        Expediente expediente2=new Expediente(prioridad2, "Carné", interesado,"EDA");
        dependencia2.agregarExpediente(expediente2);
       
    }

    public Lista<Dependencia> getDependencias() {
        return dependencias;
    }

    public void setDependencias(Lista<Dependencia> dependencias) {
        this.dependencias = dependencias;
    }
    
    public void AñadirDependencia(Dependencia dependencia){
        dependencias.agregar(dependencia);
    }
    
    public Dependencia buscarDependenciaPorNombre(String nombre) {
        Dependencia dependenciaAux = dependencias.buscarPorNombre(nombre);
        return dependenciaAux;
    }
 
    public boolean moverExpediente(int idExpediente, String NombreDependenciaOrigen, String NombreDependenciaDestino) {
        Dependencia dependenciaOrigen = buscarDependenciaPorNombre(NombreDependenciaOrigen);
        Dependencia dependenciaDestino = buscarDependenciaPorNombre(NombreDependenciaDestino);

        Expediente expediente = dependenciaOrigen.removerExpediente(idExpediente);
        if (expediente != null) {
            expediente.setDependenciaActual(NombreDependenciaDestino);
            dependenciaDestino.agregarExpediente(expediente);
            return true;
        }
        return false; 
    }
    public Cola<Expediente> obtenerHistorialCompleto() {
        Cola<Expediente> historialCompleto = new Cola<>();
        int n= dependencias.longitud();
        for (int i = 1; i <= n; i++) {
            Cola<Expediente> colaExpedientes = dependencias.iesimo(i).getColaExpedientes();
            Cola<Expediente> tempCola = new Cola<>();
            while (!colaExpedientes.esVacia()) {
                Expediente expediente = colaExpedientes.desencolar();
                historialCompleto.encolar(expediente);
                tempCola.encolar(expediente);
            }
            while (!tempCola.esVacia()) {
                colaExpedientes.encolar(tempCola.desencolar());
            }
        }
        return historialCompleto;
    }  
}
