<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@page import="pe.plazanorte.sisterra.entidades.Ruta"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<body>
<%
	Vector<Ruta> ruta = (Vector<Ruta>)request.getAttribute("ruta");
%>
 
<%
	if(ruta.size() != 0){
%>

	<table border="1" cellspacing="1px" cellpadding="5px">
		<tr>
			<th>Codigo</th>
			<th>Nombre de Ruta</th>
			<th>Origen</th>
			<th>Destino</th>
			<th>Duracion</th>
			<th>Estado</th>
			<th>Accion</th>
		</tr>
		<%for(int i=0; i<ruta.size(); i++){ %>
		<tr>
			<td align="right"><%=ruta.get(i).getId() %></td>
			<td><%=ruta.get(i).getNomRuta() %></td>
			<td><%=ruta.get(i).getOrigen() %></td>
			<td><%=ruta.get(i).getDestino()%></td>
			<td align="center"><%=ruta.get(i).getCodRuta()%></td>
			<td><%=ruta.get(i).getDestino()%></td>
			<td> <a href="Usuarios?origen=modificar_usuario&id=<%=ruta.get(i).getId()%>">[Modificar]   </a>
						
					<a href="Eliminar?usu=<%=ruta.get(i).getId()%>&origen=gestion_usuarios">[Eliminar]</a>
						</td>
		</tr>
		<%} %>
	</table>
	<%}else{%>
<font color="red">No se encontraron resultados para la consulta.</font>
<%} %>
</body>
