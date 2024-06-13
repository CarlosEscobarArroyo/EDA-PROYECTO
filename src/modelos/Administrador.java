package modelos;

/**
 *
 * @author brina
 */     
public class Administrador extends Usuario {
    private Integer codigoAdministrador;

    public Administrador(Integer codigoAdministrador, String nombre, Integer edad, Integer dni) {
        super(nombre, edad, dni);
        this.codigoAdministrador = codigoAdministrador;
    }

    public Integer getCodigoAdministrador() {
        return codigoAdministrador;
    }

    public void setCodigoAdministrador(Integer codigoAdministrador) {
        this.codigoAdministrador = codigoAdministrador;
    }
    
}
