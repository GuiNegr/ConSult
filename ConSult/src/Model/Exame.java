package Model;

import java.io.FileInputStream;
import java.sql.Date;
import java.sql.Time;

public class Exame {
    private String id;
    private String nomeExame;
    private String descExame;
    private FileInputStream fotoExame;
    private int tamanho;
    private String idConsulta;
    Date dataExame;
    Time timeExame;
    private  String cpfPaciente;


    public Exame(String id, String nomeExame, String descExame, Time timeExame, Date dataExame, String cpfPaciente) {
        this.id = id;
        this.nomeExame = nomeExame;
        this.descExame = descExame;
        this.timeExame = timeExame;
        this.dataExame = dataExame;
        this.cpfPaciente = cpfPaciente;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public Exame(String nomeExame, String descExame, Date dataExame, Time timeExame, String cpfPaciente) {
        this.nomeExame = nomeExame;
        this.descExame = descExame;
        this.dataExame = dataExame;
        this.timeExame = timeExame;
        this.cpfPaciente = cpfPaciente;
    }

    public Exame(String id, String nomeExame, String descExame, String idConsulta, Date dataExame, Time timeExame) {
        this.id = id;
        this.nomeExame = nomeExame;
        this.descExame = descExame;
        this.idConsulta = idConsulta;
        this.dataExame = dataExame;
        this.timeExame = timeExame;
    }

    public Exame() {
    }

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public Time getTimeExame() {
        return timeExame;
    }

    public void setTimeExame(Time timeExame) {
        this.timeExame = timeExame;
    }

    public Exame(String nomeExame, String descExame, String idConsulta, Date dataExame, Time timeExame) {
        this.nomeExame = nomeExame;
        this.descExame = descExame;
        this.idConsulta = idConsulta;
        this.dataExame = dataExame;
        this.timeExame = timeExame;
    }

    public Exame(String nomeExame, String descExame, FileInputStream fotoExame, String idConsulta) {
        this.nomeExame = nomeExame;
        this.descExame = descExame;
        this.fotoExame = fotoExame;
        this.idConsulta = idConsulta;
    }

    public Exame(int tamanho, FileInputStream fotoExame) {
        this.tamanho = tamanho;
        this.fotoExame = fotoExame;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public String getDescExame() {
        return descExame;
    }

    public void setDescExame(String descExame) {
        this.descExame = descExame;
    }

    public FileInputStream getFotoExame() {
        return fotoExame;
    }

    public void setFotoExame(FileInputStream fotoExame) {
        this.fotoExame = fotoExame;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Exame{" +
                "id='" + id + '\'' +
                ", nomeExame='" + nomeExame + '\'' +
                ", descExame='" + descExame + '\'' +
                ", fotoExame=" + fotoExame +
                ", tamanho=" + tamanho +
                ", idConsulta='" + idConsulta + '\'' +
                ", dataExame=" + dataExame +
                ", timeExame=" + timeExame +
                ", cpfPaciente='" + cpfPaciente + '\'' +
                '}';
    }
}
