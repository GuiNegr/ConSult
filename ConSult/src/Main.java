import Controller.ConsultaController;
import Controller.MedicoController;
import Model.Consulta;
import Model.Medico;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Medico medico = new Medico("DR Guilherme secola rei do java SECO",300300);
        MedicoController mdc = new MedicoController();
        mdc.updateMedic(medico);
    }
}