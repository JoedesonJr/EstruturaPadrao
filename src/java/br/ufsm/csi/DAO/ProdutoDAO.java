package br.ufsm.csi.DAO;

import br.ufsm.csi.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdutoDAO {

    private Connection conn = new PostgreSQLFactory().getConexao();
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;
    private boolean status = false;

    public int cadastrarProduto(Produto produto) {

        int idProduto = 0;

        query = " INSERT INTO produto VALUES(DEFAULT, ?, ?); ";

        try {
            preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, produto.getNome());
                preparedStatement.setFloat(2, produto.getPreco());
            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();

            // se o numero de linhas alteradas foi maior que 0
            if(preparedStatement.getUpdateCount() > 0) {
                resultSet.next();
                // recupera o id serial gerado.
                idProduto = resultSet.getInt(1);
            }

        } catch (Exception e) { e.printStackTrace(); }

        new PostgreSQLFactory().fecharConexao(conn, preparedStatement, resultSet);

        return idProduto;
    }

    public boolean removerProduto(int idProduto) {

        query = " DELETE FROM produto WHERE idProduto = ?; ";

        try {
            preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, idProduto);
            preparedStatement.executeUpdate();

            // se o numero de linhas alteradas foi maior que 0
            if(preparedStatement.getUpdateCount() > 0) {
                status = true;
            }
        } catch (Exception e) { e.printStackTrace(); }

        new PostgreSQLFactory().fecharConexao(conn, preparedStatement, resultSet);

        return status;
    }

    public ArrayList<Produto> getProdutos() {

        ArrayList<Produto> produtos = new ArrayList<Produto>();

        query = " SELECT * FROM produto; ";

        try {
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Produto produto = new Produto();
                    produto.setIdProduto(resultSet.getInt("idProduto"));
                    produto.setNome(resultSet.getString("nome"));
                    produto.setPreco(resultSet.getFloat("preco"));
                produtos.add(produto);
            }

        } catch (Exception e) { e.printStackTrace(); }

        new PostgreSQLFactory().fecharConexao(conn, preparedStatement, resultSet);

        return produtos;
    }

}
