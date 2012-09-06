<%@page import="pe.plazanorte.sisterra.entidades.Clasificacion"%>
<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@page import="pe.plazanorte.sisterra.entidades.Proveedor"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<body>
<%
	Vector<Clasificacion> clasificaciones= (Vector<Clasificacion>)request.getAttribute("clasificaciones");
%>
 
<%
	if(clasificaciones.size() != 0){
%>

<table border="1" cellspacing="1px" cellpadding="5px">
	<tr>
		<th>C&oacute;digo</th>
		<th>Descripcion</th>
		<th>Acci&oacute;n</th>
	</tr>
	<%for(int i=0; i<clasificaciones.size(); i++){ %>
	<tr>
		<td align="right"><%=clasificaciones.get(i).getId() %></td>
		<td><%=clasificaciones.get(i).getDescripcion() %></td>
		<td><a href="ServletClasificacion?tipo=<%=Constantes.ACCION_CONSULTAR_CLASIFICACION %>&destino=<%=Constantes.MODIFICAR_CLASIFICACION%>&id=<%=clasificaciones.get(i).getId()%>">Modificar</a></td>		
	</tr>
	<%} %>
</table>
<%}else{%>
<font color="red">No se encontraron resultados para la consulta.</font>
<%} %>
</body>
