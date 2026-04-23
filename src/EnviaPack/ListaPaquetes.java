/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnviaPack;

/**
 *
 * @author camad
 */
public class ListaPaquetes {
     private Nodo inicio;

    public ListaPaquetes() {
        this.inicio = null;
    }

    public boolean vacia() {
        return inicio == null;
    }

    public void insertar(Paquete p) {

        Nodo nuevo = new Nodo();
        nuevo.setDato(p);

        if (vacia()) {
            inicio = nuevo;

        } else {
            Nodo aux = inicio;

            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }

            aux.setSiguiente(nuevo);
        }

        System.out.println("Paquete agregado correctamente");
    }

    public void mostrar() {
        Nodo aux = inicio;

        if (!vacia()) {
            while (aux != null) {
                System.out.println("Descripcion: " + aux.getDato().getDescripcion());
                System.out.println("Tipo envio: " + aux.getDato().getTipoEnvio());
                System.out.println("Peso: " + aux.getDato().getPeso());
                System.out.println("----------------------");

                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("Lista vacia");
        }
    }

    public Nodo getInicio() {
        return inicio;
    }
    
}
