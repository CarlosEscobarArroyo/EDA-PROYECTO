/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author n04613
 */


public class Prioridad {    
    
    private String prioridad;
    
    public Prioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    
    public static int obtenerValorPrioridad(String prioridad2) {
        switch (prioridad2) {
            case "Alta":
                return 3;
            case "Normal":
                return 2;
            case "Baja":
                return 1;
            default:
                throw new IllegalArgumentException("Prioridad no válida: " + prioridad2);
        }
    
    }
    
}
