package interfaces;

import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PanelFacturas extends JFrame{
    private JComboBox<String> facturas;
    private JPanel panel;
    private JButton verFacturaButton;
    private JButton volverAtrasButton;
    private PanelControlPagos panelControlPagos;
    private PanelVerFacturas panelVerFacturas;
    private List<Document> facturasAMostrar;

    public PanelFacturas() {

        setTitle("Panel de Facturas");
        setContentPane(panel);
        setSize(600,500);
        setLocationRelativeTo(null);
        panelVerFacturas = new PanelVerFacturas();
        panelVerFacturas.setPanelFacturas(this);
        facturasAMostrar = new ArrayList<Document>();

        verFacturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = facturas.getSelectedIndex();
                if (selectedIndex != -1 && facturasAMostrar != null) {
                    Document selectedFactura = facturasAMostrar.get(selectedIndex);
                    panelVerFacturas.setFactura(selectedFactura);
                    setVisible(false);
                    panelVerFacturas.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una factura de la lista");
                }
            }
        });
        volverAtrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                facturas.removeAllItems();
                facturasAMostrar.clear();
                getPanelControlPagos().setVisible(true);
            }
        });
    }

    public PanelControlPagos getPanelControlPagos() {return panelControlPagos;}
    public void setPanelControlPagos(PanelControlPagos panelControlPagos) {this.panelControlPagos = panelControlPagos;}

    public void llenarLista() {
        facturasAMostrar = panelControlPagos.getPanelControlCliente().getCliente().obtenerFacturasCliente();
        facturas.removeAllItems();
        for (Document doc : facturasAMostrar) {
            facturas.addItem("Fecha: " + doc.getString("fecha") + " - Importe: $" + String.format("%.2f",doc.getDouble("importe_final")));
        }
    }
}