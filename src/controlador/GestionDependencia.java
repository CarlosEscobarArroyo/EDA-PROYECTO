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

    public GestionDependencia() {
        this.dependencias=new Lista<>();
        Dependencia dependencia1=new Dependencia("DUSAR", "Gerente de DUSAR");
        Dependencia dependencia2=new Dependencia("ENVIO DE TRAMITE", "YO");
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
    
    public boolean moverExpediente(int idExpediente, int idDependenciaOrigen, int idDependenciaDestino) {
        if (idDependenciaOrigen < 0 || idDependenciaOrigen >= dependencias.size() ||
            idDependenciaDestino < 0 || idDependenciaDestino >= dependencias.size()) {
            return false; // IDs de dependencias no válidos
        }

        Dependencia dependenciaOrigen = dependencias.get(idDependenciaOrigen);
        Dependencia dependenciaDestino = dependencias.get(idDependenciaDestino);

        Expediente expediente = dependenciaOrigen.getColaExpedientes().remove(idExpediente);
        if (expediente != null) {
            dependenciaDestino.getColaExpedientes().enqueue(expediente);
            return true; // Movimiento exitoso
        }

        return false; // Expediente no encontrado
    }
    
}
