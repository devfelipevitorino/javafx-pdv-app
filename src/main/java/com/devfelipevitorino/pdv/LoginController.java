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

}