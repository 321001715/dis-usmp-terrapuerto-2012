<%@page import="pe.plazanorte.sisterra.entidades.Usuario"%>
<%@page import="pe.plazanorte.sisterra.entidades.Vehiculo"%>
<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@page import="pe.plazanorte.sisterra.entidades.Asiento"%>
<%@page import="java.util.Vector"%>
<%@page import="pe.plazanorte.sisterra.entidades.Ruta"%>
<%@page import="pe.plazanorte.sisterra.entidades.Viaje"%>
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
<%
	Viaje viaje=(Viaje)request.getAttribute("unviaje");
	
	Ruta ruta=(Ruta)request.getAttribute("unaruta");
	
	Vehiculo carro=(Vehiculo)request.getAttribute("carro");
	
	
	Vector<Asiento> asientos=(Vector<Asiento>)request.getAttribute("asientos");
	String estado="";
	
	
	
%>
<body>
<div class="ui-widget">
<form action="ServletBoletaje" method="post" name="reservar" >
<input type="hidden" name="tipo" value="<%=Constantes.ACCION_RESERVAR_BOLETO %>">
<table style="width: 100%; height: 100%; position: relative;">
<tr>
<td>
	<table cellpadding="8" cellspacing="8" align="center" style="width: 100%; height: 100%;">
		<tr>
			<td rowspan="3" align="center">
				<!-- GRÁFICO DE OMNIBUS -->
					<table border="3" style="background-color: #CC99CC;" cellpadding="5" cellspacing="5">
						<tr>
							<td colspan="4">
								<font style="font-family: 'Trebuchet MS'; font-size: medium;"><b>PISO 1</b></font>
							<table border="2" cellpadding="5" cellspacing="5" style="width: 300px; height: 300px;">
							<!-- AQUI ESTARÍA EL FOR PARA CREAR LOS TD PARA PISO 1-->
							<tr>
								<% for(int i=0;i<4;i++){ %>
								<td align="center" <%if(asientos.get(i).getEstado().equals("DISPONIBLE"))estado=Constantes.ASIENTO_DISPONIBLE;
								else if (asientos.get(i).getEstado().equals("NODISPONIBLE"))estado=Constantes.ASIENTO_NODISPONIBLE;
								else if (asientos.get(i).getEstado().equals("RESERVADO"))estado=Constantes.ASIENTO_RESERVADO;
								else if (asientos.get(i).getEstado().equals("VENDIDO"))estado=Constantes.ASIENTO_VENDIDO;
								%> bgcolor="<%=estado %>"><%=(i+1) %></td>							
								<%} %>
								
							</tr>
							
							<tr>	
								<% for(int i=4;i<8;i++){ %>
								<td align="center" <%if(asientos.get(i).getEstado().equals("DISPONIBLE"))estado=Constantes.ASIENTO_DISPONIBLE;
								else if (asientos.get(i).getEstado().equals("NODISPONIBLE"))estado=Constantes.ASIENTO_NODISPONIBLE;
								else if (asientos.get(i).getEstado().equals("RESERVADO"))estado=Constantes.ASIENTO_RESERVADO;
								else if (asientos.get(i).getEstado().equals("VENDIDO"))estado=Constantes.ASIENTO_VENDIDO;
								%> bgcolor="<%=estado %>"><%=(i+1) %></td>							
								<%} %>
							</tr>
							<tr>	
								<% for(int i=8;i<12;i++){ %>
								<td align="center" <%if(asientos.get(i).getEstado().equals("DISPONIBLE"))estado=Constantes.ASIENTO_DISPONIBLE;
								else if (asientos.get(i).getEstado().equals("NODISPONIBLE"))estado=Constantes.ASIENTO_NODISPONIBLE;
								else if (asientos.get(i).getEstado().equals("RESERVADO"))estado=Constantes.ASIENTO_RESERVADO;
								else if (asientos.get(i).getEstado().equals("VENDIDO"))estado=Constantes.ASIENTO_VENDIDO;
								%> bgcolor="<%=estado %>"><%=(i+1) %></td>							
								<%} %>
							</tr>
							<tr>	
								<% for(int i=12;i<16;i++){ %>
								<td align="center" <%if(asientos.get(i).getEstado().equals("DISPONIBLE"))estado=Constantes.ASIENTO_DISPONIBLE;
								else if (asientos.get(i).getEstado().equals("NODISPONIBLE"))estado=Constantes.ASIENTO_NODISPONIBLE;
								else if (asientos.get(i).getEstado().equals("RESERVADO"))estado=Constantes.ASIENTO_RESERVADO;
								else if (asientos.get(i).getEstado().equals("VENDIDO"))estado=Constantes.ASIENTO_VENDIDO;
								%> bgcolor="<%=estado %>"><%=(i+1) %></td>							
								<%} %>
							</tr>
							<tr>	
								<% for(int i=16;i<20;i++){ %>
								<td align="center" <%if(asientos.get(i).getEstado().equals("DISPONIBLE"))estado=Constantes.ASIENTO_DISPONIBLE;
								else if (asientos.get(i).getEstado().equals("NODISPONIBLE"))estado=Constantes.ASIENTO_NODISPONIBLE;
								else if (asientos.get(i).getEstado().equals("RESERVADO"))estado=Constantes.ASIENTO_RESERVADO;
								else if (asientos.get(i).getEstado().equals("VENDIDO"))estado=Constantes.ASIENTO_VENDIDO;
								%> bgcolor="<%=estado %>"><%=(i+1) %></td>							
								<%} %>
							</tr>
							<!-- FIN DE FOR PARA PISO 1 -->
							</table>
							</td>
						</tr>
						<tr>
							<td colspan="4">
								<font style="font-family: 'Trebuchet MS'; font-size: medium;"><b>PISO 2</b></font>
							<table border="2" cellpadding="5" cellspacing="5" style="width: 300px; height: 300px;">
							<!-- AQUI ESTARÍA EL FOR PARA CREAR LOS TD PARA PISO 2-->
							<tr>	
								<% for(int i=20;i<24;i++){ %>
								<td align="center" <%if(asientos.get(i).getEstado().equals("DISPONIBLE"))estado=Constantes.ASIENTO_DISPONIBLE;
								else if (asientos.get(i).getEstado().equals("NODISPONIBLE"))estado=Constantes.ASIENTO_NODISPONIBLE;
								else if (asientos.get(i).getEstado().equals("RESERVADO"))estado=Constantes.ASIENTO_RESERVADO;
								else if (asientos.get(i).getEstado().equals("VENDIDO"))estado=Constantes.ASIENTO_VENDIDO;
								%> bgcolor="<%=estado %>"><%=(i+1) %></td>							
								<%} %>
							</tr>
							<tr>	
								<% for(int i=24;i<28;i++){ %>
								<td align="center" <%if(asientos.get(i).getEstado().equals("DISPONIBLE"))estado=Constantes.ASIENTO_DISPONIBLE;
								else if (asientos.get(i).getEstado().equals("NODISPONIBLE"))estado=Constantes.ASIENTO_NODISPONIBLE;
								else if (asientos.get(i).getEstado().equals("RESERVADO"))estado=Constantes.ASIENTO_RESERVADO;
								else if (asientos.get(i).getEstado().equals("VENDIDO"))estado=Constantes.ASIENTO_VENDIDO;
								%> bgcolor="<%=estado %>"><%=(i+1) %></td>							
								<%} %>
							</tr>
							<tr>	
								<% for(int i=28;i<32;i++){ %>
								<td align="center" <%if(asientos.get(i).getEstado().equals("DISPONIBLE"))estado=Constantes.ASIENTO_DISPONIBLE;
								else if (asientos.get(i).getEstado().equals("NODISPONIBLE"))estado=Constantes.ASIENTO_NODISPONIBLE;
								else if (asientos.get(i).getEstado().equals("RESERVADO"))estado=Constantes.ASIENTO_RESERVADO;
								else if (asientos.get(i).getEstado().equals("VENDIDO"))estado=Constantes.ASIENTO_VENDIDO;
								%> bgcolor="<%=estado %>"><%=(i+1) %></td>							
								<%} %>
							</tr>
							<tr>	
								<% for(int i=32;i<36;i++){ %>
								<td align="center" <%if(asientos.get(i).getEstado().equals("DISPONIBLE"))estado=Constantes.ASIENTO_DISPONIBLE;
								else if (asientos.get(i).getEstado().equals("NODISPONIBLE"))estado=Constantes.ASIENTO_NODISPONIBLE;
								else if (asientos.get(i).getEstado().equals("RESERVADO"))estado=Constantes.ASIENTO_RESERVADO;
								else if (asientos.get(i).getEstado().equals("VENDIDO"))estado=Constantes.ASIENTO_VENDIDO;
								%> bgcolor="<%=estado %>"><%=(i+1) %></td>							
								<%} %>
							</tr>
							<tr>	
								<% for(int i=36;i<40;i++){ %>
								<td align="center" <%if(asientos.get(i).getEstado().equals("DISPONIBLE"))estado=Constantes.ASIENTO_DISPONIBLE;
								else if (asientos.get(i).getEstado().equals("NODISPONIBLE"))estado=Constantes.ASIENTO_NODISPONIBLE;
								else if (asientos.get(i).getEstado().equals("RESERVADO"))estado=Constantes.ASIENTO_RESERVADO;
								else if (asientos.get(i).getEstado().equals("VENDIDO"))estado=Constantes.ASIENTO_VENDIDO;
								%> bgcolor="<%=estado %>"><%=(i+1) %></td>							
								<%} %>
							</tr>
							<!-- FIN DE FOR PARA PISO 2 -->
							</table>
						</tr>
					</table>
			</td>
			<td colspan="2">
				<!-- DETALLE DE RESERVA -->
				<table cellpadding="3" cellspacing="3">
				<tr>
					<td colspan="5">
						<div class="ui-corner-bottom ui-widget-content">   
		   					<font style="font-family: monospace; font-size: x-large;">Detalle de Reserva</font>
		   				</div>
	   				</td>
	   			</tr>
	   			<tr>
	   				<td width="10%"></td>
					<td width="150px">Código de Viaje: </td>
					<td><input type="text" name="codViaje1" disabled="disabled" value="<%=viaje.getCodViaje() %>"></td>
					<td><input type="hidden" name="codViaje"  value="<%=viaje.getCodViaje() %>"></td>
					<td><input type="hidden" name="viaje"  value="<%=viaje.getId() %>"></td>
				</tr>
	   			<tr>
	   				<td width="10%"></td>
					<td>Origen: </td>
					<td><input type="hidden" name="origen"  value="<%=ruta.getOrigen() %>"><input type="text" name="origen1" disabled="disabled" value="<%=ruta.getOrigen() %>"></td>
					<td width="150px">Destino: </td>
					<td><input type="hidden" name="destino"  value="<%=ruta.getDestino() %>"><input type="text" name="destino1" disabled="disabled" value="<%=ruta.getDestino() %>"></td>
				</tr>
	   			<tr>
	   				<td width="10%"></td>
					<td>Fecha de Salida: </td>
					<td><input type="hidden" name="fecSalida"  value="<%=viaje.getFecSalida() %>"><input type="text" name="fecSalida1" disabled="disabled" value="<%=viaje.getFecSalida() %>"></td>
					<td>Fecha de Llegada: </td>
					<td><input type="hidden" name="fecLlegada"  value="<%=viaje.getFecLlegada() %>"><input type="text" name="fecLlegada1" disabled="disabled" value="<%=viaje.getFecLlegada() %>"></td>
				</tr>
	   			<tr>
	   				<td width="10%"></td>
					<td>Costo S/.: </td>
					<td><input type="hidden" name="costo"  value="<%=viaje.getPrecio() %>"><input type="text" name="costo1" disabled="disabled" value="<%=viaje.getPrecio() %>"></td>
					<td>Duración Hrs.: </td>
					<td><input type="hidden" name="duracion"  value="<%=ruta.getDuracion() %>"><input type="text" name="duracion1" disabled="disabled" value="<%=ruta.getDuracion() %>"></td>
				</tr>
	   			<tr>
	   				<td width="10%"></td>
					<td>Servicio: </td>
					<td colspan="3"><input type="hidden" name="servicio"  value="<%=viaje.getServicio() %>"><input type="text" name="servicio1" size="73" disabled="disabled" value="<%=viaje.getServicio() %>"></td>
				</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<!-- DETALLE DE VEHÍCULO -->
				<table cellpadding="3" cellspacing="3">
				<tr>
					<td colspan="5">
						<div class="ui-corner-bottom ui-widget-content">   
		   					<font style="font-family: monospace; font-size: x-large;">Detalle de Vehículo</font>
		   				</div>
	   				</td>
	   			</tr>
	   			<tr>
	   				<td width="10%"></td>
					<td width="150px">Nº de Asiento: </td>
					<td>
						<select name="asientos">
							<option></option>
							<%for(int i=0;i<40;i++){ %>
							<option><%=(i+1) %></option>
							<%} %>
						</select>
					</td>
					<td></td>
					<td></td>
				</tr>
	   			<tr>
	   				<td width="10%"></td>
					<td>Piso: </td>
					<td><input type="hidden" name="piso"  value="<%=carro.getNumPiso() %>"><input type="text" name="piso1" disabled="disabled" value="<%=carro.getNumPiso() %>"></td>
					<td width="150px">Placa: </td>
					<td><input type="hidden" name="placa" value="<%=carro.getPlaca() %>"><input type="text" name="placa1" disabled="disabled"  value="<%=carro.getPlaca() %>"></td>
				</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="right" width="20%">
				<!-- DETALLE DE LEYENDA -->
				<table border="4" cellpadding="4" cellspacing="4">
					<tr>
						<td width="30%" bgcolor="black"></td>
						<td><font style="font-family: fantasy; font-size:small;">Asiento <br> No Disponible</font></td>
					</tr>
					<tr>
						<td bgcolor="red"></td>
						<td><font style="font-family: fantasy; font-size:small;">Asiento <br> Vendido</font></td>
					</tr>
					<tr>
						<td bgcolor="orange"></td>
						<td><font style="font-family: fantasy; font-size:small;">Asiento <br> Reservado</font></td>
					</tr>
					<tr>
						<td bgcolor="blue"></td>
						<td><font style="font-family: fantasy; font-size:small;">Asiento <br> Disponible</font></td>
					</tr>
				</table>
			</td>
			<td align="center"  width="40%">
				<!-- BOTONES -->
				<input type="submit" value="RESERVAR"> 
				<br>
				<br>
				<input type="submit" value="COMPRAR BOLETO"> 
			</td>
		</tr>
	</table>
</td>
</tr>
</table>
</form>
</div>
</body>
</html>