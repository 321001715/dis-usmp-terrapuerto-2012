<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="pe.plazanorte.sisterra.entidades.Proveedor"%>
<%@page import="pe.plazanorte.sisterra.entidades.Usuario"%>


<%@page import="java.util.Vector"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sistema 10 Cruces</title>

</head>
<% 
	Vector<Proveedor> empresa = (Vector<Proveedor>)request.getAttribute("empresa");
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
			
				<table>
					<tr>
						<th>CodEmpresa</th>
						<th>Ruc</th>
						<th>Razon Social</th>
						<th>Razon Comercial</th>
						<th>Direccion</th>
						<th>Telefono</th>
						<th>Estado</th>
						<th colspan="2">Acciones</th>
					</tr> 
					<%	for (int i = 0; i < empresa.size(); i++) {	%>
					<tr>
						<td><%=empresa.get(i).getCodEmpre()%></td>
						<td><%=empresa.get(i).getRuc()%></td>
						<td><%=empresa.get(i).getRazSocial()%></td>
						<td><%=empresa.get(i).getRazCom()%></td>
						<td><%=empresa.get(i).getDirec()%></td>
						<td><%=empresa.get(i).getTel()%></td>
						<td><%=empresa.get(i).getEstado()%></td>
							
						<td><a href="Usuarios?origen=modificar_usuario&id=<%=usuarios.get(i).getId()%>">[Modificar]</a>
						</td>
						<td><a href="Eliminar?usu=<%=usuarios.get(i).getId()%>&origen=gestion_usuarios">[Eliminar]</a>
						</td>
					</tr>
					<%	}	%>

				</table>
                
		</div>
		<div id="sidebar"><%@ include file="sidebar.jsp" %></div>
	</div>
	<div id="footer"><%@ include file="footer.jsp" %></div>
</div>
</body>
</html>
