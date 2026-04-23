/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnviaPack;

/**
 *
 * @author camad
 */
public class ColaPaquetes {
    private Nodo frente;
    private Nodo fin;

    public ColaPaquetes() {
        this.frente = null;
        this.fin = null;
    }

    public boolean vacia() {
        return frente == null;
    }

    public void encolar(Paquete dato) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(dato);

        if (vacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public Paquete desencolar() {
        if (vacia()) {
            System.out.println("Cola vacia");
            return null;
        }

        Paquete dato = frente.getDato();
        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        return dato;
    }

    public void mostrar() {
        Nodo aux = frente;

        if (vacia()) {
            System.out.println("Cola vacia");
            return;
        }

        while (aux != null) {
            System.out.println("Descripcion: " + aux.getDato().getDescripcion());
            aux = aux.getSiguiente();
        }
    }

    public Nodo getFrente() {
        return frente;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }
    
    
    
}
