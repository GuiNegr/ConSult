package Controller;


import Model.Consulta;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//read do consulta ele vai precisa do id paciente
public class ConsultaController {


    public void CreateConsulta(Consulta consulta){
        String sql = "insert into Consultas (dateConsulta,timeConstulta,id_fk_paciente,id_fk_medico) values (?,?,?,?)";

        try{
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1,consulta.getDataConsulta());
            preparedStatement.setTime(2,consulta.getTimeConsulta());
            preparedStatement.setString(3,consulta.getId_fk_paciente());
            preparedStatement.setInt(4,consulta.getId_fk_medico());
            preparedStatement.execute();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO NO CREATE CONSULTA: "+e.getMessage());
        }
    }

    public void DeleteConsulta(String id){
        String sql = "Delete from consultas where id_consulta = ?";
        try{
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.execute();


        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR DELETECONSULTA: "+e.getMessage());
        }
    }

    public void updateConsulta(Consulta consulta){
        String sql = "UPDATE CONSULTAS SET dateConsulta = ?, timeConstulta = ? , ID_FK_PACIENTE = ?, ID_FK_MEDICO = ? where id_consulta = ?";
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1,consulta.getDataConsulta());
            preparedStatement.setTime(2,consulta.getTimeConsulta());
            preparedStatement.setString(3, consulta.getId_fk_paciente());
            preparedStatement.setInt(4,consulta.getId_fk_medico());
            preparedStatement.setString(5, consulta.getId_Consulta());
            preparedStatement.execute();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR UPADTECONSULTA: "+e.getMessage());
        }
    }


    public List<Consulta> readConsulta(String idPaciente){
        String sql = "SELECT * FROM CONSULTAS WHERE ID_FK_PACIENTE = ?";
        List<Consulta> consultas = new ArrayList<>();
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,idPaciente);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String id = resultSet.getString("id_Consulta");
                Date date = resultSet.getDate("dateConsulta");
                Time time = resultSet.getTime("timeConstulta");
                String fkPaciente = resultSet.getString("id_fk_paciente");
                int fkMedico = resultSet.getInt("id_fk_medico");
                Consulta consulta = new Consulta(id,date,time,fkPaciente,fkMedico);
                consultas.add(consulta);
            }

            return consultas;

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR READ CONSULTA: "+e.getMessage());
            return null;
        }
    }
}
