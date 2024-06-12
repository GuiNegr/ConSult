package View;

import Controller.ComponentView;
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
        setSize(640, 400);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        loginTXT = ComponentView.text("User Login");
        passTxt = ComponentView.pass("User Pass");
        add(loginTXT); add(passTxt);
        botao = ComponentView.botao("LOGIN");
        add(botao);
        botao.addActionListener(this);
        getContentPane().setLayout(new GridLayout(3,1));
        setVisible(true);
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
            } else if (stg.equalsIgnoreCase("ADMIN")) {
                JOptionPane.showMessageDialog(null,"olá admin");
            }else if(stg.equalsIgnoreCase("MEDICO")){
                new MedicoInterface();
                dispose();
            }else {
                JOptionPane.showMessageDialog(null,"ERRO DE USUARIO NÃO ENCONTRADO");
                new LoginForm();
            }
        }
    }
}
