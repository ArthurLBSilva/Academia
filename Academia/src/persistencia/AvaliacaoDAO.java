package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import aplicacao.Avaliacao;


public class AvaliacaoDAO {
    private static Conexao con;

    public static void inserirAvaliacao(Avaliacao a1) {
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement(
                    "INSERT INTO AvaliacoesFisicas (ID_aluno, ID_instrutor, Data_avaliacao, Peso, Altura, Massa_corporal, Indice_massa_corporal, Percentual_gordura, Observacoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            instrucao.setInt(1, a1.getId_aluno());
            instrucao.setInt(2, a1.getId_instrutor());
            instrucao.setString(3, a1.getData());
            instrucao.setString(4, a1.getPeso());
            instrucao.setString(5, a1.getAltura());
            instrucao.setString(6, a1.getMassa());
            instrucao.setString(7, a1.getImc());
            instrucao.setString(8, a1.getPercentualGordura());
            instrucao.setString(9, a1.getObservacoes());

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
        AvaliacaoDAO.con = con;
    }



    public static void alterarAvaliacao(int ID_aluno, Avaliacao a1) {
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement(
                    "UPDATE AvaliacoesFisicas SET Data_avaliacao = ?, Peso = ?, Altura = ? Massa_corporal = ?, Indice_massa_corporal = ?, Percentual_gordura = ?, Observacoes = ? WHERE ID_aluno = ?");
            instrucao.setString(1, a1.getData());
            instrucao.setString(2, a1.getPeso());
            instrucao.setString(3, a1.getAltura());
            instrucao.setString(4, a1.getMassa());
            instrucao.setString(5, a1.getImc());
            instrucao.setString(6, a1.getPercentualGordura());
            instrucao.setString(7, a1.getObservacoes());
            instrucao.setInt(8, ID_aluno);

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

    public static void ExcluirAvaliacao(int ID_aluno) {
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon()
                    .prepareStatement("DELETE FROM AvaliacoesFisicas WHERE ID_aluno = ?");
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

    public static ArrayList<Avaliacao> Relatorio() {
        ArrayList<Avaliacao> relatorio = new ArrayList<Avaliacao>();

        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement("SELECT * FROM AvaliacoesFisicas");
            ResultSet rs = instrucao.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID_avaliacao");
                int id2 = rs.getInt("ID_aluno");
                int id3 = rs.getInt("ID_instrutor");
                String data = rs.getString("Data_avaliacao");
                String peso = rs.getString("Peso");
                String altura = rs.getString("Altura");
                String massa = rs.getString("Massa_corporal");
                String imc = rs.getString("Indice_massa_corporal");
                String gordura = rs.getString("Percentual_gordura");
                String observacoes = rs.getString("Observacoes");

                Avaliacao a1 = new Avaliacao(id, id2, id3, data, observacoes, peso, altura, massa, imc, gordura);
                relatorio.add(a1);
            }

        } catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally {
            con.desconectar();
        }

        return relatorio;
    }

    public static Avaliacao BuscarUma(int id) {
        Avaliacao a1 = null;
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon()
                    .prepareStatement("SELECT * FROM AvaliacoesFisicas WHERE ID_aluno = ?");
            instrucao.setInt(1, id);
            ResultSet rs = instrucao.executeQuery();

            if (rs.next()) {
                int id2 = rs.getInt("ID_avaliacao");
                int id3 = rs.getInt("ID_aluno");
                int id4 = rs.getInt("ID_instrutor");
                String data = rs.getString("Data_avaliacao");
                String peso = rs.getString("Peso");
                String altura = rs.getString("Altura");
                String massa = rs.getString("Massa_corporal");
                String imc = rs.getString("Indice_massa_corporal");
                String gordura = rs.getString("Percentual_gordura");
                String observacoes = rs.getString("Observacoes");

                a1 = new Avaliacao(id2, id3, id4, data, observacoes, peso, altura, massa, imc, gordura);
            }
        } catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally {
            con.desconectar();
        }
        return a1;
    }

    public static ArrayList<Avaliacao> Relatorio(int id) {
        ArrayList<Avaliacao> relatorio = new ArrayList<Avaliacao>();
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon()
                    .prepareStatement("SELECT * FROM AvaliacoesFisicas WHERE ID_instrutor = ?");
            instrucao.setInt(1, id);
            ResultSet rs = instrucao.executeQuery();

            while (rs.next()) {
                int id2 = rs.getInt("ID_avaliacao");
                int id3 = rs.getInt("ID_aluno");
                int id4 = rs.getInt("ID_instrutor");
                String data = rs.getString("Data_avaliacao");
                String peso = rs.getString("Peso");
                String altura = rs.getString("Altura");
                String massa = rs.getString("Massa_corporal");
                String imc = rs.getString("Indice_massa_corporal");
                String gordura = rs.getString("Percentual_gordura");
                String observacoes = rs.getString("Observacoes");

                Avaliacao a1 = new Avaliacao(id2, id3, id4, data, observacoes, peso, altura, massa, imc, gordura);
                relatorio.add(a1);
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
