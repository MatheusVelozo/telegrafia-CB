package ImportXLS;

import java.io.Serializable;
import java.util.Date;

public class ModelOcorrencia  implements Serializable {

    public static final long serialVersionUID = 1L;
    private Long id;
    private Date dataOcorrencia;
    private Integer numeroTalao;
    private String vtr;
    private String endereco;
    private String cidade;
    private String horarioInicial;
    private String horarioFinal;
    private Integer kmInicial;
    private Integer KmLocal;
    private Integer kmFinal;
    private String codigo;
    private String qru;
    private String tipoOcorrencia;
    private Integer qtdVitimasVivas;
    private Integer qtdVitimasFatais;
    private String comandante;
    private String motorista;
    private String cecom;
    private String observacao;
    private Double latitude;
    private Double longitude;

    @Override
    public String toString() {
        return "Ocorrências: {" +
                "DATA=" + dataOcorrencia +
                ", TALÃO=" + numeroTalao +
                ", VIATURA='" + vtr + '\'' +
                ", ENDEREÇO='" + endereco + '\'' +
                ", CIDADE='" + cidade + '\'' +
                ", HI=" + horarioInicial +
                ", HF=" + horarioFinal +
                ", KMINICIAL=" + kmInicial +
                ", KMLOCAL=" + KmLocal +
                ", KMFINAL=" + kmFinal +
                ", CÓD.='" + codigo + '\'' +
                ", QRU='" + qru + '\'' +
                ", NATUREZA='" + tipoOcorrencia + '\'' +
                ", VV='" + qtdVitimasVivas + '\'' +
                ", VF='" + qtdVitimasFatais + '\'' +
                ", CMD='" + comandante + '\'' +
                ", MOT='" + motorista + '\'' +
                ", CECOM='" + cecom + '\'' +
                ", OBSERVAÇÃO='" + observacao + '\'' +
                '}';
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public Integer getNumeroTalao() {
        return numeroTalao;
    }

    public void setNumeroTalao(Integer numeroTalao) {
        this.numeroTalao = numeroTalao;
    }

    public String getVtr() {
        return vtr;
    }

    public void setVtr(String vtr) {
        this.vtr = vtr;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public Integer getKmLocal() {
        return KmLocal;
    }

    public void setKmLocal(Integer kmLocal) {
        KmLocal = kmLocal;
    }

    public Integer getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(Integer kmInicial) {
        this.kmInicial = kmInicial;
    }

    public Integer getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(Integer kmFinal) {
        this.kmFinal = kmFinal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getQru() {
        return qru;
    }

    public void setQru(String qru) {
        this.qru = qru;
    }

    public String getTipoOcorrencia() {
        return tipoOcorrencia;
    }

    public void setTipoOcorrencia(String tipoOcorrencia) {
        this.tipoOcorrencia = tipoOcorrencia;
    }

    public Integer getQtdVitimasVivas() {
        return qtdVitimasVivas;
    }

    public void setQtdVitimasVivas(Integer qtdVitimasVivas) {
        this.qtdVitimasVivas = qtdVitimasVivas;
    }

    public Integer getQtdVitimasFatais() {
        return qtdVitimasFatais;
    }

    public void setQtdVitimasFatais(Integer qtdVitimasFatais) {
        this.qtdVitimasFatais = qtdVitimasFatais;
    }

    public String getComandante() {
        return comandante;
    }

    public void setComandante(String comandante) {
        this.comandante = comandante;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public String getCecom() {
        return cecom;
    }

    public void setCecom(String cecom) {
        this.cecom = cecom;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
