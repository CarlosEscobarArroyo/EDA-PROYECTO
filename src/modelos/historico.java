
package modelos;

import java.time.LocalTime;

public class historico {
    //por expediente
    private int numExpediente;
    private Prioridad prioridad;
    private String documento;
    private Usuario user;
    private LocalTime tiempoExpediente;
    //por dependencia
    private String nombre;
    private String encargado;
    
    public historico(int NumExpediente,Prioridad PRioridad,String doc,Usuario User,LocalTime TiempoExpediente,String nDependencia,String encargDependencia){
        this.numExpediente=NumExpediente;
        this.prioridad=PRioridad;
        this.documento=doc;
        this.user=User;
        this.tiempoExpediente=TiempoExpediente;
        this.nombre=nDependencia;
        this.encargado=encargDependencia;
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
    
}
