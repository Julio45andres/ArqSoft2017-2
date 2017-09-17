<%-- 
    Document   : Cliente
    Created on : 16-sep-2017, 21:27:23
    Author     : César
--%>
<div class="container">
    <div ng-if="response!=undefined" class="alert" ng-class="{'alert-danger':!response.estado,'alert-success':response.estado}">
        <span ng-bind="response.msj"></span>
    </div>
    <form>
        <h3>Crear/Editar Cliente</h3>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label>Id</label>
                    <input type="text" class="form-control" ng-model="cliente.id" placeholder="Nombre">
                </div>
            </div>      
            <div class="col-md-6">
                <div class="form-group">
                    <label>Nombre:</label>
                    <input type="text" class="form-control" ng-model="cliente.nombre" placeholder="Nombre">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label>Apellidos:</label>
                    <input type="text" class="form-control" ng-model="cliente.apellidos" placeholder="Apellidos">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label>Direccion:</label>
                    <input type="text" class="form-control" ng-model="cliente.direccion" placeholder="Direccion">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <div class="form-group">
                    <label>Teléfono</label>
                    <input type="tel" class="form-control" ng-model="cliente.telefono" placeholder="Teléfono">
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label>Celular</label>
                    <input type="tel" class="form-control" ng-model="cliente.celular" placeholder="Celular">
                </div>
            </div>
            <div class="col-md-6">            
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" class="form-control" ng-model="cliente.email" placeholder="Email">
                </div>
            </div>
        </div>
        
        <button type="button" class="btn btn-default" ng-click="postClientes()">Crear</button>
        <button type="button" class="btn btn-default" ng-click="putClientes()">Editar</button>

    </form>
    <br>
    <h3>Lista de clientes</h3>
    <div class="table-responsive">
        <table class="table table-hover" >
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Dirección</th>
                    <th>Telefono</th>
                    <th>Celular</th>
                    <th>Email</th>
                    <th>Opciones</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="item in listClientes">
                    <td ng-bind="item.id"></td>
                    <td ng-bind="item.nombre"></td>
                    <td ng-bind="item.apellidos"></td>
                    <td ng-bind="item.direccion"></td>
                    <td ng-bind="item.telefono"></td>
                    <td ng-bind="item.celular"></td>
                    <td ng-bind="item.email"></td>
                    <td>
                        <button type="button" class="btn btn-info btn-xs" ng-click="edit(item)"><span class="glyphicon glyphicon-edit" title="Editar"></span></button>
                        <button type="button" class="btn btn-danger btn-xs" ng-click="remove(item)"><span class="glyphicon glyphicon-remove" title="Eliminar"></span></button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
{{cliente}}
