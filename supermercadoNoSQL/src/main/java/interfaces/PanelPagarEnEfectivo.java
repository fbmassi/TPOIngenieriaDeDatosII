package interfaces;

import org.bson.Document;
import org.bson.types.ObjectId;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class PanelPagarEnEfectivo extends JFrame{
    private JButton atrasButton;
    private JButton pagarButton;
    private JPanel panel;
    private JLabel importe;
    private JLabel texto;
    private PanelRealizarPago panelRealizarPago;
    private List<ObjectId> pedidosAPagar;
    private Double monto;

    public PanelPagarEnEfectivo() {
        setTitle("Pagar en efectivo");
        setContentPane(panel);
        setSize(500,500);
        setLocationRelativeTo(null);

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelRealizarPago.setVisible(true);
            }
        });
        pagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ObjectId id: pedidosAPagar) {
                    panelRealizarPago.getPanelControlPagos().getPanelControlCliente().getCliente().generarFactura(id);
                }
                panelRealizarPago.getPanelControlPagos().getPanelControlCliente().getCliente().pagarPedidosEnEfectivo(pedidosAPagar);
                importe.setText("");
            }
        });
    }

    public void setPanelRealizarPago(PanelRealizarPago panelRealizarPago) {
        this.panelRealizarPago = panelRealizarPago;
    }

    public void setPedidosAPagar(List<ObjectId> pedidosAPagar) {
        this.pedidosAPagar = pedidosAPagar;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public void setMontoEnPantalla() {
        importe.setText(monto.toString());
    }
}
