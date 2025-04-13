package com.devfelipevitorino.pdv.Database.Produtos;

import com.devfelipevitorino.pdv.Database.Configuration.Database;
import com.devfelipevitorino.pdv.Model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Produto buscarProduto(String comando) {
        String sql = "SELECT * FROM produto WHERE nome LIKE ? OR descricao LIKE ? OR referencia LIKE ?";

        try (Connection conn = Database.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String termo = "%" + comando + "%";
            stmt.setString(1, termo);
            stmt.setString(2, termo);
            stmt.setString(3, termo);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Produto produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setReferencia(rs.getString("referencia"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQtdEstoque(rs.getInt("qtd_estoque"));
                produto.setUnidadeMedida(rs.getString("unidade_medida"));
                produto.setDataCadastro(rs.getTimestamp("data_cadastro"));
                produto.setAtivo(rs.getBoolean("ativo"));

                return produto;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar produto: " + e.getMessage());
        }

        return null;
    }
}

