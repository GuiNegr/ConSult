package View;

import Controller.ComponentView;
import Controller.ControllerPaciente;
import Controller.MedicoController;
import Model.Login;
import Model.Medico;
import Model.Paciente;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;

public class UserInicial extends JFrame implements ActionListener {
    private JLabel consult;
    private JButton rdPac;
    private JButton rdMedc;
    private JButton crtPac;
    private JButton crtConsu;
    private JButton exameAgend;
    private JPanel painelButtons;
    private JPanel painelLogo;

    public UserInicial(){
        setSize(1280,720);
        setTitle("Consult:UserPainel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        painelButtons = painelBotao();
        painelButtons.setLayout(new GridLayout(5,1));
        rdPac = botao("PESQUISAR PACIENTES");
        rdMedc = botao("PESQUISAR MEDICOS");
        crtPac = botao("CADASTRAR PACIENTES");
        exameAgend = botao("AGENDAR EXAME");
        crtConsu = botao("AGENDAR CONSULTA");
        painelButtons.add(rdPac);
        painelButtons.add(rdMedc);
        painelButtons.add(crtPac);
        painelButtons.add(crtConsu);

        painelButtons.add(exameAgend);
        painelLogo = painelLabel();
        consult = label("ConSult");
        painelLogo.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        painelLogo.add(consult, gbc);


        add(painelLogo,BorderLayout.CENTER);
        add(painelButtons,BorderLayout.WEST);
        setVisible(true);
    }


    private JPanel painelLabel(){
        JPanel painel = new JPanel();
        painel.setBackground(Color.WHITE);
        add(painel);
        return painel;
    }

    private JPanel painelBotao(){
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        add(painel);
        return painel;
    }
    private JButton botao(String text){
        JButton botao = new JButton();
        botao.setText(text);
        Font fonte = ComponentView.monteserrat();
        botao.setFont(fonte);
        botao.setBackground(new Color(71, 35, 189, 255));
        botao.setForeground(new Color(231, 201, 144));
        botao.addActionListener(this);
        add(botao);
        return botao;

    }



    private JLabel label(String text){
        JLabel label = new JLabel();
        label.setText(text);
        label.setBackground(new Color(71, 35, 189, 255));
        label.setFont(ComponentView.monteserrat());
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == crtPac){
            new PacientesView();
            dispose();
        }
        if(e.getSource() == rdPac){
            String cpf = JOptionPane.showInputDialog(null,"Insira o cpf do paciente");
            Paciente paciente = ControllerPaciente.returnWithCpf(cpf);
            new PacientesView(paciente);
            dispose();
        }
        if(e.getSource() == rdMedc){
            String crm = JOptionPane.showInputDialog(null,"Insira o crm do medico desejado");
            Medico medico = MedicoController.returnWithCrm(Integer.parseInt(crm));
            new MedicoAddUpdate(medico);
            dispose();
        }
        if(e.getSource() == crtConsu){
           try{
               new AgendarConsulta();
               dispose();
           }catch (ParseException a){
               JOptionPane.showMessageDialog(null,a.getMessage());
           }
        }
        if(e.getSource() == exameAgend){
            try {
                dispose();
                new AgendarExame();
            }catch (ParseException a){
                JOptionPane.showMessageDialog(null,a.getMessage());
            }
        }


        painelLogo = painelLabel();
        consult = label("ConSult");
        painelLogo.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        painelLogo.add(consult, gbc);


        add(painelLogo,BorderLayout.CENTER);
        add(painelButtons,BorderLayout.WEST);
        setVisible(true);
    }


    private JPanel painelLabel(){
        JPanel painel = new JPanel();
        painel.setBackground(Color.WHITE);
        add(painel);
        return painel;
    }

    private JPanel painelBotao(){
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        add(painel);

        return painel;
    }
    private JButton botao(String text){
        JButton botao = new JButton();
        botao.setText(text);
        Font fonte = monteserrat();
        botao.setFont(fonte);
        botao.setBackground(new Color(71, 35, 189, 255));
        botao.setForeground(new Color(231, 201, 144));
        add(botao);
        return botao;

    }

    private Font monteserrat(){
        try{
            Font monte = Font.createFont(Font.TRUETYPE_FONT,new File("C:\\Users\\Gui\\Desktop\\Consult\\ConSult\\src\\Fonte\\Montserrat\\static\\Montserrat-Bold.ttf")).deriveFont(Font.BOLD,40);
            return monte;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    private JLabel label(String text){
        JLabel label = new JLabel();
        label.setText(text);
        label.setBackground(new Color(71, 35, 189, 255));
        label.setFont(monteserrat());
        return label;
    }
}
