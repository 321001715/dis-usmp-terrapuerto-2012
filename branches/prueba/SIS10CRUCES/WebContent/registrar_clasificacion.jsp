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
		if(document.registrar.nombre.value.length == 0){
			alert("Debe llenar el campo nombre.");
			document.registrar.nombre.focus();
			return false;
		}
		if(document.registrar.descripcion.value.length == 0){
			alert("Debe llenar el campo descripcion.");
			document.registrar.descripcion.focus();
			return false;
		}
		
		return true;
	}	
</script>
</head>
<body>

	<h2>Registrar Clasificacion</h2>

	<form action="ServletClasificacion" method="post" name="registrar" onsubmit="validar()">
		<input type="hidden" name="tipo" value="<%=Constantes.ACCION_REGISTRAR_CLASIFICACION%>">
		<table cellspacing="10px">			
			<tr>
				<td colspan="2"><h3>Datos de clasificacion</h3></td>					
			</tr>
			<tr>
				<td>Codigo de Clasificaci&oacute;n</td>
				<td><input type="text" name="idTipoServicio" maxlength="11" readonly="readonly"></td>				
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre"></td>			
			</tr>
			<tr>
				<td>Descripcion</td>
				<td><input type="text" name="descripcion"></td>			
			</tr>
			
			<tr>
				<td><input type="submit" value=Agregar type="submit"></td>
				<td><input type="reset" value="Limpiar campos" type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>