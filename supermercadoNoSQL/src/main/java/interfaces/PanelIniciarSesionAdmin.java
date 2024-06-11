package interfaces;

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
    private ErrorDeInicioDeSesion errorDeInicioDeSesion;

    public PanelIniciarSesionAdmin() {

        setTitle("Panel Iniciar Sesion Administrador");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        panelControlAdmin = new PanelControlAdmin();
        panelControlAdmin.setPanelIniciarSesionAdmin(this);
        errorDeInicioDeSesion = new ErrorDeInicioDeSesion();

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
                    panelControlAdmin.setAdministrador(panelAdministradores.getPanelPrincipal().getSistema().recupararAdmin(usuario, contraseña));
                } else {
                    errorDeInicioDeSesion.setVisible(true);
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
