package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import aplicacao.Instrutor;

public class InstrutorDAO {
     private static Conexao con;
    
    public static void inserirInstrutor(Instrutor i1){
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement("INSERT INTO Instrutor (Nome, Data_nascimento, Endereco, Telefone, Email, Senha, Especialidade) VALUES (?, ?, ?, ?, ?, ?, ?)");
            instrucao.setString(1, i1.getNome());
            instrucao.setString(2, i1.getData());
            instrucao.setString(3, i1.getEndereco());
            instrucao.setString(4, i1.getTelefone());
            instrucao.setString(5, i1.getEmail());
            instrucao.setString(6, i1.getSenha());
            instrucao.setString(7, i1.getEspecialidade());

            int linhasAfetadas = instrucao.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Inserção realizada com sucesso");
            } else{
                System.out.println("Nenhuma linha afetada durante a inserção");
            }
        } catch (SQLException e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally{
            con.desconectar();
        }
    }

    public static void setCon(Conexao con) {
        InstrutorDAO.con = con;
    }

    public static void alterarInstrutor(int id, Instrutor i1){
        try {
            con.conectar();
        PreparedStatement instrucao = con.getCon().prepareStatement("UPDATE Instrutor SET Nome = ?, Data_nascimento = ?, Endereco = ?, Telefone = ?, Email = ?, Senha = ?, Especialidade = ? WHERE ID_instrutor = ?");
            instrucao.setString(1, i1.getNome());
            instrucao.setString(2, i1.getData());
            instrucao.setString(3, i1.getEndereco());
            instrucao.setString(4, i1.getTelefone());
            instrucao.setString(5, i1.getEmail());
            instrucao.setString(6, i1.getSenha());
            instrucao.setString(7, i1.getEspecialidade());
            instrucao.setInt(8, id);

            int linhasAfetadas = instrucao.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Inserção realizada com sucesso");
            } else{
                System.out.println("Nenhuma linha afetada durante a inserção");
            }

        } catch (SQLException e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        }finally{
            con.desconectar();
        }
    }

    public static void ExcluirInstrutor (int id){
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement("DELETE FROM Instrutor WHERE ID_instrutor = ?");
            instrucao.setInt (1, id);
            
            int linhasAfetadas = instrucao.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Inserção realizada com sucesso");
            } else{
                System.out.println("Nenhuma linha afetada durante a inserção");
            }
        } catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        }finally{
            con.desconectar();
        }
        
    }

    public static ArrayList<Instrutor> Relatorio(){
        ArrayList<Instrutor> relatorio = new ArrayList<Instrutor>();

        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement("SELECT * FROM Instrutor");
            ResultSet rs = instrucao.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID_instrutor");
                String nome = rs.getString("Nome");
                String data = rs.getString("Data_nascimento");
                String endereco = rs.getString("Endereco");
                String telefone = rs.getString("Telefone");
                String email = rs.getString("Email");
                String senha = rs.getString("Senha");
                String especialidade = rs.getString("Especialidade");

                Instrutor i1 = new Instrutor(id, nome, data, endereco, telefone, email, senha, especialidade);
                relatorio.add(i1);
            }
        }catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        }finally{
            con.desconectar();
        }

        return relatorio;
    } 

    public static Instrutor BuscaNome(String nome){
        Instrutor i1 = null;
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement("SELECT * FROM Instrutor WHERE Nome = ?"); 
            instrucao.setString(1, nome);
            ResultSet rs = instrucao.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("ID_instrutor");
                String nome2 = rs.getString("Nome");
                String data = rs.getString("Data_nascimento");
                String endereco = rs.getString("Endereco");
                String telefone = rs.getString("Telefone");
                String email = rs.getString("Email");
                String senha = rs.getString("Senha");
                String especialidade = rs.getString("Especialidade");

                i1 = new Instrutor(id, nome2, data, endereco, telefone, email, senha, especialidade);
            }
        } catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally{
            con.desconectar();
        }
        return i1;
    }

    public static Instrutor BuscaNome(int id){
        Instrutor i1 = null;
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement("SELECT * FROM Instrutor WHERE ID_aluno = ?"); 
            instrucao.setInt(1, id);
            ResultSet rs = instrucao.executeQuery();

            if (rs.next()) {
                int id2 = rs.getInt("ID_instrutor");
                String nome = rs.getString("Nome");
                String data = rs.getString("Data_nascimento");
                String endereco = rs.getString("Endereco");
                String telefone = rs.getString("Telefone");
                String email = rs.getString("Email");
                String senha = rs.getString("Senha");
                String especialidade = rs.getString("Especialidade");

                i1 = new Instrutor(id2, nome, data, endereco, telefone, email, senha, especialidade);
            }
        } catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally{
            con.desconectar();
        }
        return i1;
    }

    /* ---------------------------------------------------------------------------------------------------- */
                                    /* COMEÇANDO A POR MÉTODOS DO JAVAFX */
    /* ---------------------------------------------------------------------------------------------------- */
    
    public static Instrutor FazerLogin(String email){
        Instrutor a1 = null;
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement("SELECT * FROM Instrutor WHERE Email = ?"); 
            instrucao.setString(1, email);
            ResultSet rs = instrucao.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("ID_instrutor");
                String nome = rs.getString("Nome");
                String data = rs.getString("Data_nascimento");
                String endereco = rs.getString("Endereco");
                String telefone = rs.getString("Telefone");
                String email2 = rs.getString("Email");
                String senha = rs.getString("Senha");
                String especialidade = rs.getString("Especialidade");

                a1 = new Instrutor(id, nome, data, endereco, telefone, email2, senha, especialidade);
            }
        } catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally{
            con.desconectar();
        }
        return a1;
    }
}
