package controladores;

import negocios.*;

import java.util.*;

/**
 * 
 */
public class Sistema {

    /**
     * Default constructor
     */
    public Sistema() {
    }

    /**
     * 
     */
    private List<Cliente> clientes;

    /**
     * 
     */
    private List<Administrador> administradores;

    /**
     * 
     */
    private Catalogo catalogo;

    /**
     * 
     */
    private List<Factura> facturas;

    /**
     * 
     */
    private List<Pago> pagos;

    /**
     * @param String nombre 
     * @param String documento 
     * @param String direccion 
     * @return
     */
    public void crearCliente(String nombre, String documento, String direccion) {
        // TODO implement here
    }

    /**
     * @param String username 
     * @param String contraseña 
     * @return
     */
    public void crearAdmin(String username, String contraseña) {
        // TODO implement here
    }

    /**
     * @param String nombreCliente 
     * @return
     */
    public Cliente recuperarCliente(String nombreCliente) {
        // TODO implement here
        return null;
    }

    /**
     * @param String username 
     * @return
     */
    public Administrador recupararAdmin(String username) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    private List<Producto> traerCatalogo() {
        // TODO implement here
        return null;
    }

    /**
     * @param List productos 
     * @return
     */
    public String mostrarProd(List<Producto> productos) {
        // TODO implement here
        return "";
    }

    /**
     * @param String nombreProducto 
     * @return
     */
    public Producto buscarProducto(String nombreProducto) {
        // TODO implement here
        return null;
    }

}