package View;

import Controller.ComponentView;
import Model.Exame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.sql.Blob;

public class ViewExame extends JFrame implements ActionListener {

    private JTextField outNome;
    private JLabel nomeExame;
    private JTextField outDesc;
    private JLabel descExame;
    private JTextField outIdConsulta;
    private JLabel idConsulta;
    private JButton criar;
    private JButton voltar;
    private JButton concluido;
    private FileInputStream fis;
    private int tamanho;
    private Exame exame;

    private JPanel painelLogo;
    private JPanel painelButtons;
    private JPanel painelLabels;
    private JPanel label;
    private JLabel  labelImg = ComponentView.label("ConSult");


    public ViewExame(Exame exame){
            CarregarImg(exame);
            setSize(1280,720);
            setTitle("cadastro de exame");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            nomeExame = ComponentView.label("NOME DO EXAME:");
            outNome = ComponentView.text(exame.getNomeExame());

            descExame = ComponentView.label("DESCRIÇÃO DO EXAME:");
            outDesc = ComponentView.text(exame.getDescExame());

            idConsulta = ComponentView.label("ID DE CONSULTA DO EXAME:");
            outIdConsulta = ComponentView.text(exame.getIdConsulta());

            painelLabels = new JPanel();
            painelLabels.add(nomeExame);
            painelLabels.add(outNome);
            painelLabels.add(descExame);
            painelLabels.add(outDesc);
            painelLabels.add(idConsulta);
            painelLabels.add(outIdConsulta);
            painelLabels.setLayout(new GridLayout(6,1));


            criar = ComponentView.botao("ADICIONAR EXAME");
            criar.addActionListener(this);
            voltar = ComponentView.botao("VOLTAR");
            voltar.addActionListener(this);
            concluido = ComponentView.botao("Enivar");
            concluido.addActionListener(this);



            painelButtons = ComponentView.painelBotao();
            painelButtons.add(voltar);
            painelButtons.setLayout(new GridLayout(1,1));

            painelLogo = ComponentView.painelLabel();
            painelLogo.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            painelLogo.add(labelImg, gbc);

            add(painelLabels,BorderLayout.WEST);
            add(painelButtons,BorderLayout.SOUTH);
            add(painelLogo,BorderLayout.CENTER);
            setVisible(true);

        }

        public void CarregarImg(Exame exame){
        try {
            Blob blob = exame.getFoto();
            byte[] img = blob.getBytes(1,(int)blob.length());
            BufferedImage image = null;
            try {
                image = ImageIO.read(new ByteArrayInputStream(img));
            }catch (Exception E){
                JOptionPane.showMessageDialog(null,E.getMessage());
            }
                ImageIcon icone = new ImageIcon(image);
                Icon foto = new ImageIcon(icone.getImage());
                labelImg.setIcon(foto);
                labelImg.setText(" ");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        }
    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == voltar){
                dispose();
                new MedicoInterface();
            }
    }
}

