appRoute.controller('produtoCtrl', function ($scope, $rootScope, $location, $http) {

    $rootScope.activetab = $location.path();

    $scope.produtos = [];

    // LISTAR PRODUTOS
    $http.get('getProdutos')
        .then(function (retorno) {
            $scope.produtos = retorno.data;
        }).catch(function (erro) {
            console.log("Problema: " +erro);
        });

    // CADASTRAR PRODUTO
    $scope.cadastrarProduto = function (produto) {
        $http.post('cadastrarProduto', produto)
            .then(function (retorno) {
                // retorna o id serial gerado
                if(retorno.data > 0) {
                    produto.idProduto = retorno.data;

                    // adiciona objeto na lista
                    $scope.produtos.push(angular.copy(produto));
                    delete $scope.produto;
                    $scope.mensagem = "Produto cadastrado";
                } else {
                    $scope.mensagem = "Produto não cadastrado";
                }

                // apaga a mensagem apos 3s
                setTimeout(function () {
                    $scope.$apply(function () {
                        $scope.mensagem = null;
                    });
                }, 3000);

            }).catch(function (erro) {
                console.log("Problema: " +erro);
        });
    };

    // REMOVER PRODUTO
    $scope.removerProduto = function (produto) {
        $http.post('removerProduto', {idProduto: produto.idProduto})
            .then(function (retorno) {
                // retorna true se o objeto foi removido
                if(retorno.data) {
                    $scope.produtos.splice($scope.produtos.indexOf(produto), 1);
                    $scope.mensagem = "Produto removido";
                } else {
                    $scope.mensagem = "Produto não removido";
                }

                // apaga a mensagem apos 3s
                setTimeout(function () {
                    $scope.$apply(function () {
                        $scope.mensagem = null;
                    });
                }, 3000);
            }).catch(function (erro) {
            console.log("Problema: " +erro);
        });
    }
});
