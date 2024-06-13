package interfaces;

import org.bson.Document;
import org.bson.types.ObjectId;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PanelRealizarPago extends JFrame {
    private JPanel panel;
    private JComboBox<String> pedidosPendientes;
    private JButton atrásButton;
    private JButton agregarALaListaButton;
    private JButton pagarConTarjetaButton;
    private JButton pagarConEfectivoButton;
    private JButton verPedidoButton;
    private PanelControlPagos panelControlPagos;
    private List<ObjectId> pedidosAPagar;
    private PanelVerPedido panelVerPedido;
    private PanelPagarEnEfectivo panelPagarEnEfectivo;
    private PanelPagarConTarjeta panelPagarConTarjeta;
    private Double montoTotal;

    public PanelRealizarPago() {

        setTitle("Pagos");
        setContentPane(panel);
        setSize(1000,700);
        setLocationRelativeTo(null);
        pedidosAPagar = new ArrayList<ObjectId>();
        panelVerPedido = new PanelVerPedido();
        panelVerPedido.setPanelRealizarPago(this);
        panelPagarEnEfectivo = new PanelPagarEnEfectivo();
        panelPagarEnEfectivo.setPanelRealizarPago(this);
        panelPagarConTarjeta = new PanelPagarConTarjeta();
        panelPagarConTarjeta.setPanelRealizarPago(this);
        montoTotal = 0.0;

        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                pedidosPendientes.removeAllItems();
                pedidosAPagar.clear();
                montoTotal = 0.0;
                panelControlPagos.setVisible(true);
            }
        });

        verPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String objectId = (String) pedidosPendientes.getSelectedItem();
                List<ObjectId> pedidos = panelControlPagos.getPanelControlCliente().getCliente().getPedidosPendientes();
                Document pedidoActual = null;
                for (ObjectId id: pedidos) {
                    if (objectId.equals(id.toString())) {
                        pedidoActual = panelControlPagos.getPanelControlCliente().getCliente().getPedido(id);
                    };
                }
                panelVerPedido.setPedido(pedidoActual);
                panelVerPedido.mostrarPedido();
                setVisible(false);
                panelVerPedido.setVisible(true);
            }
        });

        agregarALaListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String objectId = (String) pedidosPendientes.getSelectedItem();
                List<ObjectId> pedidos = panelControlPagos.getPanelControlCliente().getCliente().getPedidosPendientes();
                for (ObjectId id: pedidos) {
                    if (objectId.equals(id.toString())) {
                        pedidosAPagar.add(id);
                        montoTotal += panelControlPagos.getPanelControlCliente().getCliente().getPedido(id).getDouble("importe_final");
                    };
                }
                pedidosPendientes.removeItem(objectId);
            }
        });
        pagarConEfectivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelPagarEnEfectivo.setPedidosAPagar(pedidosAPagar);
                panelPagarEnEfectivo.setMonto(montoTotal);
                panelPagarEnEfectivo.setMontoEnPantalla();
                panelPagarEnEfectivo.setVisible(true);
            }
        });

        pagarConTarjetaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelPagarConTarjeta.setPedidosAPagar(pedidosAPagar);
                panelPagarConTarjeta.setMonto(montoTotal);
                panelPagarConTarjeta.setMontoEnPantalla();
                panelPagarConTarjeta.setVisible(true);
            }
        });

    }

    public PanelControlPagos getPanelControlPagos() {
        return panelControlPagos;
    }

    public void setPanelControlPagos(PanelControlPagos panelControlPagos) {
        this.panelControlPagos = panelControlPagos;
    }

    public void llenarLista() {
        List<ObjectId> pedidos = panelControlPagos.getPanelControlCliente().getCliente().getPedidosPendientes();
        for (ObjectId id: pedidos) {
            pedidosPendientes.addItem(id.toString());
        }
    }
}
