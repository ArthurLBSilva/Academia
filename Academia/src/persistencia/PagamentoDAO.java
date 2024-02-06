package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import aplicacao.Pagamento;

public class PagamentoDAO {
    private static Conexao con;

    public static void inserirPagamento(Pagamento a1, int id) {
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement(
    "INSERT INTO Pagamento (ID_aluno, Data_vencimento, Tipo_pagamento, Valor, Status, Metodo_pagamento) VALUES (?, ?, ?, ?, ?, ?)");

            instrucao.setInt(1, id);
            instrucao.setString(2, a1.getData_vencimento());
            instrucao.setString(3, a1.getTipo_pagamento());
            instrucao.setFloat(4, a1.getValor());
            instrucao.setString(5, a1.getStatus());
            instrucao.setString(6, a1.getMetodo_pagamento());

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
        PagamentoDAO.con = con;
    }

    public static void alterarPagamento(int ID_aluno, Pagamento a1) {
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement(
                    "UPDATE Pagamento SET Data_vencimento = ?, Tipo_pagamento = ? Valor = ?, Status = ?, Metodo_pagamento = ? WHERE ID_aluno = ?");
            instrucao.setString(1, a1.getData_vencimento());
            instrucao.setString(2, a1.getTipo_pagamento());
            instrucao.setFloat(3, a1.getValor());
            instrucao.setString(4, a1.getStatus());
            instrucao.setString(5, a1.getMetodo_pagamento());
            instrucao.setInt(6, ID_aluno);

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

    public static void ExcluirPagamento(int ID_aluno) {
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon()
                    .prepareStatement("DELETE FROM Pagamento WHERE ID_aluno = ?");
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

    public static ArrayList<Pagamento> Relatorio() {
        ArrayList<Pagamento> relatorio = new ArrayList<Pagamento>();

        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon().prepareStatement("SELECT * FROM Pagamento");
            ResultSet rs = instrucao.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID_pagamento");
                int id2 = rs.getInt("ID_aluno");
                String data = rs.getString("Data_vencimento");
                String tipo_pagamento = rs.getString("Tipo_pagamento");
                float valor = rs.getFloat("Valor");
                String status = rs.getString("Status");
                String metodo_pagamento = rs.getString("Metodo_pagamento");

                Pagamento a1 = new Pagamento(id, id2, data, valor, status, tipo_pagamento, metodo_pagamento);
                relatorio.add(a1);
            }

        } catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally {
            con.desconectar();
        }

        return relatorio;
    }

    public static Pagamento BuscarPagamento(int id) {
        Pagamento a1 = null;
        try {
            con.conectar();
            PreparedStatement instrucao = con.getCon()
                    .prepareStatement("SELECT * FROM Pagamento WHERE ID_aluno = ?");
            instrucao.setInt(1, id);
            ResultSet rs = instrucao.executeQuery();

            if (rs.next()) {
                int id2 = rs.getInt("ID_pagamento");
                int id3 = rs.getInt("ID_aluno");
                String data = rs.getString("Data_vencimento");
                String tipo_pagamento = rs.getString("Tipo_pagamento");
                float valor = rs.getFloat("Valor");
                String status = rs.getString("Status");
                String metodo_pagamento = rs.getString("Metodo_pagamento");

                a1 = new Pagamento(id2, id3, data, valor, status, tipo_pagamento, metodo_pagamento);
            }
        } catch (Exception e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        } finally {
            con.desconectar();
        }
        return a1;
    }

    /* ---------------------------------------------------------------------------------------------------- */
                                    /* COMEÇANDO A POR MÉTODOS DO JAVAFX */
    /* ---------------------------------------------------------------------------------------------------- */


}
