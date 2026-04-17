
package EnviaPack;
// repoitorio
/**
 *
 * @author Usuario
 */
public class Principal {

    public static void main(String[] args) {

        ListaPaquetes lista = new ListaPaquetes();
        PilaDinamica pila = new PilaDinamica();

        
        Paquete p1 = new Paquete();
        p1.setDescripcion("Documentos");
        p1.setTipoEnvio("Estandar");
        p1.setPeso(2.5);

        Paquete p2 = new Paquete();
        p2.setDescripcion("Ropa");
        p2.setTipoEnvio("Express");
        p2.setPeso(1.2);

        Paquete p3 = new Paquete();
        p3.setDescripcion("Electronicos");
        p3.setTipoEnvio("Internacional");
        p3.setPeso(5.0);

       
        lista.insertar(p1);
        lista.insertar(p2);
        lista.insertar(p3);

        System.out.println("=== LISTA DE PAQUETES ===");
        lista.mostrar();

        
        Nodo aux = lista.getInicio();

        while (aux != null) {
            pila.push(aux.getDato());
            aux = aux.getSiguiente();
        }

        System.out.println("=== PILA DE PAQUETES ===");
        pila.mostrar();
    }
}
    

    

