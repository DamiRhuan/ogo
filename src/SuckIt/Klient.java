package SuckIt;

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.net.Socket;
import java.util.Scanner;

public class Klient {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);  Socket sock = new Socket("192.168.0.42", 12345);
            DataInputStream dis = new DataInputStream(sock.getInputStream());
            DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
            FileReader fr = new FileReader("E:\\a.json");
            Scanner son = new Scanner(fr);
            JSONObject transfer = new JSONObject(son.next());
            dos.writeUTF(transfer.toString());
            dos.flush();
            String b = " ";
            b= dis.readUTF();
            JSONObject getter = new JSONObject(b);
            String a = getter.getString("id");
            System.out.println(a);
        } catch (Exception Err0r) {
            Err0r.printStackTrace();
        }
    }
}
