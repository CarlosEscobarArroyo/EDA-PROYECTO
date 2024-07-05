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
        Encargados usuario1= new Encargados("Billy", 4325);
        Encargados usuario2= new Encargados("Jose", 2346);
        Encargados usuario3= new Encargados("Nina", 1231);
        Encargados usuario4= new Encargados("Hanco", 2342);
        encargados.agregar(usuario1);
        encargados.agregar(usuario2);
        encargados.agregar(usuario3);
        encargados.agregar(usuario4);
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
