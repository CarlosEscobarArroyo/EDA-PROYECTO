/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//PRUEBAAAA
package controlador;

import java.util.ArrayList;
import javax.accessibility.AccessibleState;
import modelos.*;
import tda.Lista;
import tda.Nodo;

/**
 *
 * @author brina
 */
public class GestionAdministrador {
    private Lista<Administrador> administradores;

    public GestionAdministrador() {
       this.administradores = new Lista<>();
       Administrador admin1 = new Administrador(20224307, "password", "Carlos", "Escobar", 71291853);
       Administrador admin2 = new Administrador(20223087, "password", "Alonso", "Almerco", 1291212);
       Administrador admin3 = new Administrador(20228741, "password", "Sabrina", "Sabrina", 9081272);
       administradores.agregar(admin1);
       administradores.agregar(admin2);
       administradores.agregar(admin3);
    }
    
    public Lista<Administrador> getAdministradores() {
        return administradores;
    }
    
    
    public boolean login(Integer usuario, String password) {
        
        Administrador adminAux = administradores.buscarAdministrador(usuario);
        if (adminAux!=null) {
            if (adminAux.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
     //Insertar
    
    public void Insertar(Administrador admin){
        administradores.agregar(admin);
    
    }
    
//    //Buscar
//    public Administrador buscar(int id) {
//
//    }
//
//    
//    //Remover
//    public void Remover(int id) {
// 
//    }
    
    
}
