package com.devfelipevitorino.pdv.Database.Produtos;

import com.devfelipevitorino.pdv.Database.Configuration.Database;
import com.devfelipevitorino.pdv.Model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutosDAO {

    public boolean salvarProduto(Produto produto) {
        String sql = "INSERT INTO produto (nome, descricao, preco, qtd_estoque, referencia, unidade_medida, data_cadastro, ativo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQtdEstoque());
            stmt.setString(5, produto.getReferencia());
            stmt.setString(6, produto.getUnidadeMedida());
            stmt.setTimestamp(7, new java.sql.Timestamp(produto.getDataCadastro().getTime()));
            stmt.setBoolean(8, produto.getAtivo());

            stmt.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar produto: " + e.getMessage());
            return false;
        }
    }
}
