/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module('modInicial',['ngRoute']).config(
 function($routeProvider){
    $routeProvider.
        when('/clientes',{
            templateUrl:'Cliente.jsp',
            controller:'ctrCliente'
        }).
        otherwise({
            templateUrl:'Cliente.jsp',
            controller:'ctrCliente'
        })
                    
 }).
service('$srv',function($http){
    this.clientes=function(datos){
        return $http({
                method:'POST',
                url:'ClienteServlet',
                params:datos,
                headers:{
                    'Content-type':'application/json'
                }
        });
    }
            
}).
controller('ctrCliente',function($scope,$srv){
    $scope.cliente={};    
    
    $scope.listClientes=[];
    
    $scope.response=undefined;
    
    $scope.getClientes=function(){
        var data={method:'GET'}
        $srv.clientes(data).then(
        function(res){
            $scope.listClientes=res.data;
            console.log(res);
        },function(err){
            console.log(err);
        })
    }
    
    $scope.postClientes=function(){
        $scope.cliente.method='POST';
        $srv.clientes($scope.cliente).then(
        function(res){
            $scope.response=res.data;
            $scope.getClientes();
        },function(err){
            console.log(err);
        })
    }
    $scope.putClientes=function(){
        $scope.cliente.method='PUT';
        $srv.clientes($scope.cliente).then(
        function(res){
            $scope.response=res.data;
            $scope.getClientes();
        },function(err){
            console.log(err);
        })
    }
    
    $scope.edit=function(item){
        $scope.cliente=item;
    }
    
    $scope.remove=function(item){
        item.method='DELETE';
        $srv.clientes(item).then(
        function(res){
            $scope.response=res.data;
            $scope.getClientes();
        },function(err){
            console.log(err);
        })
    }
    
    $scope.getClientes();
})