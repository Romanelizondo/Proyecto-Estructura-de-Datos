/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnviaPack;

/**
 *
 * @author roman
 */
public class NodoArbol {
    private String ciudad;
    private ListaPaquetes paquetes; // Lista simple dentro del nodo
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    public NodoArbol(String ciudad) {
        this.ciudad = ciudad;
        this.paquetes = new ListaPaquetes();
        this.izquierdo = null;
        this.derecho = null;
    }

    // Getters y Setters
    public String getCiudad(){ 
        return ciudad; 
    }
    public ListaPaquetes getPaquetes(){ 
        return paquetes; 
    }
    public NodoArbol getIzquierdo(){ 
        return izquierdo; 
    }
    public void setIzquierdo(NodoArbol izq){ 
        this.izquierdo = izq; 
    }
    public NodoArbol getDerecho(){ 
        return derecho; 
    }
    public void setDerecho(NodoArbol der){ 
        this.derecho = der; 
    }
}
