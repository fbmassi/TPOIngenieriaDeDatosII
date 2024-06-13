package interfaces;

import controladores.Administrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelIniciarSesionAdmin extends JFrame{
    private JPanel panel;
    private JTextField usuarioTextField;
    private JTextField contraseñaTextField;
    private JButton iniciarSesionButton;
    private JButton atrásButton;
    private PanelAdministradores panelAdministradores;
    private PanelControlAdmin panelControlAdmin;

    public PanelIniciarSesionAdmin() {

        setTitle("Panel Iniciar Sesion Administrador");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        panelControlAdmin = new PanelControlAdmin();
        panelControlAdmin.setPanelIniciarSesionAdmin(this);

        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelAdministradores.setVisible(true);
            }
        });
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioTextField.getText();
                String contraseña = contraseñaTextField.getText();
                usuarioTextField.setText("");
                contraseñaTextField.setText("");
                Administrador administrador = new Administrador(usuario, contraseña);
                if (administrador.getSesion()) {
                    setVisible(false);
                    panelControlAdmin.setVisible(true);
                    panelControlAdmin.setAdministrador(administrador);
                } else {
                    JOptionPane.showMessageDialog(panel, "Error en el inicio de sesion. Usuario o Contraseña incorrectos.");
                };
            }
        });
    }

    public PanelAdministradores getPanelAdministradores() {
        return panelAdministradores;
    }

    public void setPanelAdministradores(PanelAdministradores panelAdministradores) {
        this.panelAdministradores = panelAdministradores;
    }
}
