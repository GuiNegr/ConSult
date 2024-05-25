package Controller;

import Model.Paciente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerPaciente {

    public void createPaciente(Paciente paciente){
        String SQL = "insert into pacientes (cpfPaciente, nomePaciente, enderecoPaciente , pacienteConvenio) values (?,?,?,?)";

        try{
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, paciente.getCpfPaciente());
            preparedStatement.setString(2, paciente.getNomePaciente());
            preparedStatement.setString(3, paciente.getEnderecoPaciente());
            preparedStatement.setString(4, paciente.getPacienteConvenio());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"criado no bd");

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error Create: "+e.getMessage());
        }
    }

    public void deletePaciente(String id){
        String SQL = "DELETE FROM PACIENTES WHERE cpfPaciente = ?";


        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"PACIENTE DELETADO");

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR DELETE: "+e.getMessage());
        }
    }

    public void updatePaciete(Paciente paciente){
        String SQL = "UPDATE PACIENTES SET nomePaciente = ?, enderecoPaciente = ?, pacienteConvenio = ? where cpfPaciente = ?";

        try{
            Connection  connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, paciente.getNomePaciente());
            preparedStatement.setString(2,paciente.getEnderecoPaciente());
            preparedStatement.setString(3, paciente.getPacienteConvenio());
            preparedStatement.setString(4, paciente.getCpfPaciente());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"Upadate is working");

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR UPDATE TOTAL: "+e.getMessage());
        }

    }

}
