package controladores;

import com.mongodb.client.FindIterable;
import negocios.*;
import org.bson.Document;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import sevicios.AdminService;
import sevicios.ClienteService;
import sevicios.ProductService;

import java.util.*;

public class Sistema {

    public Sistema() {
        this.adminService = new AdminService();
        this.productService = new ProductService();
        this.clienteService = new ClienteService();
    }

    private List<Factura> facturas;
    private List<Pago> pagos;
    private ProductService productService;
    private AdminService adminService;
    private ClienteService clienteService;

    public void crearCliente(String nombre, String documento, String direccion) {
        if (!existeCliente(nombre, documento)) {
            clienteService.crearCliente(nombre, documento, direccion);
        }
    }

    public Cliente recuperarCliente(String nombre, String documentoIdentidad) {
        Cliente cliente = new Cliente(nombre, documentoIdentidad);
        return cliente;
    }

    private boolean existeCliente(String nombre, String documentoIdentidad) {
        return clienteService.obtenerCliente(nombre, documentoIdentidad) != null;
    }

    public boolean iniciarSesionCliente(String nombre, String documentoIdentidad) {
        return clienteService.iniciarSesion(nombre, documentoIdentidad);
    }

    public void crearAdmin(String username, String contraseña) {
        if (adminService.obtenerAdmin(username, contraseña) == null) {
            adminService.crearAdministrador(username, contraseña);
        }
    }

    public Administrador recupararAdmin(String username, String contraseña) {
        Administrador administrador = new Administrador(username, contraseña);
        return administrador;
    }

    public boolean iniciarSesionAdmin(String username, String contraseña) {
        return adminService.iniciarSesion(username, contraseña);
    }

    public List<String> mostrarProductos() {
        List<String> productos = new ArrayList<>();
        List<Document> iterador = productService.obtenerTodosLosProductos();
        for (Document doc : iterador) {
            productos.add(doc.toJson());
        }
        return productos;
    }

    public void imprimirProductosEnPantalla() {
        List<String> productos = mostrarProductos();
        for (String producto : productos) {
            System.out.println(producto);
        }
    }



    public Producto recuperarProducto(String nombreProducto) {
        Producto producto = new Producto(nombreProducto);
        return producto;
    }

    public boolean existeProducto(String nombreProducto) {
        return productService.obtenerProductoPorNombre(nombreProducto) != null;
    }

    public List<Document> obtenerTodosLosProductos() {
        return productService.obtenerTodosLosProductos();
    }

    public List<String> obtenerProductosTexto() {
        return productService.obtenerProductosTexto();
    }

    public Document obtenerProductoPorNombre(String nombreProducto) {
        Producto producto = new Producto(nombreProducto);
        return producto.getDocumentoProducto();
    }

}