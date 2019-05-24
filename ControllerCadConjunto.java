package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Main;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Optional;

public class ControllerCadConjunto extends Controller {
    public static ArrayList listConjuntos = new ArrayList();
    public static String conjuntos;
    @FXML
    private Label  conjCadastrados;
    @FXML TextField campo;

    @FXML public void addElemento(ActionEvent e){
        String s = campo.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar cadastro");
        alert.setContentText("Conjunto:" + s);
        alert.setHeaderText("Você confirma o cadastro?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Alert idShow = new Alert(Alert.AlertType.INFORMATION);
            idShow.setTitle("Cadastro confirmado");
            idShow.setHeaderText("O conjunto foi cadastrado com sucesso");
            idShow.showAndWait();
            campo.setText("");
            listConjuntos.add("{" +s + "}");

        } else {
            campo.setText("");
        }
    }

    public void trocarTela(int op){
        opc = op;
        finalizeCadastro(new ActionEvent());
    }

    public void finalizeCadastro(ActionEvent actionEvent) {
        conjuntos = "";
        for (int i = 0; i < listConjuntos.size(); i++){
            conjuntos += "\n" + listConjuntos.get(i);
        }
        Controller c = new Controller();
        c.setConj(conjuntos);
        if( opc == 1)
            Main.changeScreen("cartesiano");
        if (opc == 2)
            Main.changeScreen("ope");
    }
}
