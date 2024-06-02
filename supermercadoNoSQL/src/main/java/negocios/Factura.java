package negocios;

import controladores.Cliente;

import java.util.*;

/**
 * 
 */
public class Factura {

    /**
     * Default constructor
     */
    public Factura(Cliente cliente, Date fecha, double importeTotal, String formaPago) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.importeTotal = importeTotal;
        this.formaPago = formaPago;
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private Pedido pedido;

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
    private double importeTotal;

    /**
     * 
     */
    private String formaPago;

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}