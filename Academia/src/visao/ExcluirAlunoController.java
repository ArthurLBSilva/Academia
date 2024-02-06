package visao;

import java.io.IOException;

import aplicacao.Aluno;
import aplicacao.Avaliacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistencia.AlunoDAO;
import persistencia.AvaliacaoDAO;

public class ExcluirAlunoController {

    @FXML
    private Button btnConcluir;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextField campoEmail;

    @FXML
    void concluirCadastro(ActionEvent event) throws IOException {
        String email = campoEmail.getText().trim();
        Aluno a1 = AlunoDAO.FazerLogin(email);
        if (a1 != null) {
            AlunoDAO.ExcluirAluno(a1.getId());
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aluno não cadastrado!");
            alert.setHeaderText(null);
            alert.setContentText("Verificar se digitou corretamente!");
            alert.showAndWait();
        }
        Stage stage = (Stage) btnConcluir.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BuscarAluno.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void voltarTela(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnConcluir.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BuscarAluno.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
