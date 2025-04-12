package com.devfelipevitorino.pdv.TelaDeVendas;

import com.devfelipevitorino.pdv.Database.Produtos.ProdutosDAO;
import com.devfelipevitorino.pdv.Model.Produto;
import com.devfelipevitorino.pdv.Uteis.Uteis;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;

public class CadastroMercadoriaController {

    private final ProdutosDAO dao = new ProdutosDAO();
    private final Uteis uteis = new Uteis();

    @FXML
    private TextField text_field_nome;
    @FXML
    private TextField text_field_descricao;
    @FXML
    private TextField text_field_preco;
    @FXML
    private TextField text_field_quantidade;
    @FXML
    private ComboBox<String> comboUnidade;
    @FXML
    private TextField text_field_referencia;
    @FXML
    private Button btn_cancelar_cadastro_mercadoria;

    @FXML
    private void cadastrarMercadoria(){
        String nome = text_field_nome.getText();
        String descricao = text_field_descricao.getText();
        Double preco = Double.valueOf(text_field_preco.getText());
        Integer quantidade = Integer.valueOf(text_field_quantidade.getText());
        String unidade = comboUnidade.getValue();
        String referencia = text_field_referencia.getText();

        Produto produto = new Produto(nome, descricao, preco, quantidade, referencia, unidade);

        if (dao.salvarProduto(produto)) {
            uteis.exibirAlerta("Sucesso", "Mercadoria Cadastrada!", Alert.AlertType.INFORMATION);
            text_field_nome.clear();
            text_field_descricao.clear();
            text_field_preco.clear();
            text_field_quantidade.clear();
            text_field_referencia.clear();
        } else {
            uteis.exibirAlerta("Erro", "Erro ao cadastrar mercadoria!", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void fecharTelaCadastroMercadoria() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.initStyle(StageStyle.UNDECORATED);
        alerta.setHeaderText("Deseja sair?");

        ButtonType buttonSim = new ButtonType("Sim");
        ButtonType buttonNao = new ButtonType("Não");

        alerta.getButtonTypes().setAll(buttonSim, buttonNao);

        Optional<ButtonType> resultado = alerta.showAndWait();

        if (resultado.isPresent() && resultado.get() == buttonSim) {
            Stage stage = (Stage) btn_cancelar_cadastro_mercadoria.getScene().getWindow();
            stage.close();
        }
    }

}
