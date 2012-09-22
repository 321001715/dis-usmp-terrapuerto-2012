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
<form action="ServletSeguridad" name="recuperar" method="post" onsubmit="return validar()">
	<input type="hidden" name="tipo" value="<%=Constantes.ACCION_RECUPERAR_CONTRASEÑA%>">
	<input type="hidden" name="destino" value="<%=Constantes.MENU_PRINCIPAL%>">
		<table cellpadding="5px">
			
		
			<tr>
				<td>Usuario</td>
				<td><input type="text" name="usuario"></td>
				<td></td>
				<td></td>
			</tr>
					<td><input type="submit" value="Recuperar Contraseña"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>