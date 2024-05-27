package View;

import Controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener{

    private JTextField loginTXT;
    private JTextField passTxt;
    private JButton botao;


    public LoginForm(){
        setSize(300,300);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        loginTXT = textComponent("User Login");
        passTxt = textComponent("User Pass");
        botao = botao("LOGIN");
        getContentPane().setLayout(new GridLayout(3,1));
        setVisible(true);
    }

    private JButton botao(String text){
       JButton botao = new JButton();
       botao.setBackground(new Color(139, 114, 236));
       botao.setForeground(new Color(231, 201, 144));
       botao.setText(text);
       botao.addActionListener(this);
       add(botao);
       botao.setFont(new Font("robot",Font.BOLD,22));
       return botao;
    }

    public JTextField textComponent(String text){
      JTextField txt = new JTextField();
      txt.setText(text);
      txt.setForeground(new Color(231, 201, 144));
      txt.setFont(new Font("robot",Font.BOLD,22));
      add(txt);
      return txt;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botao){
            String login = loginTXT.getText();
            String pass = passTxt.getText();
            if(new LoginController().verifica(login,pass)){
                JOptionPane.showMessageDialog(null,"FOI DEMAIS");
            }
            else {
                JOptionPane.showMessageDialog(null, "meu deus mto ruim em java");
            }
        }
    }
}
