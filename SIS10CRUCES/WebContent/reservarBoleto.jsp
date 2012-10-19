<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@page import="pe.plazanorte.sisterra.entidades.Asiento"%>
<%@page import="pe.plazanorte.sisterra.entidades.Vehiculo"%>
<%@page import="pe.plazanorte.sisterra.entidades.Ruta"%>
<%@page import="pe.plazanorte.sisterra.entidades.Viaje"%>
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
		
		Usuario usuario=(Usuario)request.getAttribute("usuario");
		Persona persona=(Persona)request.getAttribute("persona");
		
		Ruta ruta=(Ruta)request.getAttribute("ruta");
		Perfil perfil=(Perfil)request.getAttribute("perfil");
		
		Viaje viaje=(Viaje)request.getAttribute("viaje");
		
		int asiento= (Integer)request.getAttribute("asiento");
		int piso= (Integer)request.getAttribute("piso");
		String estado="";

		
		String busqueda=(String)request.getAttribute("busqueda");
		%>

		<form action="ServletBoletaje" name="reservar" method="post">
			<div class="ui-corner-bottom ui-widget-content">
				<font style="font-family: monospace; font-size: x-large;">Detalle
					del Reservador</font>
			</div>
			<table>
				<tr>
					<td><input type="hidden" name="tipo" value="<%=Constantes.ACCION_RESERVAR %>"><br></td>
				</tr>
				<tr>

					<td>Usuario:</td>
					<td><input type="text" name="txt_usuario" value="<%=usuario.getUsuario() %>" disabled="disabled"></td>
					<td>Perfil:</td>
					<td><input type="text" name="txt_usuario" value="<%=perfil.getNombre() %>" disabled="disabled"></td>
				</tr>

			</table>
			<br>
			<div class="ui-corner-bottom ui-widget-content">
				<font style="font-family: monospace; font-size: x-large;">Detalle
					de Viajero</font>
			</div>
			<br>
			<div>
			<table>
			<tr>
				<td>N° de Documento:</td>
				<td><input type="text" name="dni"></td>
				<td><input type="submit" name="tipoSubmit" value="<%=Constantes.ACCION_CONSULTAR_USUARIO %>" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"></td>
			</tr>
					
			</table>
			</div>
				<%
					if (busqueda.equalsIgnoreCase(Constantes.ACCION_BUSQUEDA_REALIZADA)) {
				%>
			<table>
				

				<tr>
					<td>Nombre:</td>
					<td><input name="nombre"  value="<%=persona.getNombre() %>" disabled="disabled" /> <input
						name="txt_dni" value="<%=persona.getDni() %>"type="hidden" /> <input name="txt_nombre" value="<%=persona.getNombre() %>"
						type="hidden" /></td>
				</tr>
				<tr>

					<td>Apellido Paterno:</td>
					<td><input name="apePat" value="<%=persona.getApePat() %>" disabled="disabled" /> <input
						name="txt_apePat"  value="<%=persona.getApePat() %>" type="hidden" /></td>
				</tr>
				<tr>

					<td>Apellido Materno:</td>
					<td><input name="apeMat" value="<%=persona.getApeMat() %>"  disabled="disabled" /> <input
						name="txt_apeMat" value="<%=persona.getApeMat() %>"  type="hidden" /></td>
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
			<b><font color="red">NOTA: Maximo 5 consultas sin confirmar por hora. Caso contrario, se suspendera su cuenta por 24 horas. </font>
			</b>
			<br>
			<br>
			<div class="ui-corner-bottom ui-widget-content">
				<font style="font-family: monospace; font-size: x-large;">Detalle
					de Reserva</font>
			</div>
			<br>
			<table>
			<tr>
			<td>Nombre de Viaje</td>
			<td><input name="txt_nomViaje" value="<%=viaje.getNomViaje() %>" disabled="disabled"/></td>
			<td><input name="idViaje" type="hidden"  value="<%=viaje.getId() %>" /></td>
			<td></td>
			</tr>
			<tr>
			<td>Origen</td>
			<td><input name="idRuta" type="hidden"  value="<%=ruta.getId() %>" /><input name="txt_origen" value="<%=ruta.getOrigen() %>" disabled="disabled"/></td>
			
			<td width="20%">Destino</td>
			<td><input name="txt_destino" value="<%=ruta.getDestino() %>" disabled="disabled"/></td>
			</tr>
			<tr>
			<td>Fecha de Salida</td>
			<td><input name="txt_salida" value="<%=viaje.getFecSalida() %>" disabled="disabled"/></td>
			
			<td width="20%">Fecha de Llegada</td>
			<td><input name="txt_llegada" value="<%=viaje.getFecLlegada() %>" disabled="disabled"/></td>
			</tr>
			<tr>
			<td>Hora de Salida</td>
			<td><input name="txt_origen" value="<%=viaje.getHorSalida() %>" disabled="disabled"/></td>
			
			<td width="20%">Hora de Llegada</td>
			<td><input name="txt_destino" value="<%=viaje.getHorLlegada() %>" disabled="disabled"/></td>
			</tr>
			<tr>
			<td>Costo S/.</td>
			<td><input name="txt_costo"  value="<%=viaje.getPrecio() %>" disabled="disabled"/></td>
			
			<td width="20%">Duracion Hrs.</td>
			<td><input name="txt_duracion" value="<%=ruta.getDuracion() %>" disabled="disabled"/></td>
			</tr>
			<tr>
			<td>Servicio</td>
			<td colspan="3"><input name="txt_servicio" value="<%=viaje.getServicio() %>" disabled="disabled"/></td>
			</tr>
			<tr>
			<td>Nro Asiento</td>
			<td><input name="asientos" type="hidden"  value="<%=asiento %>" /><input name="txt_asiento" value="<%=asiento %>" disabled="disabled"/></td>
			
			<td width="20%">Piso</td>
			<td><input name="piso" type="hidden"  value="<%=piso %>" /><input name="txt_piso" value="<%=piso %>" disabled="disabled"/></td>
			</tr>
			<tr>
			<td colspan="4"><b><font color="red">NOTA: La reserva se anulará si no es CONFIRMADA en las 8 horas posteriores </b></font>
			</td>
			</tr>
			<tr>
			<td colspan="4"><b><font color="red">de la generación del Código de Reserva</b> </font>
			</td>
			</tr>
			<tr>
			<td></td>
			<td><input type="submit" name="tipoSubmit" value="<%=Constantes.ACCION_RESERVAR_BOLETO %>" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"></td>
			<td >      </td>
			<td><input type="submit" name="tipoSubmit" value="<%=Constantes.ACCION_CANCELAR %>" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"></td>
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