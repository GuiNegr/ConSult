package Model;

public class Medico {
    private String id_Medico;
    private String nomeMedico;
    private String crmMedico;

    public Medico(String nomeMedico, String crmMedico) {
        this.nomeMedico = nomeMedico;
        this.crmMedico = crmMedico;
    }

    public Medico(String id_Medico, String nomeMedico, String crmMedico) {
        this.id_Medico = id_Medico;
        this.nomeMedico = nomeMedico;
        this.crmMedico = crmMedico;
    }

    public String getId_Medico() {
        return id_Medico;
    }

    public void setId_Medico(String id_Medico) {
        this.id_Medico = id_Medico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }
}
