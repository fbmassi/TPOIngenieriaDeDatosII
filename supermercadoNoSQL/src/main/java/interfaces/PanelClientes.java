package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelClientes extends JFrame {
    private JButton crearClienteButton;
    private JButton iniciarSesionButton;
    private JButton atrásButton;
    private JPanel panel;
    private PanelPrincipal panelPrincipal;
    private PanelCrearClientes panelCrearClientes;

    public PanelClientes() {

        setTitle("Panel Clientes");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        panelCrearClientes = new PanelCrearClientes();
        panelCrearClientes.setPanelClientes(this);

        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                getPanelPrincipal().setVisible(true);
            }
        });
        crearClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelCrearClientes.setVisible(true);

            }
        });
    }

    public PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }
}
