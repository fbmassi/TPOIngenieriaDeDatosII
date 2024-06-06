package negocios;

import controladores.Cliente;

import java.util.*;

public class Pedido {

    public Pedido() {
    }

    private int id;
    private Carrito carrito;
    private Cliente cliente;
    private Date fecha;
    private Double importe;
    private double descuentos;
    private double impuestos;
    private String estado;

    public Factura facturarPedido(String formaDePago, Date fecha, Double monto) {
        // TODO implement here
        return null;
    }

    private Double calcularImporte(Carrito carrito) {
        // TODO implement here
        return null;
    }

}