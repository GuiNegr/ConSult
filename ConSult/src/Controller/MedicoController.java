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

    public static void CreateMedico(Medico medico){
        String sql = "insert into medicos (crmMedico,nomeMedico,DiasDaSemana,consultorio) values (?,?,?,?)";

        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,medico.getCrmMedico());
            preparedStatement.setString(2,medico.getNomeMedico());
            preparedStatement.setString(3,medico.getDiaDaSemana());
            preparedStatement.setInt(4,medico.getConsultorio());
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

    private static List<Medico> readMedico(){
        String sql = "Select * from medicos";
        List<Medico> medicos = new ArrayList<>();
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String nome = resultSet.getString("nomeMedico");
                int crm = resultSet.getInt("crmMedico");
                String dias = resultSet.getString("DiasDaSemana");
                int consultorio = resultSet.getInt("consultorio");
                Medico medico = new Medico(nome,crm,dias,consultorio);
                medicos.add(medico);
            }
            return medicos;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR READ MEDICOS: "+e.getMessage());
            return null;
        }
    }

    public static void updateMedic(Medico medico){
        String sql = "UPDATE MEDICOS SET NOMEMEDICO = ?, diasdasemana = ?, consultorio = ? WHERE CRMMEDICO = ?";

        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,medico.getNomeMedico());
            preparedStatement.setString(2,medico.getDiaDaSemana());
            preparedStatement.setInt(3,medico.getConsultorio());
            preparedStatement.setInt(4,medico.getCrmMedico());
            preparedStatement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR UPDATE MEDIC: "+e.getMessage());
        }

    }


    private static List<Integer> rdCrm(){
        String sql = "Select * from medicos";
        List<Integer> crms = new ArrayList<>();
        try {
            Connection connection = new ConexaoDao().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int crm = resultSet.getInt("crmMedico");
                crms.add(crm);
            }
            return crms;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR CRM: "+e.getMessage());
            return null;
        }
    }


    public static Medico returnWithCrm(int crm){

        List<Medico> medicosINbD = readMedico();
        int a = getPos(crm);
        if(a >= 0){
            List<Medico> medicos = new ArrayList<>();
            Medico medico = medicos.get(a);
            return medico;
        }else{
            JOptionPane.showMessageDialog(null,"Medico não encontrado");
            return null;
        }

    }

    private static int getPos(int crm){
        List<Integer> crms = rdCrm();

        if(crms.contains(crm)){
           return crms.indexOf(crm);
        }else {
            return -1;
        }
    }
}
