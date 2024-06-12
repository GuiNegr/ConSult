package View;

import Controller.ComponentView;
import Controller.ExameController;
import Model.Exame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

public class ExameCreateView extends JFrame implements ActionListener {

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
    private JLabel  labelImg = la("ConSult");

    public ExameCreateView(){
        exame = new Exame();
        setSize(1280,720);
        setTitle("cadastro de exame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        nomeExame = ComponentView.label("NOME DO EXAME:");
        outNome = ComponentView.text();

        descExame = ComponentView.label("DESCRIÇÃO DO EXAME:");
        outDesc = ComponentView.text();

        idConsulta = ComponentView.label("ID DE CONSULTA DO EXAME:");
        outIdConsulta = ComponentView.text();

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
        painelButtons.add(criar);
        painelButtons.add(concluido);
        painelButtons.setLayout(new GridLayout(1,3));

        painelLogo = ComponentView.painelLabel();
        painelLogo.setLayout(new GridBagLayout());
        painelLogo.setBackground(new Color(139, 114, 236));
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

    public void adicionaImg(){
        JFileChooser pegador = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG & JPEG","jpg","png","jpeg");
        pegador.setFileFilter(filter);
        int returnVal = pegador.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
          try {
              File select = pegador.getSelectedFile();
              this.fis = new FileInputStream(select);
              this.tamanho = (int) select.length();
              this.exame.setFotoExame(fis);
              this.exame.setTamanho(tamanho);
              labelImg.setText("");
              Image foto = ImageIO.read(select).getScaledInstance(labelImg.getWidth(), labelImg.getHeight(), Image.SCALE_SMOOTH);
              labelImg.setIcon(new ImageIcon(foto));
          }catch (Exception e){
              System.out.println(e.getMessage());
          }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == criar){
            String nome = outNome.getText();
            String desc = outDesc.getText();
            String id = outIdConsulta.getText();
            this.exame.setDescExame(desc);
            this.exame.setNomeExame(nome);
            this.exame.setIdConsulta(id);
            adicionaImg();
        }
        if(e.getSource() == voltar){
            dispose();
            new MedicoInterface();
        }
        if(e.getSource() == concluido){
            ExameController.CreateExame(this.exame);
        }
    }
    public static JPanel painelLabel(){
        JPanel painel = new JPanel();
        painel.setBackground(Color.WHITE);

        return painel;
    }
    public static JPanel painelBotao(){
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);

        return painel;
    }

    public JLabel la(String text){
        JLabel label1 = new JLabel();
        label1.setText(text);
        label1.setFont(ComponentView.monteserrat(100));
        label1.setForeground(Color.white);
        add(label1);
        return label1;
    }
}
