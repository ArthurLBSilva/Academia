package visao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import aplicacao.Aluno;
import aplicacao.Avaliacao;
import aplicacao.Pagamento;
import aplicacao.UsuarioLogado;
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
import persistencia.AvaliacaoDAO;
import persistencia.PagamentoDAO;


public class AvaliacaoController {

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextField campoAltura;

    @FXML
    private DatePicker campoData;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoIMC;

    @FXML
    private TextField campoMassa;

    @FXML
    private TextField campoPercentual;

    @FXML
    private TextField campoPeso;

    @FXML
    private TextField campoObservacoes;

    @FXML
    void cadastrarAvaliacao(ActionEvent event) throws IOException {
        LocalDate localDate = campoData.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = localDate.format(formatter);
        String observacoes = campoObservacoes.getText().trim();
        String peso = campoPeso.getText().trim();
        String altura = campoAltura.getText().trim();
        String massa = campoMassa.getText().trim();
        String imc = campoIMC.getText().trim();
        String percentual = campoPercentual.getText().trim();
        String email = campoEmail.getText().trim();

        if (!data.isEmpty() && !observacoes.isEmpty() && !peso.isEmpty() && !email.isEmpty() && !altura.isEmpty()
                && !massa.isEmpty() && !imc.isEmpty() && !percentual.isEmpty()) {
            Aluno a1 = AlunoDAO.FazerLogin(email);
            if (a1 != null) {
                Pagamento p1 = PagamentoDAO.BuscarPagamento(a1.getId());
                if (p1 != null) {
                    Avaliacao a2 = AvaliacaoDAO.BuscarUma(a1.getId());
                    if (a2 == null) {
                        Avaliacao a3 = new Avaliacao(a1.getId(), UsuarioLogado.getId(), data, observacoes, peso, altura,
                                massa, imc, percentual);
                        AvaliacaoDAO.inserirAvaliacao(a3);
                    } else {
                        Avaliacao a3 = new Avaliacao(a1.getId(), UsuarioLogado.getId(), data, observacoes, peso, altura,
                                massa, imc, percentual);
                        AvaliacaoDAO.alterarAvaliacao(a1.getId(), a3);
                    }
                    Stage stage = (Stage) btnCadastrar.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioInstrutor.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    System.out.println("O aluno deve realizar o pagamento antes de ter seu treino cadastrado!");
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
        Stage stage = (Stage) btnCadastrar.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioInstrutor.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
