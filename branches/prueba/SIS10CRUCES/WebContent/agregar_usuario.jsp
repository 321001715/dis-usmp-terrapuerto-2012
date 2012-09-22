<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="pe.plazanorte.sisterra.entidades.Persona"%>
<%@page import="java.util.Vector"%>
<%@page import="pe.plazanorte.sisterra.entidades.Perfil"%>
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
<%
	Vector<Perfil> perfiles = (Vector<Perfil>)request.getAttribute("perfiles");
	String busqueda=(String)request.getAttribute("busqueda");
	Persona unapersona=(Persona)request.getAttribute("unapersona");
%>
<div id="container">
	<div id="header">
		<h2>Registrar Usuario</h2>
		
    </div>
    <div id="top-panel">
		<div id="panel"></div>
	</div>
	<div id="wrapper">
		<div id="content" style="height: 210px;">
            <%@include file="buscar_usuario_dni.jsp" %>
            <form action="ServletSeguridad" name="registrar" method="post">
            <input type="hidden" name="tipo" value="registrar">	
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
				<td>Perfil</td>
				<td><select name="sel_perfil">
				<% for (int i=0;i<perfiles.size();i++){ %>
				<option value="<%=perfiles.get(i).getId() %>"> <%=perfiles.get(i).getNombre() %> </option>
				<%} %>
				</select></td>
				<td>Estado</td>
				<td><select name="sel_estado" type="text">
				<option> ACTIVO </option>
				<option> INHABILITADO </option>
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
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<%if(busqueda.equalsIgnoreCase("realizada")){ System.out.print("realizada"); %>
			
			<tr>
				<td>Nombre</td>
				<td><input name="txt_nombre" value="<%=unapersona.getNombre() %>"/></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Apellido Paterno</td>
				<td><input name="txt_apePat" value="<%=unapersona.getApePat() %>"/></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Apellido Materno</td>
				<td><input name="txt_apeMat" value="<%=unapersona.getApeMat() %>"/></td>
				<td></td>
				<td></td>
			</tr>
			<%}else{ %>
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
			<%} %>
			<tr>
				<td><input value="Agregar" type="submit" /></td>
				<td><input type="reset" value="Limpiar campos" type="submit"></td>
				
	
		
			</tr>
		</table>
	</form>
                
		</div>
	
	</div>
	
</div>
</body>
</html>
