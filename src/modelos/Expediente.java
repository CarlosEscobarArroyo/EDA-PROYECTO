/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
import java.time.LocalTime;
/**
 *
 * @author n04613
 */
public class Expediente {
    private int numExpediente=0;
    private Prioridad prioridad2;
    private String documento;
    private Interesado interesado;
    private LocalTime tiempoExpediente;
    private static int contador=0;
    private String dependenciaActual;
    
    public Expediente(Prioridad prioridad2, String documento, Interesado interesado, String dependenciaActual){
        this.numExpediente=contador++;                
        this.prioridad2=prioridad2;
        this.documento=documento;
        this.interesado=interesado;
        this.tiempoExpediente=LocalTime.now();    
        this.dependenciaActual=dependenciaActual;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }

    public String getDependenciaActual() {
        return dependenciaActual;
    }

    public void setDependenciaActual(String dependenciaActual) {
        this.dependenciaActual = dependenciaActual;
    }

    public int getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(int numExpediente) {
        this.numExpediente = numExpediente;
    }

    public Prioridad getPrioridad2() {
        return prioridad2;
    }

    public void setPrioridad2(Prioridad prioridad) {
        this.prioridad2 = prioridad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalTime getTiempoExpediente() {
        return tiempoExpediente;
    }

    public void setTiempoExpediente(LocalTime tiempoExpediente) {
        this.tiempoExpediente = tiempoExpediente;
    }  
    
    public static int obtenerValorPrioridad(String prioridad2) {
        switch (prioridad2) {
            case "Alta":
                return 3;
            case "Media":
                return 2;
            case "Baja":
                return 1;
            default:
                throw new IllegalArgumentException("Prioridad no válida: " + prioridad2);
        }
    
    }
}
