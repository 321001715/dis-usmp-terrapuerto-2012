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
<script type="text/javascript">
	function validar(){
		if(document.modificar.nombre.value.length == 0){
			alert("Debe llenar el campo Nombre.");
			document.modificar.nombre.focus();
			return false;
		}
		if(document.modificar.fecSalida.value.length == 0){
			alert("Debe llenar el campo Fecha de Salida.");
			document.modificar.fecSalida.focus();
			return false;
		}
		if(document.modificar.fecLlegada.value.length == 0){
			alert("Debe llenar el campo Fecha de Llegada.");
			document.modificar.fecLlegada.focus();
			return false;
		}
		if(document.modificar.horSalida.value.length == 0){
			alert("Debe llenar el campo Hora de salida.");
			document.modificar.horSalida.focus();
			return false;
		}
		if(document.modificar.horLlegada.value.length == 0){
			alert("Debe llenar el campo Hora de llegada.");
			document.modificar.horLlegada.focus();
			return false;
		}
		if(document.modificar.precio.value.length == 0){
			alert("Debe llenar el campo Precio.");
			document.modificar.precio.focus();
			return false;
		}
		if(document.modificar.servicio.value.length == 0){
			alert("Debe llenar el campo Servicio.");
			document.modificar.servicio.focus();
			return false;
		}
		if(document.modificar.idChofer.value.length == 0){
			alert("Debe llenar el campo Chofer.");
			document.modificar.idChofer.focus();
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
<%
	
	Vector<Ruta> listaRutas = (Vector<Ruta>)request.getAttribute("listaRutas");
	Vector<Vehiculo> listaVehiculos = (Vector<Vehiculo>)request.getAttribute("listaVehiculos");
	Vector<Clasificacion> listaClasificaciones = (Vector<Clasificacion>)request.getAttribute("listaClasificaciones");
	Vector<Chofer> listaChoferes = (Vector<Chofer>)request.getAttribute("listaChoferes");
	Viaje viaje = (Viaje)request.getAttribute("viaje");

%>
<div class="ui-widget">
   <h3 class="ui-corner-top ui-widget-header"> 
   	<font style="font-family: monospace; font-size: x-large;">Gestionar Viajes</font>
   </h3>
  	
   <div class="ui-corner-bottom ui-widget-content">   
   		<font style="font-family: monospace; font-size: x-large;">Modificar Viaje</font>
   </div>
<form method="post" action="ServletProveedor" name="modificar" onsubmit="validar()">
	<input type="hidden" name="tipo" value="<%=Constantes.ACCION_MODIFICAR_VIAJE %>">
	<input type="hidden" name="idViaje" value=<%=viaje.getId() %>>
<table border="0">
			<tr><td><br></td></tr>
			<tr>
				<td width="20%"></td>
				<td>Nombre de Viaje:</td>
				<td><input type="text" name="nombre" value=<%=viaje.getNomViaje() %>></td>
			<tr>
				<td></td>
				<td>Fecha Salida:</td>
				<td><input type="text" name="fecSalida" value=<%=viaje.getFecSalida() %> id="fechaSalida" readonly="readonly"></td>
			</tr>
			<tr>
				<td></td>	
				<td>Fecha Llegada:</td>
				<td><input type="text" name="fecLlegada" value=<%=viaje.getFecLlegada() %> id="fechaLlegada" readonly="readonly"></td>
			</tr>
			<tr>
				<td></td>
				<td>Hora Salida:</td>
				<td><input type="text" name="horSalida" value=<%=viaje.getHorSalida() %> id="horaSalida" readonly="readonly"></td>
			</tr>
			<tr>
				<td></td>
				<td>Hora Llegada:</td>
			<td><input type="text" name="horLegada" value=<%=viaje.getHorLlegada() %> id="horaLlegada" readonly="readonly"></td>
			</tr>
			<tr>
				<td></td>
				<td>Precio S/.</td>
				<td><input type="text" name="precio" value=<%=viaje.getPrecio() %>></td>
			</tr>
			<tr>
				<td></td>
				<td>Ruta Asociada:</td>
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
				<td></td>
				<td>Nombre de Servicio:</td>
				<td><input type="text" name="servicio" value=<%=viaje.getServicio() %>></td>
			</tr>
			<tr>
				<td></td>
				<td>Placa de Vehículo:</td>
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
				<td></td>
				<td>DNI de Chofer:</td>
				<td>
				<select name="idChofer">
					<%
						for(Chofer chofer : listaChoferes){
					%>
						<option value=<%=chofer.getId() %>
						<% if(viaje.getIdChofer() == chofer.getId()){ %>selected="selected"<%} %>>
								<%=chofer.getNombres()%>
						</option>
					<%
						}
					%>					
				</select> 
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
				<td></td>
				<td>Estado: </td>
				<td>
					<select name="estado">						
						<option value="<%=Constantes.ESTADO_ACTIVO%>" <%if(viaje.getEstado().equals(Constantes.ESTADO_ACTIVO)){ %>selected="selected" <%} %>><%=Constantes.ESTADO_ACTIVO%></option>
						<option value="<%=Constantes.ESTADO_INHABILITADO%>" <%if(viaje.getEstado().equals(Constantes.ESTADO_INHABILITADO)){ %>selected="selected" <%} %>><%=Constantes.ESTADO_INHABILITADO%></option>
					</select>	
				</td>
			</tr>
			<tr>
				<td colspan="6" align="right">
					<input type="submit" value="Registrar Viaje" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
				</td>
			</tr>			
			<tr>
				<td colspan="6" align="right">
					<input type="submit" value="Modificar Viaje" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
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
								
