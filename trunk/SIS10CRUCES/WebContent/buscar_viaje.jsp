<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="jquery/css/dark-hive/jquery-ui-1.7.3.custom.css" type="text/css"/>
<script type="text/javascript" src="jquery/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="jquery/js/jquery-ui-1.7.3.custom.min.js"></script>
</head>
<body>	
<script>
$(document).ready(function(){
	   $("#a").datepicker({
	      showOn: 'both',
	      buttonImage: 'jquery/css/dark-hive/images/calendar.png',
	      buttonImageOnly: true,
	      changeYear: true,
	      numberOfMonths: 1	,
	   });
	   $('#a').datepicker('option', {dateFormat: 'dd/mm/yy'});
});
</script>
<div class="ui-widget">
   <div class="ui-corner-bottom ui-widget-content">   
   <font style="font-family: monospace; font-size: x-large;">Filtros de Búsqueda</font>
   </div>
&nbsp;   
	<form action="" method="post" name="buscar" onsubmit="validar()">
		<input type="hidden" name="tipo" value="listar_viajes">
		<input type="hidden" name="des" value="buscarViajes">
		<table>
			<tr>
				<td width="20%"></td>
				<td>Empresa: </td>
				<td><input type="text" name=""></td>
				
				<td>Fecha de Salida: </td>
				<td><input name="" id="a"></td>
			</tr>
			<tr>
				<td></td>
				<td>Origen: </td>
				<td><input type="text" name=""></td>
				
				<td>Destino: </td>
				<td><input type="text" name=""></td>
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