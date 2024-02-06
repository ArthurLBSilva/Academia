package visao;

import java.io.IOException;

import aplicacao.Pagamento;
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
import persistencia.PagamentoDAO;


public class PagamentoAlunoController {

    @FXML
    private Button btnVoltar;

    @FXML
    private Label campoData;

    @FXML
    private Label campoMetodo;

    @FXML
    private Label campoStatus;

    @FXML
    private Label campoTipo;

    @FXML
    private Label campoValor;

    @FXML
    void voltarTela(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioAluno.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exibirInformacoesPagamento() {
        Pagamento a1 = PagamentoDAO.BuscarPagamento(UsuarioLogado.getId());
        if (a1 != null) {
            campoData.setText(a1.getData_vencimento());
            campoMetodo.setText(a1.getMetodo_pagamento());
            campoStatus.setText(a1.getStatus());
            campoTipo.setText(a1.getTipo_pagamento());
            float valor = a1.getValor();
            String valorString = Float.toString(valor);
            campoValor.setText(valorString);
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Pagamento não cadastrado!");
            alert.setHeaderText(null);
            alert.setContentText("Fale com seu instrutor ou realize seu pagamento");
            alert.showAndWait();
        }
    }
}
