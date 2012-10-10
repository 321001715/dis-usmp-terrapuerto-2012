<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validar(){
		if(document.buscar.idVehiculo.value.length == 0 && document.buscar.marca.value.length == 0 && document.buscar.modelo.value.length == 0 && document.buscar.placa.value.length == 0){		
			alert("Debe llenar alguna condición de búsqueda.");
			document.buscar.idVehiculo.focus();				
			return false;
		}else if(isNaN(document.buscar.idVehiculo.value)){		
			alert("Código de viaje no válido.");
			document.buscar.idVehiculo.focus();	
			return false;
		}	
		return true;
	}
</script>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<link rel="stylesheet" href="css/humanity.datepick.css" type="text/css"/>
<link rel="stylesheet" href="css/jquery.datepick.css" type="text/css"/> 
<link rel="stylesheet" href="jquery/css/dark-hive/jquery-ui-1.7.3.custom.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.6.1.js"></script>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>	
<div class="ui-widget">
   <div class="ui-corner-bottom ui-widget-content">   
   <font style="font-family: monospace; font-size: x-large;">Filtros de Búsqueda</font>
   </div>
&nbsp;   
	<form action="ServletProveedor" method="post" name="buscar" onsubmit="validar()">
		<input type="hidden" name="tipo" value=<%=Constantes.ACCION_FILTRO_VIAJE %>>
		<input type="hidden" name="destino" value=<%=Constantes.GESTIONAR_VIAJE %>>
		<table>
			<tr>
				<td width="20%"></td>
				<td>Código de Ruta: </td>
				<td><input type="text" name="idRuta"></td>
				
				<td>Código de Viaje: </td>
				<td><input type="text" name="idViaje"></td>
			</tr>
			<tr>
				<td></td>
				<td>Clasificación: </td>
				<td><input type="text" name="idClasificacion"></td>
				
				<td>Código Vehículo: </td>
				<td><input type="text" name="idVehiculo"></td>
			</tr>
			<tr>
				<td colspan="6" align="right">
					<input type="submit" value="Buscar" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
				</td>
			</tr>			
		</table>
	</form>
</div>
</body>
</html>