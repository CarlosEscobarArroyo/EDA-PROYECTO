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
    
    
    
}
