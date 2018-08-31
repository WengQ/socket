package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServerThread extends Thread{

    DatagramSocket socket = null;
    DatagramPacket packet = null;
    byte[] bytes;

    public UDPServerThread(DatagramSocket socket,byte[] bytes,DatagramPacket packet) {
        this.socket = socket;
        this.bytes = bytes;
        this.packet = packet;
    }

    @Override
    public void run() {
        System.out.println("***服务器已经启动线程: "+Thread.currentThread().getName());

        try {
            String info = new String(bytes,0, packet.getLength());
            System.out.println("我是服务器线程，客户端说：" + info);

            //向客户端返回响应,UDP通信从数据包DatagramPacket中获取客户端IP，端口信息。
            InetAddress address = packet.getAddress();//TCP通信中获取客户端地址是通过Socket： InetAddress address=TCP.getInetAddress();
            int port = packet.getPort();              //                                      System.out.println("当前客户端的IP："+address.getHostAddress());
            byte[] resp = (Thread.currentThread().getName()+"说欢迎你").getBytes();
            DatagramPacket packet1 = new DatagramPacket(resp,resp.length,address,port);
            //发送数据包给客户端
            socket.send(packet1);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
