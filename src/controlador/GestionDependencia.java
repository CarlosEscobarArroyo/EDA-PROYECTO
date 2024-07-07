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
        Encargados encargado1 = new Encargados("Encargado Admisión y Matrícula", 12345678, 987654321, "admision@universidad.edu");
        Encargados encargado2 = new Encargados("Encargado Finanzas Estudiantiles", 23456789, 876543210, "finanzas@universidad.edu");
        Encargados encargado3 = new Encargados("Encargado Registro Académico", 34567890, 765432109, "registro@universidad.edu");
        
        Dependencia admisionMatricula = new Dependencia("Admisión y Matrícula", encargado1.getNombre());
        Dependencia finanzasEstudiantiles = new Dependencia("Finanzas Estudiantiles", encargado2.getNombre());
        Dependencia registroAcademico = new Dependencia("Registro Académico", encargado3.getNombre());
        dependencias.agregar(admisionMatricula);
        dependencias.agregar(finanzasEstudiantiles);
        dependencias.agregar(registroAcademico);
        Interesado interesado1 = new Interesado("Juan Pérez", 11111111, 987654321, "juan.perez@correo.com");
        Interesado interesado2 = new Interesado("Ana Gómez", 22222222, 876543210, "ana.gomez@correo.com");
        Interesado interesado3 = new Interesado("Luis Martínez", 33333333, 765432109, "luis.martinez@correo.com");
        Interesado interesado4 = new Interesado("María Rodríguez", 44444444, 654321098, "maria.rodriguez@correo.com");
        Interesado interesado5 = new Interesado("Carlos Fernández", 55555555, 543210987, "carlos.fernandez@correo.com");
        Interesado interesado6 = new Interesado("Laura Sánchez", 66666666, 432109876, "laura.sanchez@correo.com");
        Interesado interesado7 = new Interesado("Miguel Torres", 77777777, 321098765, "miguel.torres@correo.com");
        Interesado interesado8 = new Interesado("Elena Díaz", 88888888, 210987654, "elena.diaz@correo.com");
        Interesado interesado9 = new Interesado("Jorge Ruiz", 99999999, 109876543, "jorge.ruiz@correo.com");
        Prioridad alta=new Prioridad("Alta");
        Prioridad media=new Prioridad("Media");
        Prioridad baja=new Prioridad("Baja");
        admisionMatricula.agregarExpediente(new Expediente(baja, "Tipo de Matrícula 1", interesado1, "Admisión y Matrícula"));
        admisionMatricula.agregarExpediente(new Expediente(media, "Tipo de Matrícula 2", interesado2, "Admisión y Matrícula"));
        admisionMatricula.agregarExpediente(new Expediente(baja, "Tipo de Matrícula 3", interesado3, "Admisión y Matrícula"));

        // Crear expedientes para Finanzas Estudiantiles
        finanzasEstudiantiles.agregarExpediente(new Expediente(media, "Tipo de Matrícula 4", interesado4, "Finanzas Estudiantiles"));
        finanzasEstudiantiles.agregarExpediente(new Expediente(baja, "Tipo de Matrícula 5", interesado5, "Finanzas Estudiantiles"));
        finanzasEstudiantiles.agregarExpediente(new Expediente(baja, "Tipo de Matrícula 6", interesado6, "Finanzas Estudiantiles"));

        // Crear expedientes para Registro Académico
        registroAcademico.agregarExpediente(new Expediente(media, "Tipo de Matrícula 7", interesado7, "Registro Académico"));
        registroAcademico.agregarExpediente(new Expediente(baja, "Tipo de Matrícula 8", interesado8, "Registro Académico"));
        registroAcademico.agregarExpediente(new Expediente(alta, "Tipo de Matrícula 9", interesado9, "Registro Académico"));    
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
    
    public Cola<Expediente> obtenerHistorialFinalizados() {
        Cola<Expediente> historialFinalizados = new Cola<>();
        int n = dependencias.longitud();
        for (int i = 1; i <= n; i++) {
            Cola<Expediente> colaExpedientesFinalizados = dependencias.iesimo(i).getColaExpedientesFinalizados();
            Cola<Expediente> tempCola = new Cola<>();
            while (!colaExpedientesFinalizados.esVacia()) {
                Expediente expediente = colaExpedientesFinalizados.desencolar();
                historialFinalizados.encolar(expediente);
                tempCola.encolar(expediente);
            }
            while (!tempCola.esVacia()) {
                colaExpedientesFinalizados.encolar(tempCola.desencolar());
            }
        }
        return historialFinalizados;
    }    
}
