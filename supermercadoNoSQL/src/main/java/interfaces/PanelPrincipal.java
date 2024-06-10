package interfaces;

import controladores.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class PanelPrincipal extends JFrame{
    private JButton administradoresButton;
    private JPanel panel;
    private JButton clientesButton;
    private PanelAdministradores panelAdministradores;
    private PanelClientes panelClientes;
    private Sistema sistema;

    public PanelPrincipal() {

        sistema = new Sistema();
        setTitle("Panel Principal");
        setContentPane(panel);
        setVisible(true);
        setSize(500, 500);
        setLocationRelativeTo(null);
        panelAdministradores = new PanelAdministradores();
        panelAdministradores.setPanelPrincipal(this);
        panelClientes = new PanelClientes();
        panelClientes.setPanelPrincipal(this);

        administradoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelAdministradores.setVisible(true);
            }
        });
        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelClientes.setVisible(true);
            }
        });
    }

    public Sistema getSistema() {
        return sistema;
    }
}
