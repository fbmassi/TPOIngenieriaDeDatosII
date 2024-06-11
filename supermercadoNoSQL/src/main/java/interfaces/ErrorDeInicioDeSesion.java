package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorDeInicioDeSesion extends JFrame{
    private JPanel panel;
    private JLabel error;
    private JButton volverButton;

    public ErrorDeInicioDeSesion() {

        setTitle("Error");
        setContentPane(panel);
        setSize(500, 500);
        setLocationRelativeTo(null);

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
