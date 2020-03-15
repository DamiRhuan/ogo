import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class izi {
    public static int x = 0;
    public static boolean closer = false;
    public static JLabel text;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ок");
        frame.setSize(900, 900);
        frame.setVisible(true);
        JPanel panel = new JPanel(new GridLayout(2, 1));
        frame.add(panel);
        text = new JLabel(Integer.toString(x));
        JButton but = new JButton();
        Thread river = new Thread(() -> {
            text.setText(Integer.toString(x));
            for (int i = 0; true; i++) {
                if (closer) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException eee) {
                    eee.printStackTrace();
                }
                text.setText(Integer.toString(i));
                }
            }
        });

        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (!closer) {
                    but.setText("Вкл");
                    closer = true;
                } else {
                    but.setText("Выкл");
                    closer = false;
                    river.start();
                }
            }
        });
        panel.add(text);
        panel.add(but);
    }
}

