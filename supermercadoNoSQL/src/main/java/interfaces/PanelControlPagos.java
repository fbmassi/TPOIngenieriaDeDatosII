package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PanelControlPagos extends JFrame {
    private JPanel panel;
    private JButton facturasButton;
    private JButton pagosPendientesButton;
    private JButton volverAtrasButton;
    private PanelControlCliente panelControlCliente;
    private PanelFacturas panelFacturas;
    private PanelPagosPendientes pagosPendientes;


    public PanelControlPagos() {

        setTitle("Control de Pagos");
        setContentPane(panel);
        setSize(500,500);
        setLocationRelativeTo(null);
        panelFacturas = new PanelFacturas();
        panelFacturas.setPanelControlPagos(this);

        facturasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelFacturas.setVisible(true);
            }
        });
        pagosPendientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                //panelPagosPendientes.setVisible(true);
                //
            }
        });
        volverAtrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                //getPanelControlCliente.setVisible(true);
            }
        });
    }
}
