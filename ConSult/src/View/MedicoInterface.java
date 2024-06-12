package View;

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

public class MedicoInterface extends JFrame implements ActionListener {
    private JLabel consult;
    private JButton rdPac;
    private JButton vizualizarConsulta;
    private JButton crcExame;
    private JButton agndConsult;
    private JPanel painelButtons;
    private JPanel painelLogo;

    public MedicoInterface() {
        setSize(1280, 720);
        setTitle("Consult:MedicPainel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        painelButtons = painelBotao();
        painelButtons.setLayout(new GridLayout(4, 1));
        rdPac = botao("PESQUISAR PACIENTES");
        vizualizarConsulta = botao("VER HISTORICO DE PACIENTE");
        crcExame = botao("CRIAR EXAME");
        agndConsult = botao("Agendar consulta");
        painelButtons.add(agndConsult);
        painelButtons.add(rdPac);
        painelButtons.add(vizualizarConsulta);
        painelButtons.add(crcExame);

        painelLogo = painelLabel();
        consult = label("ConSult");
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


    private JPanel painelLabel() {
        JPanel painel = new JPanel();
        painel.setBackground(Color.WHITE);
        add(painel);
        return painel;
    }

    private JPanel painelBotao() {
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        add(painel);

        return painel;
    }

    private JButton botao(String text) {
        JButton botao = new JButton();
        botao.setText(text);
        Font fonte = monteserrat();
        botao.setFont(fonte);
        botao.setBackground(new Color(71, 35, 189, 255));
        botao.setForeground(new Color(231, 201, 144));
        botao.addActionListener(this);
        add(botao);
        return botao;

    }

    public static Font monteserrat() {
        try {
            Font monte = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Gui\\Desktop\\Consult\\ConSult\\src\\Fonte\\Montserrat\\static\\Montserrat-Bold.ttf")).deriveFont(Font.BOLD, 40);
            return monte;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private JLabel label(String text) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setBackground(new Color(71, 35, 189, 255));
        label.setFont(monteserrat());
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
