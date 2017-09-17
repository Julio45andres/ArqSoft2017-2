<%-- 
    Document   : Estado
    Created on : 16-sep-2017, 21:28:06
    Author     : César
--%>

<div class="container">
    <div ng-if="response!=undefined" class="alert" ng-class="{'alert-danger':!response.estado,'alert-success':response.estado}">
        <span ng-bind="response.msj"></span>
    </div>
    <form>
        <h3>Crear/Editar Estado</h3>        
        <div class="form-group">
            <label>Codigo:</label>
            <input type="text" class="form-control" ng-model="estado.codigo" placeholder="Codigo">
        </div>          
        <div class="form-group">
            <label>Descripción:</label>
            <input type="text" class="form-control" ng-model="estado.descripcion" placeholder="Descripción">
        </div>
        <div class="form-group">
            <label>Estado:</label>
            <input type="text" class="form-control" ng-model="estado.estado" placeholder="Estado">
        </div>
        
        <button type="button" class="btn btn-default" ng-click="post()">Crear</button>
        <button type="button" class="btn btn-default" ng-click="put()">Editar</button>
        
    </form>
    <h3>Lista de Vendedores</h3>
    <div class="table-responsive">
        <table class="table table-hover" >
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Descripción</th>
                    <th>Estado</th>                    
                    <th>Opciones</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="item in listEstados">
                    <td ng-bind="item.codigo"></td>
                    <td ng-bind="item.descripcion"></td>
                    <td ng-bind="item.estado"></td>
                    <td>
                        <button type="button" class="btn btn-info btn-xs" ng-click="edit(item)"><span class="glyphicon glyphicon-edit" title="Editar"></span></button>
                        <button type="button" class="btn btn-danger btn-xs" ng-click="remove(item)"><span class="glyphicon glyphicon-remove" title="Eliminar"></span></button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
