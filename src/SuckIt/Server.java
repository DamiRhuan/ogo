package SuckIt;

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket sosok = new ServerSocket(12345);
            Socket accepted = sosok.accept();
            DataOutputStream dos = new DataOutputStream(accepted.getOutputStream());
            DataInputStream dis = new DataInputStream(accepted.getInputStream());
            FileReader fr = new FileReader("E:\\a.json");
            Scanner son = new Scanner(fr);
            JSONObject transfer = new JSONObject(son.next());
            dos.writeUTF(transfer.toString());
            dos.flush();
            String b = " ";
            b= dis.readUTF();
            JSONObject getter = new JSONObject(b);
            int a = getter.getInt("id");
            System.out.println(a);
        } catch (Exception Err0r) {
            Err0r.printStackTrace();
        }
    }
}
