/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelos.*;
import tda.Lista;

/**
 *
 * @author brina
 */
public class GestionAdministrador {
    private Lista<Administrador> administradores;
    private int nroRutas = 0;

    public GestionAdministrador() {
       this.administradores = new Lista<Administrador>();
    }
    
    public Lista<Administrador> getAdministradores() {
        return administradores;
    }
     //Insertar
    
    public void Insertar(Administrador admin){
        
    
    }
    
    //Buscar
    public Administrador buscar(int id) {
        return Administrador id;
    }

    
    //Remover
    public void Remover(int id) {
 
    }
    
    
}
