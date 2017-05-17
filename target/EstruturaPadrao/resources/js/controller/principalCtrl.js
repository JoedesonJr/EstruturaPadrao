
appRoute.controller('principalCtrl', function ($scope, $rootScope, $location) {

    $rootScope.activetab = $location.path();

});