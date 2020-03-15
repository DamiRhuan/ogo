package DistanceLearn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class Register extends JPanel {
    public Register(JFrame frame) {
        super(new GridLayout(8,1));
        JPanel x = this;
        JLabel Login = new JLabel("Придумайте логин и введите его дважды:");
        JTextField login1 = new JTextField();
        JTextField login2 = new JTextField();
        JLabel Password = new JLabel("Придумайте пароль и введите его дважды:");
        JTextField password1 = new JTextField();
        JTextField password2 = new JTextField();
        JButton create = new JButton("Зарегистрироваться");
        JButton back = new JButton("Назад");
        this.add(Login);
        this.add(login1);
        this.add(login2);
        this.add(Password);
        this.add(password1);
        this.add(password2);
        this.add(create);
        this.add(back);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(login1.getText().equals(login2.getText()) && password1.getText().equals(password2.getText())){
                    System.out.println("Вы успешно прошли регистрацию!");
                    try{
                        FileWriter fw = new FileWriter("E:\\программирование\\nik\\LogPas.txt", true);
                        fw.write(login1.getText() + "," + password1.getText() + "\n");
                        fw.flush();
                    }catch (Exception Err0r){
                        Err0r.printStackTrace();
                    }
                    x.setVisible(false);
                    frame.add(new Enterence(frame));
                    frame.validate();
                }else{
                    System.out.println("Вы неверно ввели логин или пароль!");
                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.setVisible(false);
                frame.add(new Enterence(frame));
                frame.validate();
            }
        });
    }
}
