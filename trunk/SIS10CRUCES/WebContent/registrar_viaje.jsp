<%@page import="java.util.Vector"%>
<%@page import="pe.plazanorte.sisterra.entidades.Chofer"%>
<%@page import="pe.plazanorte.sisterra.entidades.Clasificacion"%>
<%@page import="pe.plazanorte.sisterra.entidades.Vehiculo"%>
<%@page import="pe.plazanorte.sisterra.entidades.Ruta"%>
<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
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

Vector<Ruta> listaRutas = (Vector<Ruta>)request.getAttribute("listaRutas");
Vector<Vehiculo> listaVehiculos = (Vector<Vehiculo>)request.getAttribute("listaVehiculos");
Vector<Clasificacion> listaClasificaciones = (Vector<Clasificacion>)request.getAttribute("listaClasificaciones");
Vector<Chofer> listaChoferes = (Vector<Chofer>)request.getAttribute("listaChoferes");

%>
<div class="ui-widget">
   <h3 class="ui-corner-top ui-widget-header"> 
   	<font style="font-family: monospace; font-size: x-large;">Gestionar Viaje</font>
   </h3>
  	
   <div class="ui-corner-bottom ui-widget-content">   
   		<font style="font-family: monospace; font-size: x-large;">Registrar Viaje</font>
   </div>

<form method="post" action="ServletProveedor">
	<input type="hidden" name="tipo" value="<%=Constantes.ACCION_REGISTRAR_VIAJE %>">
	<table border="0">
			<tr><td><br></td></tr>
			<tr>
				<td width="20%"></td>
				<td>Nombre de Viaje:</td>
				<td><input type="text" name="nombre"></td>
			<tr>
				<td></td>
				<td>Fecha Salida:</td>
				<td><input type="text" name="fecSalida"></td>
			</tr>
			<tr>
				<td></td>	
				<td>Fecha Llegada:</td>
				<td><input type="text" name="fecLlegada"></td>
			</tr>
			<tr>
				<td></td>
				<td>Hora Salida:</td>
				<td><input type="text" name="horSalida"></td>
			</tr>
			<tr>
				<td></td>
				<td>Hora Llegada:</td>
			<td><input type="text" name="horLegada"></td>
			</tr>
			<tr>
				<td></td>
				<td>Hora Salida:</td>
				<td><input type="text" name="horSalida"></td>
			</tr>
			<tr>
				<td></td>
				<td>Precio S/.</td>
				<td><input type="text" name="precio"></td>
			</tr>
			<tr>
				<td></td>
				<td>Ruta Asociada:</td>
				<td>
					<select name="idRuta">
						<%
							for(Ruta ruta : listaRutas){
						%>
							<option value=<%=ruta.getId() %>><%=ruta.getNomRuta() %></option>
						<%
							}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>Nombre de Servicio:</td>
				<td><input type="text" name="servicio"></td>
			</tr>
			<tr>
				<td></td>
				<td>Placa de Vehículo:</td>
				<td>
					<select name="idVehiculo">
						<%
							for(Vehiculo vehiculo : listaVehiculos){							
						%>
							<option value=<%=vehiculo.getIdVehiculo() %>><%=vehiculo.getPlaca()%></option>
						<%							
							}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>DNI de Chofer:</td>
				<td>
				<select name="idChofer">
					<%
						for(Chofer chofer : listaChoferes){
					%>
						<option value=<%=chofer.getId() %>><%=chofer.getNombres() %></option>
					<%
						}
					%>					
				</select> 
				<input type="text" name="idChofer">
			</td>
			</tr>
			<tr>
				<td></td>
				<td>Clasificación:</td>
				<td>
					<select name="idClasificacion">
						<%
							for(Clasificacion clasificacion : listaClasificaciones){						
						%>
							<option value=<%=clasificacion.getId() %>><%=clasificacion.getNombre() %></option>
						<%				
							}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>Estado: </td>
				<td><input type="text" name="estado" value="<%=Constantes.ESTADO_ACTIVO %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td colspan="6" align="right">
					<input type="submit" value="Registrar Viaje" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
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