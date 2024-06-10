package controladores;

import java.util.*;
import negocios.*;
import org.bson.Document;
import sevicios.AdminService;
import sevicios.LogService;

public class Administrador {

    public Administrador(String usuario, String contraseña) {
        this.adminService = new AdminService();
        this.logService = new LogService();
        setDocumentoAdmin(adminService.obtenerAdmin(usuario, contraseña));
        setId(getDocumentoAdmin().getObjectId("_id").toString());
        setUsuario(getDocumentoAdmin().getString("usuario"));
    }

    private String id;
    private String usuario;
    private AdminService adminService;
    private LogService logService;
    private Document documentoAdmin;

    public void cerrarSesion() {
        documentoAdmin = null;
        System.gc();
    }

    public void agregarProducto(String nombreProducto, String descripcion, String strPrecio) {
        String devolver;
        try {
            double precio = Double.parseDouble(strPrecio);
            new Producto(nombreProducto, descripcion, precio);
            Producto producto = new Producto(nombreProducto);
            CambioProducto cambioProducto = new CambioProducto(producto, this.getUsuario());
            cambioProducto.registrarCreacionenLog();
        } catch (NumberFormatException e) {
            devolver = "Error: '" + strPrecio + "' no es un número válido.";
            System.err.println(devolver);
        }
    }

    public void eliminarProducto(String nombreProducto) {
        Producto producto = new Producto(nombreProducto);
        producto.eliminarProducto(getUsuario());
    }

    public void actualizarPrecioProducto(String nombreProducto, double nuevoPrecio) {
        Producto producto = new Producto(nombreProducto);
        producto.actualizarPrecio(producto.getPrecio(), this.getUsuario());
    }

    public void actualizarDescripcionProducto(String nombreProducto, String nuevaDescripción) {
        Producto producto = new Producto(nombreProducto);
        producto.actualizarDescripción(nuevaDescripción, this.getUsuario());
    }

    public List<String> traerLogDeProducto(String nombreProducto) {
        return logService.obtenerLogPorNombreProducto(nombreProducto);
    }

    public List<String> traerLogDeTodoElCatalogo() {
        return logService.obtenerTodosLosLogs();
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Document getDocumentoAdmin() {
        return documentoAdmin;
    }
    public void setDocumentoAdmin(Document documentoAdmin) {
        this.documentoAdmin = documentoAdmin;
    }

}