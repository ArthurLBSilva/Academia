package aplicacao;

public class UsuarioLogado {
    private static String email, nome, senha;

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String senha) {
        UsuarioLogado.senha = senha;
    }

    private static int id;

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UsuarioLogado.email = email;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        UsuarioLogado.nome = nome;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        UsuarioLogado.id = id;
    }
}
