<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema 10 cruces </title>
</head>
<body bgcolor="#FFCC66">
<table border="0" width="100%">
	<tr>
		<td width="20%"></td>
		<td>
			<font style="font-family: monospace; font-size: x-large;">
  			<br> <b>Módulo de Proveedor</b> <br><br>
  			</font>
				<ul>
					<li><a href="<%=application.getContextPath() %>/ServletProveedor?tipo=<%=Constantes.ACCION_LISTAR_VEHICULO %>&destino=<%=Constantes.GESTIONAR_VEHICULO%>">Gestione sus Vehículos</a></li>
					<br>
		            <li><a href="<%=application.getContextPath() %>/ServletProveedor?tipo=<%=Constantes.ACCION_LISTAR_RUTA %>&destino=<%=Constantes.GESTIONAR_RUTA%>">Gestione sus Rutas</a></li>
		        </ul>
		</td>
		<td></td>
	</tr>	
	<tr>
		<td colspan="2"></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/proveedor.png">
		</td>
	</tr>     
</table>        
</body>
</html>