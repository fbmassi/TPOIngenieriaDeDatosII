package negocios;

import controladores.Cliente;

import java.util.*;

/**
 * 
 */
public class Pago {

    /**
     * Default constructor
     */
    public Pago() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private List<Factura> facturas;

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
    private double monto;

}