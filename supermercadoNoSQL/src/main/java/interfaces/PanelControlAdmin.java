package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelControlAdmin extends JFrame{
    private JButton modificarProductosButton;
    private JButton verOperacionesButton;
    private JButton atrásButton;
    private JPanel panel;
    private PanelIniciarSesion panelIniciarSesion;
    private PanelModificaciónDeProductos panelModificaciónDeProductos;

    public PanelControlAdmin() {
        setTitle("Panel de Control de Administrador");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        panelModificaciónDeProductos = new PanelModificaciónDeProductos();
        panelModificaciónDeProductos.setPanelControlAdmin(this);


        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelIniciarSesion.getPanelAdministradores().getPanelPrincipal().setVisible(true);
            }
        });
        modificarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelModificaciónDeProductos.setVisible(true);
            }
        });
    }

    public PanelIniciarSesion getPanelIniciarSesion() {
        return panelIniciarSesion;
    }

    public void setPanelIniciarSesion(PanelIniciarSesion panelIniciarSesion) {
        this.panelIniciarSesion = panelIniciarSesion;
    }
}
