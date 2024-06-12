package org.example;

import controladores.Administrador;
import controladores.Cliente;
import controladores.Sistema;
import interfaces.PanelPrincipal;
import negocios.Carrito;
import negocios.EstadoCarrito;
import negocios.ItemCarrito;
import negocios.Producto;
import sevicios.ProductService;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //PanelPrincipal panelPrincipal = new PanelPrincipal();
        Cliente franco = new Cliente("Franco", "42724252");
        Carrito carrito = franco.iniciarCompra();
        franco.agregarProducto(carrito, "Laptop Apple MacBook Pro", 2);
        franco.agregarProducto(carrito, "Cámara DSLR Canon EOS Rebel T7", 6);
        franco.agregarProducto(carrito, "Altavoz Amazon Echo Dot", 5);
        EstadoCarrito estadoCarritoActual = carrito.getEstadoCarritoActual();
        List<ItemCarrito> productos = estadoCarritoActual.getProductos();
        for (ItemCarrito itemCarrito: productos){
            System.out.println(itemCarrito.getProducto().getNombreProducto() + " " + itemCarrito.getProducto().getPrecio() + " " + itemCarrito.getCantidad());
        }
        System.out.println("");

        franco.guardarEstado(carrito);

        EstadoCarrito estadoCarritoActual1 = carrito.getEstadoCarritoActual();
        List<ItemCarrito> productos1 = estadoCarritoActual1.getProductos();
        for (ItemCarrito itemCarrito: productos1){
            System.out.println(itemCarrito.getProducto().getNombreProducto() + " " + itemCarrito.getProducto().getPrecio() + " " + itemCarrito.getCantidad());
        }
        System.out.println("");
        franco.agregarProducto(carrito, "Zumo de naranja", 5);
        EstadoCarrito estadoCarritoActual2 = carrito.getEstadoCarritoActual();
        List<ItemCarrito> productos2 = estadoCarritoActual2.getProductos();
        for (ItemCarrito itemCarrito: productos2){
            System.out.println(itemCarrito.getProducto().getNombreProducto() + " " + itemCarrito.getProducto().getPrecio() + " " + itemCarrito.getCantidad());
        }
        franco.modificarProducto(carrito, "Zumo de naranja", 3);
        EstadoCarrito estadoCarritoActual3 = carrito.getEstadoCarritoActual();
        List<ItemCarrito> productos3 = estadoCarritoActual3.getProductos();
        for (ItemCarrito itemCarrito: productos3){
            System.out.println(itemCarrito.getProducto().getNombreProducto() + " " + itemCarrito.getProducto().getPrecio() + " " + itemCarrito.getCantidad());
        }
        System.out.println("");
        franco.volverAEstadoAnterior(carrito);
        EstadoCarrito estadoCarritoActual4 = carrito.getEstadoCarritoActual();
        List<ItemCarrito> productos4 = estadoCarritoActual4.getProductos();
        for (ItemCarrito itemCarrito: productos4){
            System.out.println(itemCarrito.getProducto().getNombreProducto() + " " + itemCarrito.getProducto().getPrecio() + " " + itemCarrito.getCantidad());
        }
        System.out.println("");
        franco.recuperarEstado(carrito);
        EstadoCarrito estadoCarritoActual5 = carrito.getEstadoCarritoActual();
        List<ItemCarrito> productos5 = estadoCarritoActual5.getProductos();
        for (ItemCarrito itemCarrito: productos5){
            System.out.println(itemCarrito.getProducto().getNombreProducto() + " " + itemCarrito.getProducto().getPrecio() + " " + itemCarrito.getCantidad());
        }
        System.out.println("");
        franco.eliminarProducto(carrito, "Cámara DSLR Canon EOS Rebel T7");
        EstadoCarrito estadoCarritoActual6 = carrito.getEstadoCarritoActual();
        List<ItemCarrito> productos6 = estadoCarritoActual6.getProductos();
        for (ItemCarrito itemCarrito: productos6){
            System.out.println(itemCarrito.getProducto().getNombreProducto() + " " + itemCarrito.getProducto().getPrecio() + " " + itemCarrito.getCantidad());
        }

        franco.guardarEstado(carrito);

        System.out.println("");
        franco.volverAEstadoAnterior(carrito);
        franco.volverAEstadoAnterior(carrito);
        franco.modificarProducto(carrito, "Laptop Apple MacBook Pro", 15);
        EstadoCarrito estadoCarritoActual7 = carrito.getEstadoCarritoActual();
        List<ItemCarrito> productos7 = estadoCarritoActual7.getProductos();
        for (ItemCarrito itemCarrito: productos7){
            System.out.println(itemCarrito.getProducto().getNombreProducto() + " " + itemCarrito.getProducto().getPrecio() + " " + itemCarrito.getCantidad());
        }
        System.out.println("");
        franco.recuperarEstado(carrito);
        EstadoCarrito estadoCarritoActual8 = carrito.getEstadoCarritoActual();
        List<ItemCarrito> productos8 = estadoCarritoActual8.getProductos();
        for (ItemCarrito itemCarrito: productos8){
            System.out.println(itemCarrito.getProducto().getNombreProducto() + " " + itemCarrito.getProducto().getPrecio() + " " + itemCarrito.getCantidad());
        }








    }
}
