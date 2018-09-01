package FileUploaderProgram.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//服务器主线程，创建服务器，绑定端口，循环监听，多线程通信
public class StartServer {
    //
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;

            while (true){
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
