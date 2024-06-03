package Model;

import java.util.Objects;

public class Login {
    private String id;
    private String login;
    private String password;
    private String type;


    public Login(String id, String login, String password, String type) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.type = type;
    }

    public Login(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Login(String login, String password, String type) {
        this.login = login;
        this.password = password;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login1 = (Login) o;
        return Objects.equals(id, login1.id) && Objects.equals(login, login1.login) && Objects.equals(password, login1.password) && Objects.equals(type, login1.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, type);
    }
}
