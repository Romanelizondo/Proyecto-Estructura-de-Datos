/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnviaPack;

/**
 *
 * @author camad
 */
public class ArbolDestinos {
    private NodoArbol raiz;

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void insertar(Paquete p) {

        if (raiz == null) {
            raiz = new NodoArbol(p.getDestino());
            raiz.getLista().insertar(p);
        } else {
            insertarRec(raiz, p);
        }
    }

    private void insertarRec(NodoArbol nodo, Paquete p) {

        if (p.getDestino().compareToIgnoreCase(nodo.getDestino()) < 0) {

            if (nodo.getIzquierda() == null) {
                NodoArbol nuevo = new NodoArbol(p.getDestino());
                nuevo.getLista().insertar(p);
                nodo.setIzquierda(nuevo);
            } else {
                insertarRec(nodo.getIzquierda(), p);
            }

        } else if (p.getDestino().compareToIgnoreCase(nodo.getDestino()) > 0) {

            if (nodo.getDerecha() == null) {
                NodoArbol nuevo = new NodoArbol(p.getDestino());
                nuevo.getLista().insertar(p);
                nodo.setDerecha(nuevo);
            } else {
                insertarRec(nodo.getDerecha(), p);
            }

        } else {
            nodo.getLista().insertar(p);
        }
    }

    public void mostrarClasificacion(NodoArbol nodo) {
        if (nodo != null) {
            mostrarClasificacion(nodo.getIzquierda());

            System.out.println("Ciudad: " + nodo.getDestino());
            nodo.getLista().mostrar();

            mostrarClasificacion(nodo.getDerecha());
        }
    }
    
}
