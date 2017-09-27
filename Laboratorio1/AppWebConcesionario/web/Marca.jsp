<%-- 
    Document   : Marca
    Created on : 16-sep-2017, 21:27:54
    Author     : César
--%>

<div class="container">
    <div ng-if="response!=undefined" class="alert" ng-class="{'alert-danger':!response.estado,'alert-success':response.estado}">
        <span ng-bind="response.msj"></span>
    </div>
    <form>
        <h3>Crear/Editar Marca</h3>        
        <div class="form-group">
            <label>Codigo:</label>
            <input type="text" class="form-control" ng-model="marca.codigo" placeholder="Codigo" maxlength="5">
        </div>          
        <div class="form-group">
            <label>Nombre Marca:</label>
            <input type="text" class="form-control" ng-model="marca.nombreMarca" placeholder="Nombre Marca" maxlength="30">
        </div>        
        
        <button type="button" class="btn btn-default" ng-click="post()"><span class="glyphicon glyphicon-floppy-save"></span> Crear</button>
        <button type="button" class="btn btn-default" ng-click="put()"><span class="glyphicon glyphicon-edit"></span> Editar</button>
        <button type="button" class="btn btn-default" ng-click="clean()"><span class="glyphicon glyphicon-trash"></span> Limpiar</button>
        
    </form>
    <h3>Lista de Marcas</h3>
    <div class="table-responsive">
        <table class="table table-hover" >
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre Marca</th>                 
                    <th>Opciones</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="item in listMarcas">
                    <td ng-bind="item.codigo"></td>
                    <td ng-bind="item.nombreMarca"></td>
                    <td>
                        <button type="button" class="btn btn-info btn-xs" ng-click="edit(item)"><span class="glyphicon glyphicon-edit" title="Editar"></span></button>
                        <button type="button" class="btn btn-danger btn-xs" ng-click="remove(item)"><span class="glyphicon glyphicon-remove" title="Eliminar"></span></button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>

