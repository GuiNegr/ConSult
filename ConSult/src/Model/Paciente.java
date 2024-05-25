package Model;

public class Paciente {
    private String cpfPaciente;
    private String nomePaciente;
    private String enderecoPaciente;
    private String pacienteConvenio;

    public Paciente(String nomePaciente, String enderecoPaciente, String pacienteConvenio) {
        this.nomePaciente = nomePaciente;
        this.enderecoPaciente = enderecoPaciente;
        this.pacienteConvenio = pacienteConvenio;
    }

    public Paciente(String cpfPaciente, String nomePaciente, String enderecoPaciente, String pacienteConvenio) {
        this.cpfPaciente = cpfPaciente;
        this.nomePaciente = nomePaciente;
        this.enderecoPaciente = enderecoPaciente;
        this.pacienteConvenio = pacienteConvenio;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
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
