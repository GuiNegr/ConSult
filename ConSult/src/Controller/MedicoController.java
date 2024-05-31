package Controller;

import Model.Medico;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoController {

    public void CreateMedico(Medico medico){
        String sql = "insert into medicos (crmMedico,nomeMedico) values (?,?)";

        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,medico.getCrmMedico());
            preparedStatement.setString(2,medico.getNomeMedico());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"medico criado");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR CREATE MEDICO: "+e.getMessage());
        }
    }

    public void deleteMedico(Medico medico){
        String sql = "Delete from medicos where crmMedico = ?";
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,medico.getCrmMedico());
            preparedStatement.execute();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR DELETEMEDICO: "+e.getMessage());
        }
    }

    public List<Medico> readMedico(){
        String sql = "Select * from medicos";
        List<Medico> medicos = new ArrayList<>();
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String nome = resultSet.getString("nomeMedico");
                int crm = resultSet.getInt("crmMedico");
                Medico medico = new Medico(nome,crm);
                medicos.add(medico);
            }
            return medicos;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR READ MEDICOS: "+e.getMessage());
            return null;
        }
    }

    public void updateMedic(Medico medico){
        String sql = "UPDATE MEDICOS SET NOMEMEDICO = ? WHERE CRMMEDICO = ?";

        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,medico.getNomeMedico());
            preparedStatement.setInt(2,medico.getCrmMedico());
            preparedStatement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR UPDATE MEDIC: "+e.getMessage());
        }

    }
}
