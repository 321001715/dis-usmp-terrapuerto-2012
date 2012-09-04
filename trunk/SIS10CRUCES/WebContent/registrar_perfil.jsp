<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Registrar Perfil</h2>

	<form action="ServletProveedor" method="post" name="registrar" onsubmit="return validar()">
		<input type="hidden" name="tipo" value="registrar">
		<table cellspacing="10px">			
			
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
				
								
			</tr>
			<tr>
									
			</tr>
			<tr>
				</tr><tr>	
									
			</tr>
			<tr>
				<td><input type="submit" value=Agregar type="submit"></td>
				<td><input type="reset" value="Limpiar campos" type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>