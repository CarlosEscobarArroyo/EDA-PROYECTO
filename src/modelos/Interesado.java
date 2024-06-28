/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Alonso
 */
public class Interesado extends Usuario{
    private String email;
    private int telefono;
    public Interesado(String nombre, Integer dni,int telefono, String email) {
        super(nombre,dni);
        this.email=email;        
        this.telefono=telefono;
    }
    
}
