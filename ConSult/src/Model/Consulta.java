package Model;

import java.sql.*;

public class Consulta {
    private String id_Consulta;
    private Date dataConsulta;
    private Time timeConsulta;
    private String id_fk_paciente;
    private String id_fk_medico;

    public Consulta(String id_Consulta, Date dataConsulta, Time timeConsulta, String id_fk_paciente, String id_fk_medico) {
        this.id_Consulta = id_Consulta;
        this.dataConsulta = dataConsulta;
        this.timeConsulta = timeConsulta;
        this.id_fk_paciente = id_fk_paciente;
        this.id_fk_medico = id_fk_medico;
    }

    public Consulta(Date dataConsulta, Time timeConsulta, String id_fk_paciente, String id_fk_medico) {
        this.dataConsulta = dataConsulta;
        this.timeConsulta = timeConsulta;
        this.id_fk_paciente = id_fk_paciente;
        this.id_fk_medico = id_fk_medico;
    }

    public String getId_Consulta() {
        return id_Consulta;
    }

    public void setId_Consulta(String id_Consulta) {
        this.id_Consulta = id_Consulta;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Time getTimeConsulta() {
        return timeConsulta;
    }

    public void setTimeConsulta(Time timeConsulta) {
        this.timeConsulta = timeConsulta;
    }

    public String getId_fk_paciente() {
        return id_fk_paciente;
    }

    public void setId_fk_paciente(String id_fk_paciente) {
        this.id_fk_paciente = id_fk_paciente;
    }

    public String getId_fk_medico() {
        return id_fk_medico;
    }

    public void setId_fk_medico(String id_fk_medico) {
        this.id_fk_medico = id_fk_medico;
    }
}
