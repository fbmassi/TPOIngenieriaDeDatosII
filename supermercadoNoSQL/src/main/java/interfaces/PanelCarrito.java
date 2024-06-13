package interfaces;

import negocios.EstadoCarrito;
import negocios.ItemCarrito;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCarrito extends JFrame {
    private JPanel panel1;
    private JButton atrasButton;
    private JLabel mostrar;
    private PanelIniciarCompra  panelIniciarCompra;
    private EstadoCarrito carrito;

    public PanelCarrito() {

        setTitle("Panel Carrito");
        setContentPane(panel1);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        mostrar.setSize(500, 700);


        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrar.setText("");
                setVisible(false);
                panelIniciarCompra.setVisible(true);
            }
        });
    }

    public void setPanelIniciarCompra(PanelIniciarCompra panelIniciarCompra) {
        this.panelIniciarCompra = panelIniciarCompra;
    }

    public void setCarrito(EstadoCarrito carrito) {
        this.carrito = carrito;
    }

    public void setearPantalla() {
        String setearPantalla = "<html>";

        for (ItemCarrito item: carrito.getProductos()) {
            setearPantalla += "<p>" + item.getProducto().getNombreProducto();
            setearPantalla += " - $" + String.format("%.2f",item.getProducto().getPrecio());
            setearPantalla += " - Cantidad: " + item.getCantidad() + "</p>";
        }

        setearPantalla += "</html>";

        mostrar.setText(setearPantalla);
    }
}
