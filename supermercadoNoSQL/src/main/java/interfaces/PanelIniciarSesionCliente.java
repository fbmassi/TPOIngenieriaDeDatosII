package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelIniciarSesionCliente extends JFrame {
    private JPanel panel;
    private JTextField nombreTextField;
    private JTextField DNITextField;
    private JButton iniciarSesionButton;
    private JButton atrásButton;
    private PanelClientes panelClientes;
    private PanelControlCliente panelControlCliente;
    private ErrorDeInicioDeSesion errorDeInicioDeSesion;

    public PanelIniciarSesionCliente() {

        setTitle("Panel Iniciar Sesion Cliente");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        panelControlCliente = new PanelControlCliente();
        panelControlCliente.setPanelIniciarSesionCliente(this);
        errorDeInicioDeSesion = new ErrorDeInicioDeSesion();

        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelClientes.setVisible(true);
            }
        });
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                String DNI = DNITextField.getText();
                nombreTextField.setText("");
                DNITextField.setText("");
                if (panelClientes.getPanelPrincipal().getSistema().iniciarSesionCliente(nombre, DNI)) {
                    setVisible(false);
                    panelControlCliente.setVisible(true);
                    panelControlCliente.setCliente(panelClientes.getPanelPrincipal().getSistema().recuperarCliente(nombre, DNI));
                } else {
                    errorDeInicioDeSesion.setVisible(true);
                };
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
