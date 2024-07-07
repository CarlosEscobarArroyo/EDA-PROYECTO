/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelos.Encargados;
import tda.Lista;

/**
 *
 * @author brina
 */
public class GestionPersonal {
    private Lista<Encargados> encargados;

    public GestionPersonal() {
        this.encargados=new Lista<>();
        Encargados encargado1 = new Encargados("Encargado Admisión y Matrícula", 12345678, 987654321, "admision@universidad.edu");
        Encargados encargado2 = new Encargados("Encargado Finanzas Estudiantiles", 23456789, 876543210, "finanzas@universidad.edu");
        Encargados encargado3 = new Encargados("Encargado Registro Académico", 34567890, 765432109, "registro@universidad.edu");
        
        encargados.agregar(encargado1);
        encargados.agregar(encargado2);
        encargados.agregar(encargado3);
    }

    public Lista<Encargados> getEncargados() {
        return encargados;
    }

    public void setEncargados(Lista<Encargados> encargados) {
        this.encargados = encargados;
    }

    
    public void agregar(Encargados encargados){
        this.encargados.agregar(encargados);
    }
    
    public Encargados buscarUsuario(String nombreUsuario) {
        Encargados usuarioAux = (Encargados) encargados.buscarPorNombre(nombreUsuario);
        return usuarioAux;
    }
}
