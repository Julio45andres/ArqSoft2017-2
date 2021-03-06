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
        when('/vehiculos',{
            templateUrl:'Vehiculo.jsp',
            controller:'ctrVehiculo'
        }).
        when('/compras',{
            templateUrl:'Compra.jsp',
            controller:'ctrCompra'
        }).
        when('/acercaDe',{
            templateUrl:'AcercaDe.jsp'
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
    
    this.vehiculos=function(datos){
        return $http({
                method:'POST',
                url:'VehiculoServlet',
                params:datos,
                headers:{
                    'Content-type':'application/json'
                }
        });
    }
    
    this.compras=function(datos){
        return $http({
                method:'POST',
                url:'CompraServlet',
                params:datos,
                headers:{
                    'Content-type':'application/json'
                }
        });
    }
            
}).
directive('uploaderModel',['$parse',function($parse){
    return {
        restrict:'A',
        link:function(scope,iElement,iAttrs)
        {
            iElement.on('change',function(e)
            {
                //console.log(iElement[0].files)
                $parse(iAttrs.uploaderModel).assign(scope,iElement[0].files[0]);
                //$parse(iAttrs.uploaderModel).assign(scope,iElement[0].files[1]);
            });
        }
    }
}]).
controller('ctrCliente',function($scope,$srv){
    $scope.cliente={};    
    
    $scope.listClientes=[];
    
    $scope.response=undefined;
    
    $scope.getClientes=function(){
        var data={method:'GET'}
        $srv.clientes(data).then(
        function(res){
            $scope.listClientes=res.data;
        },function(err){
            console.log(err);
        })
    }
    
    $scope.postClientes=function(){
        $scope.cliente.method='POST';
        $srv.clientes($scope.cliente).then(
        function(res){
            $scope.response=res.data;
            if($scope.response.estado){
                $scope.clean();
                $scope.getClientes();
            }
        },function(err){
            console.log(err);
        })
    }
    $scope.putClientes=function(){
        $scope.cliente.method='PUT';
        $srv.clientes($scope.cliente).then(
        function(res){
            $scope.response=res.data;
            if($scope.response.estado){
                $scope.clean();
                $scope.getClientes();
            }
        },function(err){
            console.log(err);
        })
    }
    
    $scope.edit=function(item){
        $scope.cliente=item;
    }
    $scope.clean=function(){
        $scope.cliente=undefined;
    }
    $scope.remove=function(item){
        if(!confirm("Esta seguro de eliminar el cliente con cedula "+item.id+" ?")){
            return;
        }
        item.method='DELETE';
        $srv.clientes(item).then(
        function(res){
            $scope.response=res.data;
            if($scope.response.estado){
                $scope.getClientes();
            }
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
            if($scope.response.estado){
                $scope.clean();
                $scope.get();
            }
        },function(err){
            console.log(err);
        })
    }
    $scope.put=function(){
        $scope.vendedor.method='PUT';
        $srv.vendedores($scope.vendedor).then(
        function(res){
            $scope.response=res.data;
            if($scope.response.estado){
                $scope.clean();
                $scope.get();
            }
        },function(err){
            console.log(err);
        })
    }
    
    $scope.edit=function(item){
        $scope.vendedor=item;
    }
    $scope.clean=function(){
        $scope.vendedor=undefined;
    }
    $scope.remove=function(item){
        if(!confirm("Esta seguro de eliminar el vendedor "+item.id+" ?")){
            return;
        }
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
            if($scope.response.estado){
                $scope.clean();
                $scope.get();
            }
        },function(err){
            console.log(err);
        })
    }
    
    $scope.put=function(){
        $scope.estado.method='PUT';
        $srv.estados($scope.estado).then(
        function(res){
            $scope.response=res.data;
            if($scope.response.estado){
                $scope.clean();
                $scope.get();
            }
        },function(err){
            console.log(err);
        })
    }
    
    $scope.edit=function(item){
        $scope.estado=item;
    }
    
    $scope.clean=function(){
        $scope.estado=undefined;
    }
    
    $scope.remove=function(item){
        if(!confirm("Esta seguro de eliminar el estado "+item.codigo+" ?")){
            return;
        }
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
            if($scope.response.estado){
                $scope.clean();
                $scope.get();
            }
        },function(err){
            console.log(err);
        })
    }
    
    $scope.put=function(){
        $scope.marca.method='PUT';
        $srv.marcas($scope.marca).then(
        function(res){
            $scope.response=res.data;
            if($scope.response.estado){
                $scope.clean();
                $scope.get();
            }
        },function(err){
            console.log(err);
        })
    }
    
    $scope.edit=function(item){
        $scope.marca=item;
    }
    $scope.clean=function(){
        $scope.marca=undefined;
    }
    
    $scope.remove=function(item){
        if(!confirm("Esta seguro de eliminar la Marca "+item.codigo+" ?")){
            return;
        }
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
            if($scope.response.estado){
                $scope.clean();
                $scope.get();
            }
        },function(err){
            console.log(err);
        })
    }
    
    $scope.put=function(){
        $scope.tipoPago.method='PUT';
        $srv.tipoPagos($scope.tipoPago).then(
        function(res){
            $scope.response=res.data;
            if($scope.response.estado){
                $scope.clean();
                $scope.get();
            }
        },function(err){
            console.log(err);
        })
    }
    
    $scope.edit=function(item){
        $scope.tipoPago=item;
    }
    $scope.clean=function(){
        $scope.tipoPago=undefined;
    }
    $scope.remove=function(item){
        if(!confirm("Esta seguro de eliminar el Tipo de Pago "+item.codigo+" ?")){
            return;
        }
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
}).
controller('ctrVehiculo',function($scope,$srv,$http){
    $scope.vehiculo={};    
    
    $scope.listVehiculos=[];
    
    $scope.listMarcas=[];
    
    $scope.listEstados=[];
    
    $scope.response=undefined;
    
    $scope.get=function(){
        var data={method:'GET'}
        $srv.vehiculos(data).then(
        function(res){
            $scope.listVehiculos=res.data;
        },function(err){
            console.log(err);
        })
    }
    
    $scope.post=function(){        
        $scope.vehiculo.method='POST';
        var formData=new FormData();
        formData.append("foto",$scope.foto);
        
        $http({
            method:'POST',
            url:'VehiculoServlet',
            data:formData,
            params:$scope.vehiculo,
            headers:{"Content-type":undefined},
            transformRequest:angular.indentity
        }).then(
        function(res){
            $scope.response=res.data;
            if($scope.response.estado){
                $scope.clean();
                $scope.get();
            }
        },function(err){
            console.log(err);
        })
    }
        
    $scope.put=function(){
        $scope.vehiculo.method='PUT';
        var formData=new FormData();
        formData.append("foto",$scope.foto);
        
        $http({
            method:'POST',
            url:'VehiculoServlet',
            data:formData,
            params:$scope.vehiculo,
            headers:{"Content-type":undefined},
            transformRequest:angular.indentity
        }).then(
        function(res){
            $scope.response=res.data;            
            if($scope.response.estado){
                $scope.clean();
                $scope.get();
            }
        },function(err){
            console.log(err);
        })
    }
    
    $scope.edit=function(item){
        $scope.vehiculo=item;
        $scope.matriculaAux=$scope.vehiculo.matricula;
    }
    
    $scope.clean=function(){
       $scope.vehiculo={};
       $scope.foto=undefined;
       $scope.matriculaAux="";
    }
    
    $scope.remove=function(item){  
        if(!confirm("Esta seguro de eliminar el vehículo con matricula "+item.matricula+" ?")){
            return;
        }
        $http({
            method:'POST',
            url:'VehiculoServlet',
            params:{method:'DELETE',matricula:item.matricula},
            headers:{"Content-type":undefined},
            transformRequest:angular.indentity
        }).then(
        function(res){
            $scope.response=res.data;
            if($scope.response.estado){
                $scope.get();
            }
        },function(err){
            console.log(err);
        })        
    }
        
    $srv.marcas({method:'GET'}).then(
        function(res){
            $scope.listMarcas=res.data;
        },function(err){
            console.log(err);
        });        
   
    $srv.estados({method:'GET'}).then(
        function(res){
            $scope.listEstados=res.data;
        },function(err){
            console.log(err);
        })
    
    
    $scope.get();
}).
controller('ctrCompra',function($scope,$srv){
    $scope.compra={};    
    
    $scope.listCompras=[];
    
    $scope.listTipoPagos=[];
    
    $scope.listClientes=[];
    
    $scope.listVendedores=[];
    
    $scope.listVehiculos=[];
    
    $scope.response=undefined;
    
    $scope.get=function(){
        var data={method:'GET'}
        $srv.compras(data).then(
        function(res){
            $scope.listCompras=res.data;
        },function(err){
            console.log(err);
        })
    }
    
    $scope.post=function(){
        $scope.compra.method='POST';
        $srv.compras($scope.compra).then(
        function(res){
            $scope.response=res.data;
            if($scope.response.estado){
                $scope.clean();
                $scope.get();                
            }
        },function(err){
            console.log(err);
        })
    }
    
    $scope.put=function(){
        $scope.compra.method='PUT';
        $srv.compras($scope.compra).then(
        function(res){
            $scope.response=res.data;
            if($scope.response.estado){
                $scope.clean();
                $scope.get();                
            }
        },function(err){
            console.log(err);
        })
    }
    
    $scope.edit=function(item){
        $scope.compra=item;
    }
    $scope.clean=function(){
        $scope.compra=undefined;
    }
    
    $scope.remove=function(item){
        if(!confirm("Esta seguro de eliminar la compra "+item.codigo+" ?")){
            return;
        }
        item.method='DELETE';
        $srv.compras(item).then(
        function(res){
            $scope.response=res.data;
            $scope.get();
        },function(err){
            console.log(err);
        })
    }
    
    
    $srv.tipoPagos({method:'GET'}).then(
        function(res){
            $scope.listTipoPagos=res.data;
        },function(err){
            console.log(err);
        })
        
    $srv.clientes({method:'GET'}).then(
        function(res){
            $scope.listClientes=res.data;
        },function(err){
            console.log(err);
        })
 
    $srv.vendedores({method:'GET'}).then(
        function(res){
            $scope.listVendedores=res.data;
        },function(err){
            console.log(err);
        })
        
    $srv.vehiculos({method:'GET'}).then(
        function(res){
            $scope.listVehiculos=res.data;
        },function(err){
            console.log(err);
        })
    
    $scope.get();
})

$(function(){
    var menu=document.getElementById("menu");
    var liMenu=menu.childNodes;
    for(var i in liMenu){
        if(liMenu[i].nodeName=='LI'){
            liMenu[i].onclick=function(){
                controlMenu(this);
            }
        }
    }
    var menuAcercaDe=document.getElementById("menuAcercaDe");
    menuAcercaDe.onclick=function(){
        controlMenu(this);
    }
    
});

function controlMenu(id){
    var menu=document.getElementById("menu");
    var liMenu=menu.childNodes;
    
    for(var i in liMenu){
        if(liMenu[i].nodeName=='LI'){
            if(liMenu[i].className=='active'){
                liMenu[i].className='';
                break;
            }
        }
    }
    var menuAcercaDe=document.getElementById("menuAcercaDe");
    if(menuAcercaDe.className=='active'){
        menuAcercaDe.className='';
    }
    id.className="active";
}