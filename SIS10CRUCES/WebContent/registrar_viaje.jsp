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

<h2>Registrar viaje</h2>

<form method="post" action="ServletProveedor">
	<table>
		<tr>
			<td>Nombre del Viaje nuevo</td>
			<td><input type="text" name="nombre"></td>
		</tr>	
		<tr>
			<td>Fecha de salida</td>
			<td><input type="text" name="fecSalida"></td>
		</tr>	
		<tr>
			<td>Fecha de llegada</td>
			<td><input type="text" name="fecLlegada"></td>
		</tr>	
		<tr>
			<td>Hora de salida</td>
			<td><input type="text" name="horSalida"></td>
		</tr>	
		<tr>
			<td>Hora de llegada</td>
			<td><input type="text" name="horLegada"></td>
		</tr>	
		<tr>
			<td>Precio</td>
			<td><input type="text" name="precio"></td>
		</tr>	
		<tr>
			<td>Ruta asociada</td>
			<td><input type="text" name="ruta"></td>
		</tr>	
		<tr>
			<td>Nombre de servicio</td>
			<td><input type="text" name="servicio"></td>
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