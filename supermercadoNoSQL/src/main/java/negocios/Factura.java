package negocios;

import controladores.Cliente;
import org.bson.Document;
import org.bson.types.ObjectId;
import sevicios.FacturaService;

import javax.print.Doc;
import java.util.*;

public class Factura {

    public Factura(String nombreCliente, ObjectId idPedido) {
        facturaService = new FacturaService();
        setCliente(nombreCliente);
        setFecha(new Date());
        setPedido(obtenerPedido(idPedido));
        setImporteTotal(pedido.getDouble("importe_final"));
        setImporteParcial(pedido.getDouble("importe_parcial"));
        setDescuentos(pedido.getInteger("descuentos"));
        setImpuestos(pedido.getDouble("impuestos"));
        setPrecioBase(pedido.getDouble("precioBase"));
        productos = (List<Document>) pedido.get("productos");
        facturaService.generarFactura(idPedido, cliente, fecha, productos, importeParcial,
                importeTotal, descuentos, impuestos, precioBase);
    }

    private String cliente;
    private Date fecha;
    private FacturaService facturaService;
    private Document pedido;
    private double importeTotal;
    private double importeParcial;
    private int descuentos;
    private double impuestos;
    private double precioBase;
    private List<Document> productos;

    private Document obtenerPedido(ObjectId idPedido) {
        return facturaService.obtenerPedido(idPedido);
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
    public Document getPedido() { return pedido; }
    public void setPedido(Document pedido) { this.pedido = pedido; }
    public double getImporteParcial() { return importeParcial; }
    public void setImporteParcial(double importeParcial) { this.importeParcial = importeParcial; }
    public int getDescuentos() { return descuentos; }
    public void setDescuentos(int descuentos) { this.descuentos = descuentos; }
    public double getImpuestos() { return impuestos; }
    public void setImpuestos(double impuestos) { this.impuestos = impuestos; }
    public double getPrecioBase()  { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
}