package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCrearAdmin extends JFrame {
    private JTextField usuarioTextField;
    private JTextField contraseñaTextField;
    private JButton crearAdministradorButton;
    private JPanel panel;
    private JButton atrásButton;
    private PanelAdministradores panelAdministradores;

    public PanelCrearAdmin() {

        setTitle("Crear Administrador");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);

        crearAdministradorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioTextField.getText();
                String contraseña = contraseñaTextField.getText();
                usuarioTextField.setText("");
                contraseñaTextField.setText("");
                getPanelAdministradores().getPanelPrincipal().getSistema().crearAdmin(usuario, contraseña);
            }
        });
        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelAdministradores.setVisible(true);
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
