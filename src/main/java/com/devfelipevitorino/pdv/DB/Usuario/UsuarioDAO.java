package com.devfelipevitorino.pdv.DB.Usuario;

import com.devfelipevitorino.pdv.DB.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean validaCampos(String nome, String senha){
        return nome != null && !nome.trim().isEmpty() && senha != null && !senha.trim().isEmpty();
    }


    public boolean autenticarUsuario(String nome, String senha) {

        if (!validaCampos(nome, senha)){
            return false;
        }

        String sql = "SELECT * FROM usuarios WHERE BINARY nome = ? AND BINARY senha = ?";

        try (Connection conn = Database.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean salvarUsuario(String nome, String senha) {

        if (!validaCampos(nome, senha)){
            return false;
        }

        String sql = "INSERT INTO usuarios (nome, senha) VALUES (?, ?)";

        try (Connection conn = Database.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, senha);
            stmt.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
        return false;
    }

}
