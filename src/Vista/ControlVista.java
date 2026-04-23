package Vista;

import EnviaPack.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Dilan
 */
public class ControlVista {
    ListaPaquetes lista = null;
    PilaDinamica pila = null;
    ColaPaquetes cola = null;
    ArbolDestinos arbol = null;
    ListaGuias guias = null;
    ListaDistribucion distribucion = null;
        
    Inicio inicio = null;
    Registrar registro = null;
    VerPaquete verPaq = null;
    VerCola verCola = null;
    AsignarDestino asignarDestino = null;
    VerDistribucion verDistribucion = null;
    
    public ControlVista(ListaPaquetes lista, PilaDinamica pila, ColaPaquetes cola, 
            ArbolDestinos arbol, ListaGuias guias, ListaDistribucion distribucion) {
        this.lista = lista;
        this.cola = cola;
        this.pila = pila;
        this.arbol = arbol;
        this.guias = guias;
        this.distribucion = distribucion;
        
        this.inicio = new Inicio(this);
        this.registro = new Registrar(this);
        this.verPaq = new VerPaquete(this);
        this.verCola = new VerCola(this);
        this.asignarDestino = new AsignarDestino(this);
        this.verDistribucion = new VerDistribucion(this);
        
        inicio.setVisible(true);
        inicio.setLocationRelativeTo(null);
    }
    
    public void salir(){
        int opcion = JOptionPane.showConfirmDialog(
            null,
            "¿Desea Salir Del Programa?",
            "Confirmación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        switch (opcion){
            case 0:
                System.exit(0);
                break;
            case 1:
                break;
        }
    }
    
    public void menuInicio(){
        inicio.setVisible(true);
        inicio.setLocationRelativeTo(null);
    }
    
    public void desencolar(){
        cola.desencolar();
    }
    
    public void generarGuia(){
        if (arbol.getRaiz() == null) {
            JOptionPane.showMessageDialog(null, "No hay paquetes clasificados.");
        } else {
            Principal.generarGuiasDesdeArbol(arbol.getRaiz(), guias);
        }
    }
    
    public void asignarDestino(){
        asignarDestino.setVisible(true);
        asignarDestino.setLocationRelativeTo(null);
        
        asignarDestino.txtGuia.setText(guias.getInicio().getDato().getCodigoSeguimiento());
        asignarDestino.txtCiudad.setText(guias.getInicio().getDato().getDestino());
        asignarDestino.txtADescripcion.setText(guias.getInicio().getDato().getDescripcion());
    }
    
    public void asignarDatos(){
        distribucion.asignarDistribucion(asignarDestino.txtCodigo.getText(), asignarDestino.txtDestino.getText(), 
                asignarDestino.txtDireccion.getText(), asignarDestino.txtFecha.getText(), 
                asignarDestino.txtRepartidor.getText(), String.valueOf(asignarDestino.cmbEstado.getSelectedItem()));
        
        asignarDestino.txtGuia.setText(guias.getInicio().getDato().getCodigoSeguimiento());
        asignarDestino.txtCiudad.setText(guias.getInicio().getDato().getDestino());
        asignarDestino.txtADescripcion.setText(guias.getInicio().getDato().getDescripcion());
        limpiarDestino();
    }
    
    public void registrarPaquete(){
        limpiarRegistro();
        registro.setVisible(true);
        registro.setLocationRelativeTo(null);
    }
    
public void registrar() {
    String descripcion = registro.txtADescripcion.getText().trim();
    if (descripcion.isEmpty()) {
        JOptionPane.showMessageDialog(
            null,
            "No se pueden registrar paquetes sin descripción.",
            "Error de registro",
            JOptionPane.ERROR_MESSAGE
        );
        return;
    }

    Paquete nuevoP = new Paquete();
    try {
        nuevoP.setDescripcion(descripcion);
        nuevoP.setTipoEnvio(String.valueOf(registro.cmbTipoEnvio.getSelectedItem()));
        nuevoP.setPeso(Double.parseDouble(registro.txtPeso.getText()));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(
            null,
            "Error: El Peso debe ser un valor numérico válido",
            "Error de registro",
            JOptionPane.ERROR_MESSAGE
        );
        return;
    }

    lista.insertar(nuevoP);
    limpiarRegistro();
    JOptionPane.showMessageDialog(null, "Paquete registrado en la lista de ingreso.");
}
    
