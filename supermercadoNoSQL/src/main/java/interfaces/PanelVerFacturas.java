package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelVerFacturas extends JFrame {
    private JButton volverAtrasButton;
    private JPanel panel;
    private JPanel panelSecundario; //este para proyectar los datos de la factura, hace falta?
    private PanelFacturas panelFacturas;

    public PanelVerFacturas() {
        setTitle("Panel Ver Facturas");
        setContentPane(panel);
        setSize(500,500);
        setLocationRelativeTo(null);


        volverAtrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                getPanelFacturas().setVisible(true);
            }
        });
    }
    public PanelFacturas getPanelFacturas() {return panelFacturas;}
    public void setPanelFacturas(PanelFacturas panelFacturas) {this.panelFacturas = panelFacturas;}

}
