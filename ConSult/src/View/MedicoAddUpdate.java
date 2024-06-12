package View;

import Controller.ComponentView;
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
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        nomeMedico = ComponentView.label("Nome: ");
        outNome = ComponentView.text();

        crmMedico =  ComponentView.label("Crm: ");
        outCrm = ComponentView.text();

        diasDaSemana =  ComponentView.label("Dias Disponiveis");
        outDias = ComponentView.text("Ex: Seg,terc,quart");

        consultorio =  ComponentView.label("Consultorio: ");
        outConsultorio = ComponentView.text();

        add(nomeMedico); add(outNome); add(crmMedico); add(outCrm); add(diasDaSemana); add(outDias); add(consultorio); add(outConsultorio);

        botaoCad = ComponentView.botao("cad medico");
        botaoCad.addActionListener(this);
        add(botaoCad);

        voltar = ComponentView.botao("Voltar");
        voltar.addActionListener(this);
        add(voltar);

        getContentPane().setLayout(new GridLayout(5,2));
        setVisible(true);
    }


    public MedicoAddUpdate(Medico medico){
        setTitle("Medico: Form");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        nomeMedico = ComponentView.label("Nome: ");
        outNome = ComponentView.text(medico.getNomeMedico());

        crmMedico = ComponentView.label("Crm: ");
        outCrm = ComponentView.text(String.valueOf(medico.getCrmMedico()));

        diasDaSemana = ComponentView.label("Dias Disponiveis");
        outDias = ComponentView.text(medico.getDiaDaSemana());

        consultorio = ComponentView.label("Consultorio: ");
        outConsultorio = ComponentView.text(String.valueOf(medico.getConsultorio()));

        add(nomeMedico); add(outNome); add(crmMedico); add(outCrm); add(diasDaSemana); add(outDias); add(consultorio); add(outConsultorio);

        botaoUpdate = ComponentView.botao("Atualizar medico");
        botaoUpdate.addActionListener(this);
        add(botaoUpdate);


        voltar = ComponentView.botao("Voltar");
        voltar.addActionListener(this);
        add(voltar);
        getContentPane().setLayout(new GridLayout(5,2));
        setVisible(true);
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
