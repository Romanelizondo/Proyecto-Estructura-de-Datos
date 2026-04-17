
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

        int opcion = 0;

        do {
            try {
                String menu = "--- MENÚ ENVIAPACK ---\n"
                        + "1. Registrar ingreso de paquete (Lista)\n"
                        + "2. Apilar paquetes (Pila)\n"
                        + "3. Trasladar a cola de envío (Cola)\n"
                        + "4. Clasificar por destino (Árbol)\n"
                        + "5. Ver reporte final (Árbol Inorden)\n"
                        + "6. Salir\n"
                        + "Seleccione una opción:";

                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (opcion) {
                    case 1:
                        // Registrar en la lista
                        Paquete nuevoP = new Paquete();
                        nuevoP.setDescripcion(JOptionPane.showInputDialog("Descripción del paquete:"));
                        nuevoP.setTipoEnvio(JOptionPane.showInputDialog("Tipo de envío (Estándar/Express):"));
                        nuevoP.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Peso (kg):")));
                        
                        lista.insertar(nuevoP);
                        JOptionPane.showMessageDialog(null, "Paquete registrado en la lista de ingreso.");
                        break;

                    case 2:
                        // De lista a pila
                        if (lista.vacia()) {
                            JOptionPane.showMessageDialog(null, "La lista está vacía.");
                        } else {
                            Nodo aux = lista.getInicio();
                            while (aux != null) {
                                pila.push(aux.getDato());
                                aux = aux.getSiguiente();
                            }
                            JOptionPane.showMessageDialog(null, "Paquetes movidos a la pila de almacenamiento.");
                        }
                        break;

                    case 3:
                        // De pila a cola (Vaciando la pila como pidió la profe)
                        if (pila.getCima() == null) {
                            JOptionPane.showMessageDialog(null, "La pila está vacía.");
                        } else {
                            while (pila.getCima() != null) {
                                cola.encolar(pila.pop());
                            }
                            JOptionPane.showMessageDialog(null, "Pila vaciada. Paquetes movidos a la cola de envío.");
                        }
                        break;

                    case 4:
                        // clasificar en el arbol
                        if (cola.vacia()) {
                            JOptionPane.showMessageDialog(null, "No hay paquetes en la cola.");
                        } else {
                            while (!cola.vacia()) {
                                Paquete p = cola.desencolar();
                                String destino = JOptionPane.showInputDialog("Paquete: " + p.getDescripcion() 
                                                 + "\nIngrese la ciudad de destino:");
                                p.setDestino(destino);
                                arbol.insertar(p);
                            }
                            JOptionPane.showMessageDialog(null, "Clasificación completada con exito.");
                        }
                        break;

                    case 5:
                        // ver reporte (Se muestra en consola para leerlo mejor)
                        if (arbol.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El arbol está vacio.");
                        } else {
                            System.out.println("\n--- REPORTE DE ENVIOS POR CIUDAD ---");
                            arbol.mostrarClasificacion(arbol.getRaiz());
                            JOptionPane.showMessageDialog(null, "Reporte generado en la consola (Output).");
                        }
                        break;

                    case 6:
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese datos válidos.");
            }
        } while (opcion != 6);
    }
}
    

    

