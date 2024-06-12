package Controller;

import View.UserInicial;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.io.File;
import java.text.ParseException;

public class ComponentView{

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


    public static Font monteserrat(){
        try{
            Font monte = Font.createFont(Font.TRUETYPE_FONT,new File("C:\\Users\\Gui\\Desktop\\BackUp11-06\\Consult\\ConSult\\src\\Fonte\\Montserrat\\static\\Montserrat-Bold.ttf")).deriveFont(Font.BOLD,40);
            return monte;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Font monteserrat(int size){
        try{
            Font monte = Font.createFont(Font.TRUETYPE_FONT,new File("C:\\Users\\Gui\\Desktop\\BackUp11-06\\Consult\\ConSult\\src\\Fonte\\Montserrat\\static\\Montserrat-Bold.ttf")).deriveFont(Font.BOLD,size);
            return monte;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static JLabel label(String text){
        JLabel label = new JLabel();
        label.setText(text);
        label.setBackground(new Color(71, 35, 189, 255));
        label.setForeground(new Color(71, 35, 189, 255));
        label.setFont(monteserrat());
        return label;
    }

    public static JButton botao(String text){
        JButton botao = new JButton();
        botao.setText(text);
        Font fonte = monteserrat();
        botao.setFont(fonte);
        botao.setBackground(new Color(71, 35, 189, 255));
        botao.setForeground(new Color(231, 201, 144));
        return botao;
    }
    public static JFormattedTextField txtData() throws ParseException {
        MaskFormatter mascaraData = new MaskFormatter("2024-##-##");
        JFormattedTextField txt = new JFormattedTextField(mascaraData);
        txt.setFont(ComponentView.monteserrat());
        txt.setForeground(new Color(156, 65, 235));
        return txt;
    }

    public static JFormattedTextField txtHora() throws ParseException {
        MaskFormatter mascaraHora  = new MaskFormatter("##:##:00");
        JFormattedTextField txt = new JFormattedTextField(mascaraHora);
        txt.setFont(ComponentView.monteserrat());
        txt.setForeground(new Color(156, 65, 235));
        return txt;
    }

    public static JTextField  text(){
        JTextField textField = new JTextField();
        textField.setFont(ComponentView.monteserrat());
        textField.setForeground(new Color(0xE7C990));
        return textField;
    }

    public static JTextField  text(String text){
        JTextField textField = new JTextField();
        textField.setFont(ComponentView.monteserrat());
        textField.setForeground(new Color(0xE7C990));
        textField.setText(text);
        return textField;
    }
    public static JPasswordField pass(String text){
        JPasswordField txt = new JPasswordField();
        txt.setText(text);
        txt.setForeground(new Color(231, 201, 144));
        txt.setFont(new Font("robot",Font.BOLD,22));
        return txt;
    }
}
