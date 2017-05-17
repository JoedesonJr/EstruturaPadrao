package br.ufsm.csi.DAO;

import br.ufsm.csi.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    private Connection conn = new PostgreSQLFactory().getConexao();
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;

    public Usuario autenticarUsuario(Usuario usuario) {

        Usuario usuarioAutenticado = null;

        query = " SELECT idusuario, nome FROM usuario " +
            " WHERE email = ? AND senha = ?; ";

        try {
            preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, usuario.getEmail());
                preparedStatement.setString(2, usuario.getSenha());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                usuarioAutenticado = new Usuario();

                usuarioAutenticado.setIdUsuario(resultSet.getInt("idusuario"));
                usuarioAutenticado.setNome(resultSet.getString("nome"));
                usuarioAutenticado.setEmail(usuario.getEmail());
            }

        } catch (Exception e) { e.printStackTrace(); }

        new PostgreSQLFactory().fecharConexao(conn, preparedStatement, resultSet);

        return usuarioAutenticado;
    }

}
