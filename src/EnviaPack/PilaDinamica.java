/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnviaPack;

/**
 *
 * @author camad
 */
public class PilaDinamica {
     Nodo cima;

    public PilaDinamica() {
        this.cima = null;
    }

    public void push(Paquete dato) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(dato);
        nuevo.setSiguiente(cima);
        cima = nuevo;
    }

    public Paquete pop() {
        if (cima == null) {
            System.out.println("Error: Pila vacia");
            return null;
        }

        Paquete dato = cima.getDato();
        cima = cima.getSiguiente();
        return dato;
    }

    public void mostrar() {
        Nodo aux = cima;

        if (cima == null) {
            System.out.println("Pila vacia");
            return;
        }

        while (aux != null) {
            System.out.println("Descripcion: " + aux.getDato().getDescripcion());
            aux = aux.getSiguiente();
        }
    }

    public Nodo getCima() {
        return cima;
    }
    
}
