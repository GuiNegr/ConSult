import Controller.AgendaExameController;
import Model.Exame;
import View.AgendarConsulta;
import View.LoginForm;

import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        AgendaExameController a = new AgendaExameController();
        List<Exame> exames = a.readExame();
        System.out.println(exames);
    }
}