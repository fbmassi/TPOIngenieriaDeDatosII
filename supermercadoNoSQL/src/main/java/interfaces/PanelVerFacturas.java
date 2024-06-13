package interfaces;

import negocios.ItemCarrito;
import org.bson.Document;

import javax.print.Doc;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelVerFacturas extends JFrame {
    private JButton volverAtrasButton;
    private JPanel panel;
    private JLabel factura;
    private Document documentoFactura;
    private PanelFacturas panelFacturas;


    public PanelVerFacturas() {
        setTitle("Panel Ver Facturas");
        setContentPane(panel);
        setSize(500,700);
        setLocationRelativeTo(null);
        factura.setSize(500, 500);


        volverAtrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                factura.setText("");
                getPanelFacturas().setVisible(true);
            }
        });
    }
    public PanelFacturas getPanelFacturas() {return panelFacturas;}
    public void setPanelFacturas(PanelFacturas panelFacturas) {this.panelFacturas = panelFacturas;}


    public void setDocumentoFactura(Document documentoFactura) {
        this.documentoFactura = documentoFactura;
    }

    public void setFactura(Document documentoFactura) {
        String setear = "<html>";
        setear += "<p> " + "PRODUCTOS" + " </p>";
        List<Document> productos = (List<Document>) documentoFactura.get("productos");
        for (Document doc: productos) {
            setear += "<p>" + doc.getString("producto") + " -  Precio: $" + String.format("%.2f",doc.getDouble("precio")) + " - Cantidad: " + doc.getInteger("cantidad") + "</p>";
        }
        setear += "<p>  </p>";
        setear += "<p> " + "IMPORTE PARCIAL: $" + String.format("%.2f", documentoFactura.getDouble("importe_parcial")) + " </p>";
        setear += "<p> " + "DESCUENTO: %" + documentoFactura.getInteger("descuentos") + " </p>";
        setear += "<p> " + "PRECIO BASE: $" + String.format("%.2f", documentoFactura.getDouble("precioBase")) + " </p>";
        setear += "<p> " + "IMPUESTOS: $" + String.format("%.2f", documentoFactura.getDouble("impuestos")) + " </p>";
        setear += "<p> " + "IMPORTE A PAGAR: $" + String.format("%.2f", documentoFactura.getDouble("importe_final")) + " </p>";
        setear += "</html>";
        factura.setText(setear);
    }
}
