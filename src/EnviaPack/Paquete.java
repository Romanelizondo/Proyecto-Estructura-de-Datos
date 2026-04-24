/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnviaPack;

/**
 *
 * @author camad
 */
public class Paquete {
    private String descripcion;
    private String tipoEnvio;
    private double peso;
    private String destino;
    private boolean tieneGuia;

    public Paquete() {
        this.descripcion = "";
        this.tipoEnvio = "";
        this.peso = 0;
        this.destino = "";
        this.tieneGuia = false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public boolean isTieneGuia() {
        return tieneGuia;
    }

    public void setTieneGuia(boolean tieneGuia) {
        this.tieneGuia = tieneGuia;
    }
    
}
