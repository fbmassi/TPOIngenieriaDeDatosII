package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelIniciarCompra extends JFrame {
    private JPanel panel;
    private JComboBox<String> comboBoxProductos;
    private JTextField cantidadTextField;
    private JButton agregarAlCarritoButton;
    private JButton confirmarCompraButton;
    private JButton recuperarEstadoButton;
    private JButton volverAlEstadoAnteriorButton;
    private JButton volverAtrasButton;
    private JButton verCarritoButton;
    private PanelIniciarCompra panelIniciarCompra;
    private PanelControlCliente panelControlCliente;
    private PanelCarrito panelCarrito;

    public PanelIniciarCompra() {

        setTitle("Panel Iniciar Compra");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);

        panelCarrito=new PanelCarrito();
        /*List<String> products = panelClientes.getPanelPrincipal().getSistema().obtenerProductosTexto();
        for (String product : products) {
            comboBoxProductos.addItem(product);
        }
        */

        agregarAlCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String articulo = comboBoxProductos.getSelectedItem();
                String cant=  cantidadTextField.getText();
                int cantidad = Integer.parseInt(cant);

            }
        });
        volverAtrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelControlCliente.getPanelIniciarSesionCliente().setVisible(true);
            }
        });
        confirmarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        recuperarEstadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        volverAlEstadoAnteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        verCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelCarrito.setVisible(true);
            }
        });
    }
    public PanelIniciarCompra getPanelIniciarCompra() { return panelIniciarCompra;}
    public void setPanelIniciarCompra(PanelIniciarCompra panelIniciarCompra) {
        this.panelIniciarCompra= panelIniciarCompra;
    }

    public PanelControlCliente getPanelControlCliente() { return panelControlCliente;}
    public void setPanelControlCliente(PanelControlCliente panelControlCliente) {
        this.panelControlCliente = panelControlCliente;
    }
}
