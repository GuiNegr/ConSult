package Model;

public class Medico {
    private String nomeMedico;
    private int crmMedico;
    private String diaDaSemana;
    private int consultorio;


    public Medico(String nomeMedico, int crmMedico, String diaDaSemana, int consultorio) {
        this.nomeMedico = nomeMedico;
        this.crmMedico = crmMedico;
        this.diaDaSemana = diaDaSemana;
        this.consultorio = consultorio;
    }

    public Medico(int consultorio, String diaDaSemana) {
        this.consultorio = consultorio;
        this.diaDaSemana = diaDaSemana;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public int getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(int crmMedico) {
        this.crmMedico = crmMedico;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public int getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(int consultorio) {
        this.consultorio = consultorio;
    }
}
