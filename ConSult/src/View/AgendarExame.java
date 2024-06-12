package View;

import Controller.AgendaExameController;
import Controller.ComponentView;
import Controller.ExameController;
import Model.Exame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;

public class AgendarExame extends JFrame implements ActionListener {
    private JLabel descExame;
    private JTextField outDesc;
    private JLabel nomeExame;
    private JTextField outNome;
    private JLabel dataExame;
    private JFormattedTextField outData;
    private JLabel horaExame;
    private JFormattedTextField outHora;
    private JLabel cpfPaciente;
    private JTextField outCpf;
    private JButton agendar;
    private JButton voltar;

    public AgendarExame() throws ParseException {
        setSize(1280,720);
        setTitle("Agendamento de Exame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        nomeExame = ComponentView.label("NOME DO EXAME");
        outNome = ComponentView.text();

        descExame = ComponentView.label("DESCRIÇÃO DO EXAME");
        outDesc = ComponentView.text();

        dataExame = ComponentView.label("DATA DO EXAME");
        outData = ComponentView.txtData();

        horaExame = ComponentView.label("HORA DO EXAME");
        outHora = ComponentView.txtHora();

        cpfPaciente = ComponentView.label("CPF DO PACIENTE");
        outCpf = ComponentView.text();

        agendar = ComponentView.botao("AGENDAR");
        agendar.addActionListener(this);
        voltar = ComponentView.botao("VOLTAR");
        voltar.addActionListener(this);

        add(nomeExame); add(outNome); add(descExame); add(outDesc); add(dataExame); add(outData); add(horaExame); add(outHora); add(cpfPaciente); add(outCpf); add(agendar); add(voltar);
        getContentPane().setLayout(new GridLayout(6,2));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == agendar){
            String cpf = outCpf.getText();
            Date data = Date.valueOf(outData.getText());
            Time hora = Time.valueOf(outHora.getText());
            String nome = outNome.getText();
            String desc = outDesc.getText();

            Exame exame = new Exame(nome,desc,data,hora,cpf);
            AgendaExameController.createAgenda(exame);

            outHora.setText(" ");
            outDesc.setText(" ");
            outCpf.setText(" ");
            outNome.setText(" ");
            outDesc.setText(" ");

        }
        if(e.getSource() == voltar){
            dispose();
            new UserInicial();
        }
    }
}
