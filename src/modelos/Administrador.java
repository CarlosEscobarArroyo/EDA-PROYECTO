package modelos;

/**
 *
 * @author brina
 */     
public class Administrador {
    private Integer codigoAdministrador;
    private String password;
    private String nombre;
    private String apellido;
    private int dni;

    public Administrador(Integer codigoAdministrador, String password, String nombre, String apellido, int dni) {
        this.codigoAdministrador = codigoAdministrador;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    

    
    
    

    
    
}
