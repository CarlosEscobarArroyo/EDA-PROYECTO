
package controlador;
import tda.*;
import modelos.*;
/**
 *
 * @author Alonso
 */
public class RegistroExpediente {
    Cola<Expediente> expedientes;
    
    RegistroExpediente(){
        this.expedientes= new Cola<>();
        Interesado interesado=new Interesado("Alonso", "Almerc", 20, 12312);
        Prioridad prioridad=new Prioridad("alta");
        
        Expediente expediente1=new Expediente(0, prioridad, "foto", interesado);
        
        expedientes.encolar(expediente1);
    }
    public void agregarEXpediente(Expediente expediente){
        expedientes.encolar(expediente);        
    }
    
    
}
