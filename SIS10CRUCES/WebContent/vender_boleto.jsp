<%@page import="pe.plazanorte.sisterra.entidades.Perfil"%>
<%@page import="pe.plazanorte.sisterra.entidades.Reserva"%>
<%@page import="pe.plazanorte.sisterra.entidades.Usuario"%>
<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	double precio = (Double)request.getAttribute("precio");
	Usuario reservador = (Usuario)request.getAttribute("reservador");
	Reserva reserva = (Reserva)request.getAttribute("reserva");
	Usuario usuarioSesion = (Usuario)session.getAttribute("BUsuario");
	Perfil usuarioPerfil = (Perfil)request.getAttribute("perfil");
%>

<h2>Vender boleto de viaje</h2>

<form action="ServletBoletaje" name="vender" onsubmit="">
	<input type="hidden" name="tipo" value="<%=Constantes.ACCION_VENDER_BOLETO%>">
	<input type="hidden" name="destino" value="<%=Constantes.MENU_PRINCIPAL%>">
	<input type="hidden" name="idReserva" value="<%=reserva.getId() %>">
	
	
	<table>
		<tr>
			<td>Usuario</td>
			<td><input type="text" value="<%=usuarioSesion.getUsuario() %>" disabled="disabled"></td>
		</tr>
		<tr>
			<td>Perfil</td>
			<td><input type="text" value="<%=usuarioPerfil.getNombre() %>" disabled="disabled"></td>
		</tr>
	</table>
		
	<h4>Detalle de reserva</h4>
	<table>
		<tr>
			<td>Nro. Reserva</td>
			<td><input type="text" name="idReserva" value=""></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>C&oacute;digo de viaje</td>
			<td><input type="text" name="idViaje" value=""></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Origen</td>
			<td><input type="text" name="origen" value=""></td>
			<td>Destino</td>
			<td><input type="text" name="destino" value=""></td>
		</tr>
		<tr>
			<td>Fecha de salida</td>
			<td><input type="text" name="destino" value=""></td>
			<td>Fecha de llegada</td>
			<td><input type="text" name="destino" value=""></td>
		</tr>
		<tr>
			<td>Hora de salida</td>
			<td><input type="text" name="destino" value=""></td>
			<td>Hora de llegada</td>
			<td><input type="text" name="destino" value=""></td>
		</tr>
	</table>
	
	<h4>Detalle del servicio</h4>
	
	<table>
		<tr>
			<td>Empresa</td>
			<td><input type="text" name="empresa" value=""></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Servicio</td>
			<td><input type="text" name="servicio" value=""></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Costo S/.</td>
			<td><input type="text" name="empresa" value=""></td>
			<td>Horas</td>
			<td><input type="text" name="horas" value=""></td>
		</tr>
		<tr>
			<td>Nro. de Asiento</td>
			<td><input type="text" name="nroAsientos" value=""></td>
			<td>Piso</td>
			<td><input type="text" name="piso" value=""></td>
		</tr>
	</table>
	
	<h4>Detalle del reservador</h4>
	
	<table>
		<tr>
			<td>Apellidos y Nombres</td>
			<td><input type="text" name="apellidos" value=""></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Reservador</td> 
			<td><input type="text" name="reservador" value=""></td>
			<td>Perfil</td>
			<td><input type="text" name="perfil" value=""></td>
		</tr>
		<tr>
			<td>Fec. Nacimiento</td>
			<td><input type="text" name="fecNac" value=""></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	
	<h4>Datos del viajero</h4>
	
	<table>
		<tr>
			<td>Nro. Documento</td>
			<td><input type="text" name="documento" value=""></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Nombre</td>
			<td><input type="text" name="nombre" value=""></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Apellido Paterno</td>
			<td><input type="text" name="apePat" value=""></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Apellido Materno</td>
			<td><input type="text" name="apeMat" value=""></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Fec. Nacimiento</td>
			<td><input type="text" name="fecNac" value=""></td>
			<td>Edad</td>
			<td><input type="text" name="edad" value=""></td>
		</tr>
	</table>
	
	<h4>Detalle de pago</h4>
	
	Importe a pagar: <input type="text" name="importe" value="<%=precio %>">
	
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
			<td><input type="text" name="clave"></td>
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
			<td><input type="submit" value="Confirmar"></td>
			<td><input type="submit" value="Imprimir"></td>
		</tr>
	</table>
</form>

</body>
</html>