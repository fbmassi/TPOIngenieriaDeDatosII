package negocios;

import controladores.Cliente;
import org.bson.types.ObjectId;
import sevicios.PagoService;

import java.util.*;

public class Pago {

    public Pago(String nombreCliente, List<ObjectId> pedidos) {
        pagoService = new PagoService();
        this.pedidos = pedidos;
        setCliente(nombreCliente);
        setFecha(new Date());
        setMonto(calcularMontoTotalAPagar(obtenerTodosLosPedidos(pedidos)));
    }

    protected List<ObjectId> pedidos;
    protected Date fecha;
    protected double monto;
    protected String medio;
    protected PagoService pagoService;
    protected String cliente;

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    public String getMedio() { return medio; }
    public void setMedio(String medio) { this.medio = medio; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    protected Double calcularMontoTotalAPagar(List<Double> pedidos) {
        double importeTotal = 0;
        for (Double montoPedido: pedidos) {
            importeTotal += montoPedido;
        }
        return importeTotal;
    }

    protected List<Double> obtenerTodosLosPedidos(List<ObjectId> pedidos) {
        return pagoService.obtenerMontosDePedidos(pedidos);
    }


}