<%@page import="pe.plazanorte.sisterra.entidades.Persona"%>
<%@page import="java.util.Vector"%>
<%@page import="pe.plazanorte.sisterra.entidades.Perfil"%>
<%@page import="pe.plazanorte.sisterra.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/humanity.datepick.css" type="text/css" />
<link rel="stylesheet" href="css/jquery.datepick.css" type="text/css" />
<link rel="stylesheet"
	href="jquery/css/dark-hive/jquery-ui-1.7.3.custom.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.6.1.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESERVAR BOLETO</title>
</head>
<body>

	<div class="ui-widget">
		<h3 class="ui-corner-top ui-widget-header">
			<font style="font-family: monospace; font-size: x-large;">Reservar
				Boleto de Viaje</font>
		</h3>


		<%
			String busqueda = "REALIZADA";
		%>

		<form action="ServletSeguridad" name="registrar" method="post">
			<div class="ui-corner-bottom ui-widget-content">
				<font style="font-family: monospace; font-size: x-large;">Detalle
					del Reservador</font>
			</div>
			<table>
				<tr>
					<td><input type="hidden" name="tipo" value="registrar"><br></td>
				</tr>
				<tr>

					<td>Usuario:</td>
					<td><input type="text" name="txt_usuario"></td>
					<td>Perfil:</td>
					<td><input type="text" name="txt_usuario"></td>
				</tr>

			</table>
			<br>
			<div class="ui-corner-bottom ui-widget-content">
				<font style="font-family: monospace; font-size: x-large;">Detalle
					de Viajero</font>
			</div>
			<br>
			<div>
			<%@include file="buscar_usuario_dni.jsp"%>
			</div>
				<%
					if (busqueda.equalsIgnoreCase(Constantes.ACCION_BUSQUEDA_REALIZADA)) {
				%>
			<table>
				

				<tr>
					<td>Nombre:</td>
					<td><input name="nombre" disabled="disabled" /> <input
						name="txt_dni" type="hidden" /> <input name="txt_nombre"
						type="hidden" /></td>
				</tr>
				<tr>

					<td>Apellido Paterno:</td>
					<td><input name="apePat" disabled="disabled" /> <input
						name="txt_apePat" type="hidden" /></td>
				</tr>
				<tr>

					<td>Apellido Materno:</td>
					<td><input name="apeMat" disabled="disabled" /> <input
						name="txt_apeMat" type="hidden" /></td>
				</tr>
				</table>	
				<%
					} else {
				%>
				<table>
				<tr>
					<td></td>
					<td>Nombre:</td>
					<td><input name="txt_nombre" disabled="disabled" /></td>
				</tr>
				<tr>
					<td></td>
					<td>Apellido Paterno:</td>
					<td><input name="txt_apePat" disabled="disabled" /></td>
				</tr>
				<tr>
					<td></td>
					<td>Apellido Materno:</td>
					<td><input name="txt_apeMat" disabled="disabled" /></td>
				</tr>
				<%
					}
				%>

			</table>
			<br>
			<div class="ui-corner-bottom ui-widget-content">
				<font style="font-family: monospace; font-size: x-large;">Detalle
					de Reserva</font>
			</div>
			<br>
			<table>
			<tr>
			<td>Nombre de Viaje</td>
			<td><input name="txt_nom"/></td>
			<td></td>
			<td></td>
			</tr>
			<tr>
			<td>Origen</td>
			<td><input name="txt_origen"/></td>
			
			<td width="20%">Destino</td>
			<td><input name="txt_destino"/></td>
			</tr>
			<tr>
			<td>Fecha de Salida</td>
			<td><input name="txt_salida"/></td>
			
			<td width="20%">Fecha de Llegada</td>
			<td><input name="txt_llegada"/></td>
			</tr>
			<tr>
			<td>Hora de Salida</td>
			<td><input name="txt_origen"/></td>
			
			<td width="20%">Hora de Llegada</td>
			<td><input name="txt_destino"/></td>
			</tr>
			<tr>
			<td>Costo S/.</td>
			<td><input name="txt_costo"/></td>
			
			<td width="20%">Duracion Hrs.</td>
			<td><input name="txt_duracion"/></td>
			</tr>
			<tr>
			<td>Servicio</td>
			<td colspan="3"><input name="txt_servicio"/></td>
			</tr>
			<tr>
			<td>Nro Asiento</td>
			<td><input name="txt_asiento"/></td>
			
			<td width="20%">Piso</td>
			<td><input name="txt_piso"/></td>
			</tr>
			<tr>
			</tr>
			<tr>
			<td></td>
			<td><input type="submit" value="CONFIRMAR" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"></td>
			<td>       </td>
			<td><input type="submit" value="CANCELAR" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"></td>
			<td></td>
			</tr>
			
			
			</table>
		</form>
	</div>
	<br>
	<br>
	<a href="index_seguridad.jsp"> <img alt=""
		src="<%=request.getContextPath()%>/images/atras.jpg">
	</a> Atrás... &nbsp;
</body>
</html>