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
    Lista<Dependencia> dependencias;
    //HOLA
    public GestionDependencia() {
        this.dependencias=new Lista<>();
        Dependencia dependencia1=new Dependencia("DUSAR", "Gerente de DUSAR");
        Dependencia dependencia2=new Dependencia("TRAMITES", "Gerente de TRAMITES");
        dependencias.agregar(dependencia1);
        dependencias.agregar(dependencia2);
    
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
            dependenciaDestino.agregarExpediente(expediente);
            return true;
        }
        return false; 
    }
    
    
}
