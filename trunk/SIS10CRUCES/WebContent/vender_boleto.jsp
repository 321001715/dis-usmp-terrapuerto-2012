<%@page import="pe.plazanorte.sisterra.entidades.Boleto"%>
<%@page import="pe.plazanorte.sisterra.entidades.Ruta"%>
<%@page import="pe.plazanorte.sisterra.entidades.Viaje"%>
<%@page import="pe.plazanorte.sisterra.entidades.Perfil"%>
<%@page import="pe.plazanorte.sisterra.entidades.Reserva"%>
<%@page import="pe.plazanorte.sisterra.entidades.Usuario"%>
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

<script type="text/javascript">

function desabilitarEfectivo() {
	eval("document.vender.pagoEfectivo.disabled=true");	
		
	eval("document.vender.nroTarjeta.disabled=false");
	eval("document.vender.clave.disabled=false");
}

function desabilitarTarjeta(accion) {
	eval("document.vender.nroTarjeta.disabled=true");
	eval("document.vender.clave.disabled=true");
	
	eval("document.vender.pagoEfectivo.disabled=false");
}

</script>

</head>
<body>

<%
	Usuario reservador = (Usuario)session.getAttribute("BUsuario");	
	Perfil usuarioPerfil = (Perfil)session.getAttribute("BPerfil");	
	int idReserva = (Integer)request.getAttribute("idReserva");	
	Viaje viaje = (Viaje)request.getAttribute("viaje");	
	Ruta ruta = (Ruta)request.getAttribute("ruta");	
	int piso = (Integer)request.getAttribute("piso");	
	int asiento = (Integer)request.getAttribute("asiento");	
	String nombreProveedor = (String)request.getAttribute("nombreProveedor");
%>

<h3 class="ui-corner-top ui-widget-header">
	<font style="font-family: monospace; font-size: x-large;">Vender Boleto de Viaje</font>
</h3>

<form method="post" action="ServletBoletaje" name="vender" onsubmit="">
	<input type="hidden" name="tipo" value="<%=Constantes.ACCION_VENDER_BOLETO%>">
	<input type="hidden" name="destino" value="<%=Constantes.MENU_PRINCIPAL%>">
	<input type="hidden" name="idReserva" value="<%=idReserva %>">
	
	
	<table>
		<tr>
			<td>Usuario</td>
			<td><input type="text" value="<%=reservador.getUsuario() %>" disabled="disabled"></td>
		</tr>
		<tr>
			<td>Perfil</td>
			<td><input type="text" value="<%=usuarioPerfil.getNombre() %>" disabled="disabled"></td>
		</tr>
	</table>
	
	<div class="ui-corner-bottom ui-widget-content">
		<font style="font-family: monospace; font-size: x-large;">Detalle de reserva</font>
	</div>
	
	<table>
		<tr>
			<td>Nro. Reserva</td>
			<td><input type="text" name="idReserva" value="<%=idReserva %>" disabled="disabled"></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>C&oacute;digo de viaje</td>
			<td><input type="text" name="idViaje" value="<%=viaje.getId() %>" disabled="disabled"></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Origen</td>
			<td><input type="text" name="origen" value="<%=ruta.getOrigen() %>" disabled="disabled"></td>
			<td>Destino</td>
			<td><input type="text" name="destino" value="<%=ruta.getDestino() %>" disabled="disabled"></td>
		</tr>
		<tr>
			<td>Fecha de salida</td>
			<td><input type="text" name="destino" value="<%=viaje.getFecSalida() %>" disabled="disabled"></td>
			<td>Fecha de llegada</td>
			<td><input type="text" name="destino" value="<%=viaje.getFecLlegada() %>" disabled="disabled"></td>
		</tr>
		<tr>
			<td>Hora de salida</td>
			<td><input type="text" name="destino" value="<%=viaje.getHorSalida() %>" disabled="disabled"></td>
			<td>Hora de llegada</td>
			<td><input type="text" name="destino" value="<%=viaje.getHorLlegada() %>" disabled="disabled"></td>
		</tr>
	</table>
	
	<div class="ui-corner-bottom ui-widget-content">
		<font style="font-family: monospace; font-size: x-large;">Detalle del servicio</font>
	</div>
	
	<table>
		<tr>
			<td>Empresa</td>
			<td><input type="text" name="nombreProveedor" value="<%=nombreProveedor %>" disabled="disabled"></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Servicio</td>
			<td><input type="text" name="servicio" value="" disabled="disabled"></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Costo S/.</td>
			<td><input type="text" name="costo" value="<%=viaje.getPrecio()%>" disabled="disabled"></td>
			<td>Horas</td>
			<td><input type="text" name="horas" value="<%=ruta.getDuracion()%>" disabled="disabled"></td>
		</tr>
		<tr>
			<td>Nro. de Asiento</td>
			<td><input type="text" name="nroAsientos" value="<%=asiento %>" disabled="disabled"></td>
			<td>Piso</td>
			<td><input type="text" name="piso" value="<%=piso %>" disabled="disabled"></td>
		</tr>
	</table>
	
	<div class="ui-corner-bottom ui-widget-content">
		<font style="font-family: monospace; font-size: x-large;">Detalle del reservador</font>
	</div>
	
	<table>
		<tr>
			<td>Apellidos y Nombres</td>
			<td><input type="text" name="apellidos" value="<%=reservador.getNombres() + " " + reservador.getApePat() %>" disabled="disabled"></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Reservador</td> 
			<td><input type="text" name="reservador" value="<%=reservador.getUsuario() %>" disabled="disabled"></td>
			<td>Perfil</td>
			<td><input type="text" name="perfil" value="" disabled="disabled"></td>
		</tr>		
	</table>
	
	<h4>Datos del viajero</h4>
	
	<table>
		<tr>
			<td>Nro. Documento</td>
			<td><input type="text" name="documento"></td>
			<td><input type="submit" value="<%=Constantes.%>"></td>
			<td></td>
		</tr>
		<tr>
			<td>Nombre</td>
			<td><input type="text" name="nombre"></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Apellido Paterno</td>
			<td><input type="text" name="apePat"></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Apellido Materno</td>
			<td><input type="text" name="apeMat"></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Fec. Nacimiento</td>
			<td><input type="text" name="fecNac" disabled="disabled"></td>
			<td>Edad</td>
			<td><input type="text" name="edad"></td>
		</tr>
	</table>
	
	<h4>Detalle de pago</h4>
	
	Importe a pagar: <input type="text" name="importe" value="<%=viaje.getPrecio() %>">
	
	<table>
		<tr>
			<td><input type="radio" name="tipoPago" value="<%=Constantes.TIPO_PAGO_TARJETA%>" onclick="desabilitarEfectivo(true)" checked="checked">Tarjeta de cr&eacute;dito</td>
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
			<td><input type="radio" name="tipoPago" value="<%=Constantes.TIPO_PAGO_EFECTIVO%>" onclick="desabilitarTarjeta(true)">Efectivo</td>
			<td></td>
		</tr>		
		<tr>
			<td>Pago</td>
			<td><input type="text" name="pagoEfectivo" disabled="disabled"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Confirmar compra" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"></td>
			<td><input type="submit" value="Imprimir" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"></td>
		</tr>
	</table>
</form>

</body>
</html>