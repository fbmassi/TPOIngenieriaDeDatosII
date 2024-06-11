package negocios;

import org.bson.Document;
import sevicios.ProductService;

public class Producto {

    public Producto(String nombreProducto, String descricpion, Double precio) {
        productService = new ProductService();
        productService.crearProducto(nombreProducto, descricpion, precio);
    }

    public Producto(String nombreProducto) {
        productService = new ProductService();
        this.documentoProducto = productService.obtenerProductoPorNombre(nombreProducto);
        this.id = documentoProducto.getObjectId("_id").toString();
        setNombreProducto(documentoProducto.getString("nombre"));
        setDescricpion(documentoProducto.getString("descripcion"));
        Double precio = documentoProducto.getDouble("precio");
        setPrecio(precio);
    }

    public Producto() {
        productService = new ProductService();
    }

    private String id;
    private String nombreProducto;
    private String descricpion;
    private Double precio;
    private ProductService productService;
    private Document documentoProducto;

    public void actualizarPrecio(String nuevoPrecio, String operador) {
        boolean modificación  = productService.modificarPrecioProducto(this.getNombreProducto(), nuevoPrecio);
        if (modificación) {
            CambioProducto cambioProducto = new CambioProducto(this, "precio", this.getPrecio(), nuevoPrecio.toString(), operador);
            cambioProducto.registrarCambioEnLog();
        }
    }

    public void actualizarDescripción(String nuevaDescripción, String operador) {
        boolean modificación  = productService.modificarDescripcionProducto(this.getNombreProducto(), nuevaDescripción);
        if (modificación) {
            CambioProducto cambioProducto = new CambioProducto(this, "descripcion", getDescricpion(), nuevaDescripción, operador);
            cambioProducto.registrarCambioEnLog();
        }
    }

    public void eliminarProducto(String operador) {
        boolean eliminación = productService.eliminarProducto(getNombreProducto());
        if (eliminación) {
            CambioProducto cambioProducto = new CambioProducto(this, operador);
            cambioProducto.registrarEliminaciónEnLog();
        }
    }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }
    public String getDescricpion() { return descricpion; }
    public void setDescricpion(String descricpion) { this.descricpion = descricpion; }
    public String getPrecio() { return precio.toString(); }
    public void setPrecio( Double precio) { this.precio = precio; }
    public String getId() { return id; }
    public Document getDocumentoProducto() { return documentoProducto; }

}