    public void verPaquetes(){
        if(lista.vacia()){
            int opcion = JOptionPane.showConfirmDialog(
                null,
                "No hay Paquetes en la lista.\n¿Desea Agregar un Nuevo Paquete?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
        
            switch (opcion){
                case 0:
                    registrarPaquete();
                    break;
                case 1:
                    menuInicio();
                    break;
            }
        } else {
            verPaq.setTemp(lista.getInicio());
            verPaq.setVisible(true);
            verPaq.setLocationRelativeTo(null);
            verPaq.txtPeso.setText(String.valueOf(verPaq.getTemp().getDato().getPeso()));
            verPaq.txtADescripcion.setText(verPaq.getTemp().getDato().getDescripcion());
            verPaq.txtTipoEnvio.setText(verPaq.getTemp().getDato().getTipoEnvio());
        }
    }
    
    public void siguientePaquete(){
        if (verPaq.getTemp().getSiguiente() == null){
            verPaq.setTemp(lista.getInicio());
        } else {
            verPaq.setTemp(verPaq.getTemp().getSiguiente());
        }
        verPaq.txtPeso.setText(String.valueOf(verPaq.getTemp().getDato().getPeso()));
        verPaq.txtADescripcion.setText(verPaq.getTemp().getDato().getDescripcion());
        verPaq.txtTipoEnvio.setText(verPaq.getTemp().getDato().getTipoEnvio());
    }
    
    public void verCola(){
        if(cola.vacia()){
            JOptionPane.showMessageDialog(null, "No hay paquetes en la cola.");
        } else {
            verCola.setTemp(cola.getFrente());
            verCola.setVisible(true);
            verCola.setLocationRelativeTo(null);
            verCola.txtPeso.setText(String.valueOf(verCola.getTemp().getDato().getPeso()));
            verCola.txtADescripcion.setText(verCola.getTemp().getDato().getDescripcion());
            verCola.txtTipoEnvio.setText(verCola.getTemp().getDato().getTipoEnvio());
        }
    }
    
    public void siguientePaqueteCola(){
        if (verCola.getTemp().getSiguiente() == null){
            verCola.setTemp(cola.getFrente());
        } else {
            verCola.setTemp(verCola.getTemp().getSiguiente());
        }
        verCola.txtPeso.setText(String.valueOf(verCola.getTemp().getDato().getPeso()));
        verCola.txtADescripcion.setText(verCola.getTemp().getDato().getDescripcion());
        verCola.txtTipoEnvio.setText(verCola.getTemp().getDato().getTipoEnvio());
    }
    
    public void apilar(){
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
        lista.vaciar();
    }
    
    public void encolar(){
        if (pila.getCima() == null) {
            JOptionPane.showMessageDialog(null, "La pila está vacía.");
        } else {
            while (pila.getCima() != null) {
            cola.encolar(pila.pop());
            }
            JOptionPane.showMessageDialog(null, "Pila vaciada. Paquetes movidos a la cola de envío.");
        }
    }
    
    public void clasificar(){
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
    }
    
    public void limpiarRegistro(){
        registro.txtADescripcion.setText("");
        registro.txtPeso.setText("");
        registro.cmbTipoEnvio.setSelectedIndex(0);
    }
    
    public void limpiarDestino(){
        asignarDestino.txtCodigo.setText("");
        asignarDestino.txtDestino.setText("");
        asignarDestino.txtDireccion.setText("");
        asignarDestino.txtFecha.setText("");
        asignarDestino.txtRepartidor.setText("");
        asignarDestino.cmbEstado.setSelectedIndex(0);
    }
    
    public void verDistribucion(){
        if(distribucion.vacia()){
            JOptionPane.showMessageDialog(null, "No hay paquetes en la lista de Distribución.");
        } else {
            verDistribucion.setTemp(distribucion.getInicio());

            verDistribucion.setVisible(true);
            verDistribucion.setLocationRelativeTo(null);

            verDistribucion.txtCodigo.setText(verDistribucion.getTemp().getDato().getCodigoGuia());
            verDistribucion.txtDestino.setText(verDistribucion.getTemp().getDato().getDestino());
            verDistribucion.txtDireccion.setText(verDistribucion.getTemp().getDato().getDireccion());
            verDistribucion.txtRepartidor.setText(verDistribucion.getTemp().getDato().getRepartidor());
            verDistribucion.txtFecha.setText(verDistribucion.getTemp().getDato().getFechaEntrega());
            verDistribucion.txtEstado.setText(verDistribucion.getTemp().getDato().getEstado());
        }  
    }
    
    public void siguienteDistribucion(){
        if(verDistribucion.getTemp().getSiguiente() == null){
            
        } else {
            verDistribucion.setTemp(verDistribucion.getTemp().getSiguiente());
            
            verDistribucion.txtCodigo.setText(verDistribucion.getTemp().getDato().getCodigoGuia());
            verDistribucion.txtDestino.setText(verDistribucion.getTemp().getDato().getDestino());
            verDistribucion.txtDireccion.setText(verDistribucion.getTemp().getDato().getDireccion());
            verDistribucion.txtRepartidor.setText(verDistribucion.getTemp().getDato().getRepartidor());
            verDistribucion.txtFecha.setText(verDistribucion.getTemp().getDato().getFechaEntrega());
            verDistribucion.txtEstado.setText(verDistribucion.getTemp().getDato().getEstado());
        } 
    }
}
