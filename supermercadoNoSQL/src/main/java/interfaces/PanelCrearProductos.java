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
    private Sistema sistema;
    private Administrador administrador;

    public PanelCrearProductos() {

        setTitle("Panel de Control de Administrador");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        sistema = panelControlAdmin.getPanelIniciarSesion().getPanelAdministradores().getPanelPrincipal().getSistema();
        administrador = panelControlAdmin.getAdministrador();

        List<String> products = sistema.obtenerProductosTexto();
        for (String product: products) {
            productos.addItem(product);
        }

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelControlAdmin.setVisible(true);
            }
        });
        crearProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                String descripcion = descripciónTextField.getText();
                String precioText = precioTextField.getText();

                // Validación de datos
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

                administrador.agregarProducto(nombre, descripcion, precio);
                boolean productoCreado = sistema.existeProducto(nombre);
                
                if (productoCreado) {
                    productos.addItem(nombre + " - " + descripcion + " - $" + precio);
                    JOptionPane.showMessageDialog(panel, "Producto creado correctamente.");
                    // Limpiar los campos de texto
                    nombreTextField.setText("");
                    descripciónTextField.setText("");
                    precioTextField.setText("");
                } else {
                    JOptionPane.showMessageDialog(panel, "Error al crear el producto.");
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
