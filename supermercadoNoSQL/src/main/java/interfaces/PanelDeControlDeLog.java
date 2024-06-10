package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDeControlDeLog extends JFrame{
    private JPanel panel;
    private PanelControlAdmin panelControlAdmin;
    private JButton atrásButton;

    public PanelDeControlDeLog() {
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
