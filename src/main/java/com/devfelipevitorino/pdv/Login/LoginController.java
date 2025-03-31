package com.devfelipevitorino.pdv.Login;

import com.devfelipevitorino.pdv.DB.Usuario.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;

public class LoginController {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

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
            exibirAlerta("Sucesso", "Login bem-sucedido!", Alert.AlertType.INFORMATION);
        } else {
            exibirAlerta("Erro", "Credenciais inválidas!", Alert.AlertType.ERROR);
        }
    }

    private void exibirAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.initStyle(StageStyle.TRANSPARENT);
        alerta.showAndWait();
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
        System.out.println("Clicando no label de cadastrar");
    }

    @FXML
    private void esqueceuSenha() {
        System.out.println("Clicando no label de esqueceu senha");
    }

}