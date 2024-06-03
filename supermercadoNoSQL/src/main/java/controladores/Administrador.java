package controladores;

import java.util.*;
import negocios.*;
import org.bson.Document;
import org.springframework.boot.jdbc.metadata.AbstractDataSourcePoolMetadata;
import sevicios.AdminService;

/**
 * 
 */
public class Administrador {

    public Administrador(String usuario, String contraseña) {
        this.adminService = new AdminService();
        if (adminService.obtenerAdmin(usuario, contraseña) == null) {
            adminService.crearAdministrador(usuario, contraseña);
            this.documentoAdmin = adminService.obtenerAdmin(usuario, contraseña);
            this.id = documentoAdmin.getObjectId("_id").toString();
            this.usuario = usuario;
            this.contraseña = contraseña;
        } else {
            this.documentoAdmin = adminService.obtenerAdmin(usuario, contraseña);
            this.id = documentoAdmin.getObjectId("_id").toString();
            this.usuario = usuario;
            this.contraseña = contraseña;
        }
    }

    private String id;
    private String usuario;
    private String contraseña;
    private AdminService adminService;
    private Document documentoAdmin;

    public boolean iniciarSesion(String username, String contraseña) {
        return adminService.iniciarSesion(username, contraseña);
    }

    public void cerrarSesion() {
        documentoAdmin = null;
        System.gc();
    }

    public void agregarProducto(String nombreProducto, String Descripcion, Double precio) {
        // TODO implement here
    }

    public void eliminarProducto(String nombreProducto) {
        // TODO implement here
    }

    private List<CambioProducto> traerLogDeCatalogo() {
        // TODO implement here
        return null;
    }

    public String mostrarLog(List<CambioProducto> cambiosProductos) {
        // TODO implement here
        return "";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getId() {
        return id;
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