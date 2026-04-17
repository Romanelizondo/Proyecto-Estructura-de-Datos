
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

    public Paquete() {
        this.descripcion = "";
        this.tipoEnvio = "";
        this.peso = 0;
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
}

    

