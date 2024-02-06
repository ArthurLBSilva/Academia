package visao;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BuscarAlunoController {

    @FXML
    private Button btnAlterarAluno;

    @FXML
    private Button btnAvaliacao;

    @FXML
    private Button btnExcluirAluno;

    @FXML
    private Button btnPagamento;

    @FXML
    private Button btnTreino;

    @FXML
    void alterarAluno(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnPagamento.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AlterarAluno.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void excluirAluno(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnPagamento.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ExcluirAluno.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void verificarAvaliacao(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnPagamento.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VerificarAvaliacao.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void verificarPagamento(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnPagamento.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VerificarPagamento.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void verificarTreino(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnPagamento.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VerificarTreino.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
