package framework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    public Menu(JFrame frame) {
        super(new GridLayout(3, 1));
        JButton play = new JButton("Играть");
        JButton multy = new JButton("Мультиплеер");
        JButton exit = new JButton("Выйти");
        play.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        multy.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        exit.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        this.add(play);
        this.add(multy);
        this.add(exit);
        JPanel x = this;
        frame.add(x);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KRESTNULL();
                frame.setVisible(false);
            }
        });
        multy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                multiOptions ForTwo = new multiOptions(frame);
                x.setVisible(false);
                frame.add(ForTwo);
                frame.validate();
            }
        });
    }
}
