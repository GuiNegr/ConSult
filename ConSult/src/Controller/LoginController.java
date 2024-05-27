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
        String sql = "insert into login (login, password) values (?,?)";
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,login.getLogin());
            preparedStatement.setString(2,login.getPassword());
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
    public boolean verifica(String login,String pass){
        String sql = "SELECT * FROM LOGIN";
        Login loginfora = new Login(pass,login);
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
           while (resultSet.next()){
               String loginbd = resultSet.getString("login");
               String id = resultSet.getString("id");
               loginfora.setId(id);
               String passBd = resultSet.getString("password");
               Login logins = new Login(id,passBd,loginbd);
               if(logins.equals(loginfora)){
                   return true;
               }
           }
            return false;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR VERIFICALOGIN: "+e.getMessage());
            return false;
        }
    }
}
