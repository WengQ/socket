package entity;

import java.io.Serializable;

public class User implements Serializable {
    public String username = null;
    public String password = null;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
