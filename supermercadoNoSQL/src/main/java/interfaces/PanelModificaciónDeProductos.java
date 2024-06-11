package interfaces;

import controladores.Administrador;
import controladores.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelModificaciónDeProductos extends JFrame {
    private JPanel panel;
    private JButton atrásButton;
    private JComboBox<String> comboBox1;
    private JTextField nuevoPrecioTextField;
    private JTextField nuevaDescripciónTextField;
    private JButton cambiarPrecioButton;
    private JButton cambiarDescripciónButton;
    private JButton eliminarProductoButton;
    private PanelControlAdmin panelControlAdmin;
    private Sistema sistema;
    private Administrador administrador;

    public PanelModificaciónDeProductos() {

        setTitle("Panel de Control de Catalogo");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        sistema = panelControlAdmin.getPanelIniciarSesion().getPanelAdministradores().getPanelPrincipal().getSistema();
        administrador = panelControlAdmin.getAdministrador();

        List<String> products = sistema.obtenerNombreProducto();
        for (String product: products) {
            comboBox1.addItem(product);
        }

        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelControlAdmin.setVisible(true);
            }
        });

        eliminarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String producto = (String) comboBox1.getSelectedItem();
                if (producto != null) {
                    administrador.eliminarProducto(producto);
                    JOptionPane.showMessageDialog(panel, "Producto eliminado correctamente.");
                }
                List<String> products = sistema.obtenerNombreProducto();
                for (String product: products) {
                    comboBox1.addItem(product);
                }
            }
        });

        cambiarDescripciónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedProduct = (String) comboBox1.getSelectedItem();
                String nuevaDescripcion = nuevaDescripciónTextField.getText();
                if (selectedProduct != null && !nuevaDescripcion.isEmpty()) {
                    administrador.actualizarDescripcionProducto(selectedProduct, nuevaDescripcion);
                    JOptionPane.showMessageDialog(panel, "Descripción cambiada correctamente.");
                }
                nuevaDescripciónTextField.setText("");
                List<String> products = sistema.obtenerNombreProducto();
                for (String product: products) {
                    comboBox1.addItem(product);
                }
            }
        });
        cambiarPrecioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedProduct = (String) comboBox1.getSelectedItem();
                String nuevoPrecioText = nuevoPrecioTextField.getText();
                if (selectedProduct != null && !nuevoPrecioText.isEmpty()) {
                    try {
                        double nuevoPrecio = Double.parseDouble(nuevoPrecioText);
                        administrador.actualizarPrecioProducto(selectedProduct, nuevoPrecio);
                        JOptionPane.showMessageDialog(panel, "Precio cambiado correctamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(panel, "Por favor ingrese un precio válido.");
                    }
                }
                nuevoPrecioTextField.setText("");
                List<String> products = sistema.obtenerNombreProducto();
                for (String product: products) {
                    comboBox1.addItem(product);
                }
            }
        });
    }

    public PanelControlAdmin getPanelControlAdmin() {
        return panelControlAdmin;
    }

    public void setPanelControlAdmin(PanelControlAdmin panelControlAdmin) {
        this.panelControlAdmin = panelControlAdmin;
    }
}
