package com.devfelipevitorino.pdv.Login;

import com.devfelipevitorino.pdv.DB.Usuario.UsuarioDAO;
import com.devfelipevitorino.pdv.Uteis.Uteis;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;

public class LoginController {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    private final Uteis uteis = new Uteis();

    @FXML
    private TextField username_field;
    @FXML
    private TextField password_field;
    @FXML
    private Label label_user_senha_incorretos;
    @FXML
    private Button btn_cancelar;
    @FXML
    private Button btn_entrar;

    @FXML
    private void entrarNoSistema() {
        String nome = username_field.getText();
        String senha = password_field.getText();
        label_user_senha_incorretos.setVisible(false);

        if (usuarioDAO.autenticarUsuario(nome, senha)) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devfelipevitorino/pdv/tela-de-vendas.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UTILITY);
                stage.setScene(new Scene(root));
                stage.centerOnScreen();
                stage.show();

                Stage loginStage = (Stage) btn_entrar.getScene().getWindow();
                loginStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            label_user_senha_incorretos.setVisible(true);
        }
    }

    @FXML
    private void fecharTelaDeLogin() {

        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.initStyle(StageStyle.TRANSPARENT);
        alerta.setTitle("Sair");
        alerta.setHeaderText("Deseja sair do sistema?");

        ButtonType buttonSim = new ButtonType("Sim");
        ButtonType buttonNao = new ButtonType("Não");

        alerta.getButtonTypes().setAll(buttonSim, buttonNao);

        Optional<ButtonType> resultado = alerta.showAndWait();

        if (resultado.isPresent() && resultado.get() == buttonSim) {
            Stage stage = (Stage) btn_cancelar.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void cadastrar() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devfelipevitorino/pdv/cadastrar-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void esqueceuSenha() {
        System.out.println("Clicando no label de esqueceu senha");
    }

}