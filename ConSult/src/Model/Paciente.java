package Model;

public class Paciente {
    private String id_paciente;
    private String nomePaciente;
    private String enderecoPaciente;
    private String pacienteConvenio;

    public Paciente(String nomePaciente, String enderecoPaciente, String pacienteConvenio) {
        this.nomePaciente = nomePaciente;
        this.enderecoPaciente = enderecoPaciente;
        this.pacienteConvenio = pacienteConvenio;
    }

    public Paciente(String id_paciente, String nomePaciente, String enderecoPaciente, String pacienteConvenio) {
        this.id_paciente = id_paciente;
        this.nomePaciente = nomePaciente;
        this.enderecoPaciente = enderecoPaciente;
        this.pacienteConvenio = pacienteConvenio;
    }

    public String getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getEnderecoPaciente() {
        return enderecoPaciente;
    }

    public void setEnderecoPaciente(String enderecoPaciente) {
        this.enderecoPaciente = enderecoPaciente;
    }

    public String getPacienteConvenio() {
        return pacienteConvenio;
    }

    public void setPacienteConvenio(String pacienteConvenio) {
        this.pacienteConvenio = pacienteConvenio;
    }
}
