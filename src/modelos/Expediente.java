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
    private Usuario user;
    private LocalTime tiempoExpediente;
    private static int contador=0;
    private String dependenciaActual;
    public Expediente(Prioridad prioridad2, String documento, Usuario user, String dependenciaActual){
        this.numExpediente=contador++;                
        this.prioridad2=prioridad2;
        this.documento=documento;
        this.user=user;
        this.tiempoExpediente=LocalTime.now();    
        this.dependenciaActual=dependenciaActual;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Expediente.contador = contador;
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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public LocalTime getTiempoExpediente() {
        return tiempoExpediente;
    }

    public void setTiempoExpediente(LocalTime tiempoExpediente) {
        this.tiempoExpediente = tiempoExpediente;
    }  
}
