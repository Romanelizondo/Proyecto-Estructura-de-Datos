/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnviaPack;

/**
 *
 * @author roman
 */
public class ArbolDestinos {
    private NodoArbol raiz;

    public ArbolDestinos() {
        this.raiz = null;
    }

    public void insertar(Paquete p) {
        raiz = insertarRecursivo(raiz, p.getDestino(), p);
    }

    private NodoArbol insertarRecursivo(NodoArbol actual, String ciudadDestino, Paquete p) {
        //Si el lugar está vacío, creamos el nodo de la ciudad
        if (actual == null) {
            NodoArbol nuevo = new NodoArbol(ciudadDestino);
            nuevo.getPaquetes().insertar(p); // Insertamos el paquete en la lista simple del nodo
            return nuevo;
        }

        // Comparación alfabética para organizar el árbol
        if (ciudadDestino.compareToIgnoreCase(actual.getCiudad()) < 0) {
            // Si el destino es menor (Alajuela < Heredia), va a la izquierda
            actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), ciudadDestino, p));
        } else if (ciudadDestino.compareToIgnoreCase(actual.getCiudad()) > 0) {
            // Si el destino es mayor (San José > Heredia), va a la derecha
            actual.setDerecho(insertarRecursivo(actual.getDerecho(), ciudadDestino, p));
        } else {
            // Si la ciudad ya existe en el árbol, solo se añade el paquete a su lista simple
            actual.getPaquetes().insertar(p);
        }

        return actual;
    }

    
     //Método para mostrar los paquetes clasificados
     // muestra las ciudades en orden alfabético.
     
    public void mostrarClasificacion(NodoArbol nodo) {
        if (nodo != null) {
            mostrarClasificacion(nodo.getIzquierdo());
            
            System.out.println("------------------------------");
            System.out.println("Destino Final: " + nodo.getCiudad().toUpperCase());
            System.out.println("------------------------------");
            nodo.getPaquetes().mostrar(); // Llama mostrar() de la lista simple de esa ciudad
            
            mostrarClasificacion(nodo.getDerecho());
        }
    }

    public NodoArbol getRaiz() {
        return raiz;
    }
}
