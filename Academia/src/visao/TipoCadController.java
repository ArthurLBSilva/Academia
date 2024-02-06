package visao;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TipoCadController {

    @FXML
    private Button btnCadastrarAluno;

    @FXML
    private Button btnCadastrarInstrutor;

    @FXML
    private Button btnVoltar;

    @FXML
    void irCadastroAluno(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnCadastrarAluno.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CadastroAluno.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void irCadastroInstrutor(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnCadastrarInstrutor.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CadastroInstrutor.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void voltarTela(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
