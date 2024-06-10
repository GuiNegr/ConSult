package Model;

import java.io.FileInputStream;

public class Exame {
    private String id;
    private String nomeExame;
    private String descExame;
    private FileInputStream fotoExame;
    private int tamanho;
    private String idConsulta;

    public Exame() {
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
}
