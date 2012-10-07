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

<form>
	<table>
		<tr>
			<td>Nombre de la Ruta nueva</td>
			<td><input type="text" name="nombre"></td>
		</tr>	
		<tr>
			<td>Origen</td>
			<td><input type="text" name="origen"></td>
		</tr>	
		<tr>
			<td>Destino</td>
			<td><input type="text" name="destino"></td>
		</tr>	
		<tr>
			<td>Distancia (km)</td>
			<td><input type="text" name="distancia"></td>
		</tr>	
		<tr>
			<td>Duración aproximada</td>
			<td><input type="text" name="duracion"></td>
		</tr>	
		<tr>
			<td>Proveedor</td>
			<td><input type="text" name="idProveedor"></td>
		</tr>	
		<tr>
			<td>Ubigeo</td>
			<td><input type="text" name="idUbigeo"></td>
		</tr>	
		<tr>
			<td>Estado</td>
			<td><input type="text" name="estado" value="<%=Constantes.ESTADO_ACTIVO %>" readonly="readonly"></td>
		</tr>	
		<tr>
			<td><input type="submit" value="Registrar Ruta"></td>
			<td><input type="reset" value="Limpiar campos"></td>			
		</tr>
	</table>
</form>

</body>
</html>