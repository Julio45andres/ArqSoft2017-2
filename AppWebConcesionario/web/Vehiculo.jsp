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
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Matricula:</label>
                            <input type="text" class="form-control" ng-model="vehiculo.matricula" placeholder="Matricula" maxlength="12">
                        </div>
                    </div>      
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Modelo:</label>
                            <input type="text" class="form-control" ng-model="vehiculo.modelo" placeholder="Modelo" maxlength="10">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Marca:</label>
                            <select ng-model="vehiculo.marca" class="form-control">
                                <option value="">Seleccione</option>
                                <option ng-repeat="item in listMarcas" ng-value="item.codigo" ng-bind="item.nombreMarca"></option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Estado:</label>
                            <select ng-model="vehiculo.estado" class="form-control">
                                <option value="">Seleccione</option>
                                <option ng-repeat="item in listEstados" ng-value="item.codigo" ng-bind="item.descripcion"></option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Color:</label>
                            <input type="text" class="form-control" ng-model="vehiculo.color" placeholder="Color" maxlength="20">
                        </div>
                    </div>
                    <div class="col-md-6">            
                        <div class="form-group">
                            <label>Precio Venta:</label>
                            <input type="text" class="form-control" ng-model="vehiculo.precioVenta" placeholder="Precio Venta" maxlength="25">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <button type="button" class="btn btn-default" ng-click="post()"><span class="glyphicon glyphicon-floppy-save"></span> Crear</button>
                        <button type="button" class="btn btn-default" ng-click="put()"><span class="glyphicon glyphicon-edit"></span> Editar</button>
                        <button type="button" class="btn btn-default" ng-click="clean()"><span class="glyphicon glyphicon-trash"></span> Limpiar</button>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
               <div class="form-group">
                   <table style="width:300px;height:200px;margin-bottom: 5px;" border="1" >
                       <caption>Fotografia:</caption>
                       <tr>
                           <td>
                                <img ng-src="FotoServlet?matricula={{matriculaAux}}" width="300px"height="200px" align="center" alt="Foto Vehiculo">                   
                           </td>
                       </tr>        
                   </table>
                       <input type="file" class="form-control" uploader-model="foto">
               </div>
            </div>
        </div>
        
        

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
                    <td ng-repeat="itemMarca in listMarcas" ng-if="itemMarca.codigo==item.marca" ng-bind="itemMarca.nombreMarca"></td>
                    <td ng-repeat="itemEstado in listEstados" ng-if="itemEstado.codigo==item.estado" ng-bind="itemEstado.descripcion" width="20%"></td>
                    <td ng-bind="item.color"></td>
                    <td>
                        <img src="FotoServlet?matricula={{item.matricula}}" width="200px" height="150px"  align="center"
                                alt="Foto Vehiculo">
                    </td>
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
