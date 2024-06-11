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
        Object precioObj = documentoProducto.get("precio"); // Obtiene el precio como un Object
        Double precio = 0.0;
        if (precioObj instanceof Double) {
            precio = (Double) precioObj;
        } else if (precioObj instanceof String) {
            precio = Double.parseDouble((String) precioObj);
        }
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

    public void actualizarPrecio(Double nuevoPrecio, String operador) {
        boolean modificación  = productService.modificarPrecioProducto(this.getNombreProducto(), nuevoPrecio);
        if (modificación) {
            CambioProducto cambioProducto = new CambioProducto(this, "precio", this.getPrecio().toString(), nuevoPrecio.toString(), operador);
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
    public Double getPrecio() { return precio; }
    public void setPrecio( Double precio) { this.precio = precio; }
    public String getId() { return id; }
    public Document getDocumentoProducto() { return documentoProducto; }

}