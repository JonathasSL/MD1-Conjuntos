package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;


public class Controller {
    public static int opc;

    public static String getConj() { return conj; }
    public static void setConj(String conj) { Controller.conj = conj; }

    private static String conj;
    @FXML private Label conjCadastrados;
    @FXML private TextField campo;
    @FXML private Button carregaCon;

    @FXML public void imprimir(ActionEvent e) {
        conjCadastrados.setText(conj);
        carregaCon.setVisible(false);
    }

    public void trocarTelaOpe(){
        ControllerCadConjunto c = new ControllerCadConjunto();
        c.trocarTela(1);
        carregaCon.setVisible(true);
    }
    public void trocarTelaCar(){
        ControllerCadConjunto c = new ControllerCadConjunto();
        c.trocarTela(2);
        carregaCon.setVisible(true);
    }

    @FXML public void goTocadastroOpe(ActionEvent e){ opc = 2; Main.changeScreen("cad"); }

    @FXML public void goToCadastroCar(ActionEvent e){ opc = 1; Main.changeScreen("cad"); }

    @FXML public void goToInicio(ActionEvent e){
          Main.changeScreen("menu");
          carregaCon.setVisible(true);
    }

}
