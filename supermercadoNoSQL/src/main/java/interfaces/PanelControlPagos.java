package interfaces;

import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelControlPagos extends JFrame {
    private JPanel panel;
    private JButton facturasButton;
    private JButton pagosPendientesButton;
    private JButton volverAtrasButton;
    private PanelControlCliente panelControlCliente;
    private PanelFacturas panelFacturas;
    private PanelRealizarPago panelRealizarPago;

    public PanelControlPagos() {

        setTitle("Control de Pagos");
        setContentPane(panel);
        setSize(500,500);
        setLocationRelativeTo(null);
        panelFacturas = new PanelFacturas();
        panelFacturas.setPanelControlPagos(this);
        panelRealizarPago = new PanelRealizarPago();
        panelRealizarPago.setPanelControlPagos(this);

        facturasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelFacturas.llenarLista();
                panelFacturas.setVisible(true);
            }
        });
        pagosPendientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelRealizarPago.llenarLista();
                panelRealizarPago.setVisible(true);
            }
        });
        volverAtrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelControlCliente.setVisible(true);
            }
        });
    }

    public void setPanelControlCliente(PanelControlCliente panelControlCliente) {
        this.panelControlCliente = panelControlCliente;
    }

    public PanelControlCliente getPanelControlCliente() {
        return this.panelControlCliente;
    }

    public PanelRealizarPago getPanelRealizarPago() {
        return panelRealizarPago;
    }

    public void setPanelRealizarPago(PanelRealizarPago panelRealizarPago) {
        this.panelRealizarPago = panelRealizarPago;
    }

}
