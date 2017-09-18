<%-- 
    Document   : Compra
    Created on : 16-sep-2017, 21:27:43
    Author     : César
--%>

<div class="container">
    <div ng-if="response!=undefined" class="alert" ng-class="{'alert-danger':!response.estado,'alert-success':response.estado}">
        <span ng-bind="response.msj"></span>
    </div>
    <form>
        <h3>Crear/Editar Compras</h3>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label>Codigo:</label>
                    <input type="text" class="form-control" ng-model="compra.codigo" placeholder="Codigo">
                </div>
            </div>      
            <div class="col-md-6">
                <div class="form-group">
                    <label>Fecha Compra:</label>
                    <input type="text" class="form-control" ng-model="compra.fechaCompra" placeholder="dd/mm/yyyy">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label>Tipo Pago:</label>
                    <select ng-model="compra.tipoPago" class="form-control">
                        <option value="">Seleccione</option>
                        <option ng-repeat="item in listTipoPagos" ng-bind="item.descripcion" ng-value="item.codigo"></option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label>Descuento:</label>
                    <input type="text" class="form-control" ng-model="compra.descuento" placeholder="Descuento:">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <div class="form-group">
                    <label>Vendedor:</label>
                    <select ng-model="compra.vendedor" class="form-control">
                        <option value="">Seleccione</option>
                        <option ng-repeat="item in listVendedores" ng-bind="item.nombre" ng-value="item.id"></option>
                    </select>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label>Cliente:</label>
                    <select ng-model="compra.cliente" class="form-control">
                        <option value="">Seleccione</option>
                        <option ng-repeat="item in listClientes" ng-bind="item.nombre" ng-value="item.id"></option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">            
                <div class="form-group">
                    <label>Coche:</label>
                    <select ng-model="compra.coche" class="form-control">
                        <option value="">Seleccione</option>
                        <option ng-repeat="item in listVehiculos" ng-bind="item.matricula" ng-value="item.matricula"></option>
                    </select>
                </div>
            </div>
        </div>
        
        <button type="button" class="btn btn-default" ng-click="post()">Crear</button>
        <button type="button" class="btn btn-default" ng-click="put()">Editar</button>

    </form>
    
    <br>
    <h3>Lista de Compras</h3>
    <div class="table-responsive">
        <table class="table table-hover" >
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Fecha Compra</th>
                    <th>Tipo Pago</th>
                    <th>Descuento</th>
                    <th>Vendedor</th>
                    <th>Cliente</th>
                    <th>Coche</th>
                    <th>Opciones</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="item in listCompras">
                    <td ng-bind="item.codigo"></td>
                    <td ng-bind="item.fechaCompra"></td>
                    <td ng-repeat="itemTipoPago in listTipoPagos" ng-if="itemTipoPago.codigo==item.tipoPago">
                        <span ng-bind="itemTipoPago.descripcion"></span>
                    </td>
                    <td ng-bind="item.descuento"></td>
                    <td ng-repeat="itemVendedor in listVendedores" ng-if="itemVendedor.id==item.vendedor">
                        <span ng-bind="itemVendedor.nombre"></span> <span ng-bind="itemVendedor.apellidos"></span>                        
                    </td>
                    <td ng-bind="item.cliente"></td>
                    <td ng-bind="item.coche"></td>
                    <td>
                        <button type="button" class="btn btn-info btn-xs" ng-click="edit(item)"><span class="glyphicon glyphicon-edit" title="Editar"></span></button>
                        <button type="button" class="btn btn-danger btn-xs" ng-click="remove(item)"><span class="glyphicon glyphicon-remove" title="Eliminar"></span></button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
