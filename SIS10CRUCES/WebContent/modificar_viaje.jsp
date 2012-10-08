<%@page import="pe.plazanorte.sisterra.entidades.Viaje"%>
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
<title>Insert title here</title>
</head>
<body>
<%

Vector<Ruta> listaRutas = (Vector<Ruta>)request.getAttribute("listaRutas");
Vector<Vehiculo> listaVehiculos = (Vector<Vehiculo>)request.getAttribute("listaVehiculos");
Vector<Clasificacion> listaClasificaciones = (Vector<Clasificacion>)request.getAttribute("listaClasificaciones");
Vector<Chofer> listaChoferes = (Vector<Chofer>)request.getAttribute("listaChoferes");
Viaje viaje = (Viaje)request.getAttribute("viaje");

%>
<h2>Registrar viaje</h2>

<form method="post" action="ServletProveedor">
	<input type="hidden" name="tipo" value="<%=Constantes.ACCION_MODIFICAR_VIAJE %>">
	<table>
		<tr>
			<td>Nombre del Viaje nuevo</td>
			<td><input type="text" name="nombre" value=<%=viaje.getNomViaje() %>></td>
		</tr>	
		<tr>
			<td>Fecha de salida</td>
			<td><input type="text" name="fecSalida" value=<%=viaje.getFecSalida() %>></td>
		</tr>	
		<tr>
			<td>Fecha de llegada</td>
			<td><input type="text" name="fecLlegada" value=<%=viaje.getFecLlegada() %>></td>
		</tr>	
		<tr>
			<td>Hora de salida</td>
			<td><input type="text" name="horSalida" value=<%=viaje.getHorSalida() %>></td>
		</tr>	
		<tr>
			<td>Hora de llegada</td>
			<td><input type="text" name="horLegada" value=<%=viaje.getHorLlegada() %>></td>
		</tr>	
		<tr>
			<td>Precio</td>
			<td><input type="text" name="precio" value=<%=viaje.getPrecio() %>></td>
		</tr>	
		<tr>
			<td>Ruta asociada</td>
			<td>
				<select name="idRuta">
					<%
						for(Ruta ruta : listaRutas){
					%>
						<option value=<%=ruta.getId() %> <%if(ruta.getId() == viaje.getIdRuta()) {%> selected="selected" <%} %>>
							<%=ruta.getNomRuta() %>
						</option>
					<%
						}
					%>
				</select>
			</td>
		</tr>	
		<tr>
			<td>Nombre de servicio</td>
			<td><input type="text" name="servicio" value=<%=viaje.getServicio() %>></td>
		</tr>
		<tr>
			<td>Veh&iacute;culo</td>
			<td>
				<select name="idVehiculo">
					<%
						for(Vehiculo vehiculo : listaVehiculos){							
					%>
						<option value=<%=vehiculo.getIdVehiculo() %> <%if(vehiculo.getIdVehiculo() == viaje.getIdVehiculo()) {%> selected="selected" <%} %>>
							<%=vehiculo.getPlaca()%>
						</option>
					<%							
						}
					%>
				</select>
			</td>
		</tr>		
		<tr>
			<td>Chofer</td>
			<td>
				<%-- <select name="idChofer">
					<%
						for(Chofer chofer : listaChoferes){
					%>
						<option value=<%=chofer.getId() %>><%=chofer.getNombres() %></option>
					<%
						}
					%>					
				</select> --%>
				<input type="text" name="idChofer" value=<%=viaje.getIdChofer() %>>
			</td>
		</tr>
		<tr>
			<td>Clasificaci&oacute;n</td>
			<td>
			<select name="idClasificacion">
				<%
					for(Clasificacion clasificacion : listaClasificaciones){						
				%>
					<option value=<%=clasificacion.getId() %> 
					<% if(viaje.getIdClasificacion() == clasificacion.getId()){ %>selected="selected"<%} %>>
						<%=clasificacion.getNombre() %>
					</option>
				<%				
					}
				%>
			</select>
			</td>
		</tr>
		<tr>
			<td>Estado</td>
			<td><input type="text" name="estado" value="<%=Constantes.ESTADO_ACTIVO %>" readonly="readonly"></td>
		</tr>	
		<tr>
			<td><input type="submit" value="Registrar Viaje"></td>
			<td><input type="reset" value="Limpiar campos"></td>			
		</tr>
	</table>
</form>

</body>
</html>