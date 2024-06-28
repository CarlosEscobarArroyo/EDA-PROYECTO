/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;
import modelos.Administrador;
import modelos.Dependencia;

/**
 *
 * @author ASUS
 */
public class Lista<T> {
    
    private Nodo<T> cabeza;
    private Nodo<T> ultimo;
    
    public Lista() {
        cabeza = null;
        ultimo = null;
    }
    
    public boolean esVacia() {
        if (cabeza == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void agregar(T pElemento) {
        Nodo<T> nuevoNodo = new Nodo(pElemento, null);
        if (esVacia() == true) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSgteNodo(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }
    
    public void mostrar() {
        Nodo<T> aux = cabeza;
        while (aux != null) {
            System.out.print(aux.getElemento() + "\t");
            aux = aux.getSgteNodo();
        }
        System.out.println("");
    }
    
    public int longitud() {
        int num = 0;
        Nodo<T> aux = cabeza;
        while (aux != null) {
            num++;
            aux = aux.getSgteNodo();
        }
        return num;
    }
    
    public T iesimo(int pos) {
        T elemento = null;
        if (pos >= 1 && pos <= longitud()) {
            int i = 1;
            Nodo<T> aux = cabeza;
            while (i < pos) {
                i++;
                aux = aux.getSgteNodo();
            }
            elemento = aux.getElemento();
            return elemento;
        }
        return elemento;
    }
    
    public Integer ubicacion(T elemento) {
        Nodo<T> aux = cabeza;
        int i = 0;
        while (aux != null) {
            i++;
            if (aux.getElemento().equals(elemento)) {
                return i;
            }
            aux = aux.getSgteNodo();
        }
        return null;
    }
    
    public Administrador buscarAdministrador(int usuario) {
        Nodo<T> aux = cabeza;
        while (aux != null) {
            if (aux.getElemento() instanceof Administrador) {
                Administrador admin = (Administrador) aux.getElemento();
                if (admin.getCodigoAdministrador().equals(usuario)) {
                    return admin;
                }
            }
            aux = aux.getSgteNodo();
        }
        return null;
    }
    public T buscarPorNombre(String nombre) {
        Nodo<T> actual = cabeza;

        while (actual != null) {
            T dato = actual.getElemento();
            if (dato instanceof Dependencia) {
                Dependencia dependencia = (Dependencia) dato;
                if (dependencia.getNombre().equals(nombre)) {
                    return dato;
                }
            }
            actual = actual.getSgteNodo();
        }
        return null; 
    }

            
    public void eliminar(int pos) {
        if (pos >= 1 && pos <= longitud()) {
            if (pos == 1) {
                cabeza = cabeza.getSgteNodo();
            } else { 
                Nodo<T> aux = cabeza;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getSgteNodo();
                    i++;
                }
                Nodo<T> temp = aux.getSgteNodo();
                aux.setSgteNodo(temp.getSgteNodo());

            }
        }

    }
    
    public void eliminar(T elemento) {
        Integer pos = ubicacion(elemento);
        if (pos != null) {
            eliminar(pos);
        }
    }
    
    public void insertar(T elemento, int pos) {
        Nodo<T> nuevoNodo = new Nodo(elemento, null);
        if (pos >= 1 && pos <= longitud() + 1) {
            if (pos == 1) {
                nuevoNodo.setSgteNodo(cabeza);
                cabeza = nuevoNodo;
            } else {
                Nodo<T> aux = cabeza;
                int posActual = 1;
                while (posActual < pos - 1) {
                    aux = aux.getSgteNodo();
                    posActual++;
                }
                nuevoNodo.setSgteNodo(aux.getSgteNodo());
                aux.setSgteNodo(nuevoNodo);
            }
        }
    }
    
    public void insertarAlaDerecha(T elemento, int pos) {
        Nodo<T> nuevoNodo = new Nodo(elemento, null);
        if (pos >= 1 && pos <= longitud()) {
            if (pos == this.longitud()) {
                ultimo.setSgteNodo(nuevoNodo);
                ultimo = nuevoNodo;
            } else { 
                Nodo<T> aux = cabeza;
                int posActual = 1;
                while (posActual < pos) {
                    aux = aux.getSgteNodo();
                    posActual++;
                }
                nuevoNodo.setSgteNodo(aux.getSgteNodo());
                aux.setSgteNodo(nuevoNodo);
            }
        }
    }
    
    public void purgarDuplicados() {
        if (!esVacia()) {
            Nodo<T> aux = cabeza;
            while (aux != null) {
                Nodo<T> aux2 = aux;
                Nodo<T> ant = aux2;
                while (aux2.getSgteNodo() != null) {
                    aux2 = aux2.getSgteNodo();
                    if (aux.getElemento().equals(aux2.getElemento())) {
                        ant.setSgteNodo(aux2.getSgteNodo()); 
                    } else {
                        ant = aux2;
                    }
                }
                aux = aux.getSgteNodo();
            }

        } else {
            System.out.println("La lista esta vacia!!");
        }
    }
}
