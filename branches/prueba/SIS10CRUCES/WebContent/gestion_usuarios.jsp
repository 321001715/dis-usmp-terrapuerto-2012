<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="pe.plazanorte.sisterra.entidades.Usuario"%>


<%@page import="java.util.Vector"%>
<%
	Usuario admbean = (Usuario)session.getAttribute("admin");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sistema 10 Cruces</title>

</head>
<% 
	Vector<Usuario> usuarios = (Vector<Usuario>)request.getAttribute("usuarios");
	String mensaje = (String)request.getAttribute("mensaje");
%>
<body>
<div id="container">
	<div id="header">
		<h2>Modulo de Administracion</h2>
		
    </div>
    <div id="top-panel">
		<div id="panel"></div>
	</div>
	<div id="wrapper">
		<div id="content" style="height: 210px;">
				<a href="<%=application.getContextPath() %>/agregar_usuario.jsp">Agregar Usuario</a>
				<table>
					<tr>
						<th>Nombres</th>
						<th>ApellidoPaterno</th>
						<th>ApellidoMaterno</th>
						<th>DNI</th>
						<th>Telefono</th>
						<th>Sexo</th>
						<th>Estado</th>
						<!-- CORREGIR ESTA WEBADA -->
						<th colspan="2">Acciones</th>
					</tr>
					<%	for (int i = 0; i < usuarios.size(); i++) {	%>
					<tr>
						<td><%=usuarios.get(i).getNombres()%></td>
						<td><%=usuarios.get(i).getApePat()%></td>
						<td><%=usuarios.get(i).getApeMat()%></td>
						<td><%=usuarios.get(i).getDni()%></td>
						<td><%=usuarios.get(i).getTel()%></td>
						<td><%=usuarios.get(i).getSexo()%></td>
						<td><%=usuarios.get(i).getEstado()%></td>
						<td><a href="Usuarios?origen=modificar_usuario&id=<%=usuarios.get(i).getId()%>">[Modificar]</a>
						</td>
						<td><a href="Eliminar?usu=<%=usuarios.get(i).getId()%>&origen=gestion_usuarios">[Eliminar]</a>
						</td>
					</tr>
					<%	}	%>

				</table>
                
		</div>
		
	</div>
	<div id="footer"><%@ include file="footer.jsp" %></div>
</div>
</body>
</html>
