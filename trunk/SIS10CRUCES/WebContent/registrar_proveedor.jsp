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
		if(document.registrar.ruc.value.length == 0){
			alert("Debe llenar el campo RUC.");
			document.registrar.ruc.focus();
			return false;
		}
		if(document.registrar.razon_social.value.length == 0){
			alert("Debe llenar el campo Raz�n social.");
			document.registrar.razon_social.focus();
			return false;
		}
		if(document.registrar.razon_comercial.value.length == 0){
			alert("Debe llenar el campo Raz�n comercial.");
			document.registrar.razon_comercial.focus();
			return false;
		}
		if(document.registrar.direccion.value.length == 0){
			alert("Debe llenar el campo Direcci�n.");
			document.registrar.telefono.focus();
			return false;
		}
		if(document.registrar.telefono.value.length == 0){
			alert("Debe llenar el campo Tel�fono.");
			document.registrar.telefono.focus();
			return false;
		}
		if(document.registrar.usuario.value.length == 0){
			alert("Debe llenar el campo usuario.");
			document.registrar.usuario.focus();
			return false;
		}
		if(document.registrar.clave.value.length < 5){
			alert("Su clave debe tener m�s de 5 d�gitos.");
			document.registrar.clave.focus();
			return false;
		}
		return true;
	}	
</script>
</head>
<body>

	<h2>Registrar Proveedor</h2>

	<form action="ServletProveedor" method="post" name="registrar" onsubmit="return validar()">
		<input type="hidden" name="tipo" value="<%=Constantes.ACCION_REGISTRAR_PROVEEDOR%>">
		<table cellspacing="10px">			
			<tr>
				<td colspan="2"><h3>Datos del Proveedor</h3></td>					
			</tr>
			<tr>
				<td>RUC</td>
				<td><input type="text" name="ruc" maxlength="11"></td>				
			</tr>
			<tr>
				<td>Razon Social</td>
				<td><input type="text" name="razon_social"></td>			
			</tr>
			<tr>
				<td>Razon Comercial</td>
				<td><input type="text" name="razon_comercial"></td>			
			</tr>
			<tr>
				<td>Direccion</td>
				<td><input type="text" name="direccion"></td>				
			</tr>
			<tr>
				<td>Telefono</td>
				<td><input type="text" name="telefono" maxlength="9"></td>				
			</tr>
			<tr>
				<td colspan="2"><h3>Datos del Proveedor</h3></td>					
			</tr>
			<tr>
				<td>Id de Usuario</td>	
				<td><input type="text" name="idUsuario"></td>					
			</tr>			
			<tr>
				<td><input type="submit" value=Agregar type="submit"></td>
				<td><input type="reset" value="Limpiar campos" type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>