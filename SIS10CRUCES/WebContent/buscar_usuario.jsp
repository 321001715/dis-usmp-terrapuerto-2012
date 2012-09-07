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
	if(document.buscar.idProveedor.value.length == 0){
		alert("Debe llenar el campo de búsqueda.");
		document.buscar.idProveedor.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
<h2>Filtros de Busqueda</h2>
<form action="ServletSeguridad" method="post" name="buscar" onsubmit="return validar()">
		<input type="hidden" name="tipo" value="filtroUsuario">
		<input type="hidden" name="destino" value="<%=Constantes.MANTENER_USUARIO%>">
		<table>
			<tr>
				<td>Usuario</td>
				<td><input type="text" name="usuario"></td>
				
				<td>Apellido</td>
				<td><input type="text" name="apellido"></td>
				
				<td rowspan="2" valign="top"><input type="submit" value="Buscar"></td>
			</tr>
			<tr>
				<td>Perfil</td>
				<td><input type="text" name="perfil"></td>
				
				<td>DNI</td>
				<td><input type="text" name="dni"></td>
			</tr>			
		</table>
	</form>

</body>
</html>