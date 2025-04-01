package com.devfelipevitorino.pdv.Login;

import com.devfelipevitorino.pdv.DB.Usuario.UsuarioDAO;
import com.devfelipevitorino.pdv.Uteis.Uteis;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;

public class LoginController {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    private final Uteis uteis = new Uteis();

    @FXML
    private Button btn_entrar;
    @FXML
    private TextField username_field;
    @FXML
    private TextField password_field;

    @FXML
    private void entrarNoSistema() {
        String nome = username_field.getText();
        String senha = password_field.getText();

        if (usuarioDAO.autenticarUsuario(nome, senha)) {
            uteis.exibirAlerta("Sucesso", "Login bem-sucedido!", Alert.AlertType.INFORMATION);
        } else {
            uteis.exibirAlerta("Erro", "Credenciais inválidas!", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private Button btn_cancelar;

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