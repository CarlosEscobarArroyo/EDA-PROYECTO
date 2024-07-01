/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import tda.Cola;

/**
 *
 * @author brina
 */
public class Dependencia {
    private String nombre;
    private String encargado;
    private Cola<Expediente> colaExpedientes;
    
    public Dependencia(String nombre, String encargado) {
        this.nombre = nombre;
        this.encargado = encargado;
        this.colaExpedientes = new Cola<>(); // Inicialización de la cola de expedientes
    }
    public Dependencia(){
        this.colaExpedientes= new Cola<>();
    }

    public Cola<Expediente> getColaExpedientes() {
        return colaExpedientes;
    }

    public void setColaExpedientes(Cola<Expediente> colaExpedientes) {
        this.colaExpedientes = colaExpedientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }
    public Expediente removerExpediente(int idExpediente) {
        Cola<Expediente> tempCola = new Cola<>();
        Expediente expedienteEncontrado = null;

        while (!colaExpedientes.esVacia()) {
            Expediente expediente = colaExpedientes.desencolar();
            if (expediente.getNumExpediente()== idExpediente) {
                expedienteEncontrado = expediente;
            } else {
                tempCola.encolar(expediente);
            }
        }

        while (!tempCola.esVacia()) {
            colaExpedientes.encolar(tempCola.desencolar());
        }
        return expedienteEncontrado;
    }
    public void agregarExpediente(Expediente expediente) {
        colaExpedientes.encolar(expediente);
    }
    
   public void actualizarExpediente(Expediente expedienteNuevo, int idExpedienteAntiguo) {
       Cola<Expediente> tempCola = new Cola<>();
       Expediente expedienteAntiguo = null;
        while (!colaExpedientes.esVacia()) {
            Expediente expediente = colaExpedientes.desencolar();
            if (expediente.getNumExpediente()== idExpedienteAntiguo) {
                expedienteAntiguo = expediente;
                tempCola.encolar(expediente);
            } else {
                tempCola.encolar(expediente);
            }
        } 
      
       Cola<Expediente> aux = new Cola();

        while (!this.colaExpedientes.esVacia()){
            Expediente x = this.colaExpedientes.desencolar();
            if (x == expedienteAntiguo)
                aux.encolar(expedienteNuevo);
            else
                aux.encolar(x);
        }
        while (!aux.esVacia()){
            this.colaExpedientes.encolar(aux.desencolar());
        }
        

    } 
    
}
