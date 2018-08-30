package socket;

import sun.applet.Main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
//这是一个单线程的server程序。监听8888端口，将读到的客户端信息打印出来
public class SimpleServer {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            //1.创建一个服务器端Socket，即serverSocket，并绑定并监听端口8888
            serverSocket = new ServerSocket(8888);
            System.out.println("****服务器即将启动，等待客户端连接****");
            //2.调用accept()方法开始监听，等待客户端的连接。
            Socket socket = serverSocket.accept();
            //3.1 获取输入流，并且读取客户端信息。
            InputStream is = socket.getInputStream();//字节输入流
            InputStreamReader isr = new InputStreamReader(is);//将字节流包装为字符流
            BufferedReader br = new BufferedReader(isr);//为输入流添加缓冲
            //3.2 读取字符流缓冲中的数据并打印
            String s = null;
            while ((s = br.readLine()) != null){
                System.out.println(s);
            }

            socket.shutdownInput();//关闭输入流

            //4.给客户端返回一个响应，获取输出流
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);//包装为打印流
            pw.write("登录成功");
            pw.flush();    //将缓存输出
            //5.关闭资源
            br.close();
            isr.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
