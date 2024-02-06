package visao;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistencia.AlunoDAO;
import persistencia.InstrutorDAO;
import java.io.IOException;
import aplicacao.Aluno;
import aplicacao.Instrutor;
import aplicacao.UsuarioLogado;
import javafx.scene.control.PasswordField;
import javafx.fxml.LoadException;

public class TelaLoginController {

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField loginEmail;

    @FXML
    private PasswordField loginSenha;

    @FXML
    void fazerCadastro(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnCadastrar.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TipoCad.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void fazerLogin(ActionEvent event) throws IOException {

        String email = loginEmail.getText();
        String senha = loginSenha.getText();
        Aluno a1 = AlunoDAO.FazerLogin(email);
        if (a1 != null) {

            if (email.equals(a1.getEmail()) && senha.equals(a1.getSenha())) {
                System.err.println("Deu bom");
                UsuarioLogado.setEmail(email);
                UsuarioLogado.setNome(a1.getNome());
                UsuarioLogado.setId(a1.getId());
                UsuarioLogado.setSenha(senha);
                if (a1.getData() == null || a1.getEndereco() == null || a1.getTelefone() == null) {
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ConcluirCadastro.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioAluno.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            } else {
                System.out.println("Deu certo não aluno dog!");
            }
        } else {
            Instrutor a2 = InstrutorDAO.FazerLogin(email);
            try {
                if (a2 != null && email.equals(a2.getEmail()) && senha.equals(a2.getSenha())) {
                    System.out.println("Deu bom instrutor");
                    UsuarioLogado.setEmail(email);
                    UsuarioLogado.setNome(a2.getNome());
                    UsuarioLogado.setId(a2.getId());
                    UsuarioLogado.setSenha(senha);
                    if (a2.getData() == null || a2.getEndereco() == null || a2.getTelefone() == null) {

                        Stage stage = (Stage) btnLogin.getScene().getWindow();
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConcluirCadInstrutor.fxml"));
                            Parent root = loader.load();
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioInstrutor.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    }
                } else {
                    System.out.println("Deu certo não instrutor dog!");
                }
            } catch (Exception e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
    }

}