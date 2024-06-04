package View;

import Controller.ControllerPaciente;
import Model.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class PacientesView  extends  JFrame implements ActionListener{
    private JTextField outNome;
    private JTextField outCpf;
    private JTextField outEndereco;
    private JTextField outConvenio;
    private JLabel labelNome;
    private JLabel labelCpf;
    private JLabel labelEndereco;
    private JLabel labelConvenio;
    private JButton botaoCrt;
    private JButton botao2;
    private JButton botaoAtt;

    public PacientesView(){
        setSize(680,420);
        setTitle("Formulario de Pacientes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(139, 114, 236));
        labelNome = label("Nome: ");
        outNome = text();
        labelCpf = label("Cpf: ");
        outCpf = text();
        labelEndereco = label("Endereço: ");
        outEndereco = text();
        labelConvenio = label("Convenio: ");
        outConvenio = text();

        botaoCrt = botao("Criar Paciente");
        botao2 = botao("Voltar");
        botao2.addActionListener( e ->{
            dispose();
            new UserInicial();
        });

        getContentPane().setLayout(new GridLayout(5,2));
        setVisible(true);


        setVisible(true);
    }


    public PacientesView(Paciente paciente){
        setSize(680,420);
        setTitle("Formulario de Pacientes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(139, 114, 236));
        labelNome = label("Nome: ");
        outNome = text(paciente.getNomePaciente());
        labelCpf = label("Cpf: ");
        outCpf = text(paciente.getCpfPaciente());
        labelEndereco = label("Endereço: ");
        outEndereco = text(paciente.getEnderecoPaciente());
        labelConvenio = label("Convenio: ");
        outConvenio = text(paciente.getPacienteConvenio());

        botaoAtt = botao("Modificar");
        botao2 = botao("Voltar");
        botao2.addActionListener( e ->{
            dispose();
            new UserInicial();
        });

        getContentPane().setLayout(new GridLayout(5,2));
        setVisible(true);


        setVisible(true);
    }

    private JLabel label(String text){
        JLabel label = new JLabel();
        label.setText(text);
        label.setFont(UserInicial.monteserrat());
        label.setForeground(Color.white);
        add(label);
        return label;
    }

    private JTextField text(){
        JTextField textField = new JTextField();
        textField.setFont(UserInicial.monteserrat());
        textField.setForeground(new Color(0xE7C990));
        add(textField);
        return textField;
    }

    private JTextField text(String text){
        JTextField textField = new JTextField();
        textField.setFont(UserInicial.monteserrat());
        textField.setForeground(new Color(0xE7C990));
        textField.setText(text);
        add(textField);
        return textField;
    }

    public JButton botao(String text){
        JButton botao = new JButton();
        botao.setText(text);
        botao.setFont(UserInicial.monteserrat());
        botao.setBackground(Color.white);
        botao.setForeground(new Color(71, 35, 189));
        botao.addActionListener(this);
        add(botao);
        return botao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == botaoAtt){
                String nome = outNome.getText();
                String cpf = outCpf.getText();
                String endereco = outEndereco.getText();
                String convenio = outConvenio.getText();

                Paciente paciente = new Paciente(cpf,nome,endereco,convenio);
                ControllerPaciente.updatePaciete(paciente);
                new UserInicial();
                dispose();
            }

        if(e.getSource() == botaoCrt){
            String nome = outNome.getText();
            String cpf = outCpf.getText();
            String endereco = outEndereco.getText();
            String convenio = outConvenio.getText();

            Paciente paciente = new Paciente(cpf,nome,endereco,convenio);
            ControllerPaciente.createPaciente(paciente);

            new UserInicial();
            dispose();
        }
    }

}
