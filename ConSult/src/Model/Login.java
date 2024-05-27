package Model;

import java.util.Objects;

public class Login {
    private String id;
    private String login;
    private String password;

    public Login(String id, String password, String login) {
        this.id = id;
        this.password = password;
        this.login = login;
    }

    public Login(String password, String login) {
        this.password = password;
        this.login = login;
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

    @Override
    public String toString() {
        return "Login{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login1 = (Login) o;
        return Objects.equals(id, login1.id) && Objects.equals(login, login1.login) && Objects.equals(password, login1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }
}
