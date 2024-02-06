package visao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import aplicacao.Aluno;
import aplicacao.UsuarioLogado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistencia.AlunoDAO;

public class ConcluirCadastroController {

    @FXML
    private Button btnConcluir;

    @FXML
    private DatePicker campoData;

    @FXML
    private TextField campoEndereco;

    @FXML
    private TextField campoTelefone;

    @FXML
    void concluirCadastro(ActionEvent event) {
        try {
            LocalDate localDate = campoData.getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String data = localDate.format(formatter);
            String telefone = campoTelefone.getText();
            String endereco = campoEndereco.getText();
            if (!data.isEmpty() && !telefone.isEmpty() && !endereco.isEmpty()) {
                String nome = UsuarioLogado.getNome();
                String email = UsuarioLogado.getEmail();
                String senha = UsuarioLogado.getSenha();
                int id = UsuarioLogado.getId();
                Aluno a1 = new Aluno(nome, data, endereco, telefone, email, senha);
                AlunoDAO.alterarAluno(id, a1);
                Stage stage = (Stage) btnConcluir.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioAluno.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } else {
                System.out.println("TA COM PREGUIÇA DE PREENCHER É?");
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}