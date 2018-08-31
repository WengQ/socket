package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket socket = new DatagramSocket(8000);

        //记录客户端的数量
        int count=0;
        System.out.println("****服务器端已经启动，等待客户端发送数据***");

        while (true){
            byte[] data = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(data,data.length);
            socket.receive(datagramPacket);
            UDPServerThread serverThread = new UDPServerThread(socket,data,datagramPacket);
            serverThread.start();

            count++;//统计客户端的数量
            System.out.println("客户端的数量："+count);

        }
    }
}
