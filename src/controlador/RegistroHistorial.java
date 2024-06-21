
package controlador;
import tda.*;
import modelos.*;

public class RegistroHistorial {
    Lista<historico> regHistoria;
    
    public RegistroHistorial(){
        this.regHistoria=new Lista<>();
    }
    
    public void agregarHistorial(historico element){
        regHistoria.agregar(element);
    }

    public Lista<historico> getRegHistoria() {
        return regHistoria;
    }

    public void setRegHistoria(Lista<historico> regHistoria) {
        this.regHistoria = regHistoria;
    }
}
