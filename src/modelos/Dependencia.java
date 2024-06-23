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
    
}
