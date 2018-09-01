package FileUploaderProgram.socket;

public class StartClient {
//启动客户端
    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        client.showMainMenu();
    }
}
