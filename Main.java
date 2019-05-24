package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage stage;
    private static Scene cadastro ,tela, ope, cartesiano;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Main.stage = stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/tela.fxml"));
        tela = new Scene(root, 600, 400);

        Parent opeCar = FXMLLoader.load(getClass().getResource("view/ope.fxml"));
        ope = new Scene(opeCar, 600, 400);

        Parent cart = FXMLLoader.load(getClass().getResource("view/cartesiano.fxml"));
        cartesiano = new Scene(cart, 600, 400);

        Parent cadastroC = FXMLLoader.load(getClass().getResource("view/cadastroConjunto.fxml"));
        cadastro = new Scene(cadastroC, 600, 400);

        stage.setTitle("Trabalho MD - Conjuntos");
        stage.setScene(tela);
        stage.getIcons().add(new Image("file:src/conjunto.png"));
        stage.show();
        setStage(stage);
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void changeScreen(String cena) {
        switch (cena) {
            case "ope":
                stage.setScene(ope);
                break;
            case "cartesiano":
                stage.setScene(cartesiano);
                break;
            case "menu":
                stage.setScene(tela);
                break;
            case "cad":
                stage.setScene(cadastro);
                break;
        }
    }

}