package visao;

import java.io.IOException;

import aplicacao.InformacoesAvaliacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InicioAlunoController {

    @FXML
    private Button btnAvaliacao;

    @FXML
    private Button btnPagamento;

    @FXML
    private Button btnTreino;

    @FXML
    void verificarAvaliacao(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AvaliacaoAluno.fxml"));
        Parent root = loader.load();
        AvaliacaoAlunoController p1 = loader.getController();
        p1.exibirInformacoesAvaliacao();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void verificarPagamento(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PagamentoAluno.fxml"));
        Parent root = loader.load();
        PagamentoAlunoController p1 = loader.getController();
        p1.exibirInformacoesPagamento();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void verificarTreino(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TreinoAluno.fxml"));
        Parent root = loader.load();
        // Verifica se o controller implementa a interface antes de chamar o método
        if (loader.getController() instanceof InformacoesAvaliacao) {
            InformacoesAvaliacao informacoesAvaliacao = (InformacoesAvaliacao) loader.getController();
            informacoesAvaliacao.exibirInformacoesAvaliacao();
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

}
