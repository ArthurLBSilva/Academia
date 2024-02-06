package visao;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InicioInstrutorController {

    @FXML
    private Button btnAluno;

    @FXML
    private Button btnAvaliacao;

    @FXML
    private Button btnPagamento;

    @FXML
    private Button btnTreino;

    @FXML
    void adicionarAvaliacao(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnPagamento.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Avaliacao.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void adicionarPagamento(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnPagamento.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pagamento.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void adicionarTreino(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnPagamento.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Treino.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buscarAluno(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnPagamento.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BuscarAluno.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
