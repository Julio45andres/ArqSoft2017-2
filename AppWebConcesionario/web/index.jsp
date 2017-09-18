<%-- 
    Document   : index
    Created on : 17-sep-2017, 9:31:10
    Author     : César
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css">
        <title>Concesionario</title>
    </head>
    <body ng-app="modInicial">
        <jsp:include page="Menu.jsp"></jsp:include>
        
        <div ng-view></div>
        
        <script type="text/javascript" src="bower_components/jquery/dist/jquery.min.js"></script>
        <script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
        <script type="text/javascript" src="bower_components/angular/angular.js"></script>
        <script type="text/javascript" src="bower_components/angular-route/angular-route.min.js"></script>
        <script type="text/javascript" src="js/modInicial.js"></script>
    </body>
</html>