<%@page import="pe.plazanorte.sisterra.entidades.Viaje"%>
<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<link rel="stylesheet" href="css/humanity.datepick.css" type="text/css"/>
<link rel="stylesheet" href="css/jquery.datepick.css" type="text/css"/> 
<link rel="stylesheet" href="jquery/css/dark-hive/jquery-ui-1.7.3.custom.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.6.1.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vender boleto de viaje</title>
</head>
<body>
<%
	double precio = (Double)request.getAttribute("precio");
	int idReserva = (Integer)request.getAttribute("idReserva");
%>
<div class="ui-widget">
		<h3 class="ui-corner-top ui-widget-header">
			<font style="font-family: monospace; font-size: x-large;">Vender Boleto de Viaje</font>
		</h3>
<form action="ServletBoletaje" method="post" name="comprar" onsubmit="return validar()">
	<input type="hidden" name="tipo" value="<%=Constantes.ACCION_VENDER_BOLETO %>">
	<input type="hidden" name="destino" value="<%=Constantes.MENU_PRINCIPAL %>">
	<input type="hidden" name="idReserva" value="<%=idReserva %>">
	
	<div class="ui-corner-bottom ui-widget-content">
				<font style="font-family: monospace; font-size: x-large;">Datos del Viajero</font>
			</div>
	
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
			<td>Edad</td>
			<td><input type="text" name="edad"></td>
			
		</tr>
	</table>
	
	<div class="ui-corner-bottom ui-widget-content">
				<font style="font-family: monospace; font-size: x-large;">Detalle de Pago</font>
			</div>
	
	Importe a pagar: <input type="text" name="importe" value="<%=precio %>">
	
	<table>
		<tr>
			<td><input type="radio" name="tipoPago" value="<%=Constantes.TIPO_PAGO_TARJETA%>">Tarjeta de cr&eacute;dito</td>
			<td></td>
		</tr>
		<tr>
			<td>Nro. tarjeta</td>
			<td><input type="text" name="nroTarjeta"></td>
		</tr>
		<tr>
			<td>Clave</td>
			<td><input type="password" name="clave"></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td><input type="radio" name="tipoPago" value="<%=Constantes.TIPO_PAGO_EFECTIVO%>">Efectivo</td>
			<td></td>
		</tr>
		<tr>
			<td>Pago</td>
			<td><input type="text" name="pagoEfectivo"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Confirmar compra" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"></td>
			<td><input type="submit" value="Imprimir" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"></td>
		</tr>
	</table>
</form>

</body>
</html>