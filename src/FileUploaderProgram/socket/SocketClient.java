package FileUploaderProgram.socket;

import FileUploaderProgram.entity.File;
import FileUploaderProgram.entity.User;
import FileUploaderProgram.util.CommandTransfer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    Scanner input = new Scanner(System.in);
    private Socket socket = null;

    //主菜单
    public void showMainMenu() {
        System.out.println("**欢迎使用文件上传器**");
        System.out.println("1.登录\n2.注册\n3.退出");
        System.out.println("**********************");
        System.out.println("请选择： ");

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                showLogin();//登录
                break;
            case 2:
                showRegister();//注册
                break;
            case 3:
                System.out.println("再见~");
                System.exit(0);
            default:
                System.out.println("输入有误");
                System.exit(0);
        }
    }

    //用户登录
    private void showLogin() {
        User user = new User();
        CommandTransfer transfer = new CommandTransfer();

        int count = 0;
        while (true) {
            count++;
            if (count >3){
                System.out.println("您已经连续三次登录失败，程序退出！");
                System.exit(0);
            }

            System.out.println("请输入用户名：");
            user.setUsername(input.next());

            System.out.println("请输入密码：");
            user.setPassword(input.next());

            //transfer.setCmd("login");
            //transfer.setData(user);

            try {
                socket = new Socket("localhost",8888);
                sendData(transfer);
                transfer = getData();

                System.out.println(transfer.getResult());
                System.out.println("***********************");

                if (transfer.isFlag()){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                closeAll();
            }
        }
        showUploadFile();//登陆成功后文件上传
    }

    //用户注册
    private void showRegister() {
        User user = new User();
        CommandTransfer transfer = new CommandTransfer();

        while (true){
            System.out.println("请输入用户名：");
            user.setUsername(input.next());

            System.out.println("请输入密码：");
            user.setPassword(input.next());

            System.out.println("请再次输入密码：");
            String rePassword = input.next();

            if (!user.getPassword().equals(rePassword)){
                System.out.println("两次密码输入不一致！");
                System.out.println("*****************");
                continue;
            }

            transfer.setCmd("register");
            transfer.setData(user);


            try {
                socket = new Socket("localhost",8888);
                sendData(transfer);
                transfer = getData();

                System.out.println(transfer.getResult());
                System.out.println("***********************");

                if (transfer.isFlag()){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                closeAll();
            }
        }
        showLogin();
    }

    //上传文件
    public void showUploadFile(){
        System.out.println("请输入文件的绝对路径：");
        String path = input.next();
        File file = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        String fname = path.substring(path.lastIndexOf("/"+1));

        try {
            fis = new FileInputStream(path);
            byte[] fcontent = new byte[fis.available()];
            bis = new BufferedInputStream(fis);
            bis.read(fcontent);
            file = new File(fname,fcontent);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
