<%@page import="pe.plazanorte.sisterra.entidades.Vehiculo"%>
<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@page import="java.util.Vector"%>
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
<body>

<%
	Vehiculo vehiculo = (Vehiculo)request.getAttribute("vehiculo");
%>
<div class="ui-widget">
   <h3 class="ui-corner-top ui-widget-header"> 
   	<font style="font-family: monospace; font-size: x-large;">Gestionar Vehículo</font>
   </h3>
  	
   <div class="ui-corner-bottom ui-widget-content">   
   		<font style="font-family: monospace; font-size: x-large;">Registrar Vehículo</font>
   </div>
<form action="ServletProveedor" method="post">
	<input type="hidden" name="tipo" value="<%=Constantes.ACCION_MODIFICAR_VEHICULO %>">
<table border="0">
			<tr><td><br></td></tr>
			<tr>
				<td width="20%"></td>
				<td>Código Vehículo: </td>
				<td><input type="text" name="codVehiculo" value="<%=vehiculo.getCodVehiculo()%>" ></td>
				
				<td>Asientos No Disponibles:</td>
<%
if(vehiculo.getNumAsientos() == 0){
%>
				<td rowspan="6" valign="top">
					<b>Registrar Número de Asientos</b>
				</td>
<%
}else{
// AQUI IRIA TU MIERDA
%>
				<td rowspan="6">
					<select name=asientosNoDisponibles multiple="multiple" size="15">
<% 
	for(int i=1; i<=vehiculo.getNumAsientos(); i++){
%>
						<option value="<%=i%>" 
						<%
							if(vehiculo.getAsientosNoDisponibles().equals(i)){
						%>
							selected="selected"
						<%
							}
						%>	
							><%=i%></option>
<%
	}
}
%>
					</select>
				</td>
			<tr>
				<td></td>
				<td>Marca: </td>
				<td><input type="text" name="marca" value="<%=vehiculo.getMarca() %>"></td>
			</tr>
			<tr>
				<td></td>	
				<td>Modelo: </td>
				<td><input type="text" name="modelo" value="<%=vehiculo.getModelo() %>"></td>
			</tr>
			<tr>
				<td></td>
				<td>Placa: </td>
				<td><input type="text" name="placa" value="<%=vehiculo.getPlaca() %>"></td>
			</tr>
			<tr>	
				<td></td>	
				<td>Número de Pisos: </td>
				<td>
					<select name="numPiso">
						<option value="1" <%if(vehiculo.getNumPiso()==1){ %>selected="selected" <%}%>>1</option>
						<option value="2" <%if(vehiculo.getNumPiso()==2){ %>selected="selected" <%}%>>2</option>
					</select>
				</td>
			</tr>
			<tr>	
				<td></td>	
				<td>Número de Asientos: </td>
				<td><input type="text" name="numAsientos" value="<%=vehiculo.getNumAsientos() %>"></td>
			</tr>
			<tr>	
				<td></td>	
				<td>Asientos por Piso: </td>
				<td><input type="text" name="asientosPorPiso" value="<%=vehiculo.getAsientosPorPiso() %>" ></td>
			</tr>
			<tr>
				<td></td>
				<td>Observaciones: </td>
				<td colspan="3"><textarea rows="3" cols="50" name="obs"><%=vehiculo.getObs()%></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td>Estado:</td>
				<td>
						<select name="estado">						
							<option value="<%=Constantes.ESTADO_ACTIVO%>" <%if(vehiculo.getEstado().equals(Constantes.ESTADO_ACTIVO)){ %>selected="selected" <%} %>><%=Constantes.ESTADO_ACTIVO%></option>
							<option value="<%=Constantes.ESTADO_INHABILITADO%>" <%if(vehiculo.getEstado().equals(Constantes.ESTADO_INHABILITADO)){ %>selected="selected" <%} %>><%=Constantes.ESTADO_INHABILITADO%></option>
						</select>
				</td>
			</tr>		
			<tr>
				<td colspan="6" align="right">
					<input type="submit" value="Modificar Vehículo" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
				</td>
			</tr>
		</table>
</form>
</div>
<br><br><a href="index_proveedor.jsp">
			<img alt="" src="<%=request.getContextPath()%>/images/atras.jpg"> 
		</a> Atrás...
	&nbsp;
</body>
</html>
								
