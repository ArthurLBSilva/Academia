package aplicacao;

public class Instrutor extends Usuario {
    private String especialidade;

    public Instrutor(int id, String nome, String data, String endereco, String telefone, String email, String senha,
            String especialidade) {
        super(id, nome, data, endereco, telefone, email, senha);
        this.especialidade = especialidade;
    }

    public Instrutor(String nome, String data, String endereco, String telefone, String email, String senha,
            String especialidade) {
        super(nome, data, endereco, telefone, email, senha);
        this.especialidade = especialidade;
    }

    public Instrutor(String nome, String data, String endereco, String telefone, String email, String senha) {
        super(nome, data, endereco, telefone, email, senha);
    }

    public String apresentar(String especialidade) {
        setEspecialidade(especialidade);
        return getEspecialidade();
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

   
}
