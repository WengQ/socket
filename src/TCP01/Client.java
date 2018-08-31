package TCP01;

import entity.User;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8888);
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);

            //生成传输对象，传给服务器。
            User user = new User("zhangsan","123456");
            oos.writeObject(user);
            oos.flush();
            socket.shutdownOutput();
            //接收服务器的响应并打印
            String info = null;
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            while ((info = br.readLine()) != null){
                System.out.println("我是客户端，服务器说： " + info);
            }
            socket.shutdownInput();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
