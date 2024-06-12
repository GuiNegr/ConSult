package Controller;

import Model.Exame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExameController {

    public static void CreateExame(Exame exame){
        String sql = "insert into exames(nomeExame,descExame,fotoExame,idConsulta) values(?,?,?,?)";

        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,exame.getNomeExame());
            preparedStatement.setString(2, exame.getDescExame());
            preparedStatement.setBlob(3,exame.getFotoExame(),exame.getTamanho());
            preparedStatement.setString(4,exame.getIdConsulta());
            preparedStatement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR CREATE EXAME: "+e.getMessage());
        }
    }
}
