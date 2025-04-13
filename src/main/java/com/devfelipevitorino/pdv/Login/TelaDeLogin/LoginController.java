package com.devfelipevitorino.pdv.Login.TelaDeLogin;

import com.devfelipevitorino.pdv.Database.Usuario.UsuarioDAO;
import com.devfelipevitorino.pdv.Model.Usuario;
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
    Usuario usuario = new Usuario();

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

        usuario.setNome(nome);
        usuario.setSenha(senha);

        if (usuarioDAO.autenticarUsuario(usuario)) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devfelipevitorino/pdv/TelaDeVendas/tela-de-vendas.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) btn_entrar.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            label_user_senha_incorretos.setVisible(true);
            password_field.clear();
        }
    }

    @FXML
    private void fecharTelaDeLogin() {

        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.initStyle(StageStyle.UNDECORATED);
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

            Stage cadastroStage = new Stage();
            cadastroStage.initStyle(StageStyle.UNDECORATED);
            cadastroStage.setTitle("Cadastrar novo usuário");

            cadastroStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
            cadastroStage.initOwner(btn_entrar.getScene().getWindow());

            cadastroStage.setScene(new Scene(root));
            cadastroStage.centerOnScreen();
            cadastroStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void esqueceuSenha() {
        System.out.println("Clicando no label de esqueceu senha");
    }

}