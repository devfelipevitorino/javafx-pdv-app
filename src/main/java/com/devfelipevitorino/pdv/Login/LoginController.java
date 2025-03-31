package com.devfelipevitorino.pdv;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button btn_entrar;

    @FXML
    private Button btn_cancelar;

    @FXML
    private void fecharTelaDeLogin() {
        Stage stage = (Stage) btn_cancelar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void entrarNoSistema() {
        System.out.println("Clicando no botão de entrar");
    }

    @FXML
    private void cadastrar() {
        System.out.println("Clicando no label de cadastrar");
    }

    @FXML
    private void esqueceuSenha() {
        System.out.println("Clicando no label de esqueceu senha");
    }

}