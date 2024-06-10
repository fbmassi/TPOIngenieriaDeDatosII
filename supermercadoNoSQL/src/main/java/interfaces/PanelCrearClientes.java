package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCrearClientes extends JFrame {
    private JTextField nombreTextField;
    private JTextField DNITextField;
    private JTextField direccionTextField;
    private JButton atrasButton;
    private JButton crearUsuarioButton;
    private JPanel panel;
    private PanelClientes panelClientes;

    public PanelCrearClientes() {
        setTitle("Panel Crear Clientes");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelClientes.setVisible(true);
            }
        });
        crearUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                String DNI = DNITextField.getText();
                String direccion = direccionTextField.getText();
                nombreTextField.setText("");
                DNITextField.setText("");
                direccionTextField.setText("");
                panelClientes.getPanelPrincipal().getSistema().crearCliente(nombre,direccion,DNI);
            }
        });
    }

    public PanelClientes getPanelClientes() {
        return panelClientes;
    }

    public void setPanelClientes(PanelClientes panelClientes) {
        this.panelClientes = panelClientes;
    }
}
