package negocios;

import controladores.Cliente;
import sevicios.PedidoService;

import java.util.*;

public class Pedido {

    public Pedido(Carrito carrito, String codigoDeDescuento) {
        pedidoService = new PedidoService();
        setCliente(carrito.getCliente());
        setFecha(new Date());
        setProductos(carrito.getEstadoCarritoActual().getProductos());
        setImporteParcial(calcularImporte(0));
        if (pedidoService.codigoValido(codigoDeDescuento)) {
            setDescuentos(pedidoService.obtenerDescuento(codigoDeDescuento));
            setImporteFinal(calcularImporte(descuentos));
        } else {
            setDescuentos(0);
            setImporteFinal(importeParcial);
        }
        setImpuestos(calcularPrecioBaseYIVA(importeFinal)[1]);
        setPrecioBase(calcularPrecioBaseYIVA(importeFinal)[0]);
        setEstado("EN ESPERA");
        pedidoService.crearPedido(cliente.getNombre(), cliente.getDocumentoIdentidad(), cliente.getDireccion(),
                fecha, productos, importeParcial, importeFinal, descuentos, impuestos, precioBase, estado);
    }

    private Cliente cliente;
    private Date fecha;
    private List<ItemCarrito> productos;
    private double importeParcial;
    private Double importeFinal;
    private int descuentos;
    private double impuestos;
    private double precioBase;
    private String estado;
    private PedidoService pedidoService;

    private Double calcularImporte(int descuento) {
        double importe = 0;
        for (ItemCarrito item: productos) {
            importe += (item.getProducto().getPrecio()*item.getCantidad());
        }
        return importe - importe * ((double) descuento / 100);
    }

    private double[] calcularPrecioBaseYIVA(double precioFinal) {
        double porcentajeIVA = 21;
        double precioBase = precioFinal / (1 + porcentajeIVA / 100);
        double iva = precioFinal - precioBase;
        return new double[]{precioBase, iva};
    }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public Double getImporte() { return importeFinal; }
    public void setImporteFinal(Double importe) { this.importeFinal = importe; }
    public double getDescuentos() { return descuentos; }
    public void setDescuentos(int descuentos) { this.descuentos = descuentos; }
    public double getImpuestos() { return impuestos; }
    public void setImpuestos(double impuestos) { this.impuestos = impuestos; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase;}
    public List<ItemCarrito> getProductos() { return productos; }
    public void setProductos(List<ItemCarrito> productos) { this.productos = productos; }
    public double getImporteParcial() {return importeParcial; }
    public void setImporteParcial(double importeParcial) {this.importeParcial = importeParcial;}
}