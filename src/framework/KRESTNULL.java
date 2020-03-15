package framework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class KRESTNULL {
    static int y = 1;

    public KRESTNULL() {
        JFrame okno = new JFrame();
        okno.setSize(900, 900);
        okno.setVisible(true);
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(3, 3));
        okno.add(panel);
        ArrayList<JButton> game = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            JButton but = new JButton(" ");
            but.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
            game.add(but);
            panel.add(but);
            but.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    vibor(game, but);
                }
            });
        }
    }

    public static void vibor(ArrayList<JButton> x, JButton z) {
        if (z.getText() == " ") {
            if (y % 2 == 1) {
                z.setText("X");
                y++;
            } else {
                z.setText("0");
                y++;
            }
            wins(x, y);
        }
    }

    public static void wins(ArrayList<JButton> x, int y) {
        if ((x.get(0).getText().equals(x.get(1).getText()) && x.get(1).getText().equals(x.get(2).getText()) && !x.get(0).getText().equals(" ")) ||
                (x.get(3).getText().equals(x.get(4).getText()) && x.get(4).getText().equals(x.get(5).getText()) && !x.get(3).getText().equals(" ")) ||
                (x.get(6).getText().equals(x.get(7).getText()) && x.get(7).getText().equals(x.get(8).getText()) && !x.get(6).getText().equals(" ")) ||
                (x.get(0).getText().equals(x.get(4).getText()) && x.get(4).getText().equals(x.get(8).getText()) && !x.get(0).getText().equals(" ")) ||
                (x.get(2).getText().equals(x.get(4).getText()) && x.get(4).getText().equals(x.get(6).getText()) && !x.get(2).getText().equals(" ")) ||
                (x.get(0).getText().equals(x.get(3).getText()) && x.get(3).getText().equals(x.get(6).getText()) && !x.get(0).getText().equals(" ")) ||
                (x.get(1).getText().equals(x.get(4).getText()) && x.get(4).getText().equals(x.get(7).getText()) && !x.get(1).getText().equals(" ")) ||
                (x.get(2).getText().equals(x.get(5).getText()) && x.get(5).getText().equals(x.get(8).getText()) && !x.get(2).getText().equals(" "))) {
            if (y % 2 == 0) {
                System.out.println("Крестики победили");
                System.exit(0);
            } else {
                System.out.println("Нолики победили");
                System.exit(0);
            }
        }
        boolean a = true;
        for (int i = 0; i < 9; i++) {
            if (x.get(i).getText().equals(" ")) {
                a = false;
            }
        }
        if (a) {
            System.out.println("Ничья");
            System.exit(0);
        }
    }
}