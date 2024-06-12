package negocios;

import controladores.Cliente;
import sevicios.PagoService;

import java.util.*;

public class Pago {

    public Pago(List<String> pedidos) {
        pagoService = new PagoService();
        this.pedidos = pedidos;
        setFecha(new Date());
        setMonto(calcularMontoTotalAPagar(obtenerTodosLosPedidos(pedidos)));
    }

    protected List<String> pedidos;
    protected Cliente cliente;
    protected Date fecha;
    protected double monto;
    protected String medio;
    protected PagoService pagoService;

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public String getMedio() { return medio; }
    public void setMedio(String medio) { this.medio = medio; }

    protected Double calcularMontoTotalAPagar(List<Double> pedidos) {
        double importeTotal = 0;
        for (Double montoPedido: pedidos) {
            importeTotal += montoPedido;
        }
        return importeTotal;
    }

    protected List<Double> obtenerTodosLosPedidos(List<String> pedidos) {
        return pagoService.obtenerMontosDePedidos(pedidos);
    }



}