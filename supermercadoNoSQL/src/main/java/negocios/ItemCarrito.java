package negocios;

public class ItemCarrito {

    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    private Producto producto;
    private int cantidad;

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public int getCantidad() { return cantidad; }
    public void setCatidad(int catidad) { this.cantidad = catidad; }
}