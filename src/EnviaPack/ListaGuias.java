/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnviaPack;

import javax.swing.JOptionPane;
import java.time.LocalDate;

/**
 *
 * @author camad
 */
public class ListaGuias {
    
    private NodoGuia inicio;
    private int contador = 1;
    
    public boolean vacia(){
        return inicio == null;
        
    }
    
    public void generarDesdePaquete(Paquete p){
        
        String codigo = "COD" + contador;
        String fecha = LocalDate.now().toString();
        
        
        GuiaEnvio g = new GuiaEnvio();
        g.setNumeroGuia(contador);
        g.setDescripcion(p.getDescripcion());
        g.setTipoEnvio(p.getTipoEnvio());
        g.setCodigoSeguimiento(codigo);
        g.setDestino(p.getDestino());
        g.setFecha(fecha);
        
        NodoGuia nuevo = new NodoGuia();
        nuevo.setDato(g);
        
        if (vacia()){
            inicio = nuevo;
            
        }else{
            NodoGuia aux = inicio;
            while (aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        
        contador++;
        
        JOptionPane.showMessageDialog(null, "Guia generada para: " + p.getDescripcion());
        
    }
    
    public void mostrar(){
        
        NodoGuia aux = inicio;
        String texto = "";
        
        if (!vacia()){
            while(aux != null){
                GuiaEnvio g = aux.getDato();
                
                texto += "Numero guia: " + g.getNumeroGuia() + "\n";
                texto += "Descripcion: " + g.getDescripcion() + "\n";
                texto += "Tipo envio: " + g.getTipoEnvio() + "\n";
                texto += "Codigo: " + g.getCodigoSeguimiento() + "\n";
                texto += "Destino: " + g.getDestino() + "\n";
                texto += "Fecha:: " + g.getFecha() + "\n";
                texto += "//////////////////\n";
                
                aux = aux.getSiguiente();
                        
                
                
            }
            
            JOptionPane.showMessageDialog(null, texto);
        }else{
            JOptionPane.showMessageDialog(null, "No hay guias generadas");
        }
    }

    public NodoGuia getInicio() {
        return inicio;
    }

    public void setInicio(NodoGuia inicio) {
        this.inicio = inicio;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
}
