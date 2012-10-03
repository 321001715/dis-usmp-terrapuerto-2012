<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
   	<font style="font-family: monospace; font-size: x-large;">Gestionar Vehículo</font>
   </h3>
  	
   <div class="ui-corner-bottom ui-widget-content">   
   		<font style="font-family: monospace; font-size: x-large;">Registrar Vehículo</font>
   </div>
<form action="ServletProveedor" method="post">
	<input type="hidden" name="tipo" value="<%=Constantes.ACCION_REGISTRAR_VEHICULO %>">
	<table border="0">
			<tr><td><br></td></tr>
			<tr>
				<td width="20%"></td>
				<td>Código Vehículo: </td>
				<td><input type="text" name="codVehiculo"></td>
				
				<td>Asientos No Disponibles:</td>
				<td rowspan="6">
					<select name=asientosNoDisponibles multiple="multiple" size="15">
<% 
	for(int i=1; i<=140; i++){
%>
						<option value="<%=i%>"><%=i%></option>
<%
	}
%>
					</select>
				</td>
			<tr>
				<td></td>
				<td>Marca: </td>
				<td><input type="text" name="marca"></td>
			</tr>
			<tr>
				<td></td>	
				<td>Modelo: </td>
				<td><input type="text" name="modelo"></td>
			</tr>
			<tr>
				<td></td>
				<td>Placa: </td>
				<td><input type="text" name="placa"></td>
			</tr>
			<tr>	
				<td></td>	
				<td>Número de Pisos: </td>
				<td>
					<select name="numPiso">
						<option value="1">1</option>
						<option value="2">2</option>
					</select>
				</td>
			</tr>
			<tr>	
				<td></td>	
				<td>Numer de Asientos: </td>
				<td><input type="text" name="numAsientos"></td>
			</tr>
			<tr>	
				<td></td>	
				<td>Asientos por Piso: </td>
				<td><input type="text" name="asientosPorPiso"></td>
			</tr>
			<tr>
				<td></td>
				<td>Observaciones: </td>
				<td colspan="3"><textarea rows="3" cols="50" name="obs"></textarea></td>
			</tr>
			<tr>
				<td colspan="6" align="right">
					<input type="submit" value="Registrar Vehículo" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
				</td>
			</tr>			
		</table>
</form>
</div>
<br><br><a href="index_proveedor.jsp">
			<img alt="" src="<%=request.getContextPath()%>/images/atras.jpg"> 
		</a> Atrás...
	&nbsp;
</body>
</html>