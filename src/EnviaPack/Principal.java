
package EnviaPack;
// repoitorio

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Principal {

    public static void main(String[] args) {

        ListaPaquetes lista = new ListaPaquetes();
        PilaDinamica pila = new PilaDinamica();
        ColaPaquetes cola = new ColaPaquetes();
        ArbolDestinos arbol = new ArbolDestinos();
        ListaGuias guias = new ListaGuias();
        ListaDistribucion distribucion = new ListaDistribucion();
        
        Vista.ControlVista control = new Vista.ControlVista(lista, pila, cola, arbol, guias, distribucion);
        
    }
    
    public static void generarGuiasDesdeArbol(NodoArbol nodo, ListaGuias guias) {
        if (nodo != null) {

            generarGuiasDesdeArbol(nodo.getIzquierda(), guias);

            Nodo aux = nodo.getLista().getInicio();
            while (aux != null) {
                guias.generarDesdePaquete(aux.getDato());
                aux = aux.getSiguiente();
            }

            generarGuiasDesdeArbol(nodo.getDerecha(), guias);
        }
    }
}
    

    

