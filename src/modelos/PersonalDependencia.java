/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author brina
 */
public class PersonalDependencia extends Usuario {
    private Dependencia dependencia;

    public PersonalDependencia(Dependencia dependencia, String nombre, String apellido, Integer edad, Integer dni) {
        super(nombre, apellido, edad, dni);
        this.dependencia = dependencia;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }
    
    
}