package aplicacao;

public class Aluno extends Usuario{

    public Aluno(String nome, String data, String endereco, String telefone, String email, String senha){
        super(nome, data, endereco, telefone, email, senha);
    }

    public Aluno(int id, String nome, String data, String endereco, String telefone, String email, String senha){
        super(id, nome, data, endereco, telefone, email, senha);
    }
    public Aluno(int id, String endereco, String telefone, String email){
        super(id, endereco, telefone, email);
    }

    public String apresentar(String nome) {
        setNome(nome);
        return getNome();
    }

}
