package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAdministradores extends JFrame{
    private JButton crearAdministradorButton;
    private JButton iniciarSesionButton;
    private JButton atrásButton;
    private JPanel panel;
    private PanelPrincipal panelPrincipal;
    private PanelCrearAdmin panelCrearAdmin;
    private PanelIniciarSesionAdmin panelIniciarSesionAdmin;

    public PanelAdministradores() {

        setTitle("Panel Administradores");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        panelCrearAdmin = new PanelCrearAdmin();
        panelIniciarSesionAdmin = new PanelIniciarSesionAdmin();
        panelCrearAdmin.setPanelAdministradores(this);
        panelIniciarSesionAdmin.setPanelAdministradores(this);


        crearAdministradorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelCrearAdmin.setVisible(true);
            }
        });
        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelPrincipal.setVisible(true);
            }
        });
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelIniciarSesionAdmin.setVisible(true);
            }
        });
    }

    public PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public PanelIniciarSesionAdmin getPanelIniciarSesion() {
        return panelIniciarSesionAdmin;
    }

    public void setPanelIniciarSesion(PanelIniciarSesionAdmin panelIniciarSesion) {
        this.panelIniciarSesionAdmin = panelIniciarSesion;
    }
}
