/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnviaPack;

/**
 *
 * @author camad
 */
public class NodoDistribucion {
    
    private Distribucion dato;
    private NodoDistribucion siguiente;
    
    public NodoDistribucion(){
        this.siguiente = null;
                
    }

    public Distribucion getDato() {
        return dato;
    }

    public void setDato(Distribucion dato) {
        this.dato = dato;
    }

    public NodoDistribucion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDistribucion siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
