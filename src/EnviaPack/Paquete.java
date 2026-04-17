package EnviaPack;

// repoitorio
/**
 *
 * @author Usuario
 */
public class Paquete {

    private String descripcion;
    private String tipoEnvio;
    private double peso;
    private String destino;
    private int numeroGuia;

    public Paquete() {
        this.descripcion = "";
        this.tipoEnvio = "";
        this.peso = 0;
        this.destino = "";
        this.numeroGuia = 0;
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

    public int getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(int numeroGuia) {
        this.numeroGuia = numeroGuia;
    }
    
    
    
}
