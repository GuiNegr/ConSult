package View;

import Controller.MedicoController;
import Model.Medico;
import com.sun.jdi.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicoAddUpdate extends JFrame implements ActionListener {
    private JLabel nomeMedico;
    private JTextField outNome;
    private JLabel crmMedico;
    private JTextField outCrm;
    private JLabel diasDaSemana;
    private JTextField outDias;
    private JLabel consultorio;
    private JTextField outConsultorio;
    private JButton botaoUpdate;
    private JButton botaoCad;
    private JButton voltar;



    public MedicoAddUpdate(){
        setTitle("Medico: Form");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(18,103,227));
        nomeMedico = label("Nome: ");
        outNome = textField();
        crmMedico = label("Crm: ");
        outCrm = textField();
        diasDaSemana = label("Dias Disponiveis");
        outDias = textField("Ex: Seg,terc,quart");
        consultorio = label("Consultorio: ");
        outConsultorio = textField();
        botaoCad = botao("cad medico");
        voltar = botao("Voltar");
        getContentPane().setLayout(new GridLayout(5,2));
        setVisible(true);
    }


    public MedicoAddUpdate(Medico medico){
        setTitle("Medico: Form");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(18,103,227));
        nomeMedico = label("Nome: ");
        outNome = textField(medico.getNomeMedico());
        crmMedico = label("Crm: ");
        outCrm = textField(String.valueOf(medico.getCrmMedico()));
        diasDaSemana = label("Dias Disponiveis");
        outDias = textField(medico.getDiaDaSemana());
        consultorio = label("Consultorio: ");
        outConsultorio = textField(String.valueOf(medico.getConsultorio()));
        botaoUpdate = botao("Atualizar medico");
        voltar = botao("Voltar");
        getContentPane().setLayout(new GridLayout(5,2));
        setVisible(true);
    }

    private JLabel label(String text){
        JLabel label = new JLabel();
        label.setForeground(Color.white);
        label.setFont(UserInicial.monteserrat());
        label.setText(text);
        add(label);
        return label;
    }

    private JTextField textField(){
        JTextField text = new JTextField();
        text.setForeground(new Color(140,18,227));
        text.setFont(UserInicial.monteserrat());
        add(text);
        return text;
    }

    private JTextField textField(String txt){
        JTextField text = new JTextField();
        text.setForeground(new Color(140,18,227));
        text.setText(txt);
        text.setFont(UserInicial.monteserrat());
        add(text);
        return text;
    }

    private JButton botao(String text){
        JButton botao = new JButton();
        botao.setFont(UserInicial.monteserrat());
        botao.setText(text);
        botao.setBackground(new Color(140,18,227));
        botao.setForeground(Color.white);
        botao.addActionListener(this);
        add(botao);
        return botao;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botaoCad){
            String nome = outNome.getText();
            int crm = Integer.parseInt(outCrm.getText());
            String dias = outDias.getText();
            int consultorio = Integer.parseInt(outConsultorio.getText());
            Medico medico = new Medico(nome,crm,dias,consultorio);
            MedicoController.CreateMedico(medico);
        }
        if(e.getSource() == voltar){
            dispose();
            new UserInicial();
        }
        if(e.getSource() == botaoUpdate){
            String nome = outNome.getText();
            int crm = Integer.parseInt(outCrm.getText());
            String dias = outDias.getText();
            int consultorio = Integer.parseInt(outConsultorio.getText());
            Medico medico = new Medico(nome,crm,dias,consultorio);
            MedicoController.updateMedic(medico);
        }
    }
}
