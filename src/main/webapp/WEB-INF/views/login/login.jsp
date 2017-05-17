<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br" ng-app="app">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title> Login </title>

        <!-- CSS, FONTS, ICONS -->
        <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
        <link rel="stylesheet" href="<c:url value='/resources/fonts/'/>" >
        <link rel="stylesheet" href="<c:url value='/resources/icons'/>" >

        <!-- ANGULAR -->
        <script src="<c:url value="/resources/angular/angular.min.js"/>"></script>
        <script src="<c:url value="/resources/js/app.js"/>"></script>
        <script src="<c:url value="/resources/js/controller/loginCtrl.js"/>"></script>
    </head>
    <body ng-controller="loginCtrl">

        <!-- CABEÇALHO -->
        <header>
            <h1> Login </h1>
        </header>

        <!-- CONTEUDO -->
        <main>
            <!-- MENSAGENS -->
            <c:import url="mensagens-login.jsp"/>

            <form action="autenticarUsuario" method="post" autocomplete="off">
                Email:  <input type="email" name="email" ng-model="email" required />  <br><br>
                Senha:  <input type="password" name="senha" ng-model="senha" required />  <br><br>

                <button type="submit">Entrar</button>
            </form>
        </main>

        <!-- RODAPE -->
        <footer>
            <c:import url="../rodape/rodape.jsp"/>
        </footer>

        <!-- SCRIPTS JAVASCRIPT -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="<c:url value='/resources/js/'/>"></script>
    </body>
</html>