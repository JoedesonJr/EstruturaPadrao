<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<ul>
    <!-- HOME -->
    <li ng-class="{active: activetab == '/home/'}">
        <a href="#/home/">Home</a>
    </li>

    <!-- PRODUTO -->
    <li ng-class="{active: activetab == '/produto/'}">
        <a href="#/produto/">Produtos</a>
    </li>

    <!-- ESTOQUE -->
    <li ng-class="{active: activetab == '/estoque/'}"><a href="#/estoque/">
        Estoque</a>
    </li>

    <!-- VENDAS -->
    <li ng-class="{active: activetab == '/venda/'}">
        <a href="#/venda/">Vendas</a>
    </li>

    <li><a href="logout">Sair</a></li>
</ul>
<hr>