/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import tda.Cola;
import modelos.*;


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
   
    //Ordenar Cola por prioridad
    public static Cola<Expediente> bubblesortPrioridad(Cola<Expediente> expedientes){
        int n = expedientes.longitud();
        Expediente[] arregloDeExpedientes = new Expediente[n];

         // Convertir la cola en un array
         for (int i = 0; i < n; i++) {
             arregloDeExpedientes[i] = expedientes.desencolar();
         }

         //Ordenamiento burbuja


        for (int i = 0; i < n - 1; i++) {
             for (int j = 0; j < n - i - 1; j++) {
                 if (Prioridad.obtenerValorPrioridad(arregloDeExpedientes[j].getPrioridad2().getPrioridad())> 
                         Prioridad.obtenerValorPrioridad(arregloDeExpedientes[j+1].getPrioridad2().getPrioridad())) {
                         // intercambiar arregloDeExpedientes[j] y arregloDeExpedientes[j+1]
                         Expediente temp = arregloDeExpedientes[j];
                         arregloDeExpedientes[j] = arregloDeExpedientes[j + 1];
                         arregloDeExpedientes[j + 1] = temp;
                         }
             }
         }

         // Volver a llenar la cola con los elementos ordenados
         for (Expediente exp : arregloDeExpedientes) {
             expedientes.encolar(exp);
         }

         //Volver a encolar
         for (int i = 0; i < n; i++) {
             Expediente exp = expedientes.desencolar();
             expedientes.encolar(exp);
         }
         return expedientes;
     }


    //Ordenar cola por Orden de llegada
    public static Cola<Expediente> bubblesortOrdenDeLlegada(Cola<Expediente> expedientes){
           int n = expedientes.longitud();
           Expediente[] arregloDeExpedientes = new Expediente[n];

            // Convertir la cola en un array
            for (int i = 0; i < n; i++) {
                arregloDeExpedientes[i] = expedientes.desencolar();
            }

            //Ordenamiento burbuja


           for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arregloDeExpedientes[j].getNumExpediente()> arregloDeExpedientes[j+1].getNumExpediente()) {
                            // intercambiar arregloDeExpedientes[j] y arregloDeExpedientes[j+1]
                            Expediente temp = arregloDeExpedientes[j];
                            arregloDeExpedientes[j] = arregloDeExpedientes[j + 1];
                            arregloDeExpedientes[j + 1] = temp;
                            }
                }
            }

            // Volver a llenar la cola con los elementos ordenados
            for (Expediente exp : arregloDeExpedientes) {
                expedientes.encolar(exp);
            }

            //Volver a encolar
            for (int i = 0; i < n; i++) {
                Expediente exp = expedientes.desencolar();
                expedientes.encolar(exp);
            }
            return expedientes;
        }
}
