package controladores;

import negocios.*;
import org.bson.Document;
import sevicios.ClienteService;
import java.awt.event.ActionListener;
import java.util.*;

public class Cliente {

    public Cliente(String nombre, String direccion, String documentoIdentidad) {
        this.clienteService = new ClienteService();
        clienteService.crearCliente(nombre, direccion, documentoIdentidad);
    }

    public Cliente(String nombre, String documentoIdentidad) {
        this.clienteService = new ClienteService();
        this.documentoCliente = clienteService.obtenerCliente(nombre, documentoIdentidad);
        setId(getDocumentoCliente().getObjectId("_id").toString());
        setNombre(getDocumentoCliente().getObjectId("nombre").toString());
        setDireccion(getDocumentoCliente().getObjectId("direccion").toString());
        setDocumentoIdentidad(getDocumentoCliente().getObjectId("documento_identidad").toString());
    }

    private String id;
    private String nombre;
    private String direccion;
    private String documentoIdentidad;
    private int tiempoConectado;
    private String categoria;
    private Date ultimoInicioDeSesion;
    private ClienteService clienteService;
    private Document documentoCliente;


    public boolean iniciarSesion(String nombre, String dni) {
        return clienteService.iniciarSesion(nombre, dni);
    }

    public void cerrarSesion() {
        documentoCliente = null;
        System.gc();
    }

    private void actualizarTiempoConectado(int minutos) {
        // TODO implement here
    }

    public Carrito iniciarCompra() {
        // TODO implement here
        return null;
    }

    public void agregarProducto(Carrito carrito, String nombreProducto, int cantidad) {
        // TODO implement here
    }

    private ItemCarrito buscarItemCarrito(String nombreProducto) {
        // TODO implement here
        return null;
    }

    public void modificarProducto(Carrito carrito, ItemCarrito producto, int cantidad) {
        // TODO implement here
    }

    public void eliminarProducto(Carrito carrito, String nombreProducto) {
        // TODO implement here
    }

    public void confirmarPedido(Carrito carrito) {
        // TODO implement here
    }

    private List<Pedido> buscarPedidos() {
        // TODO implement here
        return null;
    }

    public String mostrarPedidos(List pedidos) {
        // TODO implement here
        return "";
    }

    public Pedido seleccionarPedido(Date fecha) {
        // TODO implement here
        return null;
    }

    public void pagarPedido(Pedido pedido) {
        // TODO implement here
    }

    private List<Factura> buscarFacturas() {
        // TODO implement here
        return null;
    }

    public String mostrarFacturas(List<Factura> facturas) {
        // TODO implement here
        return "";
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }
    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }
    public int getTiempoConectado() {
        return tiempoConectado;
    }
    public void setTiempoConectado(int tiempoConectado) {
        this.tiempoConectado = tiempoConectado;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Date getUltimoInicioDeSesion() {
        return ultimoInicioDeSesion;
    }
    public void setUltimoInicioDeSesion(Date ultimoInicioDeSesion) {
        this.ultimoInicioDeSesion = ultimoInicioDeSesion;
    }
    public Document getDocumentoCliente() {
        return documentoCliente;
    }
    public void setDocumentoCliente(Document documentoCliente) {
        this.documentoCliente = documentoCliente;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}