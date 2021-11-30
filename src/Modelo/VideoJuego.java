
package Modelo;

/**
 *
 * @author Tamara Gutierrez
 */
public class VideoJuego {
    private int idJuego;
    private String nombreJuego;
    private String categoria;
    private int precio;
    private String plataforma;
    private boolean disponible;

    public VideoJuego() {
    }

    public VideoJuego(int idJuego, String nombreJuego, String categoria, int precio, String plataforma, boolean disponible) {
        this.idJuego = idJuego;
        this.nombreJuego = nombreJuego;
        this.categoria = categoria;
        this.precio = precio;
        this.plataforma = plataforma;
        this.disponible = disponible;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    
    
    
    
}
