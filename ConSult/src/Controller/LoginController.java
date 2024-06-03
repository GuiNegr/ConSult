package Controller;

import Model.Login;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {


    public void CreateLogin(Login login){
        String sql = "insert into login (login, password,type) values (?,?,?)";
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,login.getLogin());
            preparedStatement.setString(2,login.getPassword());
            preparedStatement.setString(3,login.getType());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "LOGIN CRIADO");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO CREATE LOGIN"+e.getMessage());
        }
    }

    public void DeleteLogin(String id){
        String sql = "DELETE FROM LOGIN WHERE ID = ?";

        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"DELETE ERROR: "+e.getMessage());
        }
    }

    public String getTipo(String login,String pass){
        if(verifica(login,pass)){
            Login getTipoLogin = returnLogin(login,pass);
            return getTipoLogin.getType();
        } else return "Não há no banco de dados";

    }
    private boolean verifica(String login,String pass){
        Login loginfora = returnLogin(login,pass);
        List<Login> loginBd = LoginCreateInBD();

        if(loginBd.contains(loginfora)){
            return true;
        }else return false;
    }
    private List<Login> LoginCreateInBD(){
        String sql = "SELECT * FROM LOGIN";
        List<Login> loginsInBd = new ArrayList<>();
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String loginbd = resultSet.getString("login");
                String id = resultSet.getString("id");
                String passBd = resultSet.getString("password");
                String typebd = resultSet.getNString("type");
                Login logins = new Login(id,loginbd,passBd,typebd);
                loginsInBd.add(logins);
            }
            return loginsInBd;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR VERIFICALOGIN: "+e.getMessage());
            return  null;
        }
    }
    private Login returnLogin(String login,String pass){
        String sql = "SELECT * FROM LOGIN";
        Login loginfora = new Login(login,pass);
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String loginbd = resultSet.getString("login");
                String id = resultSet.getString("id");
                String passBd = resultSet.getString("password");
                String typebd = resultSet.getNString("type");
                Login logins = new Login(id,loginbd,passBd,typebd);
                if(logins.getLogin().equals(loginfora.getLogin()) && logins.getPassword().equals(loginfora.getPassword())){
                    loginfora.setType(logins.getType());
                    loginfora.setId(logins.getId());
                    break;
                }
            }
            return loginfora;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR VERIFICALOGIN: "+e.getMessage());
            return null;
        }
    }
}
