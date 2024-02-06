package persistencia;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import aplicacao.Treino;

public class TreinoDAO {
    private static Conexao con;

    public static void inserirTreino(Treino a1) {
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement(
                    "INSERT INTO Treino (ID_aluno, ID_instrutor, Data_inicio, Data_fim, Descricao) VALUES (?, ?, ?, ?, ?)");
            instrucao.setInt(1, a1.getId_aluno());
            instrucao.setInt(2, a1.getId_instrutor());
            instrucao.setString(3, a1.getData_inicio());
            instrucao.setString(4, a1.getData_fim());
            instrucao.setString(5, a1.getDescricao());

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
        TreinoDAO.con = con;
    }
    
    public static void alterarTreino(Treino a1) {
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement(
                    "UPDATE Treino SET Data_inicio = ?, Data_fim = ?, Descricao = ? WHERE ID_treino = ?");
            instrucao.setString(1, a1.getData_inicio());
            instrucao.setString(2, a1.getData_fim());
            instrucao.setString(3, a1.getDescricao());
            instrucao.setInt(4, a1.getId_aluno());

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
    
    public static void ExcluirTodosTreinos(int ID_aluno) {
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon()
                    .prepareStatement("DELETE FROM Treino WHERE ID_aluno = ?");
            instrucao.setInt(1, ID_aluno);

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

    public static void ExcluirTreino(int ID_treino) {
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon()
                    .prepareStatement("DELETE FROM Treino WHERE ID_treino = ?");
            instrucao.setInt(1, ID_treino);

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

    public static ArrayList<Treino> Relatorio() {
        ArrayList<Treino> relatorio = new ArrayList<Treino>();

        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement("SELECT * FROM Treino");
            ResultSet rs = instrucao.executeQuery();

            while (rs.next()) {
                int id_treino = rs.getInt("ID_treino");
                int ID_aluno = rs.getInt("ID_aluno");
                int ID_instrutor = rs.getInt("ID_instrutor");
                String Data_inicio = rs.getString("Data_inicio");
                String Data_fim = rs.getString("Data_fim");
                String Descricao = rs.getString("Descricao");

               Treino t1 = new Treino(id_treino, ID_aluno, ID_instrutor, Data_inicio, Data_fim, Descricao);
                relatorio.add(t1);
            }

        } catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally {
            con.desconectar();
        }

        return relatorio;
    }

    public static Treino BuscarTreino(int id) {
        Treino t1 = null;
        try {
            con.conectar();
            System.out.println("Buscando treino para o ID do aluno: " + id);
            PreparedStatement instrucao = con.getCon().prepareStatement("SELECT * FROM Treino WHERE ID_aluno = ?");
            instrucao.setInt(1, id);
            ResultSet rs = instrucao.executeQuery();
    
            if (rs.next()) {
                int id_treino = rs.getInt("ID_treino");
                int ID_aluno = rs.getInt("ID_aluno");
                int ID_instrutor = rs.getInt("ID_instrutor");
                String Data_inicio = rs.getString("Data_inicio");
                String Data_fim = rs.getString("Data_fim");
                String Descricao = rs.getString("Descricao");
    
                t1 = new Treino(id_treino, ID_aluno, ID_instrutor, Data_inicio, Data_fim, Descricao);
            }
        } catch (Exception e) {
            System.out.println("Erro na busca de treino: " + e.getMessage());
        } finally {
            con.desconectar();
        }
        if (t1 != null) {
            System.out.println("Treino encontrado: " + t1);
        } else {
            System.out.println("Nenhum treino encontrado para o ID do aluno: " + id);
        }
        return t1;
    }
    

    public static ArrayList<Treino> Relatorio(int id) {
        ArrayList<Treino> relatorio = new ArrayList<Treino>();
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon()
                    .prepareStatement("SELECT * FROM Treino WHERE ID_aluno = ?");
            instrucao.setInt(1, id);
            ResultSet rs = instrucao.executeQuery();

            while (rs.next()) {
                int id_treino = rs.getInt("ID_treino");
                int ID_aluno = rs.getInt("ID_aluno");
                int ID_instrutor = rs.getInt("ID_instrutor");
                String Data_inicio = rs.getString("Data_inicio");
                String Data_fim = rs.getString("Data_fim");
                String Descricao = rs.getString("Descricao");

               Treino t1 = new Treino(id_treino, ID_aluno, ID_instrutor, Data_inicio, Data_fim, Descricao);
                relatorio.add(t1);
            }
        } catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally {
            con.desconectar();
        }
        return relatorio;
    }

    /* ---------------------------------------------------------------------------------------------------- */
                                    /* COMEÇANDO A POR MÉTODOS DO JAVAFX */
    /* ---------------------------------------------------------------------------------------------------- */
}
