/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelos.Usuario;
import tda.Lista;

/**
 *
 * @author brina
 */
public class GestionUsuario {
    private Lista<Usuario> usuarios;

    public GestionUsuario() {
        this.usuarios=new Lista<>();
        Usuario usuario1= new Usuario("Alonso", 4325);
        Usuario usuario2= new Usuario("Carlos", 2346);
        Usuario usuario3= new Usuario("Sabrina", 1231);
        Usuario usuario4= new Usuario("Giomar", 2342);
        usuarios.agregar(usuario1);
        usuarios.agregar(usuario2);
        usuarios.agregar(usuario3);
        usuarios.agregar(usuario4);
    }

    public Lista<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Lista<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void agregar(Usuario usuarios){
        this.usuarios.agregar(usuarios);
    }
    
    public Usuario buscarUsuario(String nombreUsuario) {
        Usuario usuarioAux = (Usuario) usuarios.buscarPorNombre(nombreUsuario);
        return usuarioAux;
    }
}
