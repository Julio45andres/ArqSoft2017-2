<%-- 
    Document   : Vehiculo
    Created on : 16-sep-2017, 21:27:34
    Author     : César
--%>

<div class="container">
    <div ng-if="response!=undefined" class="alert" ng-class="{'alert-danger':!response.estado,'alert-success':response.estado}">
        <span ng-bind="response.msj"></span>
    </div>
    <form>
        <h3>Crear/Editar Vehiculo</h3>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label>Matricula:</label>
                    <input type="text" class="form-control" ng-model="vehiculo.matricula" placeholder="Matricula">
                </div>
            </div>      
            <div class="col-md-6">
                <div class="form-group">
                    <label>Modelo:</label>
                    <input type="text" class="form-control" ng-model="vehiculo.modelo" placeholder="Modelo">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label>Marca:</label>
                    <input type="text" class="form-control" ng-model="vehiculo.marca" placeholder="Marca">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label>Estado:</label>
                    <input type="text" class="form-control" ng-model="vehiculo.estado" placeholder="Estado">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <div class="form-group">
                    <label>Color:</label>
                    <input type="text" class="form-control" ng-model="vehiculo.color" placeholder="Color">
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label>Foto:</label>
                    <input type="text" class="form-control" ng-model="vehiculo.foto" placeholder="Foto">
                    <input type="file" class="form-control" uploader-model="foto">
                    <button type="button" ng-click="adjuntar()" accept="image/*">Adjuntar</button>
                </div>
            </div>
            <div class="col-md-6">            
                <div class="form-group">
                    <label>Precio Venta:</label>
                    <input type="text" class="form-control" ng-model="vehiculo.precioVenta" placeholder="Precio Venta">
                </div>
            </div>
        </div>
        
        <button type="button" class="btn btn-default" ng-click="post()">Crear</button>
        <button type="button" class="btn btn-default" ng-click="put()">Editar</button>

    </form>
    <br>
    <h3>Lista de Vehiculos</h3>
    <div class="table-responsive">
        <table class="table table-hover" >
            <thead>
                <tr>
                    <th>Matricula</th>
                    <th>Modelo</th>
                    <th>Marca</th>
                    <th>Estado</th>
                    <th>Color</th>
                    <th>Foto</th>
                    <th>Precio Venta</th>
                    <th>Opciones</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="item in listVehiculos">
                    <td ng-bind="item.matricula"></td>
                    <td ng-bind="item.modelo"></td>
                    <td ng-bind="item.marca"></td>
                    <td ng-bind="item.estado"></td>
                    <td ng-bind="item.color"></td>
                    <td ng-bind="item.foto"></td>
                    <td ng-bind="item.precioVenta"></td>
                    <td>
                        <button type="button" class="btn btn-info btn-xs" ng-click="edit(item)"><span class="glyphicon glyphicon-edit" title="Editar"></span></button>
                        <button type="button" class="btn btn-danger btn-xs" ng-click="remove(item)"><span class="glyphicon glyphicon-remove" title="Eliminar"></span></button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
