package FileUploaderProgram.socket;

import FileUploaderProgram.service.FileService;
import FileUploaderProgram.service.UserService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket = null;
    private ObjectInputStream ois = null;
    private ObjectOutputStream oos = null;
    private UserService us = new UserService();
    private FileService fs = new FileService();

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
