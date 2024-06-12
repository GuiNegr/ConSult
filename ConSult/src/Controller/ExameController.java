package Controller;

import Model.Exame;

import javax.swing.*;
import java.sql.*;
import java.util.List;

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

    public static Exame listExame(String id){
        String sql = "SELECT * FROM EXAMES WHERE ID = ?";
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Exame exame = new Exame();
            while(resultSet.next()){
                String idBd = resultSet.getString("id");
                exame.setId(idBd);
                String nomeExame = resultSet.getString("nomeExame");
                exame.setNomeExame(nomeExame);
                String descExame = resultSet.getString("descExame");
                exame.setDescExame(descExame);
                Blob foto = resultSet.getBlob("fotoExame");
                exame.setFoto(foto);
                String idConsulta = resultSet.getString("idConsulta");
                exame.setIdConsulta(idConsulta);
            }
            return exame;

        }catch (SQLException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
                return null;
        }
    }
}
