package visao;

import java.io.IOException;

import aplicacao.Aluno;
import aplicacao.Treino;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistencia.AlunoDAO;
import persistencia.TreinoDAO;

public class VerificarTreinoController {

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnVoltar;

    @FXML
    private Label campoDataFim;

    @FXML
    private Label campoDataInicio;

    @FXML
    private TextField campoEmail;

    @FXML
    private Label campoTreino;

    @FXML
    void buscarAluno(ActionEvent event) {
        String email = campoEmail.getText().trim();
        Aluno a1 = AlunoDAO.FazerLogin(email);
        if (a1 != null) {
            Treino a2 = TreinoDAO.BuscarTreino(a1.getId());
            if (a2 != null) {
                campoTreino.setText(a2.getDescricao());
                campoDataInicio.setText(a2.getData_inicio());
                campoDataFim.setText(a2.getData_fim());
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Treino não cadastrado!");
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
