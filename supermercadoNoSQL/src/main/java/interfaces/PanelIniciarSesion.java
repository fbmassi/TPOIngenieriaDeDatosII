package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelIniciarSesion extends JFrame{
    private JPanel panel;
    private JTextField usuarioTextField;
    private JTextField contraseñaTextField;
    private JButton iniciarSesionButton;
    private JButton atrásButton;
    private PanelAdministradores panelAdministradores;
    private PanelControlAdmin panelControlAdmin;

    public PanelIniciarSesion() {

        setTitle("Panel Iniciar Sesion");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        panelControlAdmin = new PanelControlAdmin();
        panelControlAdmin.setPanelIniciarSesion(this);

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
                if (panelAdministradores.getPanelPrincipal().getSistema().iniciarSesionAdmin(usuario, contraseña)) {
                    setVisible(false);
                    panelControlAdmin.setVisible(true);
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
