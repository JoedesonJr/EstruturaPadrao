<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<br><br>

<div class="left">

    <h1> > PRODUTOS </h1>  <br>

    <!-- MENSAGEM -->
    <span ng-if="mensagem != null">{{mensagem}} <br><br></span>

    <!-- CADASTRAR PRODUTO -->
    <form ng-submit="cadastrarProduto(produto)" autocomplete="off">
        Nome:  <input type="text" name="nome" ng-model="produto.nome" required />  &nbsp;&nbsp;
        Preço:  <input type="number" name="preco" ng-model="produto.preco" required />  &nbsp;&nbsp;

        <button type="submit">Cadastrar Produto</button>
    </form>

    <br><br>

    <!-- LISTAR E REMOVER PRODUTO -->
    <table ng-if="produtos.length > 0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Produto</th>
            <th>Preço</th>
            <th>Ação</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="produto in produtos">
            <td>{{produto.idProduto}}</td>
            <td>{{produto.nome}}</td>
            <td>{{produto.preco}}</td>
            <td><a href ng-click="removerProduto(produto)">Remover Produto</a> </td>
        </tr>
        </tbody>
    </table>

</div>




