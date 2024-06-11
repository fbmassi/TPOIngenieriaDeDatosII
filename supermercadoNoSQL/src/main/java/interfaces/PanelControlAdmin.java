package interfaces;

import controladores.Administrador;
import controladores.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelControlAdmin extends JFrame{
    private JButton modificarProductosButton;
    private JButton verOperacionesButton;
    private JButton atrásButton;
    private JPanel panel;
    private JButton crearProductosButton;
    private PanelIniciarSesionAdmin panelIniciarSesionAdmin;
    private PanelModificaciónDeProductos panelModificaciónDeProductos;
    private PanelCrearProductos panelCrearProductos;
    private PanelControlDeLog panelControlDeLog;
    private Administrador administrador;

    public PanelControlAdmin() {
        setTitle("Panel de Control de Administrador");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        panelModificaciónDeProductos = new PanelModificaciónDeProductos();
        panelModificaciónDeProductos.setPanelControlAdmin(this);
        panelCrearProductos = new PanelCrearProductos();
        panelCrearProductos.setPanelControlAdmin(this);


        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                administrador.cerrarSesion();
                administrador = null;
                panelIniciarSesionAdmin.getPanelAdministradores().getPanelPrincipal().setVisible(true);
            }
        });
        modificarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelModificaciónDeProductos.setVisible(true);
            }
        });
        crearProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelCrearProductos.setVisible(true);
            }
        });
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public PanelIniciarSesionAdmin getPanelIniciarSesionAdmin() {
        return panelIniciarSesionAdmin;
    }

    public void setPanelIniciarSesionAdmin(PanelIniciarSesionAdmin panelIniciarSesionAdmin) {
        this.panelIniciarSesionAdmin = panelIniciarSesionAdmin;
    }
}
