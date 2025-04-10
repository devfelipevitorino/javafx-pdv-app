package com.devfelipevitorino.pdv.DB.Produtos;

import com.devfelipevitorino.pdv.DB.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutosDAO {

    public boolean salvarProduto(String nome, String descricao, Double preco, Integer qtd_estoque, String referencia, String unidadeMedida) {

        String sql = "INSERT INTO produto (nome, descricao, preco, qtd_estoque, referencia, unidade_medida) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setDouble(3, preco);
            stmt.setInt(4, qtd_estoque);
            stmt.setString(5, referencia);
            stmt.setString(6, unidadeMedida);

            stmt.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
        return false;
    }


}
