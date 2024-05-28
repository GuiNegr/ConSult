package Model;

public class Medico {
    private String nomeMedico;
    private int crmMedico;

    public Medico(String nomeMedico, int crmMedico) {
        this.nomeMedico = nomeMedico;
        this.crmMedico = crmMedico;
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
}
