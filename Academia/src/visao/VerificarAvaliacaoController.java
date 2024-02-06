package visao;

import java.io.IOException;

import aplicacao.Aluno;
import aplicacao.Avaliacao;
import aplicacao.Pagamento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistencia.AlunoDAO;
import persistencia.AvaliacaoDAO;
import persistencia.PagamentoDAO;

public class VerificarAvaliacaoController {

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnVoltar;

    @FXML
    private Label campoAltura;

    @FXML
    private Label campoData;

    @FXML
    private TextField campoEmail;

    @FXML
    private Label campoIMC;

    @FXML
    private Label campoMassa;

    @FXML
    private Label campoObservacoes;

    @FXML
    private Label campoPercentual;

    @FXML
    private Label campoPeso;

    @FXML
    void buscarAvaliacao(ActionEvent event) {
        String email = campoEmail.getText().trim();
        Aluno a1 = AlunoDAO.FazerLogin(email);
        if (a1 != null) {
            Avaliacao a2 = AvaliacaoDAO.BuscarUma(a1.getId());
            if (a2 != null) {
                campoAltura.setText(a2.getAltura());
                campoData.setText(a2.getData());
                campoIMC.setText(a2.getImc());
                campoMassa.setText(a2.getMassa());
                campoObservacoes.setText(a2.getObservacoes());
                campoPercentual.setText(a2.getPercentualGordura());
                campoPeso.setText(a2.getPeso());
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Avaliação não cadastrada!");
                alert.setHeaderText(null);
                alert.setContentText("Aluno não realizou o pagamento, ou não foi cadastrado!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aluno não cadastrado!");
            alert.setHeaderText(null);
            alert.setContentText("Verificar se digitou corretamente!");
            alert.showAndWait();
        }
    }

    @FXML
    void voltarTela(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BuscarAluno.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
