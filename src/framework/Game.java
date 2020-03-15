package framework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
//192.168.0.78
public class Game extends JPanel {
    Socket sock = null;
    DataInputStream dis = null;
    DataOutputStream dos = null;
    public static int j = 0;

    public Game(JFrame frame, String ip) {
        super(new GridLayout(3, 3));
        JPanel x = this;
        try {
            new Thread(() -> {
                try {
                    sock = new Socket(ip, 55555);
                    dis = new DataInputStream(sock.getInputStream());
                    dos = new DataOutputStream(sock.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            try{
                Thread.sleep(2000);
            }catch (Exception err0r){
                err0r.printStackTrace();
            }
            connect(dis, dos);
            JButton[] buttons = new JButton[9];
            for (j = 0; j < 9; j++) {
                JButton but = new JButton();
                x.add(but);
                but.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        but.setText("X");
                        click(buttons, dos, j);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void click(JButton[] buttons, DataOutputStream dos, int i) {
        String st = "/click ";
        st+=i;
        try {
            dos.writeUTF(st);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void connect(DataInputStream dis, DataOutputStream dos) {
        String b = "/connect";
        boolean a = false;
        try {
            dos.writeUTF(b);
            dos.flush();
            a = dis.readBoolean();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }
}
