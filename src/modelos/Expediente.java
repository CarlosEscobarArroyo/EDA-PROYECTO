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
    private int numExpediente;
    private Prioridad prioridad;
    private String documento;
    private Usuario user;
    private LocalTime tiempoExpediente;
    
    public Expediente(int numExpediente, Prioridad pioridad, String documento, Usuario user){
        this.numExpediente=numExpediente;
        this.prioridad=prioridad;
        this.documento=documento;
        this.user=user;
        this.tiempoExpediente=LocalTime.now();    
    }

    public int getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(int numExpediente) {
        this.numExpediente = numExpediente;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
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
