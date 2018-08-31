package FileUploaderProgram.entity;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -925542940841254132L;

    //
    private  int id;
    private  String username;
    private  String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
