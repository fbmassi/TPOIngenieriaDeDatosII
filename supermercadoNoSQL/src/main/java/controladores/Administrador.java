package controladores;

import java.util.*;
import negocios.*;
/**
 * 
 */
public class Administrador {

    /**
     * Default constructor
     */
    public Administrador() {
    }

    /**
     * 
     */
    private String usuario;

    /**
     * 
     */
    private String contraseña;

    /**
     * @param String username 
     * @param String contraseña 
     * @return
     */
    public boolean iniciarSesion(String username, String contraseña) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean cerrarSesion() {
        // TODO implement here
        return false;
    }

    /**
     * @param String nombreProducto 
     * @param String Descripcion 
     * @param Double precio 
     * @return
     */
    public void agregarProducto(String nombreProducto, String Descripcion, Double precio) {
        // TODO implement here
    }

    /**
     * @param String nombreProducto 
     * @return
     */
    public void eliminarProducto(String nombreProducto) {
        // TODO implement here
    }

    /**
     * @return
     */
    private List<CambioProducto> traerLogDeCatalogo() {
        // TODO implement here
        return null;
    }

    /**
     * @param List cambiosProductos 
     * @return
     */
    public String mostrarLog(List<CambioProducto> cambiosProductos) {
        // TODO implement here
        return "";
    }

}