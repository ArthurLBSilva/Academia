package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import aplicacao.Aluno;

public class AlunoDAO {
    private static Conexao con;

    public static void inserirAluno(Aluno a1) {
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement(
                    "INSERT INTO Aluno (Nome, Data_nascimento, Endereco, Telefone, Email, Senha) VALUES (?, ?, ?, ?, ?, ?)");
            instrucao.setString(1, a1.getNome());
            instrucao.setString(2, a1.getData());
            instrucao.setString(3, a1.getEndereco());
            instrucao.setString(4, a1.getTelefone());
            instrucao.setString(5, a1.getEmail());
            instrucao.setString(6, a1.getSenha());

            int linhasAfetadas = instrucao.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Inserção realizada com sucesso");
            } else {
                System.out.println("Nenhuma linha afetada durante a inserção");
            }
        } catch (SQLException e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally {
            con.desconectar();
        }
    }

    public static void setCon(Conexao con) {
        AlunoDAO.con = con;
    }

    public static void alterarAluno(int id, Aluno a1) {
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement(
                    "UPDATE Aluno SET Nome = ?, Data_nascimento = ?, Endereco = ?, Telefone = ?, Email = ?, Senha = ? WHERE ID_aluno = ?");
            instrucao.setString(1, a1.getNome());
            instrucao.setString(2, a1.getData());
            instrucao.setString(3, a1.getEndereco());
            instrucao.setString(4, a1.getTelefone());
            instrucao.setString(5, a1.getEmail());
            instrucao.setString(6, a1.getSenha());
            instrucao.setInt(7, id);

            int linhasAfetadas = instrucao.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Inserção realizada com sucesso");
            } else {
                System.out.println("Nenhuma linha afetada durante a inserção");
            }

        } catch (SQLException e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally {
            con.desconectar();
        }

    }
       public static void alterarAluno(Aluno a1) {
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement(
                    "UPDATE Aluno SET Endereco = ?, Telefone = ?, Email = ? WHERE ID_aluno = ?");
            instrucao.setString(1, a1.getEndereco());
            instrucao.setString(2, a1.getTelefone());
            instrucao.setString(3, a1.getEmail());
            instrucao.setInt(4, a1.getId());

            int linhasAfetadas = instrucao.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Inserção realizada com sucesso");
            } else {
                System.out.println("Nenhuma linha afetada durante a inserção");
            }

        } catch (SQLException e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally {
            con.desconectar();
        }
    }

    public static void ExcluirAluno(int id) {
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement("DELETE FROM Aluno WHERE ID_aluno = ?");
            instrucao.setInt(1, id);

            int linhasAfetadas = instrucao.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Inserção realizada com sucesso");
            } else {
                System.out.println("Nenhuma linha afetada durante a inserção");
            }
        } catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally {
            con.desconectar();
        }

    }

    public static ArrayList<Aluno> Relatorio() {
        ArrayList<Aluno> relatorio = new ArrayList<Aluno>();

        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement("SELECT * FROM Aluno");
            ResultSet rs = instrucao.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID_aluno");
                String nome = rs.getString("Nome");
                String data = rs.getString("Data_nascimento");
                String endereco = rs.getString("Endereco");
                String telefone = rs.getString("Telefone");
                String email = rs.getString("Email");
                String senha = rs.getString("Senha");

                Aluno a1 = new Aluno(id, nome, data, endereco, telefone, email, senha);
                relatorio.add(a1);
            }

        } catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally {
            con.desconectar();
        }

        return relatorio;
    }

    public static Aluno BuscaNome(String nome) {
        Aluno a1 = null;
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement("SELECT * FROM Aluno WHERE Nome = ?");
            instrucao.setString(1, nome);
            ResultSet rs = instrucao.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("ID_aluno");
                String nome2 = rs.getString("Nome");
                String data = rs.getString("Data_nascimento");
                String endereco = rs.getString("Endereco");
                String telefone = rs.getString("Telefone");
                String email = rs.getString("Email");
                String senha = rs.getString("Senha");

                a1 = new Aluno(id, nome2, data, endereco, telefone, email, senha);
            }
        } catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally {
            con.desconectar();
        }
        return a1;
    }

    public static Aluno BuscaNome(int id) {
        Aluno a1 = null;
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement("SELECT * FROM Aluno WHERE ID_aluno = ?");
            instrucao.setInt(1, id);
            ResultSet rs = instrucao.executeQuery();

            if (rs.next()) {
                int id2 = rs.getInt("ID_aluno");
                String nome = rs.getString("Nome");
                String data = rs.getString("Data_nascimento");
                String endereco = rs.getString("Endereco");
                String telefone = rs.getString("Telefone");
                String email = rs.getString("Email");
                String senha = rs.getString("Senha");

                a1 = new Aluno(id2, nome, data, endereco, telefone, email, senha);
            }
        } catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally {
            con.desconectar();
        }
        return a1;
    }

    /*
     * -----------------------------------------------------------------------------
     * -----------------------
     */
    /* COMEÇANDO A POR MÉTODOS DO JAVAFX */
    /*
     * -----------------------------------------------------------------------------
     * -----------------------
     */

    public static Aluno FazerLogin(String email) {
        Aluno a1 = null;
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement("SELECT * FROM Aluno WHERE Email = ?");
            instrucao.setString(1, email);
            ResultSet rs = instrucao.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("ID_aluno");
                String nome = rs.getString("Nome");
                String data = rs.getString("Data_nascimento");
                String endereco = rs.getString("Endereco");
                String telefone = rs.getString("Telefone");
                String email2 = rs.getString("Email");
                String senha = rs.getString("Senha");

                a1 = new Aluno(id, nome, data, endereco, telefone, email2, senha);
            }
        } catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally {
            con.desconectar();
        }
        return a1;
    }
}