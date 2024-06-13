package interfaces;

import controladores.Cliente;
import negocios.Carrito;

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
        iniciarCompra.setPanelControlCliente(this);
        panelControlPagos = new PanelControlPagos();
        panelControlPagos.setPanelControlCliente(this);

        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                cliente.cerrarSesion();
                cliente = null;
                panelIniciarSesionCliente.getPanelClientes().getPanelPrincipal().setVisible(true);
            }
        });
        iniciarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Carrito carrito = cliente.iniciarCompra();
                iniciarCompra.setCarrito(carrito);
                iniciarCompra.llenarListas();
                iniciarCompra.setVisible(true);
            }
        });
        controlDePagosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelControlPagos.setVisible(true);
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
