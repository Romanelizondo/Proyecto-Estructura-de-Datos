
package EnviaPack;
// repoitorio

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Principal {
    static ListaPaquetes lista = new ListaPaquetes();
    static PilaDinamica pila = new PilaDinamica();
    static ColaPaquetes cola = new ColaPaquetes();
    static ArbolDestinos arbol = new ArbolDestinos();
    static ListaGuias guias = new ListaGuias();
    static ListaDistribucion distribucion = new ListaDistribucion();
    
    public static void main(String[] args) {
        Vista.ControlVista control = new Vista.ControlVista(lista, pila, cola, arbol, guias, distribucion);
        
    }
    
    public static void generarGuiasDesdeArbol(NodoArbol nodo, ListaGuias guias) {
        if (nodo != null) {
            generarGuiasDesdeArbol(nodo.getIzquierda(), guias);

            Nodo aux = nodo.getLista().getInicio();
            while (aux != null) {
                if(!aux.getDato().isTieneGuia()){
                    guias.generarDesdePaquete(aux.getDato());
                    aux.getDato().setTieneGuia(true);
                }
                aux = aux.getSiguiente();
            }
            generarGuiasDesdeArbol(nodo.getDerecha(), guias);
        }
    }
}
    

    

