
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
        Expediente expediente1=new Expediente(0, "alta", "no sé", interesado);

    }
    
    
    
}
