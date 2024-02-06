package visao;

import java.io.IOException;

import aplicacao.Aluno;
import aplicacao.Pagamento;
import aplicacao.Treino;
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
import persistencia.PagamentoDAO;
import persistencia.TreinoDAO;

public class VerificarPagamentoController {

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnVoltar;

    @FXML
    private Label campoData;

    @FXML
    private TextField campoEmail;

    @FXML
    private Label campoMetodo;

    @FXML
    private Label campoStatus;

    @FXML
    private Label campoTipo;

    @FXML
    private Label campoValor;

    @FXML
    void buscarPagamento(ActionEvent event) {
        String email = campoEmail.getText().trim();
        Aluno a1 = AlunoDAO.FazerLogin(email);
        if (a1 != null) {
            Pagamento a2 = PagamentoDAO.BuscarPagamento(a1.getId());
            if (a2 != null) {
                campoData.setText(a2.getData_vencimento());
                campoMetodo.setText(a2.getMetodo_pagamento());
                campoStatus.setText(a2.getStatus());
                campoTipo.setText(a2.getTipo_pagamento());
                float valor = a2.getValor();
                String valorString = Float.toString(valor);
                campoValor.setText(valorString);
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
