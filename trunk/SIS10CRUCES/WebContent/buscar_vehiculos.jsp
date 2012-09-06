<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<form action="ServletProveedor" method="post">
		<input type="hidden" name="tipo" value="<%=Constantes.ACCION_FILTRO_VEHICULO %>">
		<input type="hidden" name="destino" value="<%=Constantes.GESTIONAR_VEHICULO%>">
		<table>
			<tr>
				<td>Código de vehículo</td>
				<td><input type="text" name="idVehiculo"></td>
				
				<td>Modelo</td>
				<td><input type="text" name="modelo"></td>
				
				<td rowspan="2" valign="top"><input type="submit" value="Buscar"></td>
			</tr>
			<tr>
				<td>Marca</td>
				<td><input type="text" name="marca"></td>
				
				<td>Placa</td>
				<td><input type="text" name="placa"></td>
			</tr>			
		</table>
	</form>
</body>
</html>