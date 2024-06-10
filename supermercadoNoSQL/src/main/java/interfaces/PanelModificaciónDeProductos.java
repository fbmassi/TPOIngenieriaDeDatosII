package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelModificaciónDeProductos extends JFrame {
    private JPanel panel;
    private JButton atrásButton;
    private PanelControlAdmin panelControlAdmin;

    public PanelModificaciónDeProductos() {

        setTitle("Panel de Control de Catalogo");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);

        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelControlAdmin.setVisible(true);
            }
        });
    }

    public PanelControlAdmin getPanelControlAdmin() {
        return panelControlAdmin;
    }

    public void setPanelControlAdmin(PanelControlAdmin panelControlAdmin) {
        this.panelControlAdmin = panelControlAdmin;
    }
}
