package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServerThread extends Thread{

    DatagramSocket socket = null;
    DatagramPacket data = null;
    byte[] bytes;

    public UDPServerThread(DatagramSocket socket,byte[] bytes,DatagramPacket data) {
        this.socket = socket;
        this.data = data;
        this.bytes = bytes;
    }

    @Override
    public void run() {
        System.out.println("***服务器已经启动线程: "+Thread.currentThread().getName());

        try {
            String info = new String(bytes,0,data.getLength());
            System.out.println("我是服务器线程，客户端说：" + info);

            //向客户端返回响应
            InetAddress address = data.getAddress();
            int port = data.getPort();
            byte[] resp = (Thread.currentThread().getName()+"说欢迎你").getBytes();
            DatagramPacket packet1 = new DatagramPacket(resp,resp.length,address,port);
            //发送数据包给客户端
            socket.send(packet1);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
