package aplicacao;

public class Avaliacao {
    private int id_avaliacao, id_aluno, id_instrutor;
    private String data, observacoes;
    private String peso, altura, massa, imc, percentualGordura;

    public Avaliacao(int id_avaliacao, int id_aluno, int id_instrutor, String data, String observacoes, String peso,
            String altura, String massa, String imc, String percentualGordura) {
        this.id_avaliacao = id_avaliacao;
        this.id_aluno = id_aluno;
        this.id_instrutor = id_instrutor;
        this.data = data;
        this.observacoes = observacoes;
        this.peso = peso;
        this.altura = altura;
        this.massa = massa;
        this.imc = imc;
        this.percentualGordura = percentualGordura;
    }

    public Avaliacao(int id_aluno, int id_instrutor, String data, String observacoes, String peso,
            String altura, String massa, String imc, String percentualGordura) {
        this.id_aluno = id_aluno;
        this.id_instrutor = id_instrutor;
        this.data = data;
        this.observacoes = observacoes;
        this.peso = peso;
        this.altura = altura;
        this.massa = massa;
        this.imc = imc;
        this.percentualGordura = percentualGordura;
    }

    public int getId_avaliacao() {
        return id_avaliacao;
    }

    public void setId_avaliacao(int id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public int getId_instrutor() {
        return id_instrutor;
    }

    public void setId_instrutor(int id_instrutor) {
        this.id_instrutor = id_instrutor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getMassa() {
        return massa;
    }

    public void setMassa(String massa) {
        this.massa = massa;
    }

    public String getImc() {
        return imc;
    }

    public void setImc(String imc) {
        this.imc = imc;
    }

    public String getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(String percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

}
