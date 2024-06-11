package interfaces;

import controladores.Administrador;
import controladores.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelCrearProductos extends JFrame{
    private JButton atrasButton;
    private JTextField nombreTextField;
    private JTextField descripciónTextField;
    private JTextField precioTextField;
    private JButton crearProductoButton;
    private JComboBox productos;
    private JPanel panel;
    private PanelControlAdmin panelControlAdmin;

    public PanelCrearProductos() {

        setTitle("Panel de Creación de Productos");
        setContentPane(panel);
        setSize(1500, 500);
        setLocationRelativeTo(null);

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                productos.removeAllItems();
                panelControlAdmin.setVisible(true);
            }
        });
        crearProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                String descripcion = descripciónTextField.getText();
                String precioText = precioTextField.getText();

                if (nombre.isEmpty() || descripcion.isEmpty() || precioText.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Todos los campos deben estar llenos.");
                    return;
                }

                double precio;
                try {
                    precio = Double.parseDouble(precioText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "El precio debe ser un número válido.");
                    return;
                }

                panelControlAdmin.getAdministrador().agregarProducto(nombre, descripcion, precio);
                boolean productoCreado = panelControlAdmin.getPanelIniciarSesionAdmin().getPanelAdministradores().getPanelPrincipal().getSistema().existeProducto(nombre);
                
                if (productoCreado) {
                    productos.addItem(nombre + " - " + descripcion + " - $" + precio);
                    JOptionPane.showMessageDialog(panel, "Producto creado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(panel, "Error al crear el producto.");
                }

                nombreTextField.setText("");
                descripciónTextField.setText("");
                precioTextField.setText("");
            }
        });
    }

    public PanelControlAdmin getPanelControlAdmin() {
        return panelControlAdmin;
    }

    public void setPanelControlAdmin(PanelControlAdmin panelControlAdmin) {
        this.panelControlAdmin = panelControlAdmin;
    }


    public void llenarListas () {
        List<String> products = panelControlAdmin.getPanelIniciarSesionAdmin().getPanelAdministradores().getPanelPrincipal().getSistema().obtenerProductosTexto();
        for (String product: products) {
            productos.addItem(product);
        }
    }
}
