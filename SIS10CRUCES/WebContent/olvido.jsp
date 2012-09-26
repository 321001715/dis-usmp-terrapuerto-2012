<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>:: Bienvenido al Sistema 10C+ ::</TITLE>
</head>
<body>
<form action="ServletSeguridad" name="recuperar" method="post" onsubmit="return validar()">
	<input type="hidden" name="tipo" value="<%=Constantes.ACCION_RECUPERAR_CONTRASEÑA%>">
	<input type="hidden" name="destino" value="<%=Constantes.MENU_PRINCIPAL%>">
<table style="width: 100%; height: 100%; background-color: #F8F8F8">
<tr>
<td align="center" valign="middle">
<table border="1" style="position: relative; background-color: FFFFFF; border-color: black; border-width: 5px">
	<tr>
  		<td style="background-color: #F8F8F8" align="center">
			<img alt="" src="<%=request.getContextPath()%>/images/olvido.png">
 		</td>
 	</tr>
 		<td>
 		</td>
 	<tr>
 		<td>
 			<table cellpadding="5px" border="1">
				<tr>
					<td colspan="2" align="center">
						<font style="color: red; font-family: cursive; text-align: center;">
						Para recuperar su contraseña, es necesario que escriba su Usuario.
						</font>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<font style="color: red; font-family: cursive; text-align: center;">
						Se le enviará un correo con su contraseña actual para que luego se comunique <br>
						con un administrador para que autorice el posterior cambio.
						</font>
					</td>
				</tr>
				<tr>
					<td align="center"><b>Usuario: </b><input type="text" name="usuario"></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="Recuperar Contraseña">
					</td>
				</tr> 
			</table>
 		</td>
 	</tr>
</table>
</td>
</tr>
</table>
</form>
</body>
</html>