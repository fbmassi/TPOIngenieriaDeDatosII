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
    private PanelIniciarSesion panelIniciarSesion;

    public PanelAdministradores() {

        setTitle("Panel Administradores");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        panelCrearAdmin = new PanelCrearAdmin();
        panelIniciarSesion = new PanelIniciarSesion();
        panelCrearAdmin.setPanelAdministradores(this);
        panelIniciarSesion.setPanelAdministradores(this);


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
                panelIniciarSesion.setVisible(true);
            }
        });
    }

    public PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public PanelIniciarSesion getPanelIniciarSesion() {
        return panelIniciarSesion;
    }

    public void setPanelIniciarSesion(PanelIniciarSesion panelIniciarSesion) {
        this.panelIniciarSesion = panelIniciarSesion;
    }
}
