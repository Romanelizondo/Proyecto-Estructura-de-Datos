/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnviaPack;

import javax.swing.JOptionPane;

/**
 *
 * @author camad
 */
public class ListaDistribucion {
    private NodoDistribucion inicio;
    
    public boolean vacia(){
        return inicio == null;
    }
    
    public void asignarDistribucion(String codigoGuia, String destino,String direccion, String fecha, String repartidor, String estado){
        
        Distribucion d = new Distribucion();
        d.setCodigoGuia(codigoGuia);
        d.setDestino(destino);
        d.setDireccion(direccion);
        d.setFechaEntrega(fecha);
        d.setRepartidor(repartidor);
        d.setEstado(estado);

        NodoDistribucion nuevo = new NodoDistribucion();
        nuevo.setDato(d);
      
        if(vacia()){
            inicio = nuevo;
        }else{
            NodoDistribucion aux = inicio;
            while (aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }

            aux.setSiguiente(nuevo);
        }
      
        JOptionPane.showMessageDialog(null, "Distribucion asignada a la guia: " + codigoGuia);
    } 
    
    public void mostrar(){
        
        NodoDistribucion aux = inicio;
        String texto = "";
        
        if(!vacia()){
            while (aux != null){
                Distribucion d = aux.getDato();
                
                texto += "Codigo guia:  " + d.getCodigoGuia() + "\n";
                texto += "Destino: " + d.getDestino() + "\n";
                texto += "Ciudad y Direccion: " + d.getDireccion()+ "\n";
                texto += "Fecha estimada de entrega: " + d.getFechaEntrega()+ "\n";
                texto += "Repartidor: " + d.getRepartidor()+ "\n";
                texto += "estado: " + d.getEstado()+ "\n";
                texto += "-------------------------\n";
                
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, texto);
        }else{
            JOptionPane.showMessageDialog(null, "No hay distribuciones");
        }
    }
    
    public NodoDistribucion getInicio() {
        return inicio;
    }

    public void setInicio(NodoDistribucion inicio) {
        this.inicio = inicio;
    }
    
}
