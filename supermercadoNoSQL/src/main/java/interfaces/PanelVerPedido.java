package interfaces;

import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class PanelVerPedido extends JFrame{
    private JButton atrásButton;
    private JPanel panel;
    private JLabel textoPedido;
    private Document pedido;
    private PanelRealizarPago panelRealizarPago;

    public PanelVerPedido() {
        setTitle("Pedido");
        setContentPane(panel);
        setSize(700,500);
        setLocationRelativeTo(null);
        textoPedido.setSize(500, 500);
        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                pedido = null;
                textoPedido.setText("");
                panelRealizarPago.setVisible(true);
            }
        });
    }

    public Document getPedido() {
        return pedido;
    }

    public void setPedido(Document pedido) {
        this.pedido = pedido;
    }

    public PanelRealizarPago getPanelRealizarPago() {
        return panelRealizarPago;
    }

    public void setPanelRealizarPago(PanelRealizarPago panelRealizarPago) {
        this.panelRealizarPago = panelRealizarPago;
    }

    public void mostrarPedido() {
        String setear = "<html>";
        setear += "<p> " + "PRODUCTOS" + " </p>";
        List<Document> productos = (List<Document>) pedido.get("productos");
        for (Document doc: productos) {
            setear += "<p>" + doc.getString("producto") + " - " + doc.getDouble("precio") + " - " + doc.getInteger("cantidad") + "</p>";
        }
        setear += "<p> </p>";
        setear += "<p> " + "DESCUENTO: " + pedido.getInteger("descuentos") + " </p>";
        setear += "<p> </p>";
        setear += "<p> " + "IMPORTE A PAGAR: " + pedido.getDouble("importe_final") + " </p>";
        setear += "</html>";
        textoPedido.setText(setear);
    }
}
