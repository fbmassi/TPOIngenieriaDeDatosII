package interfaces;

import org.bson.types.ObjectId;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelPagarConTarjeta extends JFrame {
    private JPanel panel;
    private JButton atrasButton;
    private JButton pagarButton;
    private JTextField numeroDeTarjetaTextField;
    private JTextField codigoDeSeguridadTextField;
    private JComboBox<String> operadores;
    private JLabel texto;
    private JLabel importe;
    private PanelRealizarPago panelRealizarPago;
    private List<ObjectId> pedidosAPagar;
    private Double monto;

    public PanelPagarConTarjeta() {
        setTitle("Pagar con tarjeta");
        setContentPane(panel);
        setSize(1000,700);
        setLocationRelativeTo(null);
        operadores.addItem("VISA");
        operadores.addItem("AMEX");
        operadores.addItem("MASTER");

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
                panelRealizarPago.getPanelControlPagos().getPanelControlCliente().getCliente().pagarPedidosConTarjeta(pedidosAPagar, (String) operadores.getSelectedItem(), numeroDeTarjetaTextField.getText(), codigoDeSeguridadTextField.getText());
                importe.setText("0.0");
                numeroDeTarjetaTextField.setText("");
                codigoDeSeguridadTextField.setText("");
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
