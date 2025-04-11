package com.devfelipevitorino.pdv.Login.TelaCadastroUsuario;

import com.devfelipevitorino.pdv.Database.Usuario.UsuarioDAO;
import com.devfelipevitorino.pdv.Uteis.Uteis;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;

public class CadastroUsuarioController {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    private final Uteis uteis = new Uteis();

    @FXML
    private Button btn_cancelar_cadastrar;

    @FXML
    private TextField username_field_cadastrar;
    @FXML
    private TextField password_field_cadastrar;

    @FXML
    private void cadastrarUsuario() {
        String usuario = username_field_cadastrar.getText();
        String senha = password_field_cadastrar.getText();

        if (usuarioDAO.salvarUsuario(usuario, senha)) {
            uteis.exibirAlerta("Sucesso", "Usuario Cadastrado!", Alert.AlertType.INFORMATION);
        } else {
            uteis.exibirAlerta("Erro", "Credenciais inválidas!", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void fecharTelaCadastro() {

        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.initStyle(StageStyle.UNDECORATED);
        alerta.setHeaderText("Deseja sair?");

        ButtonType buttonSim = new ButtonType("Sim");
        ButtonType buttonNao = new ButtonType("Não");

        alerta.getButtonTypes().setAll(buttonSim, buttonNao);

        Optional<ButtonType> resultado = alerta.showAndWait();

        if (resultado.isPresent() && resultado.get() == buttonSim) {
            Stage stage = (Stage) btn_cancelar_cadastrar.getScene().getWindow();
            stage.close();
        }
    }

}
