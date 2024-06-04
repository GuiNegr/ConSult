package View;

import Controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener{

    private JTextField loginTXT;
    private JPasswordField passTxt;
    private JButton botao;


    public LoginForm(){
        setSize(300,300);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        loginTXT = textComponent("User Login");
        passTxt = pass("User Pass");
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

    public JPasswordField pass(String text){
        JPasswordField txt = new JPasswordField();
        txt.setText(text);
        txt.setForeground(new Color(231, 201, 144));
        txt.setFont(new Font("robot",Font.BOLD,22));
        add(txt);
        return txt;
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
            String stg = new LoginController().getTipo(login,pass);
            setVisible(false);
            if(stg.equalsIgnoreCase("USER")){
                new UserInicial();
                dispose();
            if(stg.equalsIgnoreCase("USER")){
                new UserInicial();
            } else if (stg.equalsIgnoreCase("ADMIN")) {
                JOptionPane.showMessageDialog(null,"olá admin");
            }else if(stg.equalsIgnoreCase("MEDICO")){
                JOptionPane.showMessageDialog(null,"olá medico");
            }else {
                JOptionPane.showMessageDialog(null,"ERRO DE USUARIO NÃO ENCONTRADO");
            }
        }
    }
}
