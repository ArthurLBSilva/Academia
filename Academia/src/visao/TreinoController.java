package visao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import aplicacao.Aluno;
import aplicacao.Pagamento;
import aplicacao.Treino;
import aplicacao.UsuarioLogado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistencia.AlunoDAO;
import persistencia.PagamentoDAO;
import persistencia.TreinoDAO;

public class TreinoController {

    @FXML
    private Button btnCadastrarTreino;

    @FXML
    private Button btnVoltar;

    @FXML
    private DatePicker campoDataFim;

    @FXML
    private DatePicker campoDataInicio;

    @FXML
    private TextField campoTreino;

    @FXML
    private TextField campoEmail;

    @FXML
    void cadastrarTreino(ActionEvent event) throws IOException {
        LocalDate localDate = campoDataInicio.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String datainicio = localDate.format(formatter);
        LocalDate localDate2 = campoDataFim.getValue();
        String datafim = localDate2.format(formatter);
        String treino = campoTreino.getText().trim();
        String email = campoEmail.getText().trim();
        if (!datainicio.isEmpty() && !datafim.isEmpty() && !treino.isEmpty() && !email.isEmpty()) {
            Aluno a1 = AlunoDAO.FazerLogin(email);
            if (a1 != null) {
                Pagamento p1 = PagamentoDAO.BuscarPagamento(a1.getId());
                if (p1 != null) {
                    Treino t1 = TreinoDAO.BuscarTreino(a1.getId());
                    if (t1 == null) {
                        Treino t2 = new Treino(a1.getId(), UsuarioLogado.getId(), datainicio, datafim, treino);
                        TreinoDAO.inserirTreino(t2);
                    } else {
                        Treino t2 = new Treino(a1.getId(), UsuarioLogado.getId(), datainicio, datafim, treino);
                        TreinoDAO.alterarTreino(t2);
                    }
                    Stage stage = (Stage) btnCadastrarTreino.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioInstrutor.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText(null);
                    alert.setContentText("O aluno deve realizar o pagamento antes de ter seu treino cadastrado!");
                    alert.showAndWait();
                }
            } else {
                System.out.println("Não existe esse aluno!");
            }
        } else {
            System.out.println("TA COM PREGUIÇA DE PREENCHER É?");
        }
    }

    @FXML
    void voltarTela(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioInstrutor.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
