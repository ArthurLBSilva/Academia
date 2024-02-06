package visao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import persistencia.InstrutorDAO;
import aplicacao.Instrutor;

public class ConcluirCadInstrutorController {

    @FXML
    private Button btnConcluir;

    @FXML
    private DatePicker campoData;

    @FXML
    private TextField campoEndereco;

    @FXML
    private TextField campoTelefone;

    @FXML
    private TextField campoEspecialidade;
    
    @FXML
    void concluirCadastro(ActionEvent event) {
        try {
            LocalDate localDate = campoData.getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String data = localDate.format(formatter);
            String especialidade = campoEspecialidade.getText();
            Instrutor a2 = new Instrutor(null, null, null, null, null, null, null);
            a2.apresentar(especialidade);
            String telefone = campoTelefone.getText();
            String endereco = campoEndereco.getText();
            if (!data.isEmpty() && !telefone.isEmpty() && !endereco.isEmpty() && !especialidade.isEmpty()) {
                String nome = UsuarioLogado.getNome();
                String email = UsuarioLogado.getEmail();
                String senha = UsuarioLogado.getSenha();
                int id = UsuarioLogado.getId();
                Instrutor a1 = new Instrutor(nome, data, endereco, telefone, email, senha, a2.apresentar(especialidade));
                InstrutorDAO.alterarInstrutor(id, a1);
            } else {
                System.out.println("TA COM PREGUIÇA DE PREENCHER É?");
            }
        Stage stage = (Stage) btnConcluir.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioInstrutor.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

}
