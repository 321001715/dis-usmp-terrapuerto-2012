<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="pe.plazanorte.sisterra.entidades.Usuario"%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sistema 10 Cruces</title>
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/estilos/admin/theme1.css" />
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/estilos/admin/style.css" />
<!--[if IE]>
<link rel="stylesheet" type="text/css" href="css/ie-sucks.css" />
<![endif]-->
</head>
<body>
<div id="container">
	<div id="header">
		<h2>Registrar Usuario</h2>
		
    </div>
    <div id="top-panel">
		<div id="panel"></div>
	</div>
	<div id="wrapper">
		<div id="content" style="height: 210px;">
            
            <form action="Agregar" method="post">
            	
		<table>
			<tr>
				
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Usuario:</td>
				<td><input name="txt_usuario"/></td>
				<td>Pass:</td>
				<td><input name="txt_pass"/></td>
			</tr>
			<tr>
				<td>Numero de Documento</td>
				<td><input name="txt_dni" /></td>
				<td><input type="submit" style="width: 56px;" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Perfil</td>
				<td><select></select></td>
				<td>Estado</td>
				<td><select name="sel_estado" type="text">
				<option> Habilitado </option>
				<option> Inhabilitado </option>
				</select>
				</td>
			</tr>
			<tr>
				<td><b><u>Detalle de Persona</u></b></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input name="txt_nombre"/></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Apellido Paterno</td>
				<td><input name="txt_apePat"/></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Apellido Materno</td>
				<td><input name="txt_apeMat"/></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td><input value=Agregar type="submit"></td>
				<td><input value="Modificar" type="submit"></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
                
		</div>
	
	</div>
	<div id="footer"><%@ include file="footer.jsp" %></div>
</div>
</body>
</html>
