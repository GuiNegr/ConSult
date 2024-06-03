package Controller;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDao {

    public Connection conecta(){
        Connection conexao = null;
        try{
            String url = "jdbc:mysql://localhost:3306/Hospital?user=root&password=root";
            conexao = DriverManager.getConnection(url);

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO CONECTA: "+e.getMessage());
        }
        return conexao;
    }
}
