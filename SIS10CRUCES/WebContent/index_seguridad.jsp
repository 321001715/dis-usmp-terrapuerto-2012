<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema 10 cruces </title>
</head>
<body bgcolor="#FFFFCC">
<table border="0" width="100%">
	<tr>
		<td width="20%"></td>
		<td>
			<font style="font-family: monospace; font-size: x-large;">
  			<br> <b>Módulo de Seguridad</b> <br><br>
  			</font>
				<ul>
					<li><a href="<%=application.getContextPath() %>/ServletClasificacion?tipo=<%=Constantes.ACCION_LISTAR_CLASIFICACION %>&destino=<%=Constantes.MANTENER_CLASIFICACION%>">Gesti&oacute;n de Clasificación</a></li>
					<br>
					<li><a href="<%=application.getContextPath() %>/ServletProveedor?tipo=<%=Constantes.ACCION_LISTAR_PROVEEDOR %>&destino=<%=Constantes.MANTENER_PROVEEDOR%>">Gesti&oacute;n de Proveedores</a></li>
		            <br>
		            <li><a href="<%=application.getContextPath() %>/ServletSeguridad?tipo=listar&origen=<%=Constantes.MENU_PRINCIPAL%>">Gesti&oacute;n de Usuarios</a></li>
					<br>
					<li><a href="<%=application.getContextPath() %>/ServletSeguridad?tipo=listarPerfiles&origen=<%=Constantes.MENU_PRINCIPAL%>">Gesti&oacute;n de Perfiles</a></li>
					<br>
		        </ul>
		</td>
		<td></td>
	</tr>	
	<tr>
		<td colspan="2"></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/seguridad.png">
		</td>
	</tr>     
</table>        
</body>
</html>