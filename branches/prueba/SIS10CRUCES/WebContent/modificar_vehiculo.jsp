<%@page import="pe.plazanorte.sisterra.entidades.Vehiculo"%>
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
	Vehiculo vehiculo = (Vehiculo)request.getAttribute("vehiculo");
%>

<h2>Registro de veh&iacute;culo</h2>

<form action="ServletProveedor" method="post">
	<input type="hidden" name="tipo" value="<%=Constantes.ACCION_MODIFICAR_VEHICULO %>">
	<table cellpadding="5px" >
		<tr>
			<td>C&oacute;digo</td>
			<td><input type="text" name="idVehiculo" value="<%=vehiculo.getIdVehiculo() %>" readonly="readonly"></td>
		</tr>
		<tr>
			<td>Marca</td>
			<td><input type="text" name="marca" value="<%=vehiculo.getMarca() %>" readonly="readonly"></td>
		</tr>
		<tr>
			<td>Modelo</td>
			<td><input type="text" name="modelo" value="<%=vehiculo.getModelo() %>" readonly="readonly"></td>
		</tr>
		<tr>
			<td>Placa</td>
			<td><input type="text" name="placa" value="<%=vehiculo.getPlaca() %>" readonly="readonly"></td>
		</tr>
		<tr>
			<td>N&uacute;mero de pisos</td>
			<td><input type="text" name="numPiso" value="<%=vehiculo.getNumPiso() %>" readonly="readonly"></td>
		</tr>
		<tr>
			<td>N&uacute;mero de asientos</td>
			<td><input type="text" name="numAsientos" value="<%=vehiculo.getNumAsientos() %>" readonly="readonly"></td>
		</tr>
		<tr>
				<td>Estado del veh&iacute;culo</td>
				<td>
					<select name="estado">						
						<option value="<%=Constantes.ESTADO_ACTIVO%>" <%if(vehiculo.getEstado().equals(Constantes.ESTADO_ACTIVO)){ %>selected="selected" <%} %>><%=Constantes.ESTADO_ACTIVO%></option>
						<option value="<%=Constantes.ESTADO_INHABILITADO%>" <%if(vehiculo.getEstado().equals(Constantes.ESTADO_INHABILITADO)){ %>selected="selected" <%} %>><%=Constantes.ESTADO_INHABILITADO%></option>
					</select>				
				</td>				
			</tr>		
		<tr>
			<td>Observaciones</td>
			<td rowspan="2"><textarea rows="3" cols="16" name="obs"><%=vehiculo.getObs() %></textarea></td>
		</tr>
		<tr>
			<td></td>			
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Modificar vehículo"></td>					
		</tr>
	</table>
</form>

</body>
</html>