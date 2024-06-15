package modelos;

/**
 *
 * @author brina
 */     
public class Administrador extends Usuario {
    private Integer codigoAdministrador;
    private String password;

    public Administrador(Integer codigoAdministrador, String password, String nombre, String apellido, Integer edad, Integer dni) {
        super(nombre, apellido, edad, dni);
        this.codigoAdministrador = codigoAdministrador;
        this.password = password;
    }

    public Administrador(String nombre, String apellido, Integer edad, Integer dni) {
        super(nombre, apellido, edad, dni);
    }
    
    public Integer getCodigoAdministrador() {
        return codigoAdministrador;
    }

    public void setCodigoAdministrador(Integer codigoAdministrador) {
        this.codigoAdministrador = codigoAdministrador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    

    
    
}
