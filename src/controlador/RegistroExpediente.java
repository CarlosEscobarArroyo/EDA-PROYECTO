
package controlador;
import tda.*;
import modelos.*;
/**
 *
 * @author Alonso
 */
public class RegistroExpediente {
    private Cola<Expediente> expedientes;
    //ESTÁ EN PRUEBAAAAAAAAAAAAAAAAAAAAAAA
    //EL METODO AÑADIR EXPEDIENTE ESTÁ EN LA CLASE DEPENDENCIA
    public RegistroExpediente(){
        this.expedientes= new Cola<>();
        Interesado interesado=new Interesado("alonso", 42,98989, "sx");
        Prioridad prioridad=new Prioridad("Alta");
        
        Interesado interesado2=new Interesado("messi", 43,89898, "df");
        Prioridad prioridad2=new Prioridad("Media");    
        
        Expediente expediente1=new Expediente(prioridad, "pregrado", interesado,"DUSAR");
        Expediente expediente2=new Expediente(prioridad2, "egresar", interesado2,"DUSAR");                
        expedientes.encolar(expediente1);        
        expedientes.encolar(expediente2);
    }
    //ESTÁ EN PRUEBAAAAAAAAAAAAAAAAAAAAAAA
    //EL METODO AÑADIR EXPEDIENTE ESTÁ EN LA CLASE DEPENDENCIA
    public void agregarEXpediente(Expediente expediente){
        expedientes.encolar(expediente);        
    } 
    //ESTÁ EN PRUEBAAAAAAAAAAAAAAAAAAAAAAA
    //EL METODO AÑADIR EXPEDIENTE ESTÁ EN LA CLASE DEPENDENCIA
    public Cola<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(Cola<Expediente> expedientes) {
        this.expedientes = expedientes;
    }
    
    
    
}
