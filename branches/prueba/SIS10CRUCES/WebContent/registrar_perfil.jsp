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
			alert("Debe llenar el campo Nombre.");
			document.registrar.nombre.focus();
			return false;
		}
		if(document.registrar.descripcion.value.length == 0){
			alert("Debe llenar el campo Descripcion.");
			document.registrar.descripcion.focus();
			return false;
		}
		
		return true;
	}	
</script>
</head>
<body>

	<h2>Registrar Perfil</h2>

	<form action="ServletSeguridad" method="post" name="registrarperfil" onsubmit="return validar()">
		<input type="hidden" name="tipo" value="registrarPerfil">
		<table cellspacing="10px">			
			<tr>
				<td colspan="2"><h3>Detalle del Perfil</h3></td>					
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre" maxlength="20"></td>				
			</tr>
			<tr>
				<td>Descripcion</td>
				<td><input type="text" name="descripcion"></td>			
			</tr>
	
			
			
			<tr>
					
									
			</tr>
			<tr>
				<td><input type="submit" value=Agregar type="submit"></td>
				<td><input type="reset" value="Limpiar campos" type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>