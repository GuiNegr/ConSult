package View;

import Controller.ComponentView;
import Controller.ControllerPaciente;
import Model.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        setSize(1280,720);
        setTitle("Formulario de Pacientes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        labelNome = ComponentView.label("Nome: ");
        outNome = ComponentView.text();

        labelCpf = ComponentView.label("Cpf: ");
        outCpf = ComponentView.text();

        labelEndereco = ComponentView.label("Endereço: ");
        outEndereco = ComponentView.text();

        labelConvenio = ComponentView.label("Convenio: ");
        outConvenio = ComponentView.text();

        add(labelNome);
        add(outNome);
        add(labelCpf);
        add(outCpf);
        add(labelEndereco);
        add(outEndereco);
        add(labelConvenio);
        add(outConvenio);

        botaoCrt = ComponentView.botao("Criar Paciente");
        add(botaoCrt);
        botaoCrt.addActionListener(this);


        botao2 = ComponentView.botao("Voltar");
        add(botao2);
        botao2.addActionListener( e ->{
            dispose();
            new UserInicial();
        });


        getContentPane().setLayout(new GridLayout(5,2));
        setVisible(true);


        setVisible(true);
    }


    public PacientesView(Paciente paciente){
        setSize(1280,720);
        setTitle("Formulario de Pacientes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        labelNome = ComponentView.label("NOME PACIENTE");
        outNome = ComponentView.text(paciente.getNomePaciente());

        labelCpf = ComponentView.label("CPF PACIENTE");
        outCpf = ComponentView.text(paciente.getCpfPaciente());

        labelEndereco = ComponentView.label("Endereço: ");
        outEndereco = ComponentView.text(paciente.getEnderecoPaciente());

        labelConvenio = ComponentView.label("Convenio: ");
        outConvenio = ComponentView.text(paciente.getPacienteConvenio());

        add(labelNome); add(outNome); add(labelCpf); add(outCpf); add(labelEndereco); add(outEndereco); add(labelConvenio); add(outConvenio);

        botaoAtt = ComponentView.botao("Modificar");
        add(botaoAtt);
        botaoAtt.addActionListener(this);


        botao2 = ComponentView.botao("Voltar");
        add(botao2);
        botao2.addActionListener( e ->{
            dispose();
            new UserInicial();
        });


        getContentPane().setLayout(new GridLayout(5,2));
        setVisible(true);


        setVisible(true);
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
