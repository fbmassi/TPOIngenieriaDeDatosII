package controladores;

import negocios.*;

import java.util.*;

/**
 * 
 */
public class Cliente {

    public Cliente(String nombre, String direccion, String documentoIdentidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.documentoIdentidad = documentoIdentidad;
    }

    private int id;
    private String nombre;
    private String direccion;
    private String documentoIdentidad;
    private int tiempoConectado;
    private String categoria;
    private Date ultimoInicioDeSesion ;

    public boolean iniciarSesion(String nombre, String dni) {
        // TODO implement here
        return false;
    }

    public void cerrarSesion() {
        // TODO implement here
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
}