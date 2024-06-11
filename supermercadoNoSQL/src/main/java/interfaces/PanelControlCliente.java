package interfaces;

import controladores.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelControlCliente extends JFrame {
    private JButton controlDePagosButton;
    private JButton atrásButton;
    private JButton iniciarCompraButton;
    private JPanel panel;
    private PanelIniciarSesionCliente  panelIniciarSesionCliente;
    private Cliente cliente;
    private PanelIniciarCompra iniciarCompra;
    private PanelControlPagos panelControlPagos;


    public PanelControlCliente() {

        setTitle("Panel Iniciar Sesion Cliente");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        iniciarCompra = new PanelIniciarCompra();
        panelControlPagos = new PanelControlPagos();

        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                cliente.cerrarSesion();
                cliente = null;
                panelIniciarSesionCliente.getPanelClientes().getPanelPrincipal().setVisible(true);
            }
        });
    }

    public PanelIniciarSesionCliente getPanelIniciarSesionCliente() {
        return panelIniciarSesionCliente;
    }

    public void setPanelIniciarSesionCliente(PanelIniciarSesionCliente panelIniciarSesionCliente) {
        this.panelIniciarSesionCliente = panelIniciarSesionCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
