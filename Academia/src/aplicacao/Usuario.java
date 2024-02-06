package aplicacao;

public abstract class Usuario {
    private int id;
    private String nome, data, endereco, telefone, email, senha;

    public Usuario(int id, String nome, String data, String endereco, String telefone, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String data, String endereco, String telefone, String email, String senha) {
        this.nome = nome;
        this.data = data;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(int id, String endereco, String telefone, String email) {
        this.id = id;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    //Poliformismo:
    public abstract String apresentar(String parametro);

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
