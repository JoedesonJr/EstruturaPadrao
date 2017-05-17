package br.ufsm.csi.DAO;

import java.sql.*;

/*
    CREATE DATABASE db_estruturapadrao;

    CREATE TABLE usuario (
        idUsuario serial PRIMARY KEY,
        nome varchar(30) NOT NULL,
        email varchar(20) UNIQUE,
        senha varchar(12) NOT NULL
    );

    INSERT INTO usuario VALUES (DEFAULT, 'Administrador', 'admin@admin', 'admin');

    CREATE TABLE produto (
        idProduto serial PRIMARY KEY,
        nome varchar(50),
        preco numeric(12,2)
    );

 */

public class PostgreSQLFactory {

    public Connection getConexao() {

        Connection conn = null;

        String host = "localhost";
        String database = "db_estruturapadrao";
        String user = "postgres";
        String password = "201421269";

        String url = "jdbc:postgresql://" +host +":5432/" +database;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void fecharConexao(Connection connection,
            PreparedStatement preparedStatement, ResultSet resultSet) {

        try {
            if(resultSet != null) resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
