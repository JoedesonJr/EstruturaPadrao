<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br" ng-app="principal">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title> Principal </title>

        <!-- CSS, FONTS, ICONS -->
        <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
        <link rel="stylesheet" href="<c:url value='/resources/fonts/'/>" >
        <link rel="stylesheet" href="<c:url value='/resources/icons'/>" >

        <!-- ANGULAR -->
        <script src="<c:url value="/resources/angular/angular.js"/>"></script>
        <script src="<c:url value="/resources/angular/angular-route.js"/>"></script>
        <script src="<c:url value="/resources/js/appRoute.js"/>"></script>
        <!-- CONTROLLERS ANGULAR -->
        <script src="<c:url value="/resources/js/controller/principalCtrl.js"/>"></script>
        <script src="<c:url value="/resources/js/controller/estoqueCtrl.js"/>"></script>
        <script src="<c:url value="/resources/js/controller/vendaCtrl.js"/>"></script>
        <script src="<c:url value="/resources/js/controller/produtoCtrl.js"/>"></script>
    </head>
    <body ng-controller="principalCtrl">

        <!-- MENU -->
        <header>
            <c:import url="menu.jsp" />
        </header>

        <!-- ROTAS -->
        <main>
            <div ng-view></div>
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
