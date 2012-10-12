<%@page import="pe.plazanorte.sisterra.entidades.Viaje"%>
<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vender boleto de viaje</title>
</head>
<body>
<%
	Viaje viaje = (Viaje)request.getAttribute("viaje");
%>
<h2>Vender boleto de viaje</h2>

<form action="ServletBoletaje" method="post" name="comprar" onsubmit="return validar()">
	<input type="hidden" name="tipo" value="<%=Constantes.ACCION_VENDER_BOLETO %>">
	<input type="hidden" name="destino" value="<%=Constantes.MENU_PRINCIPAL %>">
	
	<h4>Datos del viajero</h4>
	
	<table>
		<tr>
			<td>Nro. Documento</td>
			<td><input type="text" name="documento"></td>
		</tr>
		<tr>
			<td>Nombre</td>
			<td><input type="text" name="nombre"></td>
			
		</tr>
		<tr>
			<td>Apellido Paterno</td>
			<td><input type="text" name="apePat"></td>
			
		</tr>
		<tr>
			<td>Apellido Materno</td>
			<td><input type="text" name="apeMat"></td>
		</tr>
		<tr>
			<td>Fec. Nacimiento</td>
			<td><input type="text" name="fecNac"></td>
			
		</tr>
	</table>
	
	<h4>Detalle de pago</h4>
	
	Importe a pagar: <input type="text" name="importe" value="<%=viaje.getPrecio() %>">
	
	<table>
		<tr>
			<td><input type="radio" name="tipoPago" value="">Tarjeta de cr&eacute;dito</td>
			<td></td>
		</tr>
		<tr>
			<td>Nro. tarjeta</td>
			<td><input type="text" name="" value=""></td>
		</tr>
		<tr>
			<td>Clave</td>
			<td><input type="password" name="" value=""></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td><input type="radio" name="tipoPago" value="">Efectivo</td>
			<td></td>
		</tr>
		<tr>
			<td>Pago</td>
			<td><input type="text" name="" value=""></td>
		</tr>
		<tr>
			<td><input type="submit" value="Confirmar"></td>
			<td><input type="submit" value="Imprimir"></td>
		</tr>
	</table>
</form>

</body>
</html>