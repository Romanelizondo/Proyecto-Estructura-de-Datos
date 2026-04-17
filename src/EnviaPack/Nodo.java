
package EnviaPack;
// repoitorio
/**
 *
 * @author Usuario
 */
public class Nodo {

    private Paquete dato;
    private Nodo siguiente;

    public Nodo() {
        this.siguiente = null;
    }

    public Paquete getDato() {
        return dato;
    }

    public void setDato(Paquete dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}


