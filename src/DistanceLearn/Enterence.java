package DistanceLearn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.Scanner;

public class Enterence extends JPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame("ОК");
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new Enterence(frame));
    }

    public Enterence(JFrame frame) {
        super(new GridLayout(6, 1));
        JLabel Login = new JLabel("Логин:");
        JTextField login = new JTextField();
        JLabel Password = new JLabel("Пароль:");
        JTextField password = new JTextField();
        JButton connect = new JButton("Войти");
        JButton register = new JButton("Регистрация");
        this.add(Login);
        this.add(login);
        this.add(Password);
        this.add(password);
        this.add(connect);
        this.add(register);
        JPanel x = this;
        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean in = enter(login.getText(), password.getText());
                if (!in) {
                    System.out.println("Вы успешно вошли!");
                } else {
                    System.out.println("Неверный логин или пароль!");
                }
            }
        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.setVisible(false);
                frame.add(new Register(frame));
                frame.validate();
            }
        });
    }

    public static boolean enter(String a, String b) {
        boolean rtrn = true;
        try {
            FileReader fr = new FileReader("E:\\программирование\\nik\\LogPas.txt");
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                String x = scan.nextLine();
                String get[] = x.split(",");
                if (a.equals(get[0]) && b.equals(get[1])) {
                    rtrn = false;
                }
            }
        } catch (Exception Err0r) {
            Err0r.printStackTrace();
        }
        return rtrn;
    }
}
