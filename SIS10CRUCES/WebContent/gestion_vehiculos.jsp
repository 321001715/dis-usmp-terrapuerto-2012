<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<link rel="stylesheet" href="css/humanity.datepick.css" type="text/css"/>
<link rel="stylesheet" href="css/jquery.datepick.css" type="text/css"/> 
<link rel="stylesheet" href="jquery/css/dark-hive/jquery-ui-1.7.3.custom.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.6.1.js"></script>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<div class="ui-widget">
   <h3 class="ui-corner-top ui-widget-header"> 
   	<font style="font-family: monospace; font-size: x-large;">Gesti�n de Veh�culos</font>
   </h3>
	
	<%@include file="buscar_vehiculos.jsp" %>
	
	<br><a href="registrar_vehiculo.jsp">
			<img alt="" src="<%=request.getContextPath()%>/images/adicionar.png">
		</a>
	<br><hr><br>
	
	<%@include file="listar_vehiculos.jsp" %>
	<br><br><a href="index_proveedor.jsp">
			<img alt="" src="<%=request.getContextPath()%>/images/atras.jpg"> 
		</a> Atr�s...
	&nbsp;
</div>
</body>
</html>