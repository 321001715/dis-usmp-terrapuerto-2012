<%@page import="pe.plazanorte.sisterra.entidades.Viaje"%>
<%@page import="pe.plazanorte.sisterra.entidades.Clasificacion"%>
<%@page import="pe.plazanorte.sisterra.entidades.Vehiculo"%>
<%@page import="pe.plazanorte.sisterra.entidades.Ruta"%>
<%@page import="java.util.Vector"%>
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
		if(document.buscar.idVehiculo.selectedIndex==0 && document.buscar.idRuta.selectedIndex==0 && document.buscar.idClasificacion.selectedIndex==0 && document.buscar.idViaje.selectedIndex==0){		
			window.alert("Debe llenar alguna condición de búsqueda.");						
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
	Vector<Viaje> listaViajes = (Vector<Viaje>)request.getAttribute("listaViajes");
%>	
<div class="ui-widget">
   <div class="ui-corner-bottom ui-widget-content">   
   <font style="font-family: monospace; font-size: x-large;">Filtros de Búsqueda</font>
   </div>
&nbsp;   
	<form action="ServletProveedor" method="post" name="buscar" onsubmit="return validar()">
		<input type="hidden" name="tipo" value=<%=Constantes.ACCION_FILTRO_VIAJE %>>
		<input type="hidden" name="destino" value=<%=Constantes.GESTIONAR_VIAJE %>>
		<table>
			<tr>
				<td width="20%"></td>
				<td>Código de Ruta: </td>
				<td>
				<select name="idRuta">
						<option value="0" >Seleccione</option>
						<%
							for(Ruta ruta : listaRutas){
						%>
							<option value=<%=ruta.getId() %>><%=ruta.getNomRuta() %></option>
						<%
							}
						%>
					</select>
				</td>
				
				<td>Código de Viaje: </td>
				<td>
				<select name="idViaje">
						<option value="0">Seleccione</option>
						<%
							for(Viaje viaje : listaViajes){
						%>
							<option value=<%=viaje.getId() %>><%=viaje.getNomViaje()%></option>
						<%
							}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>Clasificación: </td>
				<td>
				<select name="idClasificacion">
						<option value="0">Seleccione</option>
						<%
							for(Clasificacion clasificacion : listaClasificaciones){						
						%>
							<option value=<%=clasificacion.getId() %>><%=clasificacion.getNombre() %></option>
						<%				
							}
						%>
					</select>
				</td>
				
				<td>Código Vehículo: </td>
				<td>
				<select name="idVehiculo">
						<option  value="0">Seleccione</option>
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
				<td colspan="6" align="right">
					<input type="submit" value="Buscar" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
				</td>
			</tr>			
		</table>
	</form>
</div>
</body>
</html>