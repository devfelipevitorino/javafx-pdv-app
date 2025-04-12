package com.devfelipevitorino.pdv.Database.Usuario;

import com.devfelipevitorino.pdv.Database.Configuration.Database;
import com.devfelipevitorino.pdv.Model.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean validaCampos(String nome, String senha) {
        return nome != null && !nome.trim().isEmpty() && senha != null && !senha.trim().isEmpty();
    }

    public boolean autenticarUsuario(Usuario usuario) {
        if (!validaCampos(usuario.getNome(), usuario.getSenha())) {
            return false;
        }

        String sql = "SELECT senha FROM usuarios WHERE BINARY nome = ?";

        try (Connection conn = Database.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String senhaHash = rs.getString("senha");
                return BCrypt.checkpw(usuario.getSenha(), senhaHash);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean salvarUsuario(Usuario usuario) {
        if (!validaCampos(usuario.getNome(), usuario.getSenha())) {
            return false;
        }

        String sql = "INSERT INTO usuarios (nome, senha) VALUES (?, ?)";

        try (Connection conn = Database.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String senhaHash = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, senhaHash);

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
