/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
import java.time.Duration;
import java.time.LocalTime;
import tda.Lista;

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
    private static int contador=001;
    private String dependenciaActual;
    private String estado;
    private Lista<String> dependenciasRecorridas;
    private LocalTime horaFinalizada;
    
    public Expediente(Prioridad prioridad2, String documento, Interesado interesado, String dependenciaActual){
        this.numExpediente=contador++;                
        this.prioridad2=prioridad2;
        this.documento=documento;
        this.interesado=interesado;
        this.tiempoExpediente=LocalTime.now();    
        this.dependenciaActual=dependenciaActual;
        this.estado="En proceso";
        this.dependenciasRecorridas=new Lista<>();
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public Lista<String> getDependenciasRecorridas() {
        return dependenciasRecorridas;
    }

    public void setDependenciasRecorridas(Lista<String> dependenciasRecorridas) {
        this.dependenciasRecorridas = dependenciasRecorridas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }

    public String getDependenciaActual() {
        return dependenciaActual;
    }

    public void setDependenciaActual(String dependenciaActual) {
        if (!this.dependenciaActual.equals(dependenciaActual)) {
            //this.dependenciasRecorridas.agregar(this.dependenciaActual); // Añadir la dependencia actual a la lista
            this.dependenciaActual = dependenciaActual;
        }
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

    public LocalTime getHoraFinalizada() {
        return horaFinalizada;
    }

    public void setHoraFinalizada(LocalTime horaFinalizada) {
        this.horaFinalizada = horaFinalizada;
    }
    
    public static int obtenerValorPrioridad(String prioridad2) {
        switch (prioridad2) {
            case "Alta":
                return 1;
            case "Media":
                return 2;
            case "Baja":
                return 3;
            default:
                throw new IllegalArgumentException("Prioridad no válida: " + prioridad2);
        }
    
    }
    
    public void agregarDependenciaRecorrida(String nombreDependenciaRecorrida) {
        System.out.println("Dependencia Agregada Al Recorrido");
        dependenciasRecorridas.agregar(nombreDependenciaRecorrida);
    }
    public boolean VerificarTiempoExpediente() {
        if (this.prioridad2.getPrioridad().equals("Alta")) {
            Duration duration = Duration.between(this.tiempoExpediente, LocalTime.now());
            return duration.getSeconds() == 20;
        }
        return false;
    }

    

}
