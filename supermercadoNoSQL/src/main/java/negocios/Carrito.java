package negocios;

import controladores.*;

import java.util.*;

/**
 * 
 */
public class Carrito {

    /**
     * Default constructor
     */
    public Carrito() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private Cliente cliente;

    /**
     * 
     */
    private EstadoCarrito estadoCarritoActual;

    /**
     * 
     */
    private List<EstadoCarrito> esatdos;

    /**
     * @param EstadoCarrito estado 
     * @return
     */
    public void guardarEstado(EstadoCarrito estado) {
        // TODO implement here
    }

    /**
     * @return
     */
    public EstadoCarrito recuperarEstado() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public EstadoCarrito volverAEstadoAnterior() {
        // TODO implement here
        return null;
    }

    /**
     * @param EstadoCarrito estado 
     * @return
     */
    public Pedido generarPedido(EstadoCarrito estado) {
        // TODO implement here
        return null;
    }

}