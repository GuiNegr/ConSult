package View;

import Controller.AgendaExameController;
import Controller.ConsultaController;
import Controller.ExameController;
import Model.Consulta;
import Model.Exame;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.util.*;
import java.text.ParseException;

public class AgendarConsulta extends JFrame implements ActionListener {


    private JLabel dataConsulta;
    private JTextField dataout;
    private JLabel horaConsulta;
    private JTextField horaOut;
    private JLabel cpfFk;
    private JTextField cpfOutfk;
    private JLabel crmFk;
    private JTextField crmOut;
    public JButton agendarConsulta;
    public JButton voltar;
    private JPanel painelCombo;
    MaskFormatter mascaraData;
    MaskFormatter mascaraHora;

    public AgendarConsulta() throws ParseException {
        mascaraData = new MaskFormatter("2024-##-##");
        mascaraHora  = new MaskFormatter("##:##:00");
        setTitle("Agendamento de consultas");
        setSize(1240, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        dataConsulta = label("DATA DA CONSULTA");
        dataout = textField(mascaraData);
        horaConsulta = label("HORA DA CONSULTA");
        horaOut = textField(mascaraHora);
        cpfFk = label("CPF DO PACIENTE");
        cpfOutfk = text();
        crmFk = label("CRM DO MEDICO");
        crmOut = text();
        agendarConsulta = botao("AGENDAR");
        voltar = botao("VOLTAR");
        getContentPane().setBackground(new Color(235, 155, 0));
        getContentPane().setLayout(new GridLayout(5, 2));
        setVisible(true);
    }

    private JLabel label(String text) {
        JLabel label = new JLabel();

        label.setText(text);
        label.setForeground(Color.white);
        label.setFont(UserInicial.monteserrat());
        add(label);
        return label;
    }

    private JTextField text() {
        JTextField txt = new JTextField();
        txt.setFont(UserInicial.monteserrat());
        txt.setForeground(new Color(156, 65, 235));
        add(txt);
        return txt;
    }

    private JFormattedTextField textField(MaskFormatter mask){
        JFormattedTextField txt = new JFormattedTextField(mask);
        txt.setFont(UserInicial.monteserrat());
        txt.setForeground(new Color(156, 65, 235));
        add(txt);
        return txt;
    }
    private JTextField text(String text) {
        JTextField txt = new JTextField();
        txt.setFont(UserInicial.monteserrat());
        txt.setText(text);
        txt.setForeground(new Color(156, 65, 235));
        add(txt);
        return txt;
    }


    private JButton botao(String txt) {
        JButton botao = new JButton();
        botao.setBackground(new Color(116, 50, 150));
        botao.setForeground(new Color(54, 107, 80));
        botao.setText(txt);
        botao.setFont(UserInicial.monteserrat());
        botao.addActionListener(this);
        add(botao);
        return botao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agendarConsulta) {
            Date d = Date.valueOf(dataout.getText());
            Time t = Time.valueOf(horaOut.getText());
            String cpf = cpfOutfk.getText();
            String crm = crmOut.getText();
            Exame exame = new Exame("2",cpf,crm,"1",d,t);
            AgendaExameController a = new AgendaExameController();
            a.UpdateAgenda(exame);
            dataout.setText(" ");
            horaOut.setText(" ");
            cpfOutfk.setText(" ");
            crmOut.setText(" ");
        }
        if (e.getSource() == voltar) {
            dispose();
            new UserInicial();
        }
    }
}
