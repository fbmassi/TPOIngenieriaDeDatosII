package controladores;

import negocios.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import sevicios.ClienteService;
import java.awt.event.ActionListener;
import java.sql.Struct;
import java.text.SimpleDateFormat;
import java.util.*;

public class Cliente {

    public Cliente(String nombre, String direccion, String documentoIdentidad) {
        this.clienteService = new ClienteService();
        clienteService.crearCliente(nombre, direccion, documentoIdentidad);
    }

    public Cliente(String nombre, String documentoIdentidad) {
        this.clienteService = new ClienteService();
        setSesion(iniciarSesion(nombre, documentoIdentidad));
        if (sesion) {
            setDocumentoCliente(clienteService.obtenerCliente(nombre, documentoIdentidad));
            setId(getDocumentoCliente().getObjectId("_id").toString());
            setNombre(documentoCliente.getString("nombre"));
            setDireccion(documentoCliente.getString("direccion"));
            setDocumentoIdentidad(documentoCliente.getString("documento_identidad"));
            setDateFormatter(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            setUltimoInicioDeSesion();
        }
    }

    private String id;
    private String nombre;
    private String direccion;
    private String documentoIdentidad;
    private int tiempoConectado;
    private String categoria;
    private SimpleDateFormat dateFormatter;
    private Date ultimoInicioDeSesion;
    private ClienteService clienteService;
    private Document documentoCliente;
    private boolean sesion;


    public boolean iniciarSesion(String nombre, String dni) {
        return clienteService.iniciarSesion(nombre, dni);
    }

    public void cerrarSesion() {
        clienteService.registrarActividad(this.getNombre(), this.getDocumentoIdentidad(), this.getDateFormatter(), this.getUltimoInicioDeSesion());
        documentoCliente = null;
        System.gc();
    }

    public Carrito iniciarCompra() {
        return new Carrito(this);
    }

    public void agregarProducto(Carrito carrito, String nombreProducto, int cantidad) {
        Document doc = clienteService.obtenerProductoPorNombre(nombreProducto);
        String nombre = doc.getString("nombre");
        Producto producto = new Producto(nombre);
        ItemCarrito item = new ItemCarrito(producto, cantidad);
        carrito.getEstadoCarritoActual().addProducto(item);
    }

    public void modificarProducto(Carrito carrito, String nombreProducto, int cantidad) {
        Document doc = clienteService.obtenerProductoPorNombre(nombreProducto);
        String nombre = doc.getString("nombre");
        Producto producto = new Producto(nombre);
        carrito.getEstadoCarritoActual().modificarCantidad(producto,cantidad);
    }

    public void eliminarProducto(Carrito carrito, String nombreProducto) {
        Document doc = clienteService.obtenerProductoPorNombre(nombreProducto);
        String nombre = doc.getString("nombre");
        Producto producto = new Producto(nombre);
        carrito.getEstadoCarritoActual().eliminarProducto(producto);
    }

    public void guardarEstado(Carrito carrito) {
        carrito.guardarEstado();
    }

    public void volverAEstadoAnterior(Carrito carrito) {
        carrito.volverAEstadoAnterior();
    }

    public void recuperarEstado(Carrito carrito) {
        carrito.recuperarEstado();
    }

    public void confirmarPedido(Carrito carrito, String codigoDeDescuento) {
        carrito.generarPedido(carrito, codigoDeDescuento);
        System.gc();
    }

    public void pagarPedidosEnEfectivo(List<ObjectId> pedidosPendientes) {
        Pago pago = new PagoEnEfectivo(nombre, pedidosPendientes);
    }

    public void pagarPedidosConTarjeta(List<ObjectId> pedidosPendientes, String operador, String tarjeta, String codigo) {
        Pago pago = new PagoConTarjeta(nombre, pedidosPendientes, operador, tarjeta,codigo);
    }

    public void generarFactura(ObjectId id) {
        new Factura(nombre, id);
    }

    public List<ObjectId> getPedidosPendientes() {
        return clienteService.obtenerPedidosPendientes(nombre);
    }

    public Document getPedido(ObjectId id) {
        return clienteService.obtenerPedido(id);
    }

    public List<Document> obtenerFacturasCliente() {
        return clienteService.obtenerFacturas(nombre);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getDocumentoIdentidad() { return documentoIdentidad; }
    public void setDocumentoIdentidad(String documentoIdentidad) { this.documentoIdentidad = documentoIdentidad; }
    public int getTiempoConectado() { return tiempoConectado; }
    public void setTiempoConectado(int tiempoConectado) { this.tiempoConectado = tiempoConectado; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public Date getUltimoInicioDeSesion() { return ultimoInicioDeSesion; }
    public void setUltimoInicioDeSesion() { this.ultimoInicioDeSesion = new Date(); }
    public Document getDocumentoCliente() { return documentoCliente; }
    public void setDocumentoCliente(Document documentoCliente) { this.documentoCliente = documentoCliente; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public void setDateFormatter(SimpleDateFormat dateFormatter) { this.dateFormatter = dateFormatter; }
    public SimpleDateFormat getDateFormatter() { return dateFormatter; }
    public void setSesion(boolean sesion) { this.sesion = sesion; }
    public boolean getSesion() { return sesion; }
}