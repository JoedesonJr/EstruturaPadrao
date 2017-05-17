var appRoute = angular.module('principal', ['ngRoute']);

appRoute.config(['$routeProvider', function ($routeProvider) {

    $routeProvider
        // HOME
        .when('/home/', {
            templateUrl: 'principal/home',
            controller: 'principalCtrl'
        })

        // PRODUTO
        .when('/produto/', {
            templateUrl: 'principal/produto',
            controller: 'produtoCtrl'
        })

        // ESTOQUE
        .when('/estoque/', {
            templateUrl: 'principal/estoque',
            controller: 'estoqueCtrl'
        })

        // VENDA
        .when('/venda/', {
            templateUrl: 'principal/venda',
            controller: 'vendaCtrl'
        })

        .otherwise({redirectTo: '/home/'});
}]);
