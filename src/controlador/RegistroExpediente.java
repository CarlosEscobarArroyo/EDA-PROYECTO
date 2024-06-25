
package controlador;
import tda.*;
import modelos.*;
/**
 *
 * @author Alonso
 */
public class RegistroExpediente {
    private Cola<Expediente> expedientes;
    
    public RegistroExpediente(){
        this.expedientes= new Cola<>();
        Interesado interesado=new Interesado("alonso", 42, "sx");
        Prioridad prioridad=new Prioridad("Alta");
        
        Interesado interesado2=new Interesado("messi", 43, "df");
        Prioridad prioridad2=new Prioridad("Media");    
        
        Expediente expediente1=new Expediente(prioridad, "pregrado", interesado,"DUSAR");
        Expediente expediente2=new Expediente(prioridad2, "egresar", interesado2,"DUSAR");                
        expedientes.encolar(expediente1);        
        expedientes.encolar(expediente2);
    }
    
    public void agregarEXpediente(Expediente expediente){
        expedientes.encolar(expediente);        
    } 

    public Cola<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(Cola<Expediente> expedientes) {
        this.expedientes = expedientes;
    }
    
    
    
}
