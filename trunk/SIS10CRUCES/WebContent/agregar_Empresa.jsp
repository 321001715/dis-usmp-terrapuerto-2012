<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="pe.plazanorte.sisterra.entidades.Usuario"%>

<%
	Usuario admbean = (Usuario)session.getAttribute("admin");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sistema 10 cruces</title>
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/estilos/admin/theme1.css" />
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/estilos/admin/style.css" />
<!--[if IE]>
<link rel="stylesheet" type="text/css" href="css/ie-sucks.css" />
<![endif]-->
</head>
<body>
<div id="container">
	<div id="header">
		<h2>Modulo de Administracion</h2>
		<div id="topmenu">Bienvenido  <%=admbean.getNombres() %> | <a href="<%=application.getContextPath() %>/Admin">Cerrar sesion</a></div>
    </div>
    <div id="top-panel">
		<div id="panel"></div>
	</div>
	<div id="wrapper">
		<div id="content" style="height: 210px;">
            
            <form action="<%=application.getContextPath() %>/Agregar" method="post">
            
		<table>
			<tr>
				<td>Codigo de Empresa</td>
				<td><input></td>
				<td ></td>
				<td></td>
			</tr>
			<tr>
				<td>RUC</td>
				<td><input></td>
				<td><input value= Buscar type="submit"></td>
				<td></td>
			</tr>
			<tr>
				<td>Razon Social</td>
				<td><input></td>
				<td colspan=2></td>
				
			</tr>
			<tr>
				<td>Razon Comercial</td>
				<td><input></td>
				<td colspan='2'></td>
				
			</tr>
			<tr>
				<td>Direccion</td>
				<td><input></td>
				<td>Usuario</td>
				<td><select></select></td>
			</tr>
			<tr>
				<td>Telefono</td>
				<td><input></td>
				<td>Estado</td>
				<td><select></select></td>
			</tr>
			<tr>
				<td><input value=Agregar type="submit"></td>
				<td><input value=Modificar type="submit"></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
                
		</div>
		<div id="sidebar"><%@ include file="sidebar.jsp" %></div>
	</div>
	<div id="footer"><%@ include file="footer.jsp" %></div>
</div>
</body>
</html>
