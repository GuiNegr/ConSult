package Controller;

import Model.Exame;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaExameController {


    public static void createAgenda(Exame exame){
            String sql = "INSERT INTO AGENDAEXAME (NOMEEXAME,DESCEXAME,DATAEXAME,HORAEXAME,cpfpacientefk) VALUES (?,?,?,?,?)";
            try {
                Connection connection = new ConexaoDao().conecta();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, exame.getNomeExame());
                preparedStatement.setString(2, exame.getDescExame());
                preparedStatement.setDate(3,exame.getDataExame());
                preparedStatement.setTime(4,exame.getTimeExame());
                preparedStatement.setString(5, exame.getCpfPaciente());
                preparedStatement.execute();
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
    }
    public static void deleteAgenda(String id){
        String sql = "DELETE FROM AGENDAEXAME WHERE ID = ?";
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public static void UpdateAgenda(Exame exame){
        String sql = "UPDATE  agendaexame set nomeExame = ? , descExame = ?, dataExame = ?, horaExame = ?,CPFPACIENTEFK = ? WHERE ID = ?";
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,exame.getNomeExame());
            preparedStatement.setString(2, exame.getDescExame());
            preparedStatement.setDate(3,exame.getDataExame());
            preparedStatement.setTime(4,exame.getTimeExame());
            preparedStatement.setString(5, exame.getCpfPaciente());
            preparedStatement.setString(6, exame.getId());
            preparedStatement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public static List<Exame> readExame(){
        String sql = "select * from agendaexame";
        List<Exame> exames = new ArrayList<>();
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String id = resultSet.getString("id");
                String nome = resultSet.getString("nomeExame");
                String descE = resultSet.getString("descExame");
                Date data = resultSet.getDate("dataExame");
                Time time = resultSet.getTime("horaExame");
                String cpf = resultSet.getString("cpfpacientefk");
                Exame exame = new Exame(id,nome,descE,time,data,cpf);
                exames.add(exame);
            }
            return exames;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
    }
}
