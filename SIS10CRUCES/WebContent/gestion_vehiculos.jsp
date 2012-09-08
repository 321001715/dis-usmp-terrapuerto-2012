<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestionar vehículos</title>
</head>
<body>
	<h2>Gestión de vehículos</h2>
	
	<%@include file="buscar_vehiculos.jsp" %>
	
	<br><a href="registrar_vehiculo.jsp">Registrar vehículo</a>
	
	<br><hr><br>
	
	<%@include file="listar_vehiculos.jsp" %>

</body>
</html>