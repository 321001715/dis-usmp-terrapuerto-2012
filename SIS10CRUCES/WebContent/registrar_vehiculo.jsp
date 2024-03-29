<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function validar(){
		if(document.regis.codVehiculo.value.length == 0 || document.regis.marca.value.length == 0 || document.regis.modelo.value.length == 0 || document.regis.placa.value.length == 0 || document.regis.numAsientos.value.length == 0|| document.regis.asientosPorPiso.value.length == 0){		
			alert("Debe llenar alguna condici�n para el registro.");
			document.regis.codVehiculo.focus();				
			return false;
		}
		alert("Registro Exitoso.");
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
   <h3 class="ui-corner-top ui-widget-header"> 
   	<font style="font-family: monospace; font-size: x-large;">Gestionar Veh�culo</font>
   </h3>
  	
   <div class="ui-corner-bottom ui-widget-content">   
   		<font style="font-family: monospace; font-size: x-large;">Registrar Veh�culo</font>
   </div>
<form action="ServletProveedor" name="regis" method="post"  onsubmit="return validar()">
	<input type="hidden" name="tipo" value="<%=Constantes.ACCION_REGISTRAR_VEHICULO %>">
	<table border="0">
			<tr><td><br></td></tr>
			<tr>
				<td width="20%"></td>
				<td>C�digo Veh�culo: </td>
				<td><input type="text" name="codVehiculo"></td>
				
				<td>Asientos No Disponibles:</td>
				<td rowspan="6" valign="top">
					<b>Agregar veh�culo para Listar</b>
				</td>
			<tr>
				<td></td>
				<td>Marca: </td>
				<td><input type="text" name="marca"></td>
			</tr>
			<tr>
				<td></td>	
				<td>Modelo: </td>
				<td><input type="text" name="modelo"></td>
			</tr>
			<tr>
				<td></td>
				<td>Placa: </td>
				<td><input type="text" name="placa"></td>
			</tr>
			<tr>	
				<td></td>	
				<td>N�mero de Pisos: </td>
				<td>
					<select name="numPiso">
						<option value="1">1</option>
						<option value="2">2</option>
					</select>
				</td>
			</tr>
			<tr>	
				<td></td>	
				<td>N�mero de Asientos: </td>
				<td><input type="text" name="numAsientos"></td>
			</tr>
			<tr>	
				<td></td>	
				<td>Asientos por Piso: </td>
				<td><input type="text" name="asientosPorPiso"></td>
			</tr>
			<tr>
				<td></td>
				<td>Observaciones: </td>
				<td colspan="3"><textarea rows="3" cols="50" name="obs"></textarea></td>
			</tr>
			<tr>
				<td></td>	
				<td>Estado:</td>
				<td>
					<select name="estado">						
						<option value="<%=Constantes.ESTADO_ACTIVO%>"><%=Constantes.ESTADO_ACTIVO%></option>
						<option value="<%=Constantes.ESTADO_INHABILITADO%>"><%=Constantes.ESTADO_INHABILITADO%></option>
					</select>
				</td>
			</tr>	
			<tr>
				<td colspan="6" align="right">
					<input type="submit" value="Registrar Veh�culo" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
				</td>
			</tr>			
		</table>
</form>
</div>
<br><br><a href="index_proveedor.jsp">
			<img alt="" src="<%=request.getContextPath()%>/images/atras.jpg"> 
		</a> Atr�s...
	&nbsp;
</body>
</html>