package visao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import aplicacao.Aluno;
import aplicacao.Pagamento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistencia.AlunoDAO;
import persistencia.PagamentoDAO;

public class PagamentoController {

    @FXML
    private Button btnConcluir;

    @FXML
    private Button btnVoltar;

    @FXML
    private DatePicker campoData;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoMetodo;

    @FXML
    private TextField campoStatus;

    @FXML
    private TextField campoTipo;

    @FXML
    void cadastrarPagamento(ActionEvent event) throws IOException {
        LocalDate localDate = campoData.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = localDate.format(formatter);
        String email = campoEmail.getText().trim();
        String metodo = campoMetodo.getText().trim();
        String status = campoStatus.getText().trim();
        String tipo = campoTipo.getText().trim();
        if (!data.isEmpty() && !email.isEmpty() && !metodo.isEmpty() && !status.isEmpty() && !tipo.isEmpty()) {
            Aluno a1 = AlunoDAO.FazerLogin(email);
            if (a1 != null) {
                Pagamento p1 = new Pagamento(a1.getId(), data, 80f, status, tipo, metodo);
                PagamentoDAO.inserirPagamento(p1, a1.getId());
                Stage stage = (Stage) btnConcluir.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioInstrutor.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                System.out.println("Não existe esse aluno!");
            }
        } else {
            System.out.println("TA COM PREGUIÇA DE PREENCHER É?");
        }
    }

    @FXML
    void voltarTela(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnConcluir.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioInstrutor.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
