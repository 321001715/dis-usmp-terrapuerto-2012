<%@page import="pe.plazanorte.sisterra.entidades.Ruta"%>
<%@page import="pe.plazanorte.sisterra.entidades.Viaje"%>
<%@page import="java.util.Vector"%>
<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="jquery/css/dark-hive/jquery-ui-1.7.3.custom.css" type="text/css"/>
<script type="text/javascript" src="jquery/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="jquery/js/jquery-ui-1.7.3.custom.min.js"></script>
</head>
<%

Vector<Ruta> rutas= (Vector<Ruta>)request.getAttribute("rutas");

%>
<body>	
<script>
$(document).ready(function(){
	   $("#fecha").datepicker({
	      showOn: 'both',
	      buttonImage: 'jquery/css/dark-hive/images/calendar.png',
	      buttonImageOnly: true,
	      changeYear: true,
	      numberOfMonths: 1	,
	   });
	   $('#fecha').datepicker('option', {dateFormat: 'dd/mm/yy'});
});
</script>
<div class="ui-widget">
   <div class="ui-corner-bottom ui-widget-content">   
   <font style="font-family: monospace; font-size: x-large;">Filtros de Búsqueda</font>
   </div>
&nbsp;   
	<form action="ServletBoletaje" method="post" name="buscar" onsubmit="validar()">
		<input type="hidden" name="tipo" value="<%=Constantes.ACCION_CONSULTAR_VIAJE %>">
		
		<table>
			<tr>
				<td width="20%"></td>
				<td>Empresa: </td>
				<td><input type="text" name="empresa"></td>
				
				<td>Fecha de Salida: </td>
				<td><input name="fechasalida" id="fecha" readonly="readonly"></td>
			</tr>
			<tr>
				<td></td>
				<td>Origen: </td>
				<td><select name="origen">
				<option value="">Origen</option>
				<% for(int i=0;i<rutas.size();i++){ %>
				<option value="<%=rutas.get(i).getOrigen() %>"><%=rutas.get(i).getOrigen() %></option>
				<%} %>
				</select>
				</td>
				
				<td>Destino: </td>
				<td><select name="destino">
				<option value="">Destino</option>
				<% for(int i=0;i<rutas.size();i++){ %>
				<option value="<%=rutas.get(i).getDestino() %>"><%=rutas.get(i).getDestino() %></option>
				<%} %>
				</select>
				</td>
			</tr>
			<tr>
				<td colspan="5" align="right">
					<input type="submit" value="CONSULTAR VIAJE" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
				</td>
			</tr>			
		</table>
	</form>
</div>
</body>
</html>