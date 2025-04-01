package com.devfelipevitorino.pdv.Uteis;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class Uteis {

    public void exibirAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.initStyle(StageStyle.TRANSPARENT);
        alerta.showAndWait();
    }

}
