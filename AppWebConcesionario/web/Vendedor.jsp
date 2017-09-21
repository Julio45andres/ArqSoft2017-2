<%-- 
    Document   : Vendedor
    Created on : 16-sep-2017, 21:28:32
    Author     : César
--%>

<div class="container">
    <div ng-if="response!=undefined" class="alert" ng-class="{'alert-danger':!response.estado,'alert-success':response.estado}">
        <span ng-bind="response.msj"></span>
    </div>
    <form>
        <h3>Crear/Editar Vendedor</h3>        
        <div class="form-group">
            <label>Id</label>
            <input type="text" class="form-control" ng-model="vendedor.id" placeholder="Id" maxlength="20">
        </div>          
        <div class="form-group">
            <label>Nombre:</label>
            <input type="text" class="form-control" ng-model="vendedor.nombre" placeholder="Nombre" maxlength="50">
        </div>
        <div class="form-group">
            <label>Apellidos:</label>
            <input type="text" class="form-control" ng-model="vendedor.apellidos" placeholder="Apellidos" maxlength="50">
        </div>
        
        <button type="button" class="btn btn-default" ng-click="post()"><span class="glyphicon glyphicon-floppy-save"></span> Crear</button>
        <button type="button" class="btn btn-default" ng-click="put()"><span class="glyphicon glyphicon-edit"></span> Editar</button>
        <button type="button" class="btn btn-default" ng-click="clean()"><span class="glyphicon glyphicon-trash"></span> Limpiar</button>
        
    </form>
    <h3>Lista de Vendedores</h3>
    <div class="table-responsive">
        <table class="table table-hover" >
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Apellidos</th>                    
                    <th>Opciones</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="item in listVendedores">
                    <td ng-bind="item.id"></td>
                    <td ng-bind="item.nombre"></td>
                    <td ng-bind="item.apellidos"></td>
                    <td>
                        <button type="button" class="btn btn-info btn-xs" ng-click="edit(item)"><span class="glyphicon glyphicon-edit" title="Editar"></span></button>
                        <button type="button" class="btn btn-danger btn-xs" ng-click="remove(item)"><span class="glyphicon glyphicon-remove" title="Eliminar"></span></button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>