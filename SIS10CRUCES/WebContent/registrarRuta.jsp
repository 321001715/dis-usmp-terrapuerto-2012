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

<h2>Registro de Ruta</h2>

<form action="ServletProveedor" method="post">
	<input type="hidden" name="tipo" value="<%=Constantes.ACCION_REGISTRAR_RUTA %>">
		<table cellpadding="5px">
			<tr>
				<td><b>Detalle Ruta</b></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Codigo de Ruta</td>
				<td><input type="text" name="codRuta"></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Nombre Ruta</td>
				<td><input type="text" name="nomRuta"></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Origen</td>
				<td><input type="text" name="origen"></td>
				<td>Destino</td>
				<td><input type="text" name="destino"></td>
			</tr>
			<tr>
				<td>Km</td>
				<td><input type="text" name="km"></td>
				<td>Duracion</td>
				<td><input  type="text" name="duracion">Hrs</td>
			</tr>
			
			<tr>
				<td><b>Detalle de Cuenta</b></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Estado</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		
			<tr>
				<td><input type="submit" value="Registrar ruta"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>

</body>
</html>