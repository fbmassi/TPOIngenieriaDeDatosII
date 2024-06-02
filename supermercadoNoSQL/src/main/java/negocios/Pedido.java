package negocios;

import controladores.Cliente;

import java.util.*;

/**
 * 
 */
public class Pedido {

    /**
     * Default constructor
     */
    public Pedido() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private Carrito carrito;

    /**
     * 
     */
    private Cliente cliente;

    /**
     * 
     */
    private Date fecha;

    /**
     * 
     */
    private Double importe;

    /**
     * 
     */
    private double descuentos;

    /**
     * 
     */
    private double impuestos;

    /**
     * 
     */
    private String estado;

    /**
     * @param String formaDePago 
     * @param Date fecha 
     * @param Double monto 
     * @return
     */
    public Factura facturarPedido(String formaDePago, Date fecha, Double monto) {
        // TODO implement here
        return null;
    }

    /**
     * @param Carrito carrito 
     * @return
     */
    private Double calcularImporte(Carrito carrito) {
        // TODO implement here
        return null;
    }

}