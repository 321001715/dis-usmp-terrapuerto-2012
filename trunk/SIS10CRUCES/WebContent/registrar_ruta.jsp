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
		if(document.regis.duracion.value.length == 0 || document.regis.km.value.length == 0 || document.regis.destino.value.length == 0 || document.regis.nomRuta.value.length == 0 || document.regis.origen.value.length == 0){		
			alert("Debe llenar alguna condición para el registro.");
			document.regis.nomRuta.focus();				
			return false;
		}
		return true;
	}
</script>

</head>
<body>

<h2>Registro de Ruta</h2>

<form action="ServletProveedor" name="regis" method="post" onsubmit="return validar()">
	<input type="hidden" name="tipo" value="registrarRuta">
		<table cellpadding="5px">
			<tr>
				<td><b>Detalle Ruta</b></td>
				<td></td>
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
				<td><input type="submit" value="Registrar ruta"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>

</body>
</html>