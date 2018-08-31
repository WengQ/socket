package TCP01;

import entity.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("***服务器已经启动，等待客户端连接***");
            String info = null;

            Socket socket = serverSocket.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //读取客户端传入的消息
            User user = (User) ois.readObject();
            System.out.println("我是服务端，客户端的用户名为：" + user.username + "密码为：" + user.password);
            socket.shutdownInput();
            //向客户端返回响应
            String resp = "欢迎你！";
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.write(resp);
            pw.flush();

            socket.shutdownOutput();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
