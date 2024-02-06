package visao;

import java.io.IOException;

import aplicacao.Avaliacao;
import aplicacao.UsuarioLogado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import persistencia.AvaliacaoDAO;

public class AvaliacaoAlunoController {

    @FXML
    private Button btnVoltar;

    @FXML
    private Label campoAltura;

    @FXML
    private Label campoData;

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
    void voltarTela(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioAluno.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

   public void exibirInformacoesAvaliacao() {
        Avaliacao a1 = AvaliacaoDAO.BuscarUma(UsuarioLogado.getId());
        if (a1 != null) {
            campoAltura.setText(a1.getAltura());
            campoData.setText(a1.getData());
            campoIMC.setText(a1.getImc());
            campoMassa.setText(a1.getMassa());
            campoObservacoes.setText(a1.getObservacoes());
            campoPercentual.setText(a1.getPercentualGordura());
            campoPeso.setText(a1.getPeso());
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Treino não cadastrado!");
            alert.setHeaderText(null);
            alert.setContentText("Fale com seu instrutor ou realize seu pagamento");
            alert.showAndWait();
        }
    }

}
