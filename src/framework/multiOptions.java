package framework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class multiOptions extends JPanel {
    public multiOptions(JFrame frame) {
        super(new GridLayout(3, 1));
        JButton host = new JButton("Хост");
        JButton klient = new JButton("Клиент");
        JButton back = new JButton("Назад");
        host.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        klient.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        back.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        this.add(host);
        this.add(klient);
        this.add(back);
        JPanel x = this;
        host.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KRESTNULL();
                frame.setVisible(false);
            }
        });
        klient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.setVisible(false);
                frame.add(new Klient(frame));
                frame.validate();
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.setVisible(false);
                frame.add(new Menu(frame));
                frame.validate();
            }
        });
    }
}
