
package controlador;
import tda.*;
import modelos.*;
/**
 *
 * @author Alonso
 */
public class RegistroExpediente {
    Cola<Expediente> expedientes;
    
    public RegistroExpediente(){
        this.expedientes= new Cola<>();
        Interesado interesado=new Interesado("Alonso", "Almerc", 10, 12312);
        Prioridad prioridad=new Prioridad("Alta");
        
        Interesado interesado2=new Interesado("Messi", "Cuccitini", 20, 1245);
        Prioridad prioridad2=new Prioridad("Media");    
        
        Expediente expediente1=new Expediente(prioridad, "pregrado", interesado);
        Expediente expediente2=new Expediente(prioridad2, "egresar", interesado2);                
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
