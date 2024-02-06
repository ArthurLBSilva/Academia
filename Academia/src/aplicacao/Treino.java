package aplicacao;

public class Treino {
    private int id_treino;
    private int id_aluno;
    private int id_instrutor;
    private String data_inicio, data_fim, descricao;

    public Treino(int id_treino, int id_aluno, int id_instrutor, String data_inicio, String data_fim,
            String descricao) {
        this.id_treino = id_treino;
        this.id_aluno = id_aluno;
        this.id_instrutor = id_instrutor;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.descricao = descricao;
    }
    public Treino(int id_aluno, int id_instrutor, String data_inicio, String data_fim,
            String descricao) {
        this.id_aluno = id_aluno;
        this.id_instrutor = id_instrutor;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.descricao = descricao;
    }
    public Treino(String data_inicio, String data_fim,
            String descricao) {
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.descricao = descricao;
    }

    public int getId_treino() {
        return id_treino;
    }

    public void setId_treino(int id_treino) {
        this.id_treino = id_treino;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
}
