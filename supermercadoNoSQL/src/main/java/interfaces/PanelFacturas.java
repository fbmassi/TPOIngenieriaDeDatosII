package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class PanelFacturas extends JFrame{
    private JComboBox verFacturaComboBox;
    private JPanel panel;
    private JButton verFacturaButton;
    private JButton volverAtrasButton;
    private PanelControlPagos panelControlPagos;

    public PanelFacturas() {

        setTitle("Panel de Facturas");
        setContentPane(panel);
        setSize(500,500);
        setLocationRelativeTo(null);
        //panelControlPagos = new PanelControlPagos();
        //panelControlPagos.setPanelFacturas(this);

        verFacturaComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        verFacturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        volverAtrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                getPanelControlPagos().setVisible(true);
            }
        });
    }
    public PanelControlPagos getPanelControlPagos() {return panelControlPagos;}
    public void setPanelControlPagos(PanelControlPagos panelControlPagos) {this.panelControlPagos = panelControlPagos;}
}