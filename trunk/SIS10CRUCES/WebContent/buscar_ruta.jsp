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
		
		if(document.buscar.idVehiculo.value.length == 0 && document.buscar.marca.value.length == 0 && document.buscar.modelo.value.length == 0 && document.buscar.placa.value.length == 0){		
			alert("Debe llenar alguna condición de búsqueda.");
			document.buscar.idVehiculo.focus();				
			return false;
		}else if(isNaN(document.buscar.idVehiculo.value)){		
			alert("Código de ruta no válido.");
			document.buscar.idVehiculo.focus();	
			return false;
		}	
		return true;
	}
</script>
</head>
<body>	
	<form action="ServletProveedor" method="post" name="buscar" onsubmit="return validar()">
		<input type="hidden" name="tipo" value="listar_rutas">
		<input type="hidden" name="des" value="buscarRutas">
		<table>
			<tr>
				<td>Código Ruta</td>
				<td><input type="text" name="codRuta"></td>
				
				<td>Origen</td>
				<td><input type="text" name="origen"></td>
				
				<td rowspan="2" valign="top"><input type="submit" value="Buscar"></td>
			</tr>
			<tr>
				<td>Nombre de Ruta</td>
				<td><input type="text" name="nomRuta"></td>
				
				<td>Destino</td>
				<td><input type="text" name="destino"></td>
			</tr>			
		</table>
	</form>
</body>
</html>