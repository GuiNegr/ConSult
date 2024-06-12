package View;

import Controller.ComponentView;
import Controller.ControllerPaciente;
import Controller.ExameController;
import Model.Exame;
import Model.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class MedicoInterface extends JFrame implements ActionListener {
    private JLabel consult;
    private JButton rdPac;
    private JButton viewEx;
    private JButton crcExame;
    private JButton agndConsult;
    private JPanel painelButtons;
    private JPanel painelLogo;

    public MedicoInterface() {
        setSize(1280, 720);
        setTitle("Consult:MedicPainel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        painelButtons = ComponentView.painelBotao();
        painelButtons.setLayout(new GridLayout(4, 1));

        rdPac = ComponentView.botao("PESQUISAR PACIENTES");
        rdPac.addActionListener(this);

        viewEx = ComponentView.botao("VER EXAME DE PACIENTE");
        viewEx.addActionListener(this);

        crcExame = ComponentView.botao("CRIAR EXAME");
        crcExame.addActionListener(this);


        agndConsult = ComponentView.botao("AGENDAR CONSULTA");
        agndConsult.addActionListener(this);

        painelButtons.add(agndConsult);
        painelButtons.add(rdPac);
        painelButtons.add(viewEx);
        painelButtons.add(crcExame);

        painelLogo = ComponentView.painelLabel();
        consult = ComponentView.label("ConSult");

        painelLogo.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        painelLogo.add(consult, gbc);


        add(painelLogo, BorderLayout.CENTER);
        add(painelButtons, BorderLayout.WEST);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rdPac){
            String cpf = JOptionPane.showInputDialog(null,"Insira o cpf do paciente");
            Paciente paciente = ControllerPaciente.returnWithCpf(cpf);
            new PacientesView(paciente);
            dispose();
        }
        if(e.getSource() == crcExame){
            new ExameCreateView();
            dispose();
        }
        if(e.getSource() == agndConsult ){
            try{
                new AgendarConsultaMed();
                dispose();;
            } catch (ParseException a){
                JOptionPane.showMessageDialog(null, a.getMessage());
            }
        }
        if(e.getSource() == viewEx){
            String a = JOptionPane.showInputDialog(null,"INFOMRE O ID DO EXAME");
            Exame exame = ExameController.listExame(a);
            new ViewExame(exame);
            dispose();
        }
    }
}
