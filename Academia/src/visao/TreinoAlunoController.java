package visao;

import java.io.IOException;

import aplicacao.Aluno;
import aplicacao.InformacoesAvaliacao;
import aplicacao.Pagamento;
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
import javafx.stage.Stage;
import persistencia.AlunoDAO;
import persistencia.PagamentoDAO;
import persistencia.TreinoDAO;

public class TreinoAlunoController implements InformacoesAvaliacao {

    @FXML
    private Button btnVoltar;

    @FXML
    private Label campoDataFim;

    @FXML
    private Label campoDataInicio;

    @FXML
    private Label campoTreino;

    @FXML
    void voltarTela(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioAluno.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void exibirInformacoesAvaliacao() {
    Treino t1 = TreinoDAO.BuscarTreino(UsuarioLogado.getId());
    if (t1 != null) {
        campoTreino.setText(t1.getDescricao());
        campoDataInicio.setText(t1.getData_inicio());
        campoDataFim.setText(t1.getData_fim());
    } else {
        System.out.println("Treino não encontrado para o aluno com ID: " + UsuarioLogado.getId());
    }
}



}
    
