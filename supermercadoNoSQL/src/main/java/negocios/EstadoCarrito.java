package negocios;

import java.util.*;

public class EstadoCarrito {

    public EstadoCarrito() {
        productos = new ArrayList<ItemCarrito>();
    }

    private List<ItemCarrito> productos;

    public boolean addProducto(ItemCarrito producto) {
        boolean seAgrego = false;
        boolean existeAntes = false;
        for (ItemCarrito itemCarrito: productos) {
            if (Objects.equals(itemCarrito.getProducto().getNombreProducto(), producto.getProducto().getNombreProducto())) {
                existeAntes = true;
            }
        }
        if (!existeAntes) {
            productos.add(producto);
            for (ItemCarrito itemCarrito: productos) {
                if (Objects.equals(itemCarrito.getProducto().getNombreProducto(), producto.getProducto().getNombreProducto())) {
                    seAgrego = true;
                }
            }
        }
        return seAgrego;
    }

    public boolean eliminarProducto(Producto producto) {
        boolean seElimino = false;
        if (!productos.isEmpty()) {
            for (ItemCarrito itemCarrito: productos) {
                if (Objects.equals(itemCarrito.getProducto().getNombreProducto(), producto.getNombreProducto())) {
                    productos.remove(itemCarrito);
                    seElimino = true;
                    break;
                }
            }
        }
        return seElimino;
    }

    public boolean modificarCantidad(Producto producto, int cantidad) {
        boolean seModifico = false;
        boolean existeAntes = false;
        for (ItemCarrito itemCarrito: productos) {
            if (Objects.equals(itemCarrito.getProducto().getNombreProducto(), producto.getNombreProducto())) {
                existeAntes = true;
            }
        }
        if (existeAntes) {
            if (!productos.isEmpty()) {
                for (ItemCarrito itemCarrito: productos) {
                    if (Objects.equals(itemCarrito.getProducto().getNombreProducto(), producto.getNombreProducto())) {
                        itemCarrito.setCatidad(cantidad);
                        seModifico = true;
                    }
                }
            }
        }
        return seModifico;
    }

    public List<ItemCarrito> getProductos() {
        return productos;
    }

}