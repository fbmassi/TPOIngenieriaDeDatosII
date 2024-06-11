package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelControlDeLog extends JFrame{
    private JPanel panel;
    private JButton atrásButton;
    private JComboBox<String> registros;
    private PanelControlAdmin panelControlAdmin;

    public PanelControlDeLog() {

        setTitle("Panel de Control de Operaciones");
        setContentPane(panel);
        setSize(1300, 500);
        setLocationRelativeTo(null);

        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                registros.removeAllItems();
                panelControlAdmin.setVisible(true);
            }
        });
    }


    public void llenarListas() {
        List<String> registrosObtenidos = panelControlAdmin.getAdministrador().traerLogDeTodoElCatalogo();
        for (String log: registrosObtenidos) {
            registros.addItem(log);
        }

    }

    public void setPanelControlAdmin(PanelControlAdmin panelControlAdmin) {
        this.panelControlAdmin = panelControlAdmin;
    }
}
