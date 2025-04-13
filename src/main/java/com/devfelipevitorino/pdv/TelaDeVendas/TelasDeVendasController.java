package com.devfelipevitorino.pdv.TelaDeVendas;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;

public class TelasDeVendasController {

    public Label label_f2;
    @FXML
    private Button btn_cadastrar_mercadoria;

    @FXML
    private Button btn_sair;

    @FXML
    private void fecharTelaVendas() throws IOException {

        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.initStyle(StageStyle.TRANSPARENT);
        alerta.setTitle("Sair");
        alerta.setHeaderText("Deseja sair?");

        ButtonType buttonSim = new ButtonType("Sim");
        ButtonType buttonNao = new ButtonType("Não");

        alerta.getButtonTypes().setAll(buttonSim, buttonNao);

        Optional<ButtonType> resultado = alerta.showAndWait();

        if (resultado.isPresent() && resultado.get() == buttonSim) {
            Stage stage = (Stage) btn_sair.getScene().getWindow();
            stage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devfelipevitorino/pdv/login-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage login = new Stage();
            login.initStyle(StageStyle.UTILITY);
            login.setScene(new Scene(root));
            login.centerOnScreen();
            login.show();
        }
    }

    @FXML
    private void cadastrarMercadoria() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devfelipevitorino/pdv/TelaDeVendas/cadastro_mercadoria.fxml"));
        Parent root = fxmlLoader.load();

        Stage cadastroStage = new Stage();
        cadastroStage.initStyle(StageStyle.UTILITY);
        cadastroStage.setTitle("Cadastro de Mercadoria");
        cadastroStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
        cadastroStage.initOwner(btn_cadastrar_mercadoria.getScene().getWindow());
        cadastroStage.setScene(new Scene(root));
        cadastroStage.centerOnScreen();
        cadastroStage.showAndWait();
    }

    @FXML
    private void abrirTelaDeBusca() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devfelipevitorino/pdv/TelaDeVendas/buscar_mercadoria.fxml"));
        Parent root = fxmlLoader.load();

        Stage buscaStage = new Stage();
        buscaStage.initStyle(StageStyle.UTILITY);
        buscaStage.setTitle("Busca de Mercadoria");
        buscaStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
        buscaStage.initOwner(btn_cadastrar_mercadoria.getScene().getWindow());
        buscaStage.setScene(new Scene(root));
        buscaStage.centerOnScreen();
        buscaStage.showAndWait();
    }

}
