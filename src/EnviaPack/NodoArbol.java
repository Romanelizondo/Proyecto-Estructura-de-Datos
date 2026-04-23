/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnviaPack;

/**
 *
 * @author camad
 */
public class NodoArbol {
     String destino;
    private ListaPaquetes lista;
    private NodoArbol izquierda;
    private NodoArbol derecha;

    public NodoArbol(String destino) {
        this.destino = destino;
        this.lista = new ListaPaquetes();
        this.izquierda = null;
        this.derecha = null;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public ListaPaquetes getLista() {
        return lista;
    }

    public void setLista(ListaPaquetes lista) {
        this.lista = lista;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }
    
}
