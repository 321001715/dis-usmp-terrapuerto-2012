<%@page import="pe.plazanorte.sisterra.entidades.Usuario"%>
<%@page import="pe.plazanorte.sisterra.entidades.Proveedor"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Vector<Usuario> usuarios = (Vector<Usuario>)request.getAttribute("proveedores");
%>

<%
	if(usuarios.size() != 0){
%>
<table border="1" cellspacing="0" cellpadding="0">
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
<%}else{%>
<font color="red">No se encontraron resultados para la consulta.</font>
<%} %>
</body>
</html>