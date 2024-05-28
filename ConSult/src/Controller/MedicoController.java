package Controller;

import Model.Medico;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
