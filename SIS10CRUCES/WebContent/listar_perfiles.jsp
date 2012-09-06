<%@page import="pe.plazanorte.sisterra.entidades.Perfil"%>
<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@page import="pe.plazanorte.sisterra.entidades.Proveedor"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<body>
<%
	Vector<Perfil> perfiles = (Vector<Perfil>)request.getAttribute("perfiles");
%>
 
<%
	if(perfiles.size() != 0){
%>

<table border="1" cellspacing="1px" cellpadding="5px">
	<tr>
		<th>Codigo</th>
		<th>Nombre</th>
		<th>Descripcion</th>
		<th>Accion</th>
	</tr>
	<%for(int i=0; i<perfiles.size(); i++){ %>
	<tr>
		<td align="right"><%=perfiles.get(i).getId() %></td>
		<td><%=perfiles.get(i).getNombre() %></td>
		<td><%=perfiles.get(i).getDescripcion() %></td>
		
		<td><a href="ServletSeguridad?tipo=<%=Constantes.ACCION_CONSULTAR_PERFIL %>&destino=<%=Constantes.MODIFICAR_PERFIL %>&idPerfil=<%=perfiles.get(i).getId()%>">Modificar</a></td>		
	</tr>
	<%} %>
</table>
<%}else{%>
<font color="red">No se encontraron resultados para la consulta.</font>
<%} %>
</body>