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
        when('/vendedores',{
            templateUrl:'Vendedor.jsp',
            controller:'ctrVendedor'
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
    
    this.vendedores=function(datos){
        return $http({
                method:'POST',
                url:'VendedorServlet',
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
}).
controller('ctrVendedor',function($scope,$srv){
    $scope.vendedor={};    
    
    $scope.listVendedores=[];
    
    $scope.response=undefined;
    
    $scope.get=function(){
        var data={method:'GET'}
        $srv.vendedores(data).then(
        function(res){
            $scope.listVendedores=res.data;
        },function(err){
            console.log(err);
        })
    }
    
    $scope.post=function(){
        $scope.vendedor.method='POST';
        $srv.vendedores($scope.vendedor).then(
        function(res){
            $scope.response=res.data;
            $scope.get();
        },function(err){
            console.log(err);
        })
    }
    $scope.put=function(){
        $scope.vendedor.method='PUT';
        $srv.vendedores($scope.vendedor).then(
        function(res){
            $scope.response=res.data;
            $scope.get();
        },function(err){
            console.log(err);
        })
    }
    
    $scope.edit=function(item){
        $scope.vendedor=item;
    }
    
    $scope.remove=function(item){
        item.method='DELETE';
        $srv.vendedores(item).then(
        function(res){
            $scope.response=res.data;
            $scope.get();
        },function(err){
            console.log(err);
        })
    }
    
    $scope.get();
})