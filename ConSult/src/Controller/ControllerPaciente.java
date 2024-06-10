package Controller;

import Model.Paciente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerPaciente {

    public static void createPaciente(Paciente paciente){
        String SQL = "insert into pacientes (cpfPaciente, nomePaciente, enderecoPaciente , pacienteConvenio) values (?,?,?,?)";

        try{
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, paciente.getCpfPaciente());
            preparedStatement.setString(2, paciente.getNomePaciente());
            preparedStatement.setString(3, paciente.getEnderecoPaciente());
            preparedStatement.setString(4, paciente.getPacienteConvenio());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"Paciente inserido na base de dados");

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

    public static void updatePaciete(Paciente paciente){
        String SQL = "UPDATE PACIENTES SET nomePaciente = ?, enderecoPaciente = ?, pacienteConvenio = ? where cpfPaciente = ?";

        try{
            Connection  connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, paciente.getNomePaciente());
            preparedStatement.setString(2,paciente.getEnderecoPaciente());
            preparedStatement.setString(3, paciente.getPacienteConvenio());
            preparedStatement.setString(4, paciente.getCpfPaciente());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso");

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR UPDATE TOTAL: "+e.getMessage());
        }
    }

    public static  List<Paciente> readPaciente(){
        String sql = "SELECT * FROM PACIENTES";
        List<Paciente> pacientes = new ArrayList<>();
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String cpf = resultSet.getNString("cpfPaciente");
                String nome = resultSet.getNString("nomePaciente");
                String endereco = resultSet.getNString("enderecoPaciente");
                String convenio = resultSet.getNString("pacienteConvenio");
                Paciente paciente = new Paciente(cpf,nome,endereco,convenio);
                pacientes.add(paciente);
            }
            return pacientes;
        }catch (SQLException e){
                JOptionPane.showMessageDialog(null,"ERRO READ PACIENTE: "+e.getMessage());
                return null;
        }
    }
    private static List<String> readCpf(){
        String sql = "SELECT * FROM PACIENTES";
        List<String> cpfs = new ArrayList<>();
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String cpf = resultSet.getNString("cpfPaciente");
                cpfs.add(cpf);
            }
            return cpfs;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO READ PACIENTE: "+e.getMessage());
            return null;
        }
    }
    public static Paciente returnWithCpf(String cpf){
        List<Paciente> rdsPacientes = readPaciente();
        int pos = getPos(cpf);
        if(pos >= 0){
            Paciente paciente =  rdsPacientes.get(pos);
            return paciente;
        }else{
            JOptionPane.showMessageDialog(null,"PACIENTE NÃO ENCONTRADO");
            return null;
        }
    }
    private static int getPos(String cpf){
        List<String> cpfs = readCpf();
        int pos = 0;
        if(cpfs.contains(cpf)){
            pos = cpfs.indexOf(cpf);
            return pos;
        }else return  -1;
    }
}
