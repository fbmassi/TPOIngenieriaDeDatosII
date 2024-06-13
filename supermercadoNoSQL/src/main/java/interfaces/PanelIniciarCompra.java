package interfaces;

import negocios.Carrito;

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
    private JTextField codigoDescuento;
    private JButton eliminarDelCarritoButton;
    private JButton modificarCantidadButton;
    private JButton guardarEstadoButton;
    private PanelIniciarCompra panelIniciarCompra;
    private PanelControlCliente panelControlCliente;
    private PanelCarrito panelCarrito;
    private Carrito carrito;

    public PanelIniciarCompra() {

        setTitle("Panel Iniciar Compra");
        setContentPane(panel);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        panelCarrito = new PanelCarrito();
        panelCarrito.setPanelIniciarCompra(this);

        agregarAlCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String articulo = (String) comboBoxProductos.getSelectedItem();
                String cant =  cantidadTextField.getText();
                try {
                    int cantidad = Integer.parseInt(cant);
                    panelControlCliente.getCliente().agregarProducto(carrito, articulo, cantidad);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Error. Ingrese un numero en 'cantidad'");
                }
                cantidadTextField.setText("Cantidad...");
            }
        });

        volverAtrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelControlCliente.setVisible(true);
            }
        });

        confirmarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControlCliente.getCliente().confirmarPedido(carrito, codigoDescuento.getText());
                codigoDescuento.setText("");
                carrito = null;
                setVisible(false);
                panelControlCliente.setVisible(true);
            }
        });

        recuperarEstadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControlCliente.getCliente().recuperarEstado(carrito);
            }
        });
        volverAlEstadoAnteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControlCliente.getCliente().volverAEstadoAnterior(carrito);
            }
        });
        verCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelCarrito.setCarrito(carrito.getEstadoCarritoActual());
                panelCarrito.setearPantalla();
                panelCarrito.setVisible(true);
            }
        });
        eliminarDelCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String articulo = (String) comboBoxProductos.getSelectedItem();
                panelControlCliente.getCliente().eliminarProducto(carrito, articulo);
            }
        });
        modificarCantidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String articulo = (String) comboBoxProductos.getSelectedItem();
                String cant =  cantidadTextField.getText();
                try {
                    int cantidad = Integer.parseInt(cant);
                    panelControlCliente.getCliente().modificarProducto(carrito, articulo,cantidad);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Error. Ingrese un numero en 'cantidad'");
                }
                cantidadTextField.setText("Cantidad...");
            }
        });
        guardarEstadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControlCliente.getCliente().guardarEstado(carrito);
                cantidadTextField.setText("Cantidad...");
            }
        });
    }

    public PanelIniciarCompra getPanelIniciarCompra() {
        return panelIniciarCompra;
    }


    public void setPanelIniciarCompra(PanelIniciarCompra panelIniciarCompra) {
        this.panelIniciarCompra= panelIniciarCompra;
    }

    public PanelControlCliente getPanelControlCliente() { return panelControlCliente;}
    public void setPanelControlCliente(PanelControlCliente panelControlCliente) {
        this.panelControlCliente = panelControlCliente;
    }

    public void llenarListas() {
        List<String> products = panelControlCliente.getPanelIniciarSesionCliente().getPanelClientes().getPanelPrincipal().getSistema().obtenerNombreProducto();
        for (String product : products) {
            comboBoxProductos.addItem(product);
        }
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
}
