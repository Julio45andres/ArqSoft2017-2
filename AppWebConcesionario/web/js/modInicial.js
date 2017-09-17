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
        when('/estados',{
            templateUrl:'Estado.jsp',
            controller:'ctrEstado'
        }).
        when('/marcas',{
            templateUrl:'Marca.jsp',
            controller:'ctrMarca'
        }).
        when('/tipoPagos',{
            templateUrl:'TipoPago.jsp',
            controller:'ctrTipoPago'
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
    
    this.estados=function(datos){
        return $http({
                method:'POST',
                url:'EstadoServlet',
                params:datos,
                headers:{
                    'Content-type':'application/json'
                }
        });
    }
    
    this.marcas=function(datos){
        return $http({
                method:'POST',
                url:'MarcaServlet',
                params:datos,
                headers:{
                    'Content-type':'application/json'
                }
        });
    }
    
    this.tipoPagos=function(datos){
        return $http({
                method:'POST',
                url:'TipoPagoServlet',
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
}).
controller('ctrEstado',function($scope,$srv){
    $scope.estado={};    
    
    $scope.listEstados=[];
    
    $scope.response=undefined;
    
    $scope.get=function(){
        var data={method:'GET'}
        $srv.estados(data).then(
        function(res){
            $scope.listEstados=res.data;
        },function(err){
            console.log(err);
        })
    }
    
    $scope.post=function(){
        $scope.estado.method='POST';
        $srv.estados($scope.estado).then(
        function(res){
            $scope.response=res.data;
            $scope.get();
        },function(err){
            console.log(err);
        })
    }
    
    $scope.put=function(){
        $scope.estado.method='PUT';
        $srv.estados($scope.estado).then(
        function(res){
            $scope.response=res.data;
            $scope.get();
        },function(err){
            console.log(err);
        })
    }
    
    $scope.edit=function(item){
        $scope.estado=item;
    }
    
    $scope.remove=function(item){
        item.method='DELETE';
        $srv.estados(item).then(
        function(res){
            $scope.response=res.data;
            $scope.get();
        },function(err){
            console.log(err);
        })
    }
    
    $scope.get();
}).
controller('ctrMarca',function($scope,$srv){
    $scope.marca={};    
    
    $scope.listMarcas=[];
    
    $scope.response=undefined;
    
    $scope.get=function(){
        var data={method:'GET'}
        $srv.marcas(data).then(
        function(res){
            $scope.listMarcas=res.data;
        },function(err){
            console.log(err);
        })
    }
    
    $scope.post=function(){
        $scope.marca.method='POST';
        $srv.marcas($scope.marca).then(
        function(res){
            $scope.response=res.data;
            $scope.get();
        },function(err){
            console.log(err);
        })
    }
    
    $scope.put=function(){
        $scope.marca.method='PUT';
        $srv.marcas($scope.marca).then(
        function(res){
            $scope.response=res.data;
            $scope.get();
        },function(err){
            console.log(err);
        })
    }
    
    $scope.edit=function(item){
        $scope.marca=item;
    }
    
    $scope.remove=function(item){
        item.method='DELETE';
        $srv.marcas(item).then(
        function(res){
            $scope.response=res.data;
            $scope.get();
        },function(err){
            console.log(err);
        })
    }
    
    $scope.get();
}).
controller('ctrTipoPago',function($scope,$srv){
    $scope.tipoPago={};    
    
    $scope.listTipoPagos=[];
    
    $scope.response=undefined;
    
    $scope.get=function(){
        var data={method:'GET'}
        $srv.tipoPagos(data).then(
        function(res){
            $scope.listTipoPagos=res.data;
        },function(err){
            console.log(err);
        })
    }
    
    $scope.post=function(){
        $scope.tipoPago.method='POST';
        $srv.tipoPagos($scope.tipoPago).then(
        function(res){
            $scope.response=res.data;
            $scope.get();
        },function(err){
            console.log(err);
        })
    }
    
    $scope.put=function(){
        $scope.tipoPago.method='PUT';
        $srv.tipoPagos($scope.tipoPago).then(
        function(res){
            $scope.response=res.data;
            $scope.get();
        },function(err){
            console.log(err);
        })
    }
    
    $scope.edit=function(item){
        $scope.tipoPago=item;
    }
    
    $scope.remove=function(item){
        item.method='DELETE';
        $srv.tipoPagos(item).then(
        function(res){
            $scope.response=res.data;
            $scope.get();
        },function(err){
            console.log(err);
        })
    }
    
    $scope.get();
})