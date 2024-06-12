package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCarrito extends JFrame {
    private JTable table1;
    private JPanel panel1;
    private JButton atrasButton;
    private PanelIniciarCompra  panelIniciarCompra;

    public PanelCarrito() {

        setTitle("Panel Carrito");
        setContentPane(panel1);
        setSize(500, 500);
        setLocationRelativeTo(null);

        table1 = new JTable();
        /*list<String> carrito = cotrolador.
        for (String prod :carrito){
            table1.add(prod);
        }
        */


        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelIniciarCompra.setVisible(true);
            }
        });
    }
}
