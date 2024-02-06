package visao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import persistencia.AlunoDAO;
import persistencia.AvaliacaoDAO;
import persistencia.Conexao;
import persistencia.InstrutorDAO;
import persistencia.PagamentoDAO;
import persistencia.TreinoDAO;

public class App extends Application {

    public static void main(String[] args) {
        Conexao c1 = new Conexao();
        AlunoDAO.setCon(c1);
        AvaliacaoDAO.setCon(c1);
        InstrutorDAO.setCon(c1);
        PagamentoDAO.setCon(c1);
        TreinoDAO.setCon(c1);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("SmartNotFit");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}