import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ugadaiBABKU {
    public static int schet = 10;
    public static void main(String[] args) {
        Random rnd = new Random();
        int x = rnd.nextInt(50);
        JFrame frame = new JFrame("ОК");
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel pan = new JPanel(new GridLayout(3,1));
        frame.add(pan);
        JLabel text = new JLabel("Угадай бабку, у тебя есть 10 попыток");
        JTextField vvod = new JTextField();
        JButton but = new JButton("ОК");
        pan.add(text);
        pan.add(vvod);
        pan.add(but);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vvod.getText()==Integer.toString(x)){
                    System.out.println("Вы победили!");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.exit(0);
                }else{
                    schet--;
                    text.setText("Неверно! У вас осталось " + schet + " попыток");
                    if(Integer.parseInt(vvod.getText()) < x){
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println("Нужна бабка побольше");
                    }else{
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println("Нужна бабка поменьше");
                    }
                }
                if(schet==0){
                    text.setText("Вы проиграли!");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.exit(0);
                }
            }
        });
    }
}
