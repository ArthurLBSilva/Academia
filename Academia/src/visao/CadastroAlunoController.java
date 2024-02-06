package visao;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistencia.AlunoDAO;
import aplicacao.Aluno;

public class CadastroAlunoController {

    @FXML
    private Button btnCadastrarAluno;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoNome;

    @FXML
    private PasswordField campoRepetirsenha;

    @FXML
    private PasswordField campoSenha;

    @FXML
    void cadastrarAluno(ActionEvent event) throws IOException {
        Aluno a2 = new Aluno(null, null, null, null, null, null);
        String nome = campoNome.getText().trim();
        a2.apresentar(nome);
        String email = campoEmail.getText().trim();
        String senha = campoSenha.getText().trim();
        String senha2 = campoRepetirsenha.getText().trim();
        if (!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !senha2.isEmpty()) {
            if (senha.equals(senha2)) {
                Aluno a1 = AlunoDAO.FazerLogin(email);
                if (a1 == null) {
                    a1 = new Aluno(a2.apresentar(nome), null, null, null, email, senha2);
                    AlunoDAO.inserirAluno(a1);
                    Stage stage = (Stage) btnCadastrarAluno.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaLogin.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    System.out.println("Tu ja tem conta abestado");
                }
            } else {
                System.out.println("SIM PARCEIRO, E AS SENHAS SEM SER IGUAIS?");
            }
        } else {
            System.out.println("TA COM PREGUIÇA DE PREENCHER É?");
        }
    }

    @FXML
    void voltarTela(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TipoCad.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
