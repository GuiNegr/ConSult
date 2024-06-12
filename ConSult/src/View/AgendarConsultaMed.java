package View;

import Controller.AgendaExameController;
import Controller.ComponentView;
import Model.Exame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;

public class AgendarConsultaMed extends JFrame implements ActionListener {

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

    public AgendarConsultaMed() throws ParseException {
        setTitle("Agendamento de consultas");
        setSize(1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        dataConsulta = ComponentView.label("DATA DA CONSULTA");
        dataout = ComponentView.txtData();

        horaConsulta = ComponentView.label("HORA DA CONSULTA");
        horaOut = ComponentView.txtHora();

        cpfFk = ComponentView.label("CPF DO PACIENTE");
        cpfOutfk = ComponentView.text();

        crmFk = ComponentView.label("CRM DO MEDICO");
        crmOut = ComponentView.text();

        add(dataConsulta);  add(dataout); add(horaConsulta);  add(horaOut); add(cpfFk);  add(cpfOutfk); add(crmFk);  add(crmOut);

        agendarConsulta = ComponentView.botao("AGENDAR");
        agendarConsulta.addActionListener(this);
        add(agendarConsulta);

        voltar = ComponentView.botao("VOLTAR");
        voltar.addActionListener(this);
        add(voltar);

        getContentPane().setLayout(new GridLayout(5, 2));
        setVisible(true);
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
            new MedicoInterface();
        }
    }
}
