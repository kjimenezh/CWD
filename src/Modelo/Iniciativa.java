
package Modelo;

/**
 *
 * @author kjime
 */
public class Iniciativa {
    private String nombre;
    private String descripcion;

    public Iniciativa(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
}